package utils;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import models.Horse;
import models.Race;

public class Utilitaire {
	
	public static String saisieString() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static void WhoWin(Race _race) {
		List<Horse> horses = _race.getHorses();
		int nbHorses = horses.size();
		Random r = new Random();
		int result = r.nextInt(0-nbHorses-1) + 5;
		_race.SetWinner(horses.get(result));
	}

}
