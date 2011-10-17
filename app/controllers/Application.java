package controllers;

import play.*;
import play.data.validation.*;
import play.mvc.*;
import utilities.LogGateway;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render(RandomTestData.createRandomTestSinger());
    }
    
    public static void sayHello(@Required String myName) {
        if(validation.hasErrors()) {
            flash.error("Oops, please enter your name!");
            index();
        }
        LogGateway.debug("Hello "+myName);
    	render(myName);
    }

}