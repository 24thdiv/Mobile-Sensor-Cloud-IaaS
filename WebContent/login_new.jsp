<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Sensor Cloud</title>
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    
    <link rel="stylesheet" href="css/normalize.css">

    
        <link rel="stylesheet" href="css/style_1.css">

    
    
    
  </head>

  <body background="https://www.colourbox.com/preview/2347548-weather-icons-doodles-hand-drawn-set-on-white.jpg">

    <div class="form">
      
      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Sign Up</a></li>
        <li class="tab"><a href="#login">Log In</a></li>
      </ul>
      
      <div class="tab-content">
        <div id="signup">   
          <h1>Sign Up for Free</h1>
          
          <form action="SignUp" method="post">
          
          <div class="top-row">
            <div class="field-wrap">
              <label>
                First Name<span class="req">*</span>
              </label>
              <input type="text" id="FirstName" name="FirstName" required autocomplete="off" />
            </div>
        
            <div class="field-wrap">
              <label>
                Last Name<span class="req">*</span>
              </label>
              <input type="text" id="LastName"  name="LastName" required autocomplete="off"/>
            </div>
          </div>
			<div class="field-wrap">
            <label>
              Phone No.<span class="req">*</span>
            </label>
            <input type="text" id="Phone" name="Phone"required autocomplete="off"/>
          </div>
          <div class="field-wrap">
            <label>
              Address<span class="req">*</span>
            </label>
            <input type="text" id="Address" name="Address"required autocomplete="off"/>
          </div>
          <div class="field-wrap">
            <label>
              City<span class="req">*</span>
            </label>
            <input type="text" id="City" name="City"required autocomplete="off"/>
          </div>
          
          
          <div class="field-wrap">
            <label>
              State<span class="req">*</span>
            </label>
            <input type="text" id="State" name="State" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              ZIP <span class="req">*</span>
            </label>
            <input type="text" id="ZIP" name="ZIP" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
            <input type="email" id="UserName" name="UserName" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Set A Password<span class="req">*</span>
            </label>
            <input type="password" id="Password"  name="Password" required autocomplete="off"/>
          </div>
          
          <button type="submit" class="button button-block"/>Get Started</button>
          
          </form>

        </div>
        
        <div id="login">   
          <h1>Welcome Back!</h1>
          
          <form action="Login" method="post">
          
            <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
            <input type="email" name="Username"required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password" name="Password" required autocomplete="off"/>
          </div>
          
          
          <button class="button button-block" />Log In</button>


						<% if(session.getAttribute("invalid")==null){
  								
  							}
  							else if(session.getAttribute("invalid").equals("wrong password")){
  								%><br>wrong password<%
  							};
  							%>

          
          </form>



        </div>
        
      </div><!-- tab-content -->
      
</div> <!-- /form -->
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>

    
    
    
  </body>
</html>
