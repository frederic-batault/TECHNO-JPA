package fr.gtm.domaine;

import java.util.List;

/**
 * classe Client herite de la classe Personne
 *
 * @author Stagiaire
 *
 */
public class Client {

	// Attributs
	private String adresse;
	private String codePostal;
	private List<Compte> comptes;
	private Conseiller conseiller;
	private String email;
	private Integer idClient;
	private Integer idConseiller;
	private String nom;
	private String prenom;
	private String ville;

	// Constructeurs

	/**
	 * Constructeur par defaut
	 */
	public Client() {
		super();

	}

	/**
	 * Constructeur complet
	 *
	 * @param nom
	 * @param prenom
	 * @param idClient
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param email
	 */
	public Client(String nom, String prenom, int idClient, String email,
			String adresse, String codePostal, String ville, int idConseiller) {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setIdConseiller(idConseiller);
		this.setIdClient(idClient);
		this.email = email;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;

	}

	/**
	 * @return Adresse
	 */
	public String getAdresse() {
		return this.adresse;
	}

	/**
	 * @return codePostal
	 */
	public String getCodePostal() {
		return this.codePostal;
	}

	public List<Compte> getComptes() {
		return this.comptes;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}

	public Integer getIdClient() {
		return this.idClient;
	}

	public Integer getIdConseiller() {
		return this.idConseiller;
	}

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * @return ville
	 */
	public String getVille() {
		return this.ville;
	}

	/**
	 * @param adresse
	 *            to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @param codePostal
	 *            to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	/**
	 * @param email
	 *            to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public void setIdConseiller(Integer idConseiller) {
		this.idConseiller = idConseiller;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @param ville
	 *            to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

}
