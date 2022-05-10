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
		<div class="screen__content">
			<form action="login/login.php" method="POST" class="login">
				<div class="login__field">
					<i class="login__icon fas fa-user"></i>
					<input type="text" name='dni' class="login__input" placeholder="DNI">
				</div>
				<div class="login__field">
					<i class="login__icon fas fa-lock"></i>
					<input type="text" name='apellido' class="login__input" placeholder="Apellido">
				</div>
				<button type='submit' name='entrar' class="button login__submit">
					<span class="button__text">Entrar</span>
					<i class="button__icon fas fa-chevron-right"></i>
				</button>
				<?php
				// Control de errores, si hay un error de login, muestra un mensaje de error con un span
					session_start();
					if(isset($_SESSION["error_login"])) {
						echo "<span class='error'>".$_SESSION["error_login"]."</span>";
						unset($_SESSION["error_login"]);
					}
				?>				
			</form>

		</div>
		<div class="screen__background">
			<span class="screen__background__shape screen__background__shape4"></span>
			<span class="screen__background__shape screen__background__shape3"></span>		
			<span class="screen__background__shape screen__background__shape2"></span>
			<span class="screen__background__shape screen__background__shape1"></span>
		</div>		
	</div>
</div>

</body>

</html>