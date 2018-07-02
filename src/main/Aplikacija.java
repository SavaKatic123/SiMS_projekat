package main;

import java.util.ArrayList;

import model.Korisnik;

public class Aplikacija {
	public static Aplikacija instance = null;
	public ArrayList<Korisnik> listaKorisnika;
	
	private Aplikacija () {
		listaKorisnika = new ArrayList<Korisnik>();
	}
	
	public static Aplikacija getInstance() {
		if (instance == null) {
			instance = new Aplikacija();
		}
		return instance;
	}
	
	public void dodajKorisnika(Korisnik k) {
		listaKorisnika.add(k);
	}
	
	public void izmeniKorisnika(Korisnik k) {
		//TODO: Implement
	}
	
	public void obrisiKorisnika(Korisnik k) {
		//TODO: Implement
	}
}
