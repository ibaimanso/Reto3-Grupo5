package controlador;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import modelobjeto.Cine;
import modelobjeto.Pelicula;
import modelobjeto.Sesion;

public class GestionBDTest {
	
		private Cine cineDePrueba;
	    private GestionBD conexion;



	@Test
	public void testInsertUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	
	

	@Before
	public void iniciarConexion() {
	    conexion.iniciarConexion();
	    cineDePrueba.getNombrecine();
	}

	@Test
	public void testBuscarCines() {
	    ArrayList<Cine> cines = conexion.buscarCines();
	    assertTrue(cines.isEmpty(), "El ArrayList de cines esta vacio");
	    assertFalse(cines.contains(cineDePrueba), "El cine de prueba no se ha encontrado en el ArrayList");
	}

	private void assertFalse(boolean contains, String string) {
		// TODO Auto-generated method stub
		
	}

	private void assertTrue(boolean empty, String string) {
		// TODO Auto-generated method stub
		
	}

	@After
	public void cerrarConexion() {
	    cineDePrueba.getNombrecine();
	    conexion.cerrarConexion();
	}

	@Test
	public void testBuscarPelis() {
	        GestionBD instancia = new GestionBD();
	        
	        String idCine = "ELO";

	        ArrayList<Pelicula> resultado = instancia.buscarPelis(idCine);

	        assertNotNull(resultado, "El resultado no debería ser nulo");

	    
	}
	

	private void assertNotNull(ArrayList<Pelicula> resultado, String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void testBuscarUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarSesiones() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarSesionesPorFecha() {
        GestionBD instancia = new GestionBD();

        int IDPelicula = 1; 
        String IDCine = "1"; 
        String dia = ""; 

        ArrayList<Sesion> resultado = instancia.buscarSesionesPorFecha(IDPelicula, IDCine, dia);

        Assert.assertNotNull(resultado);
        
	}
	
	@Test
	public void testBuscarSesion() {
		fail("Not yet implemented");
	}

	@Test
	public void testRecogerPrecio() {
		fail("Not yet implemented");
	}

	@Test
	public void testRecogerIDPelicula() {
		fail("Not yet implemented");
	}

	@Test
	public void testDevolverFacturas() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertarCompra() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertarEntradas() {
		fail("Not yet implemented");
	}

}
