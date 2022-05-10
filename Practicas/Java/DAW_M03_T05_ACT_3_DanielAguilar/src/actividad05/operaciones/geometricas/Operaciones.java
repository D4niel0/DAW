package actividad05.operaciones.geometricas;

public class Operaciones {
    // FUNCION PARA MOSTRAR EL SENO DE UN NUMERO DECIMAL INTRODUCIDO POR PARAMETRO
    public static void muestraSeno(double num1) {
        System.out.println("El seno de " + num1 + " es " + Math.sin(num1));
    }

    // FUNCION PARA MOSTRAR EL COSENO DE UN NUMERO DECIMAL INTRODUCIDO POR PARAMETRO
    public static double muestraCoseno(double num1) {
        return Math.cos(num1);
    }
}
