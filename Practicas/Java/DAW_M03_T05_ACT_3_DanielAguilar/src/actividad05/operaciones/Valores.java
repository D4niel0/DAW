package actividad05.operaciones;

public class Valores {
    // MUESTRA EL NUMERO PI
    public static void muestraPi() {
        System.out.println("El número PI es: " + Math.PI);
    }

    // MUESTRA VALOR ALEATORIO ENTRE 0 Y EL NUMERO INTRODUCIDO POR CONSOLA
    public static void muestraValorAleatorio(int maximo) {
        double aleatorio = Math.random() * maximo;
        System.out.println("Aquí tienes un numero aleatorio entre 0 y " + maximo + ": " + Math.round(aleatorio));
    }


}
