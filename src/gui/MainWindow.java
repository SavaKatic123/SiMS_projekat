package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Korisnik;


@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	public MainWindow(String title, Korisnik k) {
		//TODO: Implement
		super(title);
		this.setVisible(true);

		this.setSize(500,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		switch(k.getVrsta()) {
		case Operater:
			this.prikaziMenuOperatera();
			break;
		case Administrator:
			this.prikaziMenuAdministratora();
			break;
		case SefNaplatneStanice:
			this.prikaziMenuSefa();
			break;
		case ZaposleniUCentrali:
			this.prikaziMenuZaposlenog();
			break;
		}
	}
	public void prikaziMenuOperatera() {
		JPanel panel = new JPanel();
		this.add(panel);
		JButton button = new JButton("Pokreni rampu");
		panel.add(button);
		button.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}
	
	public void prikaziMenuAdministratora() {
		
	}
	
	public void prikaziMenuSefa () {
		
	}
	
	public void prikaziMenuZaposlenog () {
		
	}
}
