package modelobjeto;

public class Pelicula {
	private String nombrepeli;
	private int idpeli;
	private int duracion;
	private String genero;
	private double precio;
	
	public Pelicula() {
		
	}
	

	public Pelicula(String nombrepeli, int idpeli, int duracion, String genero, double precio) {
		super();
		this.nombrepeli = nombrepeli;
		this.idpeli = idpeli;
		this.duracion = duracion;
		this.genero = genero;
		this.precio = precio;
	}


	public String getNombrepeli() {
		return nombrepeli;
	}

	public void setNombrepeli(String nombrepeli) {
		this.nombrepeli = nombrepeli;
	}

	public int getIdpeli() {
		return idpeli;
	}

	public void setIdpeli(int idpeli) {
		this.idpeli = idpeli;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Pelicula [nombrepeli=" + nombrepeli + ", idpeli=" + idpeli + ", duracion=" + duracion + ", genero="
				+ genero + ", precio=" + precio + "]";
	}
	
	
}
