package model;

import enumTypes.VrstaKorisnika;

public class Korisnik {
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
    
	}