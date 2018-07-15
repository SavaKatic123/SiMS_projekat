package jedinicniTestovi;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.Aplikacija;
import utility.Utility;
import model.NaplatnaStanica;
import model.Deonica;



public class DodavanjeDeoniceTest {
	ArrayList<Deonica> deonice;
	
	@Before
	public void setUp() {
		Aplikacija.getInstance();
		Utility.ucitaj();
		Deonica d = new Deonica(Aplikacija.getInstance().listaNaplatnihStanica.get(1), Aplikacija.getInstance().listaNaplatnihStanica.get(7), null);
		deonice = (ArrayList<Deonica>) Aplikacija.getInstance().listaDeonica.clone();
		Aplikacija.getInstance().listaDeonica.add(d);
	}
	
	@Test
	public void test() {
		assertNotSame(deonice, Aplikacija.getInstance().listaDeonica);
	}
}
