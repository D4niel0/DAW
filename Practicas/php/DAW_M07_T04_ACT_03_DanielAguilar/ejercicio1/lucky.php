<?php
    session_start();
    $num = $_POST["acierto"];
    
    if ($num < $_SESSION["numAle"]) {
        $_SESSION["mayor"] = "El número que buscas es mayor";
        header("Location: ../index.php");
    }

    if ($num > $_SESSION["numAle"]) {
        $_SESSION["menor"] = "El número que buscas es menor";
        header("Location: ../index.php");
    }

    if ($num == $_SESSION["numAle"]) {
        $_SESSION["exacto"] = "ACERTASTE!";
        header("Location: ../index.php");
    }

    if (isset($_POST["desvelar"])) {
        $_SESSION["el_numero"] = "El número es: ".$_SESSION["numAle"];
        // Hago un unset de todas las variables de sesión para que limpie el resultado en el formulario
        unset($_SESSION["mayor"]);
        unset($_SESSION["menor"]);
        unset($_SESSION["exacto"]);
        header("Location: ../index.php");
    }

    if (isset($_POST["generar"])) {
        $_SESSION["numAle"] = rand(0, 100);
        // Hago un unset de todas las variables de sesión para que limpie el resultado en el formulario
        unset($_SESSION["mayor"]);
        unset($_SESSION["menor"]);
        unset($_SESSION["exacto"]);
        header("Location: ../index.php");
    }
    
?>