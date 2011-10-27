package models;

import java.util.List;

import org.junit.Test;

import play.test.UnitTest;

import utilities.LogGateway;

public class TestDataReading extends UnitTest{

	@Test
	public void testReadSingers() {
		List<Singer> singers = Singer.all().fetch(10); 
		for(Singer s: singers) {
			if (s!=null) {
				LogGateway.debug("Read singer: "+s.toString());
			}
		}
	}

	@Test
	public void testReadQuartets() {
		List<Quartet> quartets = Quartet.all().fetch(10); 
		for(Quartet q: quartets) {
			LogGateway.debug("Read quartet: "+q.toString());
		}
	}

	@Test
	public void testReadRoles() {
		List<Role> roles = Role.all().fetch(10); 
		for(Role r: roles) {
			LogGateway.debug("Read role: "+r.toString());
		}
	}

}
