package jee.commerce.controller;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import java.util.Date;
import java.util.Map;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;


import jee.commerce.dao.CommercantDao;
import jee.commerce.service.CommercantService;
import model.Commercant;
//import org.jboss.logging.Logger;

@ManagedBean(name="commercantBean")
@SessionScoped
public class CommercantBean {
	//private Logger log=Logger.getLogger(CommercantBean.class);
	private Commercant c;
	public  List<Commercant> commercants;
	List<SelectItem> liste;
	String error="";
	//Boolean showform=false;
	//Integer id;
    CommercantService comserve=new CommercantService();
    /*private  String accordion,tabCourant;
	private boolean isSessionActive=false;
	private static final long serialVersionUID = -6030539178671007104L;*/
	private static final Log log = LogFactory.getLog(CommercantBean.class);
    //private String url;
    Commercant pers;
	private String curentUser;
	private String nomcurentUser;
	public String getCurentUser() {
		return curentUser;
	}

	public void setNomcurentUser(String nomcurentUser) {
		this.nomcurentUser = nomcurentUser;
	}
	public String getNomcurentUser() {
		return nomcurentUser;
	}

	public void setCurentUser(String curentUser) {
		this.curentUser = curentUser;
	}
	public CommercantBean(){
		c=new Commercant();
		commercants=new CommercantService().findAll();
	}
	
	public void  connexion(ActionEvent a) {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		String login = c.getEmail();
		String pwd =   c.getMotpass();
		 pers = CommercantDao.connexion(login, pwd);
		if (pers!=null){
            javax.servlet.http.HttpSession sess=(javax.servlet.http.HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                try {sess.setAttribute("name", pers.getPrenom().trim()+" "+pers.getNom().toUpperCase().trim());
				    sess.setAttribute("c", pers);
				    sess.setAttribute("personne", login.trim());
					sess.setAttribute("user", pers.getPrenom()+ " "+pers.getNom().toUpperCase());
					} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}              
                try {
                	this.setCurentUser(pers.getPrenom());
                	this.setNomcurentUser(pers.getNom());
					ec.redirect("./acceuilcommercant.xhtml?idcommercant="+pers.getIdcommercant());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					try {
						throw e;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		      
                //return pers.getPrenom().trim();
		}
		else{
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur de connexion", "");
		    FacesContext.getCurrentInstance().addMessage(null, msg);
		   // return null;
		}
		//  return null;
	}
	public void connexion2() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		try {
			ec.redirect("login.xhtml");
		} catch (IOException e) {
			
		}
	}
	
	@PostConstruct
	public void InitBean(){
		commercants=new CommercantService().findAll();	
	}
		public String getparam(String name){
			FacesContext fc=FacesContext.getCurrentInstance();  		
			Map<String,String> params=fc.getExternalContext().getRequestParameterMap();
			return params.get(name);		
		}
  public void addCommercant() throws IOException{
	/*  if("".equalsIgnoreCase(nom)){
		  FacesContext.getCurrentInstance().addMessage(nom, new FacesMessage("le nom est vide "));
	  }else
	  {  */
	  ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	  log.error("call add");
	  new CommercantDao().add(c);
	  ec.redirect("./listercommercant.xhtml");
	//return "redirect:listercommercant.xhtml";
	  //ec.redirect("./acceuilcommercant.xhtml?nom="+curentUser);
	  //}
  }
 public void registCommercant(ActionEvent e) throws IOException{
	 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	 
	  		FacesContext fc=FacesContext.getCurrentInstance();  		
	  		Map<String,String> param=fc.getExternalContext().getRequestParameterMap();  		
	  		//log.info("idcommercant :"+param.get("idcommercant"));
	  		//log.info("name :"+param.get("name"));
	  		//Integer in=new Integer(getparam("id"));
	  		ec.redirect("./modifiercommercant.xhtml?idcommercant="+getparam("idcommercant"));
	  		/*c=new CommercantDao().findById(new Integer(getparam("id")));
	  	     System.out.println("modification  de id="+getparam("id"));
	  	    new CommercantDao().edit(c);
	  	    commercants=comserve.findAll();*/
	  	   // ec.redirect("./listercommercant.xhtml");
	  		//?idcommercant="+param.get("id")
  }
  public void deleteCommercantt(ActionEvent e) throws IOException{
	  ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

	  log.error("call delete");
	  FacesContext fc=FacesContext.getCurrentInstance();  		
		Map<String,String> param=fc.getExternalContext().getRequestParameterMap();
		//log.info("idcommercant :"+param.get("idcommercant"));
  		//log.info("name :"+param.get("name"));
		System.out.println("suppression de id="+param.get("idcommercant"));
		new CommercantDao().delete(new Integer(param.get("idcommercant")));
	  commercants=comserve.findAll();
	  ec.redirect("./listercommercant.xhtml");
  }
  public void delete(){
	  try{
		  HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		  
		  if(request.getParameterValues("id")!=null) {
			  System.out.println("sup invoqued");
			  for(String id : request.getParameterValues("id")){
			  new CommercantDao().delete( new Integer(id));
			  }
		  }		
	  }
	 catch (Exception e) {
		this.error=e.getMessage();		
	 }
  }
 public void editCommercant(ActionEvent e)throws IOException{

	 System.out.println("edit");
	ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    log.error("call edite");
    Commercant v=new CommercantDao().findById(new Integer(getparam("idcommercant")));
    System.out.println("modification  de id="+getparam("idcommercant"));
    v.setNom(c.getNom());
    v.setPrenom(c.getPrenom());
   v.setDatenaiss(c.getDatenaiss());
    v.setMotpass(c.getMotpass());
    v.setAdresse(c.getAdresse());
    v.setEmail(c.getEmail());
    v.setTelephone(c.getTelephone());
    c=new CommercantDao().edit(v);
    commercants=new CommercantService().findAll();
    v=null;
    ec.redirect("./listercommercant.xhtml");
    
 }
 
public void lister()
{
       //Commercants=new CommercantImplMetier().getAllCommercant();
      // Commercants=new CommercantDao().findAll();
log.error("call findAll");
 commercants=new CommercantService().findAll();
 System.out.println("findAll called avec succees ");			 
}

public void rechercher(int id){
	
log.error("rechercher called");
new CommercantService().findById(id);
System.out.println("findId called avec succees ");
}
	/*public void saveDate(ActionEvent e){
		log.info("le nom est"+nom);		
		
	}*/
	public List<SelectItem> getListe() {
		return liste;
	}
	public void setListe(List<SelectItem> liste) {
		this.liste = liste;
	}
	public String getErrot() {
		return error;
	}
	public void setError(String e) {
		this.error = e;
	}
	public Commercant getPers() {
		return pers;
	}
	public void setPers(Commercant pers) {
		this.pers = pers;
	}
	public Commercant getC() {
		return c;
	}
	public void setC(Commercant c) {
		this.c = c;
	}
	public List<Commercant> getCommercants() {
		return commercants;
	}
	public void setCommercants(List<Commercant> commercants) {
		this.commercants = commercants;
	}
	public CommercantService getComserve() {
		return comserve;
	}
	public void setComserve(CommercantService comserve){
		this.comserve=comserve;
	}
}
