package models.exceptions;

import models.Quartet;
import models.enums.VoicePart;

public class RoleIsFilledException extends Exception {
	
	public RoleIsFilledException(VoicePart part, Quartet quartet) {
		super(quartet.getName()+ " already has a " + part.getName());
	}

}
