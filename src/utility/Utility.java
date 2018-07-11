package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.Aplikacija;
import model.Cena;
import model.Cenovnik;
import model.Deonica;
import model.Korisnik;
import model.NaplatnaStanica;
import model.NaplatnoMesto;
import enumTypes.VrstaKorisnika;
import gui.LoginDialog;

public class Utility {
	
	boolean unesiOdluku (String str) {
		int dialogResult = JOptionPane.showConfirmDialog (null, str);
		return dialogResult == JOptionPane.YES_OPTION;
	}
	
	public static void ucitajKorisnike() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("korisnici.txt"));
			String red;
			while((red = br.readLine()) != null) {
				String[] lista = red.split("\\|");
				Korisnik k = new Korisnik();
				k.setKorisnickoIme(lista[0]);
				k.setLozinka(lista[1]);
				int index = Integer.parseInt(lista[2]);
				k.setVrsta(VrstaKorisnika.fromInteger(index));
				Aplikacija.getInstance().dodajKorisnika(k);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Korisnik proveriKorisnika(String korisnickoIme, String lozinka) {
		for (Korisnik k: Aplikacija.getInstance().listaKorisnika) {
			if (korisnickoIme.equals(k.getKorisnickoIme()) && lozinka.equals(k.getLozinka())) {
				return k;
			}
		}
		return null;
	}
	
	public static Korisnik logIn() {
		final JFrame frame = new JFrame("Login");
        final JButton btnLogin = new JButton();
 
        LoginDialog loginDlg = new LoginDialog(frame);
        loginDlg.setVisible(true);

        if(loginDlg.isSucceeded()){
            btnLogin.setText("Zdravo " + loginDlg.getUsername() + "!");
            return loginDlg.getKorisnik();
        }
        return null;
	}
	
	@SuppressWarnings("unchecked")
	public static void ucitaj () {
		try {
			FileInputStream f3 = new FileInputStream(new File("deonice.txt"));
			FileInputStream f4 = new FileInputStream(new File("naplatneStanice.txt"));
			
			ObjectInputStream o3 = new ObjectInputStream(f3);
			ObjectInputStream o4 = new ObjectInputStream(f4);
			
			Aplikacija.getInstance().listaDeonica = (ArrayList<Deonica>)o3.readObject();
			Aplikacija.getInstance().listaNaplatnihStanica = (ArrayList<NaplatnaStanica>)o4.readObject();
			
			o3.close();
			o4.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void upisi () {
		try {
			FileOutputStream f1 = new FileOutputStream(new File("deonice.txt"));
			FileOutputStream f2 = new FileOutputStream(new File("naplatneStanice.txt"));
			ObjectOutputStream o1 = new ObjectOutputStream(f1);
			ObjectOutputStream o2 = new ObjectOutputStream(f2);
			
			o1.writeObject(Aplikacija.getInstance().listaDeonica);
			o2.writeObject(Aplikacija.getInstance().listaNaplatnihStanica);
			o1.close();
			o2.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}
	
	// HELPER METODE - OBRISATI IH NAKON STO VISE NE BUDU POTREBNE
	public static void ucitajDeonice() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("cene_putarina.txt"));
			String red;
			while((red = br.readLine()) != null) {
				String[] lista = red.split("\\|");
				NaplatnaStanica ns1 = new NaplatnaStanica(lista[0]);
				NaplatnaStanica ns2 = new NaplatnaStanica(lista[1]);
				
				Deonica d = new Deonica(new NaplatnaStanica(lista[0]), new NaplatnaStanica(lista[1]), new Cenovnik(new Date(new Date().getTime() + 8*24*60*60*1000), 
						new ArrayList<Cena>(Arrays.asList(new Cena(0, Double.parseDouble(lista[2]), Double.parseDouble(lista[3])),
						new Cena(1, Double.parseDouble(lista[4]), Double.parseDouble(lista[5])),
						new Cena(2, Double.parseDouble(lista[6]), Double.parseDouble(lista[7])),
						new Cena(3, Double.parseDouble(lista[8]), Double.parseDouble(lista[9])),
						new Cena(4, Double.parseDouble(lista[10]), Double.parseDouble(lista[11]))))));
				Aplikacija.getInstance().dodajDeonicu(d);
				Aplikacija.getInstance().dodajNaplatnuStanicu(ns1);
				Aplikacija.getInstance().dodajNaplatnuStanicu(ns2);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void kreirajFajlove() {
		try {
			FileOutputStream f1 = new FileOutputStream(new File("deonice.txt"));
			FileOutputStream f2 = new FileOutputStream(new File("naplatneStanice.txt"));
			ObjectOutputStream o1 = new ObjectOutputStream(f1);
			ObjectOutputStream o2 = new ObjectOutputStream(f2);
			
			o1.writeObject(Aplikacija.getInstance().listaDeonica);
			o2.writeObject(Aplikacija.getInstance().listaNaplatnihStanica);
			
			FileInputStream f3 = new FileInputStream(new File("deonice.txt"));
			FileInputStream f4 = new FileInputStream(new File("naplatneStanice.txt"));
			
			ObjectInputStream o3 = new ObjectInputStream(f3);
			ObjectInputStream o4 = new ObjectInputStream(f4);
			

			ArrayList<Deonica> list1 = (ArrayList<Deonica>)o3.readObject();
			ArrayList<NaplatnaStanica> list2 = (ArrayList<NaplatnaStanica>)o4.readObject();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
