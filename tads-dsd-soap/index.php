<?php

$calculadora = new SoapClient('http://localhost:9090/CalculadoraService?wsdl');

// var_dump($calculadora->__getFunctions());

$numero = $argc > 1 ? $argv[1] : 6;

printf("%s! = %s\n", $numero, $calculadora->fatorial($numero));
