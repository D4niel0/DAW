package tiendas;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Tienda {
	
    @Id
    @GeneratedValue
    private long id;
    private String direccion;
    private int ventas;
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval=true)
    private ArrayList<Empleado> empleados;
    
    // CONSTRUCTOR
	public Tienda(long id, String direccion, int ventas, ArrayList<Empleado> empleados) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.ventas = ventas;
		this.empleados = empleados;
	}

	// GETTERS AND SETTERS
	public long getId() {
		return id;
	}


	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getVentas() {
		return ventas;
	}

	public void setVentas(int ventas) {
		this.ventas = ventas;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	// toString
	@Override
	public String toString() {
		return "Tienda [id=" + id + ", direccion=" + direccion + ", ventas=" + ventas + ", empleados=" + empleados
				+ "]";
	}
    
}
