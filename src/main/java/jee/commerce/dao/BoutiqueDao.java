package jee.commerce.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jee.commerce.config.SessionFactoryProvider;
import model.Boutique;

public class BoutiqueDao {
	private static final Log log = LogFactory.getLog(BoutiqueDao.class);

	private final static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
	private static Session session=null;
	public boolean persist(Boutique  boutique) {
		
		//log.debug("persisting Boutique instance");
		boolean result=false;
		try { 
			session = sessionFactory.openSession();
			org.hibernate.Transaction t =session.beginTransaction();
			session.save(boutique);
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

	public void add(Boutique boutique){
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(boutique);
		session.getTransaction().commit();		
		System.out.println("Ajout effectue avec succes");
	}
		public Boutique edit(Boutique b){
			session = sessionFactory.openSession();
			session.beginTransaction();
			Boutique bt=(Boutique)session.merge(b);
			session.getTransaction().commit();
			return bt;
			
		}
		public boolean delete(int id){
			boolean result=false;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Boutique bt=findById(id);
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
		public Boutique findById(int id){
			session = sessionFactory.openSession();
			return (Boutique)session.get(Boutique.class,id);
		}
		
		public List<Boutique> findAll(){
		
			session = sessionFactory.openSession();
			return session.createQuery("select c from Boutique c").list();
			
		}
}
