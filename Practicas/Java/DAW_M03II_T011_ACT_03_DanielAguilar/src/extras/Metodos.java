package extras;

import domain.Persona;
import exceptions.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Metodos {
    // PIDE UN NUMERO ENTERO PASANDOLE LA PREGUNTA POR PARAMETRO
    // Controla que no se introduce un valor diferente a un Integer y devuelve la seleccion
    // Recibe la pregunta por parámetro haciendolo reutilizable
    public static Integer pideEntero(String pregunta) {
        boolean das_salir = false;
        Integer das_entero = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println(pregunta);
                das_entero = scanner.nextInt();
                das_salir = true;
            } catch (Exception exc1) {
                System.out.println("Valor introducido invalido, vuelve a intentarlo");
                scanner.next();
            }
        } while (!das_salir);
        return das_entero;
    }

    // MOSTRAR MENU USANDO ARRAY Y RECORRIENDOLO
    public static void menu() {
        String[] das_muestraMenu;
        das_muestraMenu = new String[8];
        das_muestraMenu[0] = "************* Qué quieres hacer? *************";
        das_muestraMenu[1] = "1. Añadir una persona";
        das_muestraMenu[2] = "2. Borrar una persona";
        das_muestraMenu[3] = "3. Añadir persona al grupo de trabajo";
        das_muestraMenu[4] = "4. Quitar persona del grupo de trabajo";
        das_muestraMenu[5] = "5. Muestra los trabajadores y el grupo de trabajo";
        das_muestraMenu[6] = "0. Salir";
        das_muestraMenu[7] = "**********************************************";

        for (String das_opcion : das_muestraMenu) {
            System.out.println(das_opcion);
        }
    }

    // MOSTRAR TRABAJADORES Y GRUPOS DE TRABAJO
    // Mostrar trabajadores, recibiendo por parametro un HashMap y recorriendolo con un forEach
    public static void mostrarTrabajadores(HashMap<String, Persona> das_trabajadores){
        System.out.println("---Lista de trabajadores:---");
        das_trabajadores.forEach((k,v) -> System.out.println(k + " -   " + v.getDas_nombre() + " edad: " + v.getDas_edad()));
    }
    // Mostrar grupo de trabajo, recibiendo por parametro un ArrayList y recorriendolo con un for i
    public static void mostrarGrupo(ArrayList<Persona> das_grupo) {
        System.out.println("---Grupo de trabajo:---");
        for (int i = 0; i < das_grupo.size(); i++) {
            System.out.println("["+i+"]  " + das_grupo.get(i).getDas_nombre() + " " + "edad: " + das_grupo.get(i).getDas_edad());
        }
    }

    // CREAR TRABAJADOR
    // Este metodo va recogiendo datos para crear un nuevo objeto de persona. Cada dato esta controlado mediante
    // Un try catch, cuando se introduce un dato incorrecto, se arrojara el mensaje de su excepcion correspondiente
    // y volverá a solicitar el dato de nuevo
    public static Persona addTrabajador() {
        // VARIABLES Y CREACIÓN DEL OBJETO
        boolean das_salir = false;
        Scanner scanner = new Scanner(System.in);
        String das_nombre;
        String das_dni;
        Persona nueva = new Persona();
        int das_edad;

        // Introducir nombre
        System.out.println("Introduce nombre");
        do {
            das_nombre = scanner.next();
            try {
                nueva.setDas_nombre(das_nombre);
                das_salir = true;
            } catch (NombreIncorrecto ni){
                System.out.println(ni.getMessage()); // Mensaje de la excepcion
                System.out.println("Vuelve a introducirlo");
            }
        } while (!das_salir);

        // Introducir edad
        das_salir = false;
        do {
            das_edad = pideEntero("Introduce edad"); // Usando la funcion pideEntero controla el valor
            try {
                nueva.setDas_edad(das_edad);
                das_salir = true;
            } catch (EdadIncorrecta ei) {
                System.out.println(ei.getMessage()); // Mensaje de la excepcion
                System.out.println("Vuelve a introducirla");
            }
        } while (!das_salir);

        // Introducir DNI
        das_salir = false;
        System.out.println("Introduce DNI");
        do {
            das_dni = scanner.next();
            try{
                nueva.setDas_dni(das_dni);
                das_salir = true;
            } catch (DniIncorrecto di) {
                System.out.println(di.getMessage()); // Mensaje de la excepcion
                System.out.println("Vuelve a introducirlo");
            }
        } while (!das_salir);

        // Retorno de la persona
        return nueva;
    }

    // BORRAR TRABAJADOR
    // Recibe por parametro el HashMap. Pide por consola el DNI de la persona, y con el comprueba si esta en las Key
    // del HashMap, si esta lo borra, si no muestra un mensaje de que no existe
    public static void borrarTrabajador(HashMap<String,Persona> das_personaAnt) {
        Scanner scanner = new Scanner(System.in);
        String das_dni;
        System.out.println("Introduce el DNI de la persona");
        das_dni = scanner.next();
        if (das_personaAnt.containsKey(das_dni)) {
            das_personaAnt.remove(das_dni);
        } else {
            System.out.println("La persona no existe");
        }
    }

    // AÑADIR TRABAJADOR AL GRUPO DE TRABAJO
    // Metodo que recibe por parametro un ArrayList y un HashMap, después pide el DNI. Primero comprobara si se ha
    // alcanzado el maximo de trabajadores en el grupo, si es asi arroja la excepcion de DemasiadosObjetos.
    // Después comprueba si el trabajador existe, si no existe mostrara un mensaje.
    // Por último, añade el trabajador al grupo
    public static void addGroupTrabajador (ArrayList<Persona> das_grupo , HashMap<String, Persona> das_trabajadores) throws DemasiadosObjetos {
        Scanner scanner = new Scanner(System.in);
        String das_dni;
        System.out.println("Introduce el DNI de la persona");
        das_dni = scanner.next();
        if (das_grupo.size() > 1) {
            throw new DemasiadosObjetos("Se ha alcanzado el limite de trabajadores en el grupo de trabajo");
        } else if (!das_trabajadores.containsKey(das_dni)) {
            System.out.println("El trabajador no existe");
        } else {
            das_grupo.add(das_trabajadores.get(das_dni));
        }
    }

    // BORRAR UN TRABAJADOR DEL GRUPO DE TRABAJO
    // Metodo que recibe  un ArrayList, primero almacena en una variable de indice la posición controlada por
    // la función pideEntero. Si se ha introducido un valor permitido, comprueba si esta fuera del tamaño del ArrayList
    // En caso de estar mal, arroja la excepción PosicionIncorrecta.
    // Si no hay problemas, devuelve el indice para su tratamiento desde el main
    public static Integer borrarGroupTrabajador (ArrayList<Persona> das_grupo) throws PosicionIncorrecta {
        Integer das_indice;
        das_indice = pideEntero("Indica el indice de un trabajador para eliminarlo del grupo de trabajo");
        if (das_indice >= das_grupo.size() || das_indice < 0) {
            throw new PosicionIncorrecta("La posición indicada es incorrecta");
        }
        return das_indice;
    }
}
