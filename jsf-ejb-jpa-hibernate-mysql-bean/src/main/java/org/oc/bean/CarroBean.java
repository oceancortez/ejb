package org.oc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.oc.dao.CarroRepositoryDao;
import org.oc.domain.CarroEntity;
import org.oc.jpa.JPAUtil;

/**
 * @author ocortez
 *
 */
@ManagedBean
@ViewScoped
public class CarroBean {
		
	private CarroForm carroForm = new CarroForm();	
	
	private int page = 1;
	
	private CarroEntity carroResumo;
	
	private boolean exibirCarroResumo = false;
	
	private String descricaoTooltip;
	
	private boolean disabledBtnAdicionar;
	
	private List<CarroEntity> listaCarros = new ArrayList<>();
	
	@EJB
	CarroRepositoryDao carroRepositoryDao;
	
	
	@PostConstruct
	public void init(){
		buildCarros();
	}

	
	private void buildCarros() {
		
		showListCarros();
		setDisabledBtnAdicionar(Boolean.FALSE);
		
	}



	/**
	 * TODO - Transferir a responsabilidade da getEntityManager para o módulo DAO
	 */
	
	private void showListCarros() {

		if(this.listaCarros != null){	
			
			EntityManager em = JPAUtil.getEntityManager();
			Query q = em.createQuery("SELECT c FROM CarroEntity c", CarroEntity.class);
			this.listaCarros = q.getResultList();			
			em.close();			
		}
		
	}

	
	/**
	 * TODO - Transferir a responsabilidade da getEntityManager para o módulo DAO
	 */
	public void adicionaCarro(){
		try {
			
			EntityManager em = JPAUtil.getEntityManager();
			
			if(this.getCarroForm() != null && !this.getCarroForm().getNomeMarca().isEmpty() && !this.getCarroForm().getNomeModelo().isEmpty()){
				
				em.getTransaction().begin();
				
				em.persist(this.getCarroForm());
				
				em.getTransaction().commit();
				
				em.close();
				
				this.setCarroForm(new CarroForm());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	} 
	
//	public void selecionarCarro(){
//		System.out.println("[ Vendor: " + carroForm.getMarca() + " / Modelo: " + carroForm.getModelo() + "]");
//		carroResumo = new CarroEntity();
//		if(!carroForm.getMarca().isEmpty()){
//			carroResumo.setId(carroForm.getId());
//			carroResumo.setMarca(carroForm.getMarca());
//			carroResumo.setModelo(carroForm.getModelo());
//			exibirCarroResumo = true;
//			System.out.println("[ carroResumo.Vendor: " + carroResumo.getMarca() + " / carroResumo.Modelo: " + carroResumo.getModelo() + "]");
//			
//			FacesContext.getCurrentInstance().addMessage(null, 
//					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Anteção, voce seleciou o carro" + carroForm.getModelo()+"", "Anteção, voce seleciou o carro" + carroForm.getModelo()+""));
//		}
//				
//	}
	
//	public String renderizaTooltipDescricao(){
//		
//		if(StringUtils.isEmpty(carroForm.getDescricao())){
//			
//			descricaoTooltip = "Tooltip is OK!!";
//			return descricaoTooltip;
//		}
//		
//		return StringUtils.EMPTY;
//	} 
	
/*	private EntityManager getEntityManager (){
		
	FacesContext fc = FacesContext.getCurrentInstance();
	ExternalContext ec = fc.getExternalContext();
	HttpServletRequest request = (HttpServletRequest) ec.getRequest();
	EntityManager manager = (EntityManager) request.getAttribute("EntityManager");
	return manager;
	}*/
	
	
//	public void adicionaCarro(){
//	EntityManager manager = JPAUtil.getEntityManager();
//	carroRepositoryDao.CarroRepositoryDaoImpl(manager);
//	carroRepositoryDao.adiciona(this.carro);
//	this.carro = new Carro();
//	this.carros = null;
//	}
		
//	public List<Carro> getCarros (){
//		
//		if(this.carros.isEmpty()){	
//			
//			this.carros = carroRepositoryDao.buscaTodos();		
//			
//			if(carros != null){
//				return carros;
//			}	
//		}
//		
//		return carros;
//		
//	}
	
	
	
	
	
	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}


	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}




	/**
	 * @return the carroResumo
	 */
	public CarroEntity getCarroResumo() {
		return carroResumo;
	}


	/**
	 * @param carroResumo the carroResumo to set
	 */
	public void setCarroResumo(CarroEntity carroResumo) {
		this.carroResumo = carroResumo;
	}


	/**
	 * @return the exibirCarroResumo
	 */
	public boolean isExibirCarroResumo() {
		return exibirCarroResumo;
	}


	/**
	 * @param exibirCarroResumo the exibirCarroResumo to set
	 */
	public void setExibirCarroResumo(boolean exibirCarroResumo) {
		this.exibirCarroResumo = exibirCarroResumo;
	}


	/**
	 * @return the descricaoTooltip
	 */
	public String getDescricaoTooltip() {
		return descricaoTooltip;
	}


	/**
	 * @param descricaoTooltip the descricaoTooltip to set
	 */
	public void setDescricaoTooltip(String descricaoTooltip) {
		this.descricaoTooltip = descricaoTooltip;
	}


	/**
	 * @return the disabledBtnAdicionar
	 */
	public boolean isDisabledBtnAdicionar() {
		return disabledBtnAdicionar;
	}


	/**
	 * @param disabledBtnAdicionar the disabledBtnAdicionar to set
	 */
	public void setDisabledBtnAdicionar(boolean disabledBtnAdicionar) {
		this.disabledBtnAdicionar = disabledBtnAdicionar;
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


	/**
	 * @return the carroForm
	 */
	public CarroForm getCarroForm() {
		return carroForm;
	}


	/**
	 * @param carroForm the carroForm to set
	 */
	public void setCarroForm(CarroForm carroForm) {
		this.carroForm = carroForm;
	}


}
