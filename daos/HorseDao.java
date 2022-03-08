package daos;

import java.util.ArrayList;
import java.util.List;

import models.Data;
import models.Horse;
import models.Race;

public class HorseDao {

	Horse f1;
	Horse f2;
	Horse f3;
	
	public HorseDao() {
		f1 = new Horse();
		f2 = new Horse();
		f3 = new Horse();
		Data.setHorses(new ArrayList<Horse>());
	}
	
	public List<Horse> getAllHorseFromRace(Race f){
		return f.getHorses();
	}
	
	public boolean addHorseToList(Horse f) {
		return Data.getHorses().add(f);
	}
	
	public boolean deleteHorseToList(Horse f) {
		return Data.getHorses().remove(f);
	}
	
	public static List<Horse> getAllHorses(){
		return Data.getHorses();
	}
	
	public List<Horse> getHorses(){
		return Data.getHorses();
	}

	public void setHorses(List<Horse> Horses) {
		Data.setHorses(Horses);
	}
	
	public static Horse getHorseByName(String nameHorse) {
		Horse horse = null;
		for(Horse f : getAllHorses()) {
			if(f.getName().equals(nameHorse)) { 
				horse = f;
			}
		}
		return horse;
	}
	
	public void updateHorseName(Horse Horse, String newHorseName) {
		Horse.setName(newHorseName);
	}
}
