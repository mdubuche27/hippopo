package views;

import controllers.RaceController;
import daos.HorseDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import controllers.HorseController;
import models.Race;
import models.Horse;
import utils.Utilitaire;

public class MenuView {
	
	RaceController raceController;
	HorseController horseController;
	
	public MenuView() {
		raceController = new RaceController();
		horseController = new HorseController();
	}
	
	public void bonjour() {
		System.out.println("Bonjour !");
	}
	
	String raceName;
	String horseName;
	
	public void choix() {
	    
	    //menu
		System.out.println("Quel action souhaitez-vous faire ?");
		System.out.println("1 Créer un race");
		System.out.println("2-afficher les races");
		System.out.println("3-Suppr une Race ");
		System.out.println("4-Update Race name");
		System.out.println("5-créer un horse");
		System.out.println("6-afficher les horse");
		System.out.println("7-Suppr une horse");
		System.out.println("8-Update horseName");
		System.out.println("9-Ajouter Horse a Race");
		System.out.println("a- Suppr Horse de Race");
		System.out.println("b- Afficher les horse d'une Race");
		
		switch (Utilitaire.saisieString()) {
		
		case "1":
			System.out.println("1 Créer un race");
			System.out.println("Saisissez un nom de race : ");
			raceName = Utilitaire.saisieString();
			System.out.println("Saisissez une date au race (yyyy-MM-dd HH:mm): ");
			String inter = Utilitaire.saisieString();
			System.out.println(inter);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime raceDate = LocalDateTime.parse(inter, formatter);
			System.out.println("Saisissez le nom des horses : ");
			HorseController.printHorses();
			List<Horse> horses = new ArrayList<Horse>();
			for (int i = 1; i <= 6; i++) {
				System.out.println("     Saisissez le nom du horse " + i + " : ");
				String horsename = Utilitaire.saisieString();
				Horse h = horseController.getHorseByName(horsename);
				if (h == null) {
					System.out.println("	Vous devez enregistrez un horse valide");
					choix();
				}
				else {
					horses.add(h);
				}
			}
			raceController.createRace(raceName, raceDate, horses);
			
			break;
			
		case "2":
			raceController.printRaces();
			
			break;
			
		case "3":
			System.out.println("3-Suppr une Race");
			System.out.println("Saisissez un nom du race à supprimer : ");
			raceController.printRaces();
			raceName = Utilitaire.saisieString();
				if(raceController.deleteRaceByName(raceName))
					System.out.println("La suppression a réussi");
				else
					System.out.println("La suppression a échoué");
				
			break;
			
		case "4":
			System.out.println("4-Update Race name");
			System.out.println("Saisissez un nom du race à modifier : ");
			raceController.printRaces();
			raceName = Utilitaire.saisieString();
			System.out.println("Saisissez le nouveau nom du race : ");
			String newRaceName = Utilitaire.saisieString();
				if(raceController.updateRaceName(raceName, newRaceName))
					System.out.println("La modification a réussi");
				else
					System.out.println("La modification a échoué");
				
			break;
			
		case "5":
			System.out.println("5-créer un horse");
			System.out.println("Saisissez un nom de horse : ");
			horseName = Utilitaire.saisieString();
			System.out.println("Saisissez l'age de " + horseName );
			int HorseAge = Integer.parseInt(Utilitaire.saisieString());
			HorseController.createHorse(horseName, HorseAge);
			
			break;
			
		case "6":
			HorseController.printHorses();
			
			break;
			
		case "7":
			System.out.println("7-Suppr un horse");
			System.out.println("Saisissez un nom du horse à supprimer : ");
			HorseController.printHorses();
			raceName = Utilitaire.saisieString();
				if(HorseController.deleteHorseByName(raceName))
					System.out.println("La suppression a réussi");
				else
					System.out.println("La suppression a échoué");
			
			break;
			
		case "8":
			System.out.println("8-Update horseName");
			System.out.println("Saisissez un nom du horse à modifier : ");
			HorseController.printHorses();
			horseName = Utilitaire.saisieString();
			System.out.println("Saisissez le nouveau nom du horse : ");
			String newHorseName = Utilitaire.saisieString();
				if(horseController.updateHorseName(horseName, newHorseName))
					System.out.println("La modification a réussi");
				else
					System.out.println("La modification a échoué");
				
			break;

		case "9":
			System.out.println("9-Ajouter Horse a Race");
			System.out.println("Saisissez un nom du race : ");
			raceController.printRaces();
			raceName = Utilitaire.saisieString();
			System.out.println("Saisissez un nom du horse : ");
			HorseController.printHorses();
			horseName = Utilitaire.saisieString();
			if(raceController.AddHorseToRace(raceName, horseName))
				System.out.println("L'ajout a réussi");
			else
				System.out.println("L'ajout a échoué");
			
			break;
			
		case "a":
			System.out.println("10- Suppr Horse de Race");
			System.out.println("Saisissez un nom du race  : ");
			raceController.printRaces();
			raceName = Utilitaire.saisieString();
			System.out.println("Saisissez un nom du horse  : ");
			HorseController.printHorses();
			horseName = Utilitaire.saisieString();
			if(raceController.deleteHorseFromRace(raceName, horseName))
				System.out.println("La suppr a réussi");
			else
				System.out.println("La suppr a échoué");
			
			break;
			
		case "b":
			System.out.println("Saisissez un nom du race : ");
			raceController.printRaces();
			raceName = Utilitaire.saisieString();
			Race race = raceController.getRaceByName(raceName);
			HorseController.printHorsesFromRace(race);
			
			
		default:
			break;
		}
	}
}
