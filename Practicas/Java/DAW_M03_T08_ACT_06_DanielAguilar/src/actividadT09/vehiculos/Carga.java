package actividadT09.vehiculos;

import actividadT09.Utilidades;

import java.util.Scanner;

public class Carga extends Vehiculo{
    Double PMA;

    /********************** CONSTRUCTORES **********************/
    public Carga(String matricula, String modelo, Integer plazas, Integer dias, Double PMA) {
        super(matricula, modelo, plazas, dias);
        this.PMA = PMA;
    }

    /********************** GETTERS AND SETTERS **********************/
    public Double getPMA() {
        return PMA;
    }

    public void setPMA(Double PMA) {
        this.PMA = PMA;
    }

    /********************** METODOS **********************/
    @Override
    public Double getPrecioTotalAlquilerPorDias() {
        double precPMA = this.PMA*1.5;
        double precioBase = this.getDias()*this.getPrecioDia();
        return precioBase+precPMA;
    }

    @Override
    public void pideDatos() {
        Double PMA=0.0;
        super.pideDatos();
        Scanner scanner = new Scanner(System.in);
        PMA= Utilidades.pideDouble("Introduce el PMA");
        setPMA(PMA);
    }

    /********************** toString **********************/
    @Override
    public String toString() {
        return "Vehiculo: " +
                "matricula='" + this.getMatricula() + '\'' +
                ", modelo='" + this.getModelo() + '\'' +
                ", plazas=" + this.getPlazas() +
                ", PMA=" + this.PMA +
                ", dias=" + this.getDias() +
                ", precio al dia=" + this.getPrecioDia() +
                ", precio total=" + getPrecioTotalAlquilerPorDias();
    }

}
