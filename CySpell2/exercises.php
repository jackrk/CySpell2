<?php 
$problems = $_POST["problems"] - 1;
$grade = $_POST["grade"];
$arr = array();

// Access DB
$e = "";
try{
	$db = new PDO("sqlite:cyspell.db");
}
catch(PDOException $e){
	$e->getMessage();
}

// Get the Problems Table ()
$results = $db->query("SELECT * FROM problems");

$i = 0;
// Add the grades question-answer to arr
foreach($results as $row){
	$check1 = $row['grade'];
	if($grade == $row['grade']){
		$arr[$i] = array("picture" => $row['picture'], "answer" => $row['answer']);
		$i++;
	}	
}

if($problems >= 0) {
// Get a new picture and answer
$id = rand(0, count($arr));
$picture =  $arr[$id]['picture'];
$answer =  $arr[$id]['answer'];
echo <<<EOHTML
<html>
<head>
<link rel="stylesheet" href="css/styles.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="js/jquery.transit.min.js"></script>
<script>
$(document).ready(function(){
	$('#submitword').bind('mouseenter',function(){
		$(this).transition({backgroundColor: 'yellow',color: 'red',border: '2px solid yellow', queue: false},150);
		$(this).bind('mouseout',function() {
			$(this).transition({backgroundColor: '',color: 'yellow',border: '2px solid white', queue: false},150);
			$(this).unbind('mouseout');
			return false;
		});
		return false;
	});
	$('#spellhere').bind('focus', function() {
		$(this).transition({border: '2px dashed red', backgroundColor: ' yellow', queue: false},150);
		$(this).bind('blur',function() {
			$(this).transition({backgroundColor: 'yellow',border: '2px solid red', queue: false},150);
			$(this).unbind('blur');
			return false;
		});
		return false;
	});
	$('.cylink').bind('mouseenter',function(){
		$(this).transition({backgroundColor: 'yellow',color: 'red' ,border: '2px solid yellow', queue: false},150);
		$(this).bind('mouseout',function() {
			$(this).transition({backgroundColor: '',color: 'red',border: '2px solid white', queue: false},150);
			$(this).unbind('mouseout');
			return false;
		});
		return false;
	});
	setTimeout(function() {
		$('#spellhere').focus();
	}, 250);
});
</script>
</head>
<body>
<a class="cylink" href="main.php">Home</a><br/>
<br/>
<div class="exercisetext">$problems exercises left.</div>
<img src="$picture"  width="304" height="228"></img>
<span class="exercisetext">What is this?</span>
<form action="" method="post">
	<input type="hidden" name="problems" value="$problems">
	<input type="hidden" name="grade" value=$grade>
	<input id="spellhere" type="text" name="answer" autocomplete="off"><br>
	<input id="submitword" type="submit">
</form>

</body>
</html>

EOHTML;
}
else {	
echo <<<EOHTML
<html>
<head>
<link rel="stylesheet" href="css/styles.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="js/jquery.transit.min.js"></script>
<script>
$(document).ready(function() {
	$('.cylink').bind('mouseenter',function(){
		$(this).transition({backgroundColor: 'yellow',color: 'red',border: '2px solid yellow', queue: false},150);
		$(this).bind('mouseout',function() {
			$(this).transition({backgroundColor: '',color: 'red',border: '2px solid white', queue: false},150);
			$(this).unbind('mouseout');
			return false;
		});
		return false;
	});
});
</script>
</head>
<body>
<h1 class="maintitle"><img src="images/Cy-Spell-Logo.png"></h1>
<a class="cylink" href="main.php">Home</a><br/><br/>
EOHTML;
echo '
<form action="FlashCards.php" method="post">';
	foreach($arr as $val)
	{
		echo '<input type="hidden" name="arr[][picture]" value='; echo $val['picture']; echo '>';
	}
	echo '<input class="cylink" style="display: block; margin: 0 auto;" type="submit" value="Show FlashCards!">
</form>


<p>
<div class="exercisetext" >Thank you for playing! :)</div>
</p>

</body>
</html>';
}
?>