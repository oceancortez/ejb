/**
 * 
 */
package org.oc.ws.marca;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.oc.ws.marca.type.MarcaType;

/**
 * @author ocortez
 *
 */
@WebService
public interface IConsultaMarcasWS {
	
	
	 @WebMethod	
	 MarcaType getAllMarcas();
	 
	 @WebMethod 
	 String teste();

}
