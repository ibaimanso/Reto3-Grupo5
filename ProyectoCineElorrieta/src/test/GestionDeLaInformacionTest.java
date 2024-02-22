package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import controlador.GestionBD;
import logica.GestionDeLaInformacion;
import modelobjeto.*;

public class GestionDeLaInformacionTest {
	
	private static GestionDeLaInformacion gestion;
	private static GestionBD gestionBD;
	private static Cliente usuario;
	private static Compra prueba;
	private static ArrayList<Sesion> sesiones;
	
	@BeforeClass
	public static void inciarVariables() {
		gestion = new GestionDeLaInformacion();
		gestionBD = new GestionBD();
		usuario = new Cliente("12345678A", "JUAN", "GARCIA", "H", "contraseña1");
		prueba = new Compra(gestionBD.buscarCompraMasAlta() + 1, usuario.getDni());
		prueba.setCantodadEntradas(2);
		prueba.setDescuento(20);
		prueba.setPrecioDescontado(11.59);
		prueba.setPrecioTotal(14.49);
		sesiones = new ArrayList<Sesion>();
		sesiones.add(new Sesion(1 , "14:00:00", "2024-01-01", "001", 1));
		sesiones.add(new Sesion(4 , "14:00:00", "2024-01-01", "001", 2));
	}
	
	@Before
	public void restaurarVariables() {
		gestion = new GestionDeLaInformacion();
	}
	
	@Test
	public void ValidarPrecio() {
		gestion.guardarUsuario("12345678A");
		gestion.añadirEntradas(1, sesiones.get(0));
		gestion.añadirEntradas(1, sesiones.get(1));
		Compra compraARealizar = gestion.calcularCompra();
		assertEquals(prueba.getPrecioTotal(), compraARealizar.getPrecioTotal(), 0);
	}
	
	@Test
	public void ValidarDescontado() {
		gestion.guardarUsuario("12345678A");
		gestion.añadirEntradas(1, sesiones.get(0));
		gestion.añadirEntradas(1, sesiones.get(1));
		Compra compraARealizar = gestion.calcularCompra();
		assertEquals(prueba.getPrecioDescontado(), compraARealizar.getPrecioDescontado(), 0);
	}
	
	@AfterClass
	public static void cerrarConexion() {
		gestionBD.cerrarConexion();
	}
}
