package jedinicniTestovi;



import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import enumTypes.VrstaKorisnika;
import main.Aplikacija;
import utility.Utility;
import model.Korisnik;


public class DodavanjeKorisnikaTest {
	ArrayList<Korisnik> listaKorisnika;
	
	@Before
	public void setUp() {
		Aplikacija.getInstance();
		Utility.ucitajKorisnike();
		Korisnik k = new Korisnik(VrstaKorisnika.Administrator, "NoviKorisnik", "NovaLozinka");
		listaKorisnika = (ArrayList<Korisnik>) Aplikacija.getInstance().listaKorisnika.clone();
		Aplikacija.getInstance().dodajKorisnika(k);
	}
	
	@Test
	public void test() {
		assertNotSame(listaKorisnika, Aplikacija.getInstance().listaKorisnika);
	}
}
