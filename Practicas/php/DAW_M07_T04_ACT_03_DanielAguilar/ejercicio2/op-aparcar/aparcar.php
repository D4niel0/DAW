<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../styles.css">
  <title>Aterrizar</title>
</head>

<body>
  <div class="login-box">
    <h2>Indica que tipo de nave tienes</h2>
    <form action="../central/parking.php" method="post">
      <div class="text-radio">
        <input type="radio" name="size" value="big" required>
        <label>Grande</label>
      </div>
      <div class="text-radio">
        <input type="radio" name="size" value="small">
        <label>Pequeña</label>
      </div>
      <input type="submit" value="Aterrizar">
      <a class="volver" href="../inicio.php">Atrás</a>

    </form>
    <?php
        session_start();
        if (isset($_SESSION["huecos"])) {
          echo $_SESSION["huecos"];
          unset($_SESSION["huecos"]);
          // Redirige a los 3 segundos al inicio
          header("Refresh: 3; url=../inicio.php");
      }
      ?>
  </div>
</body>

</html>