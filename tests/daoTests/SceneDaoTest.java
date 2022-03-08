package tests.daoTests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import daos.SceneDao;
import models.Groupe;
import models.Scene;

public class SceneDaoTest {

	SceneDao sceneDao = new SceneDao();
	
	@Test
	public void addGroupeToSceneTest(){
		Groupe g = new Groupe();
		Scene s = new Scene();
		assertTrue(sceneDao.createGroupeToScene(g, s));
	}
	
	@Test
	public void addGroupeToNullSceneTest() {
		Groupe g = new Groupe();
		Scene s = null;
		assertFalse(sceneDao.createGroupeToScene(g, s));
	}
	
	
	@Test
	public void addNullGroupeToSceneTest() {
		Groupe g = null;
		Scene s = new Scene();
		assertFalse(sceneDao.createGroupeToScene(g, s));
	}
	
	
	
	@Test
	public void deleteGroupeFromSceneTest() {
		Groupe g = new Groupe();
		Scene s = new Scene();
		s.getGroupes().add(g);
		assertTrue(sceneDao.deleteGroupeFromScene(g, s));
	}
	
	@Test
	public void deleteGroupeNotInScene() {
		Groupe g = new Groupe();
		Scene s = new Scene();
		assertFalse(sceneDao.deleteGroupeFromScene(g, s));
	}


}
