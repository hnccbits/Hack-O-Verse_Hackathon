<?php
include('dbconnect.php');
    // $id1=$_GET["catid"];
    $sql="SELECT * FROM `admin_info`";
    $result=mysqli_query($conn,$sql);
    $row=mysqli_fetch_assoc($result);

    $name=$row["admin_name"];
    $id=$row["admin_id"];
    $email=$row["admin_email"];
    $address=$row["admin_address"];
    $number=$row["admin_number"];
    $dob=$row["admin_dob"];
    $rank=$row["admin_rank"];
?>