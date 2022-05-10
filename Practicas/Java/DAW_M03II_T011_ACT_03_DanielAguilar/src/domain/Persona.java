package domain;

import exceptions.DniIncorrecto;
import exceptions.EdadIncorrecta;
import exceptions.NombreIncorrecto;

public class Persona {
    private String das_nombre;
    private int das_edad;
    private String das_dni;

    // CONSTRUCTOR
    public Persona(String das_nombre, int das_edad, String das_dni) {
        this.das_nombre = das_nombre;
        this.das_edad = das_edad;
        this.das_dni = das_dni;
    }

    public Persona() {
    }

    // GETTERS & SETTERS
    public String getDas_nombre() {
        return this.das_nombre;
    }

    public void setDas_nombre(String das_nombre) throws NombreIncorrecto {
    // Comprueba si el nombre tiene menos de 3 letras, si tiene menos de 3 arroja una excepcion
        if (das_nombre.length()<3){
            throw new NombreIncorrecto("El nombre debe tener minimo 3 letras");
        } else if (tieneNumeros(das_nombre) == true){
            // Comprueba si en el nombre hay numeros, para ello se ayuda de la funcion tieneNumeros()
            // si tiene arroja una excepcion
            throw new NombreIncorrecto("El nombre no puede tener dígitos");
        } else {
            this.das_nombre = das_nombre;
        }
    }

    public int getDas_edad() {
        return this.das_edad;
    }

    public void setDas_edad (int das_edad) throws EdadIncorrecta {
        // Comprueba si la edad es menor a 1 o mayor a 110, si es incorrecta arroja una excepcion
        if (das_edad<1 || das_edad>110){
            throw new EdadIncorrecta("La edad no puede ser menor a 1 ni mayor a 110");
        }else {
            this.das_edad = das_edad;
        }
    }

    public String getDas_dni() {
        return this.das_dni;
    }

    public void setDas_dni(String das_dni) throws DniIncorrecto {
        // Comprueba si el DNI tiene mas de 9 valores o menos de 9, si es incorrecto arroja una excepcion
        if (das_dni.length()>9 || das_dni.length()<9) {
            throw new DniIncorrecto(("El DNI ha de ser una String de 9 valores"));
        }
        this.das_dni = das_dni;
    }

    // toString

    @Override
    public String toString() {
        return "Persona{" +
                "das_nombre='" + this.das_nombre + '\'' +
                ", das_edad=" + this.das_edad +
                ", das_dni='" + this.das_dni + '\'' +
                '}';
    }

    // METODOS
    // Comprueba si el nombre tiene números, usa un booleano para guardar las respuestas.
    // pasa a un array de chars el String pasado por parámetro y lo recorre, comprueba si es un dígito, y si
    // lo es, devuelve el true de la variable das_b. Si termina la ejecución significa que en la cadena no tiene
    //  digitos asi que devuelve el false de la variable das_b
    public static boolean tieneNumeros(String cadena){
        boolean das_b = true;
        char[] das_v = cadena.toCharArray();
        for (int i = 0; i < das_v.length; i++) {
            if(Character.isDigit(das_v[i])){
                return das_b;
            }
        }
        das_b = false;
        return das_b;
        }
}
