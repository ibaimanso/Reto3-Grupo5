package modelobjeto;

public class Pelicula {
	private int idpeli;
	private String nombrepeli;
	private String genero;
	private int duracion;
	
	

	public Pelicula(int idPelicula, String nombrePelicula, String generoPelicula, int duracion, double precio) {

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
