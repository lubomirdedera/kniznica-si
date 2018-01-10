package kniznica.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the "Vypozicka" database table.
 * 
 */
@Entity
@Table(name = "\"Vypozicka\"")
@NamedQuery(name = "Vypozicka.findAll", query = "SELECT v FROM Vypozicka v")
public class Vypozicka implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VypozickaPK id;

	@Temporal(TemporalType.DATE)
	@Column(name = "\"datumVypozicky\"")
	private Date datumVypozicky;

	@Temporal(TemporalType.DATE)
	@Column(name = "\"terminVratenia\"")
	private Date terminVratenia;

	//bi-directional many-to-one association to Citatel
	@ManyToOne
	@JoinColumns({})
	private Citatel citatel;

	//bi-directional many-to-one association to Publikacia
	@ManyToOne
	@JoinColumns({})
	private Publikacia publikacia;

	public Vypozicka() {
	}

	public VypozickaPK getId() {
		return this.id;
	}

	public void setId(VypozickaPK id) {
		this.id = id;
	}

	public Date getDatumVypozicky() {
		return this.datumVypozicky;
	}

	public void setDatumVypozicky(Date datumVypozicky) {
		this.datumVypozicky = datumVypozicky;
	}

	public Date getTerminVratenia() {
		return this.terminVratenia;
	}

	public void setTerminVratenia(Date terminVratenia) {
		this.terminVratenia = terminVratenia;
	}

	public Citatel getCitatel() {
		return this.citatel;
	}

	public void setCitatel(Citatel citatel) {
		this.citatel = citatel;
	}

	public Publikacia getPublikacia() {
		return this.publikacia;
	}

	public void setPublikacia(Publikacia publikacia) {
		this.publikacia = publikacia;
	}

}