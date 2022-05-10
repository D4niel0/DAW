console.log("éste mensaje se muestra por consola");

var mensaje = " CUIDADO CON EL ORDEN ";

//accedemos al elemento con id "titulo" para que contenga el valor "TITULO MODIFICADO"
document.getElementById("titulo").innerHTML="TITULO MODIFICADO";

//accedemos al elemento con id "ordenCorrecto" para que contenga el valor "CUIDADO CON EL ORDEN" 
document.getElementById("ordenCorrecto").innerHTML=mensaje;

/**Al ejecutar la función saluda, introduce en #mensaje
 *  el valor pasado por parametro
 */
function saluda(texto){
    document.getElementById("mensa").innerHTML=texto;
}

