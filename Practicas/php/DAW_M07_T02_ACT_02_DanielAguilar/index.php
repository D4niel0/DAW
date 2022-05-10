<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DAW_M07_T02_ACT_02_DanielAguilar</title>
</head>
<body>
    <?php
        // Inicio variables de sesion para hacer uso de ellas
        session_start();
        // EJERCICIO 1.1
        echo "<h2>Ejercicio 1.1</h2>";
        $notas = array("David" => 9, "Sandra" => 3, "Alicia" => 5, "Dani" => 8, "Luis" => 7);
        asort($notas); // Ordena de menor a mayor
        end($notas); // Pone el puntero del Array al final
        echo "La nota mas alta es la de ".key($notas)." con un ".end($notas).".<br/>";
        reset($notas); // Pone el puntero del Array al principio
        echo "La nota mas baja es la de ".key($notas)." con un ".reset($notas).".<br/>";
        echo "La nota media de la clase es ".calculaMedia($notas)."<br/>";
        // Mostrar las notas de menor a mayor     
        foreach($notas as $clave => $valor) {
            echo "$clave - $valor <br/>";
        }
        // EJERCICIO 1.2
        echo "<h2>Ejercicio 1.2</h2>";
        echo "<a href='calculadora.html'>Ir al ejercicio 1.2</a>";

        // EJERCICIO 1.3
        echo "<h2>Ejercicio 1.3</h2>";       
    ?>
        <form action="bucle.php" method="post">
            <label>Cuantas veces?</label>
            <input type="text" name="cuantas">
            <input type="submit" value="Enviar">
        </form>
    <?php
        // Si existe la variable de sesion de error la muestra y luego la borra
        if(isset($_SESSION["error1"])) {
            echo $_SESSION["error1"];
            unset($_SESSION["error1"]);
        }
        // Si existe la variable de sesion de no_INT la muestra y luego la borra
        if(isset($_SESSION["no_INT"])) {
            echo $_SESSION["no_INT"];
            unset($_SESSION["no_INT"]);
        }        
        // Si existe la variable de sesion de resultado la muestra y luego la borra
        if(isset($_SESSION["resultado"])) {
            foreach($_SESSION["resultado"] as $valor) {
                echo $valor;
            }
            unset($_SESSION["resultado"]);
        }

        // EJERCICIO 1.4
        echo "<h2>Ejercicio 1.4</h2>";  
    ?>
        <form action="examenes.php" method="post">
            <label>Introduce la nota</label>
            <input type="text" name="nota">
            <input type="submit" value="Enviar">
        </form>        
    <?php
        // Si existe la variable de sesion de error la muestra y luego la borra
        if(isset($_SESSION["error2"])) {
            unset($_SESSION["tu_nota"]); // Hago este unset porque me pintaba "Matricula de Honor" al controlar errores
            echo $_SESSION["error2"];
            unset($_SESSION["error2"]);
        }
        // Si existe la variable de sesion de no_FLOAT la muestra y luego la borra
        if(isset($_SESSION["no_FLOAT"])) {
            unset($_SESSION["tu_nota"]); // Hago este unset porque me pintaba "Matricula de Honor" al controlar errores
            echo $_SESSION["no_FLOAT"];
            unset($_SESSION["no_FLOAT"]);
        }

        if(isset($_SESSION["tu_nota"])) {
            echo $_SESSION["tu_nota"];
            unset($_SESSION["tu_nota"]);
        }    
           
        // EJERCICIO 1.5
        echo "<h2>Ejercicio 1.5</h2>"; 
    ?>

        <form action="dni.php" method="post">
            <label>Introduce un DNI sin la letra</label>
            <input type="text" name="dni">
            <input type="submit" value="Enviar">
        </form>        

        <?php
        // Si existe la variable de sesion de error la muestra y luego la borra
        if(isset($_SESSION["error3"])) {
            echo $_SESSION["error3"];
            unset($_SESSION["error3"]);
        }
        // Si existe la variable de sesion de no_INT_dni la muestra y luego la borra
        if(isset($_SESSION["no_INT_dni"])) {
            echo $_SESSION["no_INT_dni"];
            unset($_SESSION["no_INT_dni"]);
        }        

        if(isset($_SESSION["no_todos_num"])) {
            echo $_SESSION["no_todos_num"];
            unset($_SESSION["no_todos_num"]);
        }  

        if(isset($_SESSION["letra_dni"])) {
            echo $_SESSION["letra_dni"];
            unset($_SESSION["letra_dni"]);
        }    
           
    ?>

</body>
</html>


<?php
// Funcion para calcular la media de notas del ejercicio 1.1
function calculaMedia($notas) {
    $media = 0;
    foreach($notas as $clave => $valor) {
        $media = $media + $valor;
    }
    return $media/count($notas);
}



?>