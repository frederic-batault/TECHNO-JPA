package fr.gtm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.CompteEpargne;

public class CompteEpargneDao {
	private Statement connect() {
		try {
			// Chargement du driver (dans le pilote)
			Class.forName("com.mysql.jdbc.Driver");

			// Connexion � la base de donnee
			String url = "jdbc:mysql://localhost:3306/proxibanquebdd";
			String login = "root";
			String mdp = "";
			Connection connection = DriverManager.getConnection(url, login, mdp);

			// Pr�paration de la requete
			Statement stmt = connection.createStatement();
			return stmt;
		} catch (ClassNotFoundException e) {
			System.out.println("Probl�me chargement du driver !");
			e.printStackTrace();
			Statement stmt = null;
			return stmt;
		} catch (SQLException e) {
			System.out.println("Probl�me de connexion � la base de donnees !");
			e.printStackTrace();
			Statement stmt = null;
			return stmt;
		}
	}
	
	/**
	 * methode qui nous permet de creer un nouveau compte Epargne dans la base de donnees
	 * @param leCompteEpargne
	 * @return
	 */
	public boolean createCompteEpargne(CompteEpargne leCompteEpargne) {
		boolean reponse = false; // Creation de la variable de sortie
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "INSERT INTO `compte`(`numCompte`,`dateCreation`, `solde`,`idTypeCompte`,`idClient`,`taux`) VALUES ('"
					+ leCompteEpargne.getNumCompte()+ "', '" + leCompteEpargne.getDateCreation() + "', '" + leCompteEpargne.getSolde()+ "', '"
					+ leCompteEpargne.getIdTypeCompte() + "', '" + leCompteEpargne.getIdClient()+ "', " + leCompteEpargne.getTauxRemuneration() + ");";
			int result = stmt.executeUpdate(sql); // Ex�cution de la requ�te
			if (result > 0) { // Lecture des resultats
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; // retour de la r�ponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la cr�ation de Compte Epargne !");
			e.printStackTrace();
			return reponse;
		}
	}

	/**
	 * methode qui nous permet d'afficher un compte epargne dans la base de donnees
	 * @param c
	 * @return
	 */
	public CompteEpargne getCompteEpargne(Client c) {
		CompteEpargne leCompteEpargne = new CompteEpargne();
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "SELECT  `idCompte`, `dateCreation`, `solde`, `idTypeCompte`, `idClient`, `taux` FROM `compte` WHERE idClient = "
					+ c.getIdClient()+" and decouvert is null";
			ResultSet result = stmt.executeQuery(sql); // Ex�cution de la requete
			if(result.first()) {
				leCompteEpargne.setNumCompte(result.getString("idCompte"));// Recuperation des donnees
				leCompteEpargne.setDateCreation(result.getString("dateCreation"));
				leCompteEpargne.setSolde(result.getFloat("solde"));
				leCompteEpargne.setIdTypeCompte(result.getInt("idTypeCompte"));
				leCompteEpargne.setIdClient(result.getInt("idClient"));
				leCompteEpargne.setTauxRemuneration(result.getInt("taux"));
			}
			return leCompteEpargne; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de l'affichage du compte Epargne !");
			e.printStackTrace();
			return leCompteEpargne;
		}
	}

	/**
	 * methode qui nous permet de mettre a jour un compte Epargne dans la base de donnees
	 * @param leCompteEpargne
	 * @return
	 */
	public CompteEpargne updateCompteEpargne(CompteEpargne leCompteEpargne) {
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "UPDATE `compte` SET `numCompte` = '" + leCompteEpargne.getNumCompte() + "', `dateCreation` = '" + leCompteEpargne.getDateCreation()
					+ "', `solde` = " + leCompteEpargne.getSolde() + "', `idTypeCompte` = " + leCompteEpargne.getIdTypeCompte()
					+ "', `idClient` = " + leCompteEpargne.getIdClient() + "', `decouvert` = " + leCompteEpargne.getTauxRemuneration()
					 + " WHERE `idClient` = "
					+ leCompteEpargne.getIdClient();
			int result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) {
				return leCompteEpargne; // retour de la reponse
			} else {
				System.out.println("Un probl�me est survenu lors de la modification du Compte Epargne.");
				return leCompteEpargne;// retour de la reponse
			}
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la modification du Compte Epargne !");
			e.printStackTrace();
			return leCompteEpargne;// retour de la reponse
		}
	}

	/**
	 * methode qui nous permet de supprimer compte Epargne dans la base de donnees
	 * @param leCompteEpargne
	 * @return
	 */
	public boolean deleteCompteEpargne(CompteEpargne leCompteEpargne) {
		boolean reponse = false; // Cr�ation variable de retour
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "DELETE FROM compte WHERE `idClient` = " + leCompteEpargne.getIdClient();

			int result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) { // Lecture des resultats
				reponse = true;
			} else {
				reponse = false;
			}
			return reponse; // retour de la reponse
		} catch (SQLException e) {
			System.out.println("Probl�me lors de la suppression du Compte Epargne !");
			e.printStackTrace();
			return reponse;
		}
	}
	
	/**
	 * methode qui nous permet de mettre à jour un solde apres virement dans la base de donnees
	 * @param leCompteEpargne
	 * @param montant
	 * @return
	 */
	public CompteEpargne updateSolde(CompteEpargne leCompteEpargne) {
		try {
			Statement stmt = this.connect(); // Connexion et preparation de la requete
			String sql = "UPDATE `compte` SET `solde` = '" 	 + leCompteEpargne.getSolde() + "' WHERE `numCompte` = "
					+ leCompteEpargne.getNumCompte();
			float result = stmt.executeUpdate(sql); // Execution de la requete
			if (result > 0) {
				return leCompteEpargne; // retour de la reponse
			} else {
				System.out.println("Un probleme est survenu lors du virement sur le Compte Epargne.");
				return leCompteEpargne;// retour de la reponse
			}
		} catch (SQLException e) {
			System.out.println("Probleme lors du virement !");
			e.printStackTrace();
			return null;// retour de la reponse
		}
	}

}
