package view;

import javax.swing.JFrame;



import controlador.GestionBD;
import model.Bienvenida;
import model.Login;
import java.awt.Toolkit;

public class VistaPrincipal extends JFrame {
	
	public VistaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("multimedia/logo.jpg"));
	VistaPrincipal ventana = new VistaPrincipal();
	ventana.setVisible(true);
	ventana.cambiarDePanel(0);
	ventana.setSize(620,420);
	ventana.setResizable(false);
		
	}
	
	public void cambiarDePanel(int i) {

		switch (i) {
		case 0:
			setContentPane(new Bienvenida(this));
			break;
		case 1:
			setContentPane(new Login(this));
			break;
		}
	}
	public static void main(String[] args) {
		GestionBD gestion = new GestionBD();
		VistaPrincipal ventana = new VistaPrincipal();
//		gestion.iniciarConexion();
		gestion.informacioncliente();

	}

}
