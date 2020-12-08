package modele;
// Generated 24 sept. 2019 13:48:32 by Hibernate Tools 4.0.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Boutique.
 * @see modele.Boutique
 * @author Hibernate Tools
 */
@Stateless
public class BoutiqueHome {

	private static final Log log = LogFactory.getLog(BoutiqueHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Boutique transientInstance) {
		log.debug("persisting Boutique instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Boutique persistentInstance) {
		log.debug("removing Boutique instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Boutique merge(Boutique detachedInstance) {
		log.debug("merging Boutique instance");
		try {
			Boutique result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Boutique findById(int id) {
		log.debug("getting Boutique instance with id: " + id);
		try {
			Boutique instance = entityManager.find(Boutique.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
