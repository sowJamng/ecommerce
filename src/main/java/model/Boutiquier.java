package model;
// Generated 14 juil. 2019 13:23:45 by Hibernate Tools 4.0.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Boutiquier generated by hbm2java
 */
@Entity
@Table(name = "boutiquier", schema = "public")
public class Boutiquier implements java.io.Serializable {

	private int idboutiquier;
	private Commercant commercant;
	private String nom;
	private String prenom;
	private Date datenaiss;
	private String adresse;
	private String telephone;
	private String email;
	private String motpass;
	private Set<Comptevirtuel> comptevirtuels = new HashSet<Comptevirtuel>(0);
	private Set<Compte> comptes = new HashSet<Compte>(0);

	public Boutiquier() {
	}

	public Boutiquier(int idboutiquier, Commercant commercant) {
		this.idboutiquier = idboutiquier;
		this.commercant = commercant;
	}

	public Boutiquier(int idboutiquier, Commercant commercant, String nom, String prenom, Date datenaiss,
			String adresse, String telephone, String email, String motpass, Set<Comptevirtuel> comptevirtuels,
			Set<Compte> comptes) {
		this.idboutiquier = idboutiquier;
		this.commercant = commercant;
		this.nom = nom;
		this.prenom = prenom;
		this.datenaiss = datenaiss;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.motpass = motpass;
		this.comptevirtuels = comptevirtuels;
		this.comptes = comptes;
	}

	@Id

	@Column(name = "idboutiquier", unique = true, nullable = false)
	public int getIdboutiquier() {
		return this.idboutiquier;
	}

	public void setIdboutiquier(int idboutiquier) {
		this.idboutiquier = idboutiquier;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcommercant", nullable = false)
	public Commercant getCommercant() {
		return this.commercant;
	}

	public void setCommercant(Commercant commercant) {
		this.commercant = commercant;
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

	@Column(name = "email", length = 254)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "motpass", length = 254)
	public String getMotpass() {
		return this.motpass;
	}

	public void setMotpass(String motpass) {
		this.motpass = motpass;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "boutiquier")
	public Set<Comptevirtuel> getComptevirtuels() {
		return this.comptevirtuels;
	}

	public void setComptevirtuels(Set<Comptevirtuel> comptevirtuels) {
		this.comptevirtuels = comptevirtuels;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "boutiquier")
	public Set<Compte> getComptes() {
		return this.comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

}
