package model;

import java.util.ArrayList;
import java.util.Date;

public class Cenovnik {
	private Date rokVazenja;
	private ArrayList<Cena> listaCena = new ArrayList<Cena>();
	public Date getRokVazenja() {
		return rokVazenja;
	}
	public void setRokVazenja(Date rokVazenja) {
		this.rokVazenja = rokVazenja;
	}
	public ArrayList<Cena> getListaCena() {
		return listaCena;
	}
	public void setListaCena(ArrayList<Cena> listaCena) {
		this.listaCena = listaCena;
	}
	public Cenovnik(Date rokVazenja, ArrayList<Cena> listaCena) {
		super();
		this.rokVazenja = rokVazenja;
		this.listaCena = listaCena;
	}
	@Override
	public String toString() {
		return "Cenovnik [rokVazenja=" + rokVazenja + ", listaCena="
				+ listaCena + "]";
	}
	
	
	
}
