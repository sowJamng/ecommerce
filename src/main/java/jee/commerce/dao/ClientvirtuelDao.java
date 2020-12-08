package jee.commerce.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jee.commerce.config.SessionFactoryProvider;
import model.Clientvirtuel;

public class ClientvirtuelDao {
	private static final Log log = LogFactory.getLog(ClientvirtuelDao.class);

	private final static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
	private static Session session=null;
	public boolean persist(Clientvirtuel  clientvirtuel) {
		
		//log.debug("persisting Clientvirtuel instance");
		boolean result=false;
		try { 
			session = sessionFactory.openSession();
			org.hibernate.Transaction t =session.beginTransaction();
			session.save(clientvirtuel);
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

	public void add(Clientvirtuel clientvirtuel){
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(clientvirtuel);
		session.getTransaction().commit();		
		System.out.println("Ajout effectue avec succes");
	}
		public Clientvirtuel edit(Clientvirtuel b){
			session = sessionFactory.openSession();
			session.beginTransaction();
			Clientvirtuel bt=(Clientvirtuel)session.merge(b);
			session.getTransaction().commit();
			return bt;
			
		}
		public boolean delete(int id){
			boolean result=false;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Clientvirtuel bt=findById(id);
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
		public Clientvirtuel findById(int id){
			session = sessionFactory.openSession();
			return (Clientvirtuel)session.get(Clientvirtuel.class,id);
		}
		
		public List<Clientvirtuel> findAll(){
		
			session = sessionFactory.openSession();
			return session.createQuery("select c from Clientvirtuel c").list();
			
		}

}
