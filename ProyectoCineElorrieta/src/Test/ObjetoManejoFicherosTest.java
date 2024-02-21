package Test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import logica.ObjetoManejoFicheros;
import modelobjeto.LineaDeFactura;

public class ObjetoManejoFicherosTest {

	private ObjetoManejoFicheros escribir;
	private ArrayList<LineaDeFactura> factura;

	@Before
	public void escribirFicheros() {
		escribir = new ObjetoManejoFicheros();
		factura = new ArrayList<LineaDeFactura>();

	}

	@Test
	public void testEscribirFichero() {
		escribir.escribirFichero(factura);

		try (BufferedReader leedor = new BufferedReader(new FileReader("facturas/Factura.txt"))) {
			String linea;
			int i = 0;
			while ((linea = leedor.readLine()) != null) {
				if (i < factura.size()) {
					LineaDeFactura lineaFactura = factura.get(i);
					String expected = "Entrada " + i + ": " + lineaFactura.getNombrePelicula() + " ---> "
							+ lineaFactura.getNombreCine() + " // Sala: " + lineaFactura.getNombreSala() + "// Fecha: "
							+ lineaFactura.getDia() + " // " + lineaFactura.getHora();
					assertEquals(expected, linea);
					leedor.readLine();
					i++;
				} else {
					assertEquals("Archivo contiene más líneas de las esperadas", "", linea);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
