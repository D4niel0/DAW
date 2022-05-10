<?php
require_once("lib/nusoap.php");
$namespace = "http://localhost:8888/DWES/practicas/DAW_M07_T06_ACT_05_DanielAguilar/server/server.php";

$server = new soap_server();
$server->configureWSDL("StarWarsProducts",$namespace);
$server->schemTargetNamespace = $namespace;
$server->soap_defencoding = "UTF-8";

function prod_cat($cat){
	require_once("connection.php");
	$losProductos = array();
	$con = mysqli_connect($host, $user, $pass, $db_name);
	$query = "select nombre_prod, nombre_cat from producto p,categoria c where c.id_categoria=p.categoria and c.id_categoria=$cat";
	$productos = mysqli_query($con, $query);
	while($producto=mysqli_fetch_assoc($productos)){
		$losProductos[] = $producto;
	}
	mysqli_close($con);
	return $losProductos;
}

// DEFINIR TIPOS COMPLEJOS
$server->wsdl->addComplexType(
	'Producto',
	'complexType',
	'struct',	
	'sequence',
	'',
	array(
		'nombre_prod' => array('name'=>'nombre_prod', 'type'=>'xsd:string'),
		'nombre_cat' => array('name'=>'nombre_cat', 'type'=>'xsd:string'))
);

$server->wsdl->addComplexType(
	'ArrayProductos',
	'complexType',
	'array',
	'',
	'SOAP-ENC:Array',
	array(),
	array(array('ref'=>'SOAP-ENC:arrayType', 'wsdl:arrayType'=>'tns:Producto[]')),
	'tns:Producto'
);

// REGISTRAR FUNCION
$server->register(
	'prod_cat',
	array('cat'=>'xsd:int'),
	array('return'=>'tns:ArrayProductos'),
	$namespace,
	false,
	'rpc',
	'encoded',
	'Función que devuelve un array con los productos por categorias.'
);

$server->service(file_get_contents("php://input"));

?>
