package kniznica.controller;

import com.ibm.jpa.web.JPAManager;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;
import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;
import kniznica.entities.Vypozicka;
import kniznica.entities.VypozickaPK;
import java.util.List;
import javax.persistence.Query;
@Stateless
@LocalBean
@SuppressWarnings("unchecked")
@JPAManager(targetEntity = kniznica.entities.Vypozicka.class)
public class VypozickaManager {

	@PersistenceUnit
	private EntityManagerFactory emf;

	public VypozickaManager() {
		
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public void createVypozicka(Vypozicka vypozicka) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.persist(vypozicka);
		} finally {
			em.close();
		}
	}

	@Action(Action.ACTION_TYPE.DELETE)
	public void deleteVypozicka(Vypozicka vypozicka) throws Exception {
		EntityManager em = getEntityManager();
		try {
			vypozicka = em.merge(vypozicka);
			em.remove(vypozicka);
		} finally {
			em.close();
		}
	}

	@Action(Action.ACTION_TYPE.UPDATE)
	public void updateVypozicka(Vypozicka vypozicka) throws Exception {
		EntityManager em = getEntityManager();
		try {
			vypozicka = em.merge(vypozicka);
		} finally {
			em.close();
		}
	}

	@Action(Action.ACTION_TYPE.FIND)
	public Vypozicka findVypozickaByPrimaryKey(int ecc, int ecp) {
		Vypozicka vypozicka = null;
		EntityManager em = getEntityManager();
		VypozickaPK pk = new VypozickaPK();
		pk.setEcc(ecc);
		pk.setEcp(ecp);
		try {
			vypozicka = (Vypozicka) em.find(Vypozicka.class, pk);
		} finally {
			em.close();
		}
		return vypozicka;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public Vypozicka getNewVypozicka() {

		Vypozicka vypozicka = new Vypozicka();

		VypozickaPK id = new VypozickaPK();
		vypozicka.setId(id);

		return vypozicka;
	}

	@NamedQueryTarget("Vypozicka.findByEcp")
	public List<Vypozicka> Vypozicka_findByEcp(int ecp) {
		EntityManager em = getEntityManager();
		List<Vypozicka> results = null;
		try {
			Query query = em.createNamedQuery("Vypozicka.findByEcp");
			query.setParameter("ecp", ecp);
			results = (List<Vypozicka>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("Vypocicka.findByEcc")
	public List<Vypozicka> Vypocicka_findByEcc(int ecc) {
		EntityManager em = getEntityManager();
		List<Vypozicka> results = null;
		try {
			Query query = em.createNamedQuery("Vypocicka.findByEcc");
			query.setParameter("ecc", ecc);
			results = (List<Vypozicka>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("Vypozicka.findAll")
	public List<Vypozicka> Vypozicka_findAll() {
		EntityManager em = getEntityManager();
		List<Vypozicka> results = null;
		try {
			Query query = em.createNamedQuery("Vypozicka.findAll");
			results = (List<Vypozicka>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

}