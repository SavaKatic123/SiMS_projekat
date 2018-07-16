package jedinicniTestovi;



import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;

import main.Aplikacija;
import model.Korisnik;
import model.MestoObicneNaplate;
import model.NaplatnaStanica;
import model.NaplatnoMesto;
import model.Rampa;

import org.junit.Before;
import org.junit.Test;

import utility.Utility;


public class DodavanjeNaplatnogMestaTest {
	ArrayList<NaplatnoMesto> lista;
	
	@Before
	public void setUp() {
		Aplikacija.getInstance();
		Utility.ucitajDeonice(new Korisnik());
		NaplatnoMesto nm = new MestoObicneNaplate(true, 500, new Rampa());
		lista = (ArrayList<NaplatnoMesto>) Aplikacija.getInstance().listaNaplatnihStanica.get(1).getListaNaplatnihMesta().clone();
		Aplikacija.getInstance().listaNaplatnihStanica.get(1).dodajNaplatnoMesto(nm);
	}
	
	@Test
	public void test() {
		assertNotSame(lista, Aplikacija.getInstance().listaNaplatnihStanica.get(1).getListaNaplatnihMesta());
	}
}
