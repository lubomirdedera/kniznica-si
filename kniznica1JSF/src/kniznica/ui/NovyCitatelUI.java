package kniznica.ui;

import javax.ejb.EJB;

import kniznica.controller.ManazerKnizniceFacade;
import kniznica.entities.Citatel;

public class NovyCitatelUI {
	private String meno = null;
	private String priezvisko = null;
	private String rc;
	private String mesto;
	private String psc;
	private String ulica;
	private Citatel citatel = null;
	private String status = null;;

	@EJB(beanName = "ManazerKniznice")
	ManazerKnizniceFacade mk;

	public String getMeno() {
		return meno;
	}

	public void setMeno(String meno) {
		this.meno = meno;
	}

	public String getPriezvisko() {
		return priezvisko;
	}

	public void setPriezvisko(String priezvisko) {
		this.priezvisko = priezvisko;
	}

	public String getRc() {
		return rc;
	}

	public void setRc(String rc) {
		this.rc = rc;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getPsc() {
		return psc;
	}

	public void setPsc(String psc) {
		this.psc = psc;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String vytvorCitatela() {
		try {
			citatel = new Citatel();
			citatel.setMeno(meno);
			citatel.setPriezvisko(priezvisko);
			citatel.setRc(Long.valueOf(rc));
			citatel.setMesto(mesto);
			citatel.setUlica(ulica);
			citatel.setPsc(psc);
			mk.vytvorCitatela(citatel);
			status = "Èitate¾ bol vytvorený";
		} catch (Exception e) {
			status = e.getMessage();
			return "Chyba";
		}
		return "OK";
	}

}
