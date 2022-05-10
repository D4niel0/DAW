package actividad07.ejercicio01.cuentaCorriente;

import java.util.Scanner;

public class TestCuenta {

    public static void main(String[] args) {
        // PREGUNTAS
        String preg1 = "Introduce una opción";
        // OTRAS VARIABLES
        boolean salir = false;
        // CREACIÓN DE CUENTAS
        Cuenta[] cuentas = new Cuenta[2];
        Cuenta c1 = new Cuenta("Daniel Aguilar",100.0);
        Cuenta c2 = new Cuenta("Goku",200.0);
        cuentas[0] = c1;
        cuentas[1] = c2;
        // MOSTRAR LAS CUENTAS DISPONIBLES
        Utilidades.muestraCuentas(cuentas);
        // MENU
       do {
           System.out.println("**********************************************");
           System.out.println("*********** Bienvenido al banco!! ************");
           Utilidades.menu();
           switch (Utilidades.pideEntero(preg1)) {
               case 1:
                   Utilidades.opcionMostrar(cuentas,Utilidades.selectorCuentas(cuentas));
                   break;
               case 2:
                   Utilidades.opcionIngresa(cuentas, Utilidades.selectorCuentas(cuentas));
                   break;
               case 3:
                   Utilidades.opcionSacar(cuentas, Utilidades.selectorCuentas(cuentas));
                   break;
               case 4:
                   Utilidades.opcionTransferencia(cuentas);
                   break;
               case 5:
                   Utilidades.muestraCuentas(cuentas);
                   break;
               case 0:
                   System.out.println("Gracias por usar el programa!");
                   salir = true;
                   break;
           }
       } while (!salir);
    }
}




