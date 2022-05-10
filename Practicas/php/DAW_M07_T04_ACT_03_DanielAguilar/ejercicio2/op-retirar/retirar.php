<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../styles.css">
    <title>Despegar</title>
</head>

<body>
    <div class="login-box">
        <h2>Indica que nave quieres retirar</h2>
        <form action="../central/parking.php" method="post">
            <div class="user-box">
                <input type="text" name="num1" required="">
                <label>Número de plaza</label>
            </div>
            <div class="text-radio">
                <input type="radio" name="size_des" value="big_des" required>
                <label>Grande</label>
            </div>
            <div class="text-radio">
                <input type="radio" name="size_des" value="small_des">
                <label>Pequeña</label>
            </div>
            <input type="submit" value="Despegar">
            <a class="volver" href="../inicio.php">Atrás</a>
        </form>
        <?php
        session_start();
        if (isset($_SESSION["despegue"])) {
            echo $_SESSION["despegue"];
            unset($_SESSION["despegue"]);
            // Redirige a los 3 segundos al inicio
            header("Refresh: 3; url=../inicio.php");
        }
        ?>
    </div>
</body>

</html>