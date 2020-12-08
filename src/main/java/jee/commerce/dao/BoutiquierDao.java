package jee.commerce.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import jee.commerce.config.HibernateUtil;
import jee.commerce.config.SessionFactoryProvider;
import  model.Boutiquier;


public class BoutiquierDao {
	private static final Log log = LogFactory.getLog(BoutiquierDao.class);

	private final static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
	private static Session session=null;
	
	public static Boutiquier connexion(String email,String motpass) {
//		Session session=null;
//		if (null == login ) {
//			throw new IllegalArgumentException("Login and password are mandatory. Null values are forbidden.");
//		}		
		session=sessionFactory.openSession();
		try {
			
			// create a new criteria
			Criteria crit = session.createCriteria(Boutiquier.class);
			crit.add(Restrictions.eq("email", email.trim()));
			crit.add(Restrictions.eq("motpass", motpass.trim()));
			Object o=crit.uniqueResult();
			if(o!=null) {
			Boutiquier user = (Boutiquier)o;//sous-classement
			session.close();
			return user;
			}
			       else   {session.close(); 
			       return null;
			      }
		}
		catch(Exception e) {
			e.printStackTrace();
			session.close();
			// Critical errors : database unreachable, etc.
			return null;
		}
			}
	public boolean persist(Boutiquier  boutiquier) {
		
		//log.debug("persisting boutiquier instance");
		boolean result=false;
		try { 
			session = sessionFactory.openSession();
			org.hibernate.Transaction t =session.beginTransaction();
			session.save(boutiquier);
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

	public void add(Boutiquier boutiquier){
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(boutiquier);
		session.getTransaction().commit();		
		System.out.println("Ajout effectue avec succes");
	}
		public Boutiquier edit(Boutiquier b){
			session = sessionFactory.openSession();
			session.beginTransaction();
			Boutiquier bt=(Boutiquier)session.merge(b);
			session.getTransaction().commit();
			return bt;
			
		}
		public boolean delete(int id){
			boolean result=false;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Boutiquier bt=findById(id);
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
		public Boutiquier findById(int id){
			session = sessionFactory.openSession();
			return (Boutiquier)session.get(Boutiquier.class,id);
		}
		
		public List<Boutiquier> findAll(){
		
			session = sessionFactory.openSession();
			return session.createQuery("select c from boutiquier c").list();
			
		}
		public static List<Boutiquier> findrecherche(String nom)
		{
			List<Boutiquier> B=null;
			try{
			Session session=sessionFactory.openSession();
			Criteria crit = session.createCriteria(Boutiquier.class);
			crit.add(Restrictions.eq("nom", nom.trim()));
			B=crit.list();
			

				
			}
			catch(RuntimeException re)
			{
				re.printStackTrace();
			}
			return  B;
		}


}
