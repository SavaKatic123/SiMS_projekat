package main;

import java.util.ArrayList;

import model.Deonica;
import model.Korisnik;

public class Aplikacija {
	public static Aplikacija instance = null;
	public ArrayList<Korisnik> listaKorisnika;
	public ArrayList<Deonica> listaDeonica;
	
	private Aplikacija () {
		listaKorisnika = new ArrayList<Korisnik>();
		listaDeonica = new ArrayList<Deonica>();
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
	
	public void dodajDeonicu(Deonica d) {
		listaDeonica.add(d);
	}
}
