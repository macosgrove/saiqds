package models;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import models.Quartet;
import models.enums.VoicePart;
import models.exceptions.RoleIsFilledException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import play.modules.siena.SienaFixtures;
import play.test.Fixtures;
import play.test.UnitTest;

import utilities.LogGateway;

public class TestQuartetPersistence extends UnitTest{
	
	@Before
	public void setup() {
		SienaFixtures.deleteAllModels();
		Fixtures.deleteAllModels();
	}

	@Test
	public void testPersistRandomQuartet() throws RoleIsFilledException {
		Quartet quartet = RandomTestData.createRandomTestQuartet(true);
		quartet.setName(UUID.randomUUID().toString());
		LogGateway.debug(quartet.toString());
		assertTrue("Quartet should have between 1 and 4 members", (quartet.getSingers().size() >= 1) 
				&& (quartet.getSingers().size() <= 4));
		quartet.insert();
		Quartet findById = Quartet.findById(quartet.id);
		assertEquals("Quartet read out of Db should have same name as the original.",quartet.name, findById.name);
		assertEquals("Quartet read out of Db should have same number of singers as the original.",quartet.getSingers().size(), findById.getSingers().size());
		List<Quartet> findByNameList = Quartet.findByName(quartet.name);
		assertTrue("Should have found exactly one quartet",findByNameList.size()==1);
		Quartet findByName = findByNameList.get(0);
		assertEquals("Quartet read out of Db should have same name as the original.",quartet.name, findByName.name);
		assertEquals("Quartet read out of Db should have same number of singers as the original.",quartet.getSingers().size(), findByName.getSingers().size());
	}

}
