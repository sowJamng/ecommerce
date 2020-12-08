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
 * Facture generated by hbm2java
 */
@Entity
@Table(name = "facture", schema = "public")
public class Facture implements java.io.Serializable {

	private int idfacture;
	private Commande commande;
	private Integer montant;
	private Date datefact;
	private Set<Commande> commandes = new HashSet<Commande>(0);

	public Facture() {
	}

	public Facture(int idfacture) {
		this.idfacture = idfacture;
	}

	public Facture(int idfacture, Commande commande, Integer montant, Date datefact, Set<Commande> commandes) {
		this.idfacture = idfacture;
		this.commande = commande;
		this.montant = montant;
		this.datefact = datefact;
		this.commandes = commandes;
	}

	@Id

	@Column(name = "idfacture", unique = true, nullable = false)
	public int getIdfacture() {
		return this.idfacture;
	}

	public void setIdfacture(int idfacture) {
		this.idfacture = idfacture;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcommande")
	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Column(name = "montant")
	public Integer getMontant() {
		return this.montant;
	}

	public void setMontant(Integer montant) {
		this.montant = montant;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "datefact", length = 13)
	public Date getDatefact() {
		return this.datefact;
	}

	public void setDatefact(Date datefact) {
		this.datefact = datefact;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facture")
	public Set<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

}
