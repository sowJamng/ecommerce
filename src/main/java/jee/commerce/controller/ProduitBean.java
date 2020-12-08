package jee.commerce.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.jboss.logging.Logger;

import jee.commerce.dao.ProduitDao;
import jee.commerce.service.ProduitService;
import jee.commerce.service.ProduitService;
import model.Produitt;

public class ProduitBean {
	private static final long serialVersionUID = 1L;
	private Logger log=Logger.getLogger(ProduitBean.class);
	private Produitt produit;
	private List<Produitt> produits=new ArrayList<Produitt>();
	public ProduitBean() {
		
		produit=new Produitt();
	}
	 public void addProduit() throws IOException{
		 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			  log.error("call add");
			  new ProduitService().add(produit);
			  System.out.println("ajout effectue");
			//ec.redirect("liste-Produit.xhtml");
		  }
	 public void ajoutProduit(){
			/*  if("".equalsIgnoreCase(nom)){
				  FacesContext.getCurrentInstance().addMessage(nom, new FacesMessage("le nom est vide "));
			  }else
			  {  */
			  log.error("call add");
			  new ProduitService().add(produit);
			  System.out.println("ajout effectue");
			  //}
		  }
	 public void deleteProduit(int id){
			  log.error("call delete");
			  new ProduitService().delete(id);
			  System.out.println("ajout effectue");
		  }
	 public void editProduit(){
		 log.error("call edite");
		 new ProduitService().edit(produit);
		 System.out.println("ajout effectue");
		 
	 }
	public void lister()
	{
		       //Produits=new ProduitImplMetier().getAllProduit();
		      // Produits=new ProduitDao().findAll();
		log.error("call findAll");
		 new ProduitService().findAll();
		 System.out.println("findAll called avec succees ");	
		 
	}
	public void rechercher(int id){
		log.error("rechercher called");
		new ProduitService().findById(id);
		System.out.println("findAll called avec succees ");
	}
	
	public Produitt getProduit() {
		return produit;
	}
	public void setProduit(Produitt produit) {
		this.produit = produit;
	}
	
	public List<Produitt> getProduits() {
		return produits;
	}

	public void setProduits(List<Produitt> produits) {
		this.produits = produits;
	}
}
