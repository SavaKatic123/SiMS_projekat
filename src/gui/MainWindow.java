package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.Main;
import model.Korisnik;
import utility.Utility;


public class MainWindow extends JFrame {
	public MainWindow(String title, Korisnik k) {
		//TODO: Implement
		super(title);
		 
		this.setVisible(true);

		this.setSize(500,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setLocationRelativeTo(null); // vazno da se poziva nakon setSize()
		
		JButton btnLogout = new JButton("Logout");
		JPanel jp = new JPanel();
        jp.add(btnLogout);
        getContentPane().add(jp, BorderLayout.EAST);
		
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	Main.start();
            	System.exit(0);
            }
        });
        
        
        
        
        
        
        
        
        
        
        
        
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
