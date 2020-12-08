package jee.commerce.dao;

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import jee.commerce.config.HibernateUtil;
import jee.commerce.config.SessionFactoryProvider;
import model.Client;
import model.Commercant;
import model.Client;
public class ClientDao {
	private static final Log log = LogFactory.getLog(ClientDao.class);

private final static SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
private static Session session=null;
public boolean persist(Client  client) {
	
	//log.debug("persisting Client instance");
	boolean result=false;
	try { 
		session = sessionFactory.openSession();
		org.hibernate.Transaction t =session.beginTransaction();
		session.save(client);
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
public void add(Client c){
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
public Client edit(Client b){
	//session = sessionFactory.openSession();
	session=HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();
     Client bt=(Client)session.merge(b);
	session.getTransaction().commit();
	System.out.println("Modification effectuee avec succes");
	return bt;	
}
	
public void delete(Integer id){
	try{
	session=HibernateUtil.getSessionFactory().openSession();
	//session = sessionFactory.openSession();
	Client c= (Client) session.get(Client.class,id);
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
	public Client findById(int id){
		session = sessionFactory.openSession();
		return (Client)session.get(Client.class,id);
	}
	
	public List<Client> findAll(){
	
		session = sessionFactory.openSession();
		return session.createQuery("select c from Client c").list();
		
	}
	public static List<Client> findrecherche(String nom)
	{
		List<Client> L=null;
		try{
		Session session=sessionFactory.openSession();
		Criteria crit = session.createCriteria(Client.class);
		crit.add(Restrictions.eq("nom", nom.trim()));
		L=crit.list();			
		}
		catch(RuntimeException re)
		{
			re.printStackTrace();
		}
		return  L;
	}

}
