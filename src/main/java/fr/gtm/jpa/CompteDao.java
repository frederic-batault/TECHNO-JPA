package fr.gtm.jpa;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import fr.gtm.domaine.Compte;

public class CompteDao extends AbstractDao {

	public void create(Compte compte) {
		final EntityTransaction tx = this.em.getTransaction();
		// Début transaction.
		tx.begin();
		try {
			// Méthode de l'entity manager permettant de créer une nouvelle
			// entité (etat 'new').
			this.em.persist(compte);
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
			// Récupération de l'objet compte géré par l'entity manager.
			final Compte toDelete = this.read(id);
			// Suppression de l'entité gérée.
			this.em.remove(toDelete);
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
		}
	}

	public Compte read(Integer id) {
		return this.em.find(Compte.class, id);
	}

	public void update(Compte compte) {
		final EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		try {
			this.em.persist(compte);
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
		}
	}
}
