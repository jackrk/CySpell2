<?php
$grade = $_POST["grade"];
$arr = array();
$e = "";
try{
	$db = new PDO("sqlite:cyspell.db");
}
catch(PDOException $e){
	$e->getMessage();
}

// Get the Problems Table ()
$results = $db->query("SELECT * FROM problems WHERE grade = '2'");

// Add the grades question-answer to arr
$i = 0;
foreach($results as $row){
	$arr[$i] = array("picture" => $row['picture'], "answer" => $row['answer']);
	$i++;
}

echo <<<EOHTML
<html>
<head>
<link rel="stylesheet" href="css/styles.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="js/jquery.transit.min.js"></script>
<script>
$(document).ready(function(){
	$('.flashpic').bind('click',function(){
		var op = $(this).css('opacity');
		if (op > 0)	{
			$(this).transition({opacity: 0, queue: false},150);
			$(this).next().transition({opacity: 1, queue: false},150);
		}
		else {
			$(this).transition({opacity: 1, queue: false},150);
			$(this).next().transition({opacity: 0, queue: false},150);
		}
		return false;
	});
});
</script>
</head>
<body>
<a class="cylink" href="main.php">Home</a><br/>
EOHTML;

foreach($arr as $array){
	$picture = $array['picture'];
	$answer = $array['answer'];
	echo'
	<br/>
	<img class="flashpic" title="Click to see the answer!!" style="cursor: pointer; z-index: 3; align: middle; margin: 0 auto;" src='; echo $picture;
	echo' width="304" height="228">
	<div class="flashanswer" style="cursor: pointer; color: red; opacity: 0; align: middle; margin: 0 auto; font-size: 30px; position: relative; top: -106px;">'; echo $answer; echo'</div>
	<br/>
	';
}
echo '
</body>
</html>
'
?>
