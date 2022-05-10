// Ejercicio 6.
// CREACION DE LA CUENTA ATRAS DESDE 8 (EMPIEZA EN 9 PARA QUE APAREZCA EL 8 EN PANTALLA)
window.onload = function cuentaAtras() {
    // variables
    let cont = 9;   // variable contador
    let cuenta = document.getElementById("cuenta"); // elemento con id "cuenta"
    // intervalo usando la funcion numAtras cada 1 segundo 
    window.setInterval(numAtras,1000);

    // Funcion en la que si el contador es mayor que 0, resta 1. Al llegar a 0 cierra la ventana
    // El fondo va cambiando de color segun el intervalo
    function numAtras() {
        if (cont > 0) {
            cont=cont-1; cuenta.innerHTML = cont; 
            if (cont>5) {
                document.body.style.background = "green"};
            if (cont>3 && cont<=5) {
                document.body.style.background = "orange"};
            if (cont<=3) {
                document.body.style.background= "red";}
        }else {window.close()}
    }

}

// Ejercicio 7.
// VARIABLE QUE ALMACENA UN NUMERO ALEATORIO DE 0 A 10, TAMBIÉN MUESTRA EN LA MADRE POR CONSOLA EL NUMERO
let randomNum = Math.floor(Math.random()*11);
window.opener.console.log("Numero generado: "+ randomNum);

// Ejercicio 8.
// FUNCION PARA EL BOTON, ALMACENA EN UNA VARIABLE EL VALOR DEL INPUT Y LO COMPARA PARA INDICAR SI ES MENOR O MAYOR
// SI SE ACIERTA, MUESTRA UN MENSAJE DE ACERTADO, TAMBIÉN LO MUESTRA EN LA VENTANA MADRE, DESPUES SE CIERRA EN 2 SEGUNDOS
function suerte() {
    // Variables
    let contInput = document.getElementById("acierta").value; // contenido de input con id "acierta"
    let result = document.getElementById("resultado");  // elemento con id "cuenta"
    let textResult; // Almacenar el resultado para pasarlo como parametro
    // Comparador
    if (contInput == randomNum) {
        textResult = result.innerHTML="Acertaste!";
        window.opener.editaMadre(textResult);
        /* Ejercicio 9. */ window.setTimeout(function() {window.close()},2000);
    } else if (contInput > randomNum) {
        textResult = result.innerHTML="El número introducido es mayor";
        window.opener.editaMadre(textResult);
    } else {
        textResult = result.innerHTML="El número introducido es menor";
        window.opener.editaMadre(textResult);
    }
}



