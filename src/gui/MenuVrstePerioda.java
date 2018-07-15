package gui;

import izvestaj.FilterIzvestaja;
import izvestaj.IzvestajPoDatumu;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import enumTypes.VrstaPerioda;

@SuppressWarnings("serial")
public class MenuVrstePerioda extends JFrame {
	final Font krupanFont = new Font("Serif", Font.BOLD, 40);
	final Font vrloKrupanFont = new Font("Serif", Font.BOLD, 60);
	private boolean success;
	public MenuVrstePerioda(final FilterIzvestaja f, final boolean flag) {
		JFrame Prozor = new JFrame("Prikaz izvestaja naplatne stanice");
		success = false;
		Prozor.setSize(1000, 700);
		Prozor.setVisible(true);
		
		JPanel panel = new JPanel(new GridLayout(5, 5));
		Prozor.add(panel);
		
		GridBagConstraints cs = new GridBagConstraints();
        
        cs.fill = GridBagConstraints.HORIZONTAL;
        
		final JRadioButton PoDanu = new JRadioButton("Po danu");
		final JRadioButton PoMesecu = new JRadioButton("Po mesecu");
		final JRadioButton PoGodini = new JRadioButton("Po godini");
		
		PoDanu.setFont(krupanFont);
		PoMesecu.setFont(krupanFont);
		PoGodini.setFont(krupanFont);
		ButtonGroup grupa = new ButtonGroup();
		grupa.add(PoDanu);
		grupa.add(PoMesecu);
		grupa.add(PoGodini);
		
		panel.add(PoDanu);
		panel.add(PoMesecu);
		panel.add(PoGodini);
		JButton izlistavanje = new JButton("Izlistaj");
		panel.add(izlistavanje);
		izlistavanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VrstaPerioda vp = null;
				if(PoDanu.isSelected()) {
					vp = VrstaPerioda.PoDanu;
				}
				if(PoMesecu.isSelected()) {
					vp = VrstaPerioda.PoMesecu;
				}
				if(PoGodini.isSelected()) {
					vp = VrstaPerioda.PoGodini;
				}
				String text = JOptionPane.showInputDialog(null, "Unesi datum (dd/mm/yyyy):");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
				try {
					Date period = sdf.parse(text);
					f.filtrirajPoPeriodu(vp, period);
					if(!flag) {
						IzvestajPoDatumu ipd = f.izracunajFiltrirane();
						RezultatIzvestaja dlg = new RezultatIzvestaja(new JFrame("Rezultat"), ipd.getBrojVozila(), ipd.getPlacenIznos());
						dlg.setVisible(true);
					}
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Pogresan format datuma, pokusati ponovo!", "Error", JOptionPane.ERROR_MESSAGE);
				}									
			}
		});

	}
	public boolean isSuccess() {
		return success;
	}
}
