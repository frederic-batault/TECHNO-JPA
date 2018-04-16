package fr.gtm.domaine;

import java.util.ArrayList;

/**
 * Classe Conseiller herite de la classe Personne
 * @author Stagiaire
 *
 */
public class Conseiller extends Personne {
	
	// Attributs
	
	private int idConseiller;
	private String login;
	private String password;
	private ArrayList<Client> listeClients;
	private int nbClient;
	
	//Constructeurs
	
	public Conseiller(int idConseiller, String nom, String prenom, String login, String password) {
		super(nom,prenom);
		this.idConseiller = idConseiller;
		this.login = login;
		this.password = password;
	}

	/**
	 * Constructeur par defaut
	 */
	public Conseiller() {
		super();
		this.listeClients = new ArrayList<Client>();
	}
	
	public Conseiller(String login, String pwd) {
		super();
		this.login = login;
		this.password = pwd;
		this.listeClients = new ArrayList<Client>();
	}


	/**
	 * Constructeur d'un conseiller sans clients
	 * @param idConseiller
	 * @param login
	 * @param password
	 */
	public Conseiller(String nom,String prenom,int idConseiller, String login, String password) {
		super(nom,prenom);
		this.idConseiller = idConseiller;
		this.login = login;
		this.password = password;
		this.listeClients = new ArrayList<Client>();
	}


	/**
	 * Constructeur complet
	 * 
	 * @param idConseiller
	 * @param login
	 * @param password
	 * @param listeClients
	 * @param nbClient
	 */
	public Conseiller(String nom,String prenom,int idConseiller, String login, String password, ArrayList<Client> listeClients, int nbClient) {
		super(nom,prenom);
		this.idConseiller = idConseiller;
		this.login = login;
		this.password = password;
		this.listeClients = listeClients;
		this.nbClient = nbClient;
		this.listeClients = new ArrayList<Client>();
	}

	//Getters/Setters
	
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


	/**
	 * @return login
	 */
	public String getLogin() {
		return login;
	}


	/**
	 * @param login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}


	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return listeClients
	 */
	public ArrayList<Client> getListeClients() {
		return listeClients;
	}


	/**
	 * @param listeClients to set
	 */
	public void setListeClients(ArrayList<Client> listeClients) {
		this.listeClients = listeClients;
	}


	/**
	 * @return nbClient
	 */
	public int getNbClient() {
		return nbClient;
	}


	/**
	 * @param nbClient to set
	 */
	public void setNbClient(int nbClient) {
		this.nbClient = nbClient;
	}

	
	
	
	
}
