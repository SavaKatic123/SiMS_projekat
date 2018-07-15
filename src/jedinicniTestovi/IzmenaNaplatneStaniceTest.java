package jedinicniTestovi;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import enumTypes.VrstaKorisnika;
import main.Aplikacija;
import utility.Utility;
import model.Korisnik;
import model.NaplatnaStanica;


public class IzmenaNaplatneStaniceTest {
	ArrayList<NaplatnaStanica> listaNS1;
	
	@Before
	public void setUp() {
		Aplikacija.getInstance();
		Utility.ucitaj();
		listaNS1 = (ArrayList<NaplatnaStanica>) Aplikacija.getInstance().listaNaplatnihStanica.clone();
		Korisnik noviSef = new Korisnik();
		noviSef.setKorisnickoIme("Novi sef");
		noviSef.setLozinka("Nova lozinka");
		noviSef.setVrsta(VrstaKorisnika.SefNaplatneStanice);
		NaplatnaStanica ns = Aplikacija.getInstance().listaNaplatnihStanica.get(2);
		ns.setSef(noviSef);
		Aplikacija.getInstance().izmenaNaplatneStanice(ns);
		
	}
	
	@Test
	public void test() {
		assertNotSame(listaNS1, Aplikacija.getInstance().listaNaplatnihStanica);
	}
}
