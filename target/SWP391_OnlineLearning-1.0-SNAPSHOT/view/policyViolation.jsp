<%-- 
    Document   : policyViolation
    Created on : Jan 10, 2024, 10:02:28 AM
    Author     : Admin
--%>

<%@page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>E-Learning : Education & Course</title>
   <style>
      body {
         font-family: 'Arial', sans-serif;
         margin: 40px;
      }

      h1 {
         border-bottom: 2px solid #4c1863;
         padding-bottom: 5px;
         margin-bottom: 20px;
         line-height: 51.198px;
      }

      p {
         margin-bottom: 20px;
         margin: 0;
      }

      ul {
         list-style-type: none;
         padding: 0;
         margin-bottom: 20px;
      }


      a {
         text-decoration: none;
      }

      a:hover {
         text-decoration: underline;
         color: #4c1863;
      }

      .container {
         max-width: 800px;
         margin: auto;
         margin-top: 95px;
      }

      #headered {
         background-color: #ffffff;
         height: 80px;
         padding-left: 500px;
         position: fixed;
         top: 0;
         right: 0;
         left: 0;
         box-shadow: 0 2px 4px rgba(0, 0, 0, .08), 0 4px 12px rgba(0, 0, 0, .08);
      }

      #headered a {
         text-decoration: none;
         color: #4c1863;
         font-size: 20px;
         font-weight: bold;
         position: absolute;
         top: 50%;
         transform: translateY(-50%);
         right: 50px;
      }

      #headered img {
         text-decoration: none;
         color: #a435f0;
         font-size: 20px;
         font-weight: bold;
         position: absolute;
         top: 50%;
         transform: translateY(-45%);
         left: 50px;
         width: 200px;
      }

      #headered a:hover {
         color: #4c1863;
         opacity: 0.6;
      }

   </style>
</head>

<body>
   <div id="headered">
       <img onclick="goToHomePage()" src="../assets/images/logoBlack.png" alt="alt" />
      <a href="../login"><b>Cancel</b></a>
   </div>
   <div class="container">
      <h1>Account Blocked</h1>

      <p>We apologize for the inconvenience, but your account is currently blocked due to a violation of some of our
         important security policies.</p>

      <h3>Reasons for Account Block</h3>
      <ul>
         <li>Suspicious Activity: There is suspicious activity related to your account.</li>
         <li>Violation of Usage Policies: Using our services in a way that does not comply with the rules and terms of
            use.</li>
         <li>Account Security Threatened: Your account may be threatened in terms of security.</li>
      </ul>

      <h3>Resolution Steps</h3>
      <ol>
         <li>Read the Privacy Policy: <a href="privacy.jsp">View Privacy Policy</a></li>
         <li>Check Recent Activity: Review recent activity on your account to ensure that there is no suspicious
            activity.</li>
         <li class="contact">Contact Support:</li>
         <div style="margin: 5px 0px;">Email: <a href="mailto:privacy@example.com">privacy@example.com</a></div>
         <div>Phone: +1 (555) 123-4567</div>
      </ol>

      <p>We sincerely appreciate your understanding and cooperation in resolving this issue.</p>
   </div>
    <script>
        function goToHomePage() {
            window.location.href ="home.jsp";
        }
    </script>
</body>

</html>
