package jee.commerce.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import jee.commerce.config.HibernateUtil;
import jee.commerce.config.SessionFactoryProvider;
import model.Commercant;
import model.Commercant;

public class CommercantDao {
private static final Log log = LogFactory.getLog(CommercantDao.class);

private final static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
private static Session session=null;

public static Commercant connexion(String email,String motpass) {
//	Session session=null;
//	if (null == login ) {
//		throw new IllegalArgumentException("Login and password are mandatory. Null values are forbidden.");
//	}		
	session=HibernateUtil.getSessionFactory().openSession();
	try {		
		// create a new criteria
		Criteria crit = session.createCriteria(Commercant.class);
		crit.add(Restrictions.eq("email", email.trim()));
		crit.add(Restrictions.eq("motpass", motpass.trim()));
		Object o=crit.uniqueResult();
		if(o!=null) {
		Commercant user = (Commercant)o;//sous-classement
		session.close();
		return user;
		}
	    else {
	    	  session.close(); 	       
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

public void add(Commercant c){
	try{
		session=HibernateUtil.getSessionFactory().openSession();
		//session = sessionFactory.openSession();
	session.beginTransaction();
	session.save(c);
	session.getTransaction().commit();		
	System.out.println("Ajout effectue avec succes");
} catch (RuntimeException re) {
	 System.out.println("Integererception exception"+re.getMessage());
}
}

public Commercant edit(Commercant b){
		//session = sessionFactory.openSession();
	
		session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	     Commercant bt=(Commercant)session.merge(b);
		session.getTransaction().commit();
		System.out.println("Modification effectuee avec succes");
		return bt;	
	}
public void delete(Integer id){
	try{
	session=HibernateUtil.getSessionFactory().openSession();
	//session = sessionFactory.openSession();
	Commercant c= (Commercant) session.get(Commercant.class,id);
	if(c!=null){
		 session.beginTransaction();
		 session.delete(c);
		 session.getTransaction().commit();
	}
	else
	{
		System.out.println("personne  does not exists");
	}
     
	}
	catch(Exception e){
		e.printStackTrace();
		
	}
}

	// commit only, if tx still hasn't been committed yet by Hibernate
	/*if (session.getStatus().equals(TransactionStatus.ACTIVE)) { 
		session.getTransaction().commit();
	}
	
	}
	public void delete(Integer id){
		/*session = sessionFactory.openSession();
		session.begIntegerransaction();
            session.createQuery("delete from Commercant where idcommercant="+id);
            session.getTransaction().commit();
            System.out.prIntegerln("Ajout effectue avec succes");*/   
        
	/*	boolean result;
	try {
		session = sessionFactory.openSession();
		session.begIntegerransaction();
		Commercant bt=findById(id);
	    session.delete(bt);
		session.getTransaction().commit();		
		result=true;
		 System.out.prIntegerln("Ajout effectue avec succes :"+result);
		 
	} catch (RuntimeException re) {
		result=false;
		 System.out.prIntegerln("Integererception exception"+re.getMessage());
		 System.out.prIntegerln("echec suppression :"+result);
		
	}
	//return result;
	}*/
	public Commercant findById(Integer id){
		//session = sessionFactory.openSession();
		session=HibernateUtil.getSessionFactory().openSession();
		//return (Commercant)session.get(Commercant.class,id);
		return (Commercant)session.get(Commercant.class, id);
		
		
	}
	
	public List<Commercant> findAll(){
	
		session = sessionFactory.openSession();
		return session.createQuery("select c from Commercant c").list();
		
		
	}
	/*public void add(Commercant c){
		session.begIntegerransaction();
		session.save(c);
		session.getTransaction().commit();			
	}
	public Commercant edit(Commercant b){
		session.begIntegerransaction();
		Commercant bt=(Commercant)session.merge(b);
		session.getTransaction().commit();
		return bt;
		
				
	}
	//méthode Supprimer d'une entité à  partir de la bd
		 public  void supprimer(Integer id)
		{ 
			 session.begIntegerransaction();
		    session.merge(c); // important
		    ((List<Commercant>) session).remove(c);
		   session.getTransaction().commit();  
		}
	public Commercant findById(Integer id){
		return (Commercant)session.get(Commercant.class,id);
	}
	
	public List<Commercant> findAll(){
		return session.createQuery("select c from Commercant c").list();
		
	}
	//méthode pour lister tous les objetsà  partir de la bd
	 public List<Commercant> listerParNom(String nom) {
		 @SuppressWarnings("unchecked")
		List<Commercant> commercants =session.createQuery( "select c from Commercant c where c.nom like :pnom")
				 				            .setParameter("pnom", "%"+nom+"%").list();
		 return commercants;
		 }*/

}
