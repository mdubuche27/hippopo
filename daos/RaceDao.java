package daos;

import java.util.ArrayList;
import java.util.List;

import models.Data;
import models.Race;
import models.Horse;

public class RaceDao {

	Race f1;
	Race f2;
	Race f3;
	
	public RaceDao() {
		f1 = new Race();
		f2 = new Race();
		f3 = new Race();
		Data.setRaces(new ArrayList<Race>());
	}
	
	public boolean addRaceToList(Race f) {
		return Data.getRaces().add(f);
	}
	
	public boolean deleteRaceToList(Race f) {
		return Data.getRaces().remove(f);
	}
	
	public List<Race> getAllRaces(){
		return Data.getRaces();
	}
	
	public List<Race> getRaces(){
		return Data.getRaces();
	}

	public void setRaces(List<Race> races) {
		Data.setRaces(races);
	}
	
	public boolean addHorseToRace(Horse horse, Race race) {
		return race.getHorses().add(horse);
	}
	
	public Race getRaceByName(String nameRace) {
		Race race = null;
		for(Race f : getAllRaces()) {
			if(f.getName().equals(nameRace)) { 
				race = f;
			}
		}
		return race;
	}
	
	public boolean deleteHorseFromRace(Horse horse, Race race) {
		return race.getHorses().remove(horse);
	}
	
	
	public Horse getHorseFromRaceByHorseName(Race f,String horseName) {
		Horse horse = null;
		if(f == null)
			return null;
		for(Horse s : f.getHorses()) {
			if(s.getName().equals(horseName)) { 
				horse = s;
			}
		}
		return horse;
	}
	
	public void updateRaceName(Race race, String newRaceName) {
		race.setName(newRaceName);
	}
}
