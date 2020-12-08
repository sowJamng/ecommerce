package jee.commerce.service;

import java.util.List;

import jee.commerce.dao.DepensesDao;
import model.Depenses;

public class DepensesService {
DepensesDao dao = new DepensesDao();
	
	public void add(Depenses c){
		dao.add(c);			
	}
	public Depenses edit(Depenses b){
		
		return dao.edit(b);
		
	}
	public void delete(int id){
		dao.delete(id);			
	}
	public Depenses findById(int id){
		return dao.findById(id);
	}
	
	public List<Depenses> findAll(){
		return dao.findAll();
		
	}
}
