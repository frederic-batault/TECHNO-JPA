package fr.gtm.service;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.Compte;
import fr.gtm.jpa.CompteDao;

public class CompteService {

	CompteDao dao = new CompteDao();

	/**
	 * methode qui nous permet de creer un compte courant
	 *
	 * @param leCompteCourant
	 * @return
	 */
	public boolean createCompteCourant(Compte leCompteCourant) {
		this.dao.create(leCompteCourant);
		return true; // retour de la reponse
	}

	/**
	 * Methode pour crediter un compte courant
	 *
	 * @param monCompte
	 *            Un compte courant de classe CompteCourant
	 * @param montant
	 *            Le montant a crediter
	 */
	public Compte crediterCompteCourant(Compte monCompteCourant,
			float montant) {
		float solde = monCompteCourant.getSolde();
		float nouveauSolde = solde + montant;
		monCompteCourant.setSolde(nouveauSolde);
		this.dao.update(monCompteCourant);
		return monCompteCourant;

	}

	/**
	 * Methode pour debiter un compte Courant
	 *
	 * @param monCompteCourant
	 *            Un compte de classe CompteCourant
	 * @param montant
	 *            Le montant a debiter
	 */
	public boolean debiterCompteCourant(Compte monCompteCourant,
			float montant) {
		float solde = monCompteCourant.getSolde();
		float nouveauSolde = solde - montant;
		float autoDecouv = monCompteCourant.getDecouvert();
		if (nouveauSolde >= -autoDecouv) {
			monCompteCourant.setSolde(nouveauSolde);
			this.dao.update(monCompteCourant);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * methode qui nous permet de supprimer un compte courant
	 *
	 * @param leCompteCourant
	 * @return
	 */
	public boolean deleteCompteCourant(Compte leCompteCourant) {
		this.dao.delete(leCompteCourant.getIdCompte());
		return true; // retour de la r�ponse
	}

	/**
	 * methode qui nous permet d'afficher un compte courant
	 *
	 * @param c
	 * @return
	 */
	public Compte getCompteCourant(Client c) {
		Compte leCompteCourant = this.dao.read(1);
		return leCompteCourant;
	}

	/**
	 * methode qui nous permet de mettre a jour un compte courant
	 *
	 * @param leCompteCourant
	 * @return
	 */
	public Compte updateCCompteCourant(Compte leCompteCourant) {
		this.dao.update(leCompteCourant);
		return leCompteCourant;
	}

	/**
	 * methode qui nous permet de mettre a jour le solde apres virement
	 *
	 * @param leCompteCourant
	 * @param montant
	 * @return
	 */
	public float updateSolde(Compte leCompteCourant, float montant) {
		this.dao.update(leCompteCourant);
		return leCompteCourant.getSolde();
	}
}
