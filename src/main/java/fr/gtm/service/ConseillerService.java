package fr.gtm.service;

import fr.gtm.dao.ConseillerDao;
import fr.gtm.domaine.Conseiller;

public class ConseillerService {
	
	private ConseillerDao daoC = new ConseillerDao();
	
	/**
	 * methode pour afficher un conseiller
	 * @param c
	 * @return
	 */
	public Conseiller getConseiller(Conseiller c) {
		c = this.daoC.getConseiller(c);
		return c;
	}
	
}
