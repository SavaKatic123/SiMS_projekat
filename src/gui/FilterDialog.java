package gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import enumTypes.VrstaPerioda;
import enumTypes.VrstaVozila;

@SuppressWarnings("serial")
public class FilterDialog extends JDialog {
	private JLabel lbPeriod;
	private JLabel lbVrsta;
	private JComboBox<String> cbVrsta;
	private JTextField tfPeriod;
	private JButton btnConfirm;
	
	private boolean success;
	private Date period;
	private VrstaPerioda vrstaPerioda;
	private VrstaVozila vrstaVozila;

	public FilterDialog(Frame parent, int type) {
		JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
        
        String[] comboBoxContent;
        switch(type) {
        case 1:
        	lbVrsta = new JLabel("Po: ");
            cs.gridx = 0;
            cs.gridy = 0;
            cs.gridwidth = 1;
            panel.add(lbVrsta, cs);
     
            comboBoxContent = new String[]{"PoDanu", "PoMesecu", "PoGodini"};
            cbVrsta = new JComboBox<String>(comboBoxContent);
            cs.gridx = 1;
            cs.gridy = 0;
            cs.gridwidth = 2;
            panel.add(cbVrsta, cs);
     
            lbPeriod = new JLabel("Vreme(dd/mm/yyyy): ");
            cs.gridx = 0;
            cs.gridy = 1;
            cs.gridwidth = 1;
            panel.add(lbPeriod, cs);
     
            tfPeriod = new JTextField(20);
            cs.gridx = 1;
            cs.gridy = 1;
            cs.gridwidth = 2;
            panel.add(tfPeriod, cs);
            panel.setBorder(new LineBorder(Color.GRAY));
     
            btnConfirm = new JButton("Prihvati");
            btnConfirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	setVrstaPerioda(VrstaPerioda.fromString((String) cbVrsta.getSelectedItem()));
                	String periodString = tfPeriod.getText().trim();
                	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                	try {
    					setPeriod(sdf.parse(periodString));
    	            	success = true;
    	            	dispose();
    				} catch (ParseException e1) {
    					success = false;
    					e1.printStackTrace();
    				}
                }
            });
        	break;
        case 2:
        	lbVrsta = new JLabel("Kategorija: ");
            cs.gridx = 0;
            cs.gridy = 0;
            cs.gridwidth = 1;
            panel.add(lbVrsta, cs);
     
            comboBoxContent = new String[]{"Ia", "I", "II", "III", "IV"};
            cbVrsta = new JComboBox<String>(comboBoxContent);
            cs.gridx = 1;
            cs.gridy = 0;
            cs.gridwidth = 2;
            panel.add(cbVrsta, cs);
            btnConfirm = new JButton("Prihvati");
            btnConfirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	setVrstaVozila(VrstaVozila.fromString((String) cbVrsta.getSelectedItem()));
                	success = true;
                	dispose();
                }
            });
        	break;
        }
        
	}
	public boolean isSuccess() {
        return success;
    }
	public Date getPeriod() {
		return period;
	}
	public void setPeriod(Date period) {
		this.period = period;
	}
	public VrstaPerioda getVrstaPerioda() {
		return vrstaPerioda;
	}
	public void setVrstaPerioda(VrstaPerioda vrstaPerioda) {
		this.vrstaPerioda = vrstaPerioda;
	}
	public VrstaVozila getVrstaVozila() {
		return vrstaVozila;
	}
	public void setVrstaVozila(VrstaVozila vrstaVozila) {
		this.vrstaVozila = vrstaVozila;
	}
	
	
}
