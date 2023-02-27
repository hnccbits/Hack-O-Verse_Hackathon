<?php
include('dbconnect.php');
    // $id1=$_GET["catid"];
    $sql="SELECT * FROM `faculty_info`";
    $result=mysqli_query($conn,$sql);
    $row=mysqli_fetch_assoc($result);

    $name=$row["faculty_name"];
    $id=$row["faculty_id"];
    $email=$row["faculty_email"];
    $address=$row["faculty_address"];
    $number=$row["faculty_number"];
    $dob=$row["faculty_dob"];
    $email=$row["faculty_email"];
    $subject=$row["faculty_subject"];
?>