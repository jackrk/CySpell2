<?php
$grade = $_GET['grade'];
?>
<html>
	<head>
		<link rel="stylesheet" href="css/styles.css">
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
		<script src="js/jquery.transit.min.js"></script>
		<script>
			$(document).ready(function() {
				$('#submitword').bind('mouseenter', function() {
					$(this).transition({
						backgroundColor : 'yellow',
						color : 'red',
						border : '2px solid yellow',
						queue : false
					}, 150);
					$(this).bind('mouseout', function() {
						$(this).transition({
							backgroundColor : '',
							color : 'white',
							border : '2px solid white',
							queue : false
						}, 150);
						$(this).unbind('mouseout');
						return false;
					});
					return false;
				});
				$('.cylink').bind('mouseenter', function() {
					$(this).transition({
						backgroundColor : 'yellow',
						color : 'red',
						border : '2px solid yellow',
						queue : false
					}, 150);
					$(this).bind('mouseout', function() {
						$(this).transition({
							backgroundColor : '',
							color : 'red',
							border : '2px solid white',
							queue : false
						}, 150);
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
		<a class="cylink" href="main.php">Back</a>
		<br/>
		<br/>

		<span class="exercisetext">Level: <?php echo $grade?></span>

		<form action="exercises.php" method="post">
			<input type="hidden" name="grade" value=<?php echo $grade; ?>>
			<div id="dropdowncont">
				<select id="probsdropdown" name="problems">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10" selected>10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
				</select>
			</div>
			<div style="color: red; font-size: 30px; font-family: helvetica; top: -40px; position: relative;" >Problems </div>
			<br>
			<input id="submitword" style="display: block; margin: 0 auto;" type="submit" value="Start Quiz!">
		</form>

	</body>
</html>
