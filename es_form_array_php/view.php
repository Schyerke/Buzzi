<?php
$array = [];
for($i=0; $i<10; $i++){
    $array[$i] = $_GET["input$i"];
}

print_r($array);


echo "<br>";
echo "<br>";

//crea un array associativo nel quale la chiave sarà ciascuno dei numeri inseriti dall'utente, e il valore sarà "piccolo" o "grande" a seconda se il numero è minore o maggiore di 100.
//Stampare l'array associativo nella pagina

$assocArray = [];
for($i=0; $i<10; $i++){
    if($array[$i] > 100){
        $assocArray[$array[$i]] = "grande";
    }else{
        $assocArray[$array[$i]] = "piccolo";
    }
}

print_r($assocArray);

?>