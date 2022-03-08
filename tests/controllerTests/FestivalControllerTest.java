package tests.controllerTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import controllers.FestivalController;
import models.Data;
import models.Festival;
import models.Scene;

public class FestivalControllerTest {

	FestivalController fc = new FestivalController();
	
	@Test
	public void createFestivalTestOk() {
		fc.createFestival("festivalTest",2022);
		assertTrue(Data.getFestivals().get(Data.getFestivals().size()-1).getName().equals("festivalTest") &&
				Data.getFestivals().get(Data.getFestivals().size()-1).getYear() == 2022);
	}
	
	@Test
	public void deleteFestivalTestOk() {
		String festivalName = "festivalTest";
		Data.getFestivals().add(new Festival(festivalName));
		fc.deleteFestivalByName(festivalName);
		assertFalse(Data.getFestivals().contains(festivalName));
	}
	
	@Test
	public void deleteFestivalTestNotExist() {
		assertFalse(fc.deleteFestivalByName("festivalName"));
	}
	
	@Test
	public void createSceneAndAddToFestivalTest() {
		Data.getFestivals().add(new Festival("Festival"));
		Data.getFestivals().get(0).getScenes().add(new Scene("Scene"));
		assertTrue(fc.createSceneAndAddToFestival("Festival","Scene"));
	}
	
	@Test
	public void deleteSceneFromFestivalTestWhenFestivalExistAndSceneExist() {
		Data.getFestivals().add(new Festival("Festival"));
		Data.getFestivals().get(0).getScenes().add(new Scene("Scene"));
		
		assertTrue(fc.deleteSceneFromFestival("Festival","Scene"));
	}
	
	@Test
	public void deleteSceneFromFestivalTestWhenFestivalExistAndSceneNotExist() {
		Data.getFestivals().add(new Festival("Festival"));
		
		assertFalse(fc.deleteSceneFromFestival("Festival","Scene"));
	}
	
	@Test
	public void deleteSceneFromFestivalTestWhenFestivalAndSceneNotExist() {
		assertFalse(fc.deleteSceneFromFestival("Festival","Scene"));
	}
	
	@Test
	public void updateFestivalNameTest() {
		Data.getFestivals().add(new Festival("Festival"));
		assertTrue(fc.updateFestivalName("Festival", "Festival2"));
	}
	
	@Test
	public void createGroupeAndAddGroupeInSceneSelectedToFestivalSelectedTestOk() {
		Festival f = new Festival("Festival",2000);
		Scene s = new Scene("Scene");
		f.getScenes().add(s);
		Data.getFestivals().add(f);
		assertEquals("",fc.createGroupeAndAddGroupeInSceneSelectedToFestivalSelected(f.getName(), s.getName(), "Groupe1", 78));
		//assertEquals(1,s.getGroupes().size());
	}
	
	@Test
	public void createGroupeAndAddGroupeInSceneSelectedToFestivalSelectedTestLessFestival() {
		Scene s = new Scene("Scene");
		assertNotEquals("",fc.createGroupeAndAddGroupeInSceneSelectedToFestivalSelected(null, s.getName(), "Groupe1", 78));
		assertEquals(0,s.getGroupes().size());
	}
	
	@Test
	public void createGroupeAndAddGroupeInSceneSelectedToFestivalSelectedTestLessScene() {
		Festival f = new Festival("Festival",2000);
		Data.getFestivals().add(f);
		assertNotEquals("",fc.createGroupeAndAddGroupeInSceneSelectedToFestivalSelected(f.getName(), null, "Groupe1", 78));
	}
	
	@Test
	public void createGroupeAndAddGroupeInSceneSelectedToFestivalSelectedTestLessGroupeName() {
		Festival f = new Festival("Festival",2000);
		Scene s = new Scene("Scene");
		f.getScenes().add(s);
		Data.getFestivals().add(f);
		assertNotEquals("",fc.createGroupeAndAddGroupeInSceneSelectedToFestivalSelected(f.getName(), s.getName(), null, 78));
		assertEquals(0,s.getGroupes().size());
	}
}
