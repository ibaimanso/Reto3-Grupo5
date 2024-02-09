package model;

import javax.swing.JPanel;

import logica.GestionDeLaInformacion;
import modelobjeto.Compra;
import view.VistaPrincipal;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class carritoDeLaCompra extends JPanel{
	
	private Compra compra;
	
	public carritoDeLaCompra(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		
		compra = gestion.calcularCompra();
		setLayout(null);
		setSize(620, 420);
		setVisible(true);
		setLayout(null);
		

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(20, 89, 548, 223);
		add(panel);
		panel.setLayout(null);
		
	
		JLabel lblCompra1 = new JLabel("New label");
		lblCompra1.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblCompra1.setBounds(10, 11, 230, 14);
		panel.add(lblCompra1);
		
		JLabel separador1 = new JLabel("New label");
		separador1.setIcon(new ImageIcon("C:\\Users\\in1dm3-v\\Downloads\\Color_negro.png"));
		separador1.setBounds(250, 0, 8, 223);
		panel.add(separador1);
		
		JLabel lblCompra2 = new JLabel("info");
		lblCompra2.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblCompra2.setBounds(10, 34, 230, 14);
		panel.add(lblCompra2);
		
		JLabel lblCompra3 = new JLabel("PELI2");
		lblCompra3.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblCompra3.setBounds(10, 59, 230, 14);
		panel.add(lblCompra3);
		
		JLabel lblCompra4 = new JLabel("");
		lblCompra4.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblCompra4.setBounds(10, 86, 230, 14);
		panel.add(lblCompra4);
		
		JLabel lblCompra5 = new JLabel("peli3");
		lblCompra5.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblCompra5.setBounds(10, 111, 230, 14);
		panel.add(lblCompra5);
		
		JLabel lblCompra6 = new JLabel("");
		lblCompra6.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblCompra6.setBounds(10, 136, 230, 14);
		panel.add(lblCompra6);
		
		JLabel lblCompra7 = new JLabel("peli4");
		lblCompra7.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblCompra7.setBounds(10, 161, 230, 14);
		panel.add(lblCompra7);
		
		JLabel lblCompra8 = new JLabel("");
		lblCompra8.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblCompra8.setBounds(10, 186, 230, 14);
		panel.add(lblCompra8);
		
		JLabel lblCompra17 = new JLabel("New label");
		lblCompra17.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblCompra17.setBounds(268, 11, 270, 14);
		panel.add(lblCompra17);
		
		JLabel lblCompra18 = new JLabel("");
		lblCompra18.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblCompra18.setBounds(268, 33, 270, 14);
		panel.add(lblCompra18);
		
		JLabel lblCompra19 = new JLabel("peli6");
		lblCompra19.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblCompra19.setBounds(268, 58, 270, 14);
		panel.add(lblCompra19);
		
		JLabel lblCompra20 = new JLabel("");
		lblCompra20.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblCompra20.setBounds(268, 85, 270, 14);
		panel.add(lblCompra20);
		
		JLabel lblCompra21 = new JLabel("peli7");
		lblCompra21.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblCompra21.setBounds(268, 110, 270, 14);
		panel.add(lblCompra21);
		
		JLabel lblCompra22 = new JLabel("");
		lblCompra22.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblCompra22.setBounds(268, 135, 270, 14);
		panel.add(lblCompra22);
		
		JLabel lblCompra23 = new JLabel("peli8");
		lblCompra23.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblCompra23.setBounds(268, 160, 270, 14);
		panel.add(lblCompra23);
		
		JLabel lblCompra24 = new JLabel("");
		lblCompra24.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblCompra24.setBounds(268, 185, 270, 14);
		panel.add(lblCompra24);
		
		JLabel lblCarritoDeLaCompra = new JLabel("Carrito De La Compra");
		lblCarritoDeLaCompra.setForeground(new Color(255, 255, 255));
		lblCarritoDeLaCompra.setFont(new Font("Centaur", Font.BOLD, 30));
		lblCarritoDeLaCompra.setBounds(31, 0, 342, 39);
		add(lblCarritoDeLaCompra);
		
		JLabel lblUsuario = new JLabel("");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setText(gestion.devolverNombreUsuario());
		lblUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		lblUsuario.setBounds(31, 50, 246, 28);
		add(lblUsuario);
		
		

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(20, 319, 548, 28);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTotal = new JLabel("TOTAL: " + compra.getPrecioTotal() + "€" + "|| Descuento= " + compra.getPrecioDescontado() + "€");
		lblTotal.setFont(new Font("Sitka Small", Font.BOLD, 14));
		lblTotal.setBounds(0, 0, 548, 28);
		panel_1.add(lblTotal);
		

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("multimedia/fondopiedra.jpg"));
		lblFondo.setBounds(0, 0, 620, 420);
		add(lblFondo);
		
	}
}
