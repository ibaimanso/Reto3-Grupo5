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

public class Bienvenida extends JPanel {
/**
 * 
 * @param ventana 
 * panel de Bienvenida  con los parametros de VistaPrincipal  
 */
	public Bienvenida(VistaPrincipal ventana) {
		/**
		 * Se le da una altura y una anchura al JPanel. Se hace que no se pueda
		 * redimensionar la VentanaPrincipal.
		 */
		setSize(ventana.getSize());
		setVisible(true);
		setLayout(null);

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
		 * Accion que cuando pulsas al nombre "FINEST CINE" o 
		 * en la imagen fondo bienvenida se cambiara al siguiente panel en este caso al login.
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
		/**
		 * Es tele es la ruta donde esta la imagen de fondo de bienvenida.
		 */
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
