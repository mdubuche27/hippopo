package tests.controllerTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import controllers.RaceController;
import models.Data;
import models.Race;
import models.Horse;

public class RaceControllerTest {

	RaceController fc = new RaceController();
	
	@Test
	public void createRaceTestOk() {
		List<Horse> horses = null;
		fc.createRace("raceTest", LocalDateTime.now(), horses );
		assertTrue(Data.getRaces().get(Data.getRaces().size()-1).getName().equals("raceTest") &&
				Data.getRaces().get(Data.getRaces().size()-1).getHorses() == null);
	}
	
	@Test
	public void deleteRaceTestOk() {
		String raceName = "raceTest";
		Data.getRaces().add(new Race(raceName));
		fc.deleteRaceByName(raceName);
		assertFalse(Data.getRaces().contains(raceName));
	}
	
	@Test
	public void deleteRaceTestNotExist() {
		assertFalse(fc.deleteRaceByName("raceName"));
	}
	
	@Test
	public void createHorseAndAddToRaceTest() {
		Data.getRaces().add(new Race("Race"));
		Data.getRaces().get(0).getHorses().add(new Horse("Horse"));
		assertTrue(fc.AddHorseToRace("Race","Horse"));
	}
	
	@Test
	public void deleteHorseFromRaceTestWhenRaceExistAndHorseExist() {
		Data.getRaces().add(new Race("Race"));
		Data.getRaces().get(0).getHorses().add(new Horse("Horse"));
		
		assertTrue(fc.deleteHorseFromRace("Race","Horse"));
	}
	
	@Test
	public void deleteHorseFromRaceTestWhenRaceExistAndHorseNotExist() {
		Data.getRaces().add(new Race("Race"));
		
		assertFalse(fc.deleteHorseFromRace("Race","Horse"));
	}
	
	@Test
	public void deleteHorseFromRaceTestWhenRaceAndHorseNotExist() {
		assertFalse(fc.deleteHorseFromRace("Race","Horse"));
	}
	
	@Test
	public void updateRaceNameTest() {
		Data.getRaces().add(new Race("Race"));
		assertTrue(fc.updateRaceName("Race", "Race2"));
	}
}
