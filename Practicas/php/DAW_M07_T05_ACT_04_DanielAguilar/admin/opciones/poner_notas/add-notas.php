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
            // Si se ha pulsado sobre el boton de puntuar, se ejecuta la función
            if (isset($_POST["puntuar"])) {
                poner_nota($_POST["apellido"], $_POST["asignatura"], $_POST["nota"], $con);
                header('Location: ' . $_SERVER['PHP_SELF']);
            } else {
                echo "<form action=" . $_SERVER['PHP_SELF'] . " method=post>
                    <label>Usuarios</label>
                    <select class='s-1' name='apellido' >";
                // Los usuarios que mostrará para poner notas será UNICAMENTE los normales, no los administradores    
                $usuarios = usuarios_normales($con);
                while ($fila_usuarios = crear_array($usuarios)) {
                    extract($fila_usuarios);
                    echo "<option value=$dni>$apellido</option>";
                }
                echo    "</select><br/>";
                echo    "<label>Asignatura</label><select class='s-1' name='asignatura'>";
                $asignaturas = select_asignaturas($con);
                while ($fila_asignaturas = crear_array($asignaturas)) {
                    extract($fila_asignaturas);
                    echo "<option value=$id>$nombre</option>";
                }
                echo    "</select><br/>";
                echo    "<label>Nota</label><select class='s-2' name='nota' >";
                // El select de las notas va del 0 al 10
                for ($i = 0; $i < 11; $i++) {
                    echo "<option value=$i>$i</option>";
                }
                echo    "</select></br>";
                echo    "<input type='submit' name='puntuar' value='Puntuar' />";
                echo "</form>";
            }

            disconnect($con);

            ?>
            <a href="../../administradores.php">Atras</a>
        </div>
    </div>
</body>

</html>