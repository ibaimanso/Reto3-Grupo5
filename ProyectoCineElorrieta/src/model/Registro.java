package model;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import controlador.GestionBD;
import logica.GestionDeLaInformacion;
import modelobjeto.Cliente;
import view.VistaPrincipal;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Registro extends JPanel {
	private JTextField txtDni;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldContraseña;
	private GestionDeLaInformacion gestionINF = new GestionDeLaInformacion();

	
	
	public Registro(VistaPrincipal ventana) {
		
		setSize(new Dimension(609, 582));
		setVisible(true);
		setLayout(null);
		
		JLabel lblFinestCines = new JLabel("FINEST CINES");
		lblFinestCines.setToolTipText("");
		lblFinestCines.setFont(new Font("Lucida Bright", Font.PLAIN, 25));
		lblFinestCines.setBounds(170, 73, 359, 90);
		add(lblFinestCines);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblDNI.setBounds(52, 174, 67, 36);
		add(lblDNI);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNombre.setBounds(52, 238, 67, 36);
		add(lblNombre);
		
		txtDni = new JTextField();
		txtDni.setBounds(52, 206, 134, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(52, 273, 134, 20);
		add(textFieldNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblApellido.setBounds(52, 304, 67, 36);
		add(lblApellido);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblGenero.setBounds(284, 174, 67, 36);
		add(lblGenero);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(52, 340, 134, 20);
		add(textFieldApellido);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblContraseña.setBounds(282, 238, 123, 36);
		add(lblContraseña);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setColumns(10);
		textFieldContraseña.setBounds(284, 273, 156, 20);
		add(textFieldContraseña);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\in1dw3\\git\\Reto3-Grupo5\\ProyectoCineElorrieta\\multimedia\\FondoLogin.png"));
		lblNewLabel.setBounds(10, -25, 560, 556);
		add(lblNewLabel);		
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.setBounds(284, 339, 156, 23);
		add(btnNewButton);
		
		JRadioButton rdbHombre = new JRadioButton("H");
		rdbHombre.setBounds(284, 205, 109, 23);
		add(rdbHombre);
		
		JRadioButton rdbMujer = new JRadioButton("M");
		rdbMujer.setBounds(396, 205, 109, 23);
		add(rdbMujer);
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setDni(txtDni.getText()); 
				cliente.setNombrecli(textFieldNombre.getText());
				cliente.setContraseña(textFieldContraseña.getText());
				

				cliente.setContraseña(textFieldContraseña.getText());
				
				
				if(rdbHombre.isSelected()) {
					cliente.setSexo(rdbHombre.getText());
				}
				if(rdbMujer.isSelected()) {
					cliente.setSexo(rdbMujer.getText());
				}
				GestionBD gestionBd = new GestionBD();
				gestionBd.insertUsuario(cliente, ventana);
				//gestionINF.recogerInformacionFormulario(cliente , ventana);
			}});
	}
	}
