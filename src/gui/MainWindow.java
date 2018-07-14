package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Main;
import model.Korisnik;
import model.Rampa;
import states.RampaSeDize;


@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	public MainWindow(String title, Korisnik k) {
		//TODO: Implement
		super(title);
		 
		this.setVisible(true);

		this.setSize(1000,700);
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
		
		JPanel panel = new JPanel(new GridLayout(5, 5));
		this.add(panel);
		//getContentPane().add(panel, BorderLayout.WEST);
		GridBagConstraints cs = new GridBagConstraints();
        
        cs.fill = GridBagConstraints.HORIZONTAL;
        
		JButton button = new JButton("Pokreni rampu");
		button.setFont(new Font("Serif", Font.BOLD, 20));
		cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        
		panel.add(button);
		
		button.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final Rampa r = new Rampa();

		        boolean first = true;
		        
				while (true) {
					r.getStanje().entry();
					r.getStanje().execute();
					r.getStanje().exit();
					r.setStanje(r.getStanje().getSledeceStanje());
					if (r.getStanje().getClass().isInstance(new RampaSeDize()) && !first) {
						break;
					}
					first = false;
				}
				JOptionPane.showMessageDialog(null, "Rampa spustena, vozac prosao.");
				
			}
		});
		
		//panel.setBorder(new LineBorder(Color.GRAY));
		JLabel labela = new JLabel("Broj registarske tablice: ");
		labela.setFont(new Font("Serif", Font.BOLD, 20));
		
		cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        
		panel.add(labela);
		
		JTextField unosPolje = new JTextField(20);
		cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;	
		
		panel.add(unosPolje);
	}
	
	public void prikaziMenuAdministratora() {
		
	}
	
	public void prikaziMenuSefa () {
		
	}
	
	public void prikaziMenuZaposlenog () {
		
	}
}
