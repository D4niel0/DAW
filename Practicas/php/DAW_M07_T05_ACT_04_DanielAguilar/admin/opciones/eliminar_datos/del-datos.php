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
            // Tengo que crear dos variables para que no me de problemas al crear el array
            $users_tabla = usuarios_all($con);
            $users_mod = usuarios_all($con);
            $asignaturas = select_asignaturas($con);
            // Tabla que muestra los usuarios disponibles
            echo "<table class='tabla'>";
            echo "<tr><th>APELLIDO</th><th>ROL</th></tr>";
            // Filtrado de usuarios, si el usuario es administrador lo muestra como admin, si no como normal, construye la tabla
            while ($fila_user_tabla = crear_array($users_tabla)) {
                extract($fila_user_tabla);
                if ($tipo_usuario == 0) {
                    echo "<tr><td>$apellido</td><td>Administrador</td></tr>";
                } else {
                    echo "<tr><td>$apellido</td><td>Normal</td></tr>";
                }
            }
            echo "</table>";

            // La primera parte del formulario permite eliminar o acceder a un usuario para ver sus notas y eliminarlas una por una
            echo "<form action='accion-borrar.php' method=post>";
            echo "<h3 class='h3-as'>Selecciona un usuario para eliminarlo completamente o acceder a sus notas y eliminarlas una por una</h3><br/>";
            echo "<select class='s-1' name='usuario'>";
            while ($fila_user = crear_array($users_mod)) {
                extract($fila_user);
                echo "<option value=$dni>$apellido</option>";
            }
            echo "</select><input class='sel-button' type='submit' name='del-user' value='Eliminar usuario'/><input type='submit' name='del-notas' value='Acceder a notas'/></br>";
            // La segunda parte del formulario permite seleccionar una asignatura para eliminarla    
            echo "<h3 class='h3-as'>Selecciona una asignatura para eliminar</h3><br/>";
            echo "<select class='s-2' name='asignatura'>";
            while ($fila_asignatura = crear_array($asignaturas)) {
                extract($fila_asignatura);
                echo "<option value=$id>$nombre</option>";
            }
            echo "</select><input class='sel-button' type='submit' name='del-asign' value='Eliminar asignatura'/></br>";




            echo "</form>";

            disconnect($con);

            ?>
            <a href="../../administradores.php">Atras</a>
        </div>
    </div>
</body>

</html>