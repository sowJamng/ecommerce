package modele;
// Generated 24 sept. 2019 13:48:32 by Hibernate Tools 4.0.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Depatrtement.
 * @see modele.Depatrtement
 * @author Hibernate Tools
 */
@Stateless
public class DepatrtementHome {

	private static final Log log = LogFactory.getLog(DepatrtementHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Depatrtement transientInstance) {
		log.debug("persisting Depatrtement instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Depatrtement persistentInstance) {
		log.debug("removing Depatrtement instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Depatrtement merge(Depatrtement detachedInstance) {
		log.debug("merging Depatrtement instance");
		try {
			Depatrtement result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Depatrtement findById(int id) {
		log.debug("getting Depatrtement instance with id: " + id);
		try {
			Depatrtement instance = entityManager.find(Depatrtement.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
