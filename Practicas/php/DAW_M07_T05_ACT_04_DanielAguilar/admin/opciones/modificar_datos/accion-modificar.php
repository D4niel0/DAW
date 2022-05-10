<?php
// Desde aqui se realizan acciones que llegan desde el formulario de mod-datos
require("../../../bbdd/database.php");
$con = conectar();

// Si se ha pulsado el botón de modificar usuario...
if (isset($_POST["mod-user"])) {
    $dni = $_POST["usuario"];
    $apellido = $_POST["apellido"];
    $rol = $_POST["rol"];
    // Test vacio, alguno de los campos estan vacios devuelve atrás (El rol siempre marcado uno por defecto)
    if (empty($dni) || empty($apellido)) {
        $_SESSION["error_mod"] = "Debes rellenar el apellido para modificar el usuario";
        header("Location: mod-datos.php");
    } else {
        switch($rol) {
            // Seleccion administrador
            case 0:
                if (tipo_usuario($dni, $con) == 1) {
                    borrar_notas($dni, $con);
                } else {
                    mod_usuario($dni, $apellido, $rol, $con);
                    header("Location: mod-datos.php");
                }
            // Seleccion normal
            case 1:
                mod_usuario($dni, $apellido, $rol, $con);
                header("Location: mod-datos.php");        
        }
    }
}

// Si se ha pulsado el botón de modificar notas, redirige a la pantalla de modificar notas editables guardando primero en una variable de
// sesion el DNI del usuario
if (isset($_POST["mod-nota"])) {
    $_SESSION["dni_notas"] =  $_POST["usuario"];
    header("Location: notas-editables.php");
}

// Si se ha pulsado el botón de modificar asignatura ejecuta la funcion correspondiente para su modificación
if (isset($_POST["mod-asign"])) {
    $id = $_POST["asignatura"];
    $nombre = $_POST["nombre"];
    // Test vacio, alguno de los campos estan vacios devuelve atrás
    if (empty($id) || empty($nombre)) {
        $_SESSION["error_mod_asgn"] = "Debes rellenar el nombre de la asignatura para modificarla";
        header("Location: mod-datos.php");
    } else {
    mod_asignatura($id, $nombre, $con);
    header("Location: mod-datos.php");
    }
}


disconnect($con);
