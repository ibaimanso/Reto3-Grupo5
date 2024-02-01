package logica;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

import controlador.GestionBD;
import modelobjeto.Cliente;
import view.VistaPrincipal;


public class GestionDeLaInformacion {
	

	private GestionBD gestionBD;
	ArrayList<String> datosUsuario = new ArrayList<String>();;

	

	
	private ObjetoManejoFicheros gestionFicheros;
private final String CLAVE_ENCRIPTACION = "clavecompartidanorevelarnuncamas";	
	public GestionDeLaInformacion() {
		gestionBD = new GestionBD();
		gestionFicheros = new ObjetoManejoFicheros();
	}


	public String desencriptar(String mensajeEncriptado) throws Exception {
		byte [] mensajeBytes =Base64.getDecoder().decode(mensajeEncriptado);
		Key claveAES = new SecretKeySpec(CLAVE_ENCRIPTACION.getBytes(),"AES");
		Cipher cipher =Cipher.getInstance("AES") ;
		cipher.init(Cipher.DECRYPT_MODE, claveAES);
		String desencriptado = new String(cipher.doFinal(mensajeBytes));
		return desencriptado ;
	}
//	public void recogerInformacionFormulario(Cliente cliente, VistaPrincipal ventana) {
//
//		String textoDNI = ;
//		Pattern patron = Pattern.compile("^[0-9]{8}[A-Z]$", Pattern.CASE_INSENSITIVE);
//		Matcher dni = patron.matcher(textoDNI);
//
//		if (!dni.find()) {
//			JOptionPane.showMessageDialog(null, "DNI no valido");
//		} else {
//			datosUsuario.add(dni.group());
//			
//		}
//		String textoNombre = nobreFormulario;
//		Pattern patron2 = Pattern.compile("^[a-z]+$", Pattern.CASE_INSENSITIVE);
//		Matcher nombre = patron2.matcher(textoNombre);
//
//		if (!nombre.find()) {
//			JOptionPane.showMessageDialog(null, "Nombre no valido");
//		} else {
//			
//		}
//
//		
//		String textoApellido = apellidoFormulario;
//		Pattern patron3 = Pattern.compile("^[a-z]+$", Pattern.CASE_INSENSITIVE);
//		Matcher apellido = patron3.matcher(textoApellido);
//
//		if (!apellido.find()) {
//			JOptionPane.showMessageDialog(null, "Apellido no valido");
//		} else {
//		}
//
//		String textoPass = ;
//		Pattern patron1 = Pattern.compile("^[\\S]{6,14}+$", Pattern.CASE_INSENSITIVE);
//		Matcher pass = patron1.matcher(textoPass);
//
//		if (!pass.find()) {
//			JOptionPane.showMessageDialog(null, "Contraseña no valida");
//		} else {
//		}
//
//	
//		
//
//		
//
//		gestionBD.insertUsuario(datosUsuario, ventana);
//	}
//	
//	
//	
}
