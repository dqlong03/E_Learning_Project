<%-- 
    Document   : testSetPass
    Created on : Jan 17, 2024, 3:32:13 PM
    Author     : Admin
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>E-Learning : Education & Course</title>
        <style>
            body {
                font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
            }

            .container {
                width: fit-content;
                margin-left: 50%;
                transform: translateX(-50%);
                margin-top: 12%;
                border: 1px solid #e9e9e9;
            }

            .fields {
                margin-left: 50px;
                margin-bottom: 10px;
            }

            input {
                padding: 7px;
                width: 300px;
            }

            button {
                padding: 10px;
                width: 130px;
                border: none;
                border-radius: 3px;
                font-weight: 600;
            }

            .confirm {
                background-color: #f7b205;
            }

            .confirm:hover {
                background-color: #4c1864;
                color: white;
            }

            .cancel {
                background-color: #121921;
                color: white;
            }

            .cancel:hover {
                opacity: 0.9;
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
            .error {
                margin-top: 0px;
                padding-top: 0px;
            }
        </style>
    </head>

    <body>
        <div id="headered">
            <img onclick="goToHomePage()" src="assets/images/logoBlack.png" alt="alt" />
            <a href="login"><b>Cancel</b></a>
        </div>
        <div class="container">
            <div class="header" style="width: 94.05%; padding: 10px 0 0px 30px; border-bottom: 1px solid #e9e9e9; margin-bottom: 10px;">
                <h3>SET PASSWORD</h3>
            </div>
            <div class="body" style="width: fit-content;">
                <form action="setPassword" method="post" id="setPassword">
                    <input type="hidden" name="id" value="${requestScope.id}"> 
                    <table>
                        <tr>
                            <td></td>
                            <td>
                                <div class="fields" style="font-size: 20px; font-weight: 500;">Password</div>
                            </td>
                        </tr>

                        <tr>
                            <td style="padding: 10px 0 0px 30px; line-height: 29px; padding-bottom: 20px;">New password
                            </td>
                            <td><input type="password" name="password"  onclick="hideError()" id="password" class="fields" style="margin-right: 20px;"></td>
                        </tr>
                        <tr>
                            <td style="padding: 10px 0 0px 30px; line-height: 29px; padding-bottom: 20px;">Confirm new password</td>
                            <td><input type="password" name="confirmPassword" onclick="hideError()" id="confirmPassword" class="fields" style="margin-right: 20px;"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><div id="error" style="color:red; margin-left: 48px; margin-bottom: 10px"></div></td>
                        </tr>
                        <c:if test="${requestScope.error!=null}">
                            <tr>
                                <td></td>
                                <td><div class="fields error" id="existedError" style="color:red; margin-left: 48px; margin-bottom: 10px" >${requestScope.error}</div</td>
                            </tr>
                        </c:if>
                        <tr>
                            <td></td>
                            <td style="padding-bottom: 20px;">
                                <div class="fields"><button type="button"  class="confirm" onclick="sendForm()">Save password</button></div>
                            </td>
                        </tr>
                    </table>

                </form>
            </div>
        </div>
        <script>
            window.addEventListener("load", () => {
                const loader = document.querySelector(".loader");
                loader.classList.add("loader-hidden");
                loader.addEventListener("transitioned", () => {
                    document.body.removeChild("loader");
                });
            });
            function sendForm() {
                var error = '';
                const password = document.getElementById('password').value;
                const confirmPassword = document.getElementById('confirmPassword').value;
                if (password.length === 0) {
                    error = 'Password cannot be empty. Please try again';
                    document.getElementById('error').textContent = error;
                    document.getElementById('error').style.display = 'block';
                } else if (confirmPassword.length === 0) {
                    error = 'Confirm password cannot be empty. Please try again';
                    document.getElementById('error').textContent = error;
                    document.getElementById('error').style.display = 'block';
                } else if (!password.match('^[a-zA-Z0-9]{8,}$')) {
                    error = 'Password should be at least 8 characters';
                    document.getElementById('error').textContent = error;
                    document.getElementById('error').style.display = 'block';
                } else {
                    var form = document.getElementById('setPassword');
                    form.submit();
                }

            }

            function hideError() {
                const error = document.getElementById('error');
                if (error.innerHTML !== '') {
                    error.style.display = 'none';
                    const error = document.getElementById('existedError');
                    if (error !== null) {
                        error.style.display = 'none';
                    }
                }
            }

            
            function goToHomePage() {
                window.location.href = "home.jsp";
            }

        </script>
    </body>
</html>
