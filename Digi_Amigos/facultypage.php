



<?php session_start() ?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Faculty-profile</title>
    <link rel="stylesheet" href="stylefaculty.css">
</head>
<body>
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
        <img src="profile_image.jpeg" alt="image" height="100px" image>
       </div>
       <div class="name">
       <?php echo $name ?>
       </div>
      
      
       <button class="profilestu">
        BIO
       </button>
<!--           
        <div class="academics"><form action="/action_page.php">
            <label for="class">CLASS :</label>
            <select name="class" id="class">

              <option value="b">Attendence</option>
              <option value="c">Feedback</option>
              
            </select>
        </div>
        <div class="submit"><input type="submit" value="Submit"></div>

    </form> -->
    <div class="academics">
        
        <a href="#">Attendence</a>
    </div>


    <div class="fee"><form action="/action_page.php">
        <label for="semester">SEMESTER :</label>
        <select name="academics" id="semester">
          <option value="a">Marks</option>
          <option value="b">Assignment</option>
          <option value="c">Feedback</option>
        
          
        </select>
    </div>
    <div class="submit1"><input type="submit" value="Submit"></div>

</form>
           
         
       </div>
       <div class="action">
        <a href="#" target="_blank" >
            <span id="marks">Marks</span>
        </a>

        <a href="#" target="_blank" >
            <span id="assignment" >Assignment</span>
        </a>
        <a href="#" target="_blank" >
            <span id="feedback" >FeedBack</span>
        </a>
    
       </div>
       
    </div>

    <div class="hero">
    
      <img src="schedule.jpeg" height="86%">
        
       
    </div>
    <div class="academiccalender">
        Academic Calender
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
        <iframe src="https://calendar.google.com/calendar/embed?height=600&wkst=1&bgcolor=%23ffffff&ctz=UTC&src=c2hydXRpa2VkaWEyMDIyQGdtYWlsLmNvbQ&src=Y2xhc3Nyb29tMTA4NDY5NzQwMjM1NDM4NTAyMDA1QGdyb3VwLmNhbGVuZGFyLmdvb2dsZS5jb20&src=YWRkcmVzc2Jvb2sjY29udGFjdHNAZ3JvdXAudi5jYWxlbmRhci5nb29nbGUuY29t&src=Y19jbGFzc3Jvb21hOWM3Nzc4ZEBncm91cC5jYWxlbmRhci5nb29nbGUuY29t&src=ZW4uaW5kaWFuI2hvbGlkYXlAZ3JvdXAudi5jYWxlbmRhci5nb29nbGUuY29t&src=Y2xhc3Nyb29tMTA3OTI2MjA4Mjg1MTIzODE1NTQxQGdyb3VwLmNhbGVuZGFyLmdvb2dsZS5jb20&color=%23039BE5&color=%23007b83&color=%2333B679&color=%230047a8&color=%230B8043&color=%23202124" style="border:solid 1px #777" width="800" height="600" frameborder="0" scrolling="no"></iframe>
    </div>
    
</body>
</html>