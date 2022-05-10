package actividadT09.vehiculos;

import java.util.Scanner;

public class Coche extends Vehiculo{
    String gama;

    /********************** CONSTRUCTORES **********************/
    public Coche(String matricula, String modelo, Integer plazas, Integer dias, String gama) {
        super(matricula, modelo, plazas, dias);
        this.gama = gama;
    }

    /********************** GETTERS AND SETTERS **********************/
    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    /********************** METODOS **********************/

    @Override
    public Double getPrecioTotalAlquilerPorDias() {
        double precPlazDias = (this.getPlazas()*1.5)*this.getDias();
        double precCocheDias = this.getDias()*this.getPrecioDia();
        return precCocheDias+precPlazDias;
    }

    @Override
    // Usa el pideDatos de la madre y añade la opción de introducir gama, si lo que se introduce no es ni A, B, C o D,
    // vuelve a pedir introducir la gama
    public void pideDatos() {
        String gama = "Z";
        boolean salir = false;
        super.pideDatos();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Introduce gama");
            gama = scanner.next();
            if (gama.equals("A") || gama.equals("B") || gama.equals("C") || gama.equals("D")) {
                setGama(scanner.next());
                salir = true;
            } else {
                System.out.println("Gama introducida invalida, caracteres validos: A, B, C y D");
            }
        } while (!salir);
    }

    /********************** toString **********************/
    @Override
    public String toString() {
        return "Vehiculo: " +
                "matricula='" + this.getMatricula() + '\'' +
                ", modelo='" + this.getModelo() + '\'' +
                ", gama='" + this.gama + '\'' +
                ", plazas=" + this.getPlazas() +
                ", dias=" + this.getDias() +
                ", precio al dia=" + this.getPrecioDia() +
                ", precio total=" + getPrecioTotalAlquilerPorDias();
    }
}
