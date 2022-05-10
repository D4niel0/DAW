package actividad05.operaciones.algebraicas;

public class Operaciones {
    //FUNCION QUE RECIBE POR PARÁMETRO UN DOUBLE Y RETORNA EL RESULTADO DE SU RAIZ CUADRADA
    public static Double muestraRaizCuadrada(double num1) {
        return Math.sqrt(num1);
    }

    // FUNCION PARA CALCULAR LA POTENCIA Y MOSTRAR EL RESULTADO
    public static void calculaPotencia(double num1, double elevadoA) {
        System.out.println(num1 + " elevado a " + elevadoA + " es: " + Math.pow(num1, elevadoA));
    }


}
