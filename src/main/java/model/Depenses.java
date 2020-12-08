package model;
// Generated 14 juil. 2019 13:23:45 by Hibernate Tools 4.0.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Depenses generated by hbm2java
 */
@Entity
@Table(name = "depenses", schema = "public")
public class Depenses implements java.io.Serializable {

	private int iddepense;
	private Commercant commercant;
	private Produitt produitt;
	private Integer datedepense;
	private Integer montant;

	public Depenses() {
	}

	public Depenses(int iddepense, Commercant commercant, Produitt produitt) {
		this.iddepense = iddepense;
		this.commercant = commercant;
		this.produitt = produitt;
	}

	public Depenses(int iddepense, Commercant commercant, Produitt produitt, Integer datedepense, Integer montant) {
		this.iddepense = iddepense;
		this.commercant = commercant;
		this.produitt = produitt;
		this.datedepense = datedepense;
		this.montant = montant;
	}

	@Id

	@Column(name = "iddepense", unique = true, nullable = false)
	public int getIddepense() {
		return this.iddepense;
	}

	public void setIddepense(int iddepense) {
		this.iddepense = iddepense;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcommercant", nullable = false)
	public Commercant getCommercant() {
		return this.commercant;
	}

	public void setCommercant(Commercant commercant) {
		this.commercant = commercant;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproduct", nullable = false)
	public Produitt getProduitt() {
		return this.produitt;
	}

	public void setProduitt(Produitt produitt) {
		this.produitt = produitt;
	}

	@Column(name = "datedepense")
	public Integer getDatedepense() {
		return this.datedepense;
	}

	public void setDatedepense(Integer datedepense) {
		this.datedepense = datedepense;
	}

	@Column(name = "montant")
	public Integer getMontant() {
		return this.montant;
	}

	public void setMontant(Integer montant) {
		this.montant = montant;
	}

}
