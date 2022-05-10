package actividad04;

import java.util.Scanner;

public class Ejercicio01 {
    /* NOTA: EL MAIN SE ENCUENTRA EN EL ARCHIVO EJECUCION.JAVA */
    /************************ FUNCIONES ************************/
    // 1. FUNCION QUE RETORNA UN NUMERO ENTERO QUE INTRODUCE EL USUARIO
    // Pide al usuario un entero y lo devuelve
    public static Integer pideEntero() {
        boolean salir = false;
        Integer entero = 0;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Introduce un número entero");
                entero = scanner.nextInt();
                salir = true;
            } catch (Exception exc1) {
                System.out.println("Valor introducido invalido, vuelve a intentarlo");
            }
        } while (!salir);
        return entero;
    }

    // 2. FUNCION QUE RETORNA UN NUMERO DECIMAL QUE INTRODUCE EL USUARIO
    // Pide al usuario un decimal y lo devuelve
    public static Double pideDouble() {
        boolean salir = false;
        double decimal = 0.0;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Introduce un número decimal");
                decimal = scanner.nextDouble();
                salir = true;
            } catch (Exception exc1) {
                System.out.println("Valor introducido invalido, vuelve a intentarlo");
            }
        } while (!salir);
        return decimal;
    }

    // 3. MENU
    // Muestra un menú y mediante la funcion pideEntero devuelve la opción seleccionada
    public static Integer menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("**********************************");
        System.out.println("Bienvenido! Selecciona una opción:");
        System.out.println("1. Conversor de euros a LINKIA_COINS");
        System.out.println("2. Calcular día de la semana");
        System.out.println("3. Realizar progresión numérica");
        System.out.println("4. Salir");
        opcion = pideEntero();
        return opcion;
    }

    /** OPCIONES DEL MENU **/
    /*** OPCION 1 ***/
    // OPCION 1: CONVERSOR DE EUROS A LINKIA_COINS
    // Pasandole un número decimal realiza una conversión multiplicando por 0.5 y devolviendo el resultado
    public static Double conversorEuroLinkia(double num1) {
        return num1 * 0.5;
    }

    /*** OPCION 2 ***/
    // OPCION 2: PEDIR NUMERO PARA DIA DE LA SEMANA
    // Pide un numero del 1 al 7 para usarlo en la funcion diaDeLaSemana devolviendo el número introducido
    public static Integer introduceDia() {
        int dia = 0;
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("Introduce un número del 1 al 7");
                dia = scanner.nextInt();
                if (dia >= 1 && dia <= 7) {
                    salir = true;
                } else {
                    System.out.println("Numero introducido invalido");
                }
            } catch (Exception diaSemana) {
                System.out.println("Valor introducido invalido");
                scanner.next();
            }
        } while (!salir);
        return dia;
    }

    // OPCION 2.1: CALCULAR EL DIA DE LA SEMANA
    // Usando la funcion introduceDia() indica que día de la semana se ha introducido y devuelve el resultado en string
    public static String diaDeLaSemana(int num1) {
        String dia = "Lunes";
        boolean salir = false;
        do {
            switch (num1) {
                case 1:
                    dia = "Lunes";
                    salir = true;
                    break;
                case 2:
                    dia = "Martes";
                    salir = true;
                    break;
                case 3:
                    dia = "Miércoles";
                    salir = true;
                    break;
                case 4:
                    dia = "Jueves";
                    salir = true;
                    break;
                case 5:
                    dia = "Viernes";
                    salir = true;
                    break;
                case 6:
                    dia = "Sabado, feliz fin de semana!";
                    salir = true;
                    break;
                case 7:
                    dia = "Domingo. feliz fin de semana!";
                    salir = true;
                    break;
            }
        } while (!salir);
        return dia;
    }

    /*** OPCION 3 ***/
    // Almacena en 2 variables los valores que retorna la funcion pideEntero, y después muestra la progresión descendente dependiendo de cual de los dos es mayor
    public static void progresionDescendente() {
        int num1 = 0;
        int num2 = 0;
        // Se introducen los dos numeros con las funciones y se almacenan en las variables num1 y num2
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                System.out.println("Numero " + i + ":");
                num1 = pideEntero();
            } else {
                System.out.println("Numero " + i + ":");
                num2 = pideEntero();
            }
        }
        // Se comprueba cual de los dos es mayor para hacer la progresión descendente, también filtra si los dos son iguales
        if (num1 > num2) {
            System.out.println("La progresión numérica es:");
            for (int i = num1; i >= num2; i--) {
                System.out.print(" " + i + " ");
            }
        } else if (num1 < num2) {
            for (int i = num2; i >= num1; i--) {
                System.out.print(" " + i + " ");
            }
        }
        else {
            System.out.println("Los dos números son iguales");
        }
        System.out.println();
    }
}
