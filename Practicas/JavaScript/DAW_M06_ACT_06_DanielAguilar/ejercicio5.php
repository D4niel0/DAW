<?php
// RESPUESTA JSON
session_start();

$numeros = array("chN1"=> $_POST["chN1"]);
$numeros["chN2"] = $_POST["chN2"];
$numeros["chN3"] = $_POST["chN3"];
$numeros["chN4"] = $_POST["chN4"];


if ($numeros["chN1"] == $_SESSION["guN1"] && $numeros["chN2"] == $_SESSION["guN2"] && 
$numeros["chN3"] == $_SESSION["guN3"] && $numeros["chN4"] == $_SESSION["guN4"]) {
    $numeros["resp"] = "Son iguales";
} else {
    $numeros["resp"] = "No son iguales";
}

$result = json_encode($numeros);

echo $result;

