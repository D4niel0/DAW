package actividadT09.vehiculos;

import java.util.Scanner;

public abstract class Vehiculo implements IAlquilable{

    private String matricula;
    private String modelo;
    private Integer plazas;
    private Integer dias = 0;
    private final Double precioDia = 50.0;

    /********************** CONSTRUCTORES **********************/
    public Vehiculo(String matricula, String modelo, Integer plazas, Integer dias) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.plazas = plazas;
        this.dias = dias;
    }

    /********************** GETTERS AND SETTERS **********************/
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getPlazas() {
        return plazas;
    }

    public void setPlazas(Integer plazas) {
        this.plazas = plazas;
    }

    public Integer getDias() {
        return dias;
    }

    public Double getPrecioDia() {
        return precioDia;
    }

    /********************** METODOS **********************/

    @Override
    public Double getPrecioTotalAlquilerPorDias() {
        Double precioTotal = this.dias*this.precioDia;
        System.out.println(this.dias*this.precioDia);
        return precioTotal;
    }

    public void pideDatos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce matricula");
        setMatricula(scanner.next());
        System.out.println("Introduce modelo");
        setModelo(scanner.next());
        System.out.println("Introduce plazas");
        setPlazas(scanner.nextInt());
        System.out.println("Introduce dias");
        setNumeroDias(scanner.nextInt());
    }

    @Override
    public void setNumeroDias(int num1) {
        this.dias = num1;
    }

    /********************** toString **********************/
    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + this.matricula + '\'' +
                ", modelo='" + this.modelo + '\'' +
                ", plazas=" + this.plazas +
                ", dias=" + this.dias +
                ", precioDia=" + this.precioDia +
                ", precio total=" + this.dias*this.precioDia +
                '}';
    }
}
