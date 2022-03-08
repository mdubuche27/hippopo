package tests.daoTests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import daos.GroupeDao;
import models.Groupe;
import models.Scene;

public class GroupeDaoTest {
	
	GroupeDao gDao;
	
	@BeforeEach
	public void initTest() {
		gDao = new GroupeDao();
	}
	
	@Test
	public void createGroupeTestOk() {
		assertNotNull(gDao.createGroupe("Group1", 0));
	}
	
	@Test
	public void updateGroupeNameTest() {
		Groupe g = new Groupe();
		assertTrue(gDao.updateGroupe(g, "New Name"));
	}
	
	@Test
	public void updateGroupeNameTestKO() {
		Groupe g = null;
		assertFalse(gDao.updateGroupe(g, "New Name"));
	}
	
	
}
