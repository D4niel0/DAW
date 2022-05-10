/*Pregunta 1.e
*Funcion que pida si del menu quiere 1-Ensalada 2-Tallarines 3-Arroz
 * y muestre la opcion seleecionada en el elemento con id "primero"
 * o que indique que no es una opcion valida
 */
function seleccionaPrimero() {


        //pide mediante  prompt el numero de opcion  del menu

    do {    
        var opcion = window.prompt("Qué quieres de primero?"
            + "\n 1-Ensalada" + "\n 2-Tallarines" + "\n 3-Arroz");
             
        opcion = parseInt(opcion);
        var texto;
   
        switch (opcion) {
            case 1:
                texto = "Ensalada";
                break;
            case 2:
                texto = "Tallarines";
                break;
            case 3:
                texto = "Arroz";
                break;
            default:
                texto = "No has escogido una opcion valida";
                //pregunta 2
                //forzamos a que opcion sea false para que repita el bucle
                opcion = false;
        }
    } while (opcion == false);
   
    document.getElementById("primero").value = texto;
}

/*Pregunta 2
2.	Programa que al clicar sobre el botón con el texto “Guarda el nombre”, 
extraiga el valor escrito dentro el INPUT con id “inputNombre” y lo muestre 
en el DIV con id “tuNombre”..*/

function guardaElNombre() {
    var nombre = document.getElementById("inputNombre").value;
    document.getElementById("tuNombre").innerHTML=nombre;
}