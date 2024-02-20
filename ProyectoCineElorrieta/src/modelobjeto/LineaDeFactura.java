package modelobjeto;

import java.util.Objects;

public class LineaDeFactura {
	/*
	 * Objeto LineDefactura es un objeto sacado de una query 	 */
	private String nombreCine, nombreSala, nombrePelicula, dia, hora;

	public LineaDeFactura() {
	}

	public LineaDeFactura(String nombreCine, String nombreSala, String nombrePelicula, String dia, String hora) {
		this.nombreCine = nombreCine;
		this.nombreSala = nombreSala;
		this.nombrePelicula = nombrePelicula;
		this.dia = dia;
		this.hora = hora;
	}

	public String getNombreCine() {
		return nombreCine;
	}

	public String getNombreSala() {
		return nombreSala;
	}

	public String getNombrePelicula() {
		return nombrePelicula;
	}

	public String getDia() {
		return dia;
	}

	public String getHora() {
		return hora;
	}

	public void setNombreCine(String nombreCine) {
		this.nombreCine = nombreCine;
	}

	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}

	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dia, hora, nombreCine, nombrePelicula, nombreSala);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaDeFactura other = (LineaDeFactura) obj;
		return Objects.equals(dia, other.dia) && Objects.equals(hora, other.hora)
				&& Objects.equals(nombreCine, other.nombreCine) && Objects.equals(nombrePelicula, other.nombrePelicula)
				&& Objects.equals(nombreSala, other.nombreSala);
	}

}
