package clases;

import java.io.Serializable;

public class Usuarios implements Serializable{

	private String nombre;
	private String password;
	
	public Usuarios(String nombre, String password) {
		super();
		this.nombre = nombre;
		this.password = password;
	}
	
	

	public Usuarios() {
		super();
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuarios [nombre=" + nombre + ", password=" + password + "]";
	}
	
	
	
}
