package modele;
// Generated 24 sept. 2019 13:48:32 by Hibernate Tools 4.0.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Format.
 * @see modele.Format
 * @author Hibernate Tools
 */
@Stateless
public class FormatHome {

	private static final Log log = LogFactory.getLog(FormatHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Format transientInstance) {
		log.debug("persisting Format instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Format persistentInstance) {
		log.debug("removing Format instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Format merge(Format detachedInstance) {
		log.debug("merging Format instance");
		try {
			Format result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Format findById(int id) {
		log.debug("getting Format instance with id: " + id);
		try {
			Format instance = entityManager.find(Format.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
