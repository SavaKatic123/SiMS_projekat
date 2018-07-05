package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import enumTypes.VrstaKorisnika;
import model.Korisnik;
import model.Deonica;
import utility.Login;
import utility.UcitavanjeDeonica;

public class Main {

	public static void main(String[] args) {
		Aplikacija.getInstance();
		
		Login.citajIzFajla();
		boolean uspesno = Login.logIn();
		
		if (uspesno) {
			UcitavanjeDeonica.ucitajDeonice();
			
		}
	}

	
}


