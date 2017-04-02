/*
 * 
 */
package org.oc.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ocortez
 *
 */

public class CarroForm implements Serializable {

	private static final long serialVersionUID = 30349317438787713L;


	private Long codigo;
	
	private String nomeMarca;
	
	private String nomeModelo;
	
	private String nomeVersao;
	
	private String nomeAnoVersao;
	
	private Date dataCriacao;

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nomeMarca
	 */
	public String getNomeMarca() {
		return nomeMarca;
	}

	/**
	 * @param nomeMarca the nomeMarca to set
	 */
	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	/**
	 * @return the nomeModelo
	 */
	public String getNomeModelo() {
		return nomeModelo;
	}

	/**
	 * @param nomeModelo the nomeModelo to set
	 */
	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

	/**
	 * @return the nomeVersao
	 */
	public String getNomeVersao() {
		return nomeVersao;
	}

	/**
	 * @param nomeVersao the nomeVersao to set
	 */
	public void setNomeVersao(String nomeVersao) {
		this.nomeVersao = nomeVersao;
	}

	/**
	 * @return the nomeAnoVersao
	 */
	public String getNomeAnoVersao() {
		return nomeAnoVersao;
	}

	/**
	 * @param nomeAnoVersao the nomeAnoVersao to set
	 */
	public void setNomeAnoVersao(String nomeAnoVersao) {
		this.nomeAnoVersao = nomeAnoVersao;
	}

	/**
	 * @return the dataCriacao
	 */
	public Date getDataCriacao() {
		return dataCriacao;
	}

	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

} 