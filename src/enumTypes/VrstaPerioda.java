package enumTypes;

import java.io.Serializable;

public enum VrstaPerioda implements Serializable {
	PoDanu,
	PoMesecu,
	PoGodini;
	
	public static VrstaPerioda fromInteger(int x) {
		switch(x) {
		case 0:
			return PoDanu;
		case 1:
			return PoMesecu;
		case 2:
			return PoGodini;
		}
		return null;
	}
	
	public static VrstaPerioda fromString(String s) {
		switch(s) {
		case "PoDanu":
			return PoDanu;
		case "PoMesecu":
			return PoMesecu;
		case "PoGodini":
			return PoGodini;
		}
		return null;
	}
	
}
