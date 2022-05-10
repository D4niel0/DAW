// Ejercicio 2.
// FUNCION QUE MUESTRA UNA LISTA CON DIFERENTES VALORES PREDEFINIDOS, ADEMÁS ESTABLECE UNA FECHA Y HORA
window.onload = function lista(){
    // Variables
    let fecha = new Date(2019,10,21,17,15);     // fecha predefinida
    let lista = document.getElementById("listaPropiedades");    // elemento con id "listaPropiedades"
    // Lista
    lista.innerHTML = 
    "<ul>"
    +"<li> <b>Valor máximo de Number:</b> " + Number.MAX_VALUE + "</li>"
    +"<li> <b>Valor mínimo de Number:</b> " + Number.MIN_VALUE + "</li>"
    +"<li> <b>Altura total de la pantalla:</b> " + screen.height + "</li>"
    +"<li> <b>Anchura total de la pantalla:</b> " + screen.width + "</li>"
    +"<li> <b>Altura de la ventana:</b> " + window.innerHeight + "</li>"
    +"<li> <b>Anchura de la ventana:</b> " + window.innerWidth + "</li>"
    +"<li> <b>URL de la web:</b> " + location.href + "</li>"
    +"<li> <b>Titulo de la pagina web:</b> " + document.title + "</li>"
    +"<li> <b>Valor aleatorio entre 0 y 200:</b> " + Math.floor(Math.random()*201) + "</li>"
    +"<li> <b>Sistema operativo del ordenador:</b> " + navigator.userAgent + "</li>"
    +"<li> <b>La fecha actual es:</b> " + fecha.getDate()+"-" + fecha.getMonth() + "-" + fecha.getFullYear() + "</li>"
    +"<li> <b>La hora actual es:</b> " + fecha.getHours() + ":" + fecha.getMinutes() + "h" + "</li>"
    +"</ul>";

    // Ejercicio 4.
    // Introducir en el contenido del input el valor de la cookie "nombre_usuario" al recargar la pagina
    document.getElementById("nombre").value = document.cookie.substr(15);
}

// Ejercicio 3.
// FUNCION PARA AGREGAR COOKIE CON EL CONTENIDO DEL INPUT
function estableceCookie() {
    let contInput = document.getElementById("nombre").value;    // contenido del input "nombre"
    document.cookie = "nombre_usuario="+contInput;
}

// Ejercicio 5.
// FUNCION BOTON PARA ABRIR PAGINA numero.html
function acierta() {
    // Variables para centrar la pagina abierta
    let left = (screen.width/2)-(300/2);   
    let top = (screen.height/2)-(300/2);    
    // Referencia
    let ref_hija;
    // Abrir nueva pagina
    ref_hija = window.open("numero.html","_blank","height=300,width=300,left="+left+",top="+top+",menubar=no");
}

// FUNCION PARA EDITAR EL DIV resultIndex CON EL RESULTADO DE LA FUNCION suerte DE LA PAGINA HIJA
// RECIBE POR PARAMETRO EL TEXTO DEL RESULTADO
function editaMadre (texto) {
    let res = document.getElementById("resultIndex");   // elemento con id "resultIndex"
    res.innerHTML = texto;
}


