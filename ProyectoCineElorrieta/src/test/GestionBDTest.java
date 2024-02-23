package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import controlador.GestionBD;
import modelobjeto.Cine;
import modelobjeto.Cliente;
import modelobjeto.Compra;
import modelobjeto.Entrada;
import modelobjeto.Pelicula;
import modelobjeto.Sesion;

public class GestionBDTest {

	private static GestionBD conexion;

	@BeforeClass
	public static void iniciarConexion() {
		conexion = new GestionBD();

	}

	@AfterClass
	public static void cerrarConexion() {
		conexion.cerrarConexion();
	}

	/**
	 * En este test es importante recalcar que en nuestra aplicacion no hace falta
	 * hacer 2 test para comprobar la fecha de una pelicula y la sesion de cada
	 * pelicula, ya que las sesiones ya estan ligadas a la fecha en la que se
	 * retransmite la pelicula.
	 */
	@Test
	public void testBuscarCines() {
		ArrayList<Cine> sacarCine = conexion.buscarCines();

		Cine primerCine = sacarCine.get(0);
		Cine expected = new Cine("ELO", "CINE ELORRIETA", "123 Main Street");

		assertEquals(expected, primerCine);
	}

	/**
	 * Test Buscar Pelis: insertamos un String idCine con el valor "ELO" llamamos a
	 * la arraylist del objeto pelicula con el nombre resultado y buscamos la idcine
	 * desde el metodo buscarPeli.
	 * 
	 * 
	 */

	@Test
	public void testBuscarPelis() {

		String idCine = "ELO";

		ArrayList<Pelicula> resultado = conexion.buscarPelis(idCine);

		assertNotNull(resultado);

	}

	/**
	 * insertamos las variables con los valores para la busqueda llamamos el
	 * arraylist del objeto sesion con el nombre resultado y buscamos con el metodo
	 * "buscarSesionesPorFecha" el IDPelicula, IDCine, dia.
	 * 
	 * 
	 */
	@Test
	public void testBuscarSesionesPorFecha() {
		int IDPelicula = 1;
		String IDCine = "ELO";
		String dia = "2024-01-01";

		ArrayList<Sesion> resultado = conexion.buscarSesionesPorFecha(IDPelicula, IDCine, dia);

		Assert.assertNotNull(resultado);

	}

	/**
	 * Insertamos en assertNotEquals el resultado busca el precio de la pelicula de
	 * la posicion 0 y lo compara con para con las variables precioPelicula y
	 * unexpected si la variable precioPelicula es igual a resultado es correcto.
	 * 
	 */

	@Test
	public void testRecogerPrecio() {
		double unexpected = 0;
		double precioPelicula = 7.99;
		double resultado = conexion.recogerPrecio(0);

		assertNotEquals(unexpected, precioPelicula, resultado);
	}

	/**
	 * insertamos variables y sus valores y con la variable boolean con el metodo
	 * login comprobamos si esta registrado el usuario y contraseña
	 */
	@Test
	public void testLogin() {
		String usuario = "12345678A";
		String contraseña = "contraseña1";

		boolean correcto = conexion.Login(usuario, contraseña);

		assertTrue(correcto);

	}
	
	@Test
	public void insertarUsuario() {
		Cliente cliente = new Cliente("88888888B", "JUAN", "LARREA", "H", "Contraseña1");
		boolean correcto = conexion.insertUsuario(cliente);
		assertTrue(correcto);
	}

	@Test
	public void insertarCompra() {
		Compra compra = new Compra(conexion.buscarCompraMasAlta() + 1, "12345678A");
		compra.setCantodadEntradas(0);
		compra.setDescuento(0);
		compra.setPrecioDescontado(1.99);
		compra.setPrecioTotal(1.99);
		boolean correcto = conexion.insertarCompra(compra);
		assertTrue(correcto);
	}
	
	@Test
	public void insertarEntradas() {
		ArrayList<Entrada> entradas = new ArrayList<Entrada>();
		entradas.add(new Entrada( 1, 1));
		entradas.add(new Entrada( 1, 1));
		entradas.add(new Entrada( 1, 1));
		entradas.add(new Entrada( 1, 1));
		boolean correcto = conexion.insertarEntradas(entradas);
		assertTrue(correcto);
	}
	

}
