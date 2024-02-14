package model;

import javax.swing.JLabel;
import javax.swing.JPanel;
import controlador.GestionBD;
import logica.GestionDeLaInformacion;
import modelobjeto.Cliente;
import view.VistaPrincipal;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class Registro extends JPanel {
	private JTextField txtDni;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldContraseña;

	public Registro(VistaPrincipal ventana, GestionDeLaInformacion gestion) {

		setSize(new Dimension(609, 582));
		setVisible(true);
		setLayout(null);

		JLabel lblFinestCines = new JLabel("FINEST CINES");
		lblFinestCines.setToolTipText("");
		lblFinestCines.setFont(new Font("Lucida Bright", Font.PLAIN, 25));
		lblFinestCines.setBounds(170, 11, 186, 90);
		add(lblFinestCines);
		
		JButton btnVolver = new JButton("");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(1);
			}
		});
		btnVolver.setIcon(new ImageIcon("multimedia/flecha_volver (1).png"));
		btnVolver.setBounds(447, 58, 46, 43);
		add(btnVolver);

		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblDNI.setBounds(52, 112, 67, 36);
		add(lblDNI);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNombre.setBounds(52, 176, 67, 36);
		add(lblNombre);

		txtDni = new JTextField();
		txtDni.setBounds(52, 144, 134, 20);
		add(txtDni);
		txtDni.setColumns(10);

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(52, 211, 134, 20);
		add(textFieldNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblApellido.setBounds(52, 242, 67, 36);
		add(lblApellido);

		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblGenero.setBounds(284, 112, 67, 36);
		add(lblGenero);

		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(52, 278, 134, 20);
		add(textFieldApellido);

		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblContraseña.setBounds(282, 176, 123, 36);
		add(lblContraseña);

		textFieldContraseña = new JTextField();
		textFieldContraseña.setColumns(10);
		textFieldContraseña.setBounds(284, 211, 156, 20);
		add(textFieldContraseña);

	

		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setBounds(284, 277, 156, 23);
		add(btnRegistro);

		JRadioButton rdbHombre = new JRadioButton("H");
		rdbHombre.setBounds(284, 143, 33, 23);
		add(rdbHombre);

		JRadioButton rdbMujer = new JRadioButton("M");
		rdbMujer.setBounds(319, 143, 37, 23);
		add(rdbMujer);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("multimedia/FondoLogin.png"));
		lblNewLabel.setBounds(-22, -59, 644, 556);
		add(lblNewLabel);

		/*
		 * Función para que los textfields de el panel de registro se guarden en los
		 * atributos de el objeto cliente al hacer click en el boton de registro.
		 */

		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setDni(txtDni.getText());
				cliente.setNombrecli(textFieldNombre.getText());
				cliente.setApellido(textFieldApellido.getText());
				cliente.setContraseña(textFieldContraseña.getText());

				if (rdbHombre.isSelected()) {
					cliente.setSexo(rdbHombre.getText());
				}
				if (rdbMujer.isSelected()) {
					cliente.setSexo(rdbMujer.getText());
				}
				GestionBD gestionBd = new GestionBD();
				gestionBd.insertUsuario(cliente, ventana);
			}
		});
	
	}
	
}
