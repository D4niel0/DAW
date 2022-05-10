<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DAW_M07_T04_ACT_03_DanielAguilar</title>
</head>

<body>
    <?php
    session_start();
    ?>
    <h1>Ejercicio 1</h1>
    <?php
    // Si la variable de sesion numAle no existe, la crea con un número aleatorio
    if (!isset($_SESSION["numAle"])) {
        $_SESSION["numAle"] = rand(0, 100);
    }
    ?>
    <form action="ejercicio1/lucky.php" method="post">
        <label>Introduce un número</label>
        <input type="number" name="acierto"><br>
        <input type="submit" value="Enviar">
        <input type="submit" name="desvelar" value="Desvelar">
        <input type="submit" name="generar" value="Generar nuevo número"><br>
    </form>
    <?php
    comp_eje1();
    ?>
    <h1><a href="ejercicio2/inicio.php">Ejercicio2</a></h1>
    <h1><a href="ejercicio3/info.php">Ejercicio3</a></h1>
</body>

</html>

<?php
function comp_eje1() {
    if (isset($_SESSION["mayor"])) {
        echo $_SESSION["mayor"];
        unset($_SESSION["mayor"]);
    }
    // Si es menor
    if (isset($_SESSION["menor"])) {
        echo $_SESSION["menor"];
        unset($_SESSION["menor"]);
    }
    // Si es menor
    if (isset($_SESSION["exacto"])) {
        echo $_SESSION["exacto"];
        unset($_SESSION["exacto"]);
    }
    // Si desvela el número
    if (isset($_SESSION["el_numero"])) {
        echo $_SESSION["el_numero"];
        unset($_SESSION["el_numero"]);
    }
}
?>