package jee.commerce.service;

import java.util.List;

import jee.commerce.dao.CommuneDao;
import model.Commune;

public class CommuneService {
CommuneDao dao = new CommuneDao();
	
	public void add(Commune c){
		dao.add(c);			
	}
	public Commune edit(Commune b){
		
		return dao.edit(b);
		
	}
	public void delete(int id){
		dao.delete(id);			
	}
	public Commune findById(int id){
		return dao.findById(id);
	}
	
	public List<Commune> findAll(){
		return dao.findAll();
		
	}
}
