package main;

import gui.MainWindow;
import izvestaj.Izvestaj;
import model.Korisnik;
import model.NaplatnaStanica;
import utility.Utility;

public class Main {

	public static void main(String[] args) {
		Aplikacija.getInstance();
		Utility.ucitajKorisnike();
		//Utility.ucitajDeonice();
		//Utility.kreirajFajlove();
		Utility.ucitaj();
		start();
		
		
		
	}

	public static void start() {
		Korisnik aktivan = Utility.logIn();
		
		if (aktivan != null) {
			for(NaplatnaStanica ns: Aplikacija.getInstance().listaNaplatnihStanica) {
				System.out.println(ns);
			}
			Izvestaj.inicirajIzvestaj();
			MainWindow w = new MainWindow(aktivan.getVrsta().toString(), aktivan);
		}
		else {
			System.exit(0);
		}
	
		
	}
	
}


