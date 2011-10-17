package models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.*;

import siena.Entity;
import siena.Filter;
import siena.Generator;
import siena.Id;
import siena.Model;
import siena.Query;
import models.enums.VoicePart;
import models.exceptions.RoleIsFilledException;

public class Quartet extends SaiEntity {

	@Id(Generator.AUTO_INCREMENT)
	protected Long id;
	@Filter("quartet")
	protected Query<Role> roleQuery;	
	protected String name;
	protected Singer admin; //not nullable
	
	protected transient Set<Role> roles = new HashSet<Role>();
	
	public static Quartet findById(Long id) {
		Quartet q = Quartet.all().filter("id", id).get();
		q.fetchRoles();
		return q;
	}
	
	private void fetchRoles() {
		for (Role r: roleQuery.fetch()) {
			roles.add(r);
		}
	}

	public  Quartet(Singer admin, VoicePart part) throws RoleIsFilledException {
		this.name = "Unnamed Quartet";
		this.admin = admin;
		this.addSinger(admin, part);
	}

	public void addSinger(Singer singer, VoicePart part) throws RoleIsFilledException {
		if (getSinger(part) != null) {
			throw new RoleIsFilledException(part, this);
		}
		Role role = new Role(singer, this, part);
		roles.add(role);
	}

	public Singer findSinger(VoicePart part) {
		Singer singer = null;
		return singer;
	}
	
	public Boolean getIsComplete() {
		return roleQuery.count()==4;
	}
	
	protected Singer getSinger(VoicePart part) {
		Singer singer = null;
		Query<Role> partRoles = roleQuery.filter("part", part.getValue());
		assert partRoles.count() <= 1;
		Role r = partRoles.get();
		if (r != null) {
			singer = r.singer;
		}
		return singer;
	}
	
	public Singer getTenor() {
		return getSinger(VoicePart.TENOR);
	}
	public Singer getLead() {
		return getSinger(VoicePart.LEAD);
	}
	public Singer getBari() {
		return getSinger(VoicePart.BARI);
	}
	public Singer getBass() {
		return getSinger(VoicePart.BASS);
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(name);
		result.append(" (");
		boolean first = true;
		for (Role r : roleQuery.fetch()) {
			if (!first) {
				result.append(", ");
			}
			first = false;
			result.append(r.getSinger().getFullName());
			result.append(" - ");
			result.append(r.getVoicePart().getName()	);
		}
		result.append(")");
		return result.toString();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Set<Singer> getSingers() {
		Set<Singer> singers = new HashSet<Singer>();
		for (Role r: roles) {
			singers.add(r.getSinger());
		}
		return singers;
	}

	public static Query<Quartet> all() {
		return Model.all(Quartet.class);
	}

}