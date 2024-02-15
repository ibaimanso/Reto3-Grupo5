package modelobjeto;

import java.io.File;

public class Pelicula {
	/*
	 * Objeto Entrada se utiliza para almacenar una fila de la tabla Entrada
	 */
	private int idpeli;
	private String nombrepeli;
	private String genero;
	private int duracion;
	
	

	public Pelicula() {
		
	}

	public Pelicula(int idpeli, String nombrepeli, String genero, int duracion, double precio) {
		super();
		this.idpeli = idpeli;
		this.nombrepeli = nombrepeli;
		this.genero = genero;
		this.duracion = duracion;
		this.precio = precio;
	}

	public String toString() {
		return "Pelicula [idpeli=" + idpeli + ", nombrepeli=" + nombrepeli + ", genero=" + genero + ", duracion="
				+ duracion + ", precio=" + precio + "]";
	}

	public int getIdpeli() {
		return idpeli;
	}

	public void setIdpeli(int idpeli) {
		this.idpeli = idpeli;
	}

	public String getNombrepeli() {
		return nombrepeli;
	}

	public void setNombrepeli(String nombrepeli) {
		this.nombrepeli = nombrepeli;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	private double precio;


}
