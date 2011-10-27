package controllers;

import play.*;
import play.data.validation.*;
import play.mvc.*;
import utilities.LogGateway;

import java.util.*;

import models.*;

public class Profile extends Controller {

    public static void showProfile(String region, String saiNum) {
    	Singer singer = Singer.findBySaiNum(saiNum);
    	if (singer==null) {
    		singer = new Singer(saiNum);
    		singer.save();
    		Application.welcome(singer);
    	} else {
    		render(singer);
    	}
    }
}