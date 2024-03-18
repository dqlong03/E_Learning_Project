<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>E-Learning : Education & Course</title>
        <style>
            body {
                font-family: 'Arial', sans-serif;
                background-color: white;
                margin: 0;
                display: flex;
                align-items: center;
                justify-content: center;
                height: 100vh;
            }

            .account-head {
                position: relative;
                height: 100vh;
                overflow: hidden;
                width: 40%;
            }

            .background-wrapper {
                background: url('https://i.pinimg.com/564x/97/3a/32/973a32140bfed4786ec6a5a61cb7be76.jpg') center/cover no-repeat;
                width: 100%;
                height: 100%;
                position: absolute;
                top: 0;
                left: 0;
                z-index: 1;
            }

            .gradient-overlay::before {
                content: '';
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background: linear-gradient(45deg, rgba(76, 24, 100, 0.85) 0%, rgba(63, 24, 154, 0.85) 100%);
                filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#4c1864', endColorstr='#3f189a', GradientType=1);
                z-index: 2;
            }

            .logo-container {
                position: absolute;
                top: 50%;
                left: 20px;
                transform: translateY(-50%);
                z-index: 3;
            }

            .logo-container img {
                width: 250px;
                margin-left: 100px;
                max-width: 100%;
                max-height: 100%;
                display: block;
                margin: auto;
                margin-left: 90%;
                transform: translate(-20%);
            }

            .content {
                flex: 1;
                width: 60%;
                color: white;
                z-index: 3;
            }

            .heading-box {
                text-align: left;
                margin-top: -20px;
                margin-bottom: 50px;
                margin-left: 32.7%;
            }

            .title-head {
                color: black;
                font-size: 32px;
                font-weight: 900;
                margin-bottom: 10px;
            }

            .title-head::before {
                content: "";
                width: 6px;
                background-color: #f7b205;
                height: 35px;
                display: inline-block;
                margin-right: 8px;
                margin-bottom: -6px;
            }

            .title-head span {
                font-weight: 300;
            }

            .create-account-link {
                color: #4c1863;
            }

            .sub-title {
                color: black;
                font-size: 16px;
            }

            .contact {
                width: 100%;
                max-width: 400px;
                margin-top: -20px;
                margin-bottom: 20px;
                margin-left: 50%;
                transform: translateX(-50%);
            }

            .form-group {
                width: 100%;
                max-width: 400px;
                margin-top: 20px;
                margin-bottom: 20px;
                text-align: left;
            }

            .form-group label {
                display: block;
                color: #333;
                margin-bottom: 8px;
            }

            .form-control {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                margin-top: 4px;
            }

            .radio-group {
                margin-bottom: -10px;
                text-align: left;
            }

            .radio-group label {
                display: inline-block;
                margin-right: 15px;
            }

            .radio-group input {
                margin-right: 4px;
            }

            .btn {
                background-color: #f7b205;
                color: black;
                padding: 14px 18px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 18px;
                font-weight: bold;
                transition: background-color 0.3s;
                width: 30%;
            }

            .btn:hover {
                background-color: #4c1863;
                color: white;
                opacity: 0.8;
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
        <div class="account-head">
            <div class="background-wrapper"></div>
            <div class="gradient-overlay"></div>
            <div class="logo-container">
                <a href="index.html"><img src="assets/images/logoWhite.png" alt=""></a>
            </div>
        </div>
        <div class="content">
            <div class="heading-box">
                <h2 class="title-head">Sign up <span>Now</span></h2>
                <p class="sub-title">Login your account <a href="login" class="create-account-link">Click here</a></p>
            </div>
            <form class="contact" action="register" method="post" id="register">
                <div class="form-group">
                    <input type="text" id="fullName" name="fullName" onclick="hideError()" placeholder="Your Full Name" class="form-control" >
                </div>
                <div class="form-group">
                    <input type="email" id="email" placeholder="Your Email" onclick="hideError()" name="email" class="form-control" >
                </div>
                <div class="form-group radio-group">
                    <label>Gender:</label>
                    <label for="male">
                        <input type="radio" id="male" checked name="gender" value="male">
                        Male
                    </label>
                    <label for="female">
                        <input type="radio" id="female" name="gender" value="female">
                        Female
                    </label>
                </div>
                <div class="form-group">
                    <input type="text" id="dob" name="dob" onclick="hideError()" placeholder="Your Date Of Birth" class="form-control" onfocus="(this.type = 'date')">
                </div>
                <div class="form-group">
                    <input type="text" id="mobile" onclick="hideError()" placeholder="Your Mobile" name="mobile" class="form-control" >
                </div>
                <div id="error" style="color:red;"></div>
                <c:if test="${requestScope.error!=null}">
                    <div style="color:red;" id="existedError">${requestScope.error}</div>
                </c:if>
                <div class="form-group">
                    <button type="button"  class="btn" onclick="sendForm()">Register</button>
                </div>
            </form>
        </div>
        <div class="loader" id="loadingContainer"></div>

        <script>
            window.addEventListener("load", () => {
                const loader = document.querySelector(".loader");
                loader.classList.add("loader-hidden");
                loader.addEventListener("transitioned", () => {
                    document.body.removeChild(loader);
                });
            });

            function sendForm() {
                var error = '';
                const fullName = document.getElementById('fullName').value;
                const email = document.getElementById('email').value;
                const dob = document.getElementById('dob').value;
                const mobile = document.getElementById('mobile').value;
                if (!fullName.match('^[A-Za-z ]+$')) {
                    error = 'Full name is invalid. Please try again';
                    document.getElementById('error').textContent = error;
                    document.getElementById('error').style.display = 'block';
                } else if (!email.match('^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$')) {
                    error = 'Email is invalid. Please try again';
                    document.getElementById('error').textContent = error;
                    document.getElementById('error').style.display = 'block';
                } else if (dob.length === 0) {
                    error = 'Date of birth cannot be empty. Please try again';
                    document.getElementById('error').textContent = error;
                    document.getElementById('error').style.display = 'block';
                } else if (!mobile.match('^0[0-9]{9}$')) {
                    error = 'Mobile is invalid. Please try again';
                    document.getElementById('error').textContent = error;
                    document.getElementById('error').style.display = 'block';
                } else {
                    var form = document.getElementById('register');
                    form.submit();
                }

            }

            function hideError() {
                const error = document.getElementById('error');
                error.style.display = 'none';
                const errorExisted = document.getElementById('existedError');
                if (errorExisted !== null) {
                    error.style.display = 'none';
                }
            }

        </script>
    </body>

</html>

