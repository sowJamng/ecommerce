package jee.commerce.service;

import java.util.List;

import jee.commerce.dao.BoutiquierDao;
import model.Boutiquier;

public class BoutiquierService {
	BoutiquierDao dao = new BoutiquierDao();
	

	public void add(Boutiquier c){
		dao.add(c);			
	}
	public Boutiquier edit(Boutiquier b){
		
		return dao.edit(b);
		
	}
	public void delete(int id){
		dao.delete(id);			
	}
	public Boutiquier findById(int id){
		return dao.findById(id);
	}

	public List<Boutiquier> findAll(){
		return dao.findAll();
		
	}
}
