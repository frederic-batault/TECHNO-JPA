package fr.gtm.jpa;

import java.util.List;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.Conseiller;

public class ClientDao extends JpaDao<Client> {

	public List<Client> getAllClient(Conseiller c) {
		return this.em.createNamedQuery("getClients", Client.class)
				.setParameter("idConseiller", c.getIdConseiller())
				.getResultList();
	}

	@Override
	public Client read(Integer id) {
		return this.read(Client.class, id);
	}

}
