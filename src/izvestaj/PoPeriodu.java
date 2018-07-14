package izvestaj;

import enumTypes.VrstaPerioda;
import gui.FilterDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

public class PoPeriodu implements Kriterijum {

	@Override
	public List<Izvestaj> filtriraj(List<Izvestaj> l) {
		ArrayList<Izvestaj> novaLista = new ArrayList<Izvestaj>();
		
		final JFrame frame = new JFrame("Filter Menu");
		FilterDialog filterWindow = new FilterDialog(frame, 1);
        filterWindow.setVisible(true);

        if(filterWindow.isSuccess()){
        	VrstaPerioda vp = filterWindow.getVrstaPerioda();
        	Date period = filterWindow.getPeriod();
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
    		for (Izvestaj i: l) {
    			if(sdf.format(i.getVreme()).equals(sdf.format(period))) {
    				novaLista.add(i);
    			}
    		}
    		return novaLista;
        }
        return null;
		
	}

}
