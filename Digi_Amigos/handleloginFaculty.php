<?php
$showerror="false";
if($_SERVER["REQUEST_METHOD"]=="POST"){
    include('dbconnect.php');
    $email=$_POST['user_id'];
    $pass=$_POST['password'];
    // $email=str_replace("<","&lt;",$email);
    // $email=str_replace(">","&gt;",$email);
    // $email=str_replace("'","\'",$email);
    $pass=str_replace("<","&lt;",$pass);
    $pass=str_replace(">","&gt;",$pass);
    $pass=str_replace("'","\'",$pass);

    $sql="SELECT * FROM `faculty_info` WHERE faculty_id='$email'";
    $result=mysqli_query($conn,$sql);
    $numrows=mysqli_num_rows($result);
    if($numrows!=0){

        $row=mysqli_fetch_assoc($result);
        $sno2=$row['faculty_id'];

        if(password_verify($pass,$row['faculty_password'])){
            session_start();
            $_SESSION['loggedin']=true;
            $_SESSION['username']=$email;
            $_SESSION['faculty_id']=$sno2;
            header("location:facultypage.php?login=true");
        }
        else{
            header("location:index.php?login=false");
        }
        
    }
    else{
        header("location:index.php?login=exist");

    }
}
else{
    header("location:index.php?login=fail");
}

?>