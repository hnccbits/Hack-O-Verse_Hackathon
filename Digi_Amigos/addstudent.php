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
			<h2>Student Information</h2>
			<form action="studentdatainsertion.php" method="POST">
				<label for="name">Name:</label>
				<input type="text" id="name" name="name" required>
				<label for="email">Password:</label>
				<input type="password" id="password" name="password" required>
				<label for="branch">Branch:</label>
				<select id="branch" name="branch">
					<option value="Computer Science">Computer Science</option>
					<option value="Information Technology">Information Technology</option>
					<option value="Electronics and Communication Technology">Electronics and Communication Technology</option>
					<option value="Electrical Engineering">Electrical Engineering</option>
					<option value="Mechanical Engineering">Mechanical Engineering</option>
					<option value="Chemical Engineering">Chemical Engineering</option>
					<option value="Metallurgy">Metallurgy</option>
					<option value="Civil Engineering">Civil Engineering</option>
					<option value="Production and Industrial Engineering">Production and Industrial Engineering</option>
					<option value="Mining Engineering">Mining Engineering</option>
				</select>
				<label for="birthday">Date of Birth:</label>
				<input type="date" id="birthday" name="birthday" required>

                <label for="name">Email:</label>
				<input type="email" id="email" name="email" required>

                <label for="name">Student number:</label>
				<input type="text" id="studentnumber" name="studentnumber" required>

                <label for="name">Address:</label>
				<input type="text" id="address" name="address" required>

				<label for="name">Father Name:</label>
				<input type="text" id="namef" name="namef" required>

                <label for="name">Mother Name:</label>
				<input type="text" id="namem" name="namem" required>

                <label for="name">Father number:</label>
				<input type="text" id="fnumber" name="fnumber" required>
				
				<label for="name">Mother number:</label>
				<input type="text" id="mnumber" name="mnumber" required>

				<input type="submit" value="Submit">
			</form>
		</section>
	</main>
	<footer>
		<p>&copy; 2023 College Admin Page</p>
	</footer>
</body>
</html>
