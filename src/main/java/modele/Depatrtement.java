package modele;
// Generated 24 sept. 2019 13:48:26 by Hibernate Tools 4.0.1.Final

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
 * Depatrtement generated by hbm2java
 */
@Entity
@Table(name = "depatrtement", schema = "public")
public class Depatrtement implements java.io.Serializable {

	private int iddepartement;
	private Commune commune;
	private String nom;
	private Set quartiers = new HashSet(0);

	public Depatrtement() {
	}

	public Depatrtement(int iddepartement, Commune commune) {
		this.iddepartement = iddepartement;
		this.commune = commune;
	}

	public Depatrtement(int iddepartement, Commune commune, String nom, Set quartiers) {
		this.iddepartement = iddepartement;
		this.commune = commune;
		this.nom = nom;
		this.quartiers = quartiers;
	}

	@Id

	@Column(name = "iddepartement", unique = true, nullable = false)
	public int getIddepartement() {
		return this.iddepartement;
	}

	public void setIddepartement(int iddepartement) {
		this.iddepartement = iddepartement;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcommune", nullable = false)
	public Commune getCommune() {
		return this.commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	@Column(name = "nom", length = 254)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "depatrtement")
	public Set getQuartiers() {
		return this.quartiers;
	}

	public void setQuartiers(Set quartiers) {
		this.quartiers = quartiers;
	}

}
