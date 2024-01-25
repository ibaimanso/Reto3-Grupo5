package model;



	import javax.swing.JPanel;

	import view.VistaPrincipal;
	import javax.swing.JLabel;
	import java.awt.Font;
	import javax.swing.ImageIcon;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.awt.event.MouseAdapter;
	
	public class Bienvenida extends JPanel{
		public Bienvenida() {
			setLayout(null);
		}


			public void PanelBienvenida(VistaPrincipal ventana) {

				/**
				 * Se le da una altura y una anchura al JPanel. Se hace que no se pueda
				 * redimensionar la VentanaPrincipal
				 */
				setSize(600,500);
				setVisible(true);
				setLayout(null);
				

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