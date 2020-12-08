package jee.commerce.service;

import java.util.List;

import jee.commerce.dao.CommandeDao;
import model.Commande;

public class CommandeService {
CommandeDao dao = new CommandeDao();
	
	public void add(Commande c){
		dao.add(c);			
	}
	public Commande edit(Commande b){
		
		return dao.edit(b);
		
	}
	public void delete(int id){
		dao.delete(id);			
	}
	public Commande findById(int id){
		return dao.findById(id);
	}
	
	public List<Commande> findAll(){
		return dao.findAll();
		
	}
}
