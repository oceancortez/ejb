/**
 * 
 */
package org.oc.ws.marca;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.oc.dao.IMarcaRepositoryDao;
import org.oc.dao.MarcaRepositoryDaoImpl;
import org.oc.domain.MarcaEntity;
import org.oc.ws.marca.type.MarcaType;

/**
 * @author ocortez
 *
 */
@WebService(endpointInterface = "org.oc.ws.marca.IConsultaMarcasWS")
public class ConsultaMarcasImplWS implements IConsultaMarcasWS {
	
	public static final Logger LOGGER = Logger.getLogger(ConsultaMarcasImplWS.class);
	
	@EJB
	private IMarcaRepositoryDao marcaRepositoryDao;
	
	
	public ConsultaMarcasImplWS(){
		marcaRepositoryDao = new MarcaRepositoryDaoImpl();
	}
	
	@Override
	public MarcaType getAllMarcas(){
		//ArrayList<MarcaEntity> marcaEntities = new ArrayList<>();
		MarcaType marcaType = new MarcaType();
		try {
			LOGGER.info("Entrou no método getAllMarcas()");
			List<MarcaEntity> me = new ArrayList<>();
			me = marcaRepositoryDao.buscaTodasMarcas();
			marcaType.setMarcas(me);
			//marcaEntities.addAll(me);
			for (Iterator<MarcaEntity>  marcaEntity = marcaType.getMarcas().iterator(); marcaEntity.hasNext();) {
				MarcaEntity entity = (MarcaEntity) marcaEntity.next();
				LOGGER.info("marcaEntity = " + entity.getNome());
			}
			LOGGER.info("Saiu no método getAllMarcas()");
		} catch (Exception e) {
			LOGGER.error(new StringBuilder("Erro ao prover o serviço ConsultaMarcasWS.getAllMarcas" + e.getMessage()));
			//return new ArrayList<MarcaEntity>();
		}		
		return marcaType;
		}

	@Override
	public String teste() {
		// TODO Auto-generated method stub
		return "TESTE OK";
	}

}
