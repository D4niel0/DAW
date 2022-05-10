package actividad05.introduceDatos;

import java.util.Scanner;

public class Pregunta {

    // FUNCIONES
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
}
