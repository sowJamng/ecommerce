package modele;
// Generated 24 sept. 2019 13:48:32 by Hibernate Tools 4.0.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Boutiquier.
 * @see modele.Boutiquier
 * @author Hibernate Tools
 */
@Stateless
public class BoutiquierHome {

	private static final Log log = LogFactory.getLog(BoutiquierHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Boutiquier transientInstance) {
		log.debug("persisting Boutiquier instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Boutiquier persistentInstance) {
		log.debug("removing Boutiquier instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Boutiquier merge(Boutiquier detachedInstance) {
		log.debug("merging Boutiquier instance");
		try {
			Boutiquier result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Boutiquier findById(int id) {
		log.debug("getting Boutiquier instance with id: " + id);
		try {
			Boutiquier instance = entityManager.find(Boutiquier.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
