package logica;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import controlador.GestionBD;


public class GestionDeLaInformacion {

	private GestionBD gestionBD;
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
	
	
}
