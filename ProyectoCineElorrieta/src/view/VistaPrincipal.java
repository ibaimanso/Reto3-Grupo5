package view;

import javax.swing.JFrame;

import logica.GestionDeLaInformacion;
import model.Bienvenida;
import model.Cines;
import model.Login;
import model.Registro;

import java.awt.Toolkit;

public class VistaPrincipal extends JFrame {
	private GestionDeLaInformacion gestion;

	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gestion = new GestionDeLaInformacion();
		setIconImage(Toolkit.getDefaultToolkit().getImage("multimedia/logo.jpg"));
		cambiarDePanel(0);
		setSize(620, 420);
		setResizable(false);

	}

	public void cambiarDePanel(int i) {

		switch (i) {
		case 0:
			setContentPane(new Bienvenida(this));
			break;
		case 1:
			setContentPane(new Login(this, this.gestion));
			break;
		case 2:
			setContentPane(new Registro(this, this.gestion));
			break;
		case 3:
			setContentPane(new Cines(this, this.gestion));
		}
	}

	public static void main(String[] args) {
		VistaPrincipal ventana = new VistaPrincipal();
		ventana.setVisible(true);
	}

}
