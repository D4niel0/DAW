<?php
// Inicio para variables de sesion
// RESPUESTA EN XML
session_start();

// BLOQUE DE CODIGO PARA COMPROBAR SI LOS NÚMEROS SON VALIDOS
// Variables post recibidas de guardar numero
$guN1 = $_GET["guN1"];
$guN2 = $_GET["guN2"];
$guN3 = $_GET["guN3"];
$guN4 = $_GET["guN4"];
// Comprobaciones, correctas 1, incorrectas -1
$ch1 = -1;
$ch2 = -1;
$ch3 = -1;

// Si es númerico pon 1
if (is_numeric($guN1) && is_numeric($guN2) && is_numeric($guN3) && is_numeric($guN4)) {
    $ch1 = 1; 
    // Si es mayor o igual que 1 pon 1 (positivo)
    if ($guN1>=0 && $guN2>=0 && $guN3>=0 && $guN4>=0) {
        $ch2 = 1;
        // Si es menor o igual que 9 (Un único dígito)
        if ($guN1<=9 && $guN2<=9 && $guN3<=9 && $guN4<=9) {
            $ch3 = 1;
        }   
    }
} 
// Si las dos comprobaciones son correctas, indica correcto, si no incorrecto
if ($ch1 == 1 && $ch2 == 1 && $ch3 == 1) {
    $est = "Correcto, valores guardados";
    $_SESSION["guN1"] = $guN1;
    $_SESSION["guN2"] = $guN2;
    $_SESSION["guN3"] = $guN3;
    $_SESSION["guN4"] = $guN4;

} else {
    $est = "Incorrecto, valores no guardados";
}

// XML
@header("Content-type:text/xml");
echo '<?xml version="1.0" encoding="utf-8" ?>';
echo "<info>";
echo "<numeros>";
    echo "<n1>$guN1</n1>";
    echo "<n2>$guN2</n2>";
    echo "<n3>$guN3</n3>";
    echo "<n4>$guN4</n4>";
echo "</numeros>";
echo "<estado>";
    echo "<est>$est</est>";  
echo "</estado>";    
echo "</info>";

