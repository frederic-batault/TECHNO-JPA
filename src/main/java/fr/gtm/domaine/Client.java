package fr.gtm.domaine;

/**
 * classe Client herite de la classe Personne
 * 
 * @author Stagiaire
 *
 */
public class Client extends Personne {

	// Attributs

	private int idClient;
	private String email;
	private String adresse;
	private String codePostal;
	private String ville;
	private int idConseiller;

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
	public Client(String nom, String prenom, int idClient, String email, String adresse, String codePostal,
			String ville, int idConseiller) {
		super(nom, prenom);
		this.idConseiller=idConseiller;
		this.idClient = idClient;
		this.email = email;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;

	}

	// Getters/Setters
	/**
	 * @return idClient
	 */
	public int getIdClient() {
		return idClient;
	}

	/**
	 * @param idClient to set
	 */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	/**
	 * @return Adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param adresse
	 *            to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal
	 *            to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville
	 *            to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return idConseiller
	 */
	public int getIdConseiller() {
		return idConseiller;
	}

	/**
	 * @param idConseiller to set
	 */
	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	
	
}
