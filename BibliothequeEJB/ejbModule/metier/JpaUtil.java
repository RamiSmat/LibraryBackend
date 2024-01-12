package metier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
public class JpaUtil {
	@PersistenceContext
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("BibliothequeEJB");
	EntityManager em = emf.createEntityManager();
	public EntityManager getEntitymanager() {
		return em;
	}
	public EntityTransaction getEntityTransaction() {
		return em.getTransaction();
		}
	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
	public void closeEntityManager() {
		 em.close();

	}
}
