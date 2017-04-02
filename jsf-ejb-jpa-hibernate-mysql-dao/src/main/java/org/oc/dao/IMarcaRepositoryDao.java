/*
 * 
 */
package org.oc.dao;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.EntityManager;

import org.oc.domain.CarroEntity;
import org.oc.domain.MarcaEntity;

/**
 * @author ocortez
 *
 */
@Local
public interface IMarcaRepositoryDao {


	/**
	 * Busca todas marcas.
	 *
	 * @return the list
	 */
	 List<MarcaEntity> buscaTodasMarcas();

	/**
	 * Carro repository dao impl.
	 *
	 * @param manager the manager
	 */
	void CarroRepositoryDaoImpl(final EntityManager manager);

	/**
	 * Adiciona marca.
	 *
	 * @param marcaEntity the marca entity
	 * @return the boolean
	 */
	Boolean persistMarca(final MarcaEntity marcaEntity);
	
	Boolean excluirMarca(final MarcaEntity marcaEntity);
	
	Boolean alterarMarca(final MarcaEntity marcaEntity);

}
