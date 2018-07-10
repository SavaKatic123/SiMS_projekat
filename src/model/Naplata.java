package model;

import java.io.Serializable;

import enumTypes.VrstaVozila;

@SuppressWarnings("serial")
public class Naplata implements Serializable {
	private String regBr;
	private double cena;
	private VrstaVozila vrstaVozila;
	public String getRegBr() {
		return regBr;
	}
	public void setRegBr(String regBr) {
		this.regBr = regBr;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public VrstaVozila getVrstaVozila() {
		return vrstaVozila;
	}
	public void setVrstaVozila(VrstaVozila vrstaVozila) {
		this.vrstaVozila = vrstaVozila;
	}
	
	@Override
	public String toString() {
		return "Naplata [regBr=" + regBr + ", cena=" + cena + ", vrstaVozila="
				+ vrstaVozila + "]";
	}
	public Naplata(String regBr, double cena, VrstaVozila vrstaVozila) {
		super();
		this.regBr = regBr;
		this.cena = cena;
		this.vrstaVozila = vrstaVozila;
	}
	
	
	
}
