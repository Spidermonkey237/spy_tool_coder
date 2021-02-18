package pis.hue1;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;





public class CodecGUI extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel wurfelPanel;
	private JPanel ceasarPanel;
	private JLayeredPane layeredP;
	private JTextArea key1;
	private JButton jB_verschlusseln;
	private JButton jB_entschlusseln;
	private JTextArea klartext_c;
	private JTextArea key2;
	private JButton jB_verschC;
	private JButton jB_entchC;
	private JButton btnDoppelwuerfel;
	private JButton btnCaesar;
	private JTextArea losungc;
	private JTextArea losungW;
	private JTextArea textW;
	Codec obj1,obj2;
	
/**
 * @param obj1 will host an object of the Wuerfel class
 * @param obj2 will host an object of the Caesar class
 */
public CodecGUI(Codec obj1,Codec obj2) {
		
		this.obj1=obj1;  
		this.obj2=obj2;
		
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 644, 394);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	contentPane.setLayout(null);
		
	layeredP = new JLayeredPane();
	layeredP.setBounds(0, 70, 628, 274);
	contentPane.add(layeredP);
		layeredP.setLayout(new CardLayout(0, 0));
		
		wurfelPanel = new JPanel();
		layeredP.add(wurfelPanel, "panel_w");
		wurfelPanel.setLayout(null);
		
		key1 = new JTextArea();
		key1.setLineWrap(true);
		key1.setText("Schwarzwald");
		key1.setBounds(164, 108, 440, 22);
		wurfelPanel.add(key1);
		
		JLabel label3 = new JLabel("Text eingeben :");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setBounds(10, 50, 137, 22);
		wurfelPanel.add(label3);
		
		JLabel label1 = new JLabel(" Schlüssel :");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(36, 112, 100, 17);
		wurfelPanel.add(label1);
		
		jB_verschlusseln = new JButton("Verschlüsseln");
		jB_verschlusseln.setBounds(233, 240, 123, 23);
		wurfelPanel.add(jB_verschlusseln);
		jB_verschlusseln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wurfel_kodieren(e);
			}
		});
		
		jB_entschlusseln = new JButton("Entschlusseln");
		jB_entschlusseln.setBounds(382, 240, 137, 23);
		wurfelPanel.add(jB_entschlusseln);
		jB_entschlusseln.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wurfel_dekodieren(e);
			}
		});
		
		textW = new JTextArea();
		textW.setText("rneregnfirsrtdeulnsptnveoedtmeeregteaefntnfuei");
		textW.setLineWrap(true);
		textW.setForeground(new Color(0, 0, 0));
		textW.setBounds(164, 11, 440, 92);
		wurfelPanel.add(textW);
		
		losungW = new JTextArea();
		losungW.setLineWrap(true);
		losungW.setEditable(false);
		losungW.setBounds(164, 141, 440, 92);
		wurfelPanel.add(losungW);
		
		ceasarPanel = new JPanel();
		layeredP.add(ceasarPanel, "panel_ceasar");
		ceasarPanel.setLayout(null);
		
		klartext_c = new JTextArea();
		klartext_c.setLineWrap(true);
		klartext_c.setText("Le cyber zöide qui fretille a des particularites incomprises");
		klartext_c.setBounds(167, 11, 439, 93);
		ceasarPanel.add(klartext_c);
		
		key2 = new JTextArea();
		key2.setLineWrap(true);
		key2.setText("2077");
		key2.setBounds(167, 110, 439, 23);
		ceasarPanel.add(key2);
		
		
		JLabel labbel1c = new JLabel("Text eingeben :");
		labbel1c.setHorizontalAlignment(SwingConstants.CENTER);
		labbel1c.setBounds(10, 35, 158, 53);
		ceasarPanel.add(labbel1c);
		
		JLabel label2c = new JLabel("schlüssel :");
		label2c.setHorizontalAlignment(SwingConstants.CENTER);
		label2c.setBounds(10, 119, 158, 14);
		ceasarPanel.add(label2c);
		
		jB_verschC = new JButton("Verschlüsseln");
		jB_verschC.setBounds(204, 248, 152, 24);
		ceasarPanel.add(jB_verschC);
		jB_verschC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caesar_kodieren(e);
			}
		});
		
		jB_entchC = new JButton("Entschlüsseln");
		jB_entchC.setBounds(394, 248, 152, 24);
		ceasarPanel.add(jB_entchC);
		jB_entchC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				caesar_dekodieren(e);
			}
		});
		
		losungc = new JTextArea();
		losungc.setEditable(false);
		losungc.setLineWrap(true);
		losungc.setBounds(167, 144, 439, 93);
		ceasarPanel.add(losungc);
		
		btnDoppelwuerfel = new JButton("DoppelWuerfel");
		btnDoppelwuerfel.setBounds(114, 21, 151, 23);
		contentPane.add(btnDoppelwuerfel);
		btnDoppelwuerfel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchP(wurfelPanel);
			}
		});
		
		btnCaesar = new JButton("Caesar");
		btnCaesar.setBounds(292, 21, 151, 23);
		contentPane.add(btnCaesar);
		btnCaesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchP(ceasarPanel);
			}
		});
		
		
		
		
		
		
	}

	/**
	 * @param event1
	 * this method retrieves the GUI inputs(schluessel ) and passes them to the "kodiere" method for the cubic coding.
	 */
	public void wurfel_kodieren(ActionEvent event1) {
		obj1.setzeLosung(key1.getText());
		losungW.setText(obj1.kodiere(textW.getText()));
		
	}
	
	/**
	 * this method retrieves the GUI inputs(schluessel ) and passes them to the "dekodiere" method for the cubic decoding.
	 * @param event2
	 */
	public void wurfel_dekodieren(ActionEvent event2) {
		obj1.setzeLosung(key1.getText());
		losungW.setText(obj1.dekodiere(textW.getText()));
		
	}
	
	/**
	 * @param event3
	 * this method retrieves the GUI inputs(schluessel ) and passes them to the "kodiere" method for the caesar coding.
	 */
	public void caesar_kodieren(ActionEvent event3) {
		obj2.setzeLosung(key2.getText());
		losungc.setText(obj2.kodiere(klartext_c.getText()));
		
	}
	
	/**
	 * this method retrieves the GUI inputs(schluessel ) and passes them to the "dekodiere" method for the caesar coding.
	 * @param event4
	 */
	public void caesar_dekodieren(ActionEvent event4) {
		obj2.setzeLosung(key2.getText());
		losungc.setText(obj2.dekodiere(klartext_c.getText()));
		
	}
	
	/**
	 * @param panel
	 * the switchP(JPanel) methods allows to change panel
	 */
	public void switchP(JPanel panel) {
		layeredP.removeAll();
		layeredP.add(panel);
		layeredP.repaint();
		layeredP.revalidate();
	}
	
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CodecGUI frame = new CodecGUI(new Wuerfel(), new Caesar());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	
	
}





