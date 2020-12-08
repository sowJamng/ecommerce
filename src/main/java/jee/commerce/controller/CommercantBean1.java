package jee.commerce.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.jboss.logging.Logger;

import jee.commerce.service.CommercantService;
import model.Commercant;

@ManagedBean(name="commercantBean1")
@SessionScoped
public class CommercantBean1 {
	
	private Logger log=Logger.getLogger(CommercantBean.class);
	private CommercantService comserv =new CommercantService();
	private Commercant commercant=new Commercant();
	private Commercant scommercant=new Commercant();
    private String ch;
	private List<Commercant> listeCommercants;

	public CommercantBean1(){
		commercant=new Commercant();
	}
	
	public String  modifier() {
		comserv.edit(this.scommercant);
		return "ajouter.xhtml?faces-redirect=true";
	}
	
	/*Initialiser le "DataTable" avec la liste des commercants
	public void initDataTable() {
		listecommercants = comserv.findAll();

	}*/
	// Récupérer le code commercant à modifier  et initialiser le formulaire avec ses informations
	public void initForm() {
		int id;		
		id = Integer.parseInt(FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap()
				.get("id"));
		Commercant clt =new Commercant();
		clt= comserv.findById(id);

		if (clt!=null)
			this.scommercant = clt;

	}
	
	public Commercant getCommercant() {
		return commercant;
	}
	public void setCommercant(Commercant commercant) {
		this.commercant = commercant;
	}
	
	public List<Commercant> getListeCommercants() {
		return listeCommercants;
	}

	public void setListeCommercants(List<Commercant> listeCommercants) {
		this.listeCommercants = listeCommercants;
	}

	public Commercant getScommercant() {
		return scommercant;
	}

	public void setSCommercant(Commercant scommercant) {
		this.scommercant = scommercant;
	}
	

}
