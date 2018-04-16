package fr.gtm.service;
import java.util.ArrayList;

import fr.gtm.dao.*;
import fr.gtm.domaine.*;


public class ClientService {

	ClientDao dao = new ClientDao();

	/**
	 * methode qui nous permet de creer un client
	 * @param leClient
	 * @return
	 */
	public boolean createClient(Client leClient) {
		boolean reponse = dao.createClient(leClient);
		return reponse; // retour de la reponse
	}

	/**
	 * methode qui nous permet d'afficher un client
	 * @param leClient
	 * @return
	 */
	public Client getClient(Client leClient) {
		leClient = dao.getClient(leClient);
		return leClient;
	}

	/**
	 * methode qui nous permet de mettre a jour un client
	 * @param leClient
	 * @return
	 */
	public Client updateClient(Client leClient) {
		leClient = dao.updateClient(leClient);
		return leClient;
	}

	/**
	 * methode qui nous permet de supprimer un client
	 * @param leClient
	 * @return
	 */
	public boolean deleteClient(Client leClient) {
		boolean reponse = dao.deleteClient(leClient);
		return reponse; // retour de la réponse
	}

	/**
	 * methode qui nous permet d'afficher une liste de clients
	 * @param c
	 * @return
	 */
	public ArrayList<Client> getAllClient(Conseiller c) {
		ArrayList<Client> listClients = dao.getAllClient(c);
		return listClients;
	}
}


