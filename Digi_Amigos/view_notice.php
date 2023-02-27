<!DOCTYPE html>
<html>
<head>
	<title>College Admin Page</title>
	<link rel="stylesheet" href="teststyle.css">
</head>
<body>
	<header>
		<h1>College Admin Page</h1>
	</header>
	<nav>
		<ul>
			<li><a href="#">Home</a></li>
			<li><a href="addstudent.php">Students</a></li>
			<li><a href="#">Faculty</a></li>
			<li><a href="#">Courses</a></li>
			<li><a href="#">Settings</a></li>
		</ul>
	</nav>
    <html>
    <head>
        <title>Table Demo</title>
          <script src="jquery.js"></script> 
          <script src="jquery.dataTables.min.js"></script> 
		  <link href="jquery.dataTables.min.css" rel="stylesheet">
    <script>
     $(document).ready(function(){
	   $("#myTable").dataTable();
	 });
   
   </script>
 </head>
    <body>


      <div class="container">
                   <table id="myTable" class="table-responsive">
				   <thead>
				   <tr>
				     <th>S.no</th>
					 <th>Date of publishing</th>
					  <th>Notices</th>
					  <th>For</th>
					  <th>#</th>
				   </tr>
				   
				   </thead>
                   <tbody>
                   <?php
include('dbconnect.php');
    // $id1=$_GET["catid"];
    $sql="SELECT * FROM `notices`";
    $result=mysqli_query($conn,$sql);
    $sno=1;
 
    while($get=mysqli_fetch_assoc($result)){
        $id=$get["notice_id"];
        $desc=$get["notice_description"];
        $dop=$get["notice_date"];
        $cat=$get["notice_category"];

				echo '  
				     <tr>
					   <td>'.$sno.'</td>
					   <td>'.$dop.'</td>
					   <td>'.$desc.'</td>
                       <td>'.$cat.'</td>
					   <td><a href="updatenoticemodal.php">edit</a></td>
					 
					 </tr>
				   ';
                   $sno=$sno+1;
}
                   ?>
                   </tbody>
				   </table>
                   </div>
                   <?php

//updating notices into database

//  $id=$_GET["catid"];
// $showalert=false;

$method=$_SERVER['REQUEST_METHOD'];


if($method=='POST'){
    
    $noticedesc=$_POST['loginemail'];
    $noticecat=$_POST['description'];
    
    
    $sql="UPDATE `notices` SET `notice_description` = '$noticedesc', `notice_category` = '$noticecat' WHERE `notices`.`notice_id` = $id";
    $result1=mysqli_query($conn,$sql);
    $showalert=true;
    
}

?>
                
    </body>
</html>
	<footer>
		<p>&copy; 2023 College Admin Page</p>
	</footer>
   
</body>
</html>
