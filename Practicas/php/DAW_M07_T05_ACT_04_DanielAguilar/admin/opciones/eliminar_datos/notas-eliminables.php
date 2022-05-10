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
            // Si la variable borrar existe, se ejecuta el borrado, si no se construye el formulario
            if (isset($_POST["borrar"])) {
                del_notas($_POST["asignaturas"], $_SESSION["dni_notas"], $con);
                header('Location: ' . $_SERVER['PHP_SELF']);
            } else {
                echo "<form action='" . $_SERVER["PHP_SELF"] . "' method=post>";
                // Control de filas, por si no tiene notas mostrará un mensaje, y así no muestra una tabla vacia
                if (num_filas($notas) == 0) {
                    echo "<h3>El usuario no tiene ninguna nota asignada</h3>";
                } else {
                    // Tabla que muestra las notas del alumno 
                    echo "<table class='tabla'>";
                    echo "<tr><th>APELLIDO</th><th>ASIGNATURA</th></th><th>NOTA</th><th>SELECCIONAR</th></tr>";
                    while ($fila_notas_tabla = crear_array($notas)) {
                        extract($fila_notas_tabla);
                        echo "<tr><td>$apellido</td><td>$nombre</td>";
                        // Para el borrado se pueden seleccionar varias usando un array de checkbox, el valor de cada uno es el ID de la asignatura
                        echo "</select></td><td>$nota</td><td><input type=checkbox name='asignaturas[]' value='$asignatura'/></tr>";
                    }
                    echo "</table>";
                    echo "<input type='submit' name='borrar' value='Borrar'/>";
                    echo "</form>";
                }
            }
            disconnect($con);
            ?>
            <a href="del-datos.php">Atras</a>
        </div>
    </div>
</body>

</html>