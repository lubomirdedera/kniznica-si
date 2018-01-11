package kniznica.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the "Citatel" database table.
 * 
 */
@Entity
@Table(name = "\"Citatel\"")
@NamedQueries({ @NamedQuery(name = "Citatel.findByRc", query = "SELECT c FROM Citatel c WHERE c.rc = :rc"),
		@NamedQuery(name = "Citatel.findByPriezvisko", query = "SELECT c FROM Citatel c WHERE c.priezvisko LIKE :priezvisko ORDER BY c.priezvisko, c.meno"),
		@NamedQuery(name = "Citatel.findAll", query = "SELECT c FROM Citatel c") })
public class Citatel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"ecc\"")
	private int ecc;

	@Column(name = "\"meno\"")
	private String meno;

	@Column(name = "\"mesto\"")
	private String mesto;

	@Column(name = "\"priezvisko\"")
	private String priezvisko;

	@Column(name = "\"psc\"")
	private String psc;

	@Column(name = "\"rc\"")
	private long rc;

	@Column(name = "\"ulica\"")
	private String ulica;

	//bi-directional many-to-one association to Vypozicka
	@OneToMany(mappedBy = "citatel")
	private List<Vypozicka> vypozicky;

	public Citatel() {
	}

	public int getEcc() {
		return this.ecc;
	}

	public void setEcc(int ecc) {
		this.ecc = ecc;
	}

	public String getMeno() {
		return this.meno;
	}

	public void setMeno(String meno) {
		this.meno = meno;
	}

	public String getMesto() {
		return this.mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getPriezvisko() {
		return this.priezvisko;
	}

	public void setPriezvisko(String priezvisko) {
		this.priezvisko = priezvisko;
	}

	public String getPsc() {
		return this.psc;
	}

	public void setPsc(String psc) {
		this.psc = psc;
	}

	public long getRc() {
		return this.rc;
	}

	public void setRc(long rc) {
		this.rc = rc;
	}

	public String getUlica() {
		return this.ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public List<Vypozicka> getVypozicky() {
		return this.vypozicky;
	}

	public void setVypozicky(List<Vypozicka> vypozicky) {
		this.vypozicky = vypozicky;
	}

}