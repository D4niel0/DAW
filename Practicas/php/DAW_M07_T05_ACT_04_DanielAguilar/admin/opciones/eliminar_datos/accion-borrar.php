<?php

// Acciones desde las que se llega desde el formulario de del-datos, ejecuta funciones y redirige
require("../../../bbdd/database.php");
$con = conectar();

if (isset($_POST["del-user"])) {
    del_user($_POST["usuario"],$con);
    header("Location: del-datos.php");
}

// Para el caso de borrar notas, redirige a una nueva página
if (isset($_POST["del-notas"])) {
    $_SESSION["dni_notas"] = $_POST["usuario"];
    header("Location: notas-eliminables.php");
}



if (isset($_POST["del-asign"])) {
    del_asign($_POST["asignatura"],$con);
    header("Location: del-datos.php");
}

disconnect($con);
?>