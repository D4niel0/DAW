<?php
        require("../bbdd/database.php");
        $con = conectar();
        // Para el logout destruye las sesiones abiertas y redirige al index
        session_destroy();
        disconnect($con);
        header("Location: ../index.php");
?>