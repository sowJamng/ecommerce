package modele;
// Generated 24 sept. 2019 13:48:32 by Hibernate Tools 4.0.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Produitt.
 * @see modele.Produitt
 * @author Hibernate Tools
 */
@Stateless
public class ProduittHome {

	private static final Log log = LogFactory.getLog(ProduittHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Produitt transientInstance) {
		log.debug("persisting Produitt instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Produitt persistentInstance) {
		log.debug("removing Produitt instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Produitt merge(Produitt detachedInstance) {
		log.debug("merging Produitt instance");
		try {
			Produitt result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Produitt findById(int id) {
		log.debug("getting Produitt instance with id: " + id);
		try {
			Produitt instance = entityManager.find(Produitt.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
