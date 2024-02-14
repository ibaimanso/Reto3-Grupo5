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
import modelobjeto.Compra;
import modelobjeto.Entrada;
import modelobjeto.LineaDeFactura;
import modelobjeto.Pelicula;
import modelobjeto.Sesion;
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
	//conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/basegrupo5", "root", "");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/cinegrupo5", "root", "");

		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado la libreria");
		} catch (SQLException e) {
			System.out.println("Base de datos no encontrada");
		}

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

			String insert = "INSERT INTO clientes ( DNI, Nombre, Apellido, Sexo, Contraseña) VALUES ('"
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

	public ArrayList<Pelicula> buscarPelis(String idCine) {
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		Pelicula pelicula;
		try {
			Statement consulta = conexion.createStatement();
			String query = "select pel.ID_Pelicula, pel.Nombre_Pelicula ,pel.Genero_Pelicula, pel.Duracion, pel.Precio, min(ses.Dia) as DiaMinimo, min(ses.Hora) HoraMinima from peliculas pel \r\n"
					+ "join sesiones ses on pel.ID_Pelicula = ses.ID_Pelicula\r\n"
					+ "join salas sal on ses.ID_Sala = sal.ID_Sala\r\n"
					+ "join cines cin on sal.ID_Cine = cin.ID_Cine\r\n" + "where cin.ID_Cine like '" + idCine + "'\r\n"
					+ "group by pel.ID_Pelicula\r\n" + "order by DiaMinimo asc, HoraMinima asc; ";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				pelicula = new Pelicula(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getInt(4), resultadoConsulta.getDouble(5));
				peliculas.add(pelicula);
			}
			consulta.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return peliculas;
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

	public ArrayList<String> buscarSesiones(int IDPelicula, String IDCine) {
		ArrayList<String> dias = new ArrayList<String>();
		try {
			Statement consulta = conexion.createStatement();
			String query = "select distinct ses.Dia\r\n" + "from cinegrupo5.peliculas pel \r\n"
					+ "join sesiones ses on pel.ID_Pelicula = ses.ID_Pelicula\r\n"
					+ "join salas sal on ses.ID_Sala = sal.ID_Sala\r\n"
					+ "join cines cin on sal.ID_Cine = cin.ID_Cine\r\n" + "where cin.ID_Cine like '" + IDCine
					+ "' and pel.ID_Pelicula = " + IDPelicula + " order by ses.Dia asc";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				dias.add(resultadoConsulta.getString(1));
			}
			consulta.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dias;
	}

	public ArrayList<Sesion> buscarSesionesPorFecha(int IDPelicula, String IDCine, String dia) {
		ArrayList<Sesion> sesiones = new ArrayList<Sesion>();
		Sesion sesion;
		try {
			Statement consulta = conexion.createStatement();
			String query = "select ses.ID_Sesion, ses.Hora, ses.Dia, ses.ID_Sala, ses.ID_Pelicula from peliculas pel \r\n"
					+ "join sesiones ses on pel.ID_Pelicula = ses.ID_Pelicula\r\n"
					+ "join salas sal on ses.ID_Sala = sal.ID_Sala\r\n"
					+ "join cines cin on sal.ID_Cine = cin.ID_Cine\r\n" + "where cin.ID_Cine like '" + IDCine
					+ "' and pel.ID_Pelicula = " + IDPelicula + " and ses.Dia like '" + dia + "'";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				sesion = new Sesion(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getString(4), resultadoConsulta.getInt(5));
				sesiones.add(sesion);
			}
			consulta.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sesiones;
	}

	public Sesion buscarSesion(int IDPelicula, String IDCine, String dia, String hora) {
		Sesion sesion = new Sesion();
		try {
			Statement consulta = conexion.createStatement();
			String query = "select ses.ID_Sesion, ses.Hora, ses.Dia, ses.ID_Sala, ses.ID_Pelicula from peliculas pel join sesiones ses on pel.ID_Pelicula = ses.ID_Pelicula join salas sal on ses.ID_Sala = sal.ID_Sala join cines cin on sal.ID_Cine = cin.ID_Cine where cin.ID_Cine like '"
					+ IDCine + "' and pel.ID_Pelicula = " + IDPelicula + " and ses.Dia like '" + dia
					+ "' and ses.Hora like '" + hora + "'";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				sesion = new Sesion(resultadoConsulta.getInt(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getString(4), resultadoConsulta.getInt(5));
			}
			consulta.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sesion;
	}

	public int buscarCompraMasAlta() {
		int id = 0;
		try {
			Statement consulta = conexion.createStatement();
			String query = "SELECT max(ID_Compra) FROM `compras`";
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				if (resultadoConsulta.getInt(1) == 0) {
					id = 0;
				} else {
					id = resultadoConsulta.getInt(1);
				}
			}
			consulta.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public double recogerPrecio(int id_sesion) {
		double precio = 0;
		try {
			Statement consulta = conexion.createStatement();
			String query = "SELECT pel.Precio FROM sesiones as ses JOIN peliculas as pel on pel.ID_Pelicula = ses.ID_Pelicula where ses.ID_Sesion = "
					+ id_sesion;
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				precio = resultadoConsulta.getDouble(1);
			}
			consulta.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return precio;
	}

	public int recogerIDPelicula(int id_sesion) {
		int iDPelicula = 0;
		try {
			Statement consulta = conexion.createStatement();
			String query = "SELECT ses.ID_Pelicula FROM sesiones as ses where ses.ID_Sesion = " + id_sesion;
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				iDPelicula = resultadoConsulta.getInt(1);
			}
			consulta.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return iDPelicula;

	}

	public LineaDeFactura devolverFacturas(int id_sesion) {
		LineaDeFactura lineaDeFactura = new LineaDeFactura();
		try {
			Statement consulta = conexion.createStatement();
			String query = "SELECT cin.Nombre_Cine, sal.ID_Sala, pel.Nombre_Pelicula, ses.Dia, ses.Hora FROM cines as cin JOIN salas as sal on sal.ID_Cine = cin.ID_Cine JOIN sesiones as ses on ses.ID_Sala = sal.ID_Sala JOIN peliculas as pel on pel.ID_Pelicula = ses.ID_Pelicula WHERE ses.ID_Sesion = "
					+ id_sesion;
			ResultSet resultadoConsulta = consulta.executeQuery(query);
			while (resultadoConsulta.next()) {
				lineaDeFactura = new LineaDeFactura(resultadoConsulta.getString(1), resultadoConsulta.getString(2),
						resultadoConsulta.getString(3), resultadoConsulta.getString(4), resultadoConsulta.getString(5));
			}
			consulta.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lineaDeFactura;
	}

	public void insertarCompra(Compra compraARealizar) {
		try {
			Statement consulta = conexion.createStatement();

			String insert = "INSERT INTO compras (PrecioTotal,CantidadEntradas,Descuento,PrecioDescontado,DNI_Cliente) VALUES ( "
					+ compraARealizar.getPrecioTotal() + ", " + compraARealizar.getCantodadEntradas() + ", "
					+ compraARealizar.getDescuento() + ", " + compraARealizar.getPrecioDescontado() + ", '"
					+ compraARealizar.getDNI_Cliente() + "')";

			consulta.executeUpdate(insert);
			consulta.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertarEntradas(ArrayList<Entrada> entradasCompradas) {
		try {
			Statement consulta = conexion.createStatement();
			for (int i = 0; i < entradasCompradas.size(); i++) {
				String insert = "INSERT INTO entradas (ID_Sesion, ID_Compra) VALUES ("
						+ entradasCompradas.get(i).getId_sesion() + ", " + entradasCompradas.get(i).getId_compra()
						+ ")";
				consulta.executeUpdate(insert);
			}
			consulta.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
