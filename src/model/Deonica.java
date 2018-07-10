package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Deonica implements Serializable {
	private NaplatnaStanica polaznaNS;
	private NaplatnaStanica odredisnaNS;
	private Cenovnik cenovnik;
	
	public Deonica(NaplatnaStanica polaznaNS, NaplatnaStanica odredisnaNS,
			Cenovnik cenovnik) {
		super();
		this.polaznaNS = polaznaNS;
		this.odredisnaNS = odredisnaNS;
		this.cenovnik = cenovnik;
	}



	@Override
	public String toString() {
		return "Deonica [polaznaNS=" + polaznaNS + ", odredisnaNS="
				+ odredisnaNS + ", cenovnik=" + cenovnik + "]";
	}



	public NaplatnaStanica getPolaznaNS() {
		return polaznaNS;
	}



	public void setPolaznaNS(NaplatnaStanica polaznaNS) {
		this.polaznaNS = polaznaNS;
	}



	public NaplatnaStanica getOdredisnaNS() {
		return odredisnaNS;
	}



	public void setOdredisnaNS(NaplatnaStanica odredisnaNS) {
		this.odredisnaNS = odredisnaNS;
	}



	public Cenovnik getCenovnik() {
		return cenovnik;
	}



	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Deonica))
			return false;
		Deonica other = (Deonica) obj;
		if (polaznaNS.getNazivStanice() == other.getPolaznaNS().getNazivStanice() && odredisnaNS.getNazivStanice() == other.getOdredisnaNS().getNazivStanice()) {
			return true;
		}
		return false;
	}
	
	
	
}
