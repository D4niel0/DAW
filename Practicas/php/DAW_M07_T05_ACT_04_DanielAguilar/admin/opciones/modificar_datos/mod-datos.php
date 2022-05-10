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

            // Formulario, varias opciones, la primera para modificar usuarios
            echo "<h3>Selecciona un usuario para modificar</h3><br/>";
            echo "Puedes acceder a las notas del usuario pulsando en Modificar Notas para editarlas";
            echo "<form action='accion-modificar.php' method=post>
              <select class='s-1' name='usuario'>";
            while ($fila_user = crear_array($users_mod)) {
                extract($fila_user);
                echo "<option value=$dni>$apellido</option>";
            }
            echo "</select></br>";
            echo "<label>Nuevo apellido</label><input type='text' name='apellido' /></br/>";
            echo "<label>Nuevo rol <span>(Importante, si el usuario no era administrador, al pasar a administrador sus notas serán eliminadas)</span></label></br>";
            echo "<input type='radio' name='rol' value='1' checked/><label>Usuario normal</label><br/>";
            echo "<input type='radio' name='rol' value='0'/><label>Usuario administrador</label><br/>";
            // Control de errores campos vacios
            if (isset($_SESSION["error_mod"])){
                echo "<label class=error>".$_SESSION["error_mod"]."</label>";
                unset($_SESSION["error_mod"]);
            }
            echo "<input type='submit' name='mod-user' value='Modificar Usuario' />";
            // Desde esta opción se puede ir a una vista de notas
            echo "<input type='submit' name='mod-nota' value='Modificar Notas' /><br/>";
            // Opciones del formulario para la modificación de asignaturas, no añado tabla ya que de las asignaturas solo mostramos el nombre      
            echo "<h3 class='h3-as'>Selecciona una asignatura para modificar</h3><br/>";
            echo "<select class='s-2' name='asignatura'>";
            while ($fila_asignatura = crear_array($asignaturas)) {
                extract($fila_asignatura);
                echo "<option value=$id>$nombre</option>";
            }
            echo "</select></br>";
            echo "<label>Nuevo nombre</label><input type='text' name='nombre' /></br/>";
            // Control de errores campos vacios
            if (isset($_SESSION["error_mod_asgn"])){
                echo "<label class=error>".$_SESSION["error_mod_asgn"]."</label>";
                unset($_SESSION["error_mod_asgn"]);
            }
            echo "<input type='submit' name='mod-asign' value='Modificar Asignatura' /><br/>";
            echo "</form>";

            disconnect($con);
            ?>
            <a href="../../administradores.php">Atras</a>
        </div>
    </div>

</body>

</html>