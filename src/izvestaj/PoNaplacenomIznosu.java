package izvestaj;

import java.util.List;

public class PoNaplacenomIznosu implements Kriterijum {

	@Override
	public Double filtriraj(List<Izvestaj> l) {
		double iznos = 0;
		for(Izvestaj i: l) {
			for(IzvestajPoDatumu izp: i.getPoDatumu()) {
				iznos += izp.getPlacenIznos();
			}
		}
		return iznos;
	}

}
