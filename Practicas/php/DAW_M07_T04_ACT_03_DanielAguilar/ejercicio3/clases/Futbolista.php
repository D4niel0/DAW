<?php

class Futbolista {
    private $nombre;
    private $dorsal;
    private $goles;

    // Metodos
    // Constructor
    function __construct($nombre,$dorsal,$goles) {
        $this->nombre = $nombre;
        $this->dorsal = $dorsal;
        $this->goles = $goles;
    }
    // Getters & Setters
    function get_nombre() {
        return $this->nombre;
    }
    function set_nombre($nombre) {
        $this->nombre = $nombre;
    }
    function get_dorsal() {
        return $this->dorsal;
    }
    function set_dorsal($dorsal) {
        $this->dorsal = $dorsal;
    }
    function get_goles() {
        return $this->goles;
    }
    function set_goles($goles) {
        $this->goles = $goles;
    }
    // toString
    function __toString() {
        return "FUTBOLISTA: <br/>Nombre: ".$this->nombre." | Dorsal: ".$this->dorsal." | Goles: ".$this->goles."<br/>";
    }


}

?>