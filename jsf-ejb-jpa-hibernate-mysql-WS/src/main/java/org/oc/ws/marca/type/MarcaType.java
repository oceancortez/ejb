/**
 * 
 */
package org.oc.ws.marca.type;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.oc.domain.MarcaEntity;

/**
 * @author 579535
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MarcaType {
	
	@XmlElement(name = "marca")
	private List<MarcaEntity> marcas;
	
	
	
	public MarcaType(){
		
	}
	
	
	public MarcaType(ArrayList<MarcaEntity> arrayMarcas){
		setMarcas(arrayMarcas);
	}

	/**
	 * @return the marcas
	 */
	public List<MarcaEntity> getMarcas() {
		return marcas;
	}

	/**
	 * @param marcas the marcas to set
	 */
	public void setMarcas(List<MarcaEntity> marcas) {
		this.marcas = marcas;
	}
	
}
