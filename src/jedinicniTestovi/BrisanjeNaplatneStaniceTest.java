package jedinicniTestovi;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.Aplikacija;
import utility.Utility;
import model.NaplatnaStanica;


public class BrisanjeNaplatneStaniceTest {
	ArrayList<NaplatnaStanica> listaNS1;
	
	@Before
	public void setUp() {
		Aplikacija.getInstance();
		Utility.ucitaj();
		listaNS1 = (ArrayList<NaplatnaStanica>) Aplikacija.getInstance().listaNaplatnihStanica.clone();
		NaplatnaStanica zaBrisanje = Aplikacija.getInstance().listaNaplatnihStanica.get(2);
		Aplikacija.getInstance().obrisiNaplatnuStanicu(zaBrisanje);
	}
	
	@Test
	public void test() {
		assertNotSame(listaNS1, Aplikacija.getInstance().listaNaplatnihStanica);
	}
	
}
