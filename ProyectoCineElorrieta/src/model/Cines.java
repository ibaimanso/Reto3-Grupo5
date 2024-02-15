package model;

import javax.swing.JPanel;

import view.VistaPrincipal;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import logica.GestionDeLaInformacion;
import modelobjeto.Cine;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Cines extends JPanel {
	private ArrayList<Cine> cines;
	private Integer contador;

	public Cines(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		cines = gestion.devolverCines();
		contador = gestion.devolverLongitudDeEntradas();

		// setSize(ventana.getSize());
		setSize(620, 420);
		setVisible(true);
		setLayout(null);

		// Inicio de la parte del carrito y nombre del cine
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
		lblNombreUsuario.setText(gestion.devolverNombreUsuario());
		lblNombreUsuario.setForeground(new Color(255, 255, 255));
		lblNombreUsuario.setBounds(10, 11, 145, 18);
		add(lblNombreUsuario);

		JLabel lblContadorCompra = new JLabel("0");
		lblContadorCompra.setForeground(new Color(255, 255, 255));
		lblContadorCompra.setHorizontalAlignment(SwingConstants.CENTER);
		lblContadorCompra.setBounds(37, 70, 37, 32);
		add(lblContadorCompra);

		JLabel lblCirculoRojo = new JLabel("");
		lblCirculoRojo.setIcon(new ImageIcon("multimedia/circulo_rojo (1) (1).png"));
		lblCirculoRojo.setBounds(37, 57, 43, 61);
		add(lblCirculoRojo);

		JButton btnCarrito = new JButton("");
		btnCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(8);
			}
		});
		btnCarrito.setFocusPainted(false);
		btnCarrito.setBorderPainted(false);
		btnCarrito.setContentAreaFilled(false);
		//
		btnCarrito.setBackground(new Color(0, 0, 0));
		btnCarrito.setIcon(new ImageIcon("multimedia/CarritoBlanco (1) (1).png"));

		btnCarrito.setBounds(10, 29, 60, 60);
		add(btnCarrito);

		JLabel lblFondoParaCarrito = new JLabel("");
		lblFondoParaCarrito.setIcon(new ImageIcon("multimedia/rectangulo-negro-login.png"));
		lblFondoParaCarrito.setBounds(-373, -279, 600, 397);
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

		JLabel lblBienvenida = new JLabel("SELECIONE EL CINE");
		lblBienvenida.setForeground(new Color(255, 255, 255));
		lblBienvenida.setFont(new Font("High Tower Text", Font.BOLD, 35));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setBounds(37, 74, 540, 89);
		add(lblBienvenida);

		JComboBox<String> comboBox = new JComboBox<String>();
		for (int i = 0; i < cines.size(); i++) {
			comboBox.addItem(cines.get(i).getNombrecine());
		}
		comboBox.setBounds(207, 174, 207, 22);
		add(comboBox);

		JButton btnNewButton = new JButton("¿Volver al login?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO devolver variables a valor original
				ventana.cambiarDePanel(1);
			}
		});
		btnNewButton.setBounds(407, 342, 170, 23);
		add(btnNewButton);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestion.elegirCine((String) comboBox.getSelectedItem());
				ventana.cambiarDePanel(4);
			}
		});
		btnAceptar.setBounds(207, 238, 207, 23);
		add(btnAceptar);

		JLabel lblFoto = new JLabel("");
		lblFoto.setBounds(0, 0, 620, 420);
		lblFoto.setIcon(new ImageIcon("multimedia/fondo-cines.jpg"));
		add(lblFoto);

	}
}