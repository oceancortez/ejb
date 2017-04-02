/*
 * 
 */
package org.oc.bean.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.oc.domain.CarroEntity;
import org.oc.domain.Garagem;
import org.oc.jpa.JPAUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class GaragemWS.
 */
@WebService
public class GaragemWS {


	/** The listar carros garagem. */
	private List<CarroEntity> listarCarrosGaragem = new ArrayList<>();


	/**
	 * Gets the carros garagem.
	 *
	 * @return the carros garagem
	 */
	@WebMethod(operationName = "todosCarrosDaGaragem")
	@WebResult(name = "carros")
	public Garagem getCarrosGaragem(){		

		System.out.println("Chamando o método GaragemWS.getCarrosGaragem()");
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createQuery("SELECT c FROM CARRO c", CarroEntity.class);
		this.listarCarrosGaragem = q.getResultList();			
		em.close();			
		System.out.println("Retorno do método GaragemWS.getCarrosGaragem() size = " + listarCarrosGaragem.size());

		return new Garagem(listarCarrosGaragem);
	}



	/**
	 * Cadastrar carro.
	 *
	 * @param carro the carro
	 * @return the carro
	 * @throws Exception the exception
	 * @throws ExceptionGaragem the exception garagem
	 */
	@WebMethod(operationName = "cadastrarCarro")
	@WebResult(name = "carro")
	public CarroEntity cadastrarCarro(@WebParam(name = "carro") CarroEntity carro) throws Exception, ExceptionGaragem{
		System.out.println("Chamando o método GaragemWS.cadastrarCarro(carro)");

		if(isCarroValido(carro)){
			try{

				EntityManager em = JPAUtil.getEntityManager();

				em.getTransaction().begin();

				em.persist(carro);

				em.getTransaction().commit();

				em.close();

			} catch (Exception e) {
				throw new Exception("Erro no Serviço Cadastrar Carro");
			}

		}

		System.out.println("Fim do método GaragemWS.cadastrarCarro(carro.id) = " + carro.getCodigo());
		return carro;
	}


	/**
	 * Checks if is carro valido.
	 *
	 * @param carro the carro
	 * @return true, if is carro valido
	 * @throws ExceptionGaragem the exception garagem
	 */
	private boolean isCarroValido(CarroEntity carro) throws ExceptionGaragem {
		// TODO Auto-generated method stub
//		if(carro != null && carro.getMarca().isEmpty() && carro.getModelo().isEmpty()){
//
//			throw new ExceptionGaragem("Favor preencher os campos 'Marca', 'Modelo'");
//
//		}else if(carro.getMarca().length() < 3){
//
//			throw new ExceptionGaragem("Marca Inválida");
//
//		}else if(carro.getModelo().length() < 2){
//
//			throw new ExceptionGaragem("Modelo Inválido");
//
//		}
		return true;
	}
}
