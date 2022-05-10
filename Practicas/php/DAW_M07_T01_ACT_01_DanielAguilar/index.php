<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DAW_M07_T01_ACT_01_DanielAguilar</title>
</head>

<body>
    <?php
    // ACTIVIDAD 1.1
    echo "<h2>Actividad 1.1</h2>";
    $euros = 20;
    define("DOLLAR", $euros * 1.14); // Valor del dollar
    define("YEN", $euros * 132.06); // Valor del yen
    echo "<p>$euros euros equivalen a " . DOLLAR . " y " . YEN . " yenes.</p>";

    // ACTIVIDAD 1.2
    echo "<h2>Actividad 1.2</h2>";
    $secElegidos = 8000;
    // El resto de dividir entre 60 son los segundos
    $secResult = 8000 % 60;
    // El resto de dividir dos veces entre 60 son los minutos
    $minResult = (8000 / 60) % 60;
    // El resultado de dividir dos veces entre 60 son las horas
    $horResult = floor((8000 / 60) / 60);
    echo "<p>$secElegidos segundos son $horResult horas, $minResult minutos y $secResult segundos</p>";

    // ACTIVIDAD 1.3
    echo "<h2>Actividad 1.3</h2>";
    $coA = 5;
    $coB = 10;
    $coC = 1;
    echo "<p> Los coeficientes son $coA, $coB y $coC</p>";
    // Formula => (-b+-sqrt(b^2-4*a*c))/(2*a))
    // Calculo la primera parte => -b / (2*a)
    $primero = -$coB / (2 * $coA);
    // Calculo la segunda parte => sqrt(b^2-4*a*c)) / (2*a)
    $segundo = (sqrt(pow($coB, 2) - 4 * $coA * $coC)) / (2 * $coA);
    // Saco los resultados => $primero +- $segundo
    $resultado1 = $primero + $segundo;
    $resultado2 = $primero - $segundo;

    echo "<p>Resultado 1: $resultado1 , Resultado 2: $resultado2 </p>";

    // ACTIVIDAD 1.3
    echo "<h2>Actividad 1.4</h2>";
    $radio = 10;
    echo "<p>El radio de la circunferencia son $radio cm</p>";
    $longitud = 2 * M_PI * $radio; // L = 2 * pi * radio
    echo "<p>La longitud de la circunferencia son " . sprintf("%.2f", $longitud) . " cm</p>";
    $area = M_PI * pow($radio, 2); // A = pi * R^2
    echo "<p>El area de la circunferencia es " . sprintf("%.2f", $area) . " cm cuadrados</p>";
    $volumen = (4 * M_PI * pow($radio, 3)) / 3; // V = (4 * pi * R^3) / 3
    echo "<p>El volumen de la esfera es " . sprintf("%.2f", $volumen) . " cm cúbicos</p>";

    // ACTIVIDAD 1.3
    echo "<h2>Actividad 1.5</h2>";
    $filas = 20;
    // Indico 5 columnas ya que el bucle de colores hara que con 4 colores entre 4 veces dentro y forme 20
    $columnas = 5;
    $celda = 1;
    $colores = array("background-color:gold;", "background-color:chartreuse;", "background-color:aqua;", "background-color:red;");
    echo "<table border='1px'>";
    for ($i = 0; $i < $filas; $i++) {
        echo "<tr>";
        for ($k = 0; $k < $columnas; $k++) {
            for ($u = 0; $u < count($colores); $u++) {
                echo "<td style=" . $colores[$u] . ">$celda</td>";
                $celda++;
            }
        }
        echo "</tr>";
    }
    echo "</table>";

    ?>

</body>

</html>