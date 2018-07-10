package model;

import java.util.ArrayList;
import java.util.Arrays;

public class NaplatnaStanica {
	private String nazivStanice;
	private ArrayList<NaplatnoMesto> listaNaplatnihMesta;
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
	public NaplatnaStanica(String nazivStanice) {
		super();
		this.nazivStanice = nazivStanice;
		this.listaNaplatnihMesta = new ArrayList<NaplatnoMesto>(Arrays.asList(
				new MestoElektronskeNaplate(true, 1),
				new MestoElektronskeNaplate(true, 2),
				new MestoObicneNaplate(true, 3),
				new MestoObicneNaplate(true, 4),
				new MestoObicneNaplate(true, 5)));
	}
	
	@Override
	public String toString() {
		return "NaplatnaStanica [nazivStanice=" + nazivStanice
				+ ", listaNaplatnihMesta=" + listaNaplatnihMesta + "]";
	}
	
	
	
}
