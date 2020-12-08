package model;
// Generated 14 juil. 2019 13:23:45 by Hibernate Tools 4.0.1.Final

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

/**
 * Commune generated by hbm2java
 */
@Entity
@Table(name = "commune", schema = "public")
public class Commune implements java.io.Serializable {

	private int idcommune;
	private Region region;
	private Integer nom;
	private Set<Departement> departements = new HashSet<Departement>(0);

	public Commune() {
	}

	public Commune(int idcommune, Region region) {
		this.idcommune = idcommune;
		this.region = region;
	}

	public Commune(int idcommune, Region region, Integer nom, Set<Departement> departements) {
		this.idcommune = idcommune;
		this.region = region;
		this.nom = nom;
		this.departements = departements;
	}

	@Id

	@Column(name = "idcommune", unique = true, nullable = false)
	public int getIdcommune() {
		return this.idcommune;
	}

	public void setIdcommune(int idcommune) {
		this.idcommune = idcommune;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idregion", nullable = false)
	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Column(name = "nom")
	public Integer getNom() {
		return this.nom;
	}

	public void setNom(Integer nom) {
		this.nom = nom;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "commune")
	public Set<Departement> getDepartements() {
		return this.departements;
	}

	public void setDepartements(Set<Departement> departements) {
		this.departements = departements;
	}

}