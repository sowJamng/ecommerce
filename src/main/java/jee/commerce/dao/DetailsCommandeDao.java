package jee.commerce.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jee.commerce.config.SessionFactoryProvider;
import model.Detailscommande;

public class DetailsCommandeDao {
	private static final Log log = LogFactory.getLog(DetailsCommandeDao.class);

	private final static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
	private static Session session=null;
	
	public boolean persist(Detailscommande  c) {
		
		//log.debug("persisting Detailscommande instance");
		boolean result=false;
		try { 
			session = sessionFactory.openSession();
			org.hibernate.Transaction t =session.beginTransaction();
			session.save(c);
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

	public void add(Detailscommande c){
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();		
		System.out.println("Ajout effectue avec succes");
	}
		public Detailscommande edit(Detailscommande b){
			session = sessionFactory.openSession();
			session.beginTransaction();
			Detailscommande bt=(Detailscommande)session.merge(b);
			session.getTransaction().commit();
			return bt;
			
		}
		public boolean delete(int id){
			boolean result=false;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Detailscommande bt=findById(id);
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
		public Detailscommande findById(int id){
			session = sessionFactory.openSession();
			return (Detailscommande)session.get(Detailscommande.class,id);
		}
		
		public List<Detailscommande> findAll(){
		
			session = sessionFactory.openSession();
			return session.createQuery("select c from Detailscommande c").list();
			
		}


}
