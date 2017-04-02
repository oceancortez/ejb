package org.oc.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.oc.domain.CarroEntity;

public class CarroTest {
	
	public static void main(String[] args){
		
		EntityManager em = JPAUtil.getEntityManager();
		
		
		javax.persistence.Query q = em.createQuery("SELECT c FROM CarroEntity c ", CarroEntity.class);
		
		@SuppressWarnings("unchecked")
		List<CarroEntity> carros = q.getResultList();
		
		if(!carros.isEmpty()){
		for (CarroEntity carro : carros) {
			System.out.println(carro.getCodigo() + " /" );
		}		
		}
		System.out.println("A lista de carros está vazia!");
		
	}

}
