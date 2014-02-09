<!DOCTYPE html>
<html>
	<head>
		<title>Create a pop-up bakeshop</title>
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	</head>
	<body>
		<!-- navbar -->
		<h1>Create a pop-up bakeshop</h1>
		<form name="create_popup" method="POST">
			<p>Name of the pop-up: <input type="text" name="name" placeholder=""></p>
			<p>Staff: </p>
			<ul>
				<li><input type="email" name="staff" class="staff"></li><button id="add_staff">%2B</button>
			</ul>
			<p>Location: <input type="text" name="location"></p>
			<p>Image: <input type="image" name="image"></p>
			<p>Pop-up theme: <input type="text" name="theme"></p>
			<p>Description: <input type="text" name="description"></p>
			<input type="submit" value="Create!">
		</form>
	</body>
</html>