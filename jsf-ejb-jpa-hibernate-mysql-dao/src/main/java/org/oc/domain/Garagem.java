/**
 * 
 */
package org.oc.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ocortez
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Garagem {

	@XmlElement(name = "carro")
	private List<CarroEntity> listaCarros;


	public Garagem() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * Instantiates a new garagem.
	 *
	 * @param listaCarros the lista carros
	 */
	public Garagem(List<CarroEntity> listaCarros) {
		this.setListaCarros(listaCarros);
	}



	/**
	 * @return the listaCarros
	 */
	public List<CarroEntity> getListaCarros() {
		return listaCarros;
	}

	/**
	 * @param listaCarros the listaCarros to set
	 */
	public void setListaCarros(List<CarroEntity> listaCarros) {
		this.listaCarros = listaCarros;
	}

}
