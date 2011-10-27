package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import models.enums.Goal;
import models.enums.VoicePart;
import models.exceptions.RoleIsFilledException;

import org.apache.commons.lang.WordUtils;



public class RandomTestData {
	
	private static final int MAX_DISTANCE = 1000;
	private static String[] firstNames = {"Mary","Jane","Wilma","Samantha","Rebecca","Patty","Julia","Sandra","Simone","Natasha"};
	private static String[] lastNames = {"Smith","Jones","Williams","Green","Abernathy","Kwan","O'Donnell","Cosgrove","Windermere"};
	private static String[] verbs = {"sing", "win", "entertain", "perform", "compete"};
	private static String[] emotions = {"love","hate","like","want","prefer"};
	private static String[] places = {"international competition", "regional competition", "chorus", "eisteddfod", "church","school","home"};
	private static Random random = new Random();
	private static String[] pluralNouns = {"foursome","girls","flowers","freaks","puppies","witches","friends","ninjas"};
	private static String[] adjectives = {"fantastic", "fabulous", "green", "wondrous", "sparkly", "evil", "dynamic", "rich"};

	private static String getRandomString(String[] strArray) {
		int idx = random.nextInt(strArray.length);
		return strArray[idx];
	}

	public static Singer createRandomTestSinger() {
		Singer singer = new Singer(UUID.randomUUID().toString());
		singer.setFirstName(getRandomString(firstNames));
		singer.setLastName(getRandomString(lastNames));
		singer.setTest(true);
//		int unitIdx = random.nextInt(LengthUnit.values().length);
//		singer.setTravelDistance(new Distance(random.nextInt(MAX_DISTANCE), LengthUnit.values()[unitIdx]));
		setRandomGoals(singer);
		singer.setDescription(getRandomDescription());
		return singer;
	}

	private static String getRandomDescription() {
		return "I " + getRandomString(emotions) + " to " + getRandomString(verbs);
	}

	private static void setRandomGoals(SaiEntity entity) {
		for (int goalIdx = 0; goalIdx < Goal.values().length; goalIdx++) {
			int include = random.nextInt(2);
			if (include == 1) {
				Goal goal = Goal.values()[goalIdx];
				if (goal == Goal.OTHER) {
					entity.setOtherGoal(getRandomOtherGoal());
				} else {
					entity.addGoal(goal);
				}
			}
			if (entity.getGoals().isEmpty()) {
				entity.setOtherGoal(getRandomOtherGoal());
			}
		}
	}

	public static void setRandomVoiceParts(Singer singer) {
		List<VoicePart> parts = getRandomVoiceParts(random.nextInt(4)+1);
		singer.addVoiceParts(parts);
	}

	public static List<VoicePart> getRandomVoiceParts(int numParts) {
		List<VoicePart> allParts = VoicePart.enumList();
		List<VoicePart> parts = new ArrayList<VoicePart>();
		while (parts.size() < numParts) {
			parts.add(removeRandomVoicePart(allParts));
		}
		return parts;
	}
	
	private static String getRandomOtherGoal() {
		return "To "+getRandomString(verbs) + " at " + getRandomString(places);
	}

	public static Quartet createRandomTestQuartet(boolean complete) throws RoleIsFilledException {
		int numParts;
		if (complete) {
			numParts = 4;
		} else {
			numParts = random.nextInt(4);
		}
		List<VoicePart> parts = getRandomVoiceParts(numParts);
		Singer singer;
		Quartet quartet = null;
		while (!parts.isEmpty()) {
			VoicePart part = removeRandomVoicePart(parts);
			singer = createRandomTestSinger(part);
			singer.addVoiceParts(getRandomVoiceParts(2));
			if (quartet==null) {
				quartet=new Quartet(singer, part);
			} else {
				quartet.addSinger(singer, part);
			}
		}
		quartet.setName(getRandomQuartetName());
		return quartet;		
	}

	private static String getRandomQuartetName() {
		String name = "The " 
			+ WordUtils.capitalize(getRandomString(adjectives)) 
			+ " " 
			+ WordUtils.capitalize(getRandomString(pluralNouns));
		return name;
	}

	private static VoicePart removeRandomVoicePart(List<VoicePart> parts) {
		int which = random.nextInt(parts.size());
		VoicePart[] a = new VoicePart[4];
		parts.toArray(a);
		parts.remove(a[which]);
		return a[which];
	}

	private static Singer createRandomTestSinger(VoicePart part) {
		Singer singer = createRandomTestSinger();
		singer.addVoicePart(part);
		return singer;
	}
}
