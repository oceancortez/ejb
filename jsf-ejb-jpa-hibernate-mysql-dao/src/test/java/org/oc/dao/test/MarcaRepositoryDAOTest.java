package org.oc.dao.test;

import java.util.List;

import javax.ejb.EJB;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.oc.dao.IMarcaRepositoryDao;
import org.oc.dao.MarcaRepositoryDaoImpl;
import org.oc.domain.MarcaEntity;
import org.oc.test.AbstractDatabaseTest;

public class MarcaRepositoryDAOTest extends AbstractDatabaseTest{
	
	
	private final Logger LOGGER = Logger.getLogger(MarcaRepositoryDAOTest.class);
	
	@EJB
	private IMarcaRepositoryDao marcaRepositoryDao;
	
	public MarcaRepositoryDAOTest(){
		marcaRepositoryDao = new MarcaRepositoryDaoImpl();
	}
	
	@Test
	public void getAllMarcas(){
		List<MarcaEntity> marcaEntities = marcaRepositoryDao.buscaTodasMarcas();
		
		
		Assert.assertTrue("O retorno de marcaEntities será mario que zero "
				+ "caso haja dados na base " , marcaEntities.size() > 0);
	}

}
