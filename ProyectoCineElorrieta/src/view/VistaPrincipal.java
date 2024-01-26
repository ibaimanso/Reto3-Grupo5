package view;

import javax.swing.JFrame;
import controlador.GestionBD;
import model.Bienvenida;
import model.Login;
import model.Registro;

import java.awt.Toolkit;


public class VistaPrincipal extends JFrame {
	
	public VistaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("multimedia/logo.jpg"));
	

		
	}
	
	public void cambiarDePanel(int i) {

		switch (i) {
		case 0:
			setContentPane(new Bienvenida(this));
			break;
		case 1:
			setContentPane(new Login(this));
			break;
		case 2:
			setContentPane(new Registro(this));
			break;
		}
	}
	public static void main(String[] args) {
	
		VistaPrincipal ventana = new VistaPrincipal();
		ventana.cambiarDePanel(0);
		ventana.setVisible(true);
		ventana.setSize(620,420);
		ventana.setResizable(false);
	

	}

}
