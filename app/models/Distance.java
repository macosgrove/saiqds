package models;

import javax.persistence.Entity;

import siena.Id;

import models.enums.LengthUnit;

public class Distance {
	@Id
	private long id;
	private float distance;
	private LengthUnit units;
	
	public Distance(int distance, LengthUnit units) {
		this.distance = distance;
		this.units = units;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public LengthUnit getUnits() {
		return units;
	}
	public void setUnits(LengthUnit units) {
		this.units = units;
	}
	public long getId() {
		return id;
	}
}