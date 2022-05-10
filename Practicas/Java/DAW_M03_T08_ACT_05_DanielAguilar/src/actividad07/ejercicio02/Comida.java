package actividad07.ejercicio02;

public class Comida {
    private String nombre;
    private Double kcal;
    private Double precio;

    /********************** CONSTRUCTORES **********************/
    public Comida(String nombre, Double kcal, Double precio) {
        this.nombre = nombre;
        this.kcal = kcal;
        this.precio = precio;
    }

    /********************** GETTERS AND SETTERS **********************/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getKcal() {
        return kcal;
    }

    public void setKcal(Double kcal) {
        this.kcal = kcal;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    /********************** toString **********************/
    @Override
    public String toString() {
        return "nombre: " + this.nombre + ", " +
                this.kcal + "kcal, precio:" + this.precio + "€";
    }
}
