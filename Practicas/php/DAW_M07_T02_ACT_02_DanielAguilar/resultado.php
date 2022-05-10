<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>Resultado</title>
</head>

<body>
    <div class="login-box">
        <?php
        // Controlo que no aparezcan los warning, de esta forma al activarse el filtro para mostrar cuando no se introduce un valor
        // valido, no se mostrara el mensaje de Undefined array key de $operation 
        error_reporting(E_ALL ^ E_WARNING);
        $num1 = $_POST['num1'];
        $num2 = $_POST['num2'];
        $operacion = $_POST['operacion'];

        if (!filter_var($_POST["num1"], FILTER_VALIDATE_FLOAT) | !filter_var($_POST["num2"], FILTER_VALIDATE_FLOAT)) {
            echo "<h2>Debes introducir un valor correcto</h2>";
        } elseif ($operacion == "suma") {
            echo "<h2>El resultado de la suma es " . suma($_POST['num1'], $_POST['num2']) . "</h2>";
        } elseif ($operacion == "resta") {
            echo "<h2>El resultado de la resta es " . resta($_POST['num1'], $_POST['num2']) . "</h2>";
        } elseif ($operacion == "multi") {
            echo "<h2>El resultado de la multiplicación es " . multipliacion($_POST['num1'], $_POST['num2']) . "</h2>";
        } elseif ($operacion == "divi") {
            echo "<h2>El resultado de la división es " . division($_POST['num1'], $_POST['num2']) . "</h2>";
        }
        ?>
        <a class="volver" href="calculadora.html">Volver atras</a>
    </div>
</body>

</html>

<?php

// FUNCIONES
// SUMA
function suma($num1, $num2)
{
    return $num1 + $num2;
}
// RESTA
function resta($num1, $num2)
{
    return $num1 - $num2;
}
// MULTIPLICACION
function multipliacion($num1, $num2)
{
    return $num1 * $num2;
}
// DIVISION
function division($num1, $num2)
{
    return $num1 / $num2;
}

?>