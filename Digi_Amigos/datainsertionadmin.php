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
    
    $rank=$_POST["rank"];
    
    $pass=str_replace("<","&lt;",$pass);
    $pass=str_replace(">","&gt;",$pass);
    $pass=str_replace("'","\'",$pass);
    $hash=password_hash($pass, PASSWORD_DEFAULT);
    
    
    $sql="INSERT INTO `admin_info` (`admin_name`, `admin_id`, `admin_password`, `admin_email`, `admin_address`, `admin_number`, `admin_dob`, `admin_rank`) VALUES ('$name', NULL, '$hash', '$email', '$address', '$fac_numb', '$dob', '$rank')";
    $result1=mysqli_query($conn,$sql);
    $showalert=true;
    header("location:adminpage.php?data=pass");
}
else{
    header("location:adminpage.php?data=fail");
}
?>