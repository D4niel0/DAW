package actividad04;

public class Ejecucion {

    public static void main(String[] args) {

        boolean salir = false;
        do {
            switch (Ejercicio01.menu()) {
                case 1:
                    System.out.println("El resultado es " + Ejercicio01.conversorEuroLinkia(Ejercicio01.pideDouble()));
                    break;
                case 2:
                    System.out.println("El día introducido es " + Ejercicio01.diaDeLaSemana(Ejercicio01.introduceDia()));
                    break;
                case 3:
                    Ejercicio01.progresionDescendente();
                    break;
                case 4:
                    System.out.println("Gracias por usar el programa!");
                    salir = true;
                    break;
                default:
                    System.out.println("La opción seleccionada no existe");
                    break;
            }
        } while (!salir);
    }
}
