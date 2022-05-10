package tiendas;

import java.util.ArrayList;

import javax.persistence.*;

public class GestionaTiendas {
	public static void main(String[] args) throws Exception {
		// Creacion de la BBDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:db/tiendasDB.tmp;drop");
        EntityManager em = emf.createEntityManager();
        
        // Inicio de transaccion
        em.getTransaction().begin();

        // Creacion de tres empleados
        Empleado empleado1 = new Empleado(1,"Daniel","Aguilar");
        Empleado empleado2 = new Empleado(2,"Alicia","Revilla");
        Empleado empleado3 = new Empleado(3,"Vin","Diesel");
        
        // Creacion de tres tiendas
        ArrayList<Empleado> listEmpleadost1 = new ArrayList<Empleado>();
        ArrayList<Empleado> listEmpleadost2 = new ArrayList<Empleado>();
        ArrayList<Empleado> listEmpleadost3 = new ArrayList<Empleado>();
        listEmpleadost1.add(empleado1);
        listEmpleadost2.add(empleado2);
        listEmpleadost3.add(empleado3);
        Tienda tienda1 = new Tienda(1,"Calle Pepe",1000,listEmpleadost1);
        Tienda tienda2 = new Tienda(2,"Calle Carlos",100,listEmpleadost2);
        Tienda tienda3 = new Tienda(3,"Calle Mayor",400,listEmpleadost3);
        
        // Insertar datos en la BBDD
        em.persist(tienda1);
        em.persist(tienda2);
        em.persist(tienda3);
        em.getTransaction().commit();

        // MENU
        boolean salir = false;
        do {
        	Funciones.menu();
	        switch(Funciones.pideEntero()) {
	        
	        	case 1:
	        		Funciones.verEmpleados(em);
	        		break;
	        	case 2:
	        		Funciones.verTiendas(em);
	        		break;
	        	case 3:
	        		Funciones.verTiendasOrdenadas(em);
	        		break;
	        	case 4:
	        		System.out.println("Introduce el ID del empleado a modificar: ");
	        		Funciones.modEmpleado(em, Funciones.pideEntero());
	        		break;
	        	case 5:
	        		Funciones.nuevaTienda(em);
	        		break;
	        	case 0:
	        		System.out.println("Gracias por usar el programa");
	        		salir = true;
	        		break;
	        			
	        }
        } while (!salir);
        
        
        
	}
}
