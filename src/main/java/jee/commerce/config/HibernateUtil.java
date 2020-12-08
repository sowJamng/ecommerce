package jee.commerce.config;
	import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.service.ServiceRegistry;
	import org.hibernate.service.ServiceRegistryBuilder;	
	import org.hibernate.cfg.Configuration;
	import org.hibernate.service.ServiceRegistry;

	public class HibernateUtil {

		private static  SessionFactory sessionFactory=configureSessionFactory();


		public  static SessionFactory configureSessionFactory ( ) throws     HibernateException {
	        Configuration configuration = new Configuration();
	       configuration.configure("hibernate.cfg.xml");
	       ServiceRegistry  serviceRegistry = new ServiceRegistryBuilder().applySettings
	        (configuration.getProperties()).buildServiceRegistry();        
	         sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	return sessionFactory;
	}

		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}
		public static void main(String a[]){
			configureSessionFactory();
		}
	

 public static Session openSession(){
	return sessionFactory.openSession();
	}
	public static void close(){
	if(sessionFactory!=null){sessionFactory.close();
	}
	sessionFactory=null;
	}

	   public Session getCurrentSession(){
	    return sessionFactory.getCurrentSession();
	}


}
