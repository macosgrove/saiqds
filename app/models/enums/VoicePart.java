package models.enums;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import siena.Id;
import siena.embed.EmbeddedList;
import siena.embed.EmbeddedMap;

public enum VoicePart {
	TENOR("Tenor", 1L),
	LEAD("Lead", 2L),
	BARI("Baritone", 3L),
	BASS("Bass", 4L);
	private String name;
	private Long value;

	VoicePart(String name, Long value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Long getValue() {
		return value;
	}

	public static VoicePart getEnumByValue(Long enumValue) {
		for (VoicePart result : values()) {
			if (result.getValue().equals(enumValue)) {
				return result;
			}
		}
		return null;
	}

	public static VoicePart getEnumByName(String enumName) {
		for (VoicePart result : values()) {
			if (result.getName().equals(enumName)) {
				return result;
			}
		}
		return null;
	}

	public static List<VoicePart> enumList() {
		List<VoicePart> allParts = new ArrayList<VoicePart>();
		for (VoicePart part : values()) {
			allParts.add(part);
		}
		return allParts;
	}
	
	public static List<VoicePart> enumList(List<Long> subset) {
		List<VoicePart> partSubset = new ArrayList<VoicePart>();
		for (Long value : subset) {
			partSubset.add(getEnumByValue(value));
		}
		return partSubset;
	}
}