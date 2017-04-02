/*
 * 
 */
package org.oc.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;
import org.oc.business.IMarcaBusiness;
import org.oc.business.MarcaBusinessImpl;
import org.oc.utils.dto.MarcaDTO;

/**
 * @author ocortez
 *
 */
@Stateless
public class MarcaFacadeImpl implements IMarcaFacade {
	
	private static final Logger LOGGER = Logger.getLogger(MarcaFacadeImpl.class);
	
	@EJB
	private IMarcaBusiness marcaBusiness;
	
	public  MarcaFacadeImpl() {
		marcaBusiness = new MarcaBusinessImpl();
	}

	@Override
	public List<MarcaDTO> buscarTodasMarcas() {
		
		return marcaBusiness.buscarTodasMarcas();
	}

	@Override
	public Boolean adicionaMarca(MarcaDTO marcaDTO) {
		
		return marcaBusiness.adicionaMarca(marcaDTO);
	}

	@Override
	public List<MarcaDTO> buscarTodasMarcasService() {
		return marcaBusiness.buscarTodasMarcasService();
	}

}
