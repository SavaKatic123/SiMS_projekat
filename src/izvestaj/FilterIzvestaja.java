package izvestaj;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enumTypes.VrstaPerioda;
import enumTypes.VrstaVozila;

public class FilterIzvestaja {
	public ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
	
	public FilterIzvestaja(ArrayList<Izvestaj> lista) {
		this.lista = lista;
	}
	
	public IzvestajPoDatumu izracunajFiltrirane() {
		double iznos = 0;
		int brojVozila = 0;
		for(Izvestaj i: lista) {
			for(IzvestajPoDatumu izp: i.getPoDatumu()) {
				iznos += izp.getPlacenIznos();
				brojVozila += izp.getBrojVozila();
			}
		}
		return new IzvestajPoDatumu(VrstaVozila.fromInteger(0), iznos, brojVozila);
	}
	
	public List<Izvestaj> filtrirajPoPeriodu(VrstaPerioda vp, Date period) {
		ArrayList<Izvestaj> novaLista = new ArrayList<Izvestaj>();
    	SimpleDateFormat sdf = new SimpleDateFormat();
		switch(vp) {
		case PoDanu:
			sdf = new SimpleDateFormat("yyyyMMdd");
			break;
		case PoMesecu:
			sdf = new SimpleDateFormat("yyyyMM");
			break;
		case PoGodini:
			sdf = new SimpleDateFormat("yyyy");
			break;
		}
		for (Izvestaj i: lista) {
			if(sdf.format(i.getVreme()).equals(sdf.format(period))) {
				novaLista.add(i);
			}
		}
		return novaLista;
		
	}
	
	public List<Izvestaj> filtrirajPoVrstiVozila(VrstaVozila vv) {		
    	ArrayList<Izvestaj> lista = new ArrayList<Izvestaj>();
    	for(Izvestaj i: lista) {
    		for(IzvestajPoDatumu izv: i.getPoDatumu()) {
    			if(vv.equals(izv.getVrstaVozila())) {
    				Izvestaj iz = new Izvestaj(i.getVreme());
    				iz.getPoDatumu().add(new IzvestajPoDatumu(izv.getVrstaVozila(), izv.getPlacenIznos(), izv.getBrojVozila()));
    				lista.add(iz);
    			}
    		}
    	}
		return lista;
	}
}
