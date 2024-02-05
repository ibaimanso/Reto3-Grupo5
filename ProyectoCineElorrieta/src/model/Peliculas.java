package model;

import javax.swing.JLabel;
import javax.swing.JPanel;
import controlador.GestionBD;
import modelobjeto.Cine;
import modelobjeto.Pelicula;
import view.VistaPrincipal;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Peliculas extends JPanel {
	private int contador;
	private GestionBD gestion;
	private ArrayList<Pelicula> pelis;

	public Peliculas(VistaPrincipal ventana) {
		gestion = new GestionBD();
		pelis = gestion.buscarPelis();
	

		/**
		 * Se le da una altura y una anchura al JPanel. Se hace que no se pueda
		 * redimensionar la VentanaPrincipal
		 */
		setSize(new Dimension(664, 452));
		setVisible(true);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBounds(31, 82, 623, 264);
		add(panel);
		panel.setLayout(null);
		
		JLabel fotopelicula = new JLabel("foto");
		fotopelicula.setBounds(10, 11, 146, 184);
		panel.add(fotopelicula);
		
		contador = 0;
		JLabel nombrepelicula = new JLabel(pelis.get(contador).getNombrepeli());
		nombrepelicula.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		nombrepelicula.setBounds(176, 11, 129, 27);
		panel.add(nombrepelicula);
		
		JLabel lblDuracion = new JLabel("Duración:" + pelis.get(contador).getDuracion());
		lblDuracion.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblDuracion.setBounds(176, 49, 129, 27);
		panel.add(lblDuracion);
		
		JLabel lblGenero = new JLabel("Genero:" + pelis.get(contador).getGenero());
		lblGenero.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblGenero.setBounds(176, 87, 129, 27);
		panel.add(lblGenero);
		
		JLabel lblPrecio = new JLabel("Precio:" + pelis.get(contador).getPrecio());
		lblPrecio.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblPrecio.setBounds(176, 125, 129, 27);
		panel.add(lblPrecio);
		
		
		JLabel lblFinestCines = new JLabel("FINEST CINES");
		lblFinestCines.setBounds(32, -135, 399, 178);
		panel.add(lblFinestCines);
		lblFinestCines.setFont(new Font("Ink Free", Font.BOLD, 39));
		
		JButton btnAtras = new JButton("<");
		btnAtras.setBounds(10, 206, 89, 23);
		panel.add(btnAtras);
		
		JButton btnAdelante = new JButton(">");
		btnAdelante.setBounds(99, 206, 89, 23);
		panel.add(btnAdelante);
		
		JButton btnPrimero = new JButton("Primera");
		btnPrimero.setBounds(10, 241, 89, 23);
		panel.add(btnPrimero);
		
		JButton btnUltimo = new JButton("Ultima");
		btnUltimo.setBounds(99, 240, 89, 23);
		panel.add(btnUltimo);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (contador - 1 > -1) {
						contador--;
						nombrepelicula.setText(pelis.get(contador).getNombrepeli());;
						lblDuracion.setText(pelis.get(contador).getDuracion() + "");
						lblGenero.setText(pelis.get(contador).getGenero());
						lblPrecio.setText(pelis.get(contador).getPrecio() + "");
						if (contador == 0) {
							btnPrimero.setEnabled(false);
							btnUltimo.setEnabled(true);
						} else {
							btnPrimero.setEnabled(true);
							btnUltimo.setEnabled(true);
						}
				}
			}
		});
	}
}