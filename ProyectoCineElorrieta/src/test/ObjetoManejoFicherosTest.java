package test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.Test;

import logica.ObjetoManejoFicheros;
import modelobjeto.LineaDeFactura;

public class ObjetoManejoFicherosTest {

	private static ObjetoManejoFicheros escribir;
	private static ArrayList<LineaDeFactura> factura;

	@BeforeClass
	public static void escribirFicheros() {
		escribir = new ObjetoManejoFicheros();
		factura = new ArrayList<LineaDeFactura>();
		factura.add(new LineaDeFactura("Cine", "Sala1", "Pelicula", "Dia", "Hora"));
		factura.add(new LineaDeFactura("Cine", "Sala2", "Pelicula", "Dia", "Hora"));
		factura.add(new LineaDeFactura("Cine", "Sala3", "Pelicula", "Dia", "Hora"));
		
	}

	@Test
	public void testEscribirFichero() {
		boolean correcto = escribir.escribirFichero(factura);
		assertTrue(correcto);
	}
	
}
