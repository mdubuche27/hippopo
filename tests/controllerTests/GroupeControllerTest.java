package tests.controllerTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.GroupeController;

public class GroupeControllerTest {
	GroupeController gCtrl;
	
	@BeforeEach
	public void initTest() {
		gCtrl=new GroupeController();
	}
	
	@Test
	public void createGroupeTestOk() {
		assertNotNull(gCtrl.createGroupe("Groupe", 5));
	}
	
	@Test
	public void createGroupeTestLessGroupeName() {
		assertNull(gCtrl.createGroupe(null, 5));
	}
}
