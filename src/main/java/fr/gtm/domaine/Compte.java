package fr.gtm.domaine;

import java.io.Serializable;

/**
 * Classe abstraite Compte, dont sont heritees les classes CompteCourant et
 * CompteEpargne
 * 
 * @author Stagiaire
 *
 */
public class Compte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Attributs
	private Integer decouvert;
	private Integer idCompte;
	private String numCompte;
	private Float solde;
	private String dateCreation;
	private Integer idTypeCompte;
	// private Client client;

	/**
	 * Constructeur par defaut
	 */
	public Compte() {
	}

	/**
	 * Constructeur Complet
	 * 
	 * @param numeroCompte
	 * @param solde
	 * @param dateCreation
	 */
	public Compte(String numCompte, float solde, String dateCreation, int idTypeCompte, int idClient) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.idTypeCompte = idTypeCompte;
	}

	public Integer getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(Integer decouvert) {
		this.decouvert = decouvert;
	}

	public Integer getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Integer idCompte) {
		this.idCompte = idCompte;
	}

	public String getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(String numCompte) {
		this.numCompte = numCompte;
	}

	public Float getSolde() {
		return solde;
	}

	public void setSolde(Float solde) {
		this.solde = solde;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Integer getIdTypeCompte() {
		return idTypeCompte;
	}

	public void setIdTypeCompte(Integer idTypeCompte) {
		this.idTypeCompte = idTypeCompte;
	}

}
