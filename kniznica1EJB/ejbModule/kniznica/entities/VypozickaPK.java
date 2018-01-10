package kniznica.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the "Vypozicka" database table.
 * 
 */
@Embeddable
public class VypozickaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "\"ecc\"", insertable = false, updatable = false)
	private int ecc;

	@Column(name = "\"ecp\"", insertable = false, updatable = false)
	private int ecp;

	public VypozickaPK() {
	}

	public int getEcc() {
		return this.ecc;
	}

	public void setEcc(int ecc) {
		this.ecc = ecc;
	}

	public int getEcp() {
		return this.ecp;
	}

	public void setEcp(int ecp) {
		this.ecp = ecp;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof VypozickaPK)) {
			return false;
		}
		VypozickaPK castOther = (VypozickaPK) other;
		return (this.ecc == castOther.ecc) && (this.ecp == castOther.ecp);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ecc;
		hash = hash * prime + this.ecp;

		return hash;
	}
}