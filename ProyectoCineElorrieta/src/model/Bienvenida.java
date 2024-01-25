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
	
	public class Bienvenida extends JPanel{
		public Bienvenida() {
			setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("FINEST CINES");
			lblNewLabel_1.setFont(new Font("Ink Free", Font.BOLD, 39));
			lblNewLabel_1.setBounds(164, 38, 399, 178);
			add(lblNewLabel_1);
			
			JLabel lblNewLabel = new JLabel("fondoBienvenida");
			lblNewLabel.setIcon(new ImageIcon("multimedia/cine.jpg"));
			lblNewLabel.setBounds(0, -166, 595, 712);
			add(lblNewLabel);
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