<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<form action="view.php" method="get">
    <?php
    //generate a form with 10 input fields using php
    for($i = 0; $i < 10; $i++){
        echo "<br>";
        echo "<label for='input$i'>Input $i</label>";
        echo "<br>";
        echo "<input type='text' name='input$i' value='' required>";
    }
    ?>
    <br>
    <input type="submit" value="submit">
</form>

</body>
</html>