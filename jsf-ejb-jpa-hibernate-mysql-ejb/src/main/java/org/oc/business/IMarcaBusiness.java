/*
 * 
 */
package org.oc.business;
/*
 * 
 */

import java.util.List;

import javax.ejb.Local;

import org.oc.utils.dto.MarcaDTO;

/**
 * @author ocortez
 *
 */
@Local
public interface IMarcaBusiness {


	/**
	 * Buscar todas marcas.
	 *
	 * @return the list
	 */
	List<MarcaDTO> buscarTodasMarcas();
	
	/**
	 * @param marcaDTO
	 * @return
	 */
	Boolean adicionaMarca(final MarcaDTO marcaDTO);
	
	/**
	 * Buscar todas marcas client.
	 *
	 * @return the list
	 */
	List<MarcaDTO> buscarTodasMarcasService();
	
	

}
