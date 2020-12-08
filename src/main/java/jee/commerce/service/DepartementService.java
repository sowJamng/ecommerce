package jee.commerce.service;

import java.util.List;

import jee.commerce.dao.DepartementDao;
import model.Departement;

public class DepartementService {
DepartementDao dao = new DepartementDao();
	
	public void add(Departement c){
		dao.add(c);			
	}
	public Departement edit(Departement b){
		
		return dao.edit(b);
		
	}
	public void delete(int id){
		dao.delete(id);			
	}
	public Departement findById(int id){
		return dao.findById(id);
	}
	
	public List<Departement> findAll(){
		return dao.findAll();
		
	}
}
