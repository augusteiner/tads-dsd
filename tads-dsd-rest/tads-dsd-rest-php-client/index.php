<?php

include 'src/autoload.php';

use io\tads\dsd\rest\php\ApiClient;
use io\tads\dsd\rest\php\Configuration;
use io\tads\dsd\rest\php\stub\CalculadoraApi;

$config = new Configuration();
$config->setHost('http://java-server:8080');

$client = new ApiClient($config);

$calculadora = new CalculadoraApi($client);

$a = $argv[1];
$b = $argv[2];

$r = $calculadora->soma($a, $b);

printf("%s + %s = %s\n", $a, $b, $r);

var_dump($calculadora->soma($a, $b));

