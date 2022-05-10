// Variables globales
var varBody = document.body; //body
var varDivTable = varBody.firstElementChild; // DIV Tabla
var varTabla = varDivTable.firstElementChild; // Tabla
var varTbody = varTabla.firstElementChild; // Tbody Tabla
var listaElem = varBody.firstElementChild.nextElementSibling.firstElementChild.nextElementSibling; // <ol> de la lista
var inputNombre = varTbody.firstElementChild.nextElementSibling.firstElementChild.firstElementChild; // input nombre
var inputColor = varTbody.firstElementChild.nextElementSibling.firstElementChild.nextElementSibling.firstElementChild; // input color
var selectPosicion = varTbody.firstElementChild.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.firstElementChild.firstElementChild; // select posicion
var selectPosicionFinal = varTbody.firstElementChild.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.firstElementChild.firstElementChild; // select posicion final

// 2. AÑADIR UN PARTICIPANTE CON UN COLOR ELEGIDO
// Función que extrae los valores del nombre y el color de dos inputs, crea un elemento "li", le añade el estilo de color del input,
// y lo añade a la lista de participantes
function addPart() {
    let nombre = inputNombre.value;
    let color = inputColor.value;
    let nuevoLi = document.createElement("li");
    listaElem.appendChild(nuevoLi);
    nuevoLi.style.color=color;
    nuevoLi.innerHTML=nombre;
    optionParticipantes();
}

// 3.  FINALIZAR COMPETICION
// Función que cambia el color de los participantes según su posición, el primero será verde, el segundo azul, el tercero naranja y
// el último rojo, hace un filtrado dependiendo del número de participantes. Antes de filtrar, hace un bucle para cambiar el color
// de todos los participantes a negro (Por si hubiera alguno con algun color establecido).
// Utiliza el querySelector para seleccionar la etiqueta li y almacenarlo en un array para trabajar con el
function finishComp() {
    let arrayLista = document.querySelectorAll("li");
    for (let i=0; i<arrayLista.length;i++){
        arrayLista[i].style.color = "black";
    }

    if (arrayLista.length === 1) {
        arrayLista[0].style.color = "green";
    } else if (arrayLista.length === 2) {
        arrayLista[0].style.color = "green";
        arrayLista[1].style.color = "red";
    } else if (arrayLista.length === 3) {
        arrayLista[0].style.color = "green";
        arrayLista[1].style.color = "blue";
        arrayLista[2].style.color = "red";
    } else {
        arrayLista[0].style.color = "green";
        arrayLista[1].style.color = "blue";
        arrayLista[2].style.color = "orange";
        arrayLista[3].style.color = "red";
    }
}

// 4. BORRAR PARTICIPANTE
// Funcion que primero almacena un array con la lista actual de participantes, y guarda la posición seleccionada en
// el select, he usado un select para que sea mas sencilla controlar los errores. Le resta un -1 a la selección ya que
// esta selección se muestra con un número más visualmente (Ya que el número de participantes empieza en el número 1, y el Array
// comienza en el número 0). Una vez hecho esto, elimina el elemento hijo de esta posición y vuelve a actualizar
// el select con la funcion optionParticipantes()
function delPart() {
    let arrayLista = document.querySelectorAll("li");
    let posicion = selectPosicion.value;
    let seleccion = arrayLista[posicion-1];
    listaElem.removeChild(seleccion);
    optionParticipantes();

}


// 5. MOVER PARTICIPANTE
// Función que mueve los participantes segun la posición seleccionada en el select "delParticipantes" para elegir el participante,
// y seleccionando la posicion final con el select "delParticipantesPosFin". Uso select de nuevo para poder controlar
// errores de seleccion de participantes por parte del usuario. 
// Se declara el array con la lista actual. Se guardan las variables con la posicion de los selects
// y se almacenan las posiciones inicial y final, (restando 1 ya que los participantes empiezan por 1 visualmente) a excepción
// de seleccionFinal2, ya que si la posición final es mayor a la inicial con el insertBefore no funcionaria.
// Si no creo una variable para cuando la posicion final es mayor, entonces, si selecciona 1 inicial y 3 final:
// listaElem.insertBefore(posicionInicial=0,posicionFinal=2) => El participante queda en posicion de array 1, participante nº2
// Para solucionar esto creo una variable selectorFinal2 en el que no resto -1:
// listaElem.insertBefore(posicionInicial=0,posicionFinal=3) => El participante queda en posicion de array 2, participante nº3
function movPart() {
    let arrayLista = document.querySelectorAll("li");
    // Seleccion del participante a mover
    let posicionInicial = selectPosicion.value;
    let seleccionInicial = arrayLista[posicionInicial-1];
    // Posicion donde se colocara
    let posicionFinal = selectPosicionFinal.value;
    let seleccionFinal = arrayLista[posicionFinal-1];
    // Variable extra para usar el insertBefore cuando la seleccion final es mayor a la inicial
    let seleccionFinal2  = arrayLista[posicionFinal];
    // Colocar
    // Si se ha seleccionado la posición 0...
    if (posicionFinal === "0") {
        listaElem.appendChild(seleccionFinal);
        // Si la seleccion final es menor a la seleccion inicial...
    } else  if (posicionFinal < posicionInicial) {
        listaElem.insertBefore(seleccionInicial,seleccionFinal);
        // Si no...
    } else {
        listaElem.insertBefore(seleccionInicial,seleccionFinal2);
    }
}


// 6. MODIFICAR PARTICIPANTE
// Usando un array de queryselector con la lista de li, y la posicion inicial del select mas el contenido del input nombre, sustituye el nombre del 
// participante seleccionado por un nombre nuevo
function modifyPart(){
    let arrayLista = document.querySelectorAll("li");
    let posicionInicial = selectPosicion.value;
    let seleccionInicial = arrayLista[posicionInicial-1];
    let nombre = inputNombre.value;

    // Remplazar
    let cambiaLi = document.createElement("li");
    listaElem.replaceChild(cambiaLi,seleccionInicial);
    cambiaLi.innerHTML=nombre;
}


// FUNCION EXTRA
// Funcion para el select de borrar participantes, he decidido usar un select porque de esta forma es mas sencillo
// controlar errores a la hora de seleccionar que participante borrar
// Usa el (i+1) para no mostrar el 0 y ser menos confuso a la hora de elegir el participante número 1, a la hora de
// borrarlo esto es controlado mediante un -1 en la funcion delPart()
var delParticipantes = document.getElementById("delParticipantes");
var delParticipantesPosFin = document.getElementById("delParticipantesPosFin")
function optionParticipantes() {
    let arrayLista = document.querySelectorAll("li");
    delParticipantes.innerHTML = "";
    delParticipantesPosFin.innerHTML = "";
    for (let i = 0; i < arrayLista.length; i++) {
        delParticipantes.innerHTML += "<option>" + (i+1) + "</option>"
        delParticipantesPosFin.innerHTML += "<option>" + (i+1) + "</option>"
    }
}














