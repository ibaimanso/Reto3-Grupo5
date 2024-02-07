package model;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logica.GestionDeLaInformacion;
import modelobjeto.Pelicula;
import modelobjeto.Sesion;
import view.VistaPrincipal;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelecionDeHora extends JPanel {
	private Pelicula peliculaElegida;
	private ArrayList<Sesion> sesiones;

	public SelecionDeHora(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		peliculaElegida = gestion.devolverPelicula();
		sesiones = gestion.devolverSesionesPorDia();
		// setSize(ventana.getSize());
		setSize(620, 420);
		setVisible(true);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBounds(31, 82, 623, 264);
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

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(358, 70, 134, 22);
		panel.add(comboBox);
		for (int i = 0; i < sesiones.size(); i++) {
			comboBox.addItem(sesiones.get(i).getHora());
		}

		JButton btnElegirFecha = new JButton("Aceptar");
		btnElegirFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestion.elegirHora((String) comboBox.getSelectedItem());
				//ventana.cambiarDePanel(7);
			}
		});
		btnElegirFecha.setBounds(358, 148, 134, 23);
		panel.add(btnElegirFecha);

	}
}
