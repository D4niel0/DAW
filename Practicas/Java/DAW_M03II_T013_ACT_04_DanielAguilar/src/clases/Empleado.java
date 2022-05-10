package clases;

import java.io.Serializable;
import java.util.ArrayList;


public class Empleado implements Serializable{

	private String nombre;
	private String edad;
	private String sexo;
	private ArrayList<String> aficiones = new ArrayList<String>();
	
	// CONSTRUCTOR
	public Empleado(String nombre, String edad, String sexo, ArrayList<String> aficiones) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.aficiones = aficiones;
	}
	
	// GETTERS AND SETTERS
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public ArrayList<String> getAficiones() {
		return aficiones;
	}
	public void setAficiones(ArrayList<String> aficiones) {
		this.aficiones = aficiones;
	}

	// toString
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", aficiones=" + aficiones + "]";
	}
	
}
