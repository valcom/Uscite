/**
 * 
 */
package it.ccse.uscite.domain.filter;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import it.ccse.uscite.domain.OrdineDelGiorno;
import it.ccse.uscite.domain.ProcessoErogazione;
import it.ccse.uscite.domain.ProcessoErogazione.StatoLavorazioneContabile;
import it.ccse.uscite.domain.ProcessoErogazione.StatoProcesso;
import it.ccse.uscite.domain.ProcessoErogazione_;

/**
 * @author vcompagnone
 *
 */
public class ProcessoFilter extends PageableFilter<ProcessoErogazione> {

	private String owner;
	
	private OrdineDelGiorno ordineDelGiorno;
	
	private Integer numeroNota;
	
	private BigInteger idNota;
	
	private List<StatoLavorazioneContabile> statiLavorazioneContabile;
	
	private List<StatoProcesso> stati; 
	
	@Override
	public Specification<ProcessoErogazione> getSpecification() {
		Specification<ProcessoErogazione> hasId = (root,cq,cb)-> idNota !=null ? cb.equal(root.get(ProcessoErogazione_.id),idNota):null;
		Specification<ProcessoErogazione> hasNumeroNota = (root,cq,cb)->  numeroNota !=null ? cb.equal(root.get(ProcessoErogazione_.numeroNota),numeroNota):null;
		Specification<ProcessoErogazione> hasOrdineDelGiorno = (root,cq,cb)->  ordineDelGiorno !=null ? cb.equal(root.get(ProcessoErogazione_.ordineDelGiorno),ordineDelGiorno):null;
		Specification<ProcessoErogazione> hasOwner = (root,cq,cb)-> owner !=null ? cb.equal(root.get(ProcessoErogazione_.owner),owner):null;
		Specification<ProcessoErogazione> hasStato = (root,cq,cb)->  stati !=null ? root.get(ProcessoErogazione_.stato).in(stati):null;
		Specification<ProcessoErogazione> hasStatoLavorazioneContabile =  (root,cq,cb)-> statiLavorazioneContabile !=null ? root.get(ProcessoErogazione_.lavorazioneContabile).in(statiLavorazioneContabile):null;
		return Specifications.where(hasId).
				and(hasNumeroNota).
				and(hasOrdineDelGiorno).
				and(hasOwner).
				and(hasStato).
				and(hasStatoLavorazioneContabile);
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the ordineDelGiorno
	 */
	public OrdineDelGiorno getOrdineDelGiorno() {
		return ordineDelGiorno;
	}

	/**
	 * @param ordineDelGiorno the ordineDelGiorno to set
	 */
	public void setOrdineDelGiorno(OrdineDelGiorno ordineDelGiorno) {
		this.ordineDelGiorno = ordineDelGiorno;
	}

	/**
	 * @return the numeroNota
	 */
	public Integer getNumeroNota() {
		return numeroNota;
	}

	/**
	 * @param numeroNota the numeroNota to set
	 */
	public void setNumeroNota(Integer numeroNota) {
		this.numeroNota = numeroNota;
	}

	
	
	public void setIdOrdineDelGiorno(BigInteger idOrdineDelGiorno){
		if(idOrdineDelGiorno!=null){
			ordineDelGiorno = new OrdineDelGiorno();
			ordineDelGiorno.setId(idOrdineDelGiorno);
		}
	}
	
	public void setIdComitato(BigInteger idOrdineDelGiorno){
		setIdOrdineDelGiorno(idOrdineDelGiorno);
	}

	/**
	 * @return the idNota
	 */
	public BigInteger getIdNota() {
		return idNota;
	}

	/**
	 * @param idNota the idNota to set
	 */
	public void setIdNota(BigInteger idNota) {
		this.idNota = idNota;
	}

	/**
	 * @return the statiLavorazioneContabile
	 */
	public List<StatoLavorazioneContabile> getStatiLavorazioneContabile() {
		return statiLavorazioneContabile;
	}

	/**
	 * @param statiLavorazioneContabile the statiLavorazioneContabile to set
	 */
	public void setStatiLavorazioneContabile(List<StatoLavorazioneContabile> statiLavorazioneContabile) {
		this.statiLavorazioneContabile = statiLavorazioneContabile;
	}

	/**
	 * @return the stati
	 */
	public List<StatoProcesso> getStati() {
		return stati;
	}

	/**
	 * @param stati the stati to set
	 */
	public void setStati(List<StatoProcesso> stati) {
		this.stati = stati;
	}

}
