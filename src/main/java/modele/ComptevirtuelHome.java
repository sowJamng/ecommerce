package modele;
// Generated 24 sept. 2019 13:48:32 by Hibernate Tools 4.0.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Comptevirtuel.
 * @see modele.Comptevirtuel
 * @author Hibernate Tools
 */
@Stateless
public class ComptevirtuelHome {

	private static final Log log = LogFactory.getLog(ComptevirtuelHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Comptevirtuel transientInstance) {
		log.debug("persisting Comptevirtuel instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Comptevirtuel persistentInstance) {
		log.debug("removing Comptevirtuel instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Comptevirtuel merge(Comptevirtuel detachedInstance) {
		log.debug("merging Comptevirtuel instance");
		try {
			Comptevirtuel result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Comptevirtuel findById(int id) {
		log.debug("getting Comptevirtuel instance with id: " + id);
		try {
			Comptevirtuel instance = entityManager.find(Comptevirtuel.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
