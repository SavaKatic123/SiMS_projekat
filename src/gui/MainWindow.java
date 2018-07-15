package gui;

import izvestaj.FilterIzvestaja;
import izvestaj.Izvestaj;
import izvestaj.IzvestajPoDatumu;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import main.Aplikacija;
import main.Main;
import model.Korisnik;
import model.Naplata;
import model.NaplatnaStanica;
import model.NaplatnoMesto;
import model.Rampa;
import states.NeRadi;
import states.RampaSeDize;
import utility.Utility;
import enumTypes.VrstaPerioda;
import enumTypes.VrstaVozila;


@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	final Font krupanFont = new Font("Serif", Font.BOLD, 40);
	final Font vrloKrupanFont = new Font("Serif", Font.BOLD, 60);
	Korisnik aktivanKorisnik = new Korisnik();
	public MainWindow(String title, Korisnik k) {
		super(title);
		aktivanKorisnik = k;
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
        
		switch(aktivanKorisnik.getVrsta()) {
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
		
		JButton x = new JButton("X");
		x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NaplatnoMesto nm = aktivanKorisnik.getNaplatnoMestoForUser();
				nm.setStanjeNaplate(new NeRadi());
				nm.setAktivno(false);
			}
		});
		prviPanel.add(x);
		
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
				
				final JTextField unosPolje = new JTextField(20);
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
				
				final JTextField unosPoljeCena = new JTextField(20);
				cs.gridx = 1;
		        cs.gridy = 2;
		        cs.gridwidth = 2;	
				
		        unosPoljeCena.setFont(vrloKrupanFont);
				panel.add(unosPoljeCena);
				
				JLabel labelaVrsta = new JLabel("Vrsta vozila: ");
				labelaVrsta.setFont(krupanFont);
				panel.add(labelaVrsta);
				final JTextField unosPoljeVrsta = new JTextField(20);
				cs.gridx = 1;
				cs.gridy = 3;
				cs.gridwidth = 2;
				
				unosPoljeVrsta.setFont(vrloKrupanFont);
		        panel.add(unosPoljeVrsta);
				
				JButton button = new JButton("Pokreni rampu");
				button.setFont(krupanFont);
				cs.gridx = 0;
		        cs.gridy = 0;
		        cs.gridwidth = 1;
		        
				panel.add(button);
				
				final NaplatnaStanica naplatnaStanica = aktivanKorisnik.getNaplatnaStanicaForUser();
				final NaplatnoMesto naplatnoMesto = aktivanKorisnik.getNaplatnoMestoForUser();
				
				button.addActionListener (new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!unosPolje.getText().trim().equals("") && !unosPoljeVrsta.getText().trim().equals("") && !unosPoljeCena.getText().trim().equals("")) {
							final Rampa r = naplatnoMesto.getRampa();

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
							Naplata naplata = new Naplata(unosPolje.getText(), Double.parseDouble(unosPoljeCena.getText().trim()), VrstaVozila.fromString(unosPoljeVrsta.getText().trim()));
							naplatnoMesto.dodajNaplatu(naplata);
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm");
							
							for(Izvestaj i: naplatnaStanica.getListaIzvestaja()) {
								if(sdf.format(i.getVreme()).equals(sdf.format(new Date()))) {
									for(IzvestajPoDatumu ipd: i.getPoDatumu()) {
										if(ipd.getVrstaVozila().equals(VrstaVozila.fromString(unosPoljeVrsta.getText().trim()))) {
											ipd.setPlacenIznos(Double.parseDouble(unosPoljeCena.getText().trim()) + ipd.getPlacenIznos());
											ipd.setBrojVozila(ipd.getBrojVozila() + 1);
										}
									}
								}
							}
							for(Izvestaj i: naplatnaStanica.getListaIzvestaja()) {
								System.out.println(i);
							}
							Utility.upisi();
						} else {
							JOptionPane.showMessageDialog(null, "Potrebno popuniti sva obavezna polja!", "Error", JOptionPane.ERROR_MESSAGE);
						}						
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
				
				final JTextField unosPolje = new JTextField(20);
				cs.gridx = 1;
		        cs.gridy = 1;
		        cs.gridwidth = 2;	
				
		        unosPolje.setFont(vrloKrupanFont);
				panel.add(unosPolje);
				
				JLabel labelaVrsta = new JLabel("Vrsta vozila: ");
				labelaVrsta.setFont(krupanFont);
				panel.add(labelaVrsta);
				final JTextField unosPoljeVrsta = new JTextField(20);
				cs.gridx = 1;
				cs.gridy = 3;
				cs.gridwidth = 2;
				panel.add(unosPoljeVrsta);

				final NaplatnoMesto naplatnoMesto = aktivanKorisnik.getNaplatnoMestoForUser();
				
				JButton dugmeSkeniraj = new JButton("Skeniraj");
				panel.add(dugmeSkeniraj);
				dugmeSkeniraj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!unosPolje.getText().trim().equals("") && !unosPoljeVrsta.getText().trim().equals("")) {
							final Rampa r = naplatnoMesto.getRampa();

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
							
						} else {
							JOptionPane.showMessageDialog(null, "Potrebno popuniti sva obavezna polja!", "Error", JOptionPane.ERROR_MESSAGE);
						}
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
				
				final JTextField unosPolje = new JTextField(20);
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
						boolean success = false;
						String naziv = unosPolje.getText().trim();
						if(naziv != null) {
							NaplatnaStanica ns = new NaplatnaStanica(naziv);
							success = true;
							Aplikacija.getInstance().dodajNaplatnuStanicu(ns);
						}
						
						if (success) {
							Utility.upisi();
							JOptionPane.showMessageDialog(null, "Naplatna stanica dodata.");
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
				
				final JTextField unosPolje = new JTextField(20);
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
						boolean success = false;
						String naziv = unosPolje.getText().trim();
						if(naziv != null) {
							for(NaplatnaStanica ns: Aplikacija.getInstance().listaNaplatnihStanica) {
								if(ns.getNazivStanice().equals(naziv)) {
									String text = JOptionPane.showInputDialog(null, "Unesi novi naziv:");
									if(text != null) {
										ns.setNazivStanice(text);
										success = true;
									}
								}
							}
						}
						
						if (success) {
							Utility.upisi();
							JOptionPane.showMessageDialog(null, "Naplatna stanica promenjena.");
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
				
				final JTextField unosPolje = new JTextField(20);
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
						boolean success = false;
						String naziv = unosPolje.getText().trim();
						if(naziv != null) {
							NaplatnaStanica stanica = null;
							for(NaplatnaStanica ns: Aplikacija.getInstance().listaNaplatnihStanica) {
								if(ns.getNazivStanice().equals(naziv)) {
									stanica = ns;
									success = true;
								}
							}
							Aplikacija.getInstance().listaNaplatnihStanica.remove(stanica);
						}
						if (success) {
							Utility.upisi();
							JOptionPane.showMessageDialog(null, "Naplatna stanica obrisana.");
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
		JRadioButton IzmenaDugme = new JRadioButton("Izmena naplatne stanice");
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
				
				final JTextField unosPolje = new JTextField(20);
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
						boolean success = false;
						String naziv = unosPolje.getText().trim();
						if(naziv != null) {
							NaplatnaStanica ns = new NaplatnaStanica(naziv);
							success = true;
							Aplikacija.getInstance().dodajNaplatnuStanicu(ns);
						}
						
						if (success) {
							Utility.upisi();
							JOptionPane.showMessageDialog(null, "Naplatna stanica dodata.");
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
				JFrame ONProzor = new JFrame("Izmena podataka o naplatnoj stanici");
				
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
				
				final JTextField unosPolje = new JTextField(20);
				cs.gridx = 1;
		        cs.gridy = 1;
		        cs.gridwidth = 2;	
				
		        unosPolje.setFont(vrloKrupanFont);
				panel.add(unosPolje);
				
		        
				JButton button = new JButton("Izmeni");
				button.setFont(krupanFont);
				cs.gridx = 0;
		        cs.gridy = 0;
		        cs.gridwidth = 1;
		        
				panel.add(button);
				
				button.addActionListener (new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean success = false;
						String naziv = unosPolje.getText().trim();
						if(naziv != null) {
							for(NaplatnaStanica ns: Aplikacija.getInstance().listaNaplatnihStanica) {
								if(ns.getNazivStanice().equals(naziv)) {
									String text = JOptionPane.showInputDialog(null, "Unesi novi naziv:");
									if(text != null) {
										ns.setNazivStanice(text);
										success = true;
									}
								}
							}
						}
						
						if (success) {
							Utility.upisi();
							JOptionPane.showMessageDialog(null, "Naplatna stanica promenjena.");
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
		        
				final JRadioButton PoDatumuDugme = new JRadioButton("Po datumu");
				final JRadioButton PoVrstiVozilaDugme = new JRadioButton("Po vrsti vozila");
				
				PoDatumuDugme.setFont(krupanFont);
				PoVrstiVozilaDugme.setFont(krupanFont);
				
				panel.add(PoDatumuDugme);
				panel.add(PoVrstiVozilaDugme);
				
				JButton button = new JButton("Izaberi");
				panel.add(button);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						final FilterIzvestaja f = new FilterIzvestaja(aktivanKorisnik.getNaplatnaStanicaForUser().listaIzvestaja);
						if(PoDatumuDugme.isSelected()) {
							MenuVrstePerioda menuP = new MenuVrstePerioda(f, PoVrstiVozilaDugme.isSelected());
						}
						if(PoVrstiVozilaDugme.isSelected()) {
							MenuVrsteVozila menuV = new MenuVrsteVozila(f);
						}
						
					}
				});
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
		IzvestajiDugme.setFont(krupanFont);
		
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
		        
				final JRadioButton PoDatumuDugme = new JRadioButton("Po datumu");
				final JRadioButton PoVrstiVozilaDugme = new JRadioButton("Po vrsti vozila");
				
				PoDatumuDugme.setFont(krupanFont);
				PoVrstiVozilaDugme.setFont(krupanFont);
				
				panel.add(PoDatumuDugme);
				panel.add(PoVrstiVozilaDugme);
				JButton button = new JButton("Izaberi");
				panel.add(button);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int brojVozila = 0;
						double iznos = 0;
						for(NaplatnaStanica ns: Aplikacija.getInstance().listaNaplatnihStanica) {
							final FilterIzvestaja f = new FilterIzvestaja(ns.listaIzvestaja);
							if(PoDatumuDugme.isSelected()) {
								MenuVrstePerioda menuP = new MenuVrstePerioda(f, PoVrstiVozilaDugme.isSelected());
							}
							if(PoVrstiVozilaDugme.isSelected()) {
								MenuVrsteVozila menuV = new MenuVrsteVozila(f);
							}
							
						}

						RezultatIzvestaja dlg = new RezultatIzvestaja(new JFrame("Rezultat"), brojVozila, iznos);
						dlg.setVisible(true);
					}
				});
			}
		};

		IzvestajiDugme.addActionListener(IzvestajiAL);
	}
}
