<?php
    session_start();
    if (empty($_POST["dni"])) {
        $_SESSION["error3"] = "Debes introducir un valor";
        header("Location: index.php");
    } elseif (!filter_var($_POST["dni"], FILTER_VALIDATE_INT)) {
        $_SESSION["no_INT_dni"] = "Debes introducir un valor correcto";
        header("Location: index.php");
    } elseif (strlen($_POST["dni"]) != 8) {
        $_SESSION["no_todos_num"] = "Debes introducir 8 dígitos";
        header("Location: index.php");        
    } else {
        // Creo un array asociativo para luego sacar la letra
        $letra = array(0 => "T" , 1 => "R", 2 => "W", 3 => "A", 4 => "G", 5 => "M",
                        6 => "Y", 7 => "F", 8 => "P", 9 => "D", 10 => "X", 11 => "B", 12 => "N",
                        13 => "J", 14 => "Z", 15 => "S", 16 => "Q", 17 => "V", 18 => "H", 19 => "L",
                        20 => "C", 21 => "K", 22 => "E");
        $resto = $_POST["dni"]%23;

        $_SESSION["letra_dni"] = "La letra del DNI es : $letra[$resto]";
        header("Location: index.php");
    }
?>