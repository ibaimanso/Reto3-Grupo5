package view;

import javax.swing.JFrame;

import model.Bienvenida;

public class VistaPrincipal extends JFrame {
	
	public void cambiarDePanel(int i) {

		switch (i) {
		case 0:
			setContentPane(new model.Bienvenida());
			break;
		}
	}
	public static void main(String[] args) {
		VistaPrincipal ventana = new VistaPrincipal();
		ventana.setVisible(true);
		ventana.cambiarDePanel(0);
		ventana.setResizable(false);
		ventana.setSize(620,400);
	}

}
