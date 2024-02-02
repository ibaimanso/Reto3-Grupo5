package view;

import javax.swing.JFrame;
import controlador.GestionBD;
import model.Bienvenida;
import model.Cines;
import model.Login;
import model.Registro;
import modelobjeto.Cine;

import java.awt.Toolkit;


public class VistaPrincipal extends JFrame {
	
	public VistaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("multimedia/logo.jpg"));
		setVisible(true);
		cambiarDePanel(0);
		setSize(620,420);
		setResizable(false);
		
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
		case 3:
			setContentPane(new Cines(this));
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
