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
            // Si se ha pulsado sobre el boton de ver notas, mostrara las notas del alumno elegido
            if (isset($_POST["ver-notas"])) {
                $notas = mostrar_notas($_POST["apellido"], $con);
                // Control de filas, por si no tiene notas mostrar un mensaje y no mostrar la tabla vacia
                if (num_filas($notas) == 0) {
                    echo "<h3>El usuario no tiene ninguna nota asignada</h3>";
                } else {
                    // Tabla que muestra las notas del alumno 
                    echo "<table class='tabla'>";
                    echo "<tr><th>APELLIDO</th><th>ASIGNATURA</th></th><th>NOTA</th></tr>";
                    while ($fila_notas_tabla = crear_array($notas)) {
                        extract($fila_notas_tabla);
                        echo "<tr><td>$apellido</td><td>$nombre</td><td>$nota</td>";
                    }
                    echo "</table>";
                    echo "<a href='ver-notas.php'>Seleccionar otro usuario</a></br>";
                }
            } else {
                // Inicialente solo mostrara el formulario de seleccion de alumno
                echo "<h3>Selecciona un usuario para ver sus notas</h3><br/>";
                echo "<form action='" . $_SERVER['PHP_SELF'] . "' method=post>";
                echo "<label>Usuarios</label><select class='s-4' name='apellido'>";
                // El select será UNICAMENTE de usuarios normales
                $usuarios = usuarios_normales($con);
                while ($fila_usuarios = crear_array($usuarios)) {
                    extract($fila_usuarios);
                    echo "<option value=$dni>$apellido</option>";
                }
                echo "</select></br><input type='submit' name=ver-notas value='Ver notas' /></br>";
            }

            disconnect($con);
            ?>
            <a href="../../administradores.php">Atras</a>
        </div>
    </div>
</body>

</html>