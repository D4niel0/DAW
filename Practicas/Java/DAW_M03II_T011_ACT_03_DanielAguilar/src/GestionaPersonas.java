import domain.Persona;
import exceptions.*;
import extras.Metodos;
import java.util.ArrayList;
import java.util.HashMap;

public class GestionaPersonas {
    public static void main(String[] args) {

        // TEST
        // System.out.println("Daniel Aguilar Suarez");
        // Persona persona1 = new Persona("Dani",35,"49050958p");
        // Pinto el estado actual de la persona creada
        // System.out.println(persona1.toString());
        // Le añado un digito al nombre y compruebo la salida
        // persona1.setDas_nombre("Dan1a");
        // Le añado un 0 a la edad y compruebo la salida
        // persona1.setDas_edad(0);
        // Le añado mas de 9 digitos al DNI y compruebo la salida
        // persona1.setDas_dni("1234567890");
        // Añado datos nuevos correctos para comprobar que funciona correctamente
        // persona1.setDas_nombre("Alicia");
        // persona1.setDas_edad(24);
        // persona1.setDas_dni("49060948p");


        // DEFINIR HASHMAP
        HashMap<String,Persona> trabajadores = new HashMap<String,Persona>();
        Persona trabajador1 = new Persona("Dani",35,"12345678p");
        Persona trabajador2 = new Persona("Alicia",24,"87654321p");
        trabajadores.put(trabajador1.getDas_dni(),trabajador1);
        trabajadores.put(trabajador2.getDas_dni(),trabajador2);
        // TEST recorriendo hashmap
        // System.out.println("Daniel Aguilar Suarez");
        // trabajadores.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
        // trabajadores.forEach((k,v) -> System.out.println(k + " -   " + v.getDas_nombre() + " edad: " + v.getDas_edad()));

        //DEFINIR ARRAYLIST
        ArrayList<Persona> grupoTrabajo = new ArrayList<Persona>();
        // TEST añadiendo personas al grupo de trabajo y recorriendolo
        // grupoTrabajo.add(trabajador1);
        // grupoTrabajo.add(trabajador2);
        // for (int i = 0; i < grupoTrabajo.size(); i++) {
        //    System.out.println("grupoTrabajo = " + grupoTrabajo);
        //  }

        // VARIABLES
        boolean das_salir = false; // Usada para salir del bucle en el menu
        String das_preg1 = "Introduce un valor entre 0 y 4"; // Usada para el case
        // SELECCION
        do {
            // System.out.println("Daniel Aguilar Suarez");
            System.out.println("**********************************************");
            System.out.println("**************** Bienvenido ******************");
            Metodos.menu(); // Metodo menu muestra un array con todas las secciones
            switch (Metodos.pideEntero(das_preg1)) { // Metodo pideEntero es reutilizable, controla la inserccion de enteros
                case 1:
                    // Crea una nueva persona con el objeto recibido por el metodo addTrabajador
                    Persona nueva = Metodos.addTrabajador();
                    // Añade la nueva persona al HashMap
                    trabajadores.put(nueva.getDas_dni(),nueva); // Explicación en el metodo
                    Metodos.mostrarTrabajadores(trabajadores); // Explicación en el metodo
                    Metodos.mostrarGrupo(grupoTrabajo); // Explicación en el metodo
                    break;
                case 2:
                    // Borra una persona, se le pasa como parametro el HashMap
                    Metodos.borrarTrabajador(trabajadores); // Explicación en el metodo
                    Metodos.mostrarTrabajadores(trabajadores); // Explicación en el metodo
                    Metodos.mostrarGrupo(grupoTrabajo); // Explicación en el metodo
                    break;
                case 3:
                    // Añade un trabajador al grupo, uso try catch para controlarla desde el main
                    try {
                        Metodos.addGroupTrabajador(grupoTrabajo,trabajadores); // Explicación en el metodo
                    } catch (DemasiadosObjetos deOb) {
                        System.out.println(deOb.getMessage()); // Mensaje de la excepción
                    }
                    Metodos.mostrarTrabajadores(trabajadores); // Explicación en el metodo
                    Metodos.mostrarGrupo(grupoTrabajo); // Explicación en el metodo
                    break;
                case 4:
                    // Quita un trabajador del grupo, uso try catch para controlarlo desde el main
                    try {
                        int das_index = Metodos.borrarGroupTrabajador(grupoTrabajo); // Explicacion en el metodo
                        grupoTrabajo.remove(das_index); // Borrado del index recogido
                    } catch (PosicionIncorrecta pos) {
                        System.out.println(pos.getMessage()); // Mensaje de la excepción
                    }
                    Metodos.mostrarTrabajadores(trabajadores);
                    Metodos.mostrarGrupo(grupoTrabajo);
                    break;
                case 5:
                    // EXTRA: He añadido esta opción para mostrar directamente los trabajadores y facilitar las cosas
                    Metodos.mostrarTrabajadores(trabajadores);
                    Metodos.mostrarGrupo(grupoTrabajo);
                    break;
                case 0:
                    System.out.println("Gracias por usar el programa!");
                    das_salir = true;
                    break;
                default:
                    System.out.println("Opción introducida invalida");
            }
        } while (!das_salir);


        }
}
