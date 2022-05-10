<?php
    session_start();
    // Controla que se haya introducido un valor, devuelve la variable de sesión y la muestra
    // Tambien controlo que sea diferente de 0, ya que 0 lo interpreta como vacio, y quiero controlarlo
    // como suspenso mas adelante
    if (empty($_POST["nota"]) && $_POST["nota"] != 0) {
        $_SESSION["error2"] = "Debes introducir un valor";
        header("Location: index.php");
    // Controla que se haya introducido un número, devuelve la variable de sesión y la muestra          
    } elseif (!filter_var($_POST["nota"], FILTER_VALIDATE_FLOAT)) {
        $_SESSION["no_FLOAT"] = "Debes introducir un valor correcto";
        header("Location: index.php");
    }
    // Control de notas y retornos
    if ($_POST["nota"] >= 0 && $_POST["nota"] <= 4.99) {
        $_SESSION["tu_nota"] = "Suspenso<br/>";
        header("Location: index.php");
    } elseif ($_POST["nota"] >= 5 && $_POST["nota"] <= 6.99) {
        $_SESSION["tu_nota"] = "Aprobado<br/>";
        header("Location: index.php");
    } elseif ($_POST["nota"] >= 7 && $_POST["nota"] <= 8.99) {
        $_SESSION["tu_nota"] = "Notable<br/>";
        header("Location: index.php");
    } elseif ($_POST["nota"] >= 9 && $_POST["nota"] <= 9.99) {
        $_SESSION["tu_nota"] = "Excelente<br/>";
        header("Location: index.php");
    } elseif ($_POST["nota"] = 10) {
        $_SESSION["tu_nota"] = "Matrícula de honor<br/>";
        header("Location: index.php");
    } 

?>    