package actividad05.main;

import actividad05.introduceDatos.Pregunta;
import actividad05.operaciones.Valores;
import actividad05.operaciones.algebraicas.Operaciones;


public class Ejercicio01 {
    public static void main(String[] args) {
        boolean salir = false;
        String preg1 = "Introduce número de operación a realizar";
        String preg2 = "Introduce el máximo del número aleatorio con un número entero";
        String preg3 = "Introduce un número decimal para calcular su raiz cuadrada";
        String preg4 = "Primero, introduce un número decimal";
        String preg4_1 = "Ahora, introduce con otro decimal por cuanto lo quieres elevar";
        String preg5 = "Introduce un número decimal para calcular su seno";
        String preg6 = "Introduce un numero decimal para calcular su coseno";

        do {
            menu();
            switch (Pregunta.pideEntero(preg1)) {
                case 0:
                    System.out.println("Gracias por usar el programa");
                    salir = true;
                    break;
                case 1:
                    Valores.muestraPi();
                    break;
                case 2:
                    Valores.muestraValorAleatorio(Pregunta.pideEntero(preg2));
                    break;
                case 3:
                    System.out.println("La raiz cuadrada es: " + Operaciones.muestraRaizCuadrada(Pregunta.pideDouble(preg3)));
                    break;
                case 4:
                    Operaciones.calculaPotencia(Pregunta.pideDouble(preg4), Pregunta.pideDouble(preg4_1));
                    break;
                case 5:
                    actividad05.operaciones.geometricas.Operaciones.muestraSeno(Pregunta.pideDouble(preg5));
                    break;
                case 6:
                    double num1 = Pregunta.pideDouble(preg6);
                    double result = actividad05.operaciones.geometricas.Operaciones.muestraCoseno(num1);
                    System.out.println("El coseno de " + num1 + " es: " + result);
                    break;
                default:
                    System.out.println("La opción seleccionada no existe");
            }
        } while (!salir);

    }

    // FUNCIONES
    // MENU CON ARRAY
    public static void menu() {
        String[] muestraMenu;
        muestraMenu = new String[9];
        muestraMenu[0] = "**********************************************";
        muestraMenu[1] = "1. Muestra el número PI";
        muestraMenu[2] = "2. Muestra un valor aleatorio";
        muestraMenu[3] = "3. Calcular la raiz cuadrada";
        muestraMenu[4] = "4. Calcular el resultado de elevar un número";
        muestraMenu[5] = "5. Calcular el seno";
        muestraMenu[6] = "6. Calcular el coseno";
        muestraMenu[7] = "0. Salir";
        muestraMenu[8] = "**********************************************";

        for (String opcion : muestraMenu) {
            System.out.println(opcion);
        }

    }


}


