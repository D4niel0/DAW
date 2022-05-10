package actividad07.ejercicio02;


public class Cucurucho extends Comida {
    private SaborHelado[] saborHeladosBolas;

    /********************** CONSTRUCTORES **********************/
    public Cucurucho(String nombre, Double kcal, Double precio, SaborHelado[] saborHeladosBolas) {
        super(nombre, kcal, precio);
        this.saborHeladosBolas = new SaborHelado[2];
        this.saborHeladosBolas = saborHeladosBolas;
    }

    /********************** GETTERS AND SETTERS **********************/
    public SaborHelado[] getSaborHelados() {
        return saborHeladosBolas;
    }

    public void setSaborHelados(SaborHelado[] saborHelados) {
        this.saborHeladosBolas = saborHelados;
    }

    /********************** toString **********************/
    @Override
    public String toString() {


        return "nombre: " + super.getNombre() + ", " + super.getKcal() + "kcal, " + "precio:" + super.getPrecio() + "€" + "\n" + "\t" +
                 "bola0- " + this.saborHeladosBolas[0].toString() + "\n" + "\t" + "bola1- " + this.saborHeladosBolas[1].toString() ;
    }

    /********************** METODOS **********************/
    // AÑADIR BOLA NUEVA
    // Recibe por parámetros una bola de helado, y la posición. Asigna la bola a la posición introducida, si la posición es incorrecta,
    // muestra un error por pantalla
    public void addBolaHelado(SaborHelado bola, int posicion) {
        try {
            this.saborHeladosBolas[posicion] = bola;
        }catch (Exception em) {
            System.out.println("Posición invalida");
        }
    }
    // CALCULAR EL PRECIO TOTAL
    public Double calculaPrecioTotal() {
        Double suma = 0.0;
        for (int i = 0; i < this.saborHeladosBolas.length; i++) {
            suma += this.saborHeladosBolas[i].getPrecio();
        }
        return this.getPrecio()+suma;
    }

}
