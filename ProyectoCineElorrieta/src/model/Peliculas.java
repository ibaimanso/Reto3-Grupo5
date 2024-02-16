package model;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import logica.GestionDeLaInformacion;
import modelobjeto.Pelicula;
import view.VistaPrincipal;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Peliculas extends JPanel {
	private static final long serialVersionUID = 1L;

	private int contador;
	private JButton btnUltimo;
	private JButton btnPrimero;
	private ArrayList<Pelicula> peliculas;
	private String cineElegido;

	/**
	 * Objeto utilizado para mostrar y elegir las peliculas en base al cine elegido
	 * 
	 * @param ventana Objeto ventana utilizado para cambiar de panel
	 * @param gestion Objeto utilizado para realizar funciones relacionadas con el
	 *                uso de la informacion
	 */
	public Peliculas(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		peliculas = gestion.devolverPeliculas();
		cineElegido = gestion.sacarCine();

		setSize(new Dimension(664, 452));
		setVisible(true);
		setLayout(null);

		// Inicio de la parte del carrito y nombre del cine
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
		lblNombreUsuario.setText(gestion.devolverNombreUsuario());
		lblNombreUsuario.setForeground(new Color(255, 255, 255));
		lblNombreUsuario.setBounds(495, 11, 145, 18);
		add(lblNombreUsuario);

		/**
		 * Contador que muestra la cantidad de entradas añadidas al carrito
		 */
		JLabel lblContadorCompra = new JLabel("0");
		lblContadorCompra.setForeground(new Color(255, 255, 255));
		lblContadorCompra.setHorizontalAlignment(SwingConstants.CENTER);
		lblContadorCompra.setBounds(561, 70, 37, 32);
		add(lblContadorCompra);

		JLabel lblCirculoRojo = new JLabel("");
		lblCirculoRojo.setIcon(new ImageIcon("multimedia/circulo_rojo (1) (1).png"));
		lblCirculoRojo.setBounds(561, 57, 43, 61);
		add(lblCirculoRojo);

		/**
		 * Boton para ir al resumen de la compra
		 */
		JButton btnCarrito = new JButton("");
		btnCarrito.setFocusPainted(false);
		btnCarrito.setBorderPainted(false);
		btnCarrito.setContentAreaFilled(false);
		btnCarrito.setBackground(new Color(0, 0, 0));
		btnCarrito.setIcon(new ImageIcon("multimedia/CarritoBlanco (1) (1).png"));
		btnCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(8);
			}
		});
		btnCarrito.setBounds(523, 29, 60, 60);
		add(btnCarrito);

		JLabel lblFondoParaCarrito = new JLabel("");
		lblFondoParaCarrito.setIcon(new ImageIcon("multimedia/rectangulo-negro-login.png"));
		lblFondoParaCarrito.setBounds(435, -286, 600, 397);
		add(lblFondoParaCarrito);

		/**
		 * Función que oculta o muestra el carrito en caso de tener una compra o no
		 */
		if (gestion.devolverLongitudDeEntradas() == 0 || gestion.devolverLongitudDeEntradas() == null) {
			lblFondoParaCarrito.setVisible(false);
			btnCarrito.setVisible(false);
			lblNombreUsuario.setVisible(false);
			lblCirculoRojo.setVisible(false);
			lblContadorCompra.setVisible(false);
		} else {
			lblFondoParaCarrito.setVisible(true);
			btnCarrito.setVisible(true);
			lblNombreUsuario.setVisible(true);
			lblNombreUsuario.setVisible(true);
			lblContadorCompra.setVisible(true);
			lblContadorCompra.setText("" + gestion.devolverLongitudDeEntradas());
		}
		// Fin de la parte del carrito y nombre del cine

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBounds(31, 93, 623, 264);
		add(panel);
		panel.setLayout(null);

		JLabel fotopelicula = new JLabel("");
		ImageIcon icon = new ImageIcon("multimedia/" + peliculas.get(contador).getNombrepeli() + ".jpg");
		fotopelicula.setIcon(icon);
		fotopelicula.setBounds(10, 11, 146, 184);
		panel.add(fotopelicula);

		contador = 0;
		JLabel nombrepelicula = new JLabel(peliculas.get(contador).getNombrepeli());
		nombrepelicula.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		nombrepelicula.setBounds(176, 11, 129, 27);
		panel.add(nombrepelicula);

		JLabel lblDuracion = new JLabel("Duración: " + peliculas.get(contador).getDuracion() + " minutos");
		lblDuracion.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblDuracion.setBounds(176, 49, 129, 27);
		panel.add(lblDuracion);

		JLabel lblGenero = new JLabel("Genero: " + peliculas.get(contador).getGenero());
		lblGenero.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblGenero.setBounds(176, 87, 129, 27);
		panel.add(lblGenero);

		JLabel lblPrecio = new JLabel("Precio: " + peliculas.get(contador).getPrecio() + "€");
		lblPrecio.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblPrecio.setBounds(176, 125, 129, 27);
		panel.add(lblPrecio);

		/**
		 * Boton que tiene como funcion ir a la ultima pelicula del arraylist de
		 * peliculas y desactivar el mismo boton
		 */
		btnUltimo = new JButton("Ultima");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador = peliculas.size() - 1;
				nombrepelicula.setText((peliculas.get(contador).getNombrepeli()));
				lblDuracion.setText(("Duracion: " + peliculas.get(contador).getDuracion() + " minutos"));
				lblGenero.setText("Genero: " + peliculas.get(contador).getGenero());
				lblPrecio.setText("Precio: " + peliculas.get(contador).getPrecio() + "€");
				ImageIcon icon = new ImageIcon("multimedia/" + peliculas.get(contador).getNombrepeli() + ".jpg");
				fotopelicula.setIcon(icon);
				btnPrimero.setEnabled(true);
				btnUltimo.setEnabled(false);
			}
		});
		btnUltimo.setBounds(99, 241, 89, 23);
		panel.add(btnUltimo);

		/**
		 * Boton que tiene como funcion ir a la primera pelicula del arraylist de
		 * peliculas y desactivar el mismo boton
		 */
		btnPrimero = new JButton("Primera");
		btnPrimero.setBounds(10, 241, 89, 23);
		btnPrimero.setEnabled(false);
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador = 0;
				nombrepelicula.setText((peliculas.get(contador).getNombrepeli()));
				lblDuracion.setText(("Duracion: " + peliculas.get(contador).getDuracion() + " minutos"));
				lblGenero.setText("Genero: " + peliculas.get(contador).getGenero());
				lblPrecio.setText("Precio: " + peliculas.get(contador).getPrecio() + "€");
				ImageIcon icon = new ImageIcon("multimedia/" + peliculas.get(contador).getNombrepeli() + ".jpg");
				fotopelicula.setIcon(icon);
				btnPrimero.setEnabled(false);
				btnUltimo.setEnabled(true);
			}
		});
		panel.add(btnPrimero);

		/**
		 * Boton cuya funcion es mostrar la pelicula anterior del arraylist
		 */
		JButton btnAtras = new JButton("<");
		btnAtras.setBounds(10, 206, 89, 23);
		panel.add(btnAtras);

		/**
		 * Boton cuya funcion es mostrar la pelicula siguiente del arraylist
		 */
		JButton btnAdelante = new JButton(">");
		btnAdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador < peliculas.size() - 1) {
					contador++;
					nombrepelicula.setText((peliculas.get(contador).getNombrepeli()));
					lblDuracion.setText(("Duracion: " + peliculas.get(contador).getDuracion() + " minutos"));
					lblGenero.setText("Genero: " + peliculas.get(contador).getGenero());
					lblPrecio.setText("Precio: " + peliculas.get(contador).getPrecio() + "€");
					ImageIcon icon = new ImageIcon("multimedia/" + peliculas.get(contador).getNombrepeli() + ".jpg");
					fotopelicula.setIcon(icon);

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
		btnAdelante.setBounds(99, 206, 89, 23);
		panel.add(btnAdelante);

		/**
		 * Boton cuya función es elegir la pelicula y cambiar de panel
		 */
		JButton btnComprar = new JButton("Sesiones");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestion.elegirPelicula(peliculas.get(contador));
				ventana.cambiarDePanel(5);
			}
		});
		btnComprar.setBounds(409, 206, 116, 23);
		panel.add(btnComprar);

		/**
		 * Boton cuya función es ir al panel anterior
		 */
		JButton btnVolver = new JButton("");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(3);
			}
		});
		btnVolver.setIcon(new ImageIcon("multimedia/flecha_volver (1).png"));
		btnVolver.setBounds(479, 11, 46, 43);
		panel.add(btnVolver);

		JLabel lblNombreEmpresa = new JLabel("FINEST CINES");
		lblNombreEmpresa.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 34));
		lblNombreEmpresa.setBounds(31, 11, 431, 46);
		add(lblNombreEmpresa);

		JLabel lblCineElegido = new JLabel(cineElegido);
		lblCineElegido.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 11));
		lblCineElegido.setBounds(31, 68, 95, 14);
		add(lblCineElegido);

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador - 1 > -1) {
					contador--;
					nombrepelicula.setText(peliculas.get(contador).getNombrepeli());
					;
					lblDuracion.setText(("Duracion: " + peliculas.get(contador).getDuracion() + " minutos"));
					lblGenero.setText("Genero: " + peliculas.get(contador).getGenero());
					lblPrecio.setText("Precio: " + peliculas.get(contador).getPrecio() + "€");
					ImageIcon icon = new ImageIcon("multimedia/" + peliculas.get(contador).getNombrepeli() + ".jpg");
					fotopelicula.setIcon(icon);
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