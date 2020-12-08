package modele;
// Generated 24 sept. 2019 13:48:32 by Hibernate Tools 4.0.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Detailscommande.
 * @see modele.Detailscommande
 * @author Hibernate Tools
 */
@Stateless
public class DetailscommandeHome {

	private static final Log log = LogFactory.getLog(DetailscommandeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Detailscommande transientInstance) {
		log.debug("persisting Detailscommande instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Detailscommande persistentInstance) {
		log.debug("removing Detailscommande instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Detailscommande merge(Detailscommande detachedInstance) {
		log.debug("merging Detailscommande instance");
		try {
			Detailscommande result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Detailscommande findById(DetailscommandeId id) {
		log.debug("getting Detailscommande instance with id: " + id);
		try {
			Detailscommande instance = entityManager.find(Detailscommande.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
