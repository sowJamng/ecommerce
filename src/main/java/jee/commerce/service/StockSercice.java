package jee.commerce.service;

import java.util.List;

import jee.commerce.dao.StockDao;
import model.Stock;

public class StockSercice {
StockDao dao = new StockDao();
	
	public void add(Stock c){
		dao.add(c);			
	}
	public Stock edit(Stock b){
		
		return dao.edit(b);
		
	}
	public void delete(int id){
		dao.delete(id);			
	}
	public Stock findById(int id){
		return dao.findById(id);
	}
	
	public List<Stock> findAll(){
		return dao.findAll();
		
	}
}
