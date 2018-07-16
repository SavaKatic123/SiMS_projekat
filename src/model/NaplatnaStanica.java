package model;

import izvestaj.Izvestaj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import main.Aplikacija;

@SuppressWarnings("serial")
public class NaplatnaStanica implements Serializable {
	private String nazivStanice;
	private Korisnik sef;
	ArrayList<NaplatnoMesto> listaNaplatnihMesta;
	public ArrayList<Izvestaj> listaIzvestaja;
	
	public String getNazivStanice() {
		return nazivStanice;
	}
	public void setNazivStanice(String nazivStanice) {
		this.nazivStanice = nazivStanice;
	}
	
	public ArrayList<NaplatnoMesto> getListaNaplatnihMesta() {
		return listaNaplatnihMesta;
	}
	public void setListaNaplatnihMesta(ArrayList<NaplatnoMesto> listaNaplatnihMesta) {
		this.listaNaplatnihMesta = listaNaplatnihMesta;
	}
	
	public Korisnik getSef() {
		return sef;
	}
	public void setSef(Korisnik sef) {
		this.sef = sef;
	}
	public ArrayList<Izvestaj> getListaIzvestaja() {
		return listaIzvestaja;
	}
	public void setListaIzvestaja(ArrayList<Izvestaj> listaIzvestaja) {
		this.listaIzvestaja = listaIzvestaja;
	}
	public NaplatnaStanica(String nazivStanice) {
		this.nazivStanice = nazivStanice;
	}
	
	public NaplatnaStanica() {
		super();
		listaNaplatnihMesta = new ArrayList<NaplatnoMesto>();
		listaIzvestaja = new ArrayList<Izvestaj>();
	}
	@Override
	public String toString() {
		return "NaplatnaStanica [nazivStanice=" + nazivStanice + ", sef=" + sef
				+ ", listaNaplatnihMesta=" + listaNaplatnihMesta
				+ ", listaIzvestaja=" + listaIzvestaja + "]";
	}
	
	
	public void dodajNaplatnoMesto(NaplatnoMesto nm) {
		boolean pronadjen = false;
		for(NaplatnoMesto napm: listaNaplatnihMesta) {
			if (napm.equals(nm)) {
				pronadjen = true;
			}
		}
		if (!pronadjen) {
			listaNaplatnihMesta.add(nm);
		}
	}
	
	public void izmeniNaplatnoMesto(NaplatnoMesto nm) {
		for (int i = 0; i < listaNaplatnihMesta.size(); i++) {
			if (nm.equals(listaNaplatnihMesta.get(i))) {
				listaNaplatnihMesta.get(i).setAktivno(nm.isAktivno());
				listaNaplatnihMesta.get(i).setId(nm.getId());
				listaNaplatnihMesta.get(i).setListaKvarova(nm.getListaKvarova());
				listaNaplatnihMesta.get(i).setListaNaplata(nm.getListaNaplata());
				listaNaplatnihMesta.get(i).setOperater(nm.getOperater());
				listaNaplatnihMesta.get(i).setRampa(nm.getRampa());
				listaNaplatnihMesta.get(i).setStanjeNaplate(nm.getStanjeNaplate());
			}
		}
		
		
	}
	
	public void obrisiKorisnika(NaplatnoMesto nm) {
		for (int i = 0; i < listaNaplatnihMesta.size(); i++) {
			if (nm.equals(listaNaplatnihMesta.get(i))) {
				listaNaplatnihMesta.remove(i);
			}
			
		}
	}
	

	//HELPER KONSTRUKTOR - obrisati kad vise nije potreban
	public NaplatnaStanica(String nazivStanice, int idx, Korisnik k) {
		super();
		this.nazivStanice = nazivStanice;
		MestoObicneNaplate m = new MestoObicneNaplate(true, idx, new Rampa());
		
		this.listaNaplatnihMesta = new ArrayList<NaplatnoMesto>(Arrays.asList(
				m,
				new MestoElektronskeNaplate(true, idx + 1, new Rampa()),
				new MestoElektronskeNaplate(true, idx + 2, new Rampa()),
				new MestoObicneNaplate(true, idx + 3, new Rampa())));
		this.listaIzvestaja = new ArrayList<Izvestaj>();
		if(idx == 1) {
			for(Korisnik kor: Aplikacija.getInstance().listaKorisnika) {
				if(kor.getKorisnickoIme().equals("pera")) {
					m.setOperater(kor);
				}
				if(kor.getKorisnickoIme().equals("zika")) {
					this.sef = kor;
				}
			}
		}
	}
	
	
	
}
