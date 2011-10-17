package models;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import models.enums.Goal;
import models.interfaces.GoalOriented;
import models.interfaces.Mappable;
import models.interfaces.Rateable;
import siena.Model;
import siena.embed.Embedded;


public abstract class SaiEntity extends Model implements Mappable, Rateable, GoalOriented {
	protected String description;
	protected boolean test = true;
	protected String otherGoal;
	
	@Embedded
	protected Set<Integer> goals = new HashSet<Integer>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

	/* Mappable implementation */
	public void draw(GeoMap map) {
		// TODO Auto-generated method stub
	}

	/* Rateable implementation */
	public void getRating(Rateable rateable) {
		// TODO Auto-generated method stub

	}

	/* Goal Oriented implementation */
	public String getOtherGoal() {
		return otherGoal;
	}
	public void setOtherGoal(String other) {
		otherGoal = other;
		if (otherGoal==null || otherGoal.isEmpty()) {
			removeGoal(Goal.OTHER);
		} else {
			addGoal(Goal.OTHER);
		}
	}
	public void removeGoal(Goal oldGoal) {
		goals.remove(oldGoal.getValue());
	}
	public void addGoal(Goal newGoal) {
		goals.add(newGoal.getValue());
	}
	public Set<Goal> getGoals() {
		return Goal.enumSet(goals);
	}


}