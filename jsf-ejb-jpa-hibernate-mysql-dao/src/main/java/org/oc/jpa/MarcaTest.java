package org.oc.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.oc.domain.MarcaEntity;

public class MarcaTest {
	
	private static final Logger LOGGER = Logger.getLogger(MarcaTest.class);
	
	public static void main(String[] args){
		
		EntityManager em = JPAUtil.getEntityManager();
		
		
		//testGetAllMarcas(em);
		testAdicionarMarca(em);
		//testGetAllMarcas(em);
		
	}

	/**
	 * @param em
	 */
	private static void testGetAllMarcas(final EntityManager em) {
		javax.persistence.Query q = em.createQuery("SELECT m FROM MarcaEntity m", MarcaEntity.class);
		
		@SuppressWarnings("unchecked")
		List<MarcaEntity> marcas = q.getResultList();
		
		if(!marcas.isEmpty()){
			
			System.out.println("Total de Registros da tabela mra = " + marcas.size());
			
			for (MarcaEntity marcaEntity : marcas) {
				System.out.println("marcaEntity.getNome() = " + marcaEntity.getCodigo()+ " -- "+ marcaEntity.getNome());
			}
		}else{
			System.out.println("A lista de marcas está vazia!");
		}
	}
	
	private static void testAdicionarMarca(final EntityManager em){
		
		MarcaEntity marcaEntity = new MarcaEntity();

		
		marcaEntity.setNome("MERCEDES");
		marcaEntity.setDataCriacao(new Date());			
			
		em.getTransaction().begin();

		em.persist(marcaEntity);

		em.getTransaction().commit();

		em.close();
		
		
	}

}
