<?php
    $host = "localhost";
    $user = "root";
    $pass = "4246";
    $db_name = "MOSTRADOR";

    function conectar() {
        $con = mysqli_connect($GLOBALS["host"],$GLOBALS["user"],$GLOBALS["pass"],$GLOBALS["db_name"]) or die("Error de conexión en la base de datos");
        return $con;
    }

    function categorias($con) {
        $query = "select * from categoria";
        return mysqli_query($con,$query);
    }

    function obtener_resultados($result) {
        return mysqli_fetch_array($result);
    }

?>