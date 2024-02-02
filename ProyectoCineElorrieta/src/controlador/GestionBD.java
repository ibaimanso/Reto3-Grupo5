package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Registro;

import javax.swing.JOptionPane;

import logica.GestionDeLaInformacion;
import modelobjeto.Cliente;
import view.VistaPrincipal;

public class GestionBD {

	public GestionBD() {

		iniciarConexion();

	}

	private Connection conexion;
	private GestionDeLaInformacion gestionINF;

	public void iniciarConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/cine", "root", "");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado la libreria");
		} catch (SQLException e) {
			System.out.println("Base de datos no encontrada");
		}

	}

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
	public void insertUsuario(Cliente cliente, VistaPrincipal ventana) {

		iniciarConexion();

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
}
