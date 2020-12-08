package modele;
// Generated 24 sept. 2019 13:48:32 by Hibernate Tools 4.0.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Commune.
 * @see modele.Commune
 * @author Hibernate Tools
 */
@Stateless
public class CommuneHome {

	private static final Log log = LogFactory.getLog(CommuneHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Commune transientInstance) {
		log.debug("persisting Commune instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Commune persistentInstance) {
		log.debug("removing Commune instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Commune merge(Commune detachedInstance) {
		log.debug("merging Commune instance");
		try {
			Commune result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Commune findById(int id) {
		log.debug("getting Commune instance with id: " + id);
		try {
			Commune instance = entityManager.find(Commune.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
