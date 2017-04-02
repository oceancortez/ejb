package org.oc.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.oc.domain.CarroEntity;
import org.oc.jpa.JPAUtil;

/**
 * @author ocortez
 *
 */
@Stateless
@Local(CarroRepositoryDaoImpl.class)
public class CarroRepositoryDaoImpl implements CarroRepositoryDao {
	
	private EntityManager manager;
	
	public CarroRepositoryDaoImpl() {
		EntityManager em = JPAUtil.getEntityManager();
		this.manager = em;
	}

	/* (non-Javadoc)
	 * @see org.oc.dao.CarroRepositoryDao#buscaTodos()
	 */
	@Override
	public List<CarroEntity> buscaTodos() {
		
		List<CarroEntity> carros = null;
		try {
			
			Query query = this.manager.createQuery("SELECT c FROM CARRO c");
			
			carros = query.getResultList();
			
			manager.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return carros;
		
	}
	
	public void CarroRepositoryDaoImpl(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void adiciona(CarroEntity carro) {
		this.manager.persist(carro);
		
	}

	
	
	
	
}
