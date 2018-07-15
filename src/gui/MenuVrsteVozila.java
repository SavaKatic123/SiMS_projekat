package gui;

import izvestaj.FilterIzvestaja;
import izvestaj.IzvestajPoDatumu;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import enumTypes.VrstaVozila;

@SuppressWarnings("serial")
public class MenuVrsteVozila extends JFrame {
	final Font krupanFont = new Font("Serif", Font.BOLD, 40);
	final Font vrloKrupanFont = new Font("Serif", Font.BOLD, 60);
	public MenuVrsteVozila(final FilterIzvestaja f) {
		super("Prikaz izvestaja naplatne stanice.");
		setSize(1000, 700);
		setVisible(true);
		
		JPanel panel = new JPanel(new GridLayout(5, 5));
		add(panel);
		
		GridBagConstraints cs = new GridBagConstraints();
        
        cs.fill = GridBagConstraints.HORIZONTAL;
        
		final JRadioButton prva = new JRadioButton("I");
		final JRadioButton prvaA = new JRadioButton("Ia");
		final JRadioButton druga = new JRadioButton("II");
		final JRadioButton treca = new JRadioButton("III");
		final JRadioButton cetvrta = new JRadioButton("IV");
		prva.setFont(krupanFont);
		prvaA.setFont(krupanFont);
		druga.setFont(krupanFont);
		treca.setFont(krupanFont);
		cetvrta.setFont(krupanFont);
		
		ButtonGroup grupa = new ButtonGroup();
		grupa.add(prva);
		grupa.add(prvaA);
		grupa.add(druga);
		grupa.add(treca);
		grupa.add(cetvrta);
		
		panel.add(prva);
		panel.add(prvaA);
		panel.add(druga);
		panel.add(treca);
		panel.add(cetvrta);
		JButton izlistavanje = new JButton("Izlistaj");
		panel.add(izlistavanje);
		izlistavanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VrstaVozila vv = null;
				if(prva.isSelected()) {
					vv = VrstaVozila.I;
				}
				if(prvaA.isSelected()) {
					vv = VrstaVozila.Ia;
				}
				if(druga.isSelected()) {
					vv = VrstaVozila.II;
				}
				if(treca.isSelected()) {
					vv = VrstaVozila.III;
				}
				if(cetvrta.isSelected()) {
					vv = VrstaVozila.IV;
				}
				f.filtrirajPoVrstiVozila(vv);
				IzvestajPoDatumu ipd = f.izracunajFiltrirane();
				RezultatIzvestaja dlg = new RezultatIzvestaja(new JFrame("Rezultat"), ipd.getBrojVozila(), ipd.getPlacenIznos());
				dlg.setVisible(true);
			}
		});
	}
	
}
