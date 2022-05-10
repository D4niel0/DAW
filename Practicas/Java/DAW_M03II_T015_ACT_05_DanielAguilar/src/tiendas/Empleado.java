package tiendas;

import javax.persistence.*;

@Entity
public class Empleado {

    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    private String apellido;
    
    
    // CONSTRUCTOR
	public Empleado(long id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}


	// GETTERS AND SETTERS
	public long getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	// toString
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
}
