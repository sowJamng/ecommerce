package modele;
// Generated 24 sept. 2019 13:48:32 by Hibernate Tools 4.0.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Clientvirtuel.
 * @see modele.Clientvirtuel
 * @author Hibernate Tools
 */
@Stateless
public class ClientvirtuelHome {

	private static final Log log = LogFactory.getLog(ClientvirtuelHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Clientvirtuel transientInstance) {
		log.debug("persisting Clientvirtuel instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Clientvirtuel persistentInstance) {
		log.debug("removing Clientvirtuel instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Clientvirtuel merge(Clientvirtuel detachedInstance) {
		log.debug("merging Clientvirtuel instance");
		try {
			Clientvirtuel result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Clientvirtuel findById(int id) {
		log.debug("getting Clientvirtuel instance with id: " + id);
		try {
			Clientvirtuel instance = entityManager.find(Clientvirtuel.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
