package enumTypes;

public enum VrstaVozila {
	Ia,
	I,
	II,
	III,
	IV;
	
	public static VrstaVozila fromInteger(int x) {
        switch(x) {
        case 0:
            return Ia;
        case 1:
            return I;
        case 2:
        	return II;
        case 3:
        	return III;
        case 4:
        	return IV;
        }
        return null;
    }
	
	public static VrstaVozila fromString(String str) {
		switch(str) {
		case "Ia":
			return Ia;
		case "I":
			return I;
		case "II":
			return II;
		case "III":
			return III;
		case "IV":
			return IV;
		}
		return null;
	}
}
