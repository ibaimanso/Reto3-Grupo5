package modelobjeto;

public class Sesion {
	private int id_sesiones;
	private String id_sala;
	private int id_pelicula;
	private String Hora;
	private String Dia;

	public Sesion() {

	}

	public Sesion(int iD_Sesiones, String hora, String dia, String id_sala, int id_pelicula) {
		id_sesiones = iD_Sesiones;
		this.id_sala = id_sala;
		this.id_pelicula = id_pelicula;
		Hora = hora;
		Dia = dia;
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
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}

	public String getDia() {
		return Dia;
	}

	public void setDia(String dia) {
		Dia = dia;
	}

	@Override
	public String toString() {
		return "Sesiones [id_sesiones=" + id_sesiones + ", id_sala=" + id_sala + ", id_pelicula=" + id_pelicula
				+ ", Hora=" + Hora + ", Dia=" + Dia + "]";
	}

}
