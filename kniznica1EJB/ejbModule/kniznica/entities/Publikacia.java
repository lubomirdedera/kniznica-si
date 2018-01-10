package kniznica.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the "Publikacia" database table.
 * 
 */
@Entity
@Table(name = "\"Publikacia\"")
@NamedQuery(name = "Publikacia.findAll", query = "SELECT p FROM Publikacia p")
public class Publikacia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"ecp\"")
	private int ecp;

	@Column(name = "\"autor\"")
	private String autor;

	@Column(name = "\"isbn\"")
	private String isbn;

	@Column(name = "\"jeVypozicane\"")
	private short jeVypozicane;

	@Column(name = "\"nazov\"")
	private String nazov;

	@Column(name = "\"pocetStran\"")
	private int pocetStran;

	@Column(name = "\"rok\"")
	private int rok;

	@Column(name = "\"vydavatel\"")
	private String vydavatel;

	//bi-directional many-to-one association to Vypozicka
	@OneToMany(mappedBy = "publikacia")
	private List<Vypozicka> vypozicka;

	public Publikacia() {
	}

	public int getEcp() {
		return this.ecp;
	}

	public void setEcp(int ecp) {
		this.ecp = ecp;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public short getJeVypozicane() {
		return this.jeVypozicane;
	}

	public void setJeVypozicane(short jeVypozicane) {
		this.jeVypozicane = jeVypozicane;
	}

	public String getNazov() {
		return this.nazov;
	}

	public void setNazov(String nazov) {
		this.nazov = nazov;
	}

	public int getPocetStran() {
		return this.pocetStran;
	}

	public void setPocetStran(int pocetStran) {
		this.pocetStran = pocetStran;
	}

	public int getRok() {
		return this.rok;
	}

	public void setRok(int rok) {
		this.rok = rok;
	}

	public String getVydavatel() {
		return this.vydavatel;
	}

	public void setVydavatel(String vydavatel) {
		this.vydavatel = vydavatel;
	}

	public List<Vypozicka> getVypozicka() {
		return this.vypozicka;
	}

	public void setVypozicka(List<Vypozicka> vypozicka) {
		this.vypozicka = vypozicka;
	}

}