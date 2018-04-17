package fr.gtm.jpa;

import fr.gtm.domaine.Compte;

public class CompteDao extends JpaDao<Compte> {

	@Override
	public Compte read(Integer id) {
		return this.read(Compte.class, id);
	}

}
