package model;

import java.io.Serializable;
import java.util.ArrayList;

import states.Radi;
import states.StanjeNaplatnogMesta;

@SuppressWarnings("serial")
public abstract class NaplatnoMesto implements Serializable {
	protected boolean aktivno;
	protected int id;
	protected ArrayList<Kvar> listaKvarova;
	protected ArrayList<Naplata> listaNaplata;
	protected Rampa rampa;
	protected StanjeNaplatnogMesta stanjeNaplate;
	public boolean isAktivno() {
		return aktivno;
	}
	public void setAktivno(boolean aktivno) {
		this.aktivno = aktivno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public ArrayList<Kvar> getListaKvarova() {
		return listaKvarova;
	}
	public void setListaKvarova(ArrayList<Kvar> listaKvarova) {
		this.listaKvarova = listaKvarova;
	}
	public ArrayList<Naplata> getListaNaplata() {
		return listaNaplata;
	}
	public void setListaNaplata(ArrayList<Naplata> listaNaplata) {
		this.listaNaplata = listaNaplata;
	}
	
	public Rampa getRampa() {
		return rampa;
	}
	public void setRampa(Rampa rampa) {
		this.rampa = rampa;
	}
	
	public StanjeNaplatnogMesta getStanjeNaplate() {
		return stanjeNaplate;
	}
	public void setStanjeNaplate(StanjeNaplatnogMesta stanjeNaplate) {
		this.stanjeNaplate = stanjeNaplate;
	}
	public NaplatnoMesto(boolean aktivno, int id, Rampa r) {
		super();
		this.aktivno = aktivno;
		this.id = id;
		this.rampa = r;
		this.stanjeNaplate = new Radi();
		this.listaKvarova = new ArrayList<Kvar>();
		this.listaNaplata = new ArrayList<Naplata>();
	}
	@Override
	public String toString() {
		return "NaplatnoMesto [aktivno=" + aktivno + ", id=" + id
				+ ", listaKvarova=" + listaKvarova + ", listaNaplata="
				+ listaNaplata + ", rampa=" + rampa + ", stanjeNaplate="
				+ stanjeNaplate + "]";
	}
	
	
}
