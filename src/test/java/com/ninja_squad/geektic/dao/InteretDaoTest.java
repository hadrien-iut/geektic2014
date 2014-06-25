package com.ninja_squad.geektic.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;

import static org.junit.Assert.*;

public class InteretDaoTest extends BaseDaoTest {

	@Autowired
	InteretDao dao;
	
	@Before
    public void populateDatabase() {
        Operation operation = Operations.sequenceOf(); // TODO define your operations here.
        DbSetup dbSetup = new DbSetup(destination, operation);
        dbSetup.launch();
    }
	
	@Test
	public void retourneTousLesInterets(){
		assertEquals(5, dao.findAll().size());
	}
}
