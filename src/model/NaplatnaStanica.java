package model;

import izvestaj.Izvestaj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("serial")
public class NaplatnaStanica implements Serializable {
	private String nazivStanice;
	private ArrayList<NaplatnoMesto> listaNaplatnihMesta;
	private ArrayList<Izvestaj> listaIzvestaja;
	
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
		super();
		this.nazivStanice = nazivStanice;
		this.listaNaplatnihMesta = new ArrayList<NaplatnoMesto>(Arrays.asList(
				new MestoElektronskeNaplate(true, 1, new Rampa()),
				new MestoElektronskeNaplate(true, 2, new Rampa()),
				new MestoObicneNaplate(true, 3, new Rampa()),
				new MestoObicneNaplate(true, 4, new Rampa()),
				new MestoObicneNaplate(true, 5, new Rampa())));
		this.listaIzvestaja = new ArrayList<Izvestaj>();
	}
	@Override
	public String toString() {
		return "NaplatnaStanica [nazivStanice=" + nazivStanice
				+ ", listaNaplatnihMesta=" + listaNaplatnihMesta
				+ ", listaIzvestaja=" + listaIzvestaja + "]";
	}
	
	
	
	
	
}
