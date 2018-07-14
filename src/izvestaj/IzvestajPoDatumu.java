package izvestaj;

import enumTypes.VrstaVozila;

public class IzvestajPoDatumu {
	private VrstaVozila vrstaVozila;
	private double placenIznos;
	private int brojVozila;
	public VrstaVozila getVrstaVozila() {
		return vrstaVozila;
	}
	public void setVrstaVozila(VrstaVozila vrstaVozila) {
		this.vrstaVozila = vrstaVozila;
	}
	public double getPlacenIznos() {
		return placenIznos;
	}
	public void setPlacenIznos(double placenIznos) {
		this.placenIznos = placenIznos;
	}
	public int getBrojVozila() {
		return brojVozila;
	}
	public void setBrojVozila(int brojVozila) {
		this.brojVozila = brojVozila;
	}
	public IzvestajPoDatumu(VrstaVozila vrstaVozila, double placenIznos,
			int brojVozila) {
		super();
		this.vrstaVozila = vrstaVozila;
		this.placenIznos = placenIznos;
		this.brojVozila = brojVozila;
	}
	@Override
	public String toString() {
		return "IzvestajPoDatumu [vrstaVozila=" + vrstaVozila
				+ ", placenIznos=" + placenIznos + ", brojVozila=" + brojVozila
				+ "]";
	}
	
	
}
