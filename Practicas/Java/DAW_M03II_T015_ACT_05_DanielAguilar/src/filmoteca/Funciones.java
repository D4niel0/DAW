package filmoteca;

public class Funciones {

	// Funcion que recibe por parametro el selector del combobox de directores, primero lo convierte en un String y lo almacena en una variable
	// Luego almacena en otra variable char el primer valor, por ultimo lo pasa a int y lo retorna
	public static int retornaNumDir(Object director) {
		String direNum;
		char caracter;
		int numero;
		direNum = (String)director;
		caracter = direNum.charAt(0);
		numero = Character.getNumericValue(caracter);
		return numero;
	}




}
