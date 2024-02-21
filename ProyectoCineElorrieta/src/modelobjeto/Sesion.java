package modelobjeto;

import java.util.Objects;

public class Sesion {
	/*
	 * Objeto Sesion se utiliza para almacenar una fila de la tabla Sesion
	 */
	private int id_sesiones;
	private String id_sala;
	private int id_pelicula;
	private String hora;
	private String dia;

	public Sesion() {

	}

	public Sesion(int iD_Sesiones, String hora, String dia, String id_sala, int id_pelicula) {
		id_sesiones = iD_Sesiones;
		this.id_sala = id_sala;
		this.id_pelicula = id_pelicula;
		hora = hora;
		dia = dia;
	}

	public int getid_sesiones() {
		return id_sesiones;
	}

	public void setid_sesiones(int iD_Sesiones) {
		id_sesiones = iD_Sesiones;
	}

	public String getId_sala() {
		return id_sala;
	}

	public void setId_sala(String id_sala) {
		this.id_sala = id_sala;
	}

	public int getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		hora = hora;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		dia = dia;
	}

	@Override
	public String toString() {
		return "Sesiones [id_sesiones=" + id_sesiones + ", id_sala=" + id_sala + ", id_pelicula=" + id_pelicula
				+ ", Hora=" + hora + ", Dia=" + dia + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dia, hora, id_pelicula, id_sala, id_sesiones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sesion other = (Sesion) obj;
		return Objects.equals(dia, other.dia) && Objects.equals(hora, other.hora) && id_pelicula == other.id_pelicula
				&& Objects.equals(id_sala, other.id_sala) && id_sesiones == other.id_sesiones;
	}

}
