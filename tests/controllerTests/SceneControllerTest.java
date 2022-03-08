package tests.controllerTests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.SceneController;
import models.Data;
import models.Festival;
import models.Groupe;
import models.Scene;

public class SceneControllerTest {

	SceneController sCtrl;
	Data d = new Data();
	
	@BeforeEach
	public void initTest() {
		sCtrl=new SceneController();
	}
	/*
	@Test
	public void addGroupeToSceneTestOk() {
		Scene scene = new Scene("SceneTest");
		Groupe groupe = new Groupe("GroupeTest",5);
		assertEquals("",sCtrl.addGroupeToScene(scene, groupe));
		assertTrue(scene.getGroupes().size() == 1);
	}
	
	@Test
	public void addGroupeToSceneTestLessGroupe() {
		Scene scene = new Scene("SceneTest");
		assertNotEquals("",sCtrl.addGroupeToScene(scene, null));
	}
	@Test
	public void addGroupeToSceneTestLessScene() {
		Groupe groupe = new Groupe("GroupeTest",5);
		assertNotEquals("",sCtrl.addGroupeToScene(null, groupe));
	}
	*/
		
	SceneController sc = new SceneController();
		
	@Test
	public void addGroupeToSceneOk() {
		Festival festival = new Festival("fName");
		Scene scene = new Scene("sName");
		Data.getFestivals().add(festival);
		festival.getScenes().add(scene);
		
		String sName = "sName";
		String fName = "fName";
		String gName = "gName";
		assertTrue(sc.createGroupeAndAddToScene(fName, sName, gName));	
	}
	
	@Test
	public void addGroupeToNotExistingSceneKO() {
		Festival festival = new Festival("fName");
		Scene scene = new Scene("sName");
		Data.getFestivals().add(festival);
		//festival.getScenes().add(scene);
		
		String sName = "sName";
		String fName = "fName";
		String gName = "gName";
		assertFalse(sc.createGroupeAndAddToScene(fName, sName, gName));	
	}
	
	@Test
	public void deleteGroupeTestOk() {
		Festival festival = new Festival("fName");
		Scene scene = new Scene("sName");
		Groupe groupe = new Groupe("gName");
		
		Data.getFestivals().add(festival);
		festival.getScenes().add(scene);
		scene.getGroupes().add(groupe);
		
		String sName = "sName";
		String fName = "fName";
		String gName = "gName";
		
		assertTrue(sc.supGroupeFromScene(fName, sName, gName));	

	}
	
	
	
	
	
	
	
	
}
