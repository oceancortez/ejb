package org.oc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ocortez
 *
 */

@XmlRootElement
@Entity
@Table(name = "cro")
public class CarroEntity implements Serializable {

	private static final long serialVersionUID = 30349317438787713L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "crocod")
	private Long codigo;

	@Column(name = "mdocod")
	private String codigoModelo;	

	@Column(name = "crodat")
	private Date dataCriacao;

//	@JoinColumn(name = "mdocod")
//	private ModeloEntity modeloEntity;

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
	 * @return the codigoModelo
	 */
	public String getCodigoModelo() {
		return codigoModelo;
	}

	/**
	 * @param codigoModelo the codigoModelo to set
	 */
	public void setCodigoModelo(String codigoModelo) {
		this.codigoModelo = codigoModelo;
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

//	/**
//	 * @return the modeloEntity
//	 */
//	public ModeloEntity getModeloEntity() {
//		return modeloEntity;
//	}
//
//	/**
//	 * @param modeloEntity the modeloEntity to set
//	 */
//	public void setModeloEntity(ModeloEntity modeloEntity) {
//		this.modeloEntity = modeloEntity;
//	}
	
	
	



} 