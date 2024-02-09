package logica;

import java.security.Key;
import java.util.ArrayList;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import controlador.GestionBD;
import modelobjeto.Cine;
import modelobjeto.Cliente;
import modelobjeto.Compra;
import modelobjeto.Entrada;
import modelobjeto.LineaDeFactura;
import modelobjeto.Pelicula;
import modelobjeto.Sesion;
import view.VistaPrincipal;

public class GestionDeLaInformacion {

	private GestionBD gestionBD;
	private final String CLAVE_ENCRIPTACION = "clavecompartidanorevelarnuncamas";
	private Cliente usuario;
	private ArrayList<Cine> cine;
	private Cine cineSelecionado;
	private ArrayList<Pelicula> peliculas;
	private Pelicula peliculaSelecionada;
	private ArrayList<Sesion> sesiones;
	private String fecha;
	private String hora;
	private Sesion sesionElejida;
	private Compra compraARealizar;
	private ArrayList<Entrada> entradasCompradas;

	private ObjetoManejoFicheros gestionFicheros;

	public GestionDeLaInformacion() {
		gestionBD = new GestionBD();
		entradasCompradas = new ArrayList<Entrada>();
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

	public boolean testUsuarioYContraseña(String usuario, String contraseña) {
		boolean login = false;
		login = gestionBD.Login(usuario, contraseña);
		return login;
	}

	public ArrayList<Cine> devolverCines() {
		this.cine = gestionBD.buscarCines();
		return this.cine;
	}

	public void elegirCine(String nombre) {
		for (int i = 0; i < cine.size(); i++) {
			if (cine.get(i).getNombrecine().equalsIgnoreCase(nombre)) {
				cineSelecionado = cine.get(i);
			}
		}
	}

	public String sacarCine() {
		return cineSelecionado.getNombrecine();
	}

	public ArrayList<Pelicula> devolverPeliculas() {
		this.peliculas = gestionBD.buscarPelis(cineSelecionado.getId_cine());
		return this.peliculas;
	}

	public void elegirPelicula(Pelicula pelicula) {
		peliculaSelecionada = pelicula;
	}

	public Pelicula devolverPelicula() {
		return peliculaSelecionada;
	}

	public ArrayList<String> devolverSesiones() {
		return gestionBD.buscarSesiones(peliculaSelecionada.getIdpeli(), cineSelecionado.getId_cine());
	}

	public void elegirDia(String dia) {
		fecha = dia;
	}

	public ArrayList<Sesion> devolverSesionesPorDia() {
		this.sesiones = gestionBD.buscarSesionesPorFecha(peliculaSelecionada.getIdpeli(), cineSelecionado.getId_cine(),
				fecha);
		return this.sesiones;
	}

	public void elegirHora(String hora) {
		this.hora = hora;
	}

	public Sesion devolverSesionPorDiaYHora() {
		this.sesionElejida = gestionBD.buscarSesion(peliculaSelecionada.getIdpeli(), cineSelecionado.getId_cine(),
				fecha, hora);
		return this.sesionElejida;
	}

	public void guardarUsuario(String dni) {
		this.usuario = gestionBD.buscarUsuario(dni);
		compraARealizar = new Compra(gestionBD.buscarCompraMasAlta() + 1, usuario.getDni());
	}

	public String devolverNombreUsuario() {
		String respuesta = usuario.getNombrecli() + " " + usuario.getApellido();
		return respuesta;
	}

	public Integer devolverLongitudDeEntradas() {
		Integer longitudEntradas = entradasCompradas.size();
		return longitudEntradas;
	}

	public void añadirEntradas(int cantidad, Sesion sesionElegida) {
		for (int i = 0; i < cantidad; i++) {
			entradasCompradas.add(new Entrada(sesionElegida.getid_sesiones(), compraARealizar.getIDCompra()));
		}
	}

	public Compra calcularCompra() {
		double precioTotal = 0;
		ArrayList<Integer> contador = new ArrayList<Integer>();
		for (int i = 0; i < entradasCompradas.size(); i++) {
			precioTotal += gestionBD.recogerPrecio(entradasCompradas.get(i).getId_sesion());
			if (contador.size() == 0) {
				contador.add(Integer.valueOf(gestionBD.recogerIDPelicula(entradasCompradas.get(i).getId_sesion())));
			} else {
				for (int j = 0; j < contador.size(); j++) {
					if (gestionBD.recogerIDPelicula(entradasCompradas.get(i).getId_sesion()) != contador.get(j)
							.intValue()) {
						contador.add(
								Integer.valueOf(gestionBD.recogerIDPelicula(entradasCompradas.get(i).getId_sesion())));
					}
				}
			}
		}
		int cantidadDePeliculasDiferentes = contador.size();
		int descuento;
		if (cantidadDePeliculasDiferentes == 2) {
			descuento = 20;
		} else if (cantidadDePeliculasDiferentes >= 3) {
			descuento = 30;
		} else {
			descuento = 0;
		}
		int cantidadDeEntradas = entradasCompradas.size();
		double precioDescontado = (precioTotal * (100 - descuento)) / 100;
		compraARealizar.setPrecioTotal(precioTotal);
		compraARealizar.setCantodadEntradas(cantidadDeEntradas);
		compraARealizar.setDescuento(descuento);
		compraARealizar.setPrecioDescontado(precioDescontado);
		return compraARealizar;
	}

	public ArrayList<LineaDeFactura> devolverfactura() {
		ArrayList<LineaDeFactura> factura = new ArrayList<LineaDeFactura>();
		for (int i = 0; i < entradasCompradas.size(); i++) {
			LineaDeFactura lineadefactura = gestionBD.devolverFacturas(entradasCompradas.get(i).getId_sesion());
			factura.add(lineadefactura);
		}
		return factura;
	}

}
