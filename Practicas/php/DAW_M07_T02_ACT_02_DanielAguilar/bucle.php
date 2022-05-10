<?php
    session_start();
    // Controla que se haya introducido un valor, devuelve la variable de sesión y la muestra
    if (empty($_POST["cuantas"])) {
        $_SESSION["error1"] = "Debes introducir un valor";
        header("Location: index.php");
    // Controla que se haya introducido un número, devuelve la variable de sesión y la muestra        
    } elseif (!filter_var($_POST["cuantas"], FILTER_VALIDATE_INT)) {
        $_SESSION["no_INT"] = "Debes introducir un valor correcto";
        header("Location: index.php");
    } else {
        // Crea una array con la salida, lo guarda en la variable de sesion y la muestra
        $salida = array();
        for($i = 1; $i < $_POST["cuantas"]+1; $i++) {
            $salida[] = "$i - Los bucles son faciles!<br/>";
        }
        $salida[] = "Se acabó<br/>";
        $_SESSION["resultado"] = $salida;
        header("Location: index.php");
    }

?>