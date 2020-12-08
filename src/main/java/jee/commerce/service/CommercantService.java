package jee.commerce.service;

import java.util.List;

import org.hibernate.Session;

import jee.commerce.config.HibernateUtil;
import jee.commerce.dao.CommercantDao;
import jee.commerce.dao.CommercantDao;
import jee.commerce.dao.CommercantDao;
import model.Commercant;
import model.Commercant;
import model.Commercant;

public class CommercantService {
Session session =HibernateUtil.openSession();

CommercantDao dao = new CommercantDao();

public void add(Commercant c){
	dao.add(c);			
}
public Commercant edit(Commercant b){
	
	return dao.edit(b);
	
}
public void delete(Integer id){
	dao.delete(id);	
}
public Commercant findById(Integer id){
	return dao.findById(id);
}

public List<Commercant> findAll(){
	return dao.findAll();
	
}

}
