<%-- 
    Document   : privacy
    Created on : Jan 17, 2024, 4:38:41 PM
    Author     : Admin
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>E-Learning : Education & Course</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                line-height: 1.6;
                color: #333;
                background-color: #f8f9fa;
                margin: 10px;
            }

            h1,
            h3 {
                color: #343a40;
                margin-top: 5px;
                margin-bottom: 5px;
            }

            h1 {
                border-bottom: 2px solid #4c1863;
                padding-bottom: 5px;
                margin-bottom: 10px;
            }

            p{
                margin: 0;
            }

            ol,
            ul {
                margin-bottom: 50px;
                margin-left: 30px;
            }

            a {
                text-decoration: underline;
            }

            a:hover {
                color: #4c1863;
            }

            .container {
                max-width: 800px;
                margin: auto;
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
            .contact {
                margin-bottom: 20px
            }
        </style>
    </head>

    <body>
        <div id="headered">
            <img onclick="goToHomePage()" src="../assets/images/logoBlack.png" alt="alt" />
            <a href="../login"><b>Cancel</b></a>
        </div>
        <div class="container" style="margin-top: 95px;">
            <h1>Privacy Policy</h1>

            <p>Welcome to our E-Learning website. We are committed to protecting your personal information and ensuring
                privacy when using our services.</p>

            <h3>1. Information Collection</h3>
            <p>We may collect your personal information when you register an account, enroll in courses, or use our services.
            </p>

            <h3>2. Use of Information</h3>
            <p>We use your personal information to provide online learning services, improve user experience, and communicate
                important updates to you.</p>

            <h3>3. Security</h3>
            <p>We ensure that your personal information is securely protected. We implement security measures to prevent
                unauthorized access or misuse of personal data.</p>

            <h3>4. Your Privacy Rights</h3>
            <p>You have the right to control your personal information and may request to view, modify, or delete this
                information.</p>

            <h3>5. Cookies</h3>
            <p>We use cookies to provide the best user experience. You can choose to disable cookies in your browser.</p>

            <h3>6. Contact Us</h3>
            <p>If you have any questions or concerns about our privacy policy, please feel free to contact us:</p>
            <ul class="contact">
                <li>Email: <a href="mailto:privacy@example.com">privacy@example.com</a></li>
                <li>Phone: +1 (555) 123-4567</li>
            </ul>
            <p>This Privacy Policy is effective from January 1, 2024.</p>
        </div>
        <script>
            function goToHomePage() {
                window.location.href = "home.jsp";
            }
        </script>
    </body>

</html>
