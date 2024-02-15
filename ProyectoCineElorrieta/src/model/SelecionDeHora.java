package model;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logica.GestionDeLaInformacion;
import modelobjeto.Pelicula;
import modelobjeto.Sesion;
import view.VistaPrincipal;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * En esta clase encontraremos la seleccion de hora al elegir la sesion que
 * queremos de la pelicula que vayamos a comprar.
 */
public class SelecionDeHora extends JPanel {
	private Pelicula peliculaElegida;
	private ArrayList<Sesion> sesiones;

	public SelecionDeHora(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		peliculaElegida = gestion.devolverPelicula();
		sesiones = gestion.devolverSesionesPorDia();
		setSize(620, 420);
		setVisible(true);
		setLayout(null);

		// Inicio de la parte del carrito y nombre del cine

		JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
		lblNombreUsuario.setText(gestion.devolverNombreUsuario());
		lblNombreUsuario.setForeground(new Color(255, 255, 255));
		lblNombreUsuario.setBounds(495, 11, 145, 18);
		add(lblNombreUsuario);

		JButton btnCarrito = new JButton("");
		btnCarrito.setFocusPainted(false);
		btnCarrito.setBorderPainted(false);
		btnCarrito.setBackground(new Color(0, 0, 0));
		btnCarrito.setIcon(new ImageIcon("multimedia/CarritoBlanco (1) (1).png"));
		btnCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCarrito.setBounds(523, 29, 60, 60);
		add(btnCarrito);

		JLabel lblFondoParaCarrito = new JLabel("");
		lblFondoParaCarrito.setIcon(new ImageIcon("multimedia/rectangulo-negro-login.png"));
		lblFondoParaCarrito.setBounds(435, -286, 600, 397);
		add(lblFondoParaCarrito);

		if (gestion.devolverLongitudDeEntradas() == 0 || gestion.devolverLongitudDeEntradas() == null) {
			lblFondoParaCarrito.setVisible(false);
			btnCarrito.setVisible(false);
			lblNombreUsuario.setVisible(false);
		} else {
			lblFondoParaCarrito.setVisible(true);
			btnCarrito.setVisible(true);
			lblNombreUsuario.setVisible(true);
		}
		// Fin de la parte del carrito y nombre del cine

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBounds(31, 82, 623, 264);
		add(panel);
		panel.setLayout(null);

		/**
		 * Se muestra la imagen de la pelicula que queramos comprar mediante el nombre
		 * de la pelicula se muestra la portada de esta, ya que en la carpeta del
		 * proyecto las imagenes de las peliculas tienen el mismo nombre que las
		 * peliculas en la base de datos
		 */

		JLabel fotopelicula = new JLabel("");
		ImageIcon icon = new ImageIcon("multimedia/" + peliculaElegida.getNombrepeli() + ".jpg");
		fotopelicula.setIcon(icon);
		fotopelicula.setBounds(10, 11, 146, 184);
		panel.add(fotopelicula);

		/**
		 * Label para mostrar el nombre de la pelicula elegida
		 */
		JLabel nombrepelicula = new JLabel(peliculaElegida.getNombrepeli());
		nombrepelicula.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		nombrepelicula.setBounds(176, 11, 129, 27);
		panel.add(nombrepelicula);

		/**
		 * Label para mostrar la duracion de la pelicula elegida
		 */
		JLabel lblDuracion = new JLabel("Duración: " + peliculaElegida.getDuracion() + " minutos");
		lblDuracion.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblDuracion.setBounds(176, 49, 129, 27);
		panel.add(lblDuracion);
		/**
		 * Label para mostrar el genero de la pelicula elegida
		 */
		JLabel lblGenero = new JLabel("Genero: " + peliculaElegida.getGenero());
		lblGenero.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblGenero.setBounds(176, 87, 129, 27);
		panel.add(lblGenero);

		/**
		 * Label para mostrar el precio de la pelicula elegida
		 */
		JLabel lblPrecio = new JLabel("Precio: " + peliculaElegida.getPrecio() + "€");
		lblPrecio.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblPrecio.setBounds(176, 125, 129, 27);
		panel.add(lblPrecio);

		/**
		 * Combo box donde se mostrara las horas en las que se retransmite la pelicula
		 */
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(358, 70, 134, 22);
		panel.add(comboBox);
		for (int i = 0; i < sesiones.size(); i++) {
			comboBox.addItem(sesiones.get(i).getHora());
		}

		JButton btnVolver = new JButton("");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(3);
			}
		});
		btnVolver.setIcon(new ImageIcon("multimedia/flecha_volver (1).png"));
		btnVolver.setBounds(479, 11, 46, 43);
		panel.add(btnVolver);

		/**
		 * Se crea el boton de aceptar para que cuando eligamos la hora se mande al
		 * carrito de la compra y nos lleva de vuelta a la pantalla de seleccion de
		 * cines
		 */
		JButton btnElegirFecha = new JButton("Aceptar");
		btnElegirFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestion.elegirHora((String) comboBox.getSelectedItem());
				ventana.cambiarDePanel(7);
			}
		});
		btnElegirFecha.setBounds(358, 148, 134, 23);
		panel.add(btnElegirFecha);

	}
}
