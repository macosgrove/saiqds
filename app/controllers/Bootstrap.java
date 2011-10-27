package controllers;

import java.util.List;

import play.*;
import play.jobs.*;
import play.test.*;
import utilities.LogGateway;

import models.*;

@OnApplicationStart
public class Bootstrap extends Job {

	public void doJob() {
		// Check if the database is empty
		LogGateway.debug("Initializing application");
		if (Singer.all().count() == 0) {
			LogGateway.debug("Loading initial data...");
			Fixtures.loadModels("initial-data.yml");
		} else {
			LogGateway.debug("Singers already exist...");
		}
		if (LogGateway.isDebug()) {
			List<Singer> singers =Singer.all().fetch();
			for (Singer s: singers) {
				LogGateway.debug(s.toString());
			}
		}
	}

}
