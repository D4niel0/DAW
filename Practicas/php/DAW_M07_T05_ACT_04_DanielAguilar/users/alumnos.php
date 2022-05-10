<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <title>Document</title>
</head>

<body>
    <div class="container">
        <div class="screen">
            <?php
            require("../bbdd/database.php");
            $con = conectar();
            $notas = mostrar_notas($_SESSION["dni_sesion"], $con);
            // Tabla que muestra las notas del alumno 
            echo "<h1>Bienvenido " . bienvenida($_SESSION["dni_sesion"], $con) . "</h1>";
            // Control de filas, por si no tiene notas mostrar un mensaje y no mostrar la tabla vacia
            if (num_filas($notas) == 0) {
                echo "<h3>No tienes notas asignadas</h3>";
                echo "<a href='../login/logout.php'>Logout</a>";
            } else {

                echo "<table class='tabla'>";
                echo "<tr><th>APELLIDO</th><th>ASIGNATURA</th></th><th>NOTA</th></tr>";
                while ($fila_notas_tabla = crear_array($notas)) {
                    extract($fila_notas_tabla);
                    echo "<tr><td>$apellido</td><td>$nombre</td><td>$nota</td>";
                }
                echo "</table>";
                echo "<a href='../login/logout.php'>Logout</a>";
            }
            disconnect($con);
            ?>
        </div>
    </div>
</body>

</html>