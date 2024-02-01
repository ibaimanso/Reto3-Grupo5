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

	public void GestionBD() {
		iniciarConexion();

	}

	private Connection conexion;
	private GestionDeLaInformacion gestionINF;

	public void iniciarConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/grupo5prog", "root", "");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado la libreria");
		} catch (SQLException e) {
			System.out.println("Base de datos no encontrada");
		}
		System.out.println("Conectando...");
		System.out.println("Conexion establecida");

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


//		try {
//			Statement consulta = conexion.createStatement();
		String insert= "INSERT INTO cliente (dni, nombrecli, apellido, sexo, contraseña) VALUES (?, ?, ?, ?, ?)";

			try {
			    // Preparar la sentencia
			    PreparedStatement consulta = conexion.prepareStatement(insert);
			    
			    // Establecer los valores para los parámetros de la consulta
			    consulta.setString(1, cliente.getDni());
			    consulta.setString(2, cliente.getNombrecli());
			    consulta.setString(3, cliente.getApellido());
			    consulta.setString(4, cliente.getSexo());
			    consulta.setString(5, cliente.getContraseña());
			    
			    // Ejecutar la inserción
			    consulta.executeUpdate();
				JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
				ventana.cambiarDePanel(1);
				consulta.close();
			    
			    // Cerrar la conexión
			} catch (SQLException e) {
			    e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Campos inválidos");
				ventana.cambiarDePanel(2);

			    // Manejar la excepción apropiadamente
			}

//			String insert = "INSERT INTOcliente VALUES ('" + cliente.getDni() + "','"
//				+ cliente.getNombrecli() + "','" + cliente.getApellido() +"', '" + cliente.getSexo() + "', '" + cliente.getContraseña() + "')";


			
			//consulta.executeUpdate(insert);
		

		//} catch (Exception e) {
	
		}

	}

