package model;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.VistaPrincipal;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class Registro extends JPanel {
	private JTextField textFieldDNI;
	private JTextField textFieldApellido;
	private JTextField textField;
	private JTextField textField_1;
	
	
	public Registro(VistaPrincipal ventana) {
		
		setSize(new Dimension(609, 582));
		setVisible(true);
		setLayout(null);
		
		JLabel lblFinestCines = new JLabel("FINEST CINES");
		lblFinestCines.setToolTipText("");
		lblFinestCines.setFont(new Font("Lucida Bright", Font.PLAIN, 25));
		lblFinestCines.setBounds(242, 89, 359, 90);
		add(lblFinestCines);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("multimedia/FondoLogin"));
		lblFondo.setBounds(-24, -24, 611, 558);
		add(lblFondo);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblDNI.setBounds(160, 174, 67, 36);
		add(lblDNI);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNombre.setBounds(160, 238, 67, 36);
		add(lblNombre);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(160, 207, 134, 20);
		add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(160, 272, 134, 20);
		add(textFieldApellido);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblApellido.setBounds(160, 303, 67, 36);
		add(lblApellido);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblGenero.setBounds(373, 174, 67, 36);
		add(lblGenero);
		
		JComboBox comboBoxGenero = new JComboBox();
		comboBoxGenero.setBounds(373, 206, 156, 21);
		add(comboBoxGenero);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(160, 336, 134, 20);
		add(textField);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblContraseña.setBounds(373, 238, 123, 36);
		add(lblContraseña);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(373, 272, 134, 20);
		add(textField_1);
		

	}
}
