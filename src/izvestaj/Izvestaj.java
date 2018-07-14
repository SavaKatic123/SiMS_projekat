package izvestaj;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import main.Aplikacija;
import model.NaplatnaStanica;
import enumTypes.VrstaVozila;

public class Izvestaj {
	private Date vreme;
	private ArrayList<IzvestajPoDatumu> poDatumu;
		
	public Date getVreme() {
		return vreme;
	}

	public void setVreme(Date vreme) {
		this.vreme = vreme;
	}
	
	

	public ArrayList<IzvestajPoDatumu> getPoDatumu() {
		return poDatumu;
	}

	public void setPoDatumu(ArrayList<IzvestajPoDatumu> poDatumu) {
		this.poDatumu = poDatumu;
	}

	public Izvestaj(Date vreme) {
		super();
		this.vreme = vreme;
		for(int i = 0; i < 4; i++) {
			IzvestajPoDatumu izp = new IzvestajPoDatumu(VrstaVozila.fromInteger(i), 0, 0);
			this.poDatumu.add(izp);
		}
	}

	public static void inicirajIzvestaj () {
		Date now = new Date();
		boolean postoji = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		for(NaplatnaStanica ns: Aplikacija.getInstance().listaNaplatnihStanica) {
			for(Izvestaj i: ns.listaIzvestaja) {
				if (sdf.format(now).equals(sdf.format(i.getVreme()))) {
					postoji = true;
					break;
				}
			}
		}
		Izvestaj i = new Izvestaj(now);
		if (!postoji) {
			for(NaplatnaStanica ns: Aplikacija.getInstance().listaNaplatnihStanica) {
				ns.listaIzvestaja.add(i);
			}
		}
	}
	
	
}
