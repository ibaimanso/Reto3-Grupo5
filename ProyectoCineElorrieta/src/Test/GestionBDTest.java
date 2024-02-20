package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
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
	private GestionBD conexion;

	@Before
	public void iniciarConexion() {
		conexion.iniciarConexion();

	}



	@Test
	public void testBuscarCines() {
		GestionBD instancia = new GestionBD();
		ArrayList<Cine> sacarCine = instancia.buscarCines();
		
		Cine primerCine = sacarCine.get(0);
		Cine expected = new Cine("ELO", "Cine Elorrieta", "123 Main Street");

		assertEquals(expected, primerCine);
	}

	@Test
	public void testBuscarPelis() {
		GestionBD instancia = new GestionBD();

		String idCine = "ELO";

		ArrayList<Pelicula> resultado = instancia.buscarPelis(idCine);

		assertNotNull(resultado);

	}

	@Test
	public void testBuscarSesionesPorFecha() {
		GestionBD instancia = new GestionBD();
		int IDPelicula = 1;
		String IDCine = "ELO";
		String dia = "2024-01-01";

		ArrayList<Sesion> resultado = instancia.buscarSesionesPorFecha(IDPelicula, IDCine, dia);

		Assert.assertNotNull(resultado);

	}

	@Test
	public void testRecogerPrecio() {
		GestionBD instancia = new GestionBD();
		double precioPelicula = 7.99;
		double resultado = instancia.recogerPrecio(0);
		
		assertEquals(null, resultado, precioPelicula, resultado);

	}

	
	@After
	public void cerrarConexion() {
		conexion.cerrarConexion();
	}

}
