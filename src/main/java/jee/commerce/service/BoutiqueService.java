package jee.commerce.service;

import java.util.List;

import jee.commerce.dao.BoutiqueDao;
import model.Boutique;


public class BoutiqueService {
	
BoutiqueDao dao = new BoutiqueDao();
	

public void add(Boutique c){
	dao.add(c);			
}
public Boutique edit(Boutique b){
	
	return dao.edit(b);
	
}
public void delete(int id){
	dao.delete(id);			
}
public Boutique findById(int id){
	return dao.findById(id);
}

public List<Boutique> findAll(){
	return dao.findAll();
	
}
}
