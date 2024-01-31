package logica;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import controlador.GestionBD;

import modelobjeto.Cliente;


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
	
	public void getnombreusaurio(String nombre) {
		ArrayList<Cliente> cliente;
		try {
			cliente = gestionBD.querynombre(nombre);
			if (cliente.isEmpty()) {
				System.out.println("no hay resultados");
			} else {
				for (int i = 0; i < cliente.size(); i++) {
					System.out.println(cliente.get(i));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void getcontraseñausaurio(String contraseña) {
		ArrayList<Cliente> cliente;
		try {
			cliente = gestionBD.querynombre(contraseña);
			if (cliente.isEmpty()) {
				System.out.println("no hay resultados");
			} else {
				for (int i = 0; i < cliente.size(); i++) {
					System.out.println(cliente.get(i));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
