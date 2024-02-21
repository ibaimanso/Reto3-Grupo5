package modelobjeto;

import java.util.Objects;

public class Sala {
	/*
	 * Objeto Sala se utiliza para almacenar una fila de la tabla Sala
	 */
	private String id_sala;
	private String nombre_sala;
	private String genero;
	private String id_cine;

	public Sala() {

	}
	

	public Sala(String id_sala, String nombre_sala, String genero, String id_cine) {
		super();
		this.id_sala = id_sala;
		this.nombre_sala = nombre_sala;
		this.genero = genero;
		this.id_cine = id_cine;
	}


	public String getId_sala() {
		return id_sala;
	}

	public void setId_sala(String id_sala) {
		this.id_sala = id_sala;
	}

	public String getNombre_sala() {
		return nombre_sala;
	}

	public void setNombre_sala(String nombre_sala) {
		this.nombre_sala = nombre_sala;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getId_cine() {
		return id_cine;
	}

	public void setId_cine(String id_cine) {
		this.id_cine = id_cine;
	}


	@Override
	public String toString() {
		return "sala [id_sala=" + id_sala + ", nombre_sala=" + nombre_sala + ", genero=" + genero + ", id_cine="
				+ id_cine + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(genero, id_cine, id_sala, nombre_sala);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(genero, other.genero) && Objects.equals(id_cine, other.id_cine)
				&& Objects.equals(id_sala, other.id_sala) && Objects.equals(nombre_sala, other.nombre_sala);
	}
	

}
