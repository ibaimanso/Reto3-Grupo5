package modelobjeto;

public class Entrada {
	
	/*
	 * Objeto Entrada se utiliza para almacenar una fila de la tabla Entrada
	 */
	private int id_sesion;
	private int id_compra;

	public Entrada() {

	}

	public Entrada(int id_sesion, int id_compra) {
		this.id_sesion = id_sesion;
		this.id_compra = id_compra;
	}

	public int getId_sesion() {
		return id_sesion;
	}

	public void setId_sesion(int id_sesion) {
		this.id_sesion = id_sesion;
	}

	public int getId_compra() {
		return id_compra;
	}

	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}

	@Override
	public String toString() {
		return "entradas [id_sesion=" + id_sesion + ", id_compra=" + id_compra + "]";
	}

}
