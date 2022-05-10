package actividad07.ejercicio02;
;
import java.util.Scanner;

public class Heladeria {
    public static void main(String[] args) {
        // HORCHATA
        Horchata h1 = new Horchata("Horchata", 20.0, 2.5, 250.0, 30.0);
        // BOLAS
        SaborHelado s1 = new SaborHelado("Vainilla", 30.0, 1.0, 15.0, "Azúcar");
        SaborHelado s2 = new SaborHelado("Chocolate", 15.0, 1.0, 15.0, "Aspartamo");
        SaborHelado s3 = new SaborHelado("Cookies", 35.0, 1.0, 20.0, "Azúcar");
        SaborHelado s4 = new SaborHelado("Fresa", 10.0, 1.0, 5.0, "Aspartamo");
        SaborHelado s5 = new SaborHelado("Chicle", 10.0, 1.0, 5.0, "Aspartamo");

        // HELADOS
        SaborHelado[] heladoChocolate = {s1, s2};
        SaborHelado[] heladoGalleta = {s3, s4};
        Cucurucho c1 = new Cucurucho("Chocolate", 20.0, 1.0, heladoChocolate);
        Cucurucho c2 = new Cucurucho("Galleta", 25.0, 1.5, heladoGalleta);
        // COMIDA
        Comida o1 = new Comida("Cahuetes", 99.0, 1.5);

        // OTRAS VARIABLES
        boolean salir = false;
        String preg1 = "Elige una opción";

        // PEDIDO
        Comida[] pedido = {o1, h1, c1, c2};
        do {
            System.out.println("*************** PEDIDO ACTUAL ****************");
            for (int i = 0; i < pedido.length; i++) {
                System.out.println(i + "- " + pedido[i].toString());
            }
            menu();
            switch (pideEntero(preg1)) {
                case 1:
                    pedido = sustituir(pedido);
                    break;
                case 0:
                    System.out.println("Que aproveche!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;

            }
        } while (!salir);

    /********** PRUEBAS METODOS addBolaHelado y claculaPrecioTotal ************/
    /*
    // PRUEBAS PARA PROBAR LOS METODOS DE addBolaHelado() Y calculaPrecioTotal()
    // PRUEBA CAMBIO DE BOLA
    System.out.println("CAMBIO DE BOLA");
    c1.addBolaHelado(s5,1);
    for (int i = 0; i < pedido.length; i++) {
        System.out.println(i + "- " + pedido[i].toString());
    }

    // PRUEBA CALCULO DE PRECIO
    System.out.println("CALCULO DEL PRECIO DEL CUCURUCHO " + c1.getNombre());
    System.out.println(c1.calculaPrecioTotal() + "€");
    */

    }

    /******************* METODOS *******************/
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
        muestraMenu = new String[4];
        muestraMenu[0] = "**********************************************";
        muestraMenu[1] = "1. Sustituir un elemento por una Horchata";
        muestraMenu[2] = "0. Salir";
        muestraMenu[3] = "**********************************************";

        for (String opcion : muestraMenu) {
            System.out.println(opcion);
        }

    }

    // SUSTITUIR
    // Recibe por parámetro un Array con el pedido. Mediante consola, el usuario va introduciendo los parámetros de la
    // nueva horchata, usando la función de pideDouble, después se genera el nuevo objeto.
    // Por último le pide que elemento quiere sustituir mediante la funcion pideEntero, y lo sustituye si la posición
    // es correcta
    public static Comida[] sustituir(Comida[] pedido) {
        // VARIABLES PARA SUSTITUIR Y SALIR
        int opcion;
        boolean salir = false;
        // VARIABLES PARA CREAR
        Double kcal;
        Double precio;
        Double cantidad;
        Double chufa;
        String preg1 = "Introduce las kcal";
        String preg2 = "Introduce el precio";
        String preg3 = "Introduce la cantidad";
        String preg4 = "Introduce el porcentaje de chufa";
        // CREACIÓN
        System.out.println("***** Crear nueva horchata *****");
        kcal = pideDouble(preg1);
        precio = pideDouble(preg2);
        cantidad = pideDouble(preg3);
        chufa = pideDouble(preg4);
        Horchata h2 = new Horchata("Horchata", kcal, precio, cantidad, chufa);
        // SUSTITUCIÓN
        String preg = "Introduce el número del elemento que quieras sustituir";
        do {
            try {
                opcion = pideEntero(preg);
                pedido[opcion] = h2;
                salir = true;
            } catch (Exception em) {
                System.out.println("El artículo seleccionado no existe");
            }
        } while (!salir);

        return pedido;
    }


}
