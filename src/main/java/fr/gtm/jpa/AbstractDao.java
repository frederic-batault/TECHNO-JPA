package fr.gtm.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractDao {
	// Partie statique commune à toutes les instances.

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("ProxiBanque");

	public static EntityManager getManager() {
		return AbstractDao.emf.createEntityManager();
	}

	// Fin statique.

	protected EntityManager em;

	public AbstractDao() {
		this.em = AbstractDao.getManager();
	}
}
