package main;

import gui.MainWindow;
import model.Korisnik;
import utility.Utility;

public class Main {

	public static void main(String[] args) {
		Aplikacija.getInstance();
		
		Utility.ucitajKorisnike();
		Korisnik aktivan = Utility.logIn();
		
		if (aktivan != null) {
			Utility.ucitaj();
			MainWindow w = new MainWindow("Menu", aktivan);
		}
	}

	
}


