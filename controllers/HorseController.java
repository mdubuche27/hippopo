package controllers;

import daos.RaceDao;

import java.time.LocalDateTime;
import java.util.List;

import daos.HorseDao;
import models.Race;
import models.Data;
import models.Horse;

public class HorseController {

	static HorseDao hDao = new HorseDao();
	RaceDao rDao = new RaceDao();

	public static void printHorses() {
		for(Horse h : Data.getHorses()) {
			System.out.println(h.getName());
		}
	}
	
	public static void printHorsesFromRace(Race Race) {
		for (Horse horse : Race.getHorses()) {
			System.out.println(horse.getName());
		} 
	}

	public static void createHorse(String name,int age){
		Horse h = new Horse(name, age);
		hDao.addHorseToList(h);
	}
	
	public static boolean deleteHorseByName(String name) {
		Horse horse = hDao.getHorseByName(name);
		if(horse == null)
			return false;
		hDao.deleteHorseToList(horse);
		return true;
	}
	
	public boolean updateHorseName(String oldHorseName,String newHorseName) {
		if(hDao.getHorseByName(newHorseName) != null) {
			return false;
		}
		Horse horse = hDao.getHorseByName(oldHorseName);
		if(horse == null) {
			return false;
		}
		hDao.updateHorseName(horse, newHorseName);
		return horse.getName().equals(newHorseName);
	}
	
	
	public Horse getHorseByName(String horsename) {
		return hDao.getHorseByName(horsename);
	}
}
