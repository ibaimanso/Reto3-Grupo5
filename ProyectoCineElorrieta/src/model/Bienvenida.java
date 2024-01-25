package model;



	import javax.swing.JPanel;
	import vista.VentanaPrincipalReto;
	import javax.swing.JLabel;
	import java.awt.Font;
	import javax.swing.ImageIcon;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.awt.event.MouseAdapter;
	
	public class Bienvenida extends JPanel{

			/**
			 * @author Cine elorrieta
			 * Representa la clase principal del administrador del proyecto.
			 */
		public Bienvenida {

			/**
			 * Se le da una altura y una anchura al JPanel. Se hace que no se pueda
			 * redimensionar la VentanaPrincipal
			 */
			setSize(ventana.getSize());
			setVisible(true);
			setLayout(null);
			
			/**
			 * Creacion de la etquieta para "finestCines"
			 */
			JLabel lblLetrasBienvenida = new JLabel("BIENVENIDO A FINEST CINES");
			lblLetrasBienvenida.setBounds(135, 220, 430, 50);
			lblLetrasBienvenida.setLabelFor(this);
			lblLetrasBienvenida.setToolTipText("");
			lblLetrasBienvenida.setFont(new Font("Mistral", Font.BOLD, 36));
			add(lblLetrasBienvenida);
			
			/**
			 * Al presional el fondo y esperar 0'5s, te lleva al "PanelLoginReto"
			 */
			JLabel lblFondoBienvenida = new JLabel("FondoBienvenida");
			lblFondoBienvenida.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					long tiempoDeActivacion = System.currentTimeMillis() + 0500;
			        while (System.currentTimeMillis() < tiempoDeActivacion) {
			        }
					ventana.cambiarDePanel(1);	
				}
			});
			lblFondoBienvenida.setBounds(0, -61, 736, 622);
			lblFondoBienvenida.setIcon(new ImageIcon("Imagenes/FondoBienvenida.png"));
			add(lblFondoBienvenida);

			/**
			 * Lo que hace esto es que cuando le das al enter se presione el boton "Continuar". A si haciendolo más comodo para la persona
			 */
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
}
