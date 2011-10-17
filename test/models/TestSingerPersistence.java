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

public class TestSingerPersistence extends UnitTest {
	
	@BeforeClass
	public static void classSetup() {
		LogGateway.setCurrentLogLevel(Log.LOG_LEVEL_DEBUG);
	}
	
	@Before
	public void setup() {
		SienaFixtures.deleteAllModels();
		Fixtures.deleteAllModels();
		createTenSingers();
	}

	private void createTenSingers() {
		//Create ten test singers
		Singer singer;
		for (int i = 0; i<10; i++) {
			singer = RandomTestData.createRandomTestSinger();
			RandomTestData.setRandomVoiceParts(singer);
			singer.insert();
		}
	}
	
	@Test
	public void testCountSingers() {
		assertEquals("Exactly 10 singers should be found",10,Singer.all(Singer.class).count());
		Singer singer = Singer.all().get();
		assertTrue("Goals should not be empty", singer.getGoals().size() > 0);
		LogGateway.debug(singer.toString());
	}
	
	
}
