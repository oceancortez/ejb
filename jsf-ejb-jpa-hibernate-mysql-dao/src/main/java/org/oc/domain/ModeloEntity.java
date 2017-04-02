package org.oc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mdo")
public class ModeloEntity implements Serializable{
	
	private static final long serialVersionUID = -1147446755977649593L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "mdocod")
	private Long codigo;
	
	@Column(name = "mdonam")
	private String nome;
	
	@Column(name = "mdodat")
	private Date dataCriacao;
	
	@Column(name = "vrscod")
	private Long codigoVersao;
	
	@Column(name = "mracod")
	private Long codigoMarca;
	
//	@OneToMany
//	@JoinColumn(name = "vrscod")
//	private VersaoEntity versaoEntity;
	
//	@ManyToOne
//	@JoinColumn(name = "mracod")
//	private MarcaEntity marcaEntity;

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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
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
	 * @return the codigoVersao
	 */
	public Long getCodigoVersao() {
		return codigoVersao;
	}

	/**
	 * @param codigoVersao the codigoVersao to set
	 */
	public void setCodigoVersao(Long codigoVersao) {
		this.codigoVersao = codigoVersao;
	}

	/**
	 * @return the codigoMarca
	 */
	public Long getCodigoMarca() {
		return codigoMarca;
	}

	/**
	 * @param codigoMarca the codigoMarca to set
	 */
	public void setCodigoMarca(Long codigoMarca) {
		this.codigoMarca = codigoMarca;
	}

//	/**
//	 * @return the versaoEntity
//	 */
//	public VersaoEntity getVersaoEntity() {
//		return versaoEntity;
//	}
//
//	/**
//	 * @param versaoEntity the versaoEntity to set
//	 */
//	public void setVersaoEntity(VersaoEntity versaoEntity) {
//		this.versaoEntity = versaoEntity;
//	}
//
//	/**
//	 * @return the marcaEntity
//	 */
//	public MarcaEntity getMarcaEntity() {
//		return marcaEntity;
//	}
//
//	/**
//	 * @param marcaEntity the marcaEntity to set
//	 */
//	public void setMarcaEntity(MarcaEntity marcaEntity) {
//		this.marcaEntity = marcaEntity;
//	}
//	
	
	

}
