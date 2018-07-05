package model;

public class Deonica {
	private String polaznaNS;
	private String odredisnaNS;
	private double IcenaRSD, IacenaRSD, IIcenaRSD, IIIcenaRSD, IVcenaRSD;
	private double IcenaEUR, IacenaEUR, IIcenaEUR, IIIcenaEUR, IVcenaEUR;
	
	public Deonica(String polaznaNS, String odredisnaNS, double icenaRSD, double iacenaRSD, double iIcenaRSD,
			double iIIcenaRSD, double iVcenaRSD, double icenaEUR, double iacenaEUR, double iIcenaEUR, double iIIcenaEUR,
			double iVcenaEUR) {
		super();
		this.polaznaNS = polaznaNS;
		this.odredisnaNS = odredisnaNS;
		IcenaRSD = icenaRSD;
		IacenaRSD = iacenaRSD;
		IIcenaRSD = iIcenaRSD;
		IIIcenaRSD = iIIcenaRSD;
		IVcenaRSD = iVcenaRSD;
		IcenaEUR = icenaEUR;
		IacenaEUR = iacenaEUR;
		IIcenaEUR = iIcenaEUR;
		IIIcenaEUR = iIIcenaEUR;
		IVcenaEUR = iVcenaEUR;
	}

	
	
	
	@Override
	public String toString() {
		return "Deonica [polaznaNS=" + polaznaNS + ", odredisnaNS=" + odredisnaNS + ", IcenaRSD=" + IcenaRSD
				+ ", IacenaRSD=" + IacenaRSD + ", IIcenaRSD=" + IIcenaRSD + ", IIIcenaRSD=" + IIIcenaRSD
				+ ", IVcenaRSD=" + IVcenaRSD + ", IcenaEUR=" + IcenaEUR + ", IacenaEUR=" + IacenaEUR + ", IIcenaEUR="
				+ IIcenaEUR + ", IIIcenaEUR=" + IIIcenaEUR + ", IVcenaEUR=" + IVcenaEUR + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Deonica))
			return false;
		Deonica other = (Deonica) obj;
		if (polaznaNS == other.getPolaznaNS() && odredisnaNS == other.getOdredisnaNS()) {
			return true;
		}
		return false;
	}




	public Deonica() {
		super();
	}




	public String getPolaznaNS() {
		return polaznaNS;
	}

	public void setPolaznaNS(String polaznaNS) {
		this.polaznaNS = polaznaNS;
	}

	public String getOdredisnaNS() {
		return odredisnaNS;
	}

	public void setOdredisnaNS(String odredisnaNS) {
		this.odredisnaNS = odredisnaNS;
	}

	public double getIcenaRSD() {
		return IcenaRSD;
	}

	public void setIcenaRSD(double icenaRSD) {
		IcenaRSD = icenaRSD;
	}

	public double getIacenaRSD() {
		return IacenaRSD;
	}

	public void setIacenaRSD(double iacenaRSD) {
		IacenaRSD = iacenaRSD;
	}

	public double getIIcenaRSD() {
		return IIcenaRSD;
	}

	public void setIIcenaRSD(double iIcenaRSD) {
		IIcenaRSD = iIcenaRSD;
	}

	public double getIIIcenaRSD() {
		return IIIcenaRSD;
	}

	public void setIIIcenaRSD(double iIIcenaRSD) {
		IIIcenaRSD = iIIcenaRSD;
	}

	public double getIVcenaRSD() {
		return IVcenaRSD;
	}

	public void setIVcenaRSD(double iVcenaRSD) {
		IVcenaRSD = iVcenaRSD;
	}

	public double getIcenaEUR() {
		return IcenaEUR;
	}

	public void setIcenaEUR(double icenaEUR) {
		IcenaEUR = icenaEUR;
	}

	public double getIacenaEUR() {
		return IacenaEUR;
	}

	public void setIacenaEUR(double iacenaEUR) {
		IacenaEUR = iacenaEUR;
	}

	public double getIIcenaEUR() {
		return IIcenaEUR;
	}

	public void setIIcenaEUR(double iIcenaEUR) {
		IIcenaEUR = iIcenaEUR;
	}

	public double getIIIcenaEUR() {
		return IIIcenaEUR;
	}

	public void setIIIcenaEUR(double iIIcenaEUR) {
		IIIcenaEUR = iIIcenaEUR;
	}

	public double getIVcenaEUR() {
		return IVcenaEUR;
	}

	public void setIVcenaEUR(double iVcenaEUR) {
		IVcenaEUR = iVcenaEUR;
	}
	
	
}
