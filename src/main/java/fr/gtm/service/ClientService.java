package fr.gtm.service;

import java.util.ArrayList;
import java.util.List;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.Conseiller;
import fr.gtm.jpa.ClientDao;

public class ClientService {

	ClientDao dao = new ClientDao();

	/**
	 * methode qui nous permet de creer un client
	 *
	 * @param leClient
	 * @return
	 */
	public boolean createClient(Client leClient) {
		this.dao.create(leClient);
		return true; // retour de la reponse
	}

	/**
	 * methode qui nous permet de supprimer un client
	 *
	 * @param leClient
	 * @return
	 */
	public boolean deleteClient(Client leClient) {
		this.dao.delete(leClient.getIdClient());
		return true; // retour de la réponse
	}

	/**
	 * methode qui nous permet d'afficher une liste de clients
	 *
	 * @param c
	 * @return
	 */
	public ArrayList<Client> getAllClient(Conseiller c) {
		List<Client> listClients = this.dao.getAllClient(c);
		return (ArrayList<Client>) listClients;
	}

	/**
	 * methode qui nous permet d'afficher un client
	 *
	 * @param leClient
	 * @return
	 */
	public Client getClient(Client leClient) {
		leClient = this.dao.read(leClient.getIdClient());
		return leClient;
	}

	/**
	 * methode qui nous permet de mettre a jour un client
	 *
	 * @param leClient
	 * @return
	 */
	public Client updateClient(Client leClient) {
		this.dao.update(leClient);
		return leClient;
	}
}
