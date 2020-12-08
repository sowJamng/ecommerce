package jee.commerce.service;

import java.util.List;

import jee.commerce.dao.ClientvirtuelDao;
import model.Clientvirtuel;

public class ClientvirtuelService {
ClientvirtuelDao dao = new ClientvirtuelDao();
	
	public void add(Clientvirtuel c){
		dao.add(c);			
	}
	public Clientvirtuel edit(Clientvirtuel b){
		
		return dao.edit(b);
		
	}
	public void delete(int id){
		dao.delete(id);			
	}
	public Clientvirtuel findById(int id){
		return dao.findById(id);
	}
	
	public List<Clientvirtuel> findAll(){
		return dao.findAll();
		
	}
}
