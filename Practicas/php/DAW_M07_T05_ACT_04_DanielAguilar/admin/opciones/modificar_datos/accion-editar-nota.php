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
            // Desde esta pagina se modifican a mano las notas individualmente
            require("../../../bbdd/database.php");
            $con = conectar();
            // Si se ha pulsado sobre el botón de cambiar, se ejecuta la función
            if (isset($_POST["cambiar"])) {
                modificar_notas($_SESSION["dni_notas"], $_SESSION["asignatura"], $_POST["nota"], $con);
                header("Location: notas-editables.php");
            } else {
                echo "<form action='" . $_SERVER["PHP_SELF"] . "' method='post'>";
                $_SESSION["asignatura"] = $_GET["id"];
                echo "<h3 class='h3-sn'>Selecciona una nueva nota:</h3>";
                echo    "<label>Nota</label><select class='s-3' name='nota' >";
                // El select de las notas va del 0 al 10
                for ($i = 0; $i < 11; $i++) {
                    echo "<option value=$i>$i</option>";
                }
                echo    "</select></br>";
                echo "<input type='submit' name='cambiar' value='Cambiar' />";
                echo "</form>";
            }

            disconnect($con);
            ?>
            <a href="notas-editables.php">Atras</a>
        </div>
    </div>
</body>

</html>