package model;

import java.io.Serializable;
import java.util.Date;

import enumTypes.VrstaKvara;

@SuppressWarnings("serial")
public class Kvar implements Serializable {
	private VrstaKvara vrstaKvara;
	private String opis;
	private Date datum;
	public VrstaKvara getVrstaKvara() {
		return vrstaKvara;
	}
	public void setVrstaKvara(VrstaKvara vrstaKvara) {
		this.vrstaKvara = vrstaKvara;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public Kvar(VrstaKvara vrstaKvara, String opis, Date datum) {
		super();
		this.vrstaKvara = vrstaKvara;
		this.opis = opis;
		this.datum = datum;
	}
	@Override
	public String toString() {
		return "Kvar [vrstaKvara=" + vrstaKvara + ", opis=" + opis + ", datum="
				+ datum + "]";
	}
	
	
	
	
}
