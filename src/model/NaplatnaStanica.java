package model;

public class NaplatnaStanica {
	private String nazivStanice;
	public String getNazivStanice() {
		return nazivStanice;
	}
	public void setNazivStanice(String nazivStanice) {
		this.nazivStanice = nazivStanice;
	}
	
	public NaplatnaStanica(String nazivStanice) {
		super();
		this.nazivStanice = nazivStanice;
	}
	@Override
	public String toString() {
		return "NaplatnaStanica [nazivStanice=" + nazivStanice + "]";
	}
	
	
}
