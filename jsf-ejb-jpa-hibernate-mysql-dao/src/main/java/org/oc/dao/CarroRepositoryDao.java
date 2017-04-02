package org.oc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.oc.domain.CarroEntity;

/**
 * @author ocortez
 *
 */
public interface CarroRepositoryDao {
	
	/**
	 * @return
	 */
	public List<CarroEntity> buscaTodos();

	void CarroRepositoryDaoImpl(EntityManager manager);

	public void adiciona(CarroEntity carro);

}
