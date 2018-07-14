package model;

import java.io.Serializable;

import states.RampaSpustena;
import states.StanjeRampe;

@SuppressWarnings("serial")
public class Rampa implements Serializable {
	private StanjeRampe stanje;
	
	public Rampa () {
		this.stanje = new RampaSpustena();
	}
	public StanjeRampe getStanje() {
		return stanje;
	}
	public void setStanje(StanjeRampe stanje) {
		this.stanje = stanje;
	}
	
	
}
