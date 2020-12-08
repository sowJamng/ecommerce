package jee.commerce.service;

import java.util.List;

import jee.commerce.dao.ProduitDao;
import jee.commerce.dao.QuartierDao;
import model.Quartier;

public class QuartierService {
QuartierDao dao = new QuartierDao();
	
	public void add(Quartier c){
		dao.add(c);			
	}
	public Quartier edit(Quartier b){
		
		return dao.edit(b);
		
	}
	public void delete(int id){
		dao.delete(id);			
	}
	public Quartier findById(int id){
		return dao.findById(id);
	}
	
	public List<Quartier> findAll(){
		return dao.findAll();
		
	}
}
