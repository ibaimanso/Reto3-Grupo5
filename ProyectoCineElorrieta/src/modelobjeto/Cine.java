package modelobjeto;

import java.util.Objects;

public class Cine {
	/**
	 * Objeto cine se utiliza para almacenar una fila de la tabla cine 
	 */

	private String id_cine;
	private String nombrecine;
	private String localicacion;
	public Cine(){
		
	}
	
	public Cine(String id_cine, String nombrecine, String localicacion) {
		super();
		this.id_cine = id_cine;
		this.nombrecine = nombrecine;
		this.localicacion = localicacion;
	}

	public String getId_cine() {
		return id_cine;
	}
	public void setId_cine(String id_cine) {
		this.id_cine = id_cine;
	}
	public String getNombrecine() {
		return nombrecine;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_cine, localicacion, nombrecine);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cine other = (Cine) obj;
		return Objects.equals(id_cine, other.id_cine) && Objects.equals(localicacion, other.localicacion)
				&& Objects.equals(nombrecine, other.nombrecine);
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
