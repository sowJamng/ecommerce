package jee.commerce.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jee.commerce.config.HibernateUtil;
import jee.commerce.config.SessionFactoryProvider;
import model.Produitt;


public class ProduitDao {
	
	private static final Log log = LogFactory.getLog(ProduitDao.class);

	private final static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
	private static Session session=null;
	
	public boolean persist(Produitt  c) {
		
		//log.debug("persisting Produitt instance");
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

	public void add(Produitt c){
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();		
		System.out.println("Ajout effectue avec succes");
	}
		public Produitt edit(Produitt b){
			session = sessionFactory.openSession();
			session.beginTransaction();
			Produitt bt=(Produitt)session.merge(b);
			session.getTransaction().commit();
			return bt;
			
		}
		public boolean delete(int id){
			boolean result=false;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Produitt bt=findById(id);
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
		public Produitt findById(int id){
			session = sessionFactory.openSession();
			return (Produitt)session.get(Produitt.class,id);
		}
		
		public List<Produitt> findAll(){
		
			session = sessionFactory.openSession();
			return session.createQuery("select c from Produitt c").list();
			
		}

}
