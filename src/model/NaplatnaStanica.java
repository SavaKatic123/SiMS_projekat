package model;

import izvestaj.Izvestaj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("serial")
public class NaplatnaStanica implements Serializable {
	private String nazivStanice;
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
		if(idx == 1) {
			m.setOperater(k);
		}
		this.listaNaplatnihMesta = new ArrayList<NaplatnoMesto>(Arrays.asList(
				m,
				new MestoElektronskeNaplate(true, idx + 1, new Rampa()),
				new MestoElektronskeNaplate(true, idx + 2, new Rampa()),
				new MestoObicneNaplate(true, idx + 3, new Rampa())));
		this.listaIzvestaja = new ArrayList<Izvestaj>();
	}
	@Override
	public String toString() {
		return "NaplatnaStanica [nazivStanice=" + nazivStanice
				+ ", listaNaplatnihMesta=" + listaNaplatnihMesta
				+ ", listaIzvestaja=" + listaIzvestaja + "]";
	}
	
	
	
	
	
}
