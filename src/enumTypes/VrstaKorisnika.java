package enumTypes;

public enum VrstaKorisnika {
	Administrator,
	Operater,
	SefNaplatneStanice,
	ZaposleniUCentrali;
	
	public static VrstaKorisnika fromInteger(int x) {
        switch(x) {
        case 0:
            return Administrator;
        case 1:
            return Operater;
        case 2:
        	return SefNaplatneStanice;
        case 3:
        	return ZaposleniUCentrali;
        }
        return null;
    }
	
	public static VrstaKorisnika fromString(String str) {
		switch(str) {
		case "Administrator":
			return Administrator;
		case "Operater":
			return Operater;
		case "SefNaplatneStanice":
			return SefNaplatneStanice;
		case "ZaposleniUCentrali":
			return ZaposleniUCentrali;
		}
		return null;
	}
}
