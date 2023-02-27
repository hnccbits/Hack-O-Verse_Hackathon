<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
    <link rel="stylesheet" href="style1.css">
    <link rel="stylesheet" href="https://kit.fontawesome.com/af27657c8f.css" crossorigin="anonymous">
</head>
<body>
    <?php 
    $id=$_GET["user"];
    ?>
   
   <header>

        
<div class="head" id="head">
    <img src="logo.jpg" alt="logo" height="210rem">

    <div id="clgname">
        <h1>DIGI AMIGOS </h1>

        <!-- <i class="fa fa-user" aria-hidden="true"></i> -->
    </div>

    <span id="motto">College At Your Place </span>
</div>
</header>
<form action="handlelogin<?php echo $id?>.php" method="POST">
<div class="container">
        <h1> log in</h1>
        <div class="box">
            <i class="fa-solid fa-user"></i>
            <input type="text" name="user_id" id="user_id" placeholder="Enter <?php echo $id ?> Id">
        </div>
        <div class="box">
            <i class="fa-solid fa-key"></i>
            <input type="password" name="password" id="password" placeholder="Enter Your  Password">
        </div>
        <button class="btn">
            Sign In
        </button>
    </div>
    

   
</body>
<script src="https://kit.fontawesome.com/af27657c8f.js" crossorigin="anonymous"></script>
</html>