<!DOCTYPE html>
<html>
<head>
	<title>Add Students</title>
	<link rel="stylesheet" href="teststyle.css">
</head>
<body>
	<header>
		<h1>College Admin Page</h1>
	</header>
	<nav>
		<ul>
			<li><a href="#">Home</a></li>
			<li><a href="#">Students</a></li>
			<li><a href="#">Faculty</a></li>
			<li><a href="#">Courses</a></li>
			<li><a href="#">Settings</a></li>
		</ul>
	</nav>
	<main>
		<section>
			<h2>Welcome to the College Admin Page</h2>
			<p>This page is designed for the college administration to add students into the databases.</p>
		</section>
		<section>
			<h2>Admin Information</h2>
			<form action="data_insertion_notice.php" method="POST">
				<label for="name">Notice Description:</label>
				<input type="text" id="name" name="name" required>
				
				<label for="branch">For:</label>
				<select id="branch" name="branch">
					<option value="students">students</option>
					<option value="teachers">teachers</option>
					<option value="admins">admins</option>
					
				</select>
				

				<input type="submit" value="Submit">
			</form>
		</section>
	</main>
	<footer>
		<p>&copy; 2023 College Admin Page</p>
	</footer>
</body>
</html>