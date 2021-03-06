package model;
// Generated 14 juil. 2019 13:23:45 by Hibernate Tools 4.0.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Categorie generated by hbm2java
 */
@Entity
@Table(name = "categorie", schema = "public")
public class Categorie implements java.io.Serializable {

	private int idcategorie;
	private Integer libelle;
	private Set<Produitt> produitts = new HashSet<Produitt>(0);

	public Categorie() {
	}

	public Categorie(int idcategorie) {
		this.idcategorie = idcategorie;
	}

	public Categorie(int idcategorie, Integer libelle, Set<Produitt> produitts) {
		this.idcategorie = idcategorie;
		this.libelle = libelle;
		this.produitts = produitts;
	}

	@Id

	@Column(name = "idcategorie", unique = true, nullable = false)
	public int getIdcategorie() {
		return this.idcategorie;
	}

	public void setIdcategorie(int idcategorie) {
		this.idcategorie = idcategorie;
	}

	@Column(name = "libelle")
	public Integer getLibelle() {
		return this.libelle;
	}

	public void setLibelle(Integer libelle) {
		this.libelle = libelle;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorie")
	public Set<Produitt> getProduitts() {
		return this.produitts;
	}

	public void setProduitts(Set<Produitt> produitts) {
		this.produitts = produitts;
	}

}
