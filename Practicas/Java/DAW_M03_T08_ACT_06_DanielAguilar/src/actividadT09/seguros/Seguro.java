package actividadT09.seguros;

import actividadT09.vehiculos.IAlquilable;

public class Seguro implements IAlquilable {

    private String nomSeguro;
    private String nomDescrip;
    private final Double precioAlqu = 10.50;
    private Integer numDias = 1;

    /********************** CONSTRUCTORES **********************/
    public Seguro(String nomSeguro, String nomDescrip, Integer numDias) {
        this.nomSeguro = nomSeguro;
        this.nomDescrip = nomDescrip;
        this.numDias = numDias;
    }
    /********************** GETTERS AND SETTERS **********************/
    public String getNomSeguro() {
        return nomSeguro;
    }

    public void setNomSeguro(String nomSeguro) {
        this.nomSeguro = nomSeguro;
    }

    public String getNomDescrip() {
        return nomDescrip;
    }

    public void setNomDescrip(String nomDescrip) {
        this.nomDescrip = nomDescrip;
    }

    public Double getPrecioAlqu() {
        return precioAlqu;
    }

    public Integer getNumDias() {
        return numDias;
    }

    public void setNumDias(Integer numDias) {
        this.numDias = numDias;
    }


    /********************** METODOS **********************/
    @Override
    public void setNumeroDias(int num1) {
        this.numDias = num1;
    }

    @Override
    public Double getPrecioTotalAlquilerPorDias() {
        return null;
    }


    /********************** toString **********************/
    @Override
    public String toString() {
        return "Seguro '" + this.nomSeguro + '\'' +
                ", descripción='" + this.nomDescrip + '\'' +
                ", precio=" + this.precioAlqu +
                ", alquilado=" + this.numDias +
                ", total=" + this.numDias*this.precioAlqu;
    }
}
