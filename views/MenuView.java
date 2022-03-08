package views;

import controllers.RaceController;
import daos.HorseDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
		System.out.println("1 Cr�er un race");
		System.out.println("2-afficher les races");
		System.out.println("3-Suppr une Race ");
		System.out.println("4-Update Race name");
		System.out.println("5-cr�er un horse");
		System.out.println("6-afficher les horse");
		System.out.println("7-Suppr une horse");
		System.out.println("8-Update horseName");
		
		switch (Utilitaire.saisieString()) {
		
		case "1":
			System.out.println("1 Cr�er un race");
			System.out.println("Saisissez un nom de race : ");
			raceName = Utilitaire.saisieString();
			System.out.println("Saisissez une date au race (yyyy-MM-dd HH:mm): ");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime raceDate = LocalDateTime.parse(Utilitaire.saisieString(), formatter);
			System.out.println("Saisissez le nom des horses : ");
			List<Horse> horses = null;
			for (int i = 1; i <= 6; i++) {
				System.out.println("     Saisissez le nom du horse " + i + " : ");
				String horsename = Utilitaire.saisieString();
				Horse h = HorseDao.getHorseByName(horsename);
				if (h != null) {
					System.out.println("	Vous devez enregistrez nun horse valide");
					i--;
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
			System.out.println("Saisissez un nom du race � supprimer : ");
			raceController.printRaces();
			raceName = Utilitaire.saisieString();
				if(raceController.deleteRaceByName(raceName))
					System.out.println("La suppression a r�ussi");
				else
					System.out.println("La suppression a �chou�");
				
			break;
			
		case "4":
			System.out.println("4-Update Race name");
			System.out.println("Saisissez un nom du race � modifier : ");
			raceController.printRaces();
			raceName = Utilitaire.saisieString();
			System.out.println("Saisissez le nouveau nom du race : ");
			String newRaceName = Utilitaire.saisieString();
				if(raceController.deleteRaceByName(raceName))
					System.out.println("La modification a r�ussi");
				else
					System.out.println("La modification a �chou�");
				
			break;
			
		case "5":
			System.out.println("5-cr�er un horse");
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
			System.out.println("Saisissez un nom du horse � supprimer : ");
			HorseController.printHorses();
			raceName = Utilitaire.saisieString();
				if(HorseController.deleteHorseByName(raceName))
					System.out.println("La suppression a r�ussi");
				else
					System.out.println("La suppression a �chou�");
			
			break;
			
		case "8":
			System.out.println("8-Update horseName");
			System.out.println("Saisissez un nom du horse � modifier : ");
			HorseController.printHorses();
			horseName = Utilitaire.saisieString();
			System.out.println("Saisissez le nouveau nom du race : ");
			String newHorseNmae = Utilitaire.saisieString();
				if(horseController.deleteHorseByName(horseName))
					System.out.println("La modification a r�ussi");
				else
					System.out.println("La modification a �chou�");
				
			break;

		default:
			break;
		}
	}
}
