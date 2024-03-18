<%-- 
    Document   : waiting
    Created on : Jan 8, 2024, 3:19:11 PM
    Author     : Admin
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>E-Learning : Education & Course</title>
        <style>
            * {
                font-family: Arial, Helvetica, sans-serif;
                margin: 0;
                padding: 0;
            }

            body {
                display: flex;
                justify-content: center;
                align-items: center;
                margin-top: 10%;
            }

            .container {
                border: 1px solid #000000;
                padding: 20px;
                border-radius: 10px;
            }

            .header,
            .content {
                align-items: center;
                text-align: center;
            }

            .header {
                margin-bottom: 15px;
                font-weight: 900;
                font-size: 25px;
            }


            button {
                margin-left: 50%;
                transform: translateX(-50%);
                margin-top: 20px;
                padding: 12px 20px;
                background-color: #f7b205;
                border: none;
                color: black;
                font-weight: 600;
                border-radius: 10px;
            }

            button:hover {
                background-color: #4c1863;
                opacity: 0.7;
                color: white;
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

            .container {
                max-width: 850px;
                margin: 50px auto;
                padding: 20px;
                border-radius: 5px;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            .contact-info p {
                margin: 5px 0;
                color: #333;
            }

            .contact-info p {
                font-weight: bold;
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
                z-index: 2;
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
            <img onclick="goToHomePage()" src="assets/images/logoBlack.png" alt="alt" />
            <a href="login"><b>Cancel</b></a>
        </div>
        <div class="container" style="margin-top:80px;">
            <c:if test="${send}">
                <div class="header">
                    <p>Please verify your email</p>
                </div>
                <div class="content">
                    <div>You're almost there! We sent an email to</div>
                    <div style="margin-top: 5px"><b style="color: #4c1863">....@gmail.com</b></div>
                    <div style="margin-top: 5px">Just click on the link in the email to set the password. If you don't see it, you may need to check
                        yout spam folder</div>
                </div>
                <form action="resend" method="post">
                    <input type="hidden" value="${requestScope.id}" name="id">
                    <button type="submit"><b>Resend Verification Email</b></button>
                </form> 
            </c:if>
            <c:if test="${!send}">
                <div class="header" >
                    <p style="color: #f7b205;">Oops! Something went wrong</p>
                </div>
                <div class="content">
                    <div>We encountered an issue during the troubleshooting procedure. This could be due to various reasons, including security measures, high server load, network issues, and more.</div>
                    <div style="margin-top: 5px">Please accept our apologies for any inconvenience this may have caused.</div>
                    <div style="margin-top: 5px">To resolve this issue, kindly contact our support team:</div>
                    <div class="contact-info" style="margin-top: 2px">
                        <p>Email: support@example.com</p>
                        <p>Phone: +1 (555) 123-4567</p>
                    </div>
                </div
            </c:if>
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
            function goToHomePage() {
                window.location.href = "home.jsp";
            }
        </script>
    </body>
</html>

