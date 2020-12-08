package modele;
// Generated 24 sept. 2019 13:48:26 by Hibernate Tools 4.0.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Stock generated by hbm2java
 */
@Entity
@Table(name = "stock", schema = "public")
public class Stock implements java.io.Serializable {

	private int idstock;
	private Integer qtestock;
	private Set produitts = new HashSet(0);

	public Stock() {
	}

	public Stock(int idstock) {
		this.idstock = idstock;
	}

	public Stock(int idstock, Integer qtestock, Set produitts) {
		this.idstock = idstock;
		this.qtestock = qtestock;
		this.produitts = produitts;
	}

	@Id

	@Column(name = "idstock", unique = true, nullable = false)
	public int getIdstock() {
		return this.idstock;
	}

	public void setIdstock(int idstock) {
		this.idstock = idstock;
	}

	@Column(name = "qtestock")
	public Integer getQtestock() {
		return this.qtestock;
	}

	public void setQtestock(Integer qtestock) {
		this.qtestock = qtestock;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
	public Set getProduitts() {
		return this.produitts;
	}

	public void setProduitts(Set produitts) {
		this.produitts = produitts;
	}

}
