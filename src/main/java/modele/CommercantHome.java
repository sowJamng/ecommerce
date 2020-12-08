package modele;
// Generated 24 sept. 2019 13:48:32 by Hibernate Tools 4.0.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Commercant.
 * @see modele.Commercant
 * @author Hibernate Tools
 */
@Stateless
public class CommercantHome {

	private static final Log log = LogFactory.getLog(CommercantHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Commercant transientInstance) {
		log.debug("persisting Commercant instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Commercant persistentInstance) {
		log.debug("removing Commercant instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Commercant merge(Commercant detachedInstance) {
		log.debug("merging Commercant instance");
		try {
			Commercant result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Commercant findById(int id) {
		log.debug("getting Commercant instance with id: " + id);
		try {
			Commercant instance = entityManager.find(Commercant.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
