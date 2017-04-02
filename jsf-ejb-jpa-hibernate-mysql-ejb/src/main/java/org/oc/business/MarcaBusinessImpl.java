/*
 * 
 */
package org.oc.business;
/*
 * 
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;
import org.oc.dao.IMarcaRepositoryDao;
import org.oc.dao.MarcaRepositoryDaoImpl;
import org.oc.domain.MarcaEntity;
import org.oc.utils.dto.MarcaDTO;
import org.oc.ws.client.marcas.ConsultaMarcasImplWSService;
import org.oc.ws.client.marcas.IConsultaMarcasWS;
import org.springframework.util.CollectionUtils;

/**
 * @author ocortez
 *
 */
@Stateless
public class MarcaBusinessImpl implements IMarcaBusiness {
	
	private static final Logger LOGGER = Logger.getLogger(MarcaBusinessImpl.class);

	@EJB
	private IMarcaRepositoryDao marcaRepositoryDao;
	
	@EJB
	private IConsultaMarcasWS iConsultaMarcasWS;
	
	
	public MarcaBusinessImpl(){
		marcaRepositoryDao = new MarcaRepositoryDaoImpl();
	}
	
	@Override
	public List<MarcaDTO> buscarTodasMarcas() {
		List<MarcaDTO> marcaDTOs = null;
		try {
			
			List<MarcaEntity> marcaEntities = marcaRepositoryDao.buscaTodasMarcas();
			if(marcaEntities != null){
				marcaDTOs = new ArrayList<>();
				LOGGER.info("Entrou no método buscarTodasMarcas");
				for (MarcaEntity marcaEntity : marcaEntities) {
					
					MarcaDTO dto = parseMarcaEntityFromDTO(marcaEntity);
					
					marcaDTOs.add(dto);
				}
				
				LOGGER.info("Saiu do método buscarTodasMarcas");
			}
		} catch (Exception e) {
			LOGGER.error("Erro no método buscarTodasMarcas() >>"  + e.getMessage() );
		}
		return marcaDTOs;
	}

	/**
	 * @param marcaEntity
	 * @return
	 */
	private MarcaDTO parseMarcaEntityFromDTO(final MarcaEntity marcaEntity) {
		final MarcaDTO dto = new MarcaDTO();
		dto.setCodigo(marcaEntity.getCodigo());
		dto.setNome(marcaEntity.getNome());
		dto.setDataCriacao(marcaEntity.getDataCriacao());
		return dto;
	}

	@Override
	public Boolean adicionaMarca(final MarcaDTO marcaDTO) {	
			
		return marcaRepositoryDao.persistMarca(parseMarcaDTOFromEntity(marcaDTO));

	}

	/**
	 * @param marcaDTO
	 */
	private MarcaEntity parseMarcaDTOFromEntity(final MarcaDTO marcaDTO) {
		final MarcaEntity marcaEntity = new MarcaEntity();
		
		marcaEntity.setCodigo(marcaDTO.getCodigo());
		marcaEntity.setNome(marcaDTO.getNome());
		marcaEntity.setDataCriacao(marcaDTO.getDataCriacao());
		
		return marcaEntity;
	}

	@SuppressWarnings("null")
	@Override
	public List<MarcaDTO> buscarTodasMarcasService() {
		// TODO Auto-generated method stub
		IConsultaMarcasWS consultaMarcasImplWSPort = new ConsultaMarcasImplWSService().getConsultaMarcasImplWSPort();
		
	
		if(consultaMarcasImplWSPort == null && CollectionUtils.isEmpty(consultaMarcasImplWSPort.getAllMarcas().getMarca())){
			return null;
		}
		final List<MarcaDTO> marcaDTOs = new ArrayList<>();
		for(Iterator<org.oc.ws.client.marcas.MarcaEntity> mt = consultaMarcasImplWSPort.getAllMarcas().getMarca().iterator(); mt.hasNext();){
			final MarcaDTO dto = parseMarcaEntityClientFromDTO(mt.next());	
			marcaDTOs.add(dto);
		}
		
		return marcaDTOs;
	}

	private MarcaDTO parseMarcaEntityClientFromDTO(org.oc.ws.client.marcas.MarcaEntity next) {
		final MarcaDTO dto = new MarcaDTO();
		dto.setCodigo(next.getCodigo());
		dto.setNome(next.getNome());
		dto.setDataCriacao(new Date(next.getDataCriacao().getTimezone()));
		return dto;
	}

}
