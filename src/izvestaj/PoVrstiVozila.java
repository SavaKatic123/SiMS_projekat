package izvestaj;

import enumTypes.VrstaVozila;
import gui.FilterDialog;

import java.util.List;

import javax.swing.JFrame;

public class PoVrstiVozila implements Kriterijum {

	@Override
	public IzvestajPoDatumu filtriraj(List<Izvestaj> l) {		
		final JFrame frame = new JFrame("Filter Menu");
		FilterDialog filterWindow = new FilterDialog(frame, 2);
		
		filterWindow.setVisible(true);

        if(filterWindow.isSuccess()){
        	VrstaVozila vv = filterWindow.getVrstaVozila();
        	double iznos = 0;
        	int brojVozila = 0;
        	for(Izvestaj i: l) {
        		for(IzvestajPoDatumu izv: i.getPoDatumu()) {
        			if(vv.equals(izv.getVrstaVozila())) {
        				iznos += izv.getPlacenIznos();
        				brojVozila += izv.getBrojVozila();
        			}
        		}
        	}
    		IzvestajPoDatumu ipd = new IzvestajPoDatumu(vv, iznos, brojVozila);
    		return ipd;
        }
        return null;
	}

}
