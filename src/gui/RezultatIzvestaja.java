package gui;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class RezultatIzvestaja extends JDialog {
	private JLabel lbBrojVozila;
	private JLabel lbIznos;
	
	public RezultatIzvestaja(Frame parent, int brojVozila, double iznos) {
		super(parent, "Rezultat", true);
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
        
        lbBrojVozila = new JLabel("Broj vozila: " + brojVozila);
        lbIznos = new JLabel("Iznos: " + iznos);

        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbBrojVozila, cs);
        
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbIznos);
                
        JButton close = new JButton("Zatvori");
        panel.add(close);
        
        
        close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);

	}
}
