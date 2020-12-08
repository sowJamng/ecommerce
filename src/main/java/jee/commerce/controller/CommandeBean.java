package jee.commerce.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.jboss.logging.Logger;

import jee.commerce.dao.CommandeDao;
import jee.commerce.service.CommandeService;
import jee.commerce.service.CommandeService;
import model.Commande;
import model.Commande;

public class CommandeBean {
	private static final long serialVersionUID = 1L;
	private Logger log=Logger.getLogger(CommandeBean.class);
	private Commande commande;
	private List<Commande> commandes=new ArrayList<Commande>();
	public CommandeBean() {
		
		commande=new Commande();
	}
	 public void addCommande() throws IOException{
		 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			  log.error("call add");
			  new CommandeService().add(commande);
			  System.out.println("ajout effectue");
			//ec.redirect("liste-Commande.xhtml");
		  }
	 public void ajoutCommandet(){
			/*  if("".equalsIgnoreCase(nom)){
				  FacesContext.getCurrentInstance().addMessage(nom, new FacesMessage("le nom est vide "));
			  }else
			  {  */
			  log.error("call add");
			  new CommandeService().add(commande);
			  System.out.println("ajout effectue");
			  //}
		  }
	 public void deleteCommandet(int id){
			  log.error("call delete");
			  new CommandeService().delete(id);
			  System.out.println("ajout effectue");
		  }
	 public void editCommande(){
		 log.error("call edite");
		 new CommandeService().edit(commande);
		 System.out.println("ajout effectue");
		 
	 }
	public void lister()
	{
		       //Commandes=new CommandeImplMetier().getAllCommande();
		      // Commandes=new CommandeDao().findAll();
		log.error("call findAll");
		 commandes=new CommandeService().findAll();
		 System.out.println("findAll called avec succees ");	
		 
	}
	public void rechercher(int id){
		log.error("rechercher called");
		new CommandeService().findById(id);
		System.out.println("findAll called avec succees ");
	}
	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande Commande) {
		this.commande = Commande;
	}
	
	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> Commandes) {
		this.commandes = Commandes;
	}
}
