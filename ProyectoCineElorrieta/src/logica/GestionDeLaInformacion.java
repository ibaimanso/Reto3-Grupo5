package logica;

import java.security.Key;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import modelobjeto.Cliente;
import view.VistaPrincipal;

public class GestionDeLaInformacion {

	private final String CLAVE_ENCRIPTACION = "clavecompartidanorevelarnuncamas";

	public GestionDeLaInformacion() {
	}

	
	/*
	 * Metodo para encriptar la contraseña en la base de datos
	 */
	public String desencriptar(String mensajeEncriptado) throws Exception {
		byte[] mensajeBytes = Base64.getDecoder().decode(mensajeEncriptado);
		Key claveAES = new SecretKeySpec(CLAVE_ENCRIPTACION.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, claveAES);
		String desencriptado = new String(cipher.doFinal(mensajeBytes));
		return desencriptado;
	}

	public void recogerInformacionFormulario(Cliente cliente, VistaPrincipal ventana) {

		/*
		 * Regex para que en el panel de registro toda la informacion se introduzca
		 * correctamente
		 */

		String txtDni = cliente.getDni();
		Pattern patron = Pattern.compile("^[0-9]{8}[A-Z]$", Pattern.CASE_INSENSITIVE);
		Matcher dni = patron.matcher(txtDni);

		if (!dni.find()) {
			JOptionPane.showMessageDialog(null, "DNI no valido");
		} else {

		}
		String textoNombre = cliente.getNombrecli();
		Pattern patron2 = Pattern.compile("^[a-z]+$", Pattern.CASE_INSENSITIVE);
		Matcher nombre = patron2.matcher(textoNombre);

		if (!nombre.find()) {
			JOptionPane.showMessageDialog(null, "Nombre no valido");
		} else {

		}

		String textoApellido = cliente.getApellido();
		Pattern patron3 = Pattern.compile("^[a-z]+$", Pattern.CASE_INSENSITIVE);
		Matcher apellido = patron3.matcher(textoApellido);

		if (!apellido.find()) {
			JOptionPane.showMessageDialog(null, "Apellido no valido");
		} else {
		}

		String textoPass = cliente.getContraseña();
		Pattern patron1 = Pattern.compile("^[\\S]{6,14}+$", Pattern.CASE_INSENSITIVE);
		Matcher pass = patron1.matcher(textoPass);

		if (!pass.find()) {
			JOptionPane.showMessageDialog(null, "Contraseña no valida");
		} else {
		}

	}
}