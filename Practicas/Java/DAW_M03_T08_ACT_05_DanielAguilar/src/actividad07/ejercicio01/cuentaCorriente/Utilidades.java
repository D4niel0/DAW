package actividad07.ejercicio01.cuentaCorriente;

import java.util.Scanner;

public class Utilidades {

    // FUNCIONES

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
        muestraMenu[1] = "1. Consultar saldo";
        muestraMenu[2] = "2. Ingresar dinero";
        muestraMenu[3] = "3. Sacar dinero";
        muestraMenu[4] = "4. Hacer transferencia";
        muestraMenu[5] = "5. Mostrar de nuevo las cuentas disponibles";
        muestraMenu[6] = "0. Salir";
        muestraMenu[7] = "**********************************************";

        for (String opcion : muestraMenu) {
            System.out.println(opcion);
        }

    }

    /****** EXTRAS, REUTILIZABLES ******/
    // MUESTRA CUENTAS
    // Recibe un array por parametros y muestra las cuentas que hay disponibles para visualizarlas
    public static void muestraCuentas(Cuenta[] cuentas) {
        System.out.println("Cuentas disponibles: ");
        for (int i = 0; i < cuentas.length; i++) {
            System.out.println(cuentas[i].toString());
        }
    }

    // SELECTOR DE CUENTAS
    // Selector de cuentas reutilizable que recibe por Array las cuentas, pide el numero de cuenta y hace una búsqueda,
    // Si no la encuentra se repite, si la encuentra la devuelve
    public static int selectorCuentas(Cuenta[] cuentas) {
        boolean salir = false;
        int selector;
        int cuenta = -1;
        String preg1 = "Introduce el número de cuenta";
        do {
            selector = Utilidades.pideEntero(preg1);
            for (int i = 0; i < cuentas.length; i++) {
                if (cuentas[i].getNumCuenta() == selector) {
                    System.out.println("Encontrada");
                    cuenta = cuentas[i].getNumCuenta();
                    salir = true;
                }
            }
            if (cuenta == -1) {
                System.out.println("La cuenta introducida no existe");
            }

        } while (!salir);
        return cuenta;
    }


    /****** OPCIONES DEL MENU ******/
    // OPCIÓN 1. MOSTRAR EL SALDO
    // Recibe un array por parametro con las cuentas, y un numero de cuenta (Se usa la funcion selectorCuentas para esto)
    // Después recorre el Array y cuando encuentra la pantalla muestra el saldo
    public static void opcionMostrar(Cuenta[] cuentas, int num) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i].getNumCuenta() == num) {
                System.out.println("El saldo de la cuenta " + cuentas[i].getNumCuenta() + " es " + cuentas[i].getSaldo());
                break;
            }
        }
    }

    // OPCIÓN 2. INGRESAR DINERO
    // Recibe un array por parametro con las cuentas, y un numero de cuenta (Se usa la funcion selectorCuentas para esto)
    // Después recorre el array y cuando encuentra el número de cuenta recibido por parametro ingresa el dinero y sale
    public static void opcionIngresa(Cuenta[] cuentas, int num) {
        String preg2 = "Introduce el dinero que quieres ingresar";
        Double dinero;
        dinero = Utilidades.pideDouble(preg2);
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i].getNumCuenta() == num) {
                cuentas[i].ingresaDinero(dinero);
                System.out.println("Se han ingresado " + dinero + "€ en la cuenta");
                break;
            }
        }
    }

    // OPCION 3. SACAR DINERO
    // Recibe un array por parametro con las cuentas, y un numero de cuenta (Se usa la funcion selectorCuentas para esto)
    // Después recorre el array y cuando encuentra el número de cuenta recibido por parametro saca el dinero y sale
    public static void opcionSacar(Cuenta[] cuentas, int num) {
        String preg2 = "Introduce el dinero que quieres retirar";
        Double dinero;
        dinero = Utilidades.pideDouble(preg2);
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i].getNumCuenta() == num) {
                cuentas[i].sacarDinero(dinero);
                System.out.println("Se han sacado " + dinero + "€ en la cuenta");
                System.out.println("El saldo restante es: " + cuentas[i].getSaldo() + "€");
                break;
            }
        }
    }

    // OPCION 4. REALIZAR TRANSFERENCIA
    // Recibe un array por parámetro con las cuentas, y usando el selector de cuentas guarda en dos variables el
    // origen y el destino. Después recorre el Array para modificar con el getter el saldo
    public static void opcionTransferencia(Cuenta[] cuentas) {
        int num1;
        int num2;
        Double cantidad;
        String preg = "Selecciona la cantidad";

        System.out.println("Origen:");
        num1 = selectorCuentas(cuentas);
        System.out.println("Destino:");
        num2 = selectorCuentas(cuentas);
        cantidad = pideDouble(preg);
        for (int i = 0; i < cuentas.length; i++) {
            if (num1 == cuentas[i].getNumCuenta()) {
                cuentas[i].setSaldo(cuentas[i].getSaldo() - cantidad);
                System.out.println("Se han retirado " + cantidad + "€ de la cuenta " + cuentas[i].getNumCuenta());
            }
            if (num2 == cuentas[i].getNumCuenta()) {
                cuentas[i].setSaldo(cuentas[i].getSaldo() + cantidad);
                System.out.println("Se han ingresado " + cantidad + "€ en la cuenta " + cuentas[i].getNumCuenta());
            }
        }
    }
}
