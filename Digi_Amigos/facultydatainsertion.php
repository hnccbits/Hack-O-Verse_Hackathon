<?php
$showerror="false";
$showalert="false";

if($_SERVER["REQUEST_METHOD"]=="POST"){
    include('dbconnect.php');
    $name=$_POST["name"];
    $pass=$_POST["password"];
    $dob=$_POST["birthday"];
    $email=$_POST["email"];
    $fac_numb=$_POST["studentnumber"];
    $address=$_POST["address"];
    $subject=$_POST["subject"];
    
    $pass=str_replace("<","&lt;",$pass);
    $pass=str_replace(">","&gt;",$pass);
    $pass=str_replace("'","\'",$pass);
    $hash=password_hash($pass, PASSWORD_DEFAULT);
    
    $sql="INSERT INTO `faculty_info` (`faculty_name`, `faculty_password`, `faculty_address`, `faculty_number`, `faculty_email`, `faculty_subject`, `faculty_dob`) VALUES ('$name', '$hash', '$address', '$fac_numb', '$email', '$subject', '$dob')";
    $result1=mysqli_query($conn,$sql);
    $showalert=true;
    header("location:adminpage.php?data=pass");
}
else{
    header("location:adminpage.php?data=fail");
}
?>