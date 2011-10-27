package models;


import static org.junit.Assert.*;

import models.Singer;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import play.modules.siena.SienaFixtures;
import play.test.Fixtures;
import play.test.UnitTest;

import utilities.*;

public class TestUnpersistedSinger extends UnitTest {
	
	@BeforeClass
	public static void classSetup() {
		LogGateway.setCurrentLogLevel(Log.LOG_LEVEL_DEBUG);
	}
	
	@Before
	public void setup() {
		SienaFixtures.deleteAllModels();
		Fixtures.deleteAllModels();
	}

	@Test
	public void testCreateSinger() {
		Singer singer = RandomTestData.createRandomTestSinger();
		RandomTestData.setRandomVoiceParts(singer);
		assertNotNull("First name should not be null",singer.getFirstName());
		assertNotNull("Last name should not be null",singer.getLastName());
		assertNotNull("SAI should not be null",singer.getSaiNum());
		assertNotNull("Goals should not be null",singer.getGoals());
		assertTrue("Goals should not be empty", singer.getGoals().size() > 0);
//		assertNotNull("Locality should not be null",singer.getLocality());
//		assertNotNull("Travel distance should not be null",singer.getTravelDistance());
		assertNotNull("Description should not be null",singer.getDescription());
		assertNotNull("Voice parts should not be null",singer.getVoiceParts());
		assertTrue("Voice parts should not be empty", singer.getVoiceParts().size() > 0);
		LogGateway.debug(singer.toString());
	}
	
}
