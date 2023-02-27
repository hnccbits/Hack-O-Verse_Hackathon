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

    $sql="SELECT * FROM `admin_info` WHERE admin_id='$email'";
    $result=mysqli_query($conn,$sql);
    $numrows=mysqli_num_rows($result);
    
    if($numrows!=0){

        $row=mysqli_fetch_assoc($result);
        $sno2=$row['admin_id'];
        $checkpass=$row['admin_password'];

        if(password_verify($pass,$row['admin_password'])){
            session_start();
            $_SESSION['loggedin']=true;
            $_SESSION['username']=$email;
            $_SESSION['Faculty_id']=$sno2;
            header("location:adminpage.php?Adminlog=true");
        }
        else{
            header("location:index.php?Adminlog=false");
        }
        
    }
    else{
        header("location:index.php?Adminlog=exist");

    }
}
else{
    header("location:index.php?Adminlog=fail");
}

?>