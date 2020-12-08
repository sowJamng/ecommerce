package modele;
// Generated 24 sept. 2019 13:48:32 by Hibernate Tools 4.0.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Depenses.
 * @see modele.Depenses
 * @author Hibernate Tools
 */
@Stateless
public class DepensesHome {

	private static final Log log = LogFactory.getLog(DepensesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Depenses transientInstance) {
		log.debug("persisting Depenses instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Depenses persistentInstance) {
		log.debug("removing Depenses instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Depenses merge(Depenses detachedInstance) {
		log.debug("merging Depenses instance");
		try {
			Depenses result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Depenses findById(int id) {
		log.debug("getting Depenses instance with id: " + id);
		try {
			Depenses instance = entityManager.find(Depenses.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
