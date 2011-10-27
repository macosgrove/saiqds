package models;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Embedded;

import models.enums.VoicePart;
import siena.Generator;
import siena.Id;
import siena.Model;
import siena.Query;

public class Singer extends SaiEntity {
	protected String firstName;
	protected String lastName;
	
//	@Filter("admin")
//	private Query<Quartet> myQuartets;
	
	@Id(Generator.AUTO_INCREMENT)
	protected Long id;
	
	protected String saiNum;
	
//	@Index("photo_index")
//	protected Image photo;
	
	protected Boolean isAvailable;
	
	@Embedded
	protected List<Long> voiceParts;
	
//	@Embedded
//	protected Distance travelDistance;
	
	protected String currentChoruses;
	protected String pastChoruses;
	protected String pastQuartets;
	
//	@Index("locality_index")
//	protected Locality locality;
	
	@SuppressWarnings("unused")
	private Singer() {
		//Need a no-arg constructor for siena's reflective construction
	}
		
	public Singer(String saiNum) {
		voiceParts = new ArrayList<Long>();
		this.saiNum = saiNum;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(getFullName());
		result.append(" ["+saiNum+"]");
		result.append(" (");
		boolean first = true;
		for (VoicePart p : getVoiceParts()) {
			if (!first) {
				result.append(", ");
			}
			first = false;
			result.append(p==null?"[no part]":p.getName());			
		}
		result.append(")");
		return result.toString();
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSaiNum() {
		return saiNum;
	}

	public void setSaiNum(String saiNum) {
		this.saiNum = saiNum;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}
	
//	public List<Quartet> getMyQuartets() {
//		return myQuartets.fetch();
//	}
	public void removeVoicePart(VoicePart oldVoicePart) {
		voiceParts.remove(oldVoicePart.getValue());
	}
	public void addVoicePart(VoicePart newVoicePart) {
		voiceParts.add(newVoicePart.getValue());
	}
	public List<VoicePart> getVoiceParts() {
		return VoicePart.enumList(voiceParts);
	}
	public void addVoiceParts(List<VoicePart> parts) {
		for (VoicePart part : parts) {
			addVoicePart(part);
		}
	}

	public static Query<Singer> all() {
		return Model.all(Singer.class);
	}
	public static Singer findBySaiNum(String saiNum) {
        return all().filter("saiNum", saiNum).get();
    }
 }