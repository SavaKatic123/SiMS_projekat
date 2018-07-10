package main;

import model.Deonica;
import utility.Utility;

public class Main {

	public static void main(String[] args) {
		Aplikacija.getInstance();
		
		Utility.ucitajKorisnike();
		boolean uspesno = Utility.logIn();
		
		if (uspesno) {
			Utility.ucitaj();
		}
	}

	
}


