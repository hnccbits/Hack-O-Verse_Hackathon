<?php session_start() ?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student-profile</title>
    <link rel="stylesheet" href="stylestu.css">
</head>
<body>
<?php
include('dbconnect.php');
    // $id1=$_GET["catid"];
    $email2=$_SESSION['username'];
    $studentid=$_SESSION['student_id'];
    // echo $email2;
    $sql="SELECT * FROM `student_info` WHERE student_id='$studentid'";
    $result=mysqli_query($conn,$sql);

    $row=mysqli_fetch_assoc($result);

    $name=$row["student_name"];
    $id=$row["student_id"];
    $email=$row["student_email"];
    $address=$row["student_address"];
    $number=$row["student_number"];
    $dob=$row["student_dob"];
    $branch=$row["student_branch"];
    $email=$row["student_email"];
    $fathername=$row["student_father"];
    $mothername=$row["student_mother"];
    $fathernumber=$row["father_number"];
    $mothernumber=$row["mother_number"];
    
    if($id <= 5){
        $sem=1;
    }
    elseif($id<=7){
        $sem=3;
    }
    elseif($id<=9){
        $sem=5;
    }
    else{
        $sem=NULL;
    }
?>
    <header>

        
        <div class="head" id="head">
            <img src="logo.jpg" alt="logo" height="210rem">

            <div id="clgname">
                <h1>DIGI AMIGOS </h1>

                <!-- <i class="fa fa-user" aria-hidden="true"></i> -->
            </div>

            <span id="motto">YOUR COLLEGE AT YOUR PLACE </span>
        </div>
    </header>
    
    
    
    <div class="left">
       <div class="image">
        <img src="profile_image.jpeg" alt="image" height="90px"image>
       </div>
       <div class="name">
        <?php echo $name ?>
       </div>
       <div class="branch">
       <?php echo $branch ?>
       </div>
       <div class="sem">
       <?php echo $sem ?>
       </div>
       <button class="profilestu">
        PROFILE
       </button>
          
       <!-- <form><div class="academics"><form action="/action_page.php">
            <label for="academics">ACADEMICS :</label>
            <select name="academics" id="semester">
              <option value="a">Marks</option>
              <option value="b">Attendence</option>
             
            </select> 
        </div>
        <div class="submit"><input type="submit" value="a"></div>

    </form> -->
    <div class="academics">
        <a href="#">Marks</a>
        <a href="#">Attendence</a>
    </div>

    <div class="fee">
        <a href="#">Due</a>
        <a href="#">Pay</a>
    </div>
<!-- 
    <div class="fee"><form action="/action_page.php">
        <label for="fee">FEE :</label>
        <select name="semester" id="semester">
          <option value="a">Due</option>
          <option value="b">Pay</option>
        
          
        </select>
    </div>
    <div class="submit1"><input type="submit" value="Submit"></div>

</form> -->




           
         
       <!-- </div> -->
       <!-- <form><div class="action">
        <a href="#" target="_blank" >
            <span id="marks">Marks</span>
        </a>

        <a href="#" target="_blank" >
            <span id="assignment" >Assignment</span>
        </a>
        
       </div>
       
       
    </div>
</form> -->
<div class="feedback"><a href="feedbackstu.html" > Feedback </a>
</div>

    <div class="hero">
      Schedule
        
       
    </div>
    <div class="academiccalender">
        Notices
        <div class="scroll-box">
            <p>First line of content</p>
            <p>Second line of content</p>
            <p>Third line of content</p>
            <p>Fourth line of content</p>
            <p>Fifth line of content</p>
            <p>Sixth line of content</p>
            <p>Seventh line of content</p>
            <p>Eighth line of content</p>
            <p>Ninth line of content</p>
            <p>Tenth line of content</p>
            <p>Eleventh line of content</p>
            <p>Tenth line of content</p>
            <p>Tenth line of content</p>
            <p>Tenth line of content</p>
            <p>Tenth line of content</p>
            <p>Tenth line of content</p>
            <p>Tenth line of content</p>
            <p>Tenth line of content</p>
            <p>Tenth line of content</p>
            <p>Tenth line of content</p>
            <p>Tenth line of content</p>
            <p>Tenth line of content</p>
            <p>Tenth line of content</p>
            <p>Tenth line of content</p>
          </div>
    </div>

    <div class="workdue">
        Workdue
    </div>
    
</body>
</html>