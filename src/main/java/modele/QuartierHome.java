package modele;
// Generated 24 sept. 2019 13:48:32 by Hibernate Tools 4.0.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Quartier.
 * @see modele.Quartier
 * @author Hibernate Tools
 */
@Stateless
public class QuartierHome {

	private static final Log log = LogFactory.getLog(QuartierHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Quartier transientInstance) {
		log.debug("persisting Quartier instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Quartier persistentInstance) {
		log.debug("removing Quartier instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Quartier merge(Quartier detachedInstance) {
		log.debug("merging Quartier instance");
		try {
			Quartier result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Quartier findById(int id) {
		log.debug("getting Quartier instance with id: " + id);
		try {
			Quartier instance = entityManager.find(Quartier.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
