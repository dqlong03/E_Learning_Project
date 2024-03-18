<%-- 
    Document   : payment.jsp
    Created on : Jan 21, 2024, 10:31:30 AM
    Author     : tran Hoang Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Learning : Education & Course</title>
        <link href="/assets/jumbotron-narrow.css" rel="stylesheet">      
        <script src="/assets/jquery-1.11.3.min.js"></script>
        <style>
            * {
                margin: 0;
                padding: 0;
            }

            .content {
                display: flex;
                /* align-items: center;
                justify-content: center; */
                height: 100vh;
                margin: 0;
                background-color: #f7f9fa;
            }

            .left-side {
                margin-right: 80px;
                background-color: #ffffff;
                width: 700px;
                height: 100%;
                padding-left: 500px;
            }

            #country {
                padding: 10px 40px;
                width: 200px;
                background-color: #f7f9fa;
                border: 1px solid #c4c6c6;
            }

            #country:hover {
                background-color: #e3e7ea;
            }

            .right-side {
                display: flex;
                flex-direction: column;
                position: relative;
                height: 100%;
            }

            .table-title {
                width: 150px;
            }

            .payment-method-content {
                padding: 10px;
                width: 250px;
                border: 1px solid #c4c6c6;
                background-color: #f7f9fa;
            }

            .content-left-side {
                margin-top: 30%;
            }

            .content-right-side {
                padding-top: 90%;
            }

            .payment-info {
                margin-top: 20px;
                padding-bottom: 15px;
                width: 300px;
                position: relative;
            }

            #btn-submit {
                padding: 15px 25px;
                width: 200px;
                margin-left: 50%;
                transform: translateX(-50%);
                margin-top: 10px;
                background-color: #f7b205;
                color: #ffffff;
                border: none;
            }

            #btn-submit:hover {
                background-color: #4c1863;
                opacity: 0.8;
            }

            #header {
                background-color: #ffffff;
                height: 80px;
                padding-left: 500px;
                position: fixed;
                top: 0;
                right: 0;
                left: 0;
                box-shadow: 0 2px 4px rgba(0, 0, 0, .08), 0 4px 12px rgba(0, 0, 0, .08);
            }

            #header a {
                text-decoration: none;
                color: #4c1863;
                font-size: 20px;
                font-weight: bold;
                position: absolute;
                top: 50%;
                transform: translateY(-50%);
                right: 50px;
            }
            #header img {
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
            #header a:hover {
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
        </style>
    </head>
    <body>
        <div id="header">
            <img onclick="goHome()" src="assets/images/logoBlack.png" alt="alt"/>
            <a href="coursedetail?id=${requestScope.course.courseId}"><b style="font-weight: 30px;">Cancel</b></a>
        </div>
        <div class="content">
            <div class="left-side">
                <div class="content-left-side">
                    <h1 style="margin-bottom: 30px;">Payment</h1>
                    <div id="contry-content">
                        <h4 style="margin-bottom: 20px;">Country<span style="color: red;">*</span></h4>
                        <select name="country" id="country" style="margin-bottom: 20px;">
                            <option value="vn">Vietnam</option>
                        </select>
                    </div>
                    <div class="payment-method" style="margin-bottom: 20px;">
                        <h2 style="margin-bottom: 20px;">Payment method</h2>
                        <div class="payment-method-content">
                            <div class="payment-method-content-left">
                                <div class="payment-method-content-left-1">
                                    <input type="radio" name="payment-method" id="payment-method-1" checked>
                                    <label for="payment-method-1">VNPay</label>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="info">
                        <h2 style="margin-bottom: 10px;">Course information</h2>
                        <div class="course" style="display: flex;">
                            <img style="width: 50px;" src="${requestScope.course.img}" alt>
                            <div style="margin-left: 7px;"><b style="font-weight: bolder;">${requestScope.course.name}</b>
                            </div>
                            <div style="margin-left: 30px; font-size: larger;">đ <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${requestScope.course.price}"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="right-side">
                <div class="content-right-side">
                    <h2>Amount</h2>
                    <div class="payment-info">
                        <span style="position: absolute; left: 0;">Origin price</span>
                        <b style="position: absolute; right: 0;">đ <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${requestScope.course.price}" /></b> <br>
                    </div>
                    <div class="payment-info" style="  border-bottom: 1px solid #d1d7dc;">
                        <span style="position: absolute; left: 0;">Balance</span> <b style="position: absolute; right: 0;">đ <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${requestScope.user.balance}" /></b> <br>
                    </div>
                    <div class="payment-info">
                        <b style="position: absolute; left: 0; font-size: 20px;">Total</b>
                        <b style="position: absolute; right: 0; font-size: 20px;">đ
                            
                            <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${requestScope.course.price - requestScope.user.balance <0?requestScope.user.balance - requestScope.course.price:requestScope.course.price - requestScope.user.balance}" />  </b> <br>
                    </div>
                    <form action="pay" id="frmCreateOrder" method="post">   
                        <input type="hidden" name="courseId" value="${requestScope.course.courseId}">
                        <c:if test="${requestScope.course.price > requestScope.user.balance}">
                            <input type="hidden" name="amount" value="${requestScope.course.price - requestScope.user.balance}">
                        </c:if>
                        <c:if test="${requestScope.course.price <= requestScope.user.balance}">
                            <input type="hidden" name="amount" value="${requestScope.user.balance - requestScope.course.price}">
                        </c:if>
                      
                        <input type="hidden" name="bankCode" value="">
                        <button id="btn-submit" type="submit"><b style="font-size: 20px;">Pay</b></button>
                    </form>
                </div>
            </div>
        </div>
        <div class="loader" id="loadingContainer">

        </div>

    </body>
    <script>
        window.addEventListener("load", () => {
            const loader = document.querySelector(".loader");
            loader.classList.add("loader-hidden");
            loader.addEventListener("transitioned", () => {
                document.body.removeChild("loader");
            })
        })
        function goHome() {
            window.location = 'http://localhost:8080/SWP391_OnlineLearning/home';
        }
    </script>    
    <link href="https://pay.vnpay.vn/lib/vnpay/vnpay.css" rel="stylesheet" />
    <script src="https://pay.vnpay.vn/lib/vnpay/vnpay.min.js"></script>
    <script type="text/javascript">
        $("#frmCreateOrder").submit(function () {
            var postData = $("#frmCreateOrder").serialize();
            var submitUrl = $("#frmCreateOrder").attr("action");
            $.ajax({
                type: "POST",
                url: submitUrl,
                data: postData,
                dataType: 'JSON',
                success: function (x) {
                    if (x.code === '00') {
                        if (window.vnpay) {
                            vnpay.open({width: 768, height: 600, url: x.data});
                        } else {
                            location.href = x.data;
                        }
                        return false;
                    } else {
                        alert(x.Message);
                    }
                }
            });
            return false;
        });
    </script>     
</html>
