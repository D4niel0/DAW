// VARIABLE FORMULARIO
var refForm = document.forms["formTienda"];
// VARIABLES BOTON REGISTRAR
var buttReg = refForm["registrate"];
buttReg.addEventListener("click",registrar);
buttReg.addEventListener("submit",registrar);
// VARIABLES BOTON GUARDAR DATOS
var buttGuar = refForm["guardar"];
buttGuar.addEventListener("click",guardarDatos);
// VARIABLES BOTON RECUPERAR DATOS
var buttRecu = refForm["recuperar"];
buttRecu.addEventListener("click",recuperarDatos);
// VARIABLES BOTON RESET
var buttReset = refForm["reset"];
buttReset.addEventListener("click",limpiar);
// VARIABLE CHECKBOX
var checkbox= refForm["alimento"];
// VARIABLE INPUTS
var nombreProd = refForm["inputNombre"];
var codBarras = refForm["inputCodigo"];
var dia = refForm["inputDia"];
var mes = refForm["inputMes"];
var ano = refForm["inputAno"];
// VARIABLE OPTIONS DEL SELECT SELECT
var selectOfertas = refForm["ofertas"];
// VARIABLE TEXTAREA
var textArea = refForm["textoInfo"];

/****************************************/
/****************************************/

// FUNCION BOTON REGISTRAR
// Recibe true o false de las funciones que validan los checkbox, nombre codigo y fecha, si alguna de ellas es un false, no
// continua
function registrar(evento) {
    if ((validarCheckbox() === false) || (validanombre() === false) || (validaCodigo() === false) || (validaFecha() === false))  {
        evento.preventDefault();
    } else {
        console.log("adios");
    }
}

// FUNCION PARA VALIDAR LOS CHECKBOX
// 3. Controla que si no se selecciona algún tipo de alimento (Congelado, Fruta o Snak) 
// no se envíe el formulario al clicar en Regístrate.
// Tiene una variable contador, recorre el array de los checkbox, si esta sin marcar, sube la variable contador.
// Luego comprueba si el contador ha llegado a 3, si es así, retorna un false
function validarCheckbox() {
    let contador = 0;
    for (let i=0; i<checkbox.length;i++) {
        if (checkbox[i].checked === false) {
            contador++;
        }
    }
    if (contador === 3) {
        return false;
    } else {
        return true;
    }
}

// 4. VALIDACIONES
// ADDEVENTLISTENER ONKEYUP DE LOS INPUTS
nombreProd.addEventListener("keyup",validanombre);
codBarras.addEventListener("keyup",validaCodigo);
dia.addEventListener("keyup",validaFecha);
mes.addEventListener("keyup",validaFecha);
ano.addEventListener("keyup",validaFecha);
// VARIABLE PARA EXPRESIONES REGULARES


// FUNCIONES VALIDATORIAS
// FUNCION VALIDANOMBRE
// Funcion que define una expresion regular por la que un nombre tiene que empezar por una letra entre A y z, 3 letras y
// maximo 20, no puede empezar por un numero. Pinta el contenido del input en el textbox, hace un salto
// de linea y pinta debajo si es correcto o no 
// Pinta en verde el input cuando esta correcto y lo despinta cuando no lo esta
function validanombre() {
    let expresion = new RegExp("^[A-z]{3,20}$");
    if (expresion.test(nombreProd.value) === false) {
        textArea.value = "Contenido del input Nombre Producto: " + nombreProd.value + '\r\n';
        textArea.value += "Nombre incorrecto";
        nombreProd.style.backgroundColor = "";
        return false;
    } else {
        textArea.value = "Contenido del input Nombre Producto: " + nombreProd.value + '\r\n';
        textArea.value += "Nombre correcto";
        nombreProd.style.backgroundColor = "rgb(179, 221, 136)";
    }
}

// FUNCION VALIDACODIGO
// Funcion que define una expresion regular por la que un codigo tiene que empezar por un numero y debe de tener 13 numeros
// y ninguna letra. Pinta el contenido del input en el textbox, hace un salto de linea, y pinta debajo si es correcto o no
// Pinta en verde el input cuando esta correcto y lo despinta cuando no lo esta
function validaCodigo() {
    let expresion = new RegExp("^[0-9]{13}$");
    if (expresion.test(codBarras.value) === false) {
        textArea.value = "Contenido del input Código de Barras: " + codBarras.value + '\r\n';
        textArea.value += "Código incorrecto";
        codBarras.style.backgroundColor = "";
        return false;
    } else {
        textArea.value = "Contenido del input Código de Barras: " + codBarras.value + '\r\n';
        textArea.value += "Código correcto";
        codBarras.style.backgroundColor = "rgb(179, 221, 136)";
    } 
}

// FUNCION VALIDA FECHA
// Funcion que valida la fecha introducida, crea un objeto de tipo date con los input de año, mes, y dia. Al mes le resta
// uno ya que el mes en los objetos date son 1 menos. Luego, hace las comprobaciones usando el getMonth, se se ha generado
// una fecha con parámetros incorrectos una de las comprobaciones fallará y por tanto mostrara el mensaje de Fecha
// incorrecta. Adicionalmente muestra la fecha por el textarea con un salto de linea
// Pinta en verde los inputs cuando esta correcto y lo despinta cuando no lo esta
function validaFecha() {    
    let fecha = new Date(ano.value,(mes.value-1),dia.value);
    if ((dia.value==fecha.getDate()) && ((mes.value-1)==fecha.getMonth()) && (ano.value==fecha.getFullYear())) {
        textArea.value = dia.value + "/" + mes.value + "/" + ano.value + '\r\n';
        textArea.value += "Fecha correcta" + '\r\n';
        dia.style.backgroundColor = "rgb(179, 221, 136)";
        mes.style.backgroundColor = "rgb(179, 221, 136)";
        ano.style.backgroundColor = "rgb(179, 221, 136)";
    } else {
        textArea.value = dia.value + "/" + mes.value + "/" + ano.value + '\r\n';
        textArea.value += "Fecha incorrecta";
        dia.style.backgroundColor = "";
        mes.style.backgroundColor = "";
        ano.style.backgroundColor = "";
        return false;
    }
}

// COOKIES
// FUNCIONES GETCOOKIE Y SETCOOKIE
function setCookie(cname, cvalue, exdays) {
    const d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    let expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
  }
  
  function getCookie(cname) {
    let name = cname + "=";
    let ca = document.cookie.split(';');
    for(let i = 0; i < ca.length; i++) {
      let c = ca[i];
      while (c.charAt(0) == ' ') {
        c = c.substring(1);
      }
      if (c.indexOf(name) == 0) {
        return c.substring(name.length, c.length);
      }
    }
    return "";
  }  


// 5. PROGRAMAR GUARDAR DATOS EN COOKIES
// Funcion que usa el setCookie para guardar las cookies de todos los inputs, incluido el contenido del textArea
// Para los checkbox, recorre el array y crea una coockie por cada opcion
function guardarDatos() {
    setCookie("NombreProducto",nombreProd.value,5);
    setCookie("CodigoBarras",codBarras.value,5);
    setCookie("Dia",dia.value,5);
    setCookie("Mes",mes.value,5);
    setCookie("Anyo",ano.value);
    setCookie("Oferta",selectOfertas.value,5);
    setCookie("TextArea",textArea.value,5);
    
    for (let i=0; i<checkbox.length;i++) {
        if (checkbox[i].checked === true) {
            setCookie("OpcionChkBx"+i,checkbox[i].value,5)
        }
    }
}

// 6. RECUPERA DATOS
// Función que recupera el contenido de las cookies y lo inyecta en los inputs, para los checkbox los recorre con un
// for i, si la cookie estuviera vacia pone el checked a false, y si la cookie tiene contenido, pone el checked a true
function recuperarDatos() {
    nombreProd.value = getCookie("NombreProducto");
    codBarras.value = getCookie("CodigoBarras");
    dia.value = getCookie("Dia");
    mes.value = getCookie("Mes");
    ano.value = getCookie("Anyo");
    selectOfertas.value = getCookie("Oferta");
    textArea.value = getCookie("TextArea");

    for (let i=0; i<checkbox.length;i++) {
        if (getCookie("OpcionChkBx"+i) === "") {
            checkbox[i].checked = false;
        } else {
            checkbox[i].checked = true;
        }
    }


}


// EXTRA
// FUNCTION BOTON LIMPIAR
// Le he añadido al botón limpiar una función extra para que ponga los inputs de nuevo con el style en blanco
function limpiar() {
    nombreProd.style.backgroundColor = "";
    codBarras.style.backgroundColor = "";
    dia.style.backgroundColor = "";
    mes.style.backgroundColor = "";
    ano.style.backgroundColor = "";
}