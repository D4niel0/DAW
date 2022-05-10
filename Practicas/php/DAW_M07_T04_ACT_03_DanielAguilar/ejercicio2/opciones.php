<?php
    session_start();
    if ($_POST["opcion"] == "aparcar") {
        header("Location: op-aparcar/aparcar.php");
    }
    if ($_POST["opcion"] == "retirar") {
        header("Location: op-retirar/retirar.php");
    }
    if ($_POST["opcion"] == "estado") {
        header("Location: op-estado/estado.php");
    }
