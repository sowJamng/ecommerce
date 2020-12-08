package jee.commerce.service;

import java.util.List;

import jee.commerce.dao.ConditionnementDao;
import model.Conditionnement;

public class ConditionnmentService {
ConditionnementDao dao = new ConditionnementDao();
	
	public void add(Conditionnement c){
		dao.add(c);			
	}
	public Conditionnement edit(Conditionnement b){
		
		return dao.edit(b);
		
	}
	public void delete(int id){
		dao.delete(id);			
	}
	public Conditionnement findById(int id){
		return dao.findById(id);
	}
	
	public List<Conditionnement> findAll(){
		return dao.findAll();
		
	}
}
