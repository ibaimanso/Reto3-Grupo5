package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controlador.GestionBD;
import model.PanelCompra;
import modelobjeto.Cine;
import modelobjeto.Cliente;
import modelobjeto.Pelicula;
import modelobjeto.Sesion;

public class GestionBDTest {

	private Cine cineDePrueba;
	private static GestionBD conexion;
	private static Cliente cliente;

	@BeforeClass
	public static void iniciarConexion() {
		conexion = new GestionBD();
		cliente = new Cliente();
	}

	@AfterClass
	public static void cerrarConexion() {
		conexion.cerrarConexion();
	}

	/**
	 * En este test es importante recalcar quie en nuestra aplicacion no hace falta
	 * hacer 2 test para comprobar la fecha de una pelicula y la sesion de cada
	 * pelicula, ya que las sesiones ya estan ligafas a la fecha en la que se
	 * retransmite la pelicula.
	 */
	@Test
	public void testBuscarCines() {
		ArrayList<Cine> sacarCine = conexion.buscarCines();

		Cine primerCine = sacarCine.get(0);
		Cine expected = new Cine("ELO", "CINE ELORRIETA", "123 Main Street");

		assertEquals(expected, primerCine);
	}

	@Test
	public void testBuscarPelis() {

		String idCine = "ELO";

		ArrayList<Pelicula> resultado = conexion.buscarPelis(idCine);

		assertNotNull(resultado);

	}

	@Test
	public void testBuscarSesionesPorFecha() {
		int iDPelicula = 1;
		String iDCine = "ELO";
		String dia = "2024-01-01";

		ArrayList<Sesion> resultado = conexion.buscarSesionesPorFecha(iDPelicula, iDCine, dia);

		Assert.assertNotNull(resultado);

	}

	@Test
	public void testRecogerPrecio() {
		double unexpected = 0;
		double precioPelicula = 7.99;
		double resultado = conexion.recogerPrecio(0);

		assertNotEquals(unexpected, precioPelicula, resultado);
	}

//	@Test
//	public void testLogin() {
//		String dni = "12345678A";
//		String pass = "contraseña1";
//		boolean cliente = conexion.Login(dni, pass);
//		Cliente expected = new Cliente("12345678A", "JUAN", "GARCIA", "H", "contraseña1");
//
//		assertEquals(expected, cliente);
//	}


	
	
}
