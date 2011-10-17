package models;

import models.enums.VoicePart;
import siena.*;
import utilities.LogGateway;

public class Role extends Model {
	
	@Id(Generator.AUTO_INCREMENT)
	protected Long id;
	@Column("singer") @NotNull @Index("singer_index")
	protected Singer singer;
	@Column("quartet") @NotNull @Index("quartet_index")
	protected Quartet quartet;
	@Column("part_value") @NotNull
	protected Long part;
	
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
		return singer.getFullName() + " sings " + getVoicePart().getName() + " for " + quartet.getName();
	}

}
