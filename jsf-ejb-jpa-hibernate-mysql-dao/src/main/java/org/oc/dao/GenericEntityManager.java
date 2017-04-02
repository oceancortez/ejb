package org.oc.dao;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;

@SuppressWarnings("unchecked")
public class GenericEntityManager {
	
	private EntityManager entityManager;
	

	public GenericEntityManager(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	
	protected EntityManager getEntityManager(){
		return this.entityManager;
	}
	
	public void persist(final Object entity){
		try {
			getEntityManager().persist(entity);
		} catch (EntityExistsException eee) {
			eee.printStackTrace();
		}catch (IllegalStateException ise) {
			ise.printStackTrace();
		}catch (IllegalArgumentException  iae) {
			iae.printStackTrace();
		}catch (TransactionRequiredException tre) {
			tre.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
