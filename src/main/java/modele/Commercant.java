package modele;
// Generated 24 sept. 2019 13:48:26 by Hibernate Tools 4.0.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Commercant generated by hbm2java
 */
@Entity
@Table(name = "commercant", schema = "public")
public class Commercant implements java.io.Serializable {

	private int idcommercant;
	private String nom;
	private String prenom;
	private Date datenaiss;
	private String email;
	private String adresse;
	private String telephone;
	private String motpass;
	private Set depenseses = new HashSet(0);
	private Set boutiques = new HashSet(0);

	public Commercant() {
	}

	public Commercant(int idcommercant) {
		this.idcommercant = idcommercant;
	}

	public Commercant(int idcommercant, String nom, String prenom, Date datenaiss, String email, String adresse,
			String telephone, String motpass, Set depenseses, Set boutiques) {
		this.idcommercant = idcommercant;
		this.nom = nom;
		this.prenom = prenom;
		this.datenaiss = datenaiss;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
		this.motpass = motpass;
		this.depenseses = depenseses;
		this.boutiques = boutiques;
	}

	@Id

	@Column(name = "idcommercant", unique = true, nullable = false)
	public int getIdcommercant() {
		return this.idcommercant;
	}

	public void setIdcommercant(int idcommercant) {
		this.idcommercant = idcommercant;
	}

	@Column(name = "nom", length = 254)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", length = 254)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "datenaiss", length = 13)
	public Date getDatenaiss() {
		return this.datenaiss;
	}

	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}

	@Column(name = "email", length = 254)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "adresse", length = 254)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "telephone", length = 254)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "motpass", length = 254)
	public String getMotpass() {
		return this.motpass;
	}

	public void setMotpass(String motpass) {
		this.motpass = motpass;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "commercant")
	public Set getDepenseses() {
		return this.depenseses;
	}

	public void setDepenseses(Set depenseses) {
		this.depenseses = depenseses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "commercant")
	public Set getBoutiques() {
		return this.boutiques;
	}

	public void setBoutiques(Set boutiques) {
		this.boutiques = boutiques;
	}

}
