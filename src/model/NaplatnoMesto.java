package model;

import java.util.ArrayList;

public abstract class NaplatnoMesto {
	private boolean aktivno;
	private int id;
	private ArrayList<Kvar> listaKvarova;
	private ArrayList<Naplata> listaNaplata;
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
	public NaplatnoMesto(boolean aktivno, int id) {
		super();
		this.aktivno = aktivno;
		this.id = id;
	}
	@Override
	public String toString() {
		return "NaplatnoMesto [aktivno=" + aktivno + ", id=" + id + ", kvar="
				+ listaKvarova + ", listaNaplata=" + listaNaplata + "]";
	}
	
	
	
	
	
}
