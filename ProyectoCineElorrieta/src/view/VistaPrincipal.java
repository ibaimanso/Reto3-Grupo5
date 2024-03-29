
package view;

import javax.swing.JFrame;

import logica.GestionDeLaInformacion;
import model.Bienvenida;
import model.Cines;
import model.PanelCompra;
import model.CompraDeEntradas;
import model.Login;
import model.Peliculas;
import model.Registro;
import model.SelecionDeFechas;
import model.SelecionDeHora;
import model.CarritoDeLaCompra;

import java.awt.Toolkit;

/**
 * En esta clase nos encontraremos el JFrame principal sobre el que estan todos
 * los paneles
 */
public class VistaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;

	private GestionDeLaInformacion gestion;

	public VistaPrincipal() {

		/**
		 * Se le asignan a la ventana principal unos parametros como: Que se pueda
		 * cerrar por completo El icono de la aplicacion Y el tamaño principal de la
		 * ventana, ademas de que no se puede redimensionar.
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gestion = new GestionDeLaInformacion();
		setIconImage(Toolkit.getDefaultToolkit().getImage("multimedia/logo.jpg"));
		setLocationRelativeTo(null);
		// cambiarDePanel(0);
		setSize(620, 420);
		setResizable(false);

	}

	/**
	 * Metodo para cambiar entre los paneles
	 * 
	 * @param i
	 */
	public void cambiarDePanel(int i) {

		switch (i) {
		case 0:
			setContentPane(new Bienvenida(this));
			break;
		case 1:
			setContentPane(new Login(this, gestion));
			break;
		case 2:
			setContentPane(new Registro(this, gestion));
			break;
		case 3:
			setContentPane(new Cines(this, gestion));
			break;
		case 4:
			setContentPane(new Peliculas(this, gestion));
			break;
		case 5:
			setContentPane(new SelecionDeFechas(this, gestion));
			break;
		case 6:
			setContentPane(new SelecionDeHora(this, gestion));
			break;
		case 7:
			setContentPane(new CompraDeEntradas(this, gestion));
			break;
		case 8:
			setContentPane(new CarritoDeLaCompra(this, gestion));
			break;
		case 9:
			setContentPane(new PanelCompra(this, gestion));
			break;
		}
	}
}
