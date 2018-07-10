package model;

import java.io.Serializable;

import enumTypes.VrstaVozila;

@SuppressWarnings("serial")
public class Cena implements Serializable {
	private VrstaVozila vrstaVozila;
	private double cenaEUR;
	private double cenaRSD;
	public VrstaVozila getVrstaVozila() {
		return vrstaVozila;
	}
	public void setVrstaVozila(VrstaVozila vrstaVozila) {
		this.vrstaVozila = vrstaVozila;
	}
	public double getCenaEUR() {
		return cenaEUR;
	}
	public void setCenaEUR(double cenaEUR) {
		this.cenaEUR = cenaEUR;
	}
	public double getCenaRSD() {
		return cenaRSD;
	}
	public void setCenaRSD(double cenaRSD) {
		this.cenaRSD = cenaRSD;
	}
	public Cena(VrstaVozila vrstaVozila, double cenaRSD, double cenaEUR) {
		super();
		this.vrstaVozila = vrstaVozila;
		this.cenaEUR = cenaEUR;
		this.cenaRSD = cenaRSD;
	}
	public Cena(int vrstaVozila, double cenaEUR, double cenaRSD) {
		super();
		this.vrstaVozila = VrstaVozila.fromInteger(vrstaVozila);
		this.cenaEUR = cenaEUR;
		this.cenaRSD = cenaRSD;
	}
	@Override
	public String toString() {
		return "Cena [vrstaVozila=" + vrstaVozila + ", cenaEUR=" + cenaEUR
				+ ", cenaRSD=" + cenaRSD + "]";
	}
	
}
