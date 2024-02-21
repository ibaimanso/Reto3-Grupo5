package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controlador.GestionBD;

import modelobjeto.*;

public class GestionDeLaInformacionTest {
	    private GestionBD gestionBD;
	    private ArrayList<Entrada> entradasCompradas;
	    private Compra compra;
	
	@Before
	public void iniciar() {
		compra = new Compra();
        gestionBD = new GestionBD(); 
        compra.setGestionBD(gestionBD);
        entradasCompradas = new ArrayList<>();
     
	        
	}

	@Test
	public void testCalcularCompra() {

		 Entrada entrada1 = new Entrada();
	        entrada1.setId_sesion(1);
	        entradasCompradas.add(entrada1);

	        compra.setEntradasCompradas(entradasCompradas);
	        Compra resultado = compra.calcularCompra();

	        assertEquals(10.0, resultado.getPrecioTotal(), 0.01);
	        assertEquals(1, resultado.getCantodadEntradas());
	        assertEquals(0, resultado.getDescuento());
	        assertEquals(10.0, resultado.getPrecioDescontado(), 0.01);
	    }

	}

}
