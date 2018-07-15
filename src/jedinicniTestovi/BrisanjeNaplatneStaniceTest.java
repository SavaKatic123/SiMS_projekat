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
		listaNS1 = (ArrayList<NaplatnaStanica>) Aplikacija.getInstance().listaNaplatnihStanica.clone();
		for (int i = 0; i < Aplikacija.getInstance().listaNaplatnihStanica.size(); i++) {
			if (Aplikacija.getInstance().listaNaplatnihStanica.get(i).getNazivStanice().equals("Vrbas")) {
				Aplikacija.getInstance().listaNaplatnihStanica.remove(i);
			}
		}
	}
	
	@Test
	public void test() {
		assertNotSame(listaNS1, Aplikacija.getInstance().listaNaplatnihStanica);
	}
	
}
