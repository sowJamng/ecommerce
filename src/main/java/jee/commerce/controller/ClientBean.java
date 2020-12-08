package jee.commerce.controller;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.jboss.logging.Logger;
import jee.commerce.dao.ClientDao;
import jee.commerce.dao.CommercantDao;
import jee.commerce.service.ClientService;
import jee.commerce.service.CommercantService;
import model.*;
@ManagedBean
@SessionScoped
public class ClientBean  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Logger log=Logger.getLogger(ClientBean.class);
	private Client client;
	private List<Client> clients;
	
	public ClientBean() {
		
		client=new Client();
		clients=new ClientService().findAll();
	}
	public String getparam(String name){
		FacesContext fc=FacesContext.getCurrentInstance();  		
		Map<String,String> params=fc.getExternalContext().getRequestParameterMap();
		return params.get(name);		
	}
	@PostConstruct
	public void InitBean(){
		clients=new ClientDao().findAll();
	}
	public void registClient(ActionEvent e) throws IOException{
		 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		 
		  		FacesContext fc=FacesContext.getCurrentInstance();  		
		  		Map<String,String> param=fc.getExternalContext().getRequestParameterMap();  		
		  		ec.redirect("./modifierclient.xhtml?idclient="+getparam("idclient"));
	  }
	
	 
	 public void addClient() throws IOException{
		 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		  log.error("call add");
		  new ClientDao().add(client);
		  clients=new ClientService().findAll();
		  ec.redirect("./listerclient.xhtml");
		  }
	 
	 public void deleteClient(ActionEvent e)throws IOException{
		 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		  log.error("call delete");
		  FacesContext fc=FacesContext.getCurrentInstance();  		
			Map<String,String> param=fc.getExternalContext().getRequestParameterMap();
			System.out.println("suppression de id="+param.get("idclient"));
			new ClientDao().delete(new Integer(param.get("idclient")));
		  clients=new ClientService().findAll();
		  ec.redirect("./listerclient.xhtml");
	  }
	 
	 public void editClient(ActionEvent e)throws IOException{

		 System.out.println("edit");
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    log.error("call edite");
	    Client v=new ClientDao().findById(new Integer(getparam("idclient")));
	    System.out.println("modification  de id="+getparam("idclient"));
	    v.setNom(client.getNom());
	    v.setPrenom(client.getPrenom());
	    v.setDatenaiss(client.getDatenaiss());
	    v.setMotpass(client.getMotpass());
	    v.setAdresse(client.getAdresse());
	    v.setEmail(client.getEmail());
	    v.setTelephone(client.getTelephone());
	    client=new ClientDao().edit(v);
	    clients=new ClientService().findAll();
	    v=null;
	    ec.redirect("./listerclient.xhtml");
	    
	 }
	 
	public void lister()
	{
		       //Clients=new ClientImplMetier().getAllClient();
		      // clients=new ClientDao().findAll();
		log.error("call findAll");
		 new ClientService().findAll();
		 System.out.println("findAll called avec succees ");			 
	}
	
	public void rechercher(int id){
		log.error("rechercher called");
		new ClientService().findById(id);
		System.out.println("findAll called avec succees ");
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
}

