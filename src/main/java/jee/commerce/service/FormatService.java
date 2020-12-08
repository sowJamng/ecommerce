package jee.commerce.service;

import java.util.List;

import jee.commerce.dao.FormatDao;
import model.Format;

public class FormatService {
FormatDao dao = new FormatDao();
	
	public void add(Format c){
		dao.add(c);			
	}
	public Format edit(Format b){
		
		return dao.edit(b);
		
	}
	public void delete(int id){
		dao.delete(id);			
	}
	public Format findById(int id){
		return dao.findById(id);
	}
	
	public List<Format> findAll(){
		return dao.findAll();
		
	}
}
