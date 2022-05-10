<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <title>AparcaTuNave.com</title>
</head>

<body>
<?php    
session_start();
// Crear el parking
// Usa la funcion del constructor de parkings para crear un array y guardarlo en la variable de sesión al inicio del programa
if (!isset($_SESSION["pla_big"])) {
    $_SESSION["pla_big"] = cons_parking(13);
}
if (!isset($_SESSION["pla_small"])) {
    $_SESSION["pla_small"] = cons_parking(9);
}
?>
    <div class="login-box">
        <h2>AparcaTuNave.com</h2>
        <form action="opciones.php" method="post">
            <h3 style="color:white">Selecciona una opción</h3>
            <div class="text-radio">
                <input type="radio" name="opcion" value="aparcar">
                <label>Aparcar nave</label>
            </div>
            <div class="text-radio">
                <input type="radio" name="opcion" value="retirar">
                <label>Retirar nave</label>
            </div>
            <div class="text-radio">
                <input type="radio" name="opcion" value="estado">
                <label>Ver estado del parking</label>
            </div>
            <input type="submit" value="Enviar">
            <a class="volver" href="../index.php">Volver al index</a>
        </form>
    </div>
</body>

</html>

<?php
// Constructor de parkings
function cons_parking($tamanyo)
{
    $parking = array();
    for ($i = 0; $i < $tamanyo; $i++) {
        $parking[$i] = 0;
    }
    return $parking;
}
?>