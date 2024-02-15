package logica;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelobjeto.LineaDeFactura;

public class ObjetoManejoFicheros {

	public ObjetoManejoFicheros() {

	}

	public void escribirFichero(ArrayList<LineaDeFactura> factura) {
		try {
			BufferedWriter escribirFichero = new BufferedWriter(new FileWriter("facturas/Factura.txt"));
			for (int i = 0; i < factura.size(); i++) {
				escribirFichero.write("Entrada " + i + ": " + factura.get(i).getNombrePelicula() + " ---> "
						+ factura.get(i).getNombreCine() + " // Sala: " + factura.get(i).getNombreSala() + "// Fecha: "
						+ factura.get(i).getDia() + " // " + factura.get(i).getHora());
				escribirFichero.newLine();
				escribirFichero.write("**************************************************");
				escribirFichero.newLine();
			}
			escribirFichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
