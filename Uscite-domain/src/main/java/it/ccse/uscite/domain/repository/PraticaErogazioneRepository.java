/**
 * 
 */
package it.ccse.uscite.domain.repository;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import it.ccse.uscite.domain.PraticaErogazione;
import it.ccse.uscite.domain.ProcessoErogazione;

/**
 * @author vcompagnone
 *
 */
public interface PraticaErogazioneRepository extends JpaRepository<PraticaErogazione, BigInteger>,JpaSpecificationExecutor<PraticaErogazione>{
	@EntityGraph("praticaErogazione")
	public List<PraticaErogazione> findByProcessoErogazione(ProcessoErogazione processoErogazione);
	@EntityGraph("praticaErogazione")
	public PraticaErogazione findByCodicePratica(String codicePratica);
	public List<PraticaErogazione> findByCodicePraticaIn(Collection<String> codiciPratica);
}
