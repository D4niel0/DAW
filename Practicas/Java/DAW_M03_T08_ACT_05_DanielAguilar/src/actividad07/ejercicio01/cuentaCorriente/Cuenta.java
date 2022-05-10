package actividad07.ejercicio01.cuentaCorriente;

public class Cuenta {
    private String titular;
    private Integer numCuenta;
    private Double saldo;

    /********************** CONSTRUCTORES **********************/
    public Cuenta(String titular, Double saldo) {
        this.titular = titular;
        this.numCuenta = (int) Math.floor((Math.random()*(999))+1);
        this.saldo = saldo;
    }
    /********************** GETTERS AND SETTERS **********************/
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Integer getNumCuenta() {
        return numCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    /********************** METODOS **********************/
    public Double ingresaDinero(Double dinero) {
        return this.saldo += dinero;
    }
    public Double sacarDinero(Double dinero) {
        return this.saldo -= dinero;
    }
    /********************** toString **********************/
    @Override
    public String toString() {
        return "Cuenta: " +
                "Titular: '" + this.titular + '\'' +
                ", Número de cuenta: " + this.numCuenta +
                ", Saldo: " + this.saldo;
    }
}
