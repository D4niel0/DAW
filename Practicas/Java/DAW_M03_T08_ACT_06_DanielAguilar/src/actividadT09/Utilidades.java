package actividadT09;

import actividadT09.seguros.Seguro;
import actividadT09.vehiculos.IAlquilable;
import actividadT09.vehiculos.Vehiculo;

import java.util.Scanner;

public class Utilidades {

    /****** PEDIR NÚMEROS Y MENU ******/
    // PIDE UN NUMERO ENTERO PASANDOLE LA PREGUNTA POR PARAMETRO
    public static Integer pideEntero(String pregunta) {
        boolean salir = false;
        Integer entero = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println(pregunta);
                entero = scanner.nextInt();
                salir = true;
            } catch (Exception exc1) {
                System.out.println("Valor introducido invalido, vuelve a intentarlo");
                scanner.next();
            }
        } while (!salir);
        return entero;
    }

    // PIDE UN NUMERO DECIMAL PASANDOLE LA PREGUNTA POR PARAMETRO
    public static Double pideDouble(String pregunta) {
        boolean salir = false;
        double decimal = 0.0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println(pregunta);
                decimal = scanner.nextDouble();
                salir = true;
            } catch (Exception exc1) {
                System.out.println("Valor introducido invalido, vuelve a intentarlo");
                scanner.next();
            }
        } while (!salir);
        return decimal;
    }

    // MENU
    public static void menu() {
        String[] muestraMenu;
        muestraMenu = new String[8];
        muestraMenu[0] = "**********************************************";
        muestraMenu[1] = "1. Mostrar la información de la flota";
        muestraMenu[2] = "2. Mostrar la información de los seguros";
        muestraMenu[3] = "3. Reiniciar el alquiler indicando el total de vehiculos y seguros que se quiere alquilar";
        muestraMenu[4] = "4. Establecer el numero de días del alquiler";
        muestraMenu[5] = "5. Mostrar el alquiler";
        muestraMenu[6] = "0. Salir";
        muestraMenu[7] = "**********************************************";

        for (String opcion : muestraMenu) {
            System.out.println(opcion);
        }

    }

    /****** OPCIONES DEL MENU ******/
    // OPCION 1: MOSTRAR LA INFORMACIÓN DE LA FLOTA
    // Recibe por parámetro un array de Vehiculo, y lo pinta
    public static void mostrarFlota(Vehiculo flota[]) {
        System.out.println("--- Nuestra flota de vehiculos disponible ---");
        for (int i = 0; i < flota.length; i++) {
            System.out.println(i + "- " + flota[i].toString());
        }
    }

    // OPCION 2: MOSTRAR LA INFORMACIÓN DE LOS SEGUROS
    // Recibe por parámetro un array de Seguro, y lo pinta
    public static void mostrarSeguros(Seguro seguros[]) {
        System.out.println("--- Nuestros seguros disponibles ---");
        for (int i = 0; i < seguros.length; i++) {
            System.out.println(i + "- " + seguros[i].toString());
        }
    }

    // OPCION 3: REINICIAR EL ALQUILER
    // Recibe por parámetros los arrays de flota y de seguros. Pide la cantidad a añadir y si es mayor que 5, la vuelve
    // a pedir de nuevo. Después genera un Array donde almacenar la flota o seguros.
    // Con un bucle, se realiza el proceso para añadir al array "alquiler" los vehiculos o seguros, y por ultimo se retorna
    public static IAlquilable[] alquiler(Vehiculo flota[], Seguro seguros[]) {
        String preg1 = "Cuantos vehiculos o seguros quieres alquilar? (Máximo 5)";
        String preg2 = "Selecciona una opción";
        String preg3 = "Indica el número de vehiculo a añadir";
        String preg4 = "Indica el número de seguro a añadir";
        int cantidad;
        int opcion;
        boolean salir = false;

        do {
            cantidad = pideEntero(preg1);
            if (cantidad <= 5) {
                salir = true;
            } else {
                System.out.println("Cantidad introducida invalida, máximo 5 artículos");
            }
        } while (!salir);

        salir = false;
        IAlquilable[] alquiler = new IAlquilable[cantidad];

        for (int i = 0; i < alquiler.length; i++) {
            System.out.println("Proceso de alquiler, Alquilando el " + (i + 1) + " seguro o coche de " + (alquiler.length));
            do {
                System.out.println("1- Añadir un vehiculo al alquiler");
                System.out.println("2- Añadir un seguro al alquiler");
                try {
                    switch (pideEntero(preg2)) {
                        case 1:
                            mostrarFlota(flota);
                            opcion = pideEntero(preg3);
                            alquiler[i] = flota[opcion];
                            salir = true;
                            break;
                        case 2:
                            mostrarSeguros(seguros);
                            opcion = pideEntero(preg4);
                            alquiler[i] = seguros[opcion];
                            salir = true;
                            break;
                        default:
                            System.out.println("Opción introducida invalida");
                            break;
                    }
                } catch (Exception em) {
                    System.out.println("Opcion introducida invalida");
                    salir = false;
                }
            } while (!salir);
        }
        return alquiler;
    }

    // OPCION 4: ESTABLECER DIAS DE ALQUILER
    // Recibe por parámetros el array de alquiler. Pide la cantidad de dias, y comprueba que este entre 1 y 30.
    // Si lo está, modifica con el set los dias de cada posición del array y por último, lo retorna
    public static IAlquilable[] diasAlquiler(IAlquilable[] alquiler) {
        String preg1 = "Indica cuantos dias será el alquiler (Mínimo 1, máximo 30)";
        int opcion;
        boolean salir = false;
        do {
            opcion = pideEntero(preg1);
            if ((opcion >= 1) && (opcion <= 30)) {
                for (int i = 0; i < alquiler.length; i++) {
                    alquiler[i].setNumeroDias(opcion);
                }
                salir = true;
            } else {
                System.out.println("Cantidad introducida invalida");
            }
        } while (!salir);

        return alquiler;
    }

    // OPCION 5: MOSTRAR EL ALQUILER
    // Recibe por parámetro el array de alquiler, lo recorre y muestra su resultado
    public static void mostrarAlquiler(IAlquilable[] alquilado) {
        System.out.println("--- Este es el alquiler seleccionado ---");
        for (int i = 0; i < alquilado.length; i++) {
            System.out.println(i + "- " + alquilado[i].toString());
        }
    }


}