<?php
require("../bbdd/database.php");

$con = conectar();

login($_POST["dni"],$_POST["apellido"],$con);

disconnect($con);
?>
