package jedinicniTestovi;

import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import enumTypes.VrstaKorisnika;
import main.Aplikacija;
import model.Korisnik;
import utility.Utility;

public class IzmenaKorisnikaTest {

	ArrayList<Korisnik> listaKorisnika;
	
	@Before
	public void setUp() {
		Aplikacija.getInstance();
		Utility.ucitajKorisnike();
		Korisnik k = new Korisnik();
		k.setVrsta(VrstaKorisnika.Administrator);
		k.setKorisnickoIme("mita");
		k.setLozinka("NovaLozinka");
		listaKorisnika = (ArrayList<Korisnik>) Aplikacija.getInstance().listaKorisnika.clone();
		Aplikacija.getInstance().izmeniKorisnika(k);
	}
	
	@Test
	public void test() {
		assertNotSame(listaKorisnika, Aplikacija.getInstance().listaKorisnika);
	}
}
