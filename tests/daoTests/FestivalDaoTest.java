package tests.daoTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import daos.FestivalDao;
import models.Data;
import models.Festival;
import models.Scene;

public class FestivalDaoTest {
	FestivalDao festivalDaoTest;
	
	@Test
	public void getFestivalsTestNotNull() {
		festivalDaoTest = new FestivalDao();
		assertNotNull(festivalDaoTest.getAllFestivals());
	}
	
	@Test
	public void addFestivalToListTestOk() {
		Festival festival = new Festival();
		festivalDaoTest = new FestivalDao();
		assertTrue(festivalDaoTest.addFestivalToList(festival));
	}
	
	
	@Test
	public void deleteFestivalToListTestOk() {
		Festival festival = new Festival();
		festivalDaoTest = new FestivalDao();
		festivalDaoTest.getFestivals().add(festival);
		assertTrue(festivalDaoTest.deleteFestivalToList(festival));
	}
	
	@Test
	public void AddSceneToFestivalTestOk() {
		festivalDaoTest = new FestivalDao();
		Festival f = new Festival();
		Scene s = new Scene();
		assertTrue(festivalDaoTest.addSceneToFestival(s,f));
	}
	
	@Test
	public void DeleteSceneToFestivalTestOk() {
		festivalDaoTest = new FestivalDao();
		Festival f = new Festival();
		Scene s = new Scene();
		Data.getFestivals().add(f);
		Data.getFestivals().get(0).getScenes().add(s);
		assertTrue(festivalDaoTest.deleteSceneFromFestival(s, f));
		assertEquals(0,festivalDaoTest.getAllFestivals().get(0).getScenes().size());
	}
	
	@Test
	public void getSceneFromFestivalBySceneNameTestOk() {
		festivalDaoTest = new FestivalDao();
		Festival f = new Festival();
		Scene s = new Scene("SceneTest");
		Data.getFestivals().add(f);
		Data.getFestivals().get(0).getScenes().add(s);
		assertNotNull(festivalDaoTest.getSceneFromFestivalBySceneName(f, "SceneTest"));
	}
	
	@Test
	public void getSceneFromFestivalBySceneNameTestReturnNull() {
		festivalDaoTest = new FestivalDao();
		Festival f = new Festival();
		Data.getFestivals().add(f);
		assertNull(festivalDaoTest.getSceneFromFestivalBySceneName(f, "SceneTest"));
	}
	
	@Test
	public void getSceneFromFestivalBySceneNameTestIsNull() {
		festivalDaoTest = new FestivalDao();
		assertNull(festivalDaoTest.getSceneFromFestivalBySceneName(null, "SceneTest"));
	}
	
	@Test
	public void updateFestivalNameTest() {
		festivalDaoTest = new FestivalDao();
		Festival f = new Festival("Test");
		String newName = "Test2";
		Data.getFestivals().add(f);
		festivalDaoTest.updateFestivalName(f, newName);
		assertTrue(festivalDaoTest.getAllFestivals().get(0).getName().equals(newName));
	}
	
	
	
}
