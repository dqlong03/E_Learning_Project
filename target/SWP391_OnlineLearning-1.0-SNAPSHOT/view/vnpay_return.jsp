<%-- 
    Document   : vnpay_return
    Created on : Jan 21, 2024, 10:40:41 PM
    Author     : tran Hoang Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page import="com.fpt.swp391_onlinelearning.util.VnpayUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <%
            //Begin process return from VNPAY
            Map fields = new HashMap();
            for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
                String fieldName = URLEncoder.encode((String) params.nextElement(), StandardCharsets.US_ASCII.toString());
                String fieldValue = URLEncoder.encode(request.getParameter(fieldName), StandardCharsets.US_ASCII.toString());
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    fields.put(fieldName, fieldValue);
                }
            }

            String vnp_SecureHash = request.getParameter("vnp_SecureHash");
            if (fields.containsKey("vnp_SecureHashType")) {
                fields.remove("vnp_SecureHashType");
            }
            if (fields.containsKey("vnp_SecureHash")) {
                fields.remove("vnp_SecureHash");
            }
            String signValue = VnpayUtil.hashAllFields(fields);

        %>

        <%
           if (signValue.equals(vnp_SecureHash)) {
               if ("00".equals(request.getParameter("vnp_TransactionStatus"))) {
        %>
        <div id="headered">
            <img src="../assets/images/logoBlack.png" alt="alt" />
        </div>
        <div class="container">
            <img src="../assets/images/successful.png" alt>
            <div class="content">
                <h2>Transaction successful!</h2>
                <h1>You will be redirected to Course</h1>
            </div>
        </div>                   
        <%
                } else {
        %>
        <div id="headered">
            <img src="../assets/images/logoBlack.png" alt="alt" />
        </div>
        <div class="container failed">
            <img src="../assets/images/failed.png" alt>
            <div class="content">
                <h2>Transaction failed!</h2>
                <h1>You will be redirected to Course</h1>
            </div>
        </div>
        <%
                }
        
            } else { %>
        <div id="headered">
            <img src="../assets/images/logoBlack.png" alt="alt" />
        </div>
        <div class="container failed">
            <img src="../assets/images/failed.png" alt>
            <div class="content">
                <h2>Transaction failed!</h2>
                <h1>You will be redirected to Course</h1>
            </div>
        </div>     
        <%  }
        %>
        <form action="../return" method="post" id="returnForm">
            <input type="hidden" name="transactionId" value="<%=request.getParameter("vnp_TxnRef")%>">
            <input type="hidden" name="amount" value="<%=request.getParameter("vnp_Amount")%>">
            <input type="hidden" name="createdTime" value="<%=request.getParameter("vnp_PayDate")%>">
            <% if  ("00".equals(request.getParameter("vnp_TransactionStatus"))) {%>
            <input type="hidden" name="status" value="00">
            <% } else {%>
            <input type="hidden" name="status" value="01">
            <%}%>
        </form>


        <div class="loader" id="loadingContainer">

        </div>

        <script>
            window.addEventListener("load", () => {
                const loader = document.querySelector(".loader");
                loader.classList.add("loader-hidden");
                loader.addEventListener("transitioned", () => {
                    document.body.removeChild("loader");
                })
            });

            function Redirect() {
                const form = document.getElementById('returnForm');
                form.submit();
            }
            setTimeout('Redirect()', 3000);
        </script>
    </body>
</html>
