package tests.daoTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import daos.HorseDao;
import daos.RaceDao;
import models.Data;
import models.Horse;
import models.Race;

public class HorseDaoTest {
	HorseDao horseDaoTest;
	
	@Test
	public void getHorsesTestNotNull() {
		horseDaoTest = new HorseDao();
		assertNotNull(horseDaoTest.getAllHorses());
	}
	
	@Test
	public void addRaceToListTestOk() {
		Horse horse = new Horse();
		horseDaoTest = new HorseDao();
		assertTrue(horseDaoTest.addHorseToList(horse));
	}
	
	
	@Test
	public void deleteRaceToListTestOk() {
		Horse horse = new Horse();
		horseDaoTest = new HorseDao();
		horseDaoTest.getHorses().add(horse);
		assertTrue(horseDaoTest.deleteHorseToList(horse));
	}
	
	@Test
	public void updateRaceNameTest() {
		horseDaoTest = new HorseDao();
		Horse horse = new Horse("test");
		String newName = "Test2";
		Data.getHorses();
		horseDaoTest.updateHorseName(horse, newName);
		assertTrue(horseDaoTest.getAllHorses().get(0).getName().equals(newName));
	}
}
