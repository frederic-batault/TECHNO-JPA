package fr.gtm.jpa;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public abstract class JpaDao<ENTITY> extends AbstractDao {

	public void create(ENTITY e) {
		this.executeWithTransaction(new Runnable() {
			@Override
			public void run() {
				JpaDao.this.em.persist(e);
			}
		});
	}

	public void delete(Integer id) {
		this.executeWithTransaction(() -> this.em.remove(this.read(id)));
	}

	private void executeWithTransaction(Runnable task) {
		final EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		try {
			task.run();
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
		}
	}

	public ENTITY read(Class<ENTITY> clazz, Integer id) {
		return this.em.find(clazz, id);
	}

	public abstract ENTITY read(Integer id);

	public void update(ENTITY e) {
		this.executeWithTransaction(() -> this.em.merge(e));
	}
}
