package jee.commerce.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jee.commerce.config.SessionFactoryProvider;
import model.Facture;

public class FactureDao {
	private static final Log log = LogFactory.getLog(FactureDao.class);

	private final static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
	private static Session session=null;
	
	public boolean persist(Facture  c) {
		
		//log.debug("persisting Facture instance");
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

	public void add(Facture c){
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(c);
		session.getTransaction().commit();		
		System.out.println("Ajout effectue avec succes");
	}
		public Facture edit(Facture b){
			session = sessionFactory.openSession();
			session.beginTransaction();
			Facture bt=(Facture)session.merge(b);
			session.getTransaction().commit();
			return bt;
			
		}
		public boolean delete(int id){
			boolean result=false;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Facture bt=findById(id);
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
		public Facture findById(int id){
			session = sessionFactory.openSession();
			return (Facture)session.get(Facture.class,id);
		}
		
		public List<Facture> findAll(){
		
			session = sessionFactory.openSession();
			return session.createQuery("select c from Facture c").list();
			
		}

}
