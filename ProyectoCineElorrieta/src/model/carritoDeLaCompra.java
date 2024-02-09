package model;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import logica.GestionDeLaInformacion;
import modelobjeto.Compra;
import modelobjeto.LineaDeFactura;
import view.VistaPrincipal;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JList;

public class carritoDeLaCompra extends JPanel {

	private Compra compra;
	private ArrayList<LineaDeFactura> factura;

	public carritoDeLaCompra(VistaPrincipal ventana, GestionDeLaInformacion gestion) {

		factura = gestion.devolverfactura();
		compra = gestion.calcularCompra();
		int longitud = factura.size();
		setLayout(null);
		setSize(620, 420);
		setVisible(true);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(20, 89, 548, 223);
		add(panel);
		panel.setLayout(null);

		JList<String> list = new JList<String>();
		list.setFont(new Font("Georgia", Font.BOLD, 12));
		JScrollPane scrollPelicula = new JScrollPane(list);
		scrollPelicula.setSize(548, 223);
		scrollPelicula.setLocation(0, 0);
		panel.add(scrollPelicula);

		DefaultListModel<String> modelo = new DefaultListModel<String>();

		for (int i = 0; i < factura.size(); i++) {
			String linea = factura.get(i).getNombrePelicula() + " ---> " + factura.get(i).getNombreCine() + " // Sala: "
					+ factura.get(i).getNombreSala() + " Fecha: " + factura.get(i).getDia() + " // "
					+ factura.get(i).getHora();
			modelo.addElement(linea);
		}

		list.setModel(modelo);

//		JLabel lblCompra1 = new JLabel("");
//		lblCompra1.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
//		if (longitud >= 1)
//			lblCompra1.setText(factura.get(0).getNombrePelicula() + " ---> " + factura.get(0).getNombreCine() + " // Sala: " + factura.get(0).getNombreSala() +" Fecha: " + factura.get(0).getDia() + " // " +  factura.get(0).getHora());
//
//		lblCompra1.setBounds(10, 11, 528, 14);
//		panel.add(lblCompra1);
//		
//		JLabel lblCompra2 = new JLabel("");
//		if (longitud >= 2) 
//			lblCompra2.setText(factura.get(1).getNombrePelicula() + " ---> " + factura.get(1).getNombreCine() + " // Sala: " + factura.get(1).getNombreSala() +" Fecha: " + factura.get(1).getDia() + " // " +  factura.get(1).getHora()) ;
//		lblCompra2.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
//		lblCompra2.setBounds(10, 34, 528, 14);
//		panel.add(lblCompra2);
//		
//		
//		JLabel lblCompra3 = new JLabel("");
//		if (longitud >= 3) 
//		lblCompra3.setText(factura.get(2).getNombrePelicula() + " ---> " + factura.get(2).getNombreCine() + " // Sala: " + factura.get(2).getNombreSala() +" Fecha: " + factura.get(2).getDia() + " // " +  factura.get(2).getHora());
//		lblCompra3.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
//		lblCompra3.setBounds(10, 59, 528, 14);
//		panel.add(lblCompra3);
//		
//		JLabel lblCompra4 = new JLabel("");
//		if (longitud >= 4) 
//			lblCompra4.setText(factura.get(3).getNombrePelicula() + " ---> " + factura.get(3).getNombreCine() + " // Sala: " + factura.get(3).getNombreSala() +" Fecha: " + factura.get(3).getDia() + " // " +  factura.get(3).getHora());
//		lblCompra4.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
//		lblCompra4.setBounds(10, 86, 528, 14);
//		panel.add(lblCompra4);
//		
//		JLabel lblCompra5 = new JLabel("");
//		if (longitud >= 5) 
//			lblCompra5.setText(factura.get(4).getNombrePelicula() + " ---> " + factura.get(4).getNombreCine() + " // Sala: " + factura.get(4).getNombreSala() +" Fecha: " + factura.get(4).getDia() + " // " +  factura.get(4).getHora());
//		lblCompra5.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
//		lblCompra5.setBounds(10, 111, 528, 14);
//		panel.add(lblCompra5);
//		
//		JLabel lblCompra6 = new JLabel("");
//		if (longitud >= 6) 
//			lblCompra6.setText(factura.get(5).getNombrePelicula() + " ---> " + factura.get(5).getNombreCine() + " // Sala: " + factura.get(5).getNombreSala() +" Fecha: " + factura.get(5).getDia() + " // " +  factura.get(5).getHora());
//		lblCompra6.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
//		lblCompra6.setBounds(10, 136, 528, 14);
//		panel.add(lblCompra6);
//		
//		JLabel lblCompra7 = new JLabel("");
//		if (longitud >= 7) 
//			lblCompra7.setText(factura.get(6).getNombrePelicula() + " ---> " + factura.get(6).getNombreCine() + " // Sala: " + factura.get(6).getNombreSala() +" Fecha: " + factura.get(6).getDia() + " // " +  factura.get(6).getHora());
//		lblCompra7.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
//		lblCompra7.setBounds(10, 161, 528, 14);
//		panel.add(lblCompra7);
//		
//		JLabel lblCompra8 = new JLabel("");
//		if (longitud == 8) 
//			lblCompra8.setText(factura.get(7).getNombrePelicula() + " ---> " + factura.get(7).getNombreCine() + " // Sala: " + factura.get(7).getNombreSala() +" Fecha: " + factura.get(7).getDia() + " // " +  factura.get(7).getHora());
//		lblCompra8.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
//		lblCompra8.setBounds(10, 186, 528, 14);
//		panel.add(lblCompra8);

		JLabel lblCarritoDeLaCompra = new JLabel("Carrito De La Compra");
		lblCarritoDeLaCompra.setForeground(new Color(255, 255, 255));
		lblCarritoDeLaCompra.setFont(new Font("Centaur", Font.BOLD, 30));
		lblCarritoDeLaCompra.setBounds(27, 11, 342, 39);
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

		JLabel lblTotal = new JLabel(
				"TOTAL: " + compra.getPrecioTotal() + "€" + "|| Descuento= " + compra.getPrecioDescontado() + "€");
		lblTotal.setFont(new Font("Sitka Small", Font.BOLD, 14));
		lblTotal.setBounds(0, 0, 548, 28);
		panel_1.add(lblTotal);

		JButton btnVolver = new JButton("");
		btnVolver.setBounds(522, 39, 46, 43);
		add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(3);
			}
		});
		btnVolver.setIcon(new ImageIcon("multimedia/flecha_volver (1).png"));

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("multimedia/fondopiedra.jpg"));
		lblFondo.setBounds(0, 0, 620, 420);
		add(lblFondo);

		JLabel separador1 = new JLabel("New label");
		separador1.setBounds(560, 89, 8, 223);
		add(separador1);
		separador1.setIcon(new ImageIcon("C:\\Users\\in1dm3-v\\Downloads\\Color_negro.png"));

	}
}
