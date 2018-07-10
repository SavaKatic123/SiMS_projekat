package enumTypes;

public enum VrstaKvara {
	Kritican,
	Nekritican;
	
	public static VrstaKvara fromInteger(int x) {
        switch(x) {
        case 0:
            return Kritican;
        case 1:
            return Nekritican;
        }
        return null;
    }
	
	public static VrstaKvara fromString(String str) {
		switch(str) {
		case "Kritican":
			return Kritican;
		case "Nekritican":
			return Nekritican;
		}
		return null;
	}
}
