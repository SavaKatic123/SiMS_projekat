package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JWindow;

import main.Main;
import model.Korisnik;
import model.Rampa;
import states.RampaSeDize;


@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	final Font krupanFont = new Font("Serif", Font.BOLD, 40);
	final Font vrloKrupanFont = new Font("Serif", Font.BOLD, 60);
	public MainWindow(String title, Korisnik k) {
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
		
		JPanel prviPanel = new JPanel();
		this.add(prviPanel);
		JRadioButton ONDugme = new JRadioButton("Obicna naplata");
		JRadioButton ENDugme = new JRadioButton("Elektronska naplata");
		ONDugme.setFont(krupanFont);
		ENDugme.setFont(krupanFont);
		
		ButtonGroup grupa = new ButtonGroup();
		grupa.add(ONDugme);
		grupa.add(ENDugme);
		
		prviPanel.add(ONDugme);
		prviPanel.add(ENDugme);
		
		ActionListener ONAL = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Prozor = new JFrame("Obicna naplata");
				
				Prozor.setSize(1000, 700);
				Prozor.setVisible(true);
				
				JPanel panel = new JPanel(new GridLayout(5, 5));
				Prozor.add(panel);
				
				GridBagConstraints cs = new GridBagConstraints();
		        
		        cs.fill = GridBagConstraints.HORIZONTAL;
				
				JLabel labela = new JLabel("Broj registarske tablice: ");
				labela.setFont(krupanFont);
				
				cs.gridx = 0;
		        cs.gridy = 1;
		        cs.gridwidth = 1;
		        
				panel.add(labela);
				
				JTextField unosPolje = new JTextField(20);
				cs.gridx = 1;
		        cs.gridy = 1;
		        cs.gridwidth = 2;	
				
		        unosPolje.setFont(vrloKrupanFont);
				panel.add(unosPolje);
				
				JLabel labelaCena = new JLabel("Cena: ");
				labelaCena.setFont(krupanFont);
				
				cs.gridx = 0;
		        cs.gridy = 2;
		        cs.gridwidth = 1;
		        
				panel.add(labelaCena);
				
				JTextField unosPoljeCena = new JTextField(20);
				cs.gridx = 1;
		        cs.gridy = 2;
		        cs.gridwidth = 2;	
				
		        unosPoljeCena.setFont(vrloKrupanFont);
				panel.add(unosPoljeCena);
				
		        
				JButton button = new JButton("Pokreni rampu");
				button.setFont(krupanFont);
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
				


			}
		};
		
		ActionListener ENAL = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Prozor = new JFrame("Elektronska naplata");
				
				Prozor.setSize(1000, 700);
				Prozor.setVisible(true);
				
				JPanel panel = new JPanel(new GridLayout(5, 5));
				Prozor.add(panel);
				
				GridBagConstraints cs = new GridBagConstraints();
		        
		        cs.fill = GridBagConstraints.HORIZONTAL;
				JLabel labela = new JLabel("Broj registarske tablice: ");
				labela.setFont(krupanFont);
				
				cs.gridx = 0;
		        cs.gridy = 1;
		        cs.gridwidth = 1;
		        
				panel.add(labela);
				
				JTextField unosPolje = new JTextField(20);
				cs.gridx = 1;
		        cs.gridy = 1;
		        cs.gridwidth = 2;	
				
		        unosPolje.setFont(vrloKrupanFont);
				panel.add(unosPolje);
				
				JButton dugmeSkeniraj = new JButton("Skeniraj");
				panel.add(dugmeSkeniraj);
				dugmeSkeniraj.addActionListener(new ActionListener() {
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
						JOptionPane.showMessageDialog(null, "Tag uspesno ocitan, naplata izvrsena, rampa spustena, vozac prosao.");
						
					}
				});
				
				
				
			}
		};
		
		ONDugme.addActionListener(ONAL);
		ENDugme.addActionListener(ENAL);

	}
	
	public void prikaziMenuAdministratora() {
		JPanel prviPanel = new JPanel();
		this.add(prviPanel);
		JRadioButton UnosDugme = new JRadioButton("Unos nove naplatne stanice");
		JRadioButton IzmenaDugme = new JRadioButton("Izmena postojece naplatne stanice");
		JRadioButton BrisanjeDugme = new JRadioButton("Brisanje postojece naplatne stanice");
		UnosDugme.setFont(krupanFont);
		IzmenaDugme.setFont(krupanFont);
		BrisanjeDugme.setFont(krupanFont);
		
		ButtonGroup grupa = new ButtonGroup();
		grupa.add(UnosDugme);
		grupa.add(IzmenaDugme);
		grupa.add(BrisanjeDugme);
		
		prviPanel.add(UnosDugme);
		prviPanel.add(IzmenaDugme);
		prviPanel.add(BrisanjeDugme);
		
		ActionListener UnosAL = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Prozor = new JFrame("Unos nove naplatne stanice");
				
				Prozor.setSize(1000, 700);
				Prozor.setVisible(true);
				
				JPanel panel = new JPanel(new GridLayout(5, 5));
				Prozor.add(panel);
				
				GridBagConstraints cs = new GridBagConstraints();
		        
		        cs.fill = GridBagConstraints.HORIZONTAL;
				
				JLabel labela = new JLabel("Naziv naplatne stanice: ");
				labela.setFont(krupanFont);
				
				cs.gridx = 0;
		        cs.gridy = 1;
		        cs.gridwidth = 1;
		        
				panel.add(labela);
				
				JTextField unosPolje = new JTextField(20);
				cs.gridx = 1;
		        cs.gridy = 1;
		        cs.gridwidth = 2;	
				
		        unosPolje.setFont(vrloKrupanFont);
				panel.add(unosPolje);
						        
				JButton button = new JButton("Napravi");
				button.setFont(krupanFont);
				cs.gridx = 0;
		        cs.gridy = 0;
		        cs.gridwidth = 1;
		        
				panel.add(button);
				
				button.addActionListener (new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean success = true;
						/* TODO: treba da se prikaze novi prozor, na kom ce
						 * moci da se unose atributi naplatne stanice koja
						 * se kreira.
						 * Korisnika obavestiti o uspesnosti kreiranja.
						 */
						if (success) {
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Naplatna stanica sa unesenim nazivom vec postoji!");
						}
						
						
					}
				});
				


			}
		};

		ActionListener IzmenaAL = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Prozor = new JFrame("Izmena postojece naplatne stanice");
				
				Prozor.setSize(1000, 700);
				Prozor.setVisible(true);
				
				JPanel panel = new JPanel(new GridLayout(5, 5));
				Prozor.add(panel);
				
				GridBagConstraints cs = new GridBagConstraints();
		        
		        cs.fill = GridBagConstraints.HORIZONTAL;
				
				JLabel labela = new JLabel("Naziv naplatne stanice koju zelite da izmenite: ");
				labela.setFont(krupanFont);
				
				cs.gridx = 0;
		        cs.gridy = 1;
		        cs.gridwidth = 1;
		        
				panel.add(labela);
				
				JTextField unosPolje = new JTextField(20);
				cs.gridx = 1;
		        cs.gridy = 1;
		        cs.gridwidth = 2;	
				
		        unosPolje.setFont(vrloKrupanFont);
				panel.add(unosPolje);
						        
				JButton button = new JButton("Pretrazi");
				button.setFont(krupanFont);
				cs.gridx = 0;
		        cs.gridy = 0;
		        cs.gridwidth = 1;
		        
				panel.add(button);
				
				button.addActionListener (new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean success = true;
						/* TODO:  Treba prikazati novi prozor, u kome mogu da 
						 * se menjaju atributi naplatne stanice.
						 * Ime naplatne stanice ne moze da se menja.
						 * Nakon izmene, azurirati listu naplatnih stanica
						 * i ponovo je upisati u fajl.
						 * Korisnika dijalogom obavestiti o uspesnosti
						 * izmene.
						 */
						if (success) {
							
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Naplatna stanica sa unesenim nazivom ne postoji.");
						}
					}
				});
				


			}
		};
		
		ActionListener BrisanjeAL = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Prozor = new JFrame("Brisanje postojece naplatne stanice");
				
				Prozor.setSize(1000, 700);
				Prozor.setVisible(true);
				
				JPanel panel = new JPanel(new GridLayout(5, 5));
				Prozor.add(panel);
				
				GridBagConstraints cs = new GridBagConstraints();
		        
		        cs.fill = GridBagConstraints.HORIZONTAL;
				
				JLabel labela = new JLabel("Unesite naziv naplatne stanice koju zelite da obrisete: ");
				labela.setFont(krupanFont);
				
				cs.gridx = 0;
		        cs.gridy = 1;
		        cs.gridwidth = 1;
		        
				panel.add(labela);
				
				JTextField unosPolje = new JTextField(20);
				cs.gridx = 1;
		        cs.gridy = 1;
		        cs.gridwidth = 2;	
				
		        unosPolje.setFont(vrloKrupanFont);
				panel.add(unosPolje);
				
		        
				JButton button = new JButton("Obrisi");
				button.setFont(krupanFont);
				cs.gridx = 0;
		        cs.gridy = 0;
		        cs.gridwidth = 1;
		        
				panel.add(button);
				
				button.addActionListener (new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean success = true;
						/* TODO: Treba pronaci naplatnu stanicu sa unesenim 
						 * nazivom u listi naplatnih stanica i izbrisati je.
						 * Zatim, ponovo upisati listu u fajl.
						 */
						if (success) {
							
							JOptionPane.showMessageDialog(null, "Naplatna stanica sa unesenim nazivom uspesno obrisana.");
						}
						else {
							JOptionPane.showMessageDialog(null, "Naplatna stanica sa unesenim nazivom ne postoji.");
						}
						
						
					}
				});
				


			}
		};

		UnosDugme.addActionListener(UnosAL);
		IzmenaDugme.addActionListener(IzmenaAL);
		BrisanjeDugme.addActionListener(BrisanjeAL);
	}
	
	public void prikaziMenuSefa () {
		JPanel prviPanel = new JPanel();
		this.add(prviPanel);
		JRadioButton UnosDugme = new JRadioButton("Unos podataka o naplatnoj stanici");
		JRadioButton IzmenaDugme = new JRadioButton("Izmena cena na deonicama naplatne stanice");
		JRadioButton IzvestajiDugme = new JRadioButton("Gledanje izvestaja naplatne stanice");
		UnosDugme.setFont(krupanFont);
		IzmenaDugme.setFont(krupanFont);
		IzvestajiDugme.setFont(krupanFont);
		
		ButtonGroup grupa = new ButtonGroup();
		grupa.add(UnosDugme);
		grupa.add(IzmenaDugme);
		grupa.add(IzvestajiDugme);
		
		prviPanel.add(UnosDugme);
		prviPanel.add(IzmenaDugme);
		prviPanel.add(IzvestajiDugme);
		
		
		ActionListener UnosAL = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame ONProzor = new JFrame("Unos podataka o naplatnoj stanici");
				
				ONProzor.setSize(1000, 700);
				ONProzor.setVisible(true);
				
				JPanel panel = new JPanel(new GridLayout(5, 5));
				ONProzor.add(panel);
				
				GridBagConstraints cs = new GridBagConstraints();
		        
		        cs.fill = GridBagConstraints.HORIZONTAL;
				
				JLabel labela = new JLabel("Unesite naziv naplatne stanice: ");
				labela.setFont(krupanFont);
				
				cs.gridx = 0;
		        cs.gridy = 1;
		        cs.gridwidth = 1;
		        
				panel.add(labela);
				
				JTextField unosPolje = new JTextField(20);
				cs.gridx = 1;
		        cs.gridy = 1;
		        cs.gridwidth = 2;	
				
		        unosPolje.setFont(vrloKrupanFont);
				panel.add(unosPolje);
				
		        
				JButton button = new JButton("Napravi");
				button.setFont(krupanFont);
				cs.gridx = 0;
		        cs.gridy = 0;
		        cs.gridwidth = 1;
		        
				panel.add(button);
				
				button.addActionListener (new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean success = true;
						/* TODO: Treba proveriti da li naplatna stanica sa
						 * unesenim nazivom vec postoji. Ako ne postoji,
						 * napraviti naplatnu stanicu u skladu sa vrednostima
						 * i dodati je u listu naplatnih stanica.
						 * Listu naplatnih stanica upisati u fajl.
						 * Korisnika obavestiti o uspesnosti kreiranja naplatne
						 * stanice.
						 */
						if (success) {
							
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Naplatna stanica sa unesenim nazivom vec postoji.");
						}
						
						
					}
				});
				


			}
		};

		ActionListener IzmenaAL = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame ONProzor = new JFrame("Izmena podataka o naplatnoj stanici");
				
				ONProzor.setSize(1000, 700);
				ONProzor.setVisible(true);
				
				JPanel panel = new JPanel(new GridLayout(5, 5));
				ONProzor.add(panel);
				
				GridBagConstraints cs = new GridBagConstraints();
		        
		        cs.fill = GridBagConstraints.HORIZONTAL;
				
				JButton button = new JButton("Izmeni");
				button.setFont(krupanFont);
				cs.gridx = 0;
		        cs.gridy = 0;
		        cs.gridwidth = 1;
		        
				panel.add(button);
				
				button.addActionListener (new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean success = true;
						/* TODO:  Treba prikazati novi prozor, u kome mogu da 
						 * se menjaju atributi naplatne stanice.
						 * Ime naplatne stanice ne moze da se menja.
						 * Nakon izmene, azurirati listu naplatnih stanica
						 * i ponovo je upisati u fajl.
						 * Korisnika dijalogom obavestiti o uspesnosti
						 * izmene.
						 */
						if (success) {
							
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Naplatna stanica sa unesenim nazivom ne postoji.");
						}
					}
				});
				


			}
		};


		ActionListener IzvestajiAL = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Prozor = new JFrame("Prikaz izvestaja naplatne stanice");
				
				Prozor.setSize(1000, 700);
				Prozor.setVisible(true);
				
				JPanel panel = new JPanel(new GridLayout(5, 5));
				Prozor.add(panel);
				
				GridBagConstraints cs = new GridBagConstraints();
		        
		        cs.fill = GridBagConstraints.HORIZONTAL;
		        
				JRadioButton PoDatumuDugme = new JRadioButton("Po datumu");
				JRadioButton PoNaplacenomIznosuDugme = new JRadioButton("Po naplacenom iznosu");
				JRadioButton PoPerioduDugme = new JRadioButton("Po periodu");
				JRadioButton PoVrstiVozilaDugme = new JRadioButton("Po vrsti vozila");
				
				PoDatumuDugme.setFont(krupanFont);
				PoNaplacenomIznosuDugme.setFont(krupanFont);
				PoPerioduDugme.setFont(krupanFont);
				PoVrstiVozilaDugme.setFont(krupanFont);
				
				ButtonGroup grupa = new ButtonGroup();
				grupa.add(PoDatumuDugme);
				grupa.add(PoNaplacenomIznosuDugme);
				grupa.add(PoPerioduDugme);
				grupa.add(PoVrstiVozilaDugme);
				
				panel.add(PoDatumuDugme);
				panel.add(PoNaplacenomIznosuDugme);
				panel.add(PoPerioduDugme);
				panel.add(PoVrstiVozilaDugme);
				
		        // TODO: prikazati sve izvestaje po odabranom kriterijumu korisniku na novom prozoru
			}
		};

		
		UnosDugme.addActionListener(UnosAL);
		IzmenaDugme.addActionListener(IzmenaAL);
		IzvestajiDugme.addActionListener(IzvestajiAL);
	}
	
	public void prikaziMenuZaposlenog () {
		JPanel prviPanel = new JPanel();
		this.add(prviPanel);
		JRadioButton IzvestajiDugme = new JRadioButton("Gledanje svih izvestaja");
		prviPanel.add(IzvestajiDugme);

		ActionListener IzvestajiAL = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame Prozor = new JFrame("Prikaz svih izvestaja");
				
				Prozor.setSize(1000, 700);
				Prozor.setVisible(true);
				
				JPanel panel = new JPanel(new GridLayout(5, 5));
				Prozor.add(panel);
				
				GridBagConstraints cs = new GridBagConstraints();
		        
		        cs.fill = GridBagConstraints.HORIZONTAL;
				
		        JRadioButton PoDatumuDugme = new JRadioButton("Po datumu");
				JRadioButton PoNaplacenomIznosuDugme = new JRadioButton("Po naplacenom iznosu");
				JRadioButton PoPerioduDugme = new JRadioButton("Po periodu");
				JRadioButton PoVrstiVozilaDugme = new JRadioButton("Po vrsti vozila");
				
				PoDatumuDugme.setFont(krupanFont);
				PoNaplacenomIznosuDugme.setFont(krupanFont);
				PoPerioduDugme.setFont(krupanFont);
				PoVrstiVozilaDugme.setFont(krupanFont);
				
				ButtonGroup grupa = new ButtonGroup();
				grupa.add(PoDatumuDugme);
				grupa.add(PoNaplacenomIznosuDugme);
				grupa.add(PoPerioduDugme);
				grupa.add(PoVrstiVozilaDugme);
				
				panel.add(PoDatumuDugme);
				panel.add(PoNaplacenomIznosuDugme);
				panel.add(PoPerioduDugme);
				panel.add(PoVrstiVozilaDugme);
		        
		        /* TODO: prikazati izvestaje naplatne stanice po odabranom 
		         * kriterijumu korisniku na novom prozoru
				*/
			}
		};

		IzvestajiDugme.addActionListener(IzvestajiAL);
	}
}
