// Variables inputs
var guN1 = document.getElementById("guN1");
var guN2 = document.getElementById("guN2");
var guN3 = document.getElementById("guN3");
var guN4 = document.getElementById("guN4");
var chN1 = document.getElementById("chN1");
var chN2 = document.getElementById("chN2");
var chN3 = document.getElementById("chN3");
var chN4 = document.getElementById("chN4");
// Variables h3 resultados
var resultGuard = document.getElementById("resultadoGuardar");
var resultCheck = document.getElementById("resultadoCheck");

var h3GuN1 = document.getElementById("h3GuN1");
var h3GuN2 = document.getElementById("h3GuN2");
var h3GuN3 = document.getElementById("h3GuN3");
var h3GuN4 = document.getElementById("h3GuN4");

var h3ChN1 = document.getElementById("h3ChN1");
var h3ChN2 = document.getElementById("h3ChN2");
var h3ChN3 = document.getElementById("h3ChN3");
var h3ChN4 = document.getElementById("h3ChN4");

// Ejercicio 3
// GET CON RESPUESTA XML
// Envia por GET el contenido de los inputs, si son positivos, numericos y de un único dígito, rellena un h2 indicando
// que es correcto, en el PHP realiza otras acciones a nivel servidor.
// Recorre el XML para rellenar el h2
function guardarComb() {
    // Contenidos de los inputs
    let guN1Cont = guN1.value;
    let guN2Cont = guN2.value;
    let guN3Cont = guN3.value;
    let guN4Cont = guN4.value;
    // Variable peticion
    let varPeticion = new XMLHttpRequest();
    varPeticion.open("GET","ejercicio3.php?guN1="+guN1Cont+"&guN2="+guN2Cont+"&guN3="+guN3Cont+"&guN4="+guN4Cont,true);
    varPeticion.onreadystatechange = function(){
        if (varPeticion.readyState == 4){  
            if (varPeticion.status == 200){ 
                // console.log(varPeticion.responseText);
                let respuestaXML = varPeticion.responseXML;
                // console.log (respuestaXML.firstElementChild.children[1].children[0]);
                let estado = respuestaXML.firstElementChild.children[1].children[0];
                resultGuard.innerHTML = estado.textContent;
            } else {
                console.log ("El recurso no existe")
            }    
        } 
    }   
    varPeticion.send();
}




// Ejercicio 4
// RESPUESTA TEXTO
// addEventListener keyup de todos los input de guardar numero
guN1.addEventListener("keyup",compruebaNumero);
guN2.addEventListener("keyup",compruebaNumero);
guN3.addEventListener("keyup",compruebaNumero);
guN4.addEventListener("keyup",compruebaNumero);

// Funcion que recibe por parametro un evento, usa este evento para luego poder identificarlo
// con un target y poder saber cual de los inputs es el que lo ha lanzado
// Ademas pinta los input en verde o rojo si están bien o mal
function compruebaNumero(event) {
    // Contenidos de los inputs
    let guCont = event.target.value;

    // Variable peticion
    let varPeticion = new XMLHttpRequest();
    varPeticion.open("POST","ejercicio4.php",true);
    varPeticion.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    varPeticion.onreadystatechange = function(){
        if (varPeticion.readyState == 4){  
            if (varPeticion.status == 200){ 
                // console.log(varPeticion.responseText);
                // Si el id del target es el primer input...
                if (event.target.id == "guN1") {
                    h3GuN1.innerHTML = varPeticion.responseText;
                    if (varPeticion.responseText === "OK") {
                        guN1.style.backgroundColor = "rgb(179, 221, 136)";
                    } else {
                        guN1.style.backgroundColor = "rgb(255, 107, 85)";
                    }
                } 
                // Si el id del target es el segundo input...
                if (event.target.id == "guN2") {
                    h3GuN2.innerHTML = varPeticion.responseText;
                    if (varPeticion.responseText === "OK") {
                        guN2.style.backgroundColor = "rgb(179, 221, 136)";
                    } else {
                        guN2.style.backgroundColor = "rgb(255, 107, 85)";
                    }
                } 
                // Si el id del target es el tercer input...
                if (event.target.id == "guN3") {
                    h3GuN3.innerHTML = varPeticion.responseText;
                    if (varPeticion.responseText === "OK") {
                        guN3.style.backgroundColor = "rgb(179, 221, 136)";
                    } else {
                        guN3.style.backgroundColor = "rgb(255, 107, 85)";
                    }
                } 
                // Si el id del target es el cuarto input...
                if (event.target.id == "guN4") {
                    h3GuN4.innerHTML = varPeticion.responseText;
                    if (varPeticion.responseText === "OK") {
                        guN4.style.backgroundColor = "rgb(179, 221, 136)";
                    } else {
                        guN4.style.backgroundColor = "rgb(255, 107, 85)";
                    }
                }
            } else {
                console.log ("El recurso no existe")
            }    
        } 
    }   
    // Envio de la peticion
    varPeticion.send("valor="+guCont);
}


// Ejercicio 5
// RESPUESTA JSON
// Funcion que mediante fetch hace una petición POST,  al apretar al botón de check comprueba que los 4 valores de los
// inputs de check son iguales a los guardados anteriormente usando variables de sesion, luego lo pinta en un h3 el resultado
function checkComb() {
    // Contenidos inputs
    let chN1Cont = chN1.value;
    let chN2Cont = chN2.value;
    let chN3Cont = chN3.value;
    let chN4Cont = chN4.value;

    let configuracion = {
        method:"POST",
        headers:{"Content-Type":"application/x-www-form-urlencoded"},
        body:"chN1="+chN1Cont+"&chN2="+chN2Cont+"&chN3="+chN3Cont+"&chN4="+chN4Cont
    };

    let promise = fetch("ejercicio5.php",configuracion);

    promise.then(
        function (respuesta) {
            respuesta.json().then(
                function(objetoJSON) {
                    resultCheck.innerHTML = objetoJSON.resp;
                }
            )
        }
    )
}

// Ejercicio 6
// RESPUESTA JSON
// Funcion que recibe por parametro el evento para poder realizar el target e identificar
// cual es el input que envia el evento, y además lo utiliza para identificarlo por su
// id. Con este luego lo filtra en el PHP. Además pinta los input si está correcto o no usando
// el .style 
chN1.addEventListener("keyup",compruebaCombinacion);
chN2.addEventListener("keyup",compruebaCombinacion);
chN3.addEventListener("keyup",compruebaCombinacion);
chN4.addEventListener("keyup",compruebaCombinacion);

function compruebaCombinacion(evento) {
    let configuracion = {
        method:"POST",
        headers:{"Content-Type":"application/x-www-form-urlencoded"},
        body:"valor="+evento.target.value+"&id="+evento.target.id
    };

    let promise = fetch("ejercicio6.php",configuracion);

    promise.then(
        function (respuesta) {
            respuesta.json().then(
                function(objetoJSON) {
                    // console.log(objetoJSON);
                    if (objetoJSON.id == "chN1") {
                        h3ChN1.innerHTML = objetoJSON.igual;
                        if (objetoJSON.igual === "OK") {
                            chN1.style.backgroundColor = "rgb(179, 221, 136)";
                        } else {
                            chN1.style.backgroundColor = "rgb(255, 107, 85)";
                        }
                    }
                    if (objetoJSON.id == "chN2") {
                        h3ChN2.innerHTML = objetoJSON.igual;
                        if (objetoJSON.igual === "OK") {
                            chN2.style.backgroundColor = "rgb(179, 221, 136)";
                        } else {
                            chN2.style.backgroundColor = "rgb(255, 107, 85)";
                        }
                    }
                    if (objetoJSON.id == "chN3") {
                        h3ChN3.innerHTML = objetoJSON.igual;
                        if (objetoJSON.igual === "OK") {
                            chN3.style.backgroundColor = "rgb(179, 221, 136)";
                        } else {
                            chN3.style.backgroundColor = "rgb(255, 107, 85)";
                        }
                    }
                    if (objetoJSON.id == "chN4") {
                        h3ChN4.innerHTML = objetoJSON.igual;
                        if (objetoJSON.igual === "OK") {
                            chN4.style.backgroundColor = "rgb(179, 221, 136)";
                        } else {
                            chN4.style.backgroundColor = "rgb(255, 107, 85)";
                        }
                    } 
                }
            )
        }
    )
}