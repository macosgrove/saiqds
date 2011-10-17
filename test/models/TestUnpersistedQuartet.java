package models;
import static org.junit.Assert.*;

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

public class TestUnpersistedQuartet extends UnitTest{
	
	@Before
	public void setup() {
		SienaFixtures.deleteAllModels();
		Fixtures.deleteAllModels();
	}

	@Test
	public void testCreateNewQuartet() throws RoleIsFilledException {
		Singer singer = new Singer(UUID.randomUUID().toString());
		singer.setFirstName("Mary");
		singer.setLastName("Jones");
		singer.setTest(true);
		singer.setDescription("Test singer");
		singer.addVoicePart(VoicePart.BARI);
		LogGateway.debug(singer.toString());
		Quartet quartet = new Quartet(singer, VoicePart.BARI);
		LogGateway.debug(quartet.toString());
		assertEquals("Quartet should have 1 member", 1, quartet.getSingers().size());
	}

	@Test
	public void testCreateRandomQuartet() throws RoleIsFilledException {
		Quartet quartet = RandomTestData.createRandomTestQuartet(true);
		LogGateway.debug(quartet.toString());
		assertTrue("Quartet should have between 1 and 4 members", (quartet.getSingers().size() >= 1) 
				&& (quartet.getSingers().size() <= 4));
	}

}
