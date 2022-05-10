<?php
require_once("Futbolista.php");
    class Portero extends Futbolista {
        private $paradas;
        private $valoracion;
        // Metodos
        // Constructor
        function __construct($nombre,$dorsal,$goles,$paradas) {
            parent::__construct($nombre,$dorsal,$goles);
            $this->paradas = $paradas;
            $this->valoracion = $paradas*5+($goles*30);
        }
        // Getters & Setters
        function get_paradas() {
            return $this->paradas;
        }
        function set_paradas($paradas) {
            $this->paradas = $paradas;
        }
        function get_valoracion() {
            return $this->valoracion;
        }

        // toString
        function __toString() {
            return "FUTBOLISTA:<br/>".parent::__toString(). " | Paradas: ".$this->paradas.
                                                            " | Valoracion: ".$this->valoracion."<br/>";
        }

    }

?>