package kniznica.controller;

import com.ibm.jpa.web.JPAManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import com.ibm.jpa.web.NamedQueryTarget;

import kniznica.entities.Publikacia;

import com.ibm.jpa.web.Action;
import javax.persistence.PersistenceUnit;

import java.util.List;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
@JPAManager(targetEntity = kniznica.entities.Publikacia.class)
public class PublikaciaManager {

	@PersistenceUnit
	private EntityManagerFactory emf;

	public PublikaciaManager() {

	}

	private EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	@Action(Action.ACTION_TYPE.CREATE)
	public void createPublikacia(Publikacia publikacia) throws Exception {
		EntityManager em = getEntityManager();
		try {
			em.persist(publikacia);
		} finally {
			em.close();
		}
	}

	@Action(Action.ACTION_TYPE.DELETE)
	public void deletePublikacia(Publikacia publikacia) throws Exception {
		EntityManager em = getEntityManager();
		try {
			publikacia = em.merge(publikacia);
			em.remove(publikacia);
		} finally {
			em.close();
		}
	}

	@Action(Action.ACTION_TYPE.UPDATE)
	public void updatePublikacia(Publikacia publikacia) throws Exception {
		EntityManager em = getEntityManager();
		try {
			publikacia = em.merge(publikacia);
		} finally {
			em.close();
		}
	}

	@Action(Action.ACTION_TYPE.FIND)
	public Publikacia findPublikaciaByEcp(int ecp) {
		Publikacia publikacia = null;
		EntityManager em = getEntityManager();
		try {
			publikacia = (Publikacia) em.find(Publikacia.class, ecp);
		} finally {
			em.close();
		}
		return publikacia;
	}

	@Action(Action.ACTION_TYPE.NEW)
	public Publikacia getNewPublikacia() {

		Publikacia publikacia = new Publikacia();

		return publikacia;
	}

	@NamedQueryTarget("Publikacia.findAll")
	public List<Publikacia> Publikacia_findAll() {
		EntityManager em = getEntityManager();
		List<Publikacia> results = null;
		try {
			Query query = em.createNamedQuery("Publikacia.findAll");
			results = (List<Publikacia>) query.getResultList();
		} finally {
			em.close();
		}
		return results;
	}

}