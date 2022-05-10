<?php
// RESPUESTA JSON
session_start();

$miArray["valor"] = $_POST["valor"];
$miArray["id"] = $_POST["id"];

// Comprobaciones usando id - valor, comprueba el id de los inputs de los check con los
// valores de los input de guardar combinacion, si coincide guarda OK, si no coincide guarda KO
if ($miArray["id"] == 'chN1' && $miArray["valor"] == $_SESSION["guN1"]) {
    $miArray["igual"] = "OK";
} elseif ($miArray["id"] == 'chN2' && $miArray["valor"] == $_SESSION["guN2"]) {
    $miArray["igual"] = "OK";
} elseif ($miArray["id"] == 'chN3' && $miArray["valor"] == $_SESSION["guN3"]) {
    $miArray["igual"] = "OK";
} elseif ($miArray["id"]== 'chN4' && $miArray["valor"] == $_SESSION["guN4"]) {
    $miArray["igual"] = "OK";
} else {
    $miArray["igual"] = "KO";
}

// Respuesta
$resp = json_encode($miArray);

echo $resp;