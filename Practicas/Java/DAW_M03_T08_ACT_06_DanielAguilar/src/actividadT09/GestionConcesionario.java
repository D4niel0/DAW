package actividadT09;

import actividadT09.seguros.Seguro;
import actividadT09.vehiculos.Carga;
import actividadT09.vehiculos.Coche;
import actividadT09.vehiculos.IAlquilable;
import actividadT09.vehiculos.Vehiculo;

public class GestionConcesionario {
    public static void main(String[] args) {
        // DECLARACIÓN DE OBJETOS Y ARRAYS
        Seguro[] seguros = new Seguro[2];
        seguros[0] = new Seguro("Seguritas","Todo riesgo",0);
        seguros[1] = new Seguro("Accidentes S.A","Terceros",0);

        Vehiculo[] flota = new Vehiculo[4];
        flota[0] = new Coche("1234-BCD","Coche volador",2,1,"A");
        flota[1] = new Coche("2345-CDB","Coche acuatico",5,1,"C");
        flota[2] = new Carga("7652-FGW","Super camión",2,1,5.0);
        flota[3] = new Carga("1789-RTB","Mini camión",2,1,2.0);

        IAlquilable[] alquiler = new IAlquilable[5];

        // OTRAS VARIABLES
        boolean salir = false;
        String preg1 = "Introduce una opción del menu";

        // PROGRAMA
        do {
            Utilidades.menu();
            switch (Utilidades.pideEntero(preg1)){
                case 1:
                    Utilidades.mostrarFlota(flota);
                    break;
                case 2:
                    Utilidades.mostrarSeguros(seguros);
                    break;
                case 3:
                    alquiler = Utilidades.alquiler(flota,seguros);
                    break;
                case 4:
                    alquiler = Utilidades.diasAlquiler(alquiler);
                    break;
                case 5:
                    Utilidades.mostrarAlquiler(alquiler);
                    break;
                case 0:
                    System.out.println("Gracias!!!");
                    salir = true;
                    break;
            }
        } while (!salir);
    }
}
