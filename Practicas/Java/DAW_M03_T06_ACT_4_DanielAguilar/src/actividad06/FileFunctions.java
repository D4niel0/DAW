package actividad06;

import java.io.*;
import java.util.Scanner;

public class FileFunctions {
    // FUNCIONES CON EL TRATAMIENTO DE FICHEROS
    // OPCIÓN 1 - Crear archivo
    // Funcion que recibe por parametros la ruta de la carpeta archivos y el separador, pide un nombre para el archivo
    // y el texto a introducir, si el archivo no existe lo crea y muestra un mensaje
    public static void nuevoArchivo(String ruta, String separador) {
        Scanner scanner = new Scanner(System.in);
        String nombre, texto;
        System.out.println("Introduce un nombre para el nuevo archivo");
        nombre = scanner.next();
        System.out.println("Escribe contenido para añadir dentro del archivo");
        texto = scanner.next();
        // VARIABLE FILE RUTA Y SALIR
        File nuevoArch = new File(ruta + separador + nombre);
        boolean salir = false;
        // PROGRAMA
        do {
            try {
                if (nuevoArch.exists()) {
                    System.out.println("El archivo " + nuevoArch.getName() + " ya existe");
                    salir = true;
                } else {
                    FileWriter fw = new FileWriter(nuevoArch);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(texto);
                    bw.flush();
                    bw.close();
                    System.out.println("Archivo '" + nombre + "' creado");
                    salir = true;
                }
            } catch (Exception e) {
                System.out.println("El error es" + e.getMessage());
                System.out.println("El error es" + e.getStackTrace());
                salir = false;
            }
        } while (!salir);

    }

    /**************************************/
    // OPCIÓN 2 - Listar archivos
    // Funcion que recibe por parametros la ruta de la carpeta, almacena en un array de Files la lista de ficheros,
    // recorre dicho array y muestra sus nombres, después retorna las rutas completas
    public static File[] listarArchivos(String ruta) {
        File carpeta = new File(ruta);
        File[] archivos = carpeta.listFiles();
        int i = 0;
        System.out.println("Estos son los archivos que hay en " + ruta);
        for (File faux : archivos) {
            i++;
            System.out.println(i + ". " + faux.getName());
        }
        return archivos;

    }


    /**************************************/
    // OPCIÓN 3 - Mostrar archivo
    // Se declara una variable donde se almacena el resultado de la funcion selecArch.
    // Después se lee su contenido
    public static void mostrarArchivos(String ruta) {
        // VARIABLES
        boolean salir = false;
        // PROGRAMA
        do {
            try {
                File archElegido = (IOFunctions.selecArch(ruta));
                FileReader fr = new FileReader(archElegido);
                BufferedReader br = new BufferedReader(fr);
                System.out.println("El contenido de '" + archElegido.getName() + "' es el siguiente:");
                System.out.println(br.readLine());
                br.close();
                salir = true;
            } catch (Exception e) {
                System.out.println("el error es" + e.getMessage());
                System.out.println("el error es" + e.getStackTrace());
                salir = false;
            }
        } while (!salir);
    }

    /**************************************/
    // OPCIÓN 4 - Borrar archivo
    // Se declara una variable donde se almacena el resultado de la funcion selecArch.
    // Después lo borra
    public static void borrarArchivo(String ruta) {
        // VARIABLES
        boolean salir = false;
        // PROGRAMA
        do {
            File archElegido = (IOFunctions.selecArch(ruta));
            archElegido.delete();
            System.out.println("El archivo '" + archElegido.getName() + "' ha sido borrado");
            salir = true;
        } while (!salir);
    }

    /**************************************/
    // OPCIÓN 5 - Renombrar archivo
    // Recibe por parametros la ruta y el separador, se usa la funcion selecArch para seleccionar un archivo y
    // guardarlo en una variable. Después se pide al usuario el nuevo nombre y se comprueba si ese nombre ya existe,
    // y en caso de que no exista lo renombra y lo confirma por pantalla
    public static void renombrarArchivo(String ruta, String separador) {
        // VARIABLES
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        String nuevoNombre;
        // PROGRAMA
        File archElegido = (IOFunctions.selecArch(ruta));
        do {
            System.out.println("Elige un nuevo nombre para el archivo");
            nuevoNombre = scanner.next();
            File archivo = new File(ruta + separador + nuevoNombre);
            if (archivo.exists()) {
                System.out.println("El nombre elegido ya existe, elige otro");
            } else {
                archElegido.renameTo(archivo);
                System.out.println("El archivo '" + archElegido.getName() + "' ha sido renombrado a '" + archivo.getName() + "'");
                salir = true;
            }
        } while (!salir);
    }

    /**************************************/
    // OPCIÓN 6 - Remplazar caracteres de un archivo
    // Primero se declaran variables para los caracteres (de tipo String) y una variable Character auxiliar para
    // usarla en el bucle, además de variables de preguntas.
    // Después usando la funcion "selecArch" se selecciona el archivo, y con la funcion "introdCaracter" que retorna
    // una letra, se almacena en las variables String.
    // Por ultimo usando el RandomAccesFile se modifica la letra del puntero correspondiente donde se encuentre
    public static void remplazarCaracteres(String ruta) {
        // VARIABLES
        String antiguo = "a";
        String nuevo = "b";
        Character charaux;
        String preg1 = "Primero, elige que caracter quieres sustituir";
        String preg2 = "Ahora, introduce el caracter por el que quieres sustituirlo";

        // PROGRAMA
        File archElegido = (IOFunctions.selecArch(ruta));
        antiguo = IOFunctions.introdCaracter(antiguo, preg1);
        nuevo = IOFunctions.introdCaracter(nuevo, preg2);
        try {
            RandomAccessFile raf = new RandomAccessFile(archElegido, "rw");

            while (raf.getFilePointer() < raf.length()) {
                charaux = (char) raf.readByte();
                if (charaux == antiguo.charAt(0)) {
                    raf.seek(raf.getFilePointer() - 1);
                    raf.writeBytes(nuevo);
                }
            }
            raf.close();
        } catch (Exception e) {
            System.out.println("El fichero no existe");
        }

        System.out.println("El contenido de '" + archElegido.getName() + "' ha sido modificado");
    }
}

