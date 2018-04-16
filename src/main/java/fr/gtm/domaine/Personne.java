package fr.gtm.domaine;

/**Classe abstraite Personne, dont sont heritees les classes Conseiller et Client
 * et Client.
 * @author Stagiaire
 *
 */
public abstract class Personne {

	// Proprietes

	private String nom;
	private String prenom;
	
	// Constructeurs
	
	/**
	 * Constructeur par defaut
	 */
	public Personne() {
		super();
	}

	/**
	 * Constructeur complet 
	 * @param nom
	 * @param prenom
	 */
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	/**
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return le prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 * 
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
}
