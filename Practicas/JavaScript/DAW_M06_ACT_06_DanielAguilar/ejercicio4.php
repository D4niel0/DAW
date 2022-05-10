<?php
// RESPUESTA TEXTO
// BLOQUE DE CODIGO PARA COMPROBAR SI LOS NÚMEROS SON VALIDOS
// Variable post recibida de guardar numero
$valor = $_POST["valor"];
// Variables para hacer comprobaciones y variable de respuesta
$ch1 = -1;
$ch2 = -1;
$ch3 = -1;
$resp = "";

// Comprobaciones, si el valor es numerico
if (is_numeric($valor)) {
    $ch1 = 1; 
    // Si el valor es positivo
    if ($valor>=0) {
        $ch2 = 1;
        // Si el valor es de un solo dígito
        if ($valor<=9) {
            $ch3 = 1;
        }
    }
} 

// Respuestas
if ($ch1 == 1 && $ch2 == 1 && $ch3 == 1) {
    $resp = "OK";
} else {
    $resp = "KO";
}

// Envio
echo $resp;