package modelobjeto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
	/*
	 * Objeto CLiente
	 */

	private String dni;
	private String nombrecli;
	private String apellido;
	private String sexo;
	private String contraseña;

	public Cliente() {

	}

	public Cliente(String dni, String nombrecli, String apellido, String sexo, String contraseña) {

		this.dni = dni;
		this.nombrecli = nombrecli;
		this.apellido = apellido;
		this.sexo = sexo;
		this.contraseña = contraseña;
	}
	
	public boolean validarDNI(String dni) {
	     String regex = "^[0-9]{8}[a-zA-Z]$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(dni);
	        return matcher.matches();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
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
