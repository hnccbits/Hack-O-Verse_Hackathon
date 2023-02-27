<?php
$showerror="false";
$showalert="false";

if($_SERVER["REQUEST_METHOD"]=="POST"){
    include('dbconnect.php');
    $name=$_POST["name"];
    $pass=$_POST["password"];
    $branch=$_POST["branch"];
    $dob=$_POST["birthday"];
    $email=$_POST["email"];
    $stu_numb=$_POST["studentnumber"];
    $address=$_POST["address"];
    $father_number=$_POST["fnumber"];
    $mother_number=$_POST["mnumber"];
    $father_name=$_POST["namef"];
    $mother_name=$_POST["namem"];
    $pass=str_replace("<","&lt;",$pass);
    $pass=str_replace(">","&gt;",$pass);
    $pass=str_replace("'","\'",$pass);
    $hash=password_hash($pass, PASSWORD_DEFAULT);
    
    $sql="INSERT INTO `student_info` (`student_name`, `student_password`, `student_dob`, `student_branch`, `student_email`, `student_number`, `student_address`, `student_father`, `student_mother`, `father_number`, `mother_number`) VALUES ('$name', '$hash', '$dob', '$branch', '$email', '$stu_numb', '$address', '$father_name ', '$mother_name', '$father_number', '$mother_name')";
    $result1=mysqli_query($conn,$sql);
    $showalert=true;
    header("location:adminpage.php?data=pass");
}
else{
    header("location:adminpage.php?data=fail");
}
?>