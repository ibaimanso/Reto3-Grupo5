package modelobjeto;

public class Cine {
	private int id_cine;
	private String nombrecine;
	private String localicacion;

	public Cine(int id_cine, String nombrecine, String localicacion) {
		super();
		this.id_cine = id_cine;
		this.nombrecine = nombrecine;
		this.localicacion = localicacion;
	}

	public int getId_cine() {
		return id_cine;
	}

	public void setId_cine(int id_cine) {
		this.id_cine = id_cine;
	}

	public String getNombrecine() {
		return nombrecine;
	}

	public void setNombrecine(String nombrecine) {
		this.nombrecine = nombrecine;
	}

	public String getLocalicacion() {
		return localicacion;
	}

	public void setLocalicacion(String localicacion) {
		this.localicacion = localicacion;
	}

	@Override
	public String toString() {
		return "Cine [id_cine=" + id_cine + ", nombrecine=" + nombrecine + ", localicacion=" + localicacion + "]";
	}
	

}
