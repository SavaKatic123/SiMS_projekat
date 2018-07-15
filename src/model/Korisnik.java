package model;

import java.io.Serializable;

import main.Aplikacija;
import enumTypes.VrstaKorisnika;

@SuppressWarnings("serial")
public class Korisnik implements Serializable {
    private VrstaKorisnika vrsta;
   
    private String korisnickoIme;
    private String lozinka;
   
    public Korisnik() {
    
    }
    
	public Korisnik(VrstaKorisnika vrsta, String korisnickoIme, String lozinka) {
		super();
		this.vrsta = vrsta;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}

	public VrstaKorisnika getVrsta() {
		return vrsta;
	}

	public void setVrsta(VrstaKorisnika vrsta) {
		this.vrsta = vrsta;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public void dodajKvar() {
      // TODO: implement
    }
   
    public void unesiPodatke() {
      // TODO: implement
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Korisnik))
			return false;
		Korisnik other = (Korisnik) obj;
		if (korisnickoIme.equals(other.getKorisnickoIme()) && lozinka.equals(other.getLozinka())) {
			return true;
		}
		return false;
	}
    
    public NaplatnaStanica getNaplatnaStanicaForOperater() {
    	for(NaplatnaStanica ns: Aplikacija.getInstance().listaNaplatnihStanica) {
    		if (ns.getListaNaplatnihMesta() != null) {
    			for(NaplatnoMesto nm: ns.getListaNaplatnihMesta()) {
    				if (this.equals(nm.getOperater())) {
    					return ns;
    				}
    			}
    		}
			
		}
    	return null;
    }
    
    public NaplatnaStanica getNaplatnaStanicaForSef() {
    	for(NaplatnaStanica ns: Aplikacija.getInstance().listaNaplatnihStanica) {
    		if (ns.getSef() != null) {
				if (this.equals(ns.getSef())) {
					return ns;
    			}
    		}
			
		}
    	return null;
    }
    
    public NaplatnoMesto getNaplatnoMestoForOperater() {
    	for(NaplatnaStanica ns: Aplikacija.getInstance().listaNaplatnihStanica) {
    		if (ns.getListaNaplatnihMesta() != null) {
    			for(NaplatnoMesto nm: ns.getListaNaplatnihMesta()) {
    				if (nm.getOperater() != null && this.equals(nm.getOperater())) {
    					return nm;
    				}
    			}
    		}
			
		}
    	return null;
    }

	@Override
	public String toString() {
		return "Korisnik [vrsta=" + vrsta + ", korisnickoIme=" + korisnickoIme
				+ ", lozinka=" + lozinka + "]";
	}
    
    
    
	}