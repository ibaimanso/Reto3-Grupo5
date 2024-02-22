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

/**
 * En la clase GestionBD nos encontraremos con metodos y ArrayList construidos
 * por querys de MySQL que recogen informacion de la base de datos para luego
 * llamar a estos metodos en otra clase, normalmente se les llamara en la clase
 * GestionDeLaInformacion
 */
public class GestionBD {

	public GestionBD() {
		iniciarConexion();

	}

	private Connection conexion;

	// Conexion a la Base de Datos
	public void iniciarConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/cinegrupo5", "root", "");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinegrupo5", "root", "");
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

	/**
	 * Metodo para insertar los datos del registro en la base de datos.
	 * 
	 * @param cliente
	 * @param ventana
	 */
	public void insertUsuario(Cliente cliente, VistaPrincipal ventana) {

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

	/**
	 * Metodo para el login. Comprueba si existe un usuario y contraseña que
	 * coincidan con lod datos de la tabla clientes en la base de datos.
	 * 
	 * @param usuario
	 * @param contraseña
	 * @return
	 */

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

	/**
	 * ArrayList para almacenar los Cines de la Base de Datos, hace uso de una query
	 * que saca el nombre de los cines de la tabla cines de la base de datos.
	 * 
	 */

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
	 * ArrayList para almacenar las Peliculas de la Base de Datos, hace uso de una
	 * query que saca el ID_Pelicula, Nombre_Pelicula, Genero_Pelicula, Duracion,
	 * Precio y fecha de varias tablas de la base de datos. A este ArrayList se le
	 * llamara para que en el panel de peliculas aparezcan las peliculas de el cine
	 * elegido
	 * 
	 */

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
	 * Metodo para buscar un cliente en la base de datos Hace uso de una query que
	 * saca el DNI del cliente que se ha loggeado y luego se utiliza para que en los
	 * labels que hay a lo largo de la aplicacion aparezca el nombre o DNI de la
	 * persona.
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

	/**
	 * ArrayList Para recoger los dias en los que se retansmiten las sesiones de las
	 * peliculas
	 * 
	 * @param IDPelicula
	 * @param IDCine
	 * @return
	 */
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

	/**
	 * Se crea el ArrayList buscarSesionesPorFecha para que recoga una sola sesion.
	 * 
	 * @param IDPelicula
	 * @param IDCine
	 * @param dia
	 * @return
	 */
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

	/**
	 * 
	 * Busca una sesión de pelicula en base a ciertos parametros. Mas tarde
	 * llamaremos a este metodo para que se puedan recoger las sesiones de las
	 * peliculas seleccionadas
	 * 
	 * @param IDPelicula
	 * @param IDCine
	 * @param dia
	 * @param hora
	 * @return
	 */

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

	/**
	 * Metodo para buscar la compra mas alta en la tabla de compras de la base de
	 * datos
	 * 
	 * @return
	 */

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

	/**
	 * Metodo para recoger el precio de cada pelicula de la base de datos para asi
	 * luego calcular el precio de nuestra compra de entradas
	 * 
	 * @param id_sesion
	 * @return
	 */
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

	/**
	 * Metodo para recoger el id de la pelicula seleccionada para que aparezca el
	 * dia en el que se retransmite la pelicula
	 * 
	 * @param id_sesion
	 * @return
	 */
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

	/**
	 * Metodo que recoge todo lo que queremos de la base de datos que aparezca en la
	 * factura al realizar la compra
	 * 
	 * @param id_sesion
	 * @return
	 */

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

	/**
	 * Metodo para insertar los datos de la compra realizada en la Base de datos
	 * 
	 * @param compraARealizar
	 */
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

	/**
	 * Metodo para insertar en la tabla entradas de la base de datos las entradas
	 * compradas
	 * 
	 * @param entradasCompradas
	 */
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
