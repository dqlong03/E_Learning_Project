<%-- 
    Document   : setPasswordStatus
    Created on : Jan 18, 2024, 4:58:37 PM
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
            .container {
                position: relative;
                justify-content: center;
                align-items: center;
                border: 5px solid #39b54a;
                border-radius: 20px;
                width: 500px;
                height: 250px;
                margin-left: 50%;
                transform: translateX(-50%);
                margin-top: 15%;
            }

            .container img {
                width: 150px;
                position: absolute;
                left: 170px;
            }

            .content {
                position: absolute;
                top: 100px;
                text-align: center;
                margin-left: 30px;
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

            .loader {
                position: fixed;
                top: 0;
                left: 0;
                width: 100vw;
                height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;
                background-color: #f7f9fb;
                transition: opacity 0.75s, visibility 0.75s;
            }

            .loader-hidden {
                opacity: 0;
                visibility: hidden;
            }

            .loader::after {
                content: "";
                width: 75px;
                height: 75px;
                border: 15px solid #dddddd;
                border-top-color: #7449f5;
                border-radius: 50%;
                animation: loading 0.75s ease infinite;
            }

            @keyframes loading {
                from {
                    transform: rotate(0turn);
                }
                to {
                    transform: rotate(1turn);
                }
            }

            .failed {
                border: 5px solid #ed1b2e;
            }

            .failed img {
                width: 75px;
                margin-left: 8%;
                margin-top: 30px;
            }
        </style>
    </head>

    <body>
        <div id="headered">
            <img onclick="goToHomePage()" src="assets/images/logoBlack.png" alt="alt" />
            <a href="login"><b>Cancel</b></a>
        </div>
        <div class="container">
            <img src="assets/images/successful.png" alt>
            <div class="content">
                <h2>Set password successfully!</h2>
                <h1>You will be redirected to login </h1>
            </div>
        </div>

        <div class="loader" id="loadingContainer">

        </div>

        <script>
            window.addEventListener("load", () => {
                const loader = document.querySelector(".loader");
                loader.classList.add("loader-hidden");
                loader.addEventListener("transitioned", () => {
                    document.body.removeChild("loader");
                });
            });
            
            function goToHomePage() {
                window.location.href = "home.jsp";
            }
            function Redirect() {
                window.location = "http://localhost:8080/SWP391_OnlineLearning/login";
            }
            setTimeout('Redirect()', 3000);
        </script>
    </body>

</html>
