package modele;
// Generated 24 sept. 2019 13:48:32 by Hibernate Tools 4.0.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Conditionnement.
 * @see modele.Conditionnement
 * @author Hibernate Tools
 */
@Stateless
public class ConditionnementHome {

	private static final Log log = LogFactory.getLog(ConditionnementHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Conditionnement transientInstance) {
		log.debug("persisting Conditionnement instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Conditionnement persistentInstance) {
		log.debug("removing Conditionnement instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Conditionnement merge(Conditionnement detachedInstance) {
		log.debug("merging Conditionnement instance");
		try {
			Conditionnement result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Conditionnement findById(int id) {
		log.debug("getting Conditionnement instance with id: " + id);
		try {
			Conditionnement instance = entityManager.find(Conditionnement.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
