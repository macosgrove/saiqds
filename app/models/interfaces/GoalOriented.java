package models.interfaces;

import java.util.Set;

import models.enums.Goal;


public interface GoalOriented {
	public String getOtherGoal();
	public void setOtherGoal(String other);
	public Set<Goal> getGoals();
	public void addGoal(Goal newGoal);
	public void removeGoal(Goal oldGoal);
}