package model;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.VistaPrincipal;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Registro extends JPanel {
	
	
	public Registro(VistaPrincipal ventana) {
		
		setSize(ventana.getSize());
		setVisible(true);
		setLayout(null);
		
		JLabel lblFinestCines = new JLabel("FINEST CINES");
		lblFinestCines.setToolTipText("");
		lblFinestCines.setFont(new Font("Lucida Bright", Font.PLAIN, 25));
		lblFinestCines.setBounds(242, 89, 359, 90);
		add(lblFinestCines);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("multimedia/FondoLogin"));
		lblFondo.setBounds(0, 0, 611, 558);
		add(lblFondo);
		

	}
}
