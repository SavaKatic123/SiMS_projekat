package model;

import states.StanjeElektronskeNaplate;
import states.StanjeMirovanja;

@SuppressWarnings("serial")
public class MestoElektronskeNaplate extends NaplatnoMesto {
	private StanjeElektronskeNaplate stanjeElektronskeNaplate;
	public MestoElektronskeNaplate (boolean aktivno, int id, Rampa r) {
		super(aktivno, id, r);
		this.stanjeElektronskeNaplate = new StanjeMirovanja();
	}
	public StanjeElektronskeNaplate getStanjeElektronskeNaplate() {
		return stanjeElektronskeNaplate;
	}
	public void setStanjeElektronskeNaplate(
			StanjeElektronskeNaplate stanjeElektronskeNaplate) {
		this.stanjeElektronskeNaplate = stanjeElektronskeNaplate;
	}
	@Override
	public String toString() {
		return "MestoElektronskeNaplate [aktivno=" + aktivno + ", id=" + id
				+ ", listaKvarova=" + listaKvarova + ", listaNaplata="
				+ listaNaplata + ", rampa=" + rampa + ", stanjeNaplate="
				+ stanjeNaplate + "stanjeElektronskeNaplate=" + stanjeElektronskeNaplate + "]";
	}
	
	
}
