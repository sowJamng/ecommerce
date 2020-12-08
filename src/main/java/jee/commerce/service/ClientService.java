package jee.commerce.service;

import java.util.List;

import jee.commerce.dao.ClientDao;
import model.Client;

public class ClientService {
ClientDao dao = new ClientDao();
	
	public void add(Client c){
		dao.add(c);			
	}
	public Client edit(Client b){
		
		return dao.edit(b);
		
	}
	public void delete(int id){
		dao.delete(id);			
	}
	public Client findById(int id){
		return dao.findById(id);
	}
	
	public List<Client> findAll(){
		return dao.findAll();
		
	}
}
