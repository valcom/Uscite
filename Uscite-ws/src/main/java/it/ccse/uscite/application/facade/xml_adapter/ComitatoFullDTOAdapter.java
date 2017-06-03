/**
 * 
 */
package it.ccse.uscite.application.facade.xml_adapter;

import it.ccse.uscite.application.facade.dto.ComitatoFullDTO;
import javax.xml.bind.annotation.adapters.XmlAdapter;


/**
 * Classe utilizzata per evitare cicli e permettere la serializzazione del dto
 * 
 * @author vcompagnone
 *
 */
public class ComitatoFullDTOAdapter extends XmlAdapter<ComitatoFullDTO, ComitatoFullDTO> {

	@Override
	public ComitatoFullDTO marshal(ComitatoFullDTO v) throws Exception {
		if(v!=null&&v.getNote()!=null){
			v.getNote().stream().forEach(n->n.setOrdineDelGiorno(null));
		}
		return v;
	}

	@Override
	public ComitatoFullDTO unmarshal(ComitatoFullDTO v) throws Exception {
		return v;
	}

}
