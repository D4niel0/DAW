<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../styles.css">
    <title>Estado actual</title>
</head>

<body>
    <div class="login-box">
        <?php
        session_start();
        recorre();
        ?>
        <br><br>
        <a class="volver" href="../inicio.php">Atrás</a>
    </div>
</body>

</html>

<?php
// FUNCIONES
// Función para recorrer la variable de sesion de plazas pequeñas y grandes, crea primero una tabla para las pequeñas, recorre con
// for each, y crea tds filtrando en 0 y 1 para pintar de colo verde o rojo según si está ocupado o no, luego hace lo mismo con las grandes
function recorre()
{
    echo "<h2>Plazas pequeñas</h2>";
    echo "<table border='white'>";
    echo "<tr>";
    foreach ($_SESSION["pla_small"] as $valor => $key) {
        if ($key == 0) {
            echo "<td style='background-color:green;'>$key</td>";
        } else {
            echo "<td style='background-color:red; color:white'>$key</td>";
        }
    }
    echo "</tr>";
    echo "</table></br>";
    echo "<h2>Plazas grandes</h2>";
    echo "<table border='white'>";
    echo "<tr>";
    foreach ($_SESSION["pla_big"] as $valor => $key) {
        if ($key == 0) {
            echo "<td style='background-color:green;'>$key</td>";
        } else {
            echo "<td style='background-color:red; color:white'>$key</td>";
        }
    }
    echo "</tr>";
    echo "</table></br>";
}


?>