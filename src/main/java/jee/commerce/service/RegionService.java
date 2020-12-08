package jee.commerce.service;

import java.util.List;

import jee.commerce.dao.ProduitDao;
import jee.commerce.dao.RegionDao;
import model.Region;

public class RegionService {
RegionDao dao = new RegionDao();
	
	public void add(Region c){
		dao.add(c);			
	}
	public Region edit(Region b){
		
		return dao.edit(b);
		
	}
	public void delete(int id){
		dao.delete(id);			
	}
	public Region findById(int id){
		return dao.findById(id);
	}
	
	public List<Region> findAll(){
		return dao.findAll();
		
	}
}
