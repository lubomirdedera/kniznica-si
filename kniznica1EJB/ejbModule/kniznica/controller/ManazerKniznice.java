package kniznica.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import kniznica.entities.Citatel;
import kniznica.entities.Publikacia;
import kniznica.entities.Vypozicka;
import kniznica.controller.CitatelManager;
import kniznica.controller.PublikaciaManager;
import kniznica.controller.VypozickaManager;

/**
 * Session Bean implementation class ManazerKniznice
 */
@Stateless
@LocalBean
public class ManazerKniznice implements ManazerKnizniceFacade {
	@EJB
	private CitatelManager cm;
	@EJB
	private PublikaciaManager pm;
	@EJB
	private VypozickaManager vm;

	/**
	 * Default constructor.
	 */
	public ManazerKniznice() {
		// TODO Auto-generated constructor stub
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kniznica.ManazerKnizniceFacade#vytvorCitatela(kniznicaEJB.Citatel)
	 */
	@Override
	public int vytvorCitatela(Citatel citatel) throws Exception {
		try {
			if (!cm.Citatel_findByRc(citatel.getRc()).isEmpty()) {
				throw new Exception("Èitate¾ s daným rodným èíslom už existuje.");
			}
			cm.createCitatel(citatel);
			zosynchronizujVypozickyCitatela(citatel);
			return citatel.getEcc();
		} catch (Exception e) {
			throw new Exception("Operácia vytvorCitatela zlyhala.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kniznica.ManazerKnizniceFacade#najdiCitatela(int)
	 */
	@Override
	public Citatel najdiCitatela(int ecc) throws Exception {
		try {
			Citatel citatel = cm.findCitatelByEcc(ecc);
			if (citatel != null) {
				zosynchronizujVypozickyCitatela(citatel);
			}
			return citatel;
		} catch (Exception e) {
			throw new Exception("Operácia najdiCitatela zlyhala.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kniznica.ManazerKnizniceFacade#najdiCitatela(java.lang.String)
	 */
	@Override
	public List<Citatel> najdiCitatela(String priezvisko) throws Exception {
		try {
			return cm.Citatel_findByPriezvisko(priezvisko);
		} catch(Exception e) {
			throw new Exception("Operácia najdiCitatela zlyhala.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kniznica.ManazerKnizniceFacade#aktualizujCitatela(kniznicaEJB.Citatel)
	 */
	@Override
	public void aktualizujCitatela(Citatel citatel) throws Exception {
		try {
			cm.updateCitatel(citatel);
		} catch(Exception e) {
			throw new Exception("Operácia aktualizujCitatela zlyhala.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kniznica.ManazerKnizniceFacade#zrusCitatela(kniznicaEJB.Citatel)
	 */
	@Override
	public void zrusCitatela(Citatel citatel) throws Exception {
		try {
			zosynchronizujVypozickyCitatela(citatel);
			if (!citatel.getVypozicky().isEmpty()) {
				throw new Exception("Èitate¾ nemá vrátené všetky výpožièky.");
			} else {
				cm.deleteCitatel(citatel);
			}
		} catch(Exception e) {
			throw new Exception("Operácia zrusCitatela zlyhala.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kniznica.ManazerKnizniceFacade#zaevidujPublikaciu(kniznicaEJB.Publikacia)
	 */
	@Override
	public int zaevidujPublikaciu(Publikacia publikacia) throws Exception {
		try {
			pm.createPublikacia(publikacia);
			zosynchronizujVypozickuPublikacie(publikacia);
			return publikacia.getEcp();
		} catch(Exception e) {
			throw new Exception("Operácia zaevidujPublikaciu zlyhala.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kniznica.ManazerKnizniceFacade#najdiPublikaciu(int)
	 */
	@Override
	public Publikacia najdiPublikaciu(int ecp) throws Exception {
		try {
			Publikacia p = pm.findPublikaciaByEcp(ecp);
			if (p != null) {
				zosynchronizujVypozickuPublikacie(p);
			}
			return p;
		} catch(Exception e) {
			throw new Exception("Operácia najdiPublikaciu zlyhala.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kniznica.ManazerKnizniceFacade#najdiPublikaciu(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<Publikacia> najdiPublikaciu(String autor, String nazov) throws Exception {
		try {
			return pm.Publikacia_find(autor, nazov);
		} catch(Exception e) {
			throw new Exception("Operácia najdiPublikaciu zlyhala.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kniznica.ManazerKnizniceFacade#vyradPublikaciu(kniznicaEJB.Publikacia)
	 */
	@Override
	public void vyradPublikaciu(Publikacia publikacia) throws Exception {
		try {
			if (publikacia.getJeVypozicane() == 1) {
				vratPublikaciu(publikacia);
			}
			pm.deletePublikacia(publikacia);
		} catch(Exception e) {
			throw new Exception("Operácia vyradPublikaciu zlyhala.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kniznica.ManazerKnizniceFacade#vypozicajPublikaciu(kniznicaEJB.Citatel,
	 * kniznicaEJB.Publikacia, int)
	 */
	@Override
	public void vypozicajPublikaciu(Citatel citatel, Publikacia publikacia, int vypozicnaLehota) throws Exception {
		try {
			if (publikacia.getJeVypozicane() == 1) {
				throw new Exception("Publikácia je vypožièaná.");
			} else {
				Vypozicka v = vm.getNewVypozicka();
				if (publikacia.getJeVypozicane() == 1) {
					throw new Exception("Publikacia je vypožièaná.");
				} else {
					v.setCitatel(citatel);
					v.setPublikacia(publikacia);
					Date dnesnyDatum = new Date();
					Date terminVratenia = new Date();
					terminVratenia.setTime(dnesnyDatum.getTime() + vypozicnaLehota * 24L * 60 * 60 * 1000);
					v.setDatumVypozicky(dnesnyDatum);
					v.setTerminVratenia(terminVratenia);
					vm.createVypozicka(v);
					publikacia.setJeVypozicane((short) 1);
					pm.updatePublikacia(publikacia);
				}
			}
		} catch(Exception e) {
			throw new Exception("Operácia vypozicajPublikaciu zlyhala.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kniznica.ManazerKnizniceFacade#vratPublikaciu(kniznicaEJB.Publikacia)
	 */
	@Override
	public void vratPublikaciu(Publikacia publikacia) throws Exception {
		try {
			if (publikacia.getJeVypozicane() == 0) {
				throw new Exception("Publikacia nebola vypožièaná.");
			} else {
				Vypozicka v = vm.Vypozicka_findByEcp(publikacia.getEcp()).get(0);
				vm.deleteVypozicka(v);
				publikacia.setJeVypozicane((short) 0);
				pm.updatePublikacia(publikacia);
			}
		} catch(Exception e) {
			throw new Exception("Operácia vratPublikaciu zlyhala.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kniznica.ManazerKnizniceFacade#najdiVypozickyCitatela(kniznicaEJB.
	 * Citatel)
	 */
	@Override
	public List<Vypozicka> najdiVypozickyCitatela(Citatel citatel) throws Exception {
		try {
			return vm.Vypocicka_findByEcc(citatel.getEcc());
		} catch(Exception e) {
			throw new Exception("Operácia najdiVypozickyCitatela zlyhala.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kniznica.ManazerKnizniceFacade#najdiVypozickuPublikacie(kniznicaEJB.
	 * Publikacia)
	 */
	@Override
	public Vypozicka najdiVypozickuPublikacie(Publikacia publikacia) throws Exception {
		try {
			if (publikacia.getJeVypozicane() == 1) {
				return vm.Vypozicka_findByEcp(publikacia.getEcp()).get(0);
			} else {
				return null;
			}
		} catch(Exception e) {
			throw new Exception("Operácia najdiVypozickuPublikacie zlyhala.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kniznica.ManazerKnizniceFacade#predlzVypozicku(kniznicaEJB.Publikacia,
	 * int)
	 */
	@Override
	public void predlzVypozicku(Publikacia publikacia, int pocetDni) throws Exception {
		try {
			if (publikacia.getJeVypozicane() == 0) {
				throw new Exception("Publikácia nie je vypožièaná.");
			} else {
				Vypozicka v = najdiVypozickuPublikacie(publikacia);
				predlzVypozicku(v, pocetDni);
			}
		} catch(Exception e) {
			throw new Exception("Operácia predlzVypozicku zlyhala.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kniznica.ManazerKnizniceFacade#predlzVypozicku(kniznicaEJB.Vypozicka,
	 * int)
	 */
	@Override
	public void predlzVypozicku(Vypozicka vypozicka, int pocetDni) throws Exception {
		try {
			Date dnesnyDatum = new Date();
			Date terminVratenia = new Date();
			terminVratenia.setTime(dnesnyDatum.getTime() + pocetDni * 24L * 60 * 60 * 1000);

			vypozicka.setTerminVratenia(terminVratenia);
			aktualizujVypozicku(vypozicka);
		} catch(Exception e) {
			throw new Exception("Operácia predlzVypozicku zlyhala.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kniznica.ManazerKnizniceFacade#aktualizujVypozicku(kniznicaEJB.Vypozicka)
	 */
	@Override
	public void aktualizujVypozicku(Vypozicka vypozicka) throws Exception {
		try {
			vm.updateVypozicka(vypozicka);
		} catch(Exception e) {
			throw new Exception("Operácia aktualizujVypozicku zlyhala.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kniznica.ManazerKnizniceFacade#zosynchronizujVypozickyCitatela(
	 * kniznicaEJB.Citatel)
	 */
	@Override
	public void zosynchronizujVypozickyCitatela(Citatel citatel) throws Exception {
		try {
			citatel.setVypozicky(najdiVypozickyCitatela(citatel));
		} catch(Exception e) {
			throw new Exception("Operácia zosynchronizujVypozickyCitatela zlyhala.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kniznica.ManazerKnizniceFacade#zosynchronizujVypozickuPublikacie(
	 * kniznicaEJB.Publikacia)
	 */
	@Override
	public void zosynchronizujVypozickuPublikacie(Publikacia publikacia) throws Exception {
		try {
			publikacia.setVypozicka(vm.Vypozicka_findByEcp(publikacia.getEcp()));
		} catch(Exception e) {
			throw new Exception("Operácia zosynchronizujVypozickuPublikacie zlyhala.");
		}	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kniznica.ManazerKnizniceFacade#najdiVsetkyVypozicky()
	 */
	@Override
	public List<Vypozicka> najdiVsetkyVypozicky() throws Exception {
		try {
			return vm.Vypozicka_findAll();
		} catch(Exception e) {
			throw new Exception("Operácia najdiVsetkyVypozicky zlyhala.");
		}
	}
}
