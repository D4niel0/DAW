package actividad06;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        // VARIABLES DE RUTA
        String separador = File.separator;
        String rutaProyecto = System.getProperty("user.dir");
        String carpetaArch = "archivos";
        String rutaCompletaCarp = rutaProyecto + separador + carpetaArch;
        // VARIABLES TIPO FILE
        File carpeta = new File(rutaCompletaCarp);
        // VARIABLES DE PREGUNTA
        String preg1 = "Introduce una opcion";
        // OTRAS VARIABLES
        Boolean salir=false;
        // CREACIÓN DE LA CARPETA ARCHIVOS POR SI NO EXISTIERA
        if (carpeta.exists()) {
            System.out.println("La carpeta '" + carpeta.getName() + "' existe por lo que no es necesario crearla");
        } else {
            carpeta.mkdir();
            System.out.println("Se ha creado la carpeta '" + carpeta.getName() + "'");
        }
        /*******************************************************************/

        // INICIO DEL PROGRAMA
        do {
        IOFunctions.menu();
        switch (IOFunctions.introduceEntero(preg1)){
            case 0:
                System.out.println("Gracias por usar el programa!");
                salir=true;
                break;
            case 1:
                FileFunctions.nuevoArchivo(rutaCompletaCarp,separador);
                break;
            case 2:
                File[] rutas = FileFunctions.listarArchivos(rutaCompletaCarp);
                System.out.println("Las rutas completas son: ");
                for (File rutaComp:rutas) {
                    System.out.println(rutaComp);
                }
                break;
            case 3:
                FileFunctions.mostrarArchivos(rutaCompletaCarp);
                break;
            case 4:
                FileFunctions.borrarArchivo(rutaCompletaCarp);
                break;
            case 5:
                FileFunctions.renombrarArchivo(rutaCompletaCarp,separador);
                break;
            case 6:
                FileFunctions.remplazarCaracteres(rutaCompletaCarp);
                break;
            default:
                System.out.println("Opción no disponible, vuelve a intentarlo");
                break;
        }

        } while (!salir);


    }



}
