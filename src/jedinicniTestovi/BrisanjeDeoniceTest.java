package jedinicniTestovi;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.Aplikacija;
import utility.Utility;
import model.Deonica;
import model.NaplatnaStanica;

public class BrisanjeDeoniceTest {
	ArrayList<Deonica> deonice;
	
	@Before
	public void setUp() {
		Aplikacija.getInstance();
		Utility.ucitaj();
		deonice = (ArrayList<Deonica>) Aplikacija.getInstance().listaDeonica.clone();
		Deonica d = new Deonica();
		NaplatnaStanica ns1 = new NaplatnaStanica();
		ns1.setNazivStanice("Beograd");
		NaplatnaStanica ns2 = new NaplatnaStanica();
		ns2.setNazivStanice("Mali Pozarevac");
		d.setPolaznaNS(ns1);
		d.setOdredisnaNS(ns2);
		Aplikacija.getInstance().obrisiDeonicu(d);
	}
	
	@Test
	public void test() {
		assertNotSame(deonice, Aplikacija.getInstance().listaDeonica);
	}
}
