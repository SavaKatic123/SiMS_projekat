package model;

import izvestaj.Izvestaj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import main.Aplikacija;
import enumTypes.VrstaKorisnika;

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
	@Override
	public String toString() {
		return "NaplatnaStanica [nazivStanice=" + nazivStanice + ", sef=" + sef
				+ ", listaNaplatnihMesta=" + listaNaplatnihMesta
				+ ", listaIzvestaja=" + listaIzvestaja + "]";
	}
	
	
	
	
	
	
}
