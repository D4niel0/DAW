<?php
session_start();
$host = "localhost";
$user = "root";
$pass = "4246"; // OJO!!! Cambia el pass al que uses tu, yo uso este desde hace mucho, me daba problemas si lo cambiaba a "root"
$db_name = "instituto";

function conectar() {
    $con = mysqli_connect($GLOBALS["host"],$GLOBALS["user"],$GLOBALS["pass"],$GLOBALS["db_name"]) or die("Error de conexión a la BBDD");
    return $con;
}

// Numero de filas
function num_filas($resultado) {
    return mysqli_num_rows($resultado);
}


// Login
// Recibe por parametro el dni, el apellido y la conexión. Con el DNI y el Apellido ejecuta la query, comprueba el numero de filas,
// Si es igual a 0 indica que no se ha encontrado y redirije atrás en 3 segundos
// Si ecuentra el usuario, primero pasa el resultado a un array asociativo, almacena el DNI y el tipo de usuario en variables de sesión,
// y comprueba si el tipo de usuario es administrador o normal para redirigir a una página u a otra
function login($dni,$apellido,$con) {
    $query = "select * from USUARIO where dni='".$dni."' and apellido='".$apellido."'";
    $resultado = mysqli_query($con,$query);
    if (num_filas($resultado) == 0) {
        $_SESSION["error_login"] = "El usuario no existe / DNI o Apellido incorrectos";
        header("Location: ".$_SERVER['HTTP_REFERER']);
    } else {
        $contenido = mysqli_fetch_assoc($resultado);
        $_SESSION["dni_sesion"] = $dni;
        $_SESSION["tipo_usuario"] = $$contenido["tipo_usuario"];
        if ($contenido["tipo_usuario"] == 0) {
            header("Location: ../admin/administradores.php");
        } else {
            header("Location: ../users/alumnos.php");
        }
    }
} 

// Crear usuarios
// Recibe por parametro el dni, apellido, rol y la conexión, construye la query y la ejecuta
function crear_usuario($dni,$apellido,$rol,$con) {
    $query = "insert into USUARIO values('".$dni."','".$apellido."',".$rol.")";
    mysqli_query($con,$query);
}

// Crear asignaturas
// Recibe por parametro el nombre y la conexión, construye la query y la ejecuta
function crear_asignatura($nombre,$con){
    $query = "insert into ASIGNATURA(nombre) values('".$nombre."')";
    mysqli_query($con,$query);
}

// Select de usuarios normales
function usuarios_normales($con) {
    $query = "select * from USUARIO where tipo_usuario=1";
    return mysqli_query($con,$query);
}

// Select de asignaturas
function select_asignaturas($con) {
    $query = "select * from ASIGNATURA";
    return mysqli_query($con,$query);
}

// Select todos los usuarios
function usuarios_all($con) {
    $query = "select * from USUARIO";
    return mysqli_query($con,$query);
}

// Poner nota
function poner_nota($apellido,$asignatura,$nota,$con) {
    $query = "insert into NOTA values('".$apellido."',$asignatura,$nota)";
    mysqli_query($con,$query);
}


// Tipo de usuario
function tipo_usuario($dni,$con) {
    $query = "select tipo_usuario from USUARIO where dni='".$dni."'";
    $resultado = mysqli_query($con,$query);
    $resultado = mysqli_fetch_array($resultado);
    return $resultado["tipo_usuario"];
}

// Borrar notas
function borrar_notas($dni,$con) {
    $query = "delete from NOTA where alumno='".$dni."'";
    mysqli_query($con,$query);
}

// Modificar usuario
function mod_usuario($dni,$apellido,$rol,$con) {
    $query = "update USUARIO set apellido='".$apellido."', tipo_usuario=$rol where dni='".$dni."'";
    mysqli_query($con,$query);
}

// Modificar asignatura
function mod_asignatura($id,$nombre,$con) {
    $query = "update ASIGNATURA set nombre='".$nombre."' where id=$id";
    mysqli_query($con,$query);
}

// Mostrar notas
function mostrar_notas($dni,$con) {
    $query = "select u.apellido, a.nombre, n.nota, n.asignatura from USUARIO u, NOTA n, ASIGNATURA a where u.dni='".$dni."' and n.alumno='".$dni."' and n.asignatura=a.id";
    return mysqli_query($con,$query);
}


// Modificar notas
function modificar_notas($dni,$asignatura,$nota,$con) {
    $query = "update NOTA set nota=".$nota." where alumno='".$dni."' and asignatura=".$asignatura."";
    mysqli_query($con,$query);
}

// Borrar usuario
function del_user($dni,$con) {
    $query = "delete from USUARIO where dni='".$dni."'";
    mysqli_query($con,$query);
}

// Borrar asignatura
function del_asign($id,$con) {
    $query = "delete from ASIGNATURA where id=".$id."";
    mysqli_query($con,$query);
}

// Borrar notas
// Se construye la query primero filtrando por el DNI, luego se recorren las asignaturas seleccionadas, y se van poniendo comas, cuando
// llega al final se pone un 0) para quitar la coma y cerrar la consulta antes de enviarla
function del_notas($asignaturas,$dni,$con) {
    $query = "delete from NOTA where alumno='".$dni."' and asignatura in (";
    foreach($asignaturas as $codigo){
        $query = $query."$codigo, ";
    }
    $query = $query."0)";
    mysqli_query($con,$query);
}

// Select de apellido por DNI
// Devuelve el apellido, lo uso para la bienvenida de los alumnos
function bienvenida($dni,$con) {
    $query = "select apellido from USUARIO where dni='".$dni."'";
    $apellido = mysqli_query($con,$query);
    $apellido = mysqli_fetch_array($apellido);
    extract($apellido);
    return $apellido;
}

// Funcion para controlar si un DNI ya existe a la hora de crear un nuevo usuario
// Si el usuario existe devuelve 1, si no, devuelve 0
function existe($dni,$con) {
    $query = "select * from USUARIO where dni='".$dni."'";
    $resultado = mysqli_query($con,$query);
    if (num_filas($resultado) == 0) {
        return 0;
    } else {
        return 1;
    }
} 




// Funcion para crear arrays para selects
function crear_array($resultado) {
    return mysqli_fetch_array($resultado);
}


function disconnect($con) {
    mysqli_close($con);
}


?>