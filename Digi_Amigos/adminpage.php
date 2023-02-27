
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Page </title>
    <link rel="stylesheet" href="styleadmin.css">
    
</head>
<body>
    <div class="header">
        <h1> College Admin Page </h1>
    </div>
    <nav>
        <ul>
           <li><a href="adminpage.php">Home</a></li>
          <!--<li><a href="#">About</a></li> -->
          <li class="dropdown">
            <a href="#">Student</a>
            <ul class="dropdown-menu">
              <li><a href="addstudent.php">Add student</a></li>
              <li><a href="#">Service 2</a></li>
              <li><a href="#">Service 3</a></li>
            </ul>
          </li>

         
          <li class="dropdown">
            <a href="#">Faculty</a>
            <ul class="dropdown-menu">
              <li><a href="addfaculty.php">Add faculty</a></li>
              <li><a href="#">Service 2</a></li>
              <li><a href="#">Service 3</a></li>
            </ul>
          </li>
          <li class="dropdown">
            <a href="#">Admin</a>
            <ul class="dropdown-menu">
              <li><a href="addadmin.php">Add admin</a></li>
              <li><a href="#">Service 2</a></li>
              <li><a href="#">Service 3</a></li>
            </ul>
          </li>
          <li class="dropdown">
            <a href="#">Notices</a>
            <ul class="dropdown-menu">
              <li><a href="view_notice.php">View/edit </a></li>
              <li><a href="addnotice.php">Add Notices</a></li>
              <li><a href="#">Service 3</a></li>
            </ul>
          </li>
          
          <!-- <li><a href="#">Contact</a></li> -->
        </ul>
      </nav>


      <div class="opener">
        <h1> Welcome to the College Admin Page</h1>
        <br>
        <p>This page is designed for the college administration to manage students,faculty and courses</p>
      </div>


      <div class="image">
        <img src="profile_image.jpeg" alt="Image" height="90px">

      </div>
      <div class="profile">
        <p id="name"> Name</p>
        <p id="id"> ID</p>
        <p id="accecebility">Accessibility</p>
      </div>
      
      
</body>
</html>
