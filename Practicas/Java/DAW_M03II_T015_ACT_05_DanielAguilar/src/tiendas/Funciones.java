package tiendas;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Funciones {

	// Funcion para pedir un numero entero
    public static Integer pideEntero() {
        boolean salir = false;
        Integer entero = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                entero = scanner.nextInt();
                salir = true;
            } catch (Exception exc1) {
                System.out.println("Valor introducido invalido, vuelve a intentarlo");
                scanner.next();
            }
        } while (!salir);
        return entero;
    }
    
    // MENU
    public static void menu() {
        String[] muestraMenu;
        muestraMenu = new String[9];
        muestraMenu[0] = "**********************************************";
        muestraMenu[1] = "Introduzca la operacion a realizar del siguiente menú de opciones";
        muestraMenu[2] = "1. Muestra los empleados";
        muestraMenu[3] = "2. Muestra las tiendas";
        muestraMenu[4] = "3. Mostrar las tiendas ordenadas por ventas";
        muestraMenu[5] = "4. Modificar un empleado";
        muestraMenu[6] = "5. Añade una tienda";
        muestraMenu[7] = "0. Salir";
        muestraMenu[8] = "**********************************************";

        for (String opcion : muestraMenu) {
            System.out.println(opcion);
        }
    }
    
    
    // SELECTS
    // 1. Mostrar empleados
    public static void verEmpleados(EntityManager em) {
    	TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e", Empleado.class);

    	ArrayList<Empleado> empleados = (ArrayList<Empleado>) query.getResultList();
    	
    	for (Empleado e : empleados) {
    		System.out.println(e);
    		}
    }
    
    // 2. Mostrar tiendas
    public static void verTiendas(EntityManager em) {
    	TypedQuery<Tienda> query = em.createQuery("SELECT t FROM Tienda t", Tienda.class);

    	ArrayList<Tienda> tiendas = (ArrayList<Tienda>) query.getResultList();
    	
    	for (Tienda t : tiendas) {
    		System.out.println(t);
    		}
    }
    
    // 3. Mostrar tiendas por orden ascendente o descendente segun seleccion
    public static void verTiendasOrdenadas(EntityManager em) {
    	System.out.println("Ordenar segun ventas ascendentes o descendentes?");
    	System.out.println("1- Ascendente");
    	System.out.println("2- Descendente");
    	switch (pideEntero()) {
    		case 1 :
    			TypedQuery<Tienda> query1 = em.createQuery("SELECT t FROM Tienda t ORDER BY t.ventas ASC", Tienda.class);

    	    	ArrayList<Tienda> tiendas1 = (ArrayList<Tienda>) query1.getResultList();
    	    	
    	    	for (Tienda t1 : tiendas1) {
    	    		System.out.println(t1);
    	    		}
    	    	break;
    	   
    		case 2 :
    			TypedQuery<Tienda> query2 = em.createQuery("SELECT t FROM Tienda t ORDER BY t.ventas DESC", Tienda.class);

    	    	ArrayList<Tienda> tiendas2 = (ArrayList<Tienda>) query2.getResultList();
    	    	
    	    	for (Tienda t2 : tiendas2) {
    	    		System.out.println(t2);
    	    		}
    	    	break; 	   
    	}
    }
 
    // MODIFICAR EMPLEADOS
    // 4. Modificar un empleado
    public static void modEmpleado(EntityManager em, int id) {
    	Scanner scanner = new Scanner(System.in);
    	String nombre;
    	String apellido;
    	TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e WHERE e.id="+id, Empleado.class);
    	Empleado e1 = query.getSingleResult();
    	System.out.println("El empleado seleccionado es: " + e1.toString());
    	System.out.println("Indica el atributo a modificar:");
    	System.out.println("1- Nombre");
    	System.out.println("2- Apellido");
    	System.out.println("3- Ninguno");
    	
    	switch(pideEntero()) {
    		case 1:
    			em.getTransaction().begin();
    			System.out.println("Indica el nuevo nombre");
    			nombre = scanner.next();
    			e1.setNombre(nombre);
    			em.getTransaction().commit();
    	    	break;
    	    	
    		case 2:
    			em.getTransaction().begin();
    			System.out.println("Indica el nuevo apellido");
    			apellido = scanner.next();
    			e1.setApellido(apellido);
    			em.getTransaction().commit();
    	    	break;
    			
    		case 3:
    			break;
    	    	
    	}
    }
    
    
    // CREACION DE TIENDAS
    // 5. Crear una nueva tienda
    public static void nuevaTienda(EntityManager em) {
    try {
    	// Inicia la transaccion
    	em.getTransaction().begin();
    	// Variables
    	boolean salir = false;
    	Scanner scanner = new Scanner(System.in);
    	int idTienda;
    	String dire;
    	int ventas;
    	int id;
    	ArrayList<Empleado> listEmpleados = new ArrayList<Empleado>();
    	// Peticiones
    	System.out.println("Indica un id para la tienda");
    	idTienda = pideEntero();
    	System.out.println("Indica una direccion");
    	dire = scanner.next();
    	System.out.println("Indica las ventas");
    	ventas = pideEntero();
    	verEmpleados(em);
    	System.out.println("Indica el ID del empleado que quieras añadir a la tienda");
    	id = pideEntero();
    	// Busqueda del empleado para añadirlo al ArrayList
    	TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e WHERE e.id="+id, Empleado.class);
    	listEmpleados.add(query.getSingleResult());
    	System.out.println("Empleado añadido correctamente");
    	
    	do {
    		System.out.println("Quiere añadir otro empleado?");
    		System.out.println("1- Si");
    		System.out.println("2- No");
    	
    		switch (pideEntero()) {
    			case 1:
    				System.out.println("Indica el ID del empleado que quieras añadir a la tienda");
    		    	id = pideEntero();
    				query = em.createQuery("SELECT e FROM Empleado e WHERE e.id="+id, Empleado.class);
    		    	listEmpleados.add(query.getSingleResult());
    		    	System.out.println("Empleado añadido correctamente");
    				break;
    			case 2:
    				salir = true;
    				break;
    		}
    		
    	} while (!salir);
    	
    	// Crear tienda
    	Tienda nuevaTienda = new Tienda(idTienda,dire,ventas,listEmpleados);
    	// Commit
    	em.persist(nuevaTienda);
    	em.getTransaction().commit();
    	
    } catch (Exception e) {
    	System.out.println("El ID de tienda ya existe");
    }
   }
    
    
}


