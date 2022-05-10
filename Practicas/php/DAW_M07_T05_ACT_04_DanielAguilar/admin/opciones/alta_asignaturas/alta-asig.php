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

            // Se ejecuta sobre el propio formulario, si existe la variable "crear", es que se ha pulsado sobre el submit y se crea la asignatura
            // con la funcion de crear_asignatura, luego muestra el nombre, en caso contrario muestra el formulario
            if (isset($_POST["crear"])) {
                crear_asignatura($_POST["nombre"], $con);
                echo "<h3> Asignatura " . $_POST["nombre"] . " creada </h3><br/>";
            } else {
                echo "<form action='" . $_SERVER['PHP_SELF'] . "' method=POST>
                <label>Nombre de asignatura: </label><input type='text' name='nombre'/><br/>
                <input type='submit' name='crear' value='crear'/><br/>";
                echo "</form>";
            }

            disconnect($con);

            ?>
            <a href="../../administradores.php">Atrás</a>
        </div>
    </div>
</body>

</html>