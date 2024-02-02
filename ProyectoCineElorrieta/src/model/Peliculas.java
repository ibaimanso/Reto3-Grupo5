package model;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.VistaPrincipal;
import java.awt.Font;
import java.awt.Dimension;

public class Peliculas extends JPanel {
	
	public Peliculas(VistaPrincipal ventana) {
		/**
		 * Se le da una altura y una anchura al JPanel. Se hace que no se pueda
		 * redimensionar la VentanaPrincipal
		 */
		setSize(new Dimension(664, 452));
		setVisible(true);
		setLayout(null);
		
		JLabel lblFinestCines = new JLabel("FINEST CINES");
		lblFinestCines.setFont(new Font("Ink Free", Font.BOLD, 39));
		lblFinestCines.setBounds(188, -35, 399, 178);
		add(lblFinestCines);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 107, 623, 264);
		add(panel);
		panel.setLayout(null);
		
		JLabel fotopelicula = new JLabel("foto");
		fotopelicula.setBounds(10, 11, 146, 242);
		panel.add(fotopelicula);
		
		JLabel nombrepelicula = new JLabel("nombre");
		nombrepelicula.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		nombrepelicula.setBounds(176, 11, 129, 27);
		panel.add(nombrepelicula);
		
		JLabel lblDuracion = new JLabel("duración:");
		lblDuracion.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblDuracion.setBounds(176, 49, 129, 27);
		panel.add(lblDuracion);
		
		JLabel lblGenero = new JLabel("genero:");
		lblGenero.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblGenero.setBounds(176, 87, 129, 27);
		panel.add(lblGenero);
		
		JLabel lblPrecio = new JLabel("precio:");
		lblPrecio.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblPrecio.setBounds(176, 125, 129, 27);
		panel.add(lblPrecio);
	}
}