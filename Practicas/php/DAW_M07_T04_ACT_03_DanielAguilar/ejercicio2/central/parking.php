<?php
// Pagina principal con todas las acciones que se realizan en la aplicación
session_start();

// SELECCIÓN ATERRIZAR
if ($_POST["size"] == "big") {
    aterrizar_big();
    header("Location: ../op-aparcar/aparcar.php");
} elseif($_POST["size"] == "small") {
    aterrizar_small();
    header("Location: ../op-aparcar/aparcar.php");
}
// SELECCION DESPEGAR
elseif ($_POST["size_des"] == "big_des") {
    despegar($_POST["num1"],$_POST["size_des"]);
    header("Location: ../op-retirar/retirar.php");
} elseif ($_POST["size_des"] == "small_des") {
    despegar($_POST["num1"],$_POST["size_des"]);
    header("Location: ../op-retirar/retirar.php");
} 

/////// FUNCIONES ///////
// Función para aterrizar naves grandes, con un bucle va recorriendo las plazas grandes, si se encuentra con un 0 (hueco libre) le
// coloca un 1 y guarda en una variable de sesión el estado de aterrizado y sale, si no, guardará que no encuentra sitio
function aterrizar_big() {
    for ($i = 0; $i < count($_SESSION["pla_big"]); $i++) {
        if ($_SESSION["pla_big"][$i] == 0) {
            $_SESSION["pla_big"][$i] = 1;
            $_SESSION["huecos"] = "<h2>Nave aterrizada</h2>";
            break;
        } else {
            $_SESSION["huecos"] = "<h2>No hay sitio para su nave</h2>";
        }
    }
}

// Funcion para aterrizar naves pequeñas
// Igual que con las grandes, aunque en este caso usara una variable para si no encuentra sitio, redirigirse a la función de las grandes
// y aterrizar en el parking grande
function aterrizar_small() {
    $sin_sitio = false;
    for ($i = 0; $i < count($_SESSION["pla_small"]); $i++) {
        // Primer intento    
        if ($_SESSION["pla_small"][$i] == 0) {
            $_SESSION["pla_small"][$i] = 1;
            $_SESSION["huecos"] = "<h2>Nave aterrizada</h2>";
            return 1;
        } else {
            $sin_sitio = true;
        }
    }
    if ($sin_sitio == true) {
        aterrizar_big();
    }
}

// Función para retirar naves, recibe por parámetro el número introducido y el tamaño de la nave, primero filtra por tamaño y luego
// comprobara si el hueco introducido está ocupado o no, si lo está la nave despega y es retirada, si no se indica que estaba vacia
function despegar($num,$size) {
    // Plazas grandes
    if ($size == "big_des") {
        if ($_SESSION["pla_big"][$num] == 1) {
            $_SESSION["pla_big"][$num] = 0;
            $_SESSION["despegue"] = "<h2>La nave ha despegado</h2>";
        } else {
            $_SESSION["despegue"] = "<h2>En esa plaza no hay ninguna nave</h2>";
        }
    }
    // Plazas pequeñas
    if ($size == "small_des") {
        if ($_SESSION["pla_small"][$num] == 1) {
            $_SESSION["pla_small"][$num] = 0;
            $_SESSION["despegue"] = "<h2>La nave ha despegado</h2>";
        } else {
            $_SESSION["despegue"] = "<h2>En esa plaza no hay ninguna nave</h2>";
        }
    }
}

// Función para pruebas
// Recorredor de plazas
function recorre()
{
    foreach ($_SESSION["pla_small"] as $valor => $key) {
        echo $key;
    }
    echo "<br>";
    foreach ($_SESSION["pla_big"] as $valor => $key) {
        echo $key;
    }
}
