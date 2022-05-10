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

            // Se ejecuta sobre el propio formulario, si existe la variable "crear", es que se ha pulsado sobre el submit y se crea el usuario
            // con la funcion de crear_usuario, comprobando antes que no existiera
            if (isset($_POST["crear"])) {
                if (existe($_POST["dni"], $con) == 0) {
                    crear_usuario($_POST["dni"], $_POST["apellido"], $_POST["rol"], $con);
                    echo "<h3> Usuario " . $_POST["dni"] . " creado </h3><br/>";
                } else {
                    echo "<h3> El DNI " . $_POST["dni"] . " ya existe en el sistema </h3><br/>";
                }
            } else {
                echo "<form action='" . $_SERVER['PHP_SELF'] . "' method=POST>
                <label>DNI</label><input type='text' name='dni'/><br/>
                <label>Apellido</label><input type='text' name='apellido'/><br/>
                <input type='radio' name='rol' value='1'/><label>Usuario normal</label><br/>
                <input type='radio' name='rol' value='0'/><label>Usuario administrador</label><br/>
                <input type='submit' name='crear' value='Crear'/><br/>";
                echo "</form>";
            }

            disconnect($con);

            ?>
            <a href="../../administradores.php">Atrás</a>
        </div>
    </div>
</body>

</html>