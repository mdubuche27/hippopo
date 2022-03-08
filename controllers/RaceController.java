package controllers;

import java.time.LocalDateTime;
import java.util.List;

import daos.RaceDao;
import models.Data;
import models.Horse;
import models.Race;

public class RaceController {

	RaceDao raceDao;
	HorseController horseController;
	
	public RaceController() {
		raceDao = new RaceDao();
		horseController = new HorseController();
	}
	
	public void createRace(String name,LocalDateTime date, List<Horse> horses) {
		Race f = new Race(name, date, horses );
		raceDao.addRaceToList(f);
	}
	
	public boolean deleteRaceByName(String name) {
		Race race = raceDao.getRaceByName(name);
		if(race == null)
			return false;
		raceDao.deleteRaceToList(race);
		return true;
	}
	
	public void printRaces() {
		for(Race f : Data.getRaces()) {
			System.out.println(f.getName());
		}
	}
	
	public boolean AddHorseToRace(String raceName,Horse horse){
		Race race = raceDao.getRaceByName(raceName);
		if(race == null) {
			return false;
		}
		return raceDao.addHorseToRace(horse, race);
	}
	
	public boolean deleteHorseFromRace(String raceName,String horseName) {
		Race race = raceDao.getRaceByName(raceName);
		if(race == null) {
			return false;
		}
		Horse s = raceDao.getHorseFromRaceByHorseName(race, horseName);
		if(s == null) {
			return false;
		}
		return raceDao.deleteHorseFromRace(s, race);
	}
	
	public boolean printAllHorsesNameByRaceName(String raceName) {
		Race race = raceDao.getRaceByName(raceName);
		if(race == null) {
			return false;
		}
		System.out.println("Voici les sc�nes du race : ");
		for(Horse s : race.getHorses()) {
			System.out.println(s.getName());
		}
		return true;
	}
	
	public boolean updateRaceName(String oldRaceName,String newRaceName) {
		if(raceDao.getRaceByName(newRaceName) != null) {
			return false;
		}
		Race race = raceDao.getRaceByName(oldRaceName);
		if(race == null) {
			return false;
		}
		raceDao.updateRaceName(race, newRaceName);
		return race.getName().equals(newRaceName);
	}
	

	public void printAllHorses() {
		for (Race race : raceDao.getAllRaces()) {
			for (Horse horse : race.getHorses()) {
				System.out.println(horse.getName());
			};
		}
	}
	
	public Race getRaceByName(String raceName) {
		return raceDao.getRaceByName(raceName);
	}
}
