package jee.commerce.service;

import java.util.List;

import jee.commerce.dao.ProduitDao;

import model.Produitt;

public class ProduitService {
ProduitDao dao = new ProduitDao();
	
	public void add(Produitt c){
		dao.add(c);			
	}
	public Produitt edit(Produitt b){
		
		return dao.edit(b);
		
	}
	public void delete(int id){
		dao.delete(id);			
	}
	public Produitt findById(int id){
		return dao.findById(id);
	}
	
	public List<Produitt> findAll(){
		return dao.findAll();
		
	}
}
