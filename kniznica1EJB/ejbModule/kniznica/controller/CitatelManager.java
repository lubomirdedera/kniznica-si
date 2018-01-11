package kniznica.controller;

import com.ibm.jpa.web.JPAManager;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;

import kniznica.entities.Citatel;

import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;

import java.util.List;
import javax.persistence.Query;
@Stateless
@LocalBean
@SuppressWarnings("unchecked")
@JPAManager(targetEntity = kniznica.entities.Citatel.class)
public class CitatelManager {

	@PersistenceUnit
	private EntityManagerFactory emf;

	public CitatelManager() {
		
	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public void createCitatel(Citatel citatel) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.persist(citatel);
		} finally {
			em.close();
		}
	}

	@Action(Action.ACTION_TYPE.DELETE)
	public void deleteCitatel(Citatel citatel) throws Exception {
		EntityManager em = getEntityManager();
		try {
			citatel = em.merge(citatel);
			em.remove(citatel);
		} finally {
			em.close();
		}
	}

	@Action(Action.ACTION_TYPE.UPDATE)
	public void updateCitatel(Citatel citatel) throws Exception {
		EntityManager em = getEntityManager();
		try {
			citatel = em.merge(citatel);
		} finally {
			em.close();
		}
	}

	@Action(Action.ACTION_TYPE.FIND)
	public Citatel findCitatelByEcc(int ecc) {
		Citatel citatel = null;
		EntityManager em = getEntityManager();
		try {
			citatel = (Citatel) em.find(Citatel.class, ecc);
		} finally {
			em.close();
		}
		return citatel;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public Citatel getNewCitatel() {

		Citatel citatel = new Citatel();

		return citatel;
	}

	@NamedQueryTarget("Citatel.findByRc")
	public List<Citatel> Citatel_findByRc(long rc) {
		EntityManager em = getEntityManager();
		List<Citatel> results = null;
		try {
			Query query = em.createNamedQuery("Citatel.findByRc");
			query.setParameter("rc", rc);
			results = (List<Citatel>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("Citatel.findByPriezvisko")
	public List<Citatel> Citatel_findByPriezvisko(String priezvisko) {
		EntityManager em = getEntityManager();
		List<Citatel> results = null;
		try {
			Query query = em.createNamedQuery("Citatel.findByPriezvisko");
			query.setParameter("priezvisko", priezvisko);
			results = (List<Citatel>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

	@NamedQueryTarget("Citatel.findAll")
	public List<Citatel> Citatel_findAll() {
		EntityManager em = getEntityManager();
		List<Citatel> results = null;
		try {
			Query query = em.createNamedQuery("Citatel.findAll");
			results = (List<Citatel>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

}