package izvestaj;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import main.Aplikacija;
import model.NaplatnaStanica;
import enumTypes.VrstaVozila;

@SuppressWarnings("serial")
public class Izvestaj implements Serializable {
	private Date vreme;
	private ArrayList<IzvestajPoDatumu> poDatumu;
		
	public Date getVreme() {
		return vreme;
	}

	public void setVreme(Date vreme) {
		this.vreme = vreme;
		this.poDatumu = new ArrayList<IzvestajPoDatumu>();
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
		this.poDatumu = new ArrayList<IzvestajPoDatumu>();
		
	}

	public static void inicirajIzvestaj () {
		Date now = new Date();
		boolean postoji = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		for(NaplatnaStanica ns: Aplikacija.getInstance().listaNaplatnihStanica) {
			if (ns.listaIzvestaja != null) {
				for(Izvestaj i: ns.listaIzvestaja) {
					if (sdf.format(now).equals(sdf.format(i.getVreme()))) {
						postoji = true;
						break;
					}
				}
			}
			
		}
		
		if (!postoji) {
			
			for(NaplatnaStanica ns: Aplikacija.getInstance().listaNaplatnihStanica) {
				Izvestaj izv = new Izvestaj(now);
				for(int i = 0; i < 5; i++) {
					IzvestajPoDatumu izp = new IzvestajPoDatumu(VrstaVozila.fromInteger(i), 0, 0);
					izv.poDatumu.add(izp);
				}
				if (ns.listaIzvestaja != null) {
					ns.listaIzvestaja.add(izv);
				}
				
			}
		}
	}
	
	public void dodajIzvestajPoDatumu(IzvestajPoDatumu ipd) {
		this.poDatumu.add(ipd);
	}

	@Override
	public String toString() {
		return "Izvestaj [vreme=" + vreme + ", poDatumu=" + poDatumu + "]";
	}

	
}
