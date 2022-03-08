package models;

import java.util.List;

public class Data {

	static List<Race> races;
	static List<Horse> horses;
	
	public static List<Race> getRaces() {
		return races;
	}

	public static void setRaces(List<Race> races) {
		Data.races = races;
	}

	public static List<Horse> getHorses() {
		return horses;
	}

	public static void setHorses(List<Horse> horses) {
		Data.horses = horses;
	}
}
