package modelobjeto;

public class Cliente {
	/*
	 * Objeto CLiente
	 */

	private int dni;
	private String nombrecli;
	private String apellido;
	private String sexo;
	private String contraseña;

	public Cliente() {

	}

	public Cliente(int dni, String nombrecli, String apellido, String sexo, String contraseña) {

		this.dni = dni;
		this.nombrecli = nombrecli;
		this.apellido = apellido;
		this.sexo = sexo;
		this.contraseña = contraseña;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombrecli() {
		return nombrecli;
	}

	public void setNombrecli(String nombrecli) {
		this.nombrecli = nombrecli;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	@Override
	public String toString() {
		return "Cliente :DNI " + dni + "/n nombre" + nombrecli + "/n apellido" + apellido + "/n sexo" + sexo
				+ "/n contraseña" + contraseña;
	}


}
