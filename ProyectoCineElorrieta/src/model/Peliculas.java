package model;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import view.VistaPrincipal;

public class Peliculas extends JPanel {
	
	public Peliculas(VistaPrincipal ventana) {
		/**
		 * Tamaño del panel y otras funciones
		 */
		setSize(new Dimension(612, 615));
		setLayout(null);
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(202, 46, 45));
		panelLogin.setBounds(0, 0, 700, 535);
		add(panelLogin);
		panelLogin.setLayout(null);
	}
	
}
