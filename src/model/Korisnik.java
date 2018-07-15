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
    
    public NaplatnaStanica getNaplatnaStanicaForUser() {
    	for(NaplatnaStanica ns: Aplikacija.getInstance().listaNaplatnihStanica) {
			for(NaplatnoMesto nm: ns.getListaNaplatnihMesta()) {
				if (this.equals(nm.getOperater())) {
					return ns;
				}
			}
		}
    	return null;
    }
    
    public NaplatnoMesto getNaplatnoMestoForUser() {
    	for(NaplatnaStanica ns: Aplikacija.getInstance().listaNaplatnihStanica) {
			for(NaplatnoMesto nm: ns.getListaNaplatnihMesta()) {
				if (this.equals(nm.getOperater())) {
					return nm;
				}
			}
		}
    	return null;
    }
    
	}