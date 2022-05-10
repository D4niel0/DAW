package aplicacion;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import clases.Usuarios;
import funciones.Funcs;
import gui.VentanaLogin;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// INICIAR VENTANA DE LOGIN
		// He utilizado la sintaxis por defecto que me ha generado eclipse y la he exportado a una clase main aparte
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						VentanaLogin frame = new VentanaLogin();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		
		// Creo un usuario para usarlo como login	
			Usuarios usuario1 = new Usuarios("user","12345");
			
		// Variables para la ruta del File
			String separador = File.separator;
			String rutaProyecto = System.getProperty("user.dir");
			File f = new File(rutaProyecto+separador+"archivos"+separador+"datos_login.txt");
			if (!f.exists()) {
				f.createNewFile();
			}
			// TEST CASE
			// System.out.println(rutaProyecto+separador+"src"+separador+"archivos"+separador+"datos_login.txt");
		
		// Escribir un archivo con los datos de una clase				
			Funcs.creaBaseDatos(f,usuario1);
		
		/*		
		// TEST CASES CON EMPLEADOS
		// Creacion de un empleado
			ArrayList<String> aficciones = new ArrayList<String>();
			aficciones.add("Programar");
			aficciones.add("Cine");
			Empleado empleado1 = new Empleado("Dani","25-35","Hombre",aficciones);
			// System.out.println(empleado1);
		
		// Creacion de otro empleado y lista de empleados serializable para ejercicio 4.a
			ArrayList<String> aficciones1 = new ArrayList<String>();
			aficciones1.add("Deporte");
			Empleado empleado2 = new Empleado("Alicia","15-25","Mujer",aficciones1);
			
			
			// Creacion de archivo de empleados
			File f1 = new File(rutaProyecto+separador+"src"+separador+"archivos"+separador+"datos_empleados.txt");
			ArrayList<Empleado> aListEmpleados = new ArrayList<Empleado>();
			aListEmpleados.add(empleado1);
			aListEmpleados.add(empleado2);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f1));
			oos.writeObject(aListEmpleados);
			oos.close();
		*/ 
			
			
			
			
			
			
			
		}

	}

