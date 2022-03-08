package tests.daoTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import daos.RaceDao;
import models.Data;
import models.Race;
import models.Horse;

public class RaceDaoTest {
	RaceDao raceDaoTest;
	
	@Test
	public void getRacesTestNotNull() {
		raceDaoTest = new RaceDao();
		assertNotNull(raceDaoTest.getAllRaces());
	}
	
	@Test
	public void addRaceToListTestOk() {
		Race race = new Race();
		raceDaoTest = new RaceDao();
		assertTrue(raceDaoTest.addRaceToList(race));
	}
	
	
	@Test
	public void deleteRaceToListTestOk() {
		Race race = new Race();
		raceDaoTest = new RaceDao();
		raceDaoTest.getRaces().add(race);
		assertTrue(raceDaoTest.deleteRaceToList(race));
	}
	
	@Test
	public void AddHorseToRaceTestOk() {
		raceDaoTest = new RaceDao();
		Race f = new Race();
		Horse s = new Horse();
		assertTrue(raceDaoTest.addHorseToRace(s,f));
	}
	
	@Test
	public void DeleteHorseToRaceTestOk() {
		raceDaoTest = new RaceDao();
		Race f = new Race();
		Horse s = new Horse();
		Data.getRaces().add(f);
		Data.getRaces().get(0).getHorses().add(s);
		assertTrue(raceDaoTest.deleteHorseFromRace(s, f));
		assertEquals(0,raceDaoTest.getAllRaces().get(0).getHorses().size());
	}
	
	@Test
	public void getHorseFromRaceByHorseNameTestOk() {
		raceDaoTest = new RaceDao();
		Race f = new Race();
		Horse s = new Horse("HorseTest");
		Data.getRaces().add(f);
		Data.getRaces().get(0).getHorses().add(s);
		assertNotNull(raceDaoTest.getHorseFromRaceByHorseName(f, "HorseTest"));
	}
	
	@Test
	public void getHorseFromRaceByHorseNameTestReturnNull() {
		raceDaoTest = new RaceDao();
		Race f = new Race();
		Data.getRaces().add(f);
		assertNull(raceDaoTest.getHorseFromRaceByHorseName(f, "HorseTest"));
	}
	
	@Test
	public void getHorseFromRaceByHorseNameTestIsNull() {
		raceDaoTest = new RaceDao();
		assertNull(raceDaoTest.getHorseFromRaceByHorseName(null, "HorseTest"));
	}
	
	@Test
	public void updateRaceNameTest() {
		raceDaoTest = new RaceDao();
		Race f = new Race("Test");
		String newName = "Test2";
		Data.getRaces().add(f);
		raceDaoTest.updateRaceName(f, newName);
		assertTrue(raceDaoTest.getAllRaces().get(0).getName().equals(newName));
	}
	
	
	
}
