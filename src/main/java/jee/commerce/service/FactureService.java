package jee.commerce.service;

import java.util.List;

import jee.commerce.dao.FactureDao;
import model.Facture;

public class FactureService {
FactureDao dao = new FactureDao();
	
	public void add(Facture c){
		dao.add(c);			
	}
	public Facture edit(Facture b){
		
		return dao.edit(b);
		
	}
	public void delete(int id){
		dao.delete(id);			
	}
	public Facture findById(int id){
		return dao.findById(id);
	}
	
	public List<Facture> findAll(){
		return dao.findAll();
		
	}
}
