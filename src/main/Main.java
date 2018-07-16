package main;

import gui.MainWindow;
import izvestaj.Izvestaj;
import model.Korisnik;
import utility.Utility;

public class Main {

	public static void main(String[] args) {
		Aplikacija.getInstance();
		Utility.ucitajKorisnike();
		
		Utility.ucitaj();
		start();
	}

	public static void start() {
		Korisnik aktivan = Utility.logIn();
		
		if (aktivan != null) {
			//Utility.ucitajDeonice(aktivan);
			//Utility.kreirajFajlove();
			Izvestaj.inicirajIzvestaj();
			MainWindow w = new MainWindow(aktivan.getVrsta().toString(), aktivan);
		}
		else {
			System.exit(0);
		}
	
		
	}
	
}


