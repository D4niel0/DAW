package funciones;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import clases.Empleado;
import clases.Usuarios;

public class Funcs {

	// Función Para crear archivo de datos de usuario de login
	public static void creaBaseDatos (File das_ruta,Usuarios das_usuario) throws IOException {
		ObjectOutputStream das_oos = new ObjectOutputStream (new FileOutputStream(das_ruta));
		das_oos.writeObject(das_usuario);
		das_oos.close();
	}
	
	
	// Fumcion para comprobar si el usuario y el password son correctos, si lo son devuelve true, si no
	// devuelve false. Recibe por parametros el usuario y password de los JTextFields
	public static boolean checking (String das_usuario, String das_pass) throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean das_resultado = false;
		String das_separador = File.separator;
		String das_rutaProyecto = System.getProperty("user.dir");
		File das_f = new File(das_rutaProyecto + das_separador + "archivos" + das_separador + "datos_login.txt");
		Usuarios das_acceso = new Usuarios();		
		ObjectInputStream das_ois = new ObjectInputStream (new FileInputStream(das_f));
		
		das_acceso = (Usuarios) das_ois.readObject();
		
		
		if (das_usuario.equals(das_acceso.getNombre()) && das_pass.equals(das_acceso.getPassword())) {
			das_resultado = true;
		}
		das_ois.close();
		return das_resultado;
	}

	// Funcion que comprueba si existe el archivo datos_empleados.txt, si existe retorna true, si no existe retorna false y lo crea
	public static boolean compruebaEmpleados () throws IOException {
		boolean resultado = true;
		String das_separador = File.separator;
		String das_rutaProyecto = System.getProperty("user.dir");
		File das_f = new File(das_rutaProyecto + das_separador + "archivos" + das_separador + "datos_empleados.txt");
		if (das_f.exists()) {
			resultado = true;
		} else {
			resultado = false;
			das_f.createNewFile();
		}
		return resultado;
	}

	// Funcion que crea un ArrayList con los empleados del archivo datos_empleados.txt, devuelve el arrayList
	public static ArrayList<Empleado> creaArrayList() throws ClassNotFoundException, IOException {
		String das_separador = File.separator;
		String das_rutaProyecto = System.getProperty("user.dir");
		File das_f = new File(das_rutaProyecto + das_separador + "archivos" + das_separador + "datos_empleados.txt");
		ArrayList<Empleado> nuevosEmpleados = new ArrayList<Empleado>();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(das_f));
		nuevosEmpleados = (ArrayList<Empleado>)ois.readObject();	
		ois.close();
		return nuevosEmpleados;
	}
	
	// Funcion serializar empleados
	public static void serializaEmpleados (ArrayList<Empleado> empleados) throws FileNotFoundException, IOException {
		String das_separador = File.separator;
		String das_rutaProyecto = System.getProperty("user.dir");
		File das_f = new File(das_rutaProyecto + das_separador + "archivos" + das_separador + "datos_empleados.txt");
		ObjectOutputStream das_oos = new ObjectOutputStream (new FileOutputStream(das_f));
		das_oos.writeObject(empleados);
		das_oos.close();
	}
	

	
}
