/*******************************************/
/****** CLASES Y CREACIÓN DE OBJETOS *******/
/*******************************************/

// 2. CREACION DE LA CLASE EXTRA
// Tiene precio y URL de la imagen, además retorna el codigo HTML con la funcion getHTML
class Extra {
    nombre = "";
    precio = "";
    url = "";
    constructor(nombre, precio, url) {
        this.nombre = nombre;
        this.precio = precio;
        this.url = url;
    }
    // Funcion para pintar el codigo HTML de los extras. NOTA: He usado codigo para formar una tabla ya que he
    // "personalizado" un poco la práctica y lo he organizado en tablas
    getHTML = function () {
        return "<td>" + this.nombre + "</td><td><img src='" + this.url + "' class='extras'/></td><td>" + this.precio +
            " créditos" + "</td>"
    }
    // FUNCION EXTRA PARA TABLA
    // Uso esta funcion para poder gestionar la información que voy a mostrar en la tabla de Vehiculos
    getHTMLExtTabVeh = function () {
        return "[<img src='" + this.url + "' class='extrasVeh'/> " + this.precio + " crd ]"
    }
}

// 3. CREAR OBJETO Y VALIDAR
// Nota: He añadido el nombre y he cambiado el nombre de extra por el nombre del articulo, ademas de agregar todo
// En la misma linea incluyendo el precio. El push a Extras disponibles lo hago en el punto 6
console.log("*** Validación  EJERCICIO 3 ***")
var acelerador = new Extra("Acelerador", "20000", "img/Acelerador.jpg");
console.log(acelerador.getHTML());
console.log("******************")

// 6. CREAR UN ARRAY DONDE ALMACENAR EL EXTRA ANTERIOR Y UNO NUEVO
var extrasDisponibles = new Array();
extrasDisponibles.push(acelerador);
// Añadir nuevo extra
var bombaRef = new Extra("Refrigerante", "1000", "img/Refrigerante.jpg");
extrasDisponibles.push(bombaRef);
// Añado algunos mas
var compresor = new Extra("CompresorZX19", "500", "img/CompresorZX19.jpg");
extrasDisponibles.push(compresor);
var cabina = new Extra("Cabina", "2800", "img/Cabina.jpg");
extrasDisponibles.push(cabina);

// 4. CREAR UNA CLASE Y OBJETO DE TIPO VEHICULO (Nota: Pone coche en el enunciado, pero lo he cambiado para adecuarlo
// al estilo que he utilizado)
class Vehiculo {
    nombre = "";
    velocidad = 0;
    extras = [];
    constructor(nombre, velocidad) {
        this.nombre = nombre;
        this.velocidad = velocidad;
    }
    // Añadir un extra, recibe por parametro el extra y lo añade a la última posición del array de la clase
    addExtra = function (extraNuevo) {
        this.extras.push(extraNuevo);
    }
    // Devuelve un codigo HTML con toda la información del vehiculo, usa la funcion recorre() para pintar
    // los datos de todos los extras
    getHtmlVehiculo = function () {
        return "<tr><td>" + this.nombre + "</td><td>" + this.velocidad
            + " años luz</td>" + this.recorre() + "</tr>"
    }
    // Recorre el array de extras para pintarlo en getHtmlVehiculo, ejecuta la funcion getHTML y lo almacena en la variable, 
    // luego la devuelve
    recorre = function () {
        let texto = "";
        for (let i = 0; i < this.extras.length; i++) {
            texto += this.extras[i].getHTML();
        }
        return texto
    }
    // FUNCION EXTRA PARA TABLA
    // Uso estas funciones para poder gestionar la información que voy a mostrar en la tabla de vehiculos, al mostrar
    // los extras de manera diferente en esa tabla necesito usar una nueva funcion para recorrer el getHTMLExtTabVeh
    // de la clase de Extras
    getHtmlVehTab = function () {
        return "<tr><td>" + this.nombre + "</td><td>" + this.velocidad
            + " años luz</td><td>" + this.recorreExtTab() + "</td></tr>"
    }
    recorreExtTab = function () {
        let texto = "";
        for (let i = 0; i < this.extras.length; i++) {
            texto += this.extras[i].getHTMLExtTabVeh();
        }
        return texto
    }
}

// 5. CREAR UN VEHICULO, AÑADIRLE UN EXTRA Y MOSTRARLO POR CONSOLA
console.log("*** Validación  EJERCICIO 5 ***")
var xwing = new Vehiculo("X-Wing", 1000);
xwing.addExtra(acelerador)
console.log(xwing.getHtmlVehiculo());
console.log("******************")

/*******************************************/
/***************** WEB *********************/
/*******************************************/

// 7. MOSTRAR LOS EXTRAS EN LA WEB
// Usa la funcion mostrarExtras e inyecta el HTML en la tabla con id extras_disponibles cuando carga la web
// Usa la funcion optionExtra para mostrar los indices de extras en las opciones de la tabla de añadir extras a un vehiculo
// Usa la funcion optionVeh para mostrar los vehiculos disponibles en las opciones de la tabla de añadir extras a un vehiculo
var divExtras = document.getElementById("extras_disponibles");
var divVehiculosDisponibles = document.getElementById("vehiculos_disponibles");
window.onload = function mostrarExtras() {
    muestraArray(extrasDisponibles);
    optionExtra(extrasDisponibles);
    optionVeh(vehiculosDisponibles);
    // 9. MOSTRAR VEHICULOS DISPONIBLES EN LA WEB
    // Usa la funcion mostrarVehiculos para mostrar la lista de vehiculos disponibles al cargar la web
    mostrarVehiculos(vehiculosDisponibles);
}


// 8. ARRAY ASOCIATIVO
// Creamos un array asociativo vehiculosDisponibles al que le añadimos una propiedad por nombre de vehiculo enlazada a su vehiculo
// Añadimos el X-Wing
var vehiculosDisponibles = new Object();
vehiculosDisponibles[xwing.nombre] = xwing;  // X-Wing : Object


// 10. FORMULARIO PARA AGREGAR NUEVOS EXTRAS
// La funcion guarda el contenido del input y del select, luego crea un objeto con la información recopilada
// Por ultimo, añade con un .push el objeto y lo muestra en la tabla, ademas de actualizar el select de extras de los coches
function botonExtras() {
    var contInputExtras = document.getElementById("inputPrecioExtra").value; // PRECIO
    var selectExtras = document.getElementById("selectExtra").value; // NOMBRE EXTRA
    var nuevoExtra = new Extra(selectExtras, contInputExtras, "img/" + selectExtras + ".jpg")
    extrasDisponibles.push(nuevoExtra);
    divExtras.innerHTML += nuevoExtra.getHTML(); // Se agrega a la tabla de Extras
    // Actualiza el select desde donde añadir extras a los coches
    optionExtra(extrasDisponibles);
}

// 11. FORMULARIO BORRAR EXTRAS
function botonBorrarExtras() {
    // Variable que contiene el contenido del input "inputBorrarExtra"
    var contInputBorrarExtras = document.getElementById("inputBorrarExtra").value;
    // Usando el contenido del input, coloca el index en la posición indicada, y borra 1 elemento
    extrasDisponibles.splice(contInputBorrarExtras, 1);
    // Usa la funcion de muestraArray para modificar el div
    muestraArray(extrasDisponibles);
    // Actualiza el select desde donde añadir extras a los coches
    optionExtra(extrasDisponibles);
}


// 12. AÑADIR VEHICULO DESDE EL HTML
// Funcion que define variables para almacenar el valor de los input inputNomVeh y inputVeloVeh, y usarlos para crear un
// nuevo vehiculo
function botonVehiculos() {
    var contInputNombreVeh = document.getElementById("inputNomVeh").value; // NOMBRE
    var contInputVeloVeh = document.getElementById("inputVeloVeh").value; // VELOCIDAD
    var nuevoVeh = new Vehiculo(contInputNombreVeh, contInputVeloVeh);
    // Añade al Array asociativo el nuevo vehiculo por nombre : object
    vehiculosDisponibles[nuevoVeh.nombre] = nuevoVeh;
    // Actualiza la tabla de vehiculos disponibles
    mostrarVehiculos(vehiculosDisponibles);
    // Actualiza las opciones de vehiculos disponibles en la tabla para añadir extras
    optionVeh(vehiculosDisponibles);
}

// 13. ASIGNAR UN EXTRA A UN COCHE
// Funcion para mostrar options con el numero de indice de los extras en la tabla de añadir extras a un vehiculo
var selectExtraVehAdd = document.getElementById("extraVehAdd");
function optionExtra(extras) {
    selectExtraVehAdd.innerHTML = "";
    for (let i = 0; i < extras.length; i++) {
        selectExtraVehAdd.innerHTML += "<option>" + i + "</option>"
    }
}
// Funcion para mostrar options con el nombre de los vehiculos en la tabla de añadir extras a un vehiculo
// Va a recibir por parametro el Array de vehiculosDisponibles para tratarlo
var selectVehToAddEx = document.getElementById("nomVehAdd");
function optionVeh(vehiculos) {
    selectVehToAddEx.innerHTML = "";
    for (let key in vehiculos) {
        selectVehToAddEx.innerHTML += "<option>" + vehiculos[key].nombre + "</option>"
    }
}

// 14. PROGRAMAR EL BOTON ADD EXTRA COCHE
// Botón que añade un extra a un coche seleccionado
function addExtraCoche() {
    // Almacena en una variable el valor del input que contiene el nombre
    let nombreKey = selectVehToAddEx.value; // NOMBRE
    for (const key in vehiculosDisponibles) {
        // Recorre el Array, cuando encuentra el nombre, le añade el extra con el indice seleccionado en el otro select
        if (vehiculosDisponibles[key].nombre === nombreKey) {
            vehiculosDisponibles[key].addExtra(extrasDisponibles[selectExtraVehAdd.value]);
            // Actualiza la lista de vehiculos disponibles
            mostrarVehiculos(vehiculosDisponibles);
        }
    }

}


/*******************************************/
/**************** UTILIDADES ***************/
/*******************************************/

// RECORRER ARRAY DE EXTRAS Y PINTAR HTML
// Funcion que recorre el array pasado por parametro y usando la funcion .getHTML de la clase crea todo el contenido HTML
function muestraArray(paramArray) {
    // Vacia el contenido del div dejando unicamente las cabeceras de la tabla
    divExtras.innerHTML = "<tr><th colspan='3'>EXTRAS DISPONIBLES</th></tr><tr><th>NOMBRE</th><th>IMAGEN</th><th>PRECIO</th></tr>";
    // Realiza un bucle añadiendo los resultados del metodo .getHTML de los extras
    for (let i = 0; i < paramArray.length; i++) {
        divExtras.innerHTML += "<tr>" + paramArray[i].getHTML() + "</tr>";
    }
}

// RECORRER ARRAY ASOCIATIVO DE VEHICUÇLOS DISPONIBLES Y PINTAR HTML EN TABLA
function mostrarVehiculos(paramArray) {
    divVehiculosDisponibles.innerHTML = "<tr><th colspan='4'>VEHICULOS DISPONIBLES</th></tr><tr><th>NOMBRE</th><th>VELOCIDAD</th><th colspan='2'>EXTRAS</th></tr>";
    for (const key in paramArray) {
        divVehiculosDisponibles.innerHTML += paramArray[key].getHtmlVehTab();

    }
}

