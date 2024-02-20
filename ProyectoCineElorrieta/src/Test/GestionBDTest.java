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
import model.Compra;
import modelobjeto.Cine;
import modelobjeto.Pelicula;
import modelobjeto.Sesion;

public class GestionBDTest {

	private Cine cineDePrueba;
	private static GestionBD conexion;

	@BeforeClass
	public static void iniciarConexion() {
		conexion = new GestionBD();
	}

	@AfterClass
	public static void cerrarConexion() {
		conexion.cerrarConexion();
	}

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
		int IDPelicula = 1;
		String IDCine = "ELO";
		String dia = "2024-01-01";

		ArrayList<Sesion> resultado = conexion.buscarSesionesPorFecha(IDPelicula, IDCine, dia);

		Assert.assertNotNull(resultado);

	}

	@Test
	public void testRecogerPrecio() {
		double precioPelicula = 7.99;
		double resultado = conexion.recogerPrecio(0);
		
		assertEquals(null, resultado, precioPelicula, resultado);

	}


}
