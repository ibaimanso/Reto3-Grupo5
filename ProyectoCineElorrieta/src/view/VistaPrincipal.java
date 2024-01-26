package view;

import javax.swing.JFrame;

import controlador.GestionBD;
import model.Bienvenida;
import java.awt.Toolkit;

public class VistaPrincipal extends JFrame {
	public VistaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("multimedia/logo.jpg"));
	}
	
	public void cambiarDePanel(int i) {

		switch (i) {
		case 0:
			setContentPane(new model.Bienvenida());
			break;
		}
	}
	public static void main(String[] args) {
		GestionBD gestion = new GestionBD();
		 gestion.iniciarConexion();
		gestion.informacioncliente();
		VistaPrincipal ventana = new VistaPrincipal();
		ventana.setVisible(true);
		ventana.cambiarDePanel(0);
		ventana.setResizable(false);
		ventana.setSize(620,420);
	}

}
