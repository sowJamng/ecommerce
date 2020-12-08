package jee.commerce.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jee.commerce.config.HibernateUtil;
import jee.commerce.config.SessionFactoryProvider;
import model.Commande;
import model.Produitt;

public class CommandeDao {
	private static final Log log = LogFactory.getLog(CommandeDao.class);

	private final static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
	private static Session session=null;
	public boolean persist(Commande  commande) {
		
		//log.debug("persisting Commande instance");
		boolean result=false;
		try { 
			session = sessionFactory.openSession();
			org.hibernate.Transaction t =session.beginTransaction();
			session.save(commande);
			t.commit();
			session.close();
			log.debug("persist successful");
			//ss.close();
			 result=true;
			 System.out.println("Ajout effectue avec succes"+result);
			 
		} catch (RuntimeException re) {
			 System.out.println("Interception exception"+re.getMessage());
			result=false;
		}
		return result;
	}

	public void add(Commande commande){
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(commande);
		session.getTransaction().commit();		
		System.out.println("Ajout effectue avec succes");
	}
		public Commande edit(Commande b){
			session = sessionFactory.openSession();
			session.beginTransaction();
			Commande bt=(Commande)session.merge(b);
			session.getTransaction().commit();
			return bt;
			
		}
		public boolean delete(int id){
			boolean result=false;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Commande bt=findById(id);
		    session.delete(bt);
			session.getTransaction().commit();		
			result=true;
			 System.out.println("Ajout effectue avec succes"+result);
			 
		} catch (RuntimeException re) {
			 System.out.println("Interception exception"+re.getMessage());
			result=false;
		}
		return result;
		}
		public Commande findById(int id){
			session = sessionFactory.openSession();
			return (Commande)session.get(Commande.class,id);
		}
		
		public List<Commande> findAll(){
		
			session = sessionFactory.openSession();
			return session.createQuery("select c from Commande c").list();
			
		}

}
