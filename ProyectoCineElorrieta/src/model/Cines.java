package model;

import javax.swing.JPanel;

import view.VistaPrincipal;
import javax.swing.JLabel;

public class Cines extends JPanel {

	
	public Cines(VistaPrincipal ventana) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(186, 122, 103, 40);
		add(lblNewLabel);
		
	}
}
