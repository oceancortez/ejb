/*
 * 
 */
package org.oc.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.oc.domain.MarcaEntity;
import org.oc.jpa.JPAUtil;

/**
 * @author ocortez
 *
 */
public class MarcaRepositoryDaoImpl implements IMarcaRepositoryDao {

	private EntityManager manager;
	
	private static final Logger LOGGER = Logger.getLogger(MarcaRepositoryDaoImpl.class);

//	public MarcaRepositoryDaoImpl(final EntityManager entityManager) {
//		super(entityManager);
//	}
	
	
	public MarcaRepositoryDaoImpl(){
		this.manager = JPAUtil.getEntityManager();
	}
	
	/* (non-Javadoc)
	 * @see org.oc.dao.CarroRepositoryDao#buscaTodos()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MarcaEntity> buscaTodasMarcas() {

		List<MarcaEntity> marcas = null;
		try {
			LOGGER.info("Entrou no método buscaTodasMarcas");
			final Query query = this.manager.createQuery("SELECT m FROM MarcaEntity m", MarcaEntity.class);

			marcas = query.getResultList();
			
			LOGGER.info("Saiu do método buscaTodasMarcas");
		} catch (Exception e) {
			LOGGER.error("Erro no método buscaTodasMarcas() >>"  + e.getMessage() );
		}
		return marcas;

	}

	@Override
	public void CarroRepositoryDaoImpl(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public Boolean persistMarca(final MarcaEntity marcaEntity) {		
		try {
			LOGGER.info("Entrou no método adicionaMarca() value ["+ marcaEntity.getNome()+"]");	
			this.manager.getTransaction().begin();
			this.manager.persist(marcaEntity);	
			this.manager.getTransaction().commit();
			LOGGER.info("Saiu do método adicionaMarca() value ["+ marcaEntity.getNome()+"]");
			return true;			
		} catch (Exception e) {
			LOGGER.error("Aconteceu um Erro no método adicionaMarca() value ["+ marcaEntity.getNome()+ " >> "  + e.getMessage());
		}
		return false;
	}

	@Override
	public Boolean excluirMarca(MarcaEntity marcaEntity) {
		try {
			LOGGER.info("Entrou no método excluirMarca() value ["+ marcaEntity.getNome()+"]");
			
			this.manager.getTransaction().begin();
			
			this.manager.remove(marcaEntity);
			
			this.manager.getTransaction().commit();
			
			LOGGER.info("Saiu do método excluirMarca() value ["+ marcaEntity.getNome()+"]");
			return true;
			
		} catch (Exception e) {
			LOGGER.error("Aconteceu um Erro no método excluirMarca() value ["+ marcaEntity.getNome()+ " >> "  + e.getMessage());
		}finally{
			this.manager.close();
		}
		return false;
	}

	@Override
	public Boolean alterarMarca(MarcaEntity marcaEntity) {
		try {
			LOGGER.info("Entrou no método alterarMarca() value ["+ marcaEntity.getNome()+"]");
			
			this.manager.merge(marcaEntity);
			
			this.manager.getTransaction().commit();
			
			LOGGER.info("Saiu do método alterarMarca() value ["+ marcaEntity.getNome()+"]");
			return true;
			
		} catch (Exception e) {
			LOGGER.error("Aconteceu um Erro no método alterarMarca() value ["+ marcaEntity.getNome()+ " >> "  + e.getMessage());
		}finally{
			this.manager.close();
		}
		return false;
	}





}
