package jee.commerce.service;

import java.util.List;

import jee.commerce.dao.DetailsCommandeDao;
import model.Detailscommande;

public class DetailsCommandeService {
DetailsCommandeDao dao = new DetailsCommandeDao();
	
	public void add(Detailscommande c){
		dao.add(c);			
	}
	public Detailscommande edit(Detailscommande b){
		
		return dao.edit(b);
		
	}
	public void delete(int id){
		dao.delete(id);			
	}
	public Detailscommande findById(int id){
		return dao.findById(id);
	}
	
	public List<Detailscommande> findAll(){
		return dao.findAll();
		
	}
}
