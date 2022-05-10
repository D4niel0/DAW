<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/lightsaber.css">
    <title>Document</title>
</head>
<body>
<div class="container">
        <div class="screen">
            <?php
                require("server/connection.php");
                require_once("server/lib/nusoap.php");
                $con = conectar();
                $client = new soapclient("http://localhost:8888/DWES/practicas/DAW_M07_T06_ACT_05_DanielAguilar/server/server.php?wsdl");
                $categorias = categorias($con);

                if(isset($_POST["ver"])) {
                    $result = $client->prod_cat($_POST["categoria"]);             
                    echo "<table class='tabla'>";
                    echo "<tr><th>Nombre de producto</th><th>Nombre de categoría</th></tr>";
                    foreach ($result as $producto) {
                        $array = json_decode(json_encode($producto),true);
                        echo "<tr><td>".$array["nombre_prod"]."</td><td>".$array["nombre_cat"]."</td></tr>";
                    }
                    echo "</table>";
                    echo "<h3 class='exit'>Pulsa el laser para salir</h3>";
                    echo "<div class='lightsaber'>"; 
                    echo    "<label for='darth-vader-example'></label>";
                    echo    "<input type='checkbox' id='darth-vader-example' checked='checked'>";
                    echo    "<div class='switch'></div>";
                    echo    "<div class='plasma vader'></div>";
                    echo "</div>";
                } else {
                    echo "<form action=".$_SERVER["PHP_SELF"]." method=post>";
                    echo "<label>Selecciona una categoria:</label><br/>";
                    echo "<select name='categoria'>";
                    while ($categoria = obtener_resultados($categorias)) {
                        extract($categoria);
                        echo "<option value=$id_categoria>$nombre_cat</option>";
                    }
                    echo "</select>";
                    echo "<input type='submit' value='Ver' name='ver'>";
                    echo "</form>";
                }

        

            ?>
        </div>
    </div>
    
    <script>
        var sable = document.getElementById("darth-vader-example");
        sable.addEventListener("click",salir);
        function salir() {
            window.setTimeout(function(){
                location.reload()
            },1000);
        }
    </script>    

</body>
</html>