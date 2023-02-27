<?php
include('dbconnect.php');
    // $id1=$_GET["catid"];
    $sql="SELECT * FROM `student_info`";
    $result=mysqli_query($conn,$sql);
    $row=mysqli_fetch_assoc($result);

    $name=$row["student_name"];
    $id=$row["student_id"];
    $email=$row["student_email"];
    $address=$row["student_address"];
    $number=$row["student_number"];
    $dob=$row["student_dob"];
    $email=$row["student_email"];
    $fathername=$row["student_father"];
    $mothername=$row["student_mother"];
    $fathernumber=$row["father_number"];
    $mothernumber=$row["mother_number"];

?>