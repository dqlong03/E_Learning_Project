<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />

        <!-- META ============================================= -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="" />

        <!-- DESCRIPTION -->
        <meta name="description" content="EduChamp : Education HTML Template" />

        <!-- OG -->
        <meta property="og:title" content="EduChamp : Education HTML Template" />
        <meta property="og:description" content="EduChamp : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="../adminassets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="../adminassets/js/html5shiv.min.js"></script>
        <script src="../adminassets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="../adminassets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="../adminassets/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="../adminassets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="../adminassets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="../adminassets/css/style.css">
        <link rel="stylesheet" type="text/css" href="../adminassets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="../adminassets/css/color/color-1.css">
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            .left-sider {
                width: 250px;
                height: 100vh;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
                position: fixed;
                top: 0;
                left: 0;
            }

            .logo {
                width: 100%;
                height: 100px;
                background-color: #fff;
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .logo a {
                width: 50%;
            }

            .navigator {
                width: 100%;
                height: calc(100vh - 500px);
                background-color: #fff;
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .list-task {
                width: 100%;
                height: 100%;
                list-style: none;
                display: flex;
                flex-direction: column;
                justify-content: space-around;
                align-items: center;
            }

            li a {
                text-decoration: none;
                color: black;
                transition: color 0.3s ease-in-out;
            }

            .list-task li {
                width: 100%;
                height: 50px;
                background-color: #fff;
                display: flex;
                justify-content: left;
                align-items: center;
                cursor: pointer;
                transition: all 0.3s ease-in-out;
                text-align: left;
            }

            .list-task li:hover {
                background-color: #4c1864;
                color: white;
            }

            .list-task li span {
                margin-left: 30px;
                margin-right: 35px;
            }

            .logout {
                position: absolute;
                bottom: 20px;
                left: 50%;
                transform: translateX(-50%);
            }

            .logout a {
                text-decoration: none;
                color: black;
            }

            .right-sider {
                margin-left: 250px;
                position: relative;
            }

            .right-sider .header {
                display: flex;
                background: linear-gradient(45deg, rgba(76, 24, 100, 0.85) 0%, rgba(63, 24, 154, 0.85) 100%);
                height: 9vh;
            }

            .avatar img {
                width: 40px;
                height: 40px;
                border-radius: 50%;
            }

            .header .info {
                display: flex;
                position: absolute;
                right: 30px;
                top: 20px;
                color: white;
            }
            .info {
                display: flex;
                align-items: center;
            }
            .header .title {
                position: absolute;
                left: 40px;
                top: 28px;
                color: white;
            }

            .name .fullname {
                margin-left: 10px;
                line-height: 40px;
            }

            /*      .row {
                     position: absolute;
                     top: 15vh;
                     display: flex;
                     justify-content: center;
                     align-items: center;
                     margin-left: 50px;
                  }*/
            .row{
                margin: 20px;
            }
            .box {
                padding: 15px;
                border-radius: 7px;
                background-color: white;
                width: 300px;
                margin-right: 40px;
            }

            .box-body-header {
                display: flex;
                position: relative;
            }

            .box-body-header .symbol {
                position: absolute;
                right: 10px;
                color: green;
                font-size: 20px;
            }

            .box-body-content {
                padding-top: 35px;
            }

            /*      #incomeChart {
                     width: 800px !important;
                     height: 500px !important;
                  }*/

            #enrollChart {
                width: 550px !important;
                height: 230px !important;
                color: #f7b205;
            }
            #course-trend {
                width: 550px !important;
                height: 230px !important;
                color: #f7b205;
            }

            #user-registeration {
                width: 550px !important;
                height: 230px !important;
                color: #f7b205;
            }

            .imcome-chart {
                margin-right: 50px;
                margin-top: 20px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
                width: fit-content;
                border-radius: 5px;
                padding: 10px;
                /* background-color: #4c1864; */
            }

            .chart-area {
                display: flex;
                justify-content: center;
            }

            .enroll-chart{
                margin-left: 3%;
                background-color: #fff;
                box-shadow:0 3px 10px 0px rgba(0,0,0,.08);
                border-radius: 4px;
                height: fit-content;
            }
            .enroll-chart .upper-chart{
                margin-bottom: 20px;
            }
            .enroll-chart .upper-chart .wc-title h4{
                padding: 15px 15px;
                border-bottom:1px solid rgba(0,0,0,0.05);
                font-size:16px;
                line-height:18px;
                margin:0;
                color:#333;
                font-weight:500;
            }

            .enroll-chart .lower-chart .wc-title h4{
                padding: 15px 15px;
                border-bottom:1px solid rgba(0,0,0,0.05);
                font-size:16px;
                line-height:18px;
                margin:0;
                color:#333;
                font-weight:500;
            }
            .view-more-btn {
                margin-left: 715px; /* Di chuy?n nút v? phía bên ph?i */
                padding: 5px 10px; /* ?i?u ch?nh ?? l?ch và ?? l?n c?a nút */
                background-color: #007bff; /* Màu n?n c?a nút */
                color: #fff; /* Màu ch? c?a nút */
                border: none; /* Lo?i b? ???ng vi?n c?a nút */
                cursor: pointer; /* Bi?n con tr? thành hình tay khi di chu?t qua nút */
            }
            .view-more-btn1 {
                margin-left: 400px; /* Di chuy?n nút v? phía bên ph?i */
                padding: 5px 10px; /* ?i?u ch?nh ?? l?ch và ?? l?n c?a nút */
                background-color: #007bff; /* Màu n?n c?a nút */
                color: #fff; /* Màu ch? c?a nút */
                border: none; /* Lo?i b? ???ng vi?n c?a nút */
                cursor: pointer; /* Bi?n con tr? thành hình tay khi di chu?t qua nút */
            }

        </style>
        <style>
            .btn:hover{
                color:white;
            }
            .wc-title{
                position: relative;
            }
            .days{
                position: absolute;
                right: 20px;
                top: 20px;
            }

            .btn{
                position: absolute;
                right: 10px;
                top: 10px;
                padding: 5px;
            }

            .arrow {
                font-size: 20px;
                padding: 10px;
                cursor: pointer;
            }

            .dropdown-list {
                display: none;
                position: absolute;
                top: 50px;
                right: 10px;
                background-color: white;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
                width: 150px;
                z-index: 4;
            }

            .dropdown-list ul {
                list-style-type: none;
                padding: 10px;
            }

            .dropdown-list ul li {
                margin-bottom: 10px;
            }

            .overlay {
                height: 100%;
                width: 0;
                position: fixed;
                z-index: 2;
                left: 0;
                top: 0;
                background-color: rgb(0, 0, 0);
                background-color: rgba(0, 0, 0, 0);
                overflow-x: hidden;
            }
            a:hover {
                color:white;
            }
        </style>

    </head>

    <body class="ttr-opened-sidebar ttr-pinned-sidebar">
        <div id="myNav" class="overlay" onclick="closeNav()">
        </div>
        <div class="left-sider">
            <div class="logo">
                <a href="../home"><img src="../assets/images/logoBlack.png" alt=""/></a> 
            </div>
            <div class="navigator">
                <ul class="list-task">
                    <!-- style này là ?? ?ánh d?u xem cái nào ?ang ???c ch?n -->
                    <li style="background-color: #f7b205;" class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                        <span class="material-symbols-outlined">tv</span><a>Dashboard</a>
                    </li>
                    <li onclick="goTo('userList')" class="list-item" style="margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">person</span><a href="userList">Users</a></li>

                    <li onclick="goTo('post')" class="list-item" style="margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">post_add</span><a href="post">Posts</a>
                    </li>
                    <li onclick="goTo('slider')" class="list-item" style="margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">sliders</span><a href="slider">Sliders</a>
                    </li>
                    <li onclick="goTo('enrollmentlist')" class="list-item" style="margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">how_to_reg</span><a href="enrollmentlist">Enrollment</a></li>
                </ul>
            </div>
        </div>


        <!-- Xoa tu cho nay -->
        <div class="right-sider">
            <div class="header" style="height: 10vh">
                <div class="title"><span>BLOGS</span></div>
                <div class="info">
                    <span class="avatar">
                        <img src="${sessionScope.user.img}" alt>
                    </span>
                    <div class="name">
                        <span class="fullname">${sessionScope.user.name}</span>
                    </div>
                    <div class="arrow" onclick="toggleDropdown()">
                        <span><svg xmlns="http://www.w3.org/2000/svg"
                                   width="16"
                                   height="16" fill="currentColor"
                                   class="bi bi-caret-down-fill" viewBox="0 0 16 16">
                            <path
                                d="M7.247 11.14 2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z" />
                            </svg></span>
                    </div>
                    <div class="dropdown-list" id="dropdownList">
                        <ul>
                            <li><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                                <path
                                    d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z" />
                                </svg><a href="../editprofile">Profile</a></li>
                            <li><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                                <path fill-rule="evenodd"
                                      d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0z" />
                                <path fill-rule="evenodd"
                                      d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z" />
                                </svg><a href="../logout">Logout</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row" style="margin: 20px">
                <div class="col-md-6 col-lg-4 col-xl-4 col-sm-6 col-12">
                    <div class="widget-card widget-bg1">					 
                        <div class="wc-item">
                            <h4 class="wc-title">
                                Total income
                            </h4>
                            <span class="wc-des">
                                Change
                            </span>
                            <span class="wc-stats"> 
                                <span class="counter"><fmt:formatNumber value="${requestScope.currentMonthRevenue}" pattern="000,000"/> </span>D
                            </span>		
                            <span class="wc-progress-bx">
                                <span class="wc-change">
                                    <c:if test="${requestScope.currentMonthRevenue >= requestScope.previousMonthRevenue}">
                                        <span><svg style="color: white; font-weight: 800;"
                                                   xmlns="http://www.w3.org/2000/svg" width="16"
                                                   height="16" fill="currentColor"
                                                   class="bi bi-arrow-up" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd"
                                                  d="M8 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L7.5 2.707V14.5a.5.5 0 0 0 .5.5" />
                                            </svg></span>
                                        </c:if>
                                        <c:if test="${requestScope.currentMonthRevenue < requestScope.previousMonthRevenue}">
                                        <span><svg style="color: white;"
                                                   xmlns="http://www.w3.org/2000/svg" width="16"
                                                   height="16" fill="currentColor"
                                                   class="bi bi-arrow-down" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd"
                                                  d="M8 1a.5.5 0 0 1 .5.5v11.793l3.146-3.147a.5.5 0 0 1 .708.708l-4 4a.5.5 0 0 1-.708 0l-4-4a.5.5 0 0 1 .708-.708L7.5 13.293V1.5A.5.5 0 0 1 8 1" />
                                            </svg></span>
                                        </c:if>
                                        <fmt:formatNumber value="${Math.abs(requestScope.currentMonthRevenue / requestScope.previousMonthRevenue * 100-100)}" pattern="0.00"/> %

                                </span>
                                <span class="wc-number ml-auto">
                                    Since last month
                                </span>
                            </span>
                        </div>				      
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-4 col-sm-6 col-12">
                    <div class="widget-card widget-bg2">					 
                        <div class="wc-item">
                            <h4 class="wc-title">
                                Course Registration    
                            </h4>
                            <span class="wc-des">
                                Change
                            </span>
                            <span class="wc-stats counter">
                                <fmt:formatNumber value="${requestScope.currentWeekCourseRegistration}"/> 
                            </span>		

                            <span class="wc-progress-bx">
                                <span class="wc-change">
                                    <c:if test="${requestScope.currentWeekCourseRegistration >= requestScope.lastWeekCourseRegistration}">
                                        <span>
                                            <svg style="color: white; font-weight: 800;"
                                                 xmlns="http://www.w3.org/2000/svg" width="16"
                                                 height="16" fill="currentColor"
                                                 class="bi bi-arrow-up" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd"
                                                  d="M8 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L7.5 2.707V14.5a.5.5 0 0 0 .5.5" />
                                            </svg>
                                        </span>
                                    </c:if>
                                    <c:if test="${requestScope.currentWeekCourseRegistration < requestScope.lastWeekCourseRegistration}">
                                        <span>
                                            <svg style="color: white;"
                                                 xmlns="http://www.w3.org/2000/svg" width="16"
                                                 height="16" fill="currentColor"
                                                 class="bi bi-arrow-down" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd"
                                                  d="M8 1a.5.5 0 0 1 .5.5v11.793l3.146-3.147a.5.5 0 0 1 .708.708l-4 4a.5.5 0 0 1-.708 0l-4-4a.5.5 0 0 1 .708-.708L7.5 13.293V1.5A.5.5 0 0 1 8 1" />
                                            </svg>
                                        </span>
                                    </c:if>
                                    <fmt:formatNumber value="${Math.abs(requestScope.currentWeekCourseRegistration / requestScope.lastWeekCourseRegistration * 100-100)}" pattern="0.00"/> %

                                </span>
                                <span class="wc-number ml-auto">
                                    Since last week
                                </span>
                            </span>
                        </div>				      
                    </div>
                </div>
                <div class="col-md-6 col-lg-4 col-xl-4 col-sm-6 col-12">
                    <div class="widget-card widget-bg3">					 
                        <div class="wc-item">
                            <h4 class="wc-title">
                                User Registration 
                            </h4>
                            <span class="wc-des" style="padding-bottom: 10px">
                                Change 
                            </span>
                            <span class="wc-stats counter">
                                <fmt:formatNumber value="${requestScope.currentWeekUserRegister}"/>  
                            </span>		

                            <span class="wc-progress-bx">
                                <span class="wc-change">
                                    <c:if test="${requestScope.currentWeekUserRegister >= requestScope.previousWeekUserRegister}">
                                        <span>
                                            <svg style="color: white; font-weight: 800;"
                                                 xmlns="http://www.w3.org/2000/svg" width="16"
                                                 height="16" fill="currentColor"
                                                 class="bi bi-arrow-up" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd"
                                                  d="M8 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L7.5 2.707V14.5a.5.5 0 0 0 .5.5" />
                                            </svg>
                                        </span>
                                    </c:if>
                                    <c:if test="${requestScope.currentWeekUserRegister < requestScope.previousWeekUserRegister}">
                                        <span>
                                            <svg style="color: white;"
                                                 xmlns="http://www.w3.org/2000/svg" width="16"
                                                 height="16" fill="currentColor"
                                                 class="bi bi-arrow-down" viewBox="0 0 16 16">
                                            <path fill-rule="evenodd"
                                                  d="M8 1a.5.5 0 0 1 .5.5v11.793l3.146-3.147a.5.5 0 0 1 .708.708l-4 4a.5.5 0 0 1-.708 0l-4-4a.5.5 0 0 1 .708-.708L7.5 13.293V1.5A.5.5 0 0 1 8 1" />
                                            </svg>
                                        </span>
                                    </c:if>
                                    <fmt:formatNumber value="${Math.abs(requestScope.currentWeekUserRegister / requestScope.previousWeekUserRegister * 100 - 100)}" pattern="0.00"/> %

                                </span>
                                <span class="wc-number ml-auto">
                                    Since last week
                                </span>
                            </span>
                        </div>				      
                    </div>
                </div>

            </div>
            <div class="row" style="margin: 20px">
                <!-- Your Profile Views Chart -->
                <div class="col-lg-7 m-b30">
                    <div class="widget-box">
                        <div class="wc-title">
                            <h4>Total income <button class="btn" style="padding: 10px"><a href="revenusStats">View More</a></button></h4>
                        </div>
                        <div class="widget-inner">
                            <canvas id="incomeChart" style="width: 200px; height: 100px;"></canvas>
                        </div>
                    </div>
                </div>
                <div class="col-lg-5 m-b30">
                    <div class="enroll-chart">
                        <div class="upper-chart">
                            <div class="wc-title">
                                <h4>Course Registration <button class="btn" style="margin-left: 400px"><a href="courseregistrationStats">View More</a></button></h4>
                            </div>
                            <div class="widget-inner">
                                <canvas id="enrollChart" style="height:40vh; width:80vw;"></canvas>
                            </div>
                        </div>
                    </div>
                    <div class="enroll-chart">
                        <div class="lower-chart">
                            <div class="wc-title">
                                <h4>User Registration <button class="btn" style="margin-left: 400px"><a href="userregisterStat">View More</a></button></h4>
                            </div>
                            <div class="chart">
                                <canvas id="user-registeration" style="height:40vh; width:80vw;"></canvas>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="col-lg-6 m-b30">
                    <div class="widget-box">
                        <div class="wc-title">
                            <h4>Course trend</h4>
                            <form id="courseForm" action="report" method="get">
                                <select class="days" name="cdays" onchange="submitCourseForm()">
                                    <option value="7" <c:if test="${7 eq param.cdays}">
                                            selected="selected"
                                        </c:if>>Last 7 days</option>
                                    <option value="30" <c:if test="${30 eq param.cdays}">
                                            selected="selected"
                                        </c:if>>Last 30 days</option>

                                </select>
                                <input type="hidden" name="bdays" value="${requestScope.daysOfBlogTrend}">
                            </form>
                        </div>
                        <div class="widget-inner">
                            <canvas id="courseTrend" style="width: 200px; height: 100px;"></canvas>
                            <p style="text-align: center; font-weight: bold;">Chart 1: The chart shows the 5 courses with the most registrations</p>
                            <canvas id="course-registration-piechart" style="width: 200px; height: 100px; margin: 50px;"></canvas>
                            <p style="text-align: center; font-weight: bold;">Chart 2: The chart shows the number of registrations by course</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 m-b30">
                    <div class="widget-box">
                        <div class="wc-title">
                            <h4>Blog trend</h4>
                            <form id="blogForm" action="report" method="get">
                                <select class="days" name="bdays" onchange="submitBlogForm()">
                                    <option value="7" <c:if test="${7 eq param.bdays}">
                                            selected="selected"
                                        </c:if>>Last 7 days</option>
                                    <option value="30" <c:if test="${30 eq param.bdays}">
                                            selected="selected"
                                        </c:if>>Last 30 days</option>
                                </select>
                                <input type="hidden" name="cdays" value="${requestScope.daysOfCourseTrend}">
                            </form>
                        </div>
                        <div class="widget-inner">
                            <canvas id="blogTrend" style="width: 200px; height: 100px;"></canvas>
                            <p style="text-align: center; font-weight: bold">Chart 3: The chart shows the 5 blogs with the most views</p>
                            <canvas id="blogview-piechart" style="width: 200px; height: 100px; margin: 50px;"></canvas>
                            <p style="text-align: center; font-weight: bold">Chart 4: The chart shows the number of views by blog</p>
                        </div>
                    </div>
                </div>
            </div>


        </div>
        <script>
            function goTo(url) {
            window.location = url;
            }
            function toggleDropdown() {
            var dropdown = document.getElementById("dropdownList");
            if (dropdown.style.display === "block") {
            dropdown.style.display = "none";
            document.getElementById("myNav").style.width = "0%";
            } else {
            dropdown.style.display = "block";
            document.getElementById("myNav").style.width = "100%";
            }
            }

            function closeNav() {
            document.getElementById("myNav").style.width = "0%";
            var dropdown = document.getElementById("dropdownList");
            dropdown.style.display = "none";
            }
        </script>
        <script>
            function submitCourseForm() {
            document.getElementById("courseForm").submit();
            }
        </script>
        <script>
            function submitBlogForm() {
            document.getElementById("blogForm").submit();
            }
        </script>

        <script>
            function toWhite(element) {
            var anchor = element.querySelector('a');
            if (anchor) {
            anchor.style.color = 'white';
            }
            }

            function toBlack() {
            var firstChild = document.querySelectorAll('.list-item > a');
            firstChild.forEach(element => {
            element.style.color = 'black';
            });
            }
        </script>

        <!-- 6 -->
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script>
            //bi?u ?? blog ???c xem nhi?u nh?t trong tháng
            const blogTrend = document.getElementById('blogTrend');
            new Chart(blogTrend, {
            type: 'bar',
                    data: {
                    labels: [<c:forEach var="entry" items="${blogViewTrend}" varStatus="loop">
                    '${entry.key.blog.title}'<c:if test="${not loop.last}">, </c:if>
            </c:forEach> ],
                            datasets: [{
                            label: 'Number of view',
                                    data: [
            <c:forEach var="entry" items="${blogViewTrend}" varStatus="loop">
                ${entry.value}<c:if test="${not loop.last}">, </c:if>
            </c:forEach> ],
                                    borderWidth: 2,
                                    borderColor: '#f7b205',
                                    backgroundColor: '#f7b205',
                                    barPercentage: 0.2,
                                    categoryPercentage: 1
                            }]
                    },
                    options: {
                    indexAxis: 'x',
                            scales: {
                            x: {
                            grid: {
                            drawOnChartArea: false
                            }
                            },
                                    y: {
                                    beginAtZero: true,
                                            // grid: {
                                            //    drawOnChartArea: false
                                            // }
                                    },
                                    barPercentage: 0.4

                            }
                    }
            });
        </script>
        <!--    7-->
        <script>
            // Bi?u ?? tròn cho các blog ?ang trend trong tháng theo view
            var blogViewData = {
            labels: [
            <c:forEach var="entry" items="${blogViewTrend}" varStatus="loop">
            '${entry.key.blog.title}',
            </c:forEach>
            'Other blog'],
                    datasets: [{
                    data: [
            <c:forEach var="entry" items="${blogViewTrend}" varStatus="loop">
                ${entry.value},
            </c:forEach>
            ${requestScope.remainningView} ],
                            backgroundColor: ['red', 'green', 'blue', 'pink', 'yellow', 'purple']
                    }]
            };
            // L?y th? canvas c?a bi?u ?? tròn
            var pieChartCanvas = document.getElementById('blogview-piechart').getContext('2d');
            // V? bi?u ?? tròn
            new Chart(pieChartCanvas, {
            type: 'pie',
                    data: blogViewData,
                    options: {
                    tooltips: {
                    callbacks: {
                    label: function (tooltipItem, data) {
                    var dataset = data.datasets[tooltipItem.datasetIndex];
                    var total = dataset.data.reduce(function (previousValue, currentValue, currentIndex, array) {
                    return previousValue + currentValue;
                    });
                    var currentValue = dataset.data[tooltipItem.index];
                    var percentage = Math.floor(((currentValue / total) * 100) + 0.5);
                    return data.labels[tooltipItem.index] + ": " + percentage + "%";
                    }
                    }
                    }
                    }
            });
        </script>
        <!--4-->
        <script>
            //bi?u ?? tròn cho t?ng course category ???c ??ng kí theo tháng
            const courseTrend = document.getElementById('courseTrend');
            new Chart(courseTrend, {
            type: 'bar',
                    data: {
                    //            labels: ['Course1', 'Course2', 'Course3', 'Course4', 'Course5', 'Course6', 'Course7'],
                    labels: [
            <c:forEach var="entry" items="${courseTrend}" varStatus="loop">
                    '${entry.key.course.name}'<c:if test="${not loop.last}">, </c:if>
            </c:forEach> ],
                            datasets: [{
                            label: 'Number of registration',
                                    data: [
            <c:forEach var="entry" items="${courseTrend}" varStatus="loop">
                                    '${entry.value}'<c:if test="${not loop.last}">, </c:if>
            </c:forEach> ],
                                    borderWidth: 2,
                                    borderColor: '#f7b205',
                                    backgroundColor: '#f7b205',
                                    barPercentage: 0.2,
                                    categoryPercentage: 1
                            }]
                    },
                    options: {
                    indexAxis: 'x',
                            scales: {
                            x: {
                            grid: {
                            drawOnChartArea: false
                            }
                            },
                                    y: {
                                    beginAtZero: true,
                                            // grid: {
                                            //    drawOnChartArea: false
                                            // }
                                    },
                                    barPercentage: 0.4

                            }
                    }
            });
        </script>
        <!--5-->
        <script>
            // Bi?u ?? tròn cho các course ?ang trend trong tháng
            var cRegisterData = {
            labels: [
            <c:forEach var="entry" items="${courseTrend}" varStatus="loop">
            '${entry.key.course.name}',
            </c:forEach>
            'Other course'],
                    datasets: [{
                    data: [
            <c:forEach var="entry" items="${courseTrend}" varStatus="loop">
                ${entry.value},
            </c:forEach>
            ${requestScope.remainCourses} ],
                            backgroundColor: ['red', 'green', 'blue', 'pink', 'yellow', 'purple']
                    }]
            };
            // L?y th? canvas c?a bi?u ?? tròn
            var pieChartCanvas = document.getElementById('course-registration-piechart').getContext('2d');
            // V? bi?u ?? tròn
            new Chart(pieChartCanvas, {
            type: 'pie',
                    data: cRegisterData,
                    options: {
                    tooltips: {
                    callbacks: {
                    label: function (tooltipItem, data) {
                    var dataset = data.datasets[tooltipItem.datasetIndex];
                    var total = dataset.data.reduce(function (previousValue, currentValue, currentIndex, array) {
                    return previousValue + currentValue;
                    });
                    var currentValue = dataset.data[tooltipItem.index];
                    var percentage = Math.floor(((currentValue / total) * 100) + 0.5);
                    return data.labels[tooltipItem.index] + ": " + percentage + "%";
                    }
                    }
                    }
                    }
            });
        </script>

        <!--1-->  
        <script>
            const ctx = document.getElementById('incomeChart');
            new Chart(ctx, {
            type: 'line',
                    data: {
                    labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'July', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                            datasets: [{
                            label: 'Income',
                                    data: [${requestScope.revenueList[0]}, ${requestScope.revenueList[1]}, ${requestScope.revenueList[2]}, ${requestScope.revenueList[3]}, ${requestScope.revenueList[4]}, ${requestScope.revenueList[5]}, ${requestScope.revenueList[6]}, ${requestScope.revenueList[7]}, ${requestScope.revenueList[8]}, ${requestScope.revenueList[9]}, ${requestScope.revenueList[10]}, ${requestScope.revenueList[11]}],
                                    borderWidth: 1,
                                    borderColor: '#4c1864',
                                    backgroundColor: '#4c1864'

                            }]
                    },
                    options: {
                    legend: {
                    labels: {
                    fontColor: "white",
                            fontSize: 18
                    }
                    },
                            scales: {

                            x: {
                            grid: {
                            drawOnChartArea: false,
                            },
                                    ticks: {
                                    fontColor: "green",
                                            fontSize: 18,
                                            stepSize: 1,
                                            beginAtZero: true
                                    }

                            },
                                    y: {
                                    beginAtZero: true,
                                            // grid: {
                                            //    drawOnChartArea: false
                                            // }
                                    },
                            }
                    }
            });
        </script>
        <!--2-->
        <script>
            const enroll = document.getElementById('enrollChart');
            new Chart(enroll, {
            type: 'bar',
                    data: {
                    labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
                            datasets: [{
                            label: 'New registration',
                                    data: [${requestScope.cregisterList[0]},${requestScope.cregisterList[1]},${requestScope.cregisterList[2]},${requestScope.cregisterList[3]},${requestScope.cregisterList[4]},${requestScope.cregisterList[5]},${requestScope.cregisterList[6]}],
                                    //data: [12, 19, 3, 5, 2, 3, 10],
                                    borderWidth: 2,
                                    borderColor: '#f7b205',
                                    backgroundColor: '#f7b205',
                                    barPercentage: 0.2,
                                    categoryPercentage: 1
                            }]
                    },
                    options: {
                    indexAxis: 'x',
                            scales: {
                            x: {
                            grid: {
                            drawOnChartArea: false
                            }
                            },
                                    y: {
                                    beginAtZero: true,
                                            // grid: {
                                            //    drawOnChartArea: false
                                            // }
                                    },
                                    barPercentage: 0.4

                            }
                    }
            });
        </script>
        <!--3-->
        <script>
            const registeration = document.getElementById('user-registeration');
            new Chart(registeration, {
            type: 'bar',
                    data: {
                    labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
                            datasets: [{
                            label: 'New registration',
                                    data: [${requestScope.uregisterList[0]},${requestScope.uregisterList[1]},${requestScope.uregisterList[2]},${requestScope.uregisterList[3]},${requestScope.uregisterList[4]},${requestScope.uregisterList[5]},${requestScope.uregisterList[6]}],
                                    borderWidth: 2,
                                    borderColor: '#f7b205',
                                    backgroundColor: '#f7b205',
                                    barPercentage: 0.2,
                                    categoryPercentage: 1
                            }]
                    },
                    options: {
                    indexAxis: 'x',
                            scales: {
                            x: {
                            grid: {
                            drawOnChartArea: false
                            }
                            },
                                    y: {
                                    beginAtZero: true,
                                            // grid: {
                                            //    drawOnChartArea: false
                                            // }
                                    },
                                    barPercentage: 0.4
                            }
                    }
            });
        </script>

    </body>

</html>