package model;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logica.GestionDeLaInformacion;
import modelobjeto.Pelicula;
import modelobjeto.Sesion;
import view.VistaPrincipal;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class CompraDeEntradas extends JPanel {
	private static final long serialVersionUID = 1L;

	private Pelicula peliculaElegida;
	private Sesion sesion;
	private String cineElegido;
	private int contador = 0;

	public CompraDeEntradas(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		peliculaElegida = gestion.devolverPelicula();
		sesion = gestion.devolverSesionPorDiaYHora();
		cineElegido = gestion.sacarCine();
		// setSize(ventana.getSize());
		setSize(620, 420);
		setVisible(true);
		setLayout(null);

		// Inicio de la parte del carrito y nombre del cine
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
		lblNombreUsuario.setText(gestion.devolverNombreUsuario());
		lblNombreUsuario.setForeground(new Color(255, 255, 255));
		lblNombreUsuario.setBounds(495, 11, 145, 18);
		add(lblNombreUsuario);

		JLabel lblContadorCompra = new JLabel("0");
		lblContadorCompra.setForeground(new Color(255, 255, 255));
		lblContadorCompra.setHorizontalAlignment(SwingConstants.CENTER);
		lblContadorCompra.setBounds(561, 70, 37, 32);
		add(lblContadorCompra);

		JLabel lblCirculoRojo = new JLabel("");
		lblCirculoRojo.setIcon(new ImageIcon("multimedia/circulo_rojo (1) (1).png"));
		lblCirculoRojo.setBounds(561, 57, 43, 61);
		add(lblCirculoRojo);

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
		/*
		 * panel con las fotos de la pelicula,nombre,duracion,genero y precio
		 */
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBounds(31, 93, 623, 264);
		add(panel);
		panel.setLayout(null);

		JLabel fotopelicula = new JLabel("");
		ImageIcon icon = new ImageIcon("multimedia/" + peliculaElegida.getNombrepeli() + ".jpg");
		fotopelicula.setIcon(icon);
		fotopelicula.setBounds(10, 11, 146, 184);
		panel.add(fotopelicula);

		JLabel nombrepelicula = new JLabel(peliculaElegida.getNombrepeli());
		nombrepelicula.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		nombrepelicula.setBounds(176, 11, 129, 27);
		panel.add(nombrepelicula);

		JLabel lblDuracion = new JLabel("Duración: " + peliculaElegida.getDuracion() + " minutos");
		lblDuracion.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblDuracion.setBounds(176, 49, 129, 27);
		panel.add(lblDuracion);

		JLabel lblGenero = new JLabel("Genero: " + peliculaElegida.getGenero());
		lblGenero.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblGenero.setBounds(176, 87, 129, 27);
		panel.add(lblGenero);

		JLabel lblPrecio = new JLabel("Precio: " + peliculaElegida.getPrecio() + "€");
		lblPrecio.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblPrecio.setBounds(176, 125, 129, 27);
		panel.add(lblPrecio);

		JButton btnVolver = new JButton("");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(4);
			}
		});
		btnVolver.setIcon(new ImageIcon("multimedia/flecha_volver (1).png"));
		btnVolver.setBounds(479, 11, 46, 43);
		panel.add(btnVolver);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestion.añadirEntradas(contador, sesion);
				ventana.cambiarDePanel(3);
			}
		});
		btnAceptar.setBounds(358, 219, 134, 23);
		panel.add(btnAceptar);

		JLabel lblSala = new JLabel("Sala: " + sesion.getId_sala());
		lblSala.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblSala.setBounds(344, 49, 129, 27);
		panel.add(lblSala);

		JLabel lblHora = new JLabel("Hora:  " + sesion.getHora());
		lblHora.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblHora.setBounds(344, 125, 129, 27);
		panel.add(lblHora);

		JLabel lblDia = new JLabel("Dia: " + sesion.getDia());
		lblDia.setFont(new Font("Nirmala UI", Font.BOLD, 12));
		lblDia.setBounds(344, 87, 129, 27);
		panel.add(lblDia);

		JLabel nombrepelicula_1 = new JLabel((String) null);
		nombrepelicula_1.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		nombrepelicula_1.setBounds(340, 11, 129, 27);
		panel.add(nombrepelicula_1);

		JLabel lblContadorEntrada = new JLabel("" + contador);
		lblContadorEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		lblContadorEntrada.setBounds(402, 163, 46, 32);
		panel.add(lblContadorEntrada);

		JButton btnRestar = new JButton("<");
		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador == 0) {
					JOptionPane.showMessageDialog(null, "No puedes bajar de cero");
				} else {
					contador--;
				}
				lblContadorEntrada.setText("" + contador);
			}
		});
		btnRestar.setBounds(354, 163, 43, 32);
		panel.add(btnRestar);

		JButton btnSumar = new JButton(">");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador == 30) {
					JOptionPane.showMessageDialog(null, "No puedes subir de 30");
				} else {
					contador++;
				}
				lblContadorEntrada.setText("" + contador);
			}
		});
		btnSumar.setBounds(458, 163, 43, 32);
		panel.add(btnSumar);

		
		JLabel lblNEntradas = new JLabel("Nº Entradas");
		lblNEntradas.setFont(new Font("Nirmala UI", Font.BOLD, 16));
		lblNEntradas.setBounds(247, 163, 129, 27);
		panel.add(lblNEntradas);
		
		JLabel lblNombreEmpresa = new JLabel("FINEST CINES");
		lblNombreEmpresa.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 34));
		lblNombreEmpresa.setBounds(31, 11, 431, 46);
		add(lblNombreEmpresa);

		JLabel lblCineElegido = new JLabel(cineElegido);
		lblCineElegido.setFont(new Font("Lucida Sans", Font.BOLD | Font.ITALIC, 11));
		lblCineElegido.setBounds(31, 68, 95, 14);
		add(lblCineElegido);

	}
}
