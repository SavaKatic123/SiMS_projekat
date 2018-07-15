package main;

import java.util.ArrayList;

import model.Deonica;
import model.Korisnik;
import model.NaplatnaStanica;

public class Aplikacija {
	public static Aplikacija instance = null;
	public ArrayList<Korisnik> listaKorisnika;
	public ArrayList<Deonica> listaDeonica;
	public ArrayList<NaplatnaStanica> listaNaplatnihStanica;
	
	private Aplikacija () {
		listaKorisnika = new ArrayList<Korisnik>();
		listaDeonica = new ArrayList<Deonica>();
		listaNaplatnihStanica = new ArrayList<NaplatnaStanica>();
	}
	
	public static Aplikacija getInstance() {
		if (instance == null) {
			instance = new Aplikacija();
		}
		return instance;
	}
	
	public void dodajKorisnika(Korisnik korisnik) {
		boolean pronadjen = false;
		for(Korisnik k: listaKorisnika) {
			if (k.equals(korisnik)) {
				pronadjen = true;
			}
		}
		if (!pronadjen) {
			listaKorisnika.add(korisnik);
		}
	}
	
	public void izmeniKorisnika(Korisnik k) {
		for (int i = 0; i < listaKorisnika.size(); i++) {
			if (k.getKorisnickoIme().equals(listaKorisnika.get(i).getKorisnickoIme())) {
				
				listaKorisnika.get(i).setLozinka(k.getLozinka());
				listaKorisnika.get(i).setVrsta(k.getVrsta());
			}
		}
		
	}
	
	public void obrisiKorisnika(Korisnik k) {
		for (int i = 0; i < listaKorisnika.size(); i++) {
			if (k.getKorisnickoIme().equals(listaKorisnika.get(i).getKorisnickoIme())) {
				listaKorisnika.remove(i);
			}
			
		}
	}
	
	public void dodajDeonicu(Deonica d) {
		boolean pronadjen = false;
		for (Deonica deonica: listaDeonica) {
			if (deonica.equals(d)) {
				pronadjen = true;
			}
		}
		if (!pronadjen) {
			listaDeonica.add(d);			
		}
	}
	
	public void dodajNaplatnuStanicu(NaplatnaStanica ns) {
		boolean pronadjen = false;
		for (NaplatnaStanica naplatnaStanica: listaNaplatnihStanica) {
			if (naplatnaStanica.getNazivStanice().equals(ns.getNazivStanice())) {
				pronadjen = true;
			}
		}
		if (!pronadjen) {
			listaNaplatnihStanica.add(ns);			
		}
	}
	
	public void obrisiNaplatnuStanicu(NaplatnaStanica ns) {
		boolean pronadjena = false;
		for (int i = 0; i < listaNaplatnihStanica.size(); i++) {
			if (listaNaplatnihStanica.get(i).getNazivStanice().equals(ns.getNazivStanice())) {
				listaNaplatnihStanica.remove(i);
			}
		}
		
	}
	
	public void izmenaNaplatneStanice(NaplatnaStanica ns) {
		for (int i = 0; i < listaNaplatnihStanica.size(); i++) {
			if (ns.getNazivStanice().equals(listaNaplatnihStanica.get(i).getNazivStanice())) {
				listaNaplatnihStanica.get(i).setListaIzvestaja(ns.getListaIzvestaja());
				listaNaplatnihStanica.get(i).setListaNaplatnihMesta(ns.getListaNaplatnihMesta());
				listaNaplatnihStanica.get(i).setSef(ns.getSef());
			}
		}
	}
	
}
