package models;

import models.enums.VoicePart;
import siena.*;
import utilities.LogGateway;

public class Role extends Model {
	
	@Id(Generator.AUTO_INCREMENT)
	public Long id;
	@Column("singer") @NotNull @Index("singer_index")
	public Singer singer;
	public Quartet quartet;
	@Column("part_value") @NotNull
	public Long part;
	
	@SuppressWarnings("unused")
	private Role() {
		//Need a no-arg constructor for siena's reflective construction
	}
	public Role(Singer singer, Quartet quartet, VoicePart part) {
		if (singer==null) {
			LogGateway.debug("Null singer for new role");
			throw new NullPointerException();
		}
		if (quartet==null) {
			LogGateway.debug("Null quartet for new role");
			throw new NullPointerException();
		}
		if (part==null) {
			LogGateway.debug("Null part for new role");
			throw new NullPointerException();
		}
		this.singer = singer;
		this.quartet = quartet;
		this.part = part.getValue();
	}

	public Singer getSinger() {
		return singer;
	}

	public Quartet getQuartet() {
		return quartet;
	}

	public VoicePart getVoicePart() {
		return VoicePart.getEnumByValue(part);
	}

	public static Query<Role> all() {
		return Model.all(Role.class);
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(singer==null?"No singer sings ":singer.getFullName() + " sings ");
		result.append(getVoicePart()==null?"unknown part":getVoicePart().getName());
		result.append(quartet==null?" for unknown quartet":" for " + quartet.getName());
		return  result.toString();
	}

}
