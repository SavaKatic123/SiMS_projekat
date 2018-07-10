package izvestaj;

import java.util.Date;

import enumTypes.VrstaVozila;

public class Izvestaj {
	private VrstaVozila vrstaVozila;
	private Date vreme;
	private double placenIznos;
	private int brojVozila;

	public Izvestaj(VrstaVozila vrstaVozila, Date vreme, double placenIznos,
			int brojVozila) {
		super();
		this.vrstaVozila = vrstaVozila;
		this.vreme = vreme;
		this.placenIznos = placenIznos;
		this.brojVozila = brojVozila;
	}
	public VrstaVozila getVrstaVozila() {
		return vrstaVozila;
	}
	public void setVrstaVozila(VrstaVozila vrstaVozila) {
		this.vrstaVozila = vrstaVozila;
	}
	public Date getVreme() {
		return vreme;
	}
	public void setVreme(Date vreme) {
		this.vreme = vreme;
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
	@Override
	public String toString() {
		return "Izvestaj [vrstaVozila=" + vrstaVozila + ", vreme=" + vreme
				+ ", placenIznos=" + placenIznos + ", brojVozila=" + brojVozila
				+ "]";
	}
	
	
}
