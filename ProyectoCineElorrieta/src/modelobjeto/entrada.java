package modelobjeto;

public class entrada {
	private int id_entrada;
	private int id_sesion;
	private int id_compra;

	public entrada() {

	}
	
	public entrada(int id_entrada, int id_sesion, int id_compra) {
		super();
		this.id_entrada = id_entrada;
		this.id_sesion = id_sesion;
		this.id_compra = id_compra;
	}

	public int getId_entrada() {
		return id_entrada;
	}

	public void setId_entrada(int id_entrada) {
		this.id_entrada = id_entrada;
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
		return "entradas [id_entrada=" + id_entrada + ", id_sesion=" + id_sesion + ", id_compra=" + id_compra + "]";
	}
	

	
}
