package utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import main.Aplikacija;
import model.Deonica;

public abstract class UcitavanjeDeonica {
	public static void ucitajDeonice() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("cene_putarina.txt"));
			String red;
			while((red = br.readLine()) != null) {
				String[] lista = red.split("\\|");
				
				Deonica d = new Deonica(lista[0], lista[1], Double.parseDouble(lista[2]), Double.parseDouble(lista[3]), 
						Double.parseDouble(lista[4]), Double.parseDouble(lista[5]), Double.parseDouble(lista[6]), 
						Double.parseDouble(lista[7]), Double.parseDouble(lista[8]), Double.parseDouble(lista[9]), 
						Double.parseDouble(lista[10]), Double.parseDouble(lista[11]));
				
				Aplikacija.getInstance().dodajDeonicu(d);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
