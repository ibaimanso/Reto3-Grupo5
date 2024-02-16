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
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JList;

/**
 * En esta clase nos vamos a encontrar con el panel que nos mostrara el resumen
 * de las peliculas compradas
 */
public class carritoDeLaCompra extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Compra compra;
	private ArrayList<LineaDeFactura> factura;

	public carritoDeLaCompra(VistaPrincipal ventana, GestionDeLaInformacion gestion) {

		factura = gestion.devolverfactura();
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

		/**
		 * Se crea el boton de Compra que llamara al metodo para imprimir el ticket y
		 * nos llevara al panel de despedida.
		 */
		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestion.insertarCompraEnBaseDeDatos();
				try {
					gestion.escribirFactura();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				ventana.cambiarDePanel(9);

			}
		});
		btnComprar.setBounds(479, 318, 89, 29);
		add(btnComprar);

		/**
		 * Se crea la lista donde apareceran todas la entradas compradas junto con la
		 * informacion de estas. Incluyendo el nombre del cine, la sala en la que se
		 * retransmitira la pelicula, el id de la sala y la fecha en la que se
		 * retransmitira.
		 */

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

		/**
		 * Se crea el label donde aparecera el precio total de las entradas compradas
		 * junto a su descuento, en caso de que lo tenga. Llama al metodo que hace el
		 * calculo de el precio en gestion de la informacion
		 */
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
