package jee.commerce.service;

import java.util.List;

import jee.commerce.dao.ComptevirtuelDao;
import model.Comptevirtuel;

public class CompteService {
ComptevirtuelDao dao = new ComptevirtuelDao();
	
	public void add(Comptevirtuel c){
		dao.add(c);			
	}
	public Comptevirtuel edit(Comptevirtuel b){
		
		return dao.edit(b);
		
	}
	public void delete(int id){
		dao.delete(id);			
	}
	public Comptevirtuel findById(int id){
		return dao.findById(id);
	}
	
	public List<Comptevirtuel> findAll(){
		return dao.findAll();
		
	}
}
