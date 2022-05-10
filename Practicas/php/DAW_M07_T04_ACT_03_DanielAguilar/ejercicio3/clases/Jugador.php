<?php
require_once("Futbolista.php");
    class Jugador extends Futbolista {
        private $pases;
        private $recuperaciones;
        private $valoracion;
        // Metodos
        // Constructor
        function __construct($nombre,$dorsal,$goles,$pases,$recuperaciones) {
            parent::__construct($nombre,$dorsal,$goles);
            $this->pases = $pases;
            $this->recuperaciones = $recuperaciones;
            $this->valoracion = ($pases*2)+($recuperaciones*3)+($goles*30);
        }
        // Getters & Setters
        function get_pases() {
            return $this->pases;
        }
        function set_pases($pases) {
            $this->pases = $pases;
        }
        function get_recuperaciones() {
            return $this->recuperaciones;
        }
        function set_recuperaciones($recuperaciones) {
            $this->recuperaciones = $recuperaciones;
        }
        function get_valoracion() {
            return $this->valoracion;
        }

        // toString
        function __toString() {
            return "FUTBOLISTA:<br/>".parent::__toString(). " | Pases: ".$this->pases.
                " | Recuperaciones: ".$this->recuperaciones." | Valoracion: ".$this->valoracion."<br/>";
        }

    }

?>