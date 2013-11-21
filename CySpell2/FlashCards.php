<?php
$arr = $_POST["arr"];
echo <<<EOHTML
<html>
<head>
<link rel="stylesheet" href="css/styles.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="js/jquery.transit.min.js"></script>
<body>
<a class="cylink" href="main.php">Home</a><br/>
EOHTML;

foreach($arr as $array){
	$picture = $array['picture'];
	echo'
	<br/>
	<img style="align: middle; margin: 0 auto;" src='; echo $picture;
	echo' width="304" height="228">
	<br/>
	';
}
echo '
</body>
</html>
'
?>
