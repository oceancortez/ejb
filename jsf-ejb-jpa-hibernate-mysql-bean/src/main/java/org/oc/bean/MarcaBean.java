/*
 * 
 */
package org.oc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.oc.facade.IMarcaFacade;
import org.oc.facade.MarcaFacadeImpl;
import org.oc.utils.dto.MarcaDTO;

// TODO: Auto-generated Javadoc
/**
 * The Class MarcaBean.
 */
@ViewScoped
@ManagedBean
public class MarcaBean {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(MarcaBean.class);

	/** The marcas. */
	private List<MarcaForm> marcas;

	/** The marca form. */
	private MarcaForm marcaForm;

	/** The page. */
	private int page = 1;
	
	/** The marca facade. */
	@EJB
	private IMarcaFacade marcaFacade;

	/**
	 * Inits the.
	 */
	@PostConstruct
	public void init(){
		marcaFacade = new MarcaFacadeImpl();
		buildMarca();
	}

	/**
	 * Builds the marca.
	 */
	public void buildMarca(){
		LOGGER.info("Entrou no método buildMarca()" );
		getAllMarcas();
		LOGGER.info("Saiu do método buildMarca()" );
	}


	/**
	 * Gets the all marcas.
	 *
	 * @return the all marcas
	 */
	private void getAllMarcas() {
		try {			
			final List<MarcaDTO> marcasDTO = marcaFacade.buscarTodasMarcasService();
			if(marcasDTO != null){
				LOGGER.info("Entrou no método getAllMarcas()" );				
				marcas = parseMarcaDTO(marcasDTO);				
				LOGGER.info("Saiu do método getAllMarcas()" );
			}
		} catch (Exception e) {
			LOGGER.error("Erro no método getAllMarcas() >>"  + e.getMessage() );			
		}	
	}

	/**
	 * Parses the marca DTO.
	 *
	 * @param marcasDTO the marcas DTO
	 * @return the list
	 */
	@SuppressWarnings("unused")
	private List<MarcaForm> parseMarcaDTO(final List<MarcaDTO> marcasDTO){
		LOGGER.info("Entrou no método parseMarcaDTO()" );
		List<MarcaForm> marcasVO = new ArrayList<>();
		
		for(MarcaDTO dto : marcasDTO){
			MarcaForm marcaForm = new MarcaForm();
			marcaForm.setCodigo(dto.getCodigo());	
			marcaForm.setNome(dto.getNome());
			marcaForm.setDataCriacao(dto.getDataCriacao());

			marcasVO.add(marcaForm);
		}
		LOGGER.info("Saiu do método parseMarcaDTO()" );
		return marcasVO;
	}


	/**
	 * Parses the marca form.
	 *
	 * @param marcaForm the marca form
	 * @return the marca DTO
	 */
	private MarcaDTO parseMarcaForm(final MarcaForm marcaForm){
		final MarcaDTO MarcaDTO = new MarcaDTO();			

		MarcaDTO.setCodigo(marcaForm.getCodigo());
		MarcaDTO.setNome(marcaForm.getNome());		
		MarcaDTO.setDataCriacao(new Date());
		return MarcaDTO;
	}


	/**
	 * Adiciona marca.
	 */
	public void adicionaMarca(){
		try {		
			if(this.getMarcaForm() != null && !this.getMarcaForm().getNome().isEmpty()){
				LOGGER.info("Entrou no método adicionaMarca()" );
				
				final MarcaDTO marcaDTO = parseMarcaForm(this.marcaForm);
				boolean isFoiSalvo = marcaFacade.adicionaMarca(marcaDTO);
				if(isFoiSalvo){
					LOGGER.info("Registro foi salvo ==" + isFoiSalvo );
					this.setMarcaForm(new MarcaForm());
				}else{
					
				}					
				LOGGER.info("Saiu do método adicionaMarca()" );
			}
		} catch (Exception e) {
			LOGGER.error("Erro no método adicionaMarca() >>"  + e.getMessage() );
			this.setMarcaForm(new MarcaForm());
		}
	} 

	/**
	 * Gets the marcas.
	 *
	 * @return the marcas
	 */
	public List<MarcaForm> getMarcas() {
		if(marcas == null){
			marcas = new ArrayList<>();
		}
		return marcas;
	}

	/**
	 * Sets the marcas.
	 *
	 * @param marcas the marcas to set
	 */
	public void setMarcas(List<MarcaForm> marcas) {
		this.marcas = marcas;
	}

	/**
	 * Gets the marca form.
	 *
	 * @return the marcaForm
	 */
	public MarcaForm getMarcaForm() {
		if(marcaForm == null){
			marcaForm = new MarcaForm();
		}
		return marcaForm;
	}

	/**
	 * Sets the marca form.
	 *
	 * @param marcaForm the marcaForm to set
	 */
	public void setMarcaForm(MarcaForm marcaForm) {
		this.marcaForm = marcaForm;
	}

	/**
	 * Gets the page.
	 *
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * Sets the page.
	 *
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

}
