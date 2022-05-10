package filmoteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionBBDD {

		private static String das_datosConexion ="jdbc:mysql://127.0.0.1:8889/";
		private static String das_baseDatos = "FILMOTECA";
		private static String das_usuario = "root";
		private static String das_password = "4246";
		private static Connection con;
		
		// CONSTRUCTOR BBDD
		public GestionBBDD(){
			try {
				con = DriverManager.getConnection(das_datosConexion, das_usuario, das_password);
				try {
					// CREO LA BASE DE DATOS SI NO EXISTE
					crearBDD();
					// CREO LA TABLA PELICULA SI NO EXISTE
					crearTablaPelicula();
					// CREO LA TABLA DIRECTOR SI NO EXISTE
					crearTablaDirector();
					// INSERTO PELICULAS
					insertarPelicula("Terminator",1,"EEUU",100,"Accion");
					insertarPelicula("ESDLA",2,"EEUU",180,"Fantasia");
					insertarPelicula("Torrente",3,"España",120,"Comedia");
					insertarPelicula("Otra Pelicula",4,"Francia",200,"Amor");
					insertarPelicula("Programadores",5,"Italia",120,"Drama");
					// INSERTO DIRECTORES
					insertarDirector("Dani","Aguilar");
					insertarDirector("Alicia","Revilla");
					insertarDirector("Marco","Polo");
					insertarDirector("Lolo","Perro");
					insertarDirector("Coco","Loco");
					// ACTUALIZAR RELACION
					updateRel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// **** CREACION DE BBDD **** //
		// CREAR BBDD
		private void crearBDD() throws Exception{
			String query = "create database if not exists "+ das_baseDatos +";";
			Statement stmt = null;
			try{
				stmt = con.createStatement();
				stmt.executeUpdate(query);
				con = DriverManager.getConnection(das_datosConexion+das_baseDatos, das_usuario, das_password);
			}catch (SQLException e){
				e.printStackTrace();
			}finally{
				stmt.close();
			}
		}
		
		
		// **** CREACION DE TABLAS **** //
		// TABLA PELICULA
		private void crearTablaPelicula() throws Exception {
			String query = "create table if not exists PELICULA("
					+ "Titulo VARCHAR(30), "
					+ "Director int, "
					+ "Pais VARCHAR(30),"
					+ "Duracion INTEGER,"
					+ "Genero VARCHAR(15));";
			Statement stmt = null;
			try{
				stmt = con.createStatement();
				stmt.executeUpdate(query);
			}catch (SQLException e){
				e.printStackTrace();
			}finally{
				stmt.close();
			}
		}
		
		//TABLA DIRECTOR
		private void crearTablaDirector() throws Exception {
			String query = "create table if not exists DIRECTOR("
					+ "id_director int PRIMARY KEY auto_increment,"
					+ "Nombre VARCHAR(50),"
					+ "Apellidos VARCHAR(100));";
			Statement stmt = null;
			try{
				stmt = con.createStatement();
				stmt.executeUpdate(query);
			}catch (SQLException e){
				e.printStackTrace();
			}finally{
				stmt.close();
			}
		}
		
		// **** INSERCCIONES **** //
		// PELICULAS
		public static void insertarPelicula(String titulo, int director, String pais, int duracion, String genero) throws SQLException{
			String query = "insert into PELICULA values('" + titulo + "', " + director + ", '" + pais + "', " + duracion + ", '" + genero + "')";
			Statement stmt = null;
			try {
				stmt = con.createStatement();
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stmt.close();
			}
		}
		
		// DIRECTOR
		public static void insertarDirector(String nombre, String apellido) throws SQLException{
			String query = "insert into DIRECTOR values(null, '" + nombre  + "', '" + apellido + "')";
			Statement stmt = null;
			try {
				stmt = con.createStatement();
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stmt.close();
			}
		}
		
		// **** ACTUALIZAR RELACION PELICULA-DIRECTORES **** //
		public void updateRel() throws SQLException{
			String query = "ALTER TABLE PELICULA ADD CONSTRAINT fk_pelicula_director foreign key (Director) references DIRECTOR(id_director);";
			Statement stmt = null;
			try {
				stmt = con.createStatement();
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stmt.close();
			}
		}
		
		// **** SELECT **** //
		// LISTAR DIRECTORES
		// Funcion que devuelve un array con la información de la tabla DIRECTOR
		public static ArrayList<String> listarDirectores() throws Exception {
			ArrayList<String> lista = new ArrayList<String>();
			String query = "select * from DIRECTOR;";
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = con.createStatement(); 
				rs = stmt.executeQuery(query); 
				while(rs.next()){
					lista.add(rs.getInt(1)+ " - " + rs.getString(2) + " " + rs.getString(3)); }
				} catch (SQLException e) { e.printStackTrace();
				} finally{
					rs.close();
					stmt.close(); }
			return lista; 
			}
		
		// LISTAR DIRECTORES SIN PELICULAS
		// Funcion que devuelve un array con la información de la tabla DIRECTOR de los directores que no tengan películas asignadas
		public static ArrayList<String> listarDirectoresSinPeliculas() throws Exception {
			ArrayList<String> lista = new ArrayList<String>();
			String query = "SELECT DIRECTOR.* FROM DIRECTOR WHERE DIRECTOR.id_director NOT IN (SELECT DIRECTOR FROM PELICULA);";
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = con.createStatement(); 
				rs = stmt.executeQuery(query); 
				while(rs.next()){
					lista.add(rs.getInt(1)+ " - " + rs.getString(2) + " " + rs.getString(3)); }
				} catch (SQLException e) { e.printStackTrace();
				} finally{
					rs.close();
					stmt.close(); }
			return lista; 
			}
		
	
		// LISTAR PELICULAS
		// Funcion que devuelve un array con la informacion de la tabla PELICULA unicamente con los titulos
		public static ArrayList<String> listarPeliculas() throws Exception {
			ArrayList<String> lista = new ArrayList<String>();
			String query = "select * from PELICULA;";
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = con.createStatement(); 
				rs = stmt.executeQuery(query); 
				while(rs.next()){
					lista.add(rs.getString(1)); }
				} catch (SQLException e) { e.printStackTrace();
				} finally{
					rs.close();
					stmt.close(); }
			return lista; 
			}
		
		
		// LISTAR GENEROS
		// Funcion que devuelve un array con la informacion de la tabla PELICULA unicamente con los generos
		public static ArrayList<String> listarGeneros() throws Exception {
			ArrayList<String> lista = new ArrayList<String>();
			String query = "select * from PELICULA;";
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = con.createStatement(); 
				rs = stmt.executeQuery(query); 
				while(rs.next()){
					lista.add(rs.getString(5)); }
				} catch (SQLException e) { e.printStackTrace();
				} finally{
					rs.close();
					stmt.close(); }
			return lista; 
			}
		
		

		// **** ELIMINAR **** //
		// BORRAR PELICULAS
		// Funcion que recibe por parametro el nombre de una película, y borra el registro que coincida con esta
		public static void delPelicula(String titulo) throws SQLException{
			String query = "DELETE FROM PELICULA WHERE Titulo='"+ titulo +"';";
			Statement stmt = null;
			try {
				stmt = con.createStatement();
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stmt.close();
			}
		}
		
		// BORRAR PELICULAS
		// Funcion que recibe por parametro el id de un director, y borra el registro que coincida con este
		public static void delDirector(int id) throws SQLException{
			String query = "DELETE FROM DIRECTOR WHERE id_director="+ id +";";
			Statement stmt = null;
			try {
				stmt = con.createStatement();
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stmt.close();
			}
		}
		
		// **** MODIFICAR **** //
		// MODIFICAR PELICULA
		// Funcion que recibe por parametro la seleccion, el nombre, director, pais, duracion y genero, para modificar una pelicula existente
		public static void modPelicula(String seleccion, String titulo, int director, String pais, int duracion, String genero) throws SQLException {
			String query = "UPDATE PELICULA SET Titulo='"+ titulo +"', Director="+ director + ", Pais='"+ pais + "', Duracion=" + duracion + ", Genero='" + genero + "' WHERE Titulo='"+seleccion+"';"; 
			Statement stmt = null;
			try {
				stmt = con.createStatement();
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stmt.close();
			}
		}
		
		// MODIFICAR PELICULA
		// Funcion que recibe por parametro el nombre, apellidos e id de un director y borra el que coincida con este
		public static void modDirector(String nombre, String apellidos, int id) throws SQLException {
			String query = "UPDATE DIRECTOR SET Nombre='"+ nombre +"', Apellidos='"+ apellidos + "' WHERE id_director=" + id + ";"; 
			Statement stmt = null;
			try {
				stmt = con.createStatement();
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stmt.close();
			}
		}		
}
