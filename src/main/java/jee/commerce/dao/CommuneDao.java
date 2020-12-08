package jee.commerce.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jee.commerce.config.SessionFactoryProvider;
import model.Commune;

public class CommuneDao {
	private static final Log log = LogFactory.getLog(CommuneDao.class);

	private final static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
	private static Session session=null;
	
	public boolean persist(Commune  c) {
		
		//log.debug("persisting Commune instance");
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

	public void add(Commune c){
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();		
		System.out.println("Ajout effectue avec succes");
	}
		public Commune edit(Commune b){
			session = sessionFactory.openSession();
			session.beginTransaction();
			Commune bt=(Commune)session.merge(b);
			session.getTransaction().commit();
			return bt;
			
		}
		public boolean delete(int id){
			boolean result=false;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Commune bt=findById(id);
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
		public Commune findById(int id){
			session = sessionFactory.openSession();
			return (Commune)session.get(Commune.class,id);
		}
		
		public List<Commune> findAll(){
		
			session = sessionFactory.openSession();
			return session.createQuery("select c from Commune c").list();
			
		}

}
