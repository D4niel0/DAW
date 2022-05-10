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

            require("../../../bbdd/database.php");
            $con = conectar();
            // Almaceno en una variable las notas
            $notas = mostrar_notas($_SESSION["dni_notas"], $con);

            // Control de filas, por si no tiene notas mostrar un mensaje y no mostrar la tabla vacia
            if (num_filas($notas) == 0) {
                echo "<h3>El usuario no tiene ninguna nota asignada</h3>";
            } else {

                // Tabla que muestra las notas del alumno 
                echo "<table class='tabla'>";
                echo "<tr><th>APELLIDO</th><th>ASIGNATURA</th></th><th>NOTA</th><th>MODIFICAR</th></tr>";
                while ($fila_notas_tabla = crear_array($notas)) {
                    extract($fila_notas_tabla);
                    echo "<tr><td>$apellido</td><td>$nombre</td>";
                    // Para poder editar las notas una por una, se construyen links GET con el ID de la asignatura
                    echo "</select></td><td>$nota</td><td><a href='accion-editar-nota.php?id=" . $asignatura . "'>Editar</a></tr>";
                }
                echo "</table>";
            }

            disconnect($con);
            ?>
            <a href="mod-datos.php">Atras</a>
        </div>
    </div>

</body>

</html>