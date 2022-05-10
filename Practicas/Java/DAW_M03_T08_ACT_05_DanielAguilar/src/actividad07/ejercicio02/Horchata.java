package actividad07.ejercicio02;

public class Horchata extends Comida {
    private Double cantidad;
    private Double chufa;

    /********************** CONSTRUCTORES **********************/
    public Horchata(String nombre, Double kcal, Double precio, Double cantidad, Double chufa) {
        super("Horchata", kcal, precio);
        this.cantidad = cantidad;
        this.chufa = chufa;
    }

    /********************** GETTERS AND SETTERS **********************/
    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getChufa() {
        return chufa;
    }

    public void setChufa(Double chufa) {
        this.chufa = chufa;
    }

    /********************** toString **********************/
    @Override
    public String toString() {
        return "nombre: " + super.getNombre() + ", " + super.getKcal() + "kcal, precio:" + super.getPrecio() +
                "€, cantidad:" + this.cantidad +
                ", chufa:" + this.chufa + "%";
    }
}
