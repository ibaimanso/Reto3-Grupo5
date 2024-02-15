package model;

import javax.swing.JPanel;

import view.VistaPrincipal;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import javax.swing.SwingConstants;

import controlador.GestionBD;



/**
 * En esta clase nos encontraremos la base de el panel de bienvenida.
 */
public class Bienvenida extends JPanel {
	public Bienvenida(VistaPrincipal ventana) {
		/**
		 * Se le da una altura y una anchura al JPanel. Se hace que no se pueda
		 * redimensionar la VentanaPrincipal
		 */
		setSize(ventana.getSize());
		setVisible(true);
		setLayout(null);

		/**
		 * Etiqueta principal con el nombre de la empresa en la que si haces click
		 * pasaremos al panel de login
		 */
		JLabel lblFinestCines = new JLabel("FINEST CINES");
		lblFinestCines.setFont(new Font("Ink Free", Font.BOLD, 39));
		lblFinestCines.setBounds(164, 38, 399, 178);
		add(lblFinestCines);
		lblFinestCines.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long tiempoDeActivacion = System.currentTimeMillis() + 0500;
				while (System.currentTimeMillis() < tiempoDeActivacion) {
				}
				ventana.cambiarDePanel(1);
			}
		});

		/**
		 * Etiqueta en la que esta la imagen de el fondo de la bienvenida, en el que si
		 * hacemos click no mandara al panel de login.
		 */
		JLabel lblFondo = new JLabel("fondoBienvenida");
		lblFondo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long tiempoDeActivacion = System.currentTimeMillis() + 0500;
				while (System.currentTimeMillis() < tiempoDeActivacion) {
				}
				ventana.cambiarDePanel(1);
			}
		});
		lblFondo.setIcon(new ImageIcon("multimedia/cine.jpg"));
		lblFondo.setBounds(0, -166, 595, 712);
		add(lblFondo);
		addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
}
