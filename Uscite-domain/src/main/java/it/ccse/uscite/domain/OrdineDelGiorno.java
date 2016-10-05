package it.ccse.uscite.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.envers.Audited;

import it.ccse.uscite.domain.PraticaErogazione.StatoPratica;
import it.ccse.uscite.domain.ProcessoErogazione.StatoLavorazioneContabile;
import it.ccse.uscite.domain.ProcessoErogazione.StatoProcesso;
import it.ccse.uscite.domain.StatoComitato.AutorizzazioneComitato;
import it.ccse.uscite.exception.ApplicationException;

/**
 * The persistent class for the ordine_del_giorno database table.}
 * 
 */
@Entity
@NamedEntityGraphs({
	@NamedEntityGraph(name="ordine.processi", attributeNodes={ @NamedAttributeNode(value = "processiErogazione")}),
	@NamedEntityGraph(name="ordine.processi.pratiche", attributeNodes= @NamedAttributeNode(subgraph="processiErogazione", value = "processiErogazione"), 
            subgraphs = {
            		@NamedSubgraph(name = "processiErogazione", attributeNodes = @NamedAttributeNode(subgraph="praticheErogazione",value="praticheErogazione")),
            		@NamedSubgraph(name = "praticheErogazione", attributeNodes = {
            				@NamedAttributeNode("statoComitato"),
            				@NamedAttributeNode("tipoPeriodo"),
            				@NamedAttributeNode("statoLegale"),
            				@NamedAttributeNode("statoContabile"),
            				@NamedAttributeNode("statoUnbundling"),
            				@NamedAttributeNode("statoFideiussione")
            				})
            		})
	})
@AttributeOverride(name = "id", column = @Column(name = "id_ordine_del_giorno"))
@Table(name = "ordine_del_giorno")
@Audited
public class OrdineDelGiorno extends DomainEntity<BigInteger> implements Serializable {
	public enum StatoComitato{
		APERTO,CHIUSO
	}

	public enum TipologiaComitato{
		ORDINARIO,STRAORDINARIO
	}

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="data_comitato",unique=true)
	private Date dataComitato;

	private String descrizione;

	private Integer numeroComitato;

	@Enumerated(EnumType.STRING)
	private StatoComitato stato;

	@Enumerated(EnumType.STRING)
	private TipologiaComitato tipologia;

	//bi-directional many-to-one association to ProcessoErogazione
	@OneToMany(mappedBy="ordineDelGiorno")
	private Set<ProcessoErogazione> processiErogazione;

	public OrdineDelGiorno() {
		setId(null);
		stato = StatoComitato.APERTO;		
		numeroComitato = 1;
	}

	public ProcessoErogazione addProcessiErogazione(ProcessoErogazione processiErogazione) {
		getProcessiErogazione().add(processiErogazione);
		processiErogazione.setOrdineDelGiorno(this);

		return processiErogazione;
	}

	public void aggiorna(Date dataComitato, String descrizione,
			Integer numeroComitato, TipologiaComitato tipologia) {
		checkModificabilita();
		
		if(dataComitato!=null){
			setDataComitato(dataComitato);
		}
		
		setDescrizione(descrizione);
		setNumeroComitato(numeroComitato);
		
		if(tipologia!=null){
			setTipologia(tipologia);
		}
	}

	public void apri() {
		checkApertura();
		setStato(StatoComitato.APERTO);
		if(getTotaleNote()>0){
			for(ProcessoErogazione processo :processiErogazione){
				processo.setLavorazioneContabile(StatoLavorazioneContabile.IN_INSERIMENTO);
				if(processo.getNumeroPratiche()>0){
					for(PraticaErogazione pratica:processo.getPraticheErogazione()){
						pratica.setLavorazioneContabile(StatoPratica.ASSEGNATO);
						pratica.annullaAutorizzazioneComitato();
					}
				}
			} 
		}
	}

	private void checkApertura(){
		int numeroProcessi = processiErogazione.size();
		if(numeroProcessi>0){
			for(ProcessoErogazione processo :processiErogazione){
				processo.checkModificabilita();
			}
		}
	}

	private void checkChiusura() {
		int numeroProcessi = processiErogazione.size();
		if(numeroProcessi>0){
			for(ProcessoErogazione processo:processiErogazione){
				if(processo.getStato() != StatoProcesso.CHIUSO){
					throw new ApplicationException("error.comitato.note.stato.invalid.chiusura");
				}
			}
		}
		
	}

	public void checkInserimento() {

		if(dataComitato == null){
			throw new ApplicationException("error.comitato.data.empty.inserimento");
		}
		Date today = DateUtils.truncate(new Date(),Calendar.DAY_OF_MONTH);
		dataComitato =  DateUtils.truncate(dataComitato,Calendar.DAY_OF_MONTH);
		if(dataComitato.before(today)){
			throw new ApplicationException("error.comitato.data.invalid.inserimento");
		}
		if(tipologia == null){
			throw new ApplicationException("error.comitato.tipo.empty.inserimento");
		}

		
	}
	
	

	public void checkModificabilita() {
		if(getStato()==StatoComitato.CHIUSO){
			throw new ApplicationException("error.comitato.stato.chiuso.modifica");
		}
	}

	public void checkRinvioComitato() {
		Date dataComitato =	DateUtils.truncate(getDataComitato(),Calendar.DAY_OF_MONTH);
		Date today = DateUtils.truncate(new Date(),Calendar.DAY_OF_MONTH);
		
		if(dataComitato.before(today)){
			throw new ApplicationException("error.comitato.data.invalid.rinvio");
		}
		if(getStato()==StatoComitato.CHIUSO){
			throw new ApplicationException("error.comitato.stato.chiuso.rinvio");
		}
	
	}

	public void chiudi() {
		checkChiusura();
		if(getTotaleNote()>0){
			for(ProcessoErogazione processo :processiErogazione){
				processo.setLavorazioneContabile(StatoLavorazioneContabile.LAVORABILE);
				if(processo.getNumeroPratiche()>0){
					for(PraticaErogazione pratica:processo.getPraticheErogazione()){
						if(pratica.getAutorizzazioneComitato()==AutorizzazioneComitato.DONT_CARE){
							pratica.setLavorazioneContabile(StatoPratica.LAVORABILE);
						}
					}
				}
			} 
		}
		setStato(StatoComitato.CHIUSO);
	}

	public Date getDataComitato() {
		return this.dataComitato;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public BigInteger getIdComitato(){
		return getId();
	}
	
	public BigInteger getIdOrdineDelGiorno(){
		return getId();
	}
	
	public Integer getNumeroComitato() {
		return this.numeroComitato;
	}
	
	public Integer getTotaleNote(){
		return processiErogazione!=null?processiErogazione.size():0;
	}
	
	public Set<ProcessoErogazione> getProcessiErogazione() {
		return this.processiErogazione;
	}

	public StatoComitato getStato() {
		return this.stato;
	}

	public TipologiaComitato getTipologia() {
		return this.tipologia;
	}

	public ProcessoErogazione removeProcessiErogazione(ProcessoErogazione processiErogazione) {
		getProcessiErogazione().remove(processiErogazione);
		processiErogazione.setOrdineDelGiorno(null);

		return processiErogazione;
	}

	public void setDataComitato(Date dataComitato) {
		this.dataComitato = dataComitato;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public void setIdComitato(BigInteger id){
		setId(id);
	}

	public void setIdOrdineDelGiorno(BigInteger id){
		setId(id);
	}

	public void setNumeroComitato(Integer numeroComitato) {
		this.numeroComitato = numeroComitato;
	}

	public void setProcessiErogazione(Set<ProcessoErogazione> processiErogazione) {
		this.processiErogazione = processiErogazione;
	}

	public void setStato(StatoComitato stato) {
		this.stato = stato;
	}

	public void setTipologia(TipologiaComitato tipologia) {
		this.tipologia = tipologia;
	}
	
	public BigDecimal getTotaleImporto(){
		return processiErogazione != null ? processiErogazione.stream().map(p->p.getTotaleImporto()).reduce(BigDecimal.ZERO, BigDecimal::add):BigDecimal.ZERO;
	}
	
	public Set<ProcessoErogazione> getNote(){
		return this.processiErogazione;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrdineDelGiorno [getDataComitato()=");
		builder.append(getDataComitato());
		builder.append(", getDescrizione()=");
		builder.append(getDescrizione());
		builder.append(", getNumeroComitato()=");
		builder.append(getNumeroComitato());
		builder.append(", getStato()=");
		builder.append(getStato());
		builder.append(", getTipologia()=");
		builder.append(getTipologia());
		builder.append("]");
		return builder.toString();
	}
}