<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td,
        th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }

        .button {
            background-color: #f4511e;
            border: none;
            color: white;
            padding: 16px 32px;
            text-align: center;
            font-size: 16px;
            margin: 12px 12px;
            opacity: 0.6;
            transition: 0.3s;
            display: inline-block;
            text-decoration: none;
            cursor: pointer;
        }

        .button:hover {
            opacity: 1
        }
    </style>
    <title>Futbolistas intergalácticos</title>
</head>

<body>
    <?php
    function cargar_clases($nombre_clase)
    {
        require_once("clases/" . $nombre_clase . ".php");
    }
    spl_autoload_register("cargar_clases");

    $futbolistas = array();
    $futbolistas[0] = new Portero("Anakin Skywalker", 1, 10, 20);
    $futbolistas[1] = new Portero("Luke Skywalker", 2, 33, 80);
    $futbolistas[2] = new Portero("Chewbacca", 8, 0, 100);
    $futbolistas[3] = new Jugador("Leia Organa", 4, 23, 180, 222);
    $futbolistas[4] = new Jugador("R2-D2", 22, 1, 1, 0);
    $futbolistas[5] = new Jugador("C-3PO", 3, 0, 1, 3);
    ?>
    <table>
        <tr>
            <th>Nombre</th>
            <th>Dorsal</th>
            <th>Valoración</th>
        </tr>
        <?php
        foreach ($futbolistas as $jugador) {
            echo "<tr>";
            echo "<td>" . $jugador->get_nombre() . "</td>";
            echo "<td>" . $jugador->get_dorsal() . "</td>";
            echo "<td>" . $jugador->get_valoracion() . "</td>";
            echo "</tr>";
        }
        ?>
    </table>
    <a class="button" href="../index.php">VOLVER</button>
</body>

</html>