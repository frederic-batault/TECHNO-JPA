package fr.gtm.jpa;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.Conseiller;

public class ClientDao extends AbstractDao {

	public void create(Client client) {
		final EntityTransaction tx = this.em.getTransaction();
		// Début transaction.
		tx.begin();
		try {
			// Méthode de l'entity manager permettant de créer une nouvelle
			// entité (etat 'new').
			this.em.persist(client);
			// Fin transaction - COMMIT en base de données.
			tx.commit();
		} catch (PersistenceException e) {
			// Seulement si pas de librairie de log car sort uniquement sur la
			// sortie standard -> e.printStackTrace();
			tx.rollback();
		}
	}

	public void delete(Integer id) {
		final EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		try {
			// Récupération de l'objet client géré par l'entity manager.
			final Client toDelete = this.read(id);
			// Suppression de l'entité gérée.
			this.em.remove(toDelete);
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
		}
	}

	public List<Client> getAllClient(Conseiller c) {
		return this.em.createNamedQuery("getClients", Client.class)
				.setParameter("idConseiller", c.getIdConseiller())
				.getResultList();
	}

	public Client read(Integer id) {
		return this.em.find(Client.class, id);
	}

	public void update(Client client) {
		final EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		try {
			this.em.persist(client);
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
		}
	}
}
