package it.ccse.uscite.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import it.ccse.uscite.domain.StatoComitato.AutorizzazioneComitato;
import it.ccse.uscite.exception.ApplicationException;


/**
 * The persistent class for the processo_erogazione database table.
 * 
 */
@Entity
@NamedEntityGraph(name="processo.pratiche", attributeNodes={ 
															@NamedAttributeNode(subgraph="praticheErogazione", value = "praticheErogazione"),
															@NamedAttributeNode("ordineDelGiorno")
															},
											subgraphs = @NamedSubgraph(name = "praticheErogazione", attributeNodes = {
													@NamedAttributeNode("statoComitato"),
													@NamedAttributeNode("tipoPeriodo"),
													@NamedAttributeNode("statoLegale"),
													@NamedAttributeNode("statoContabile"),
													@NamedAttributeNode("statoUnbundling"),
													@NamedAttributeNode("statoFideiussione")
													})
		)
@Table(name="processo_erogazione")
@AttributeOverride(name = "id", column = @Column(name = "id_processo_erogazione"))
@Audited
public class ProcessoErogazione extends DomainEntity<BigInteger> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Lob
	private String causale;

	@Column(name="lavorazione_contabile")
	@Enumerated(EnumType.STRING)
	private StatoLavorazioneContabile lavorazioneContabile = StatoLavorazioneContabile.UNDEFINED;

	@Column(name="numero_nota")
	private Integer numeroNota;

	private String owner;

	@Enumerated(EnumType.STRING)
	private StatoProcesso stato;

	//bi-directional many-to-one association to PraticaErogazione
	@OneToMany(mappedBy="processoErogazione")
	private Set<PraticaErogazione> praticheErogazione;

	//bi-directional many-to-one association to OrdineDelGiorno
	@ManyToOne(optional=false)
	@JoinColumn(name="id_ordine_del_giorno")
	private OrdineDelGiorno ordineDelGiorno;

	public ProcessoErogazione() {
		stato = StatoProcesso.TEMPORANEO;
		lavorazioneContabile = StatoLavorazioneContabile.LAVORABILE;
	}

	public String getCausale() {
		return this.causale;
	}

	public void setCausale(String causale) {
		this.causale = causale;
	}

	public StatoLavorazioneContabile getLavorazioneContabile() {
		return this.lavorazioneContabile;
	}

	public void setLavorazioneContabile(StatoLavorazioneContabile lavorazioneContabile) {
		this.lavorazioneContabile = lavorazioneContabile;
	}

	public Integer getNumeroNota() {
		return this.numeroNota;
	}

	public void setNumeroNota(Integer numeroNota) {
		this.numeroNota = numeroNota;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public StatoProcesso getStato() {
		return this.stato;
	}

	public void setStato(StatoProcesso stato) {
		this.stato = stato;
	}

	public Set<PraticaErogazione> getPraticheErogazione() {
		return this.praticheErogazione;
	}

	public void setPraticheErogazione(Set<PraticaErogazione> praticheErogazione) {
		this.praticheErogazione = praticheErogazione;
	}

	public PraticaErogazione addPraticheErogazione(PraticaErogazione praticheErogazione) {
		getPraticheErogazione().add(praticheErogazione);
		praticheErogazione.setProcessoErogazione(this);

		return praticheErogazione;
	}

	public PraticaErogazione removePraticheErogazione(PraticaErogazione praticheErogazione) {
		getPraticheErogazione().remove(praticheErogazione);
		praticheErogazione.setProcessoErogazione(null);

		return praticheErogazione;
	}

	public OrdineDelGiorno getOrdineDelGiorno() {
		return this.ordineDelGiorno;
	}

	public void setOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno) {
		this.ordineDelGiorno = ordineDelGiorno;
	}
	
	public BigInteger getIdProcessoErogazione(){
		return getId();
	}
	
	public void setIdProcessoErogazione(BigInteger id){
		setId(id);
	}
	
	public BigInteger getIdNota(){
		return getId();
	}
	
	public void setIdNota(BigInteger id){
		setId(id);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProcessoErogazione [causale=");
		builder.append(causale);
		builder.append(", lavorazioneContabile=");
		builder.append(lavorazioneContabile);
		builder.append(", numeroNota=");
		builder.append(numeroNota);
		builder.append(", owner=");
		builder.append(owner);
		builder.append(", stato=");
		builder.append(stato);
		builder.append(", ordineDelGiorno=");
		builder.append(ordineDelGiorno!=null?ordineDelGiorno.getId():null);
		builder.append("]");
		return builder.toString();
	}


	public enum StatoProcesso{
		APERTO,CHIUSO,TEMPORANEO
	}

	public enum StatoLavorazioneContabile{
		UNDEFINED,IN_INSERIMENTO,LAVORABILE,LAVORATO
	}

	public BigDecimal getTotaleImporto() {
		return (getNumeroPratiche() > 0) ? praticheErogazione.stream().map(p->p.getImpegno()).reduce(BigDecimal.ZERO, BigDecimal::add):BigDecimal.ZERO;
	}
	
	public Integer getNumeroPratiche(){
		return praticheErogazione!=null?praticheErogazione.size():0;
	}

	public void aggiorna(Integer numeroNota, String causale, String owner) {
		checkModificabilita();
		if(numeroNota==null){
			stato = StatoProcesso.TEMPORANEO;
		}else{
			stato = StatoProcesso.APERTO;	
		}
		this.numeroNota = numeroNota;
		this.causale = causale;
		this.owner = owner;
	}

	

	public void checkModificabilita() {
		if(getLavorazioneContabile()==StatoLavorazioneContabile.LAVORATO){
			throw new ApplicationException("error.nota.stato.invalid.modifica");
		}
		
		int numeroPratiche = getNumeroPratiche();
		if (numeroPratiche>0){
			for(PraticaErogazione pratica:praticheErogazione){
				pratica.checkModificabilita();
				
			}
		}
		
	}

	public void apri() {
		checkModificabilita();
		stato = StatoProcesso.APERTO;
	}

	public void chiudi() {
		checkChiusura();
		this.stato = StatoProcesso.CHIUSO;
	}

	private void checkChiusura() {
		if(stato == StatoProcesso.TEMPORANEO||numeroNota==null){
			throw new ApplicationException("error.nota.stato.invalid.chiusura");
		}
	}

	public void checkCancellazione() {
		if(stato == StatoProcesso.CHIUSO){
			throw new ApplicationException("error.nota.statoEliminazione.invalid");
		}
		if(praticheErogazione != null && !praticheErogazione.isEmpty()){
			throw new ApplicationException("error.nota.praticheEliminazione.notEmpty");
		}
	}

	public void rinvia(OrdineDelGiorno ordine) {
		checkRinvio();
		ordine.checkRinvioComitato();		
		this.ordineDelGiorno = ordine;
		this.setNumeroNota(null);
		this.stato = StatoProcesso.TEMPORANEO;
		if(this.getNumeroPratiche()>0){
			for(PraticaErogazione pratica:praticheErogazione){
				pratica.setAutorizzazioneComitato(AutorizzazioneComitato.RINVIATA);
			}
		}
	}

	private void checkRinvio() {
		if(lavorazioneContabile == StatoLavorazioneContabile.LAVORATO){
			throw new ApplicationException("error.nota.stato.invalid.lavorazione");
		}
	}

	public void checkInserimento() {
		stato = (numeroNota !=null)?StatoProcesso.APERTO:StatoProcesso.TEMPORANEO;
		if(!(praticheErogazione==null || praticheErogazione.size()==0)){
			throw new ApplicationException("error.nota.pratiche.notEmpty.inserimento");
		}
		
		if(this.ordineDelGiorno == null||ordineDelGiorno.getId()==null){
			throw new ApplicationException("error.nota.comitato.empty");
		}
		
		if(this.owner == null){
			throw new ApplicationException("error.nota.unita.empty");
		}
		
	}
	
	public void lavorazioneContabile(){
		checkLavorazioneContabile();
		if(lavorazioneContabile == StatoLavorazioneContabile.LAVORABILE && getNumeroPratiche()>0){
			if(!praticheErogazione.stream().filter(PraticaErogazione.IS_LAVORABILE).findAny().isPresent()){
				lavorazioneContabile = StatoLavorazioneContabile.LAVORATO;
			}
		}
	}

	public void checkLavorazioneContabile() {
		if (lavorazioneContabile != StatoLavorazioneContabile.LAVORABILE && lavorazioneContabile != StatoLavorazioneContabile.LAVORATO){
			throw new ApplicationException("error.nota.stato.invalid.lavorazione");
		}
		
		if(getNumeroPratiche()>0){
			if(praticheErogazione.stream().filter(PraticaErogazione.IS_NOT_LAVORABILE).findAny().isPresent()){
				throw new ApplicationException("error.nota.pratiche.stato.invalid.lavorazione");
			}
		}
	}

	public void init() {
		setId(null);
		this.setLavorazioneContabile(StatoLavorazioneContabile.IN_INSERIMENTO);		
	}

	public boolean isChiusa(){
		return this.stato==StatoProcesso.CHIUSO;
	}
	
	public boolean isAperta(){
		return this.stato==StatoProcesso.APERTO;
	}
	
	public boolean isTemporanea(){
		return this.stato==StatoProcesso.TEMPORANEO;
	}
	
}