package com.ninja_squad.geektic.dao;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import com.ninja_squad.geektic.enumerator.Sexe;

import static org.junit.Assert.*;

public class GeekDaoTest extends BaseDaoTest {
	
	@Autowired
	GeekDao dao;
	
	@Before
    public void populateDatabase() {
        Operation operation = Operations.sequenceOf(); // TODO define your operations here.
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }

	@Test
	public void retourneLesGeeksParSexeEtParIdInteret(){
		assertEquals(1, dao.findBySexeAndInteret(Sexe.M, 3L).size());
	}
	
	@Test
	public void retourneUnGeekParId(){
		assertEquals("Hadrien", dao.findById(1L).getPrenom());
	}
	
	@Test
	public void incermenteLeNombreDeVuePourUnGeek(){
		dao.persist(1L, 2L);
		assertEquals(4L, dao.findById(1L).getView().longValue());
	}
}
