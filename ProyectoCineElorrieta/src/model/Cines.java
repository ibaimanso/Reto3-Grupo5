package model;

import javax.swing.JPanel;

import view.VistaPrincipal;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controlador.GestionBD;
import modelobjeto.Cine;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Cines extends JPanel {
	private GestionBD gestion;
	private ArrayList<Cine> cines;

	public Cines(VistaPrincipal ventana) {
		gestion = new GestionBD();
		cines = gestion.buscarCines();

		// setSize(ventana.getSize());
		setSize(620, 420);
		setVisible(true);
		setLayout(null);

		JLabel lblFoto = new JLabel("");
		lblFoto.setBounds(0, 0, 620, 420);
		add(lblFoto);

		JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
		lblNombreUsuario.setBounds(432, 28, 145, 18);
		add(lblNombreUsuario);

		JLabel lblBienvenida = new JLabel("SELECIONE EL CINE");
		lblBienvenida.setFont(new Font("High Tower Text", Font.BOLD, 31));
		lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenida.setBounds(37, 83, 540, 89);
		add(lblBienvenida);

		JComboBox<String> comboBox = new JComboBox<String>();
		for (int i = 0; i < cines.size(); i++) {
			comboBox.addItem(cines.get(i).getNombrecine());
		}
		comboBox.setBounds(201, 230, 207, 22);
		add(comboBox);

		JLabel lblFondoParaCarrito = new JLabel("");
		lblFondoParaCarrito.setBounds(10, 11, 80, 56);
		add(lblFondoParaCarrito);

		JButton btnCarrito = new JButton("Carrito");
		btnCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCarrito.setBounds(10, 28, 89, 23);
		add(btnCarrito);

		JButton btnNewButton = new JButton("¿Volver al login?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO devolver variables a su valor original y volver a login
			}
		});
		btnNewButton.setBounds(456, 363, 121, 23);
		add(btnNewButton);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO sacarPelicula
				comboBox.getSelectedItem();
			}
		});
		btnAceptar.setBounds(260, 313, 89, 23);
		add(btnAceptar);

	}
}