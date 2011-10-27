package models.enums;

import java.util.HashSet;
import java.util.Set;

import siena.embed.EmbeddedMap;

@EmbeddedMap
public enum Goal {
	FUN_N_SKILLS("To have fun and practice skills", 1),
	PERFORM_CHORUS("To perform for chorus", 2),
	PERFORM_CHARITY("To perform for charity", 3),
	PERFORM_PAID("To do paid performances", 4),
	MAKE_CD("To make a CD", 5),
	COMPETE_REGIONAL("To compete at Regional", 6),
	COMPETE_INTERNATIONAL("To compete at International", 7),
	OTHER("Other:", 8);

	private String label;
	private Integer value;

	Goal(String label, Integer value) {
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public Integer getValue() {
		return value;
	}

	public static Goal getEnumByValue(Integer enumValue) {
		for (Goal result : values()) {
			if (result.getValue().equals(enumValue)) {
				return result;
			}
		}
		return null;
	}

	public static Goal getEnumByLabel(String enumLabel) {
		for (Goal result : values()) {
			if (result.getLabel().equals(enumLabel)) {
				return result;
			}
		}
		return null;
	}

	public static Set<Goal> enumSet() {
		Set<Goal> allParts = new HashSet<Goal>();
		for (Goal part : values()) {
			allParts.add(part);
		}
		return allParts;
	}
	
	public static Set<Goal> enumSet(Set<Integer> subset) {
		Set<Goal> partSubset = new HashSet<Goal>();
		for (Integer value : subset) {
			partSubset.add(getEnumByValue(value));
		}
		return partSubset;
	}

}