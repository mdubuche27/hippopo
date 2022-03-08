package tests.controllerTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import controllers.HorseController;
import controllers.RaceController;
import models.Data;
import models.Race;
import models.Horse;

public class HorseControllerTest {

	HorseController hController = new HorseController();
	
	@Test
	public void createHorseTestOk() {
		hController.createHorse("horsTest", 21 );
		assertTrue(Data.getHorses().get(Data.getHorses().size()-1).getName().equals("horsTest") &&
				Data.getHorses().get(Data.getHorses().size()-1).getAge() == 21);
	}
	
	@Test
	public void deleteHorseTestOk() {
		String horseName = "horsTest";
		Data.getHorses().add(new Horse(horseName));
		hController.deleteHorseByName(horseName);
		assertFalse(Data.getHorses().contains(horseName));
	}
	
	@Test
	public void deleteHorseTestNotExist() {
		assertFalse(hController.deleteHorseByName("horsTest"));
	}
	
	@Test
	public void updateHorseNameTest() {
		Data.getHorses().add(new Horse("Horse"));
		assertTrue(hController.updateHorseName("Horse", "Horse2"));
	}
}
