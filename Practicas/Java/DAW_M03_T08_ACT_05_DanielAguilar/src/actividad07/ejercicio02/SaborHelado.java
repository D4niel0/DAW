package actividad07.ejercicio02;

public class SaborHelado extends Comida {
    private Double grasa;
    private String edulcorante;

    /********************** CONSTRUCTORES **********************/
    public SaborHelado(String nombre, Double kcal, Double precio, Double grasa, String edulcorante) {
        super(nombre, kcal, precio);
        this.grasa = grasa;
        this.edulcorante = edulcorante;
    }

    /********************** GETTERS AND SETTERS **********************/
    public Double getGrasa() {
        return grasa;
    }

    public void setGrasa(Double grasa) {
        this.grasa = grasa;
    }

    public String getEdulcorante() {
        return edulcorante;
    }

    public void setEdulcorante(String edulcorante) {
        this.edulcorante = edulcorante;
    }

    /********************** toString **********************/
    @Override
    public String toString() {
        return "nombre: " + super.getNombre() + ", "
                + super.getKcal() + "kcal, " + "precio:" + super.getPrecio() +
                "€ grasa:" + this.grasa + ", edulcorante:" + this.edulcorante ;
    }
}
