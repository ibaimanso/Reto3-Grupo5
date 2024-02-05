package model;

import javax.swing.JPanel;

import view.VistaPrincipal;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import controlador.GestionBD;
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
	private GestionBD gestion;
	private ArrayList<Cine> cines;

	public Cines(VistaPrincipal ventana) {
		gestion = new GestionBD();
		cines = gestion.buscarCines();

		// setSize(ventana.getSize());
		setSize(620, 420);
		setVisible(true);
		setLayout(null);

		JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
		lblNombreUsuario.setForeground(new Color(255, 255, 255));
		lblNombreUsuario.setBounds(10, 11, 145, 18);
		add(lblNombreUsuario);

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

		JButton btnCarrito = new JButton("");
		btnCarrito.setFocusPainted(false);
		btnCarrito.setBorderPainted(false);
		// btnCarrito.setContentAreaFilled(false);
		btnCarrito.setBackground(new Color(0, 0, 0));
		btnCarrito.setIcon(new ImageIcon("multimedia/CarritoBlanco (1) (1).png"));
		btnCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCarrito.setBounds(10, 29, 60, 60);
		add(btnCarrito);

		JLabel lblFondoParaCarrito = new JLabel("");
		lblFondoParaCarrito.setIcon(new ImageIcon("multimedia/rectangulo-negro-login.png"));
		lblFondoParaCarrito.setBounds(-373, -279, 600, 397);
		add(lblFondoParaCarrito);

		JButton btnNewButton = new JButton("¿Volver al login?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO devolver variables a su valor original y volver a login
			}
		});
		btnNewButton.setBounds(407, 342, 170, 23);
		add(btnNewButton);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				comboBox.getSelectedItem();
				
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