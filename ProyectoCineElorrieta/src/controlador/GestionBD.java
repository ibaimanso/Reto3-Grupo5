package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import modelobjeto.Cliente;

public class GestionBD {

	private static Connection conexion;
	
	public GestionBD() {
		iniciarConexion();
	
	}
	
	
	public void iniciarConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/cine", "root","");
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
	public void informacioncliente() {
		// Query para sacar toda la info de los departamentos
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT * FROM cliente ";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				System.out.println(resultadoConsulta.getString(1) + "\t" + resultadoConsulta.getString(2) + "\t"
						+ resultadoConsulta.getString(3)+ resultadoConsulta.getString(4) + "\t"+ resultadoConsulta.getString(5) + "\t");
					
			}
			consulta.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}

	}
	
	public static boolean Login(String usuario, String contraseña) {
		boolean login = false;
		try {
			Statement consulta = conexion.createStatement();

			String query = "SELECT * FROM cliente ";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				if(resultadoConsulta.getString(1).contentEquals(usuario) & resultadoConsulta.getString(5).contentEquals(contraseña)) {
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
	public void  querynombre(String nombre)  {
		Cliente objeto = new Cliente ();

		// Statement / PreparedStatement

		String query = "SELECT nombre FROM cliente";

		PreparedStatement consulta = conexion.prepareStatement(query);

		ResultSet resultadoConsulta = consulta.executeQuery();

		String nombreusuario = "";
		boolean encontrado = false;
		while (resultadoConsulta.next() && !encontrado) {

			String nombreusu = resultadoConsulta.getString(1);
		
			

			if (nombre.contains(nombre)) {
				nombreusuario = nombreusu;
				encontrado = true;
			}
		}
		if (nombreusuario == null) {
			System.out.println("No se ha encontrado el  nombre de usuario");
		} else {
			query = "SELECT * FROM cliente";
			consulta = conexion.prepareStatement(query);
			resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				if (nombreusuario == resultadoConsulta.getString(1))

					cliente.add(new Cliente(resultadoConsulta.getString(1), resultadoConsulta.getString(4),
					resultadoConsulta.getString(1),resultadoConsulta.getString(1),resultadoConsulta.getString(1)
					));
			}
		}

		return cliente;
	}
	

	}
	
	
