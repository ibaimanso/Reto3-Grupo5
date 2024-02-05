package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelobjeto.Cine;
import modelobjeto.Cliente;
import view.VistaPrincipal;

public class GestionBD {

	public GestionBD() {
		iniciarConexion();

	}

	private Connection conexion;

	// Conexion a la Base de Datos
	public void iniciarConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/cine",
			// "root", "");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/cinegrupo5", "root", "");

		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado la libreria");
		} catch (SQLException e) {
			System.out.println("Base de datos no encontrada");
		}

//		System.out.println("Conectando...");
//		System.out.println("Conexion establecida");

	}

	// Cierre de conexion a la base de datos

	public void cerrarConexion() {
		System.out.println("Cerrando...");
		try {
			if (!conexion.isClosed()) {
				conexion.close();
			}
		} catch (SQLException e) {
			System.out.println("No hay conexion con la Base de Datos");
		}
		System.out.println("Conexion cerrada");
	}

//	public void informacioncliente() {
//		// Query para sacar toda la info de los departamentos
//		try {
//			Statement consulta = conexion.createStatement();
//
//			String query = "SELECT * FROM cliente ";
//			ResultSet resultadoConsulta = consulta.executeQuery(query);
//			while (resultadoConsulta.next()) {
//				System.out.println(resultadoConsulta.getString(1) + "\t" + resultadoConsulta.getString(2) + "\t"
//						+ resultadoConsulta.getString(3) + resultadoConsulta.getString(4) + "\t"
//						+ resultadoConsulta.getString(5) + "\t");

//			}
//			consulta.close();

//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	// Insert de el panel de registro para poder registrar nuevos ususarios en
	// la Base de Datos de la aplicación

	public void insertUsuario(Cliente cliente, VistaPrincipal ventana) {

		// Query para sacar toda la info de los departamentos
		try {
			Statement consulta = conexion.createStatement();

			String insert = "INSERT INTO cliente ( DNI, Nombre, Apellido, Sexo, Contraseña) VALUES ('"
					+ cliente.getDni() + "','" + cliente.getNombrecli() + "','" + cliente.getApellido() + "', '"
					+ cliente.getSexo() + "', '" + cliente.getContraseña() + "')";

			consulta.executeUpdate(insert);
			JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
			ventana.cambiarDePanel(1);
			consulta.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Campos inválidos");
			ventana.cambiarDePanel(2);
		}

	}

	public boolean Login(String usuario, String contraseña) {
		boolean login = false;
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT * FROM clientes ";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				if (resultadoConsulta.getString(1).contentEquals(usuario)
						& resultadoConsulta.getString(5).contentEquals(contraseña)) {
					login = true;
				}

			}
			consulta.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		return login;

	}

	public ArrayList<Cine> buscarCines() {
		ArrayList<Cine> cines = new ArrayList<Cine>();
		Cine cine;
		try {
			Statement consulta = conexion.createStatement();
			String query = "SELECT * FROM cines";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				cine = new Cine(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3));
				cines.add(cine);
			}
			consulta.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cines;
	}

	/**
	 * Metodo para buscra un cliente en la base de datos
	 * 
	 * @param dni
	 * @return
	 */

	public Cliente buscarUsuario(String dni) {
		Cliente usuario = new Cliente();
		try {
			Statement consulta = conexion.createStatement();
			String query = "SELECT * FROM clientes cli where cli.DNI like '" + dni + "'";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				usuario = new Cliente(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getString(4), resultadoConsulta.getString(5));
			}
			consulta.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

}
