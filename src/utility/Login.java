package utility;

import enumTypes.VrstaKorisnika;
import gui.LoginDialog;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import main.Aplikacija;
import model.Korisnik;

public abstract class Login {
	public static void citajIzFajla() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("korisnici.txt"));
			String red;
			while((red = br.readLine()) != null) {
				String[] lista = red.split("\\|");
				Korisnik k = new Korisnik();
				k.setKorisnickoIme(lista[0]);
				k.setLozinka(lista[1]);
				int index = Integer.parseInt(lista[1]);
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
	
	public static boolean proveriKorisnika(String korisnickoIme, String lozinka) {
		for (Korisnik k: Aplikacija.getInstance().listaKorisnika) {
			if (korisnickoIme.equals(k.getKorisnickoIme()) && lozinka.equals(k.getLozinka())) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean logIn() {
		final JFrame frame = new JFrame("Login");
        final JButton btnLogin = new JButton();
 
        LoginDialog loginDlg = new LoginDialog(frame);
        loginDlg.setVisible(true);
        // if logon successfully
        if(loginDlg.isSucceeded()){
            btnLogin.setText("Zdravo " + loginDlg.getUsername() + "!");
            return true;
        }
        return false;
	}
	
}
