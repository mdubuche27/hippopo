package controllers;

import views.MenuView;

public class Main {

	public static void main(String[] args) {
		MenuView menu = new MenuView();
		menu.bonjour();
		while(true) {
			menu.choix();
		}
	}
}
