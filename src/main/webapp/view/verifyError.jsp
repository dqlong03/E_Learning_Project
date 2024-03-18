<%-- 
    Document   : error.jsp
    Created on : Jan 9, 2024, 9:23:17 AM
    Author     : Admin
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                margin-top: 320px;
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
                margin-bottom: 35px;
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
        </style>
    </head>
    <body>
        <div id="headered">
            <img onclick="goToHomePage()" src="assets/images/logoBlack.png" alt="alt" />
            <a href="login"><b>Cancel</b></a>
        </div>
        <c:choose>
            <c:when test="${requestScope.check eq 'idError' or requestScope.check eq 'errorOTP'}">
                <div class="container">
                    <div class="header">
                        <h2>Oops!!! Something went wrong</h2>
                    </div>
                    <div class="content">
                        <div>We encountered an issue during the troubleshooting procedure</div>
                        <div style="margin-top: 5px">Just click on the link in the email to complete your signup. If you don't see it, you may need to check
                            yout spam folder</div>
                    </div>
                    <form action="resend" method="post">
                        <input type="hidden" value="${requestScope.id}" name="id">
                        <button type="submit"><b>Resend Verification Email</b></button>
                    </form> 
                </div>
            </c:when>
            <c:when test="${requestScope.check eq 'timeout'}">
                <div class="container">
                    <div class="header">
                        <h2>Oops!!! Request timeout</h2>
                    </div>
                    <div class="content">
                        <div>Your otp code has expired </div>
                        <div>Please select "Resend verification email" to validate your account. After resending, if you don't see it, you may need to check yout spam folder</div>
                    </div>
                    <form action="resend" method="post">
                        <input type="hidden" value="${requestScope.id}" name="id">
                        <button type="submit"><b>Resend Verification Email</b></button>
                    </form> 
                </div>
            </c:when>

            <c:when test="${requestScope.check eq 'notActivated'}">
                <div class="container">
                    <div class="header">
                        <h2>Oops!!! Your account has not been activated yet</h2>
                    </div>
                    <div class="content">
                        <div>Please select "Resend verification email" to validate your account. After resending, if you don't see it, you may need to check yout spam folder</div>
                    </div>
                    <form action="resend" method="post">
                        <input type="hidden" value="${requestScope.id}" name="id">
                        <button type="submit"><b>Resend Verification Email</b></button>
                    </form> 
                </div>
            </c:when>
        </c:choose>

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
        </script>
    </body>

</html>
