package actividad06;

import java.io.File;
import java.util.Scanner;

public class IOFunctions {
    // FUNCIONES
    /**********************/
    // MENU CON ARRAY
    public static void menu() {
        String[] muestraMenu;
        muestraMenu = new String[9];
        muestraMenu[0] = "**********************************************";
        muestraMenu[1] = "1. Crear un nuevo archivo";
        muestraMenu[2] = "2. Listar la carpeta 'archivos'";
        muestraMenu[3] = "3. Mostrar un archivo";
        muestraMenu[4] = "4. Borrar un archivo";
        muestraMenu[5] = "5. Renombrar un archivo";
        muestraMenu[6] = "6. Remplazar carácteres de un archivo";
        muestraMenu[7] = "0. Salir";
        muestraMenu[8] = "**********************************************";

        for (String opcion : muestraMenu) {
            System.out.println(opcion);
        }

    }
    /**********************/
    // INTRODUCIR NÚMERO ENTERO
    public static int introduceEntero(String preg) {
        Scanner scanner = new Scanner(System.in);
        int entero = 0;
        boolean salir = false;
        do {
            try {
                System.out.println(preg);
                entero = scanner.nextInt();
                salir = true;
            } catch (Exception excp1) {
                System.out.println("Carácter introducido invalido");
                scanner.next();
            }
        } while (!salir);
        return entero;
    }
    /**********************/
    /******* EXTRA ********/
    /**********************/
    // SELECCIONAR ARCHIVO
    // Función reutilizable para seleccionar un archivo. Se declara un Array de Files usando la funcion
    // de listarArchivos, y otra variable File para retornarla después.
    // A la hora de seleccionar uno de los archivos, dicha seleccion se almacena en el File archElegido, este
    // almacena el contenido del Array de la posición seleccionada por el usuario mediante la funcion introduceEntero()
    // Se usa el -1 ya que si el usuario elige la posición 1, no se leeria la posición 0 si no que se leeria la
    // posicion 1 del Array.
    public static File selecArch(String ruta) {
        // VARIABLES
        String preg = "Introduce un número de archivo";
        boolean salir = false;
        File[] archivos = FileFunctions.listarArchivos(ruta);
        File archElegido = new File(ruta);
        // PROGRAMA
        do {
            try {
                archElegido = (archivos[IOFunctions.introduceEntero(preg) - 1]);
                salir = true;
            } catch (ArrayIndexOutOfBoundsException excp2) {
                System.out.println("El archivo seleccionado no existe");
                salir = false;
            }
        } while (!salir);
        return archElegido;
    }
    /**********************/
    // INTRODUCIR CARACTERES
    // Función reutilizable para introducir caracteres y controlar que unicamente se introduzca una letra.
    // Recibe por parametros un caracter de tipo String, y una pregunta para poder reutilizar la función
    public static String introdCaracter (String caracter, String preg) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        do {
            System.out.println(preg);
            caracter = scanner.next();
            if (caracter.length() > 1) {
                System.out.println("Has introducido mas de un caracter, vuelve a introducirlo");
            } else {
                salir = true;
            }
        } while (!salir);
        return caracter;
    }

}
