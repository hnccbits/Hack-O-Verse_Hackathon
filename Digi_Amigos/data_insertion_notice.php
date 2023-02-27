<?php
$showerror="false";
$showalert="false";

if($_SERVER["REQUEST_METHOD"]=="POST"){
    include('dbconnect.php');
    $desc=$_POST["name"];
    $category=$_POST["branch"];
    
    $sql="INSERT INTO `notices` (`notice_description`, `notice_date`, `notice_category`) VALUES ('$desc', current_timestamp(), '$category')";
    $result1=mysqli_query($conn,$sql);
    $showalert=true;
    header("location:adminpage.php?data=pass");
}
else{
    header("location:adminpage.php?data=fail");
}
?>