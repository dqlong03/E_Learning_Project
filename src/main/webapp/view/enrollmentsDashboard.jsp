<%-- 
    Document   : courseDashboard
    Created on : Feb 5, 2024, 9:34:27 PM
    Author     : tran Hoang Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
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
        <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>E-Learning : Education & Course </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="../assets/css/color/color-1.css">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

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

            .logo img {
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
                height: 10vh;
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

            .content{
                height: 100vh;
                margin-top: 3%;
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

            #pagger{
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 10px;
                background-color: #f2f2f2;
                margin-top: 2%;
            }

            #pagger a{
                color: #333;
                padding: 8px 12px;
                margin: 0 5px; /* Khoảng cách giữa các số */
                text-decoration: none;
                border: 1px solid #ddd;
                border-radius: 4px;
                display: inline-block;
                cursor: pointer;
            }

            #pagger a span {
                display: inline-block;
            }

            #pagger a:hover {
                background-color: #ddd;
            }

            .table-sortable th {
                cursor: pointer;
            }

            .table-sortable .th-sort-asc::after {
                content: "\25b4";
            }

            .table-sortable .th-sort-desc::after {
                content: "\25be";
            }

            .table-sortable .th-sort-asc::after,
            .table-sortable .th-sort-desc::after {
                margin-left: 5px;
            }

            .table-sortable .th-sort-asc,
            .table-sortable .th-sort-desc {
                background: rgba(0, 0, 0, 0.1);
            }

            .search-form {
                display: flex;
                align-items: center;
                height: 5vh;
            }

            .search-form {
                display: flex;
                flex-wrap: wrap;
            }

            .search-form label, .search-form input, .search-form select {
                margin-right: 10px;
                margin-bottom: 10px;
            }

            #combinedChart {
                width: 800px !important;
                height: 500px !important;
            }

            .chooseCourse form {
                display: flex;
                flex-wrap: nowrap; /* Đảm bảo các phần tử không bị trượt xuống hàng mới */
            }

            .chooseCourse form input {
                max-width: 30%;
                flex: 1; /* Căn chỉnh các ô input để chia đều không gian trên hàng */
                margin-right: 3%; /* Khoảng cách giữa các ô input */
                height: 30px;
                margin-left: 1%;
            }

            .chooseCourse form input[type="submit"] {
                flex: 0; /* Không phủ định flex để nút "Submit" không căng ra như ô input */
            }

            .leftPage{
                margin-left: 2%;
            }

            .leftPage, .rightPage {
                width: 45%;
                float: left;
                box-sizing: border-box;
            }

            .container {
                display: flex;
                flex-wrap: wrap;
            }

            canvas{
                margin-left: 6%;
            }

            .chooseCourse{
                margin-left: 12%;
                margin-top: 5%;
            }

            .chooseCourse label{
                line-height: 30px;
            }

            .listCourseTable{
                overflow-y: scroll;
            }

            .listEnrollTable td{
                padding: 3px 0px;
            }

            .table-container {
                position: relative;
                overflow-y: auto;
                overflow-x: hidden; /* Ẩn thanh cuộn ngang */
                max-height: 445px;
            }

            .table-sortable thead {
                position: sticky;
                top: 0;
                z-index: 1;
                background-color: #f2f2f2;
                width: calc(100% - 17px); /* Đảm bảo rằng chiều rộng của thead giống với tbody */
            }
            .img_not_found {
                margin-left: 20%;
            }
            .not_found {
                margin-left: 25%;
            }

        </style>
    </head>

    <body>
        <div id="myNav" class="overlay" onclick="closeNav()">
        </div>
        <div class="left-sider">
            <div class="logo">
                <img src="../assets/images/logoBlack.png" onclick="goTo('../home')" alt>
            </div>
            <div class="navigator">
                <ul class="list-task">
                    <li onclick="goTo('report')" class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                        <span class="material-symbols-outlined">tv</span><a>Dashboard</a>
                    </li>
                    <li onclick="goTo('userList')" class="list-item" style="margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">person</span><a href="userList">Users</a></li>

                    <li onclick="goTo('post')" class="list-item" style="margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">post_add</span><a href="post">Posts</a>
                    </li>
                    <li onclick="goTo('slider')" class="list-item" style="margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">sliders</span><a href="slider">Sliders</a>
                    </li>
                    <li  class="list-item" style="background-color: #f7b205;margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">how_to_reg</span><a>Enrollment</a></li>
                </ul>
            </div>
        </div>
        <div class="right-sider">
            <div class="header">
                <div class="title"><span>ENROLLMENTS</span></div>
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


            <!--Code nội dung cm vào đây-->

            <div class="content">

                <div class="leftPage">
                    <form action="enrollmentlist" method="get">
                        <table class="listEnrollTable">
                            <tbody>
                                <tr>
                                    <td><label for="email">Email:</label></td>
                                    <td><input type="text" id="email" name="email" placeholder="All" value="${param.email}"></td>
                                    <td><label for="course_name">Course Name:</label></td>
                                    <td><input type="text" id="course_name" name="course_name" placeholder="All" value="${param.course_name}"></td>
                                </tr>
                                <tr>
                                    <td><label for="course_category">Course Category:</label></td>
                                    <td><select id="course_category" name="course_category">
                                            <option value="0" ${param.course_category eq 0 ? "selected": ""}>All category </option>
                                            <c:forEach var="c" items="${requestScope.courseCategoryList}">
                                                <option value="${c.courseCategoryId}" ${param.course_category eq c.courseCategoryId ? "selected": ""}>${c.name}</option>
                                            </c:forEach>
                                        </select></td>
                                    <td><label for="course_duration">Course Duration:</label></td>
                                    <td><select id="course_duration" name="course_duration">
                                            <option value="0" ${param.course_duration eq 0 ? "selected": ""}>All duration </option>
                                            <c:forEach var="d" items="${requestScope.durationList}">
                                                <option value="${d.durationId}" ${param.course_duration eq d.durationId ? "selected": ""}>${d.name}</option>
                                            </c:forEach>
                                        </select></td>
                                </tr>
                                <tr>
                                    <td><label for="date_from">Date From:</label></td>
                                    <td><input type="date" id="date_from" name="date_from" value="${requestScope.dateFrom}"><span></span></td>
                                    <td><label for="date_to">Date To:</label></td>
                                    <td><input type="date" id="date_to" name="date_to" value="${requestScope.dateTo}">
                                        <span style="margin-left: 5%;">
                                            <button type="submit" style="color:white; background-color: black;margin-bottom: 0px;
                                                    height: 30px; margin-left: 2%; padding: 0px 5px;" class="fa fa-search text-primary"></button>
                                        </span></td>

                                </tr>
                            </tbody>
                            <input type="hidden" value="${requestScope.check}" name="check">
                        </table>
                    </form>

                    <c:if test="${requestScope.list!= null and requestScope.list.size()>0}">
                        <div class="listEnrollmentTable">
                            <table class="table-sortable" border="1">
                                <thead>
                                    <tr style="background-color: #f2f2f2;">
                                        <th>#</th>
                                        <th>Email</th>
                                        <th>Coursename</th>
                                        <th>Category</th>
                                        <th>Duration</th>
                                        <th>Created time</th>
                                        <th>Cost</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="rs" items="${requestScope.list}" varStatus="i">
                                        <tr onclick="window.location = 'enrollmentdetail?regId=${rs.courseRegisterationId}'" style="cursor: pointer;">
                                            <td>${i.count}</td>
                                            <td>${rs.user.account.email}</td>
                                            <td>${rs.course.name}</td>
                                            <td>${rs.course.category.name}</td>
                                            <td>${rs.course.duration.name}</td>
                                            <td>${rs.createdTime}</td>
                                            <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${rs.course.price}" /></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <c:if test="${requestScope.total ne null}">
                            <div id="totalIncome"  style="font-size: 22px;"><span>Total income: </span>
                                <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${requestScope.total}" /> d</div>
                            </c:if>
                        <div id="pagger"></div>

                    </c:if>
                    <c:if test="${requestScope.list ne null and requestScope.list.size()==0}">
                        <div class="img_not_found">
                            <img src="../assets/images/404.2 (1).png" alt=""/>
                        </div>
                        <h3 class="not_found">No enrollments found!</h3>
                    </c:if>
                </div>       
                <div class="rightPage">
                    <div class="chart-area">
                        <canvas id="combinedChart"></canvas>
                        <h4 style="text-align: center; margin-left: 25%; margin-top: 2%">Enrollment and Income Correlation Chart</h4>
                    </div>
                    <div class="chooseCourse" style="width: 110%;">
                        <form action="addenrollments" method="get">
                            <label for="email">Email:</label><br>
                            <input type="text" id="emailChoose" onclick="hideError()" name="emailAdd" placeholder="Email" value="${requestScope.emailAdd}"><br><br>
                            <label for="coursename">Course Name:</label><br>
                            <input type="text" id="coursename" name="coursename" placeholder="Course name" value="${requestScope.coursename}"><br><br>
                            <button type="submit" style="color:white; background-color: black; height: 30px; padding: 0px 5px;" class="fa fa-search text-primary;"></button>
                        </form>
                    </div>
                    <div class="add-enrollment" style="width: 110%; margin-left: 12%; width: 102%;">
                        <form action="addenrollments" method="post" id="addReg">
                            
                            <c:if test="${requestScope.courses ne null and requestScope.courses.size() > 0}">
                                <div class="table-container">
                                    <table class="table-sortable" border="1" style="margin-bottom: 10px;">
                                        <thead>
                                            <tr style="background-color: #f2f2f2;">
                                                <th>#</th>
                                                <th>Name</th>
                                                <th>Category</th>
                                                <th>Level</th>
                                                <th>Language</th>
                                                <th>Cost</th>
                                                <th>Author</th>
                                            </tr>
                                        </thead>
                                        <div class="listCourseTable">
                                            <tbody>

                                            <input type="hidden" value="${requestScope.emailAdd}" id="emailAdd" name="emailAdd">
                                            <input type="hidden" value="${requestScope.coursename}" name="coursename" id="searchCourseInfo">
                                            <c:forEach var="c" items="${requestScope.courses}" varStatus="i">
                                                <tr style="cursor: pointer;" onclick="courseChosen('courseId${c.courseId}', this)">
                                                    <td>${i.count}</td>
                                                    <td>${c.name}</td>
                                                    <td>${c.category.name}</td>
                                                    <td>${c.level.name}</td>
                                                    <td>${c.language.name}</td>
                                                    <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${c.price}" /></td>
                                                    <td>${c.author.name}</td>
                                                <input style="display:none;" id="courseId${c.courseId}" type="checkbox" name="chosenCourses" class="courses" value="${c.courseId}">
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </div>
                                    </table>
                                </div>
                            </c:if> 
                            <c:if test="${requestScope.mesString!=null}">
                                <div  id="mesString" class="mesString" style="margin:0 0 2% 0%;">${requestScope.mesString}</div>                        
                            </c:if>
                            <div id="error" ${requestScope.courses.size() < 5?"style=\"margin-bottom: 10px;\"":""} ></div>                       

                            <c:if test="${requestScope.courses ne null and requestScope.courses.size() >0}">
                                <button ${requestScope.courses.size() >5?"style=\"margin-top: 10px;\"":""}  class="btn" type="button" onclick="submitForm()"><b>Add new enrollments</b></button>
                            </c:if>
                            <c:if test="${requestScope.courses ne null and requestScope.courses.size() == 0}">
                                <div class="img_not_found">
                                    <img src="../assets/images/404.2 (1).png" alt=""/>
                                </div>
                                <h3 class="not_found">No courses found!</h3>
                            </c:if>
                        </form>
                    </div>
                </div>
            </div>

            <script>
                function goTo(url) {
                    window.location = url;
                }
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

            <script>


                function hideError() {
                    const error = document.getElementById('error');
                    const mesString = document.getElementById('mesString');
                    error.style.display = 'none';
                    mesString.style.display = 'none';
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

                function courseChosen(id, row) {
                    var checkbox = document.getElementById(id);
                    if (checkbox.checked === true) {
                        checkbox.checked = false;
                        row.style.backgroundColor = 'rgba(0, 0, 0, 0)';
                    } else {
                        checkbox.checked = true;
                        row.style.backgroundColor = 'rgba(124, 124, 126, 0.2)';
                        document.getElementById('error').innerHTML = '';
                    }
                }
            </script>

            <script>
                render('pagger', ${requestScope.pageIndex}, ${requestScope.totalPage}, 2, '${requestScope.email}', '${requestScope.courseName}',
                        '${requestScope.courseCategory}', '${requestScope.courseDuration}', '${requestScope.dateFrom}', '${requestScope.dateTo}');
                function render(id, pageIndex, totalPage, gap, email, courseName, couseCategory, courseDuration, dateFrom, dateTo) {
                    var container = document.getElementById(id);
                    console.log(container);
                    if (pageIndex - gap > 1) {
                        container.innerHTML += '<a href="enrollmentlist?page=1' + '&email=' + email + '&course_name=' + courseName + '&course_duration=' + courseDuration + '&course_category=' + couseCategory + '&date_from=' + dateFrom + '&date_to=' + dateTo + '&check=${requestScope.check eq null ? "true" : requestScope.check}">First</a> ';
                    }
                    for (var i = pageIndex - gap; i < pageIndex; i++) {
                        if (i > 0) {
                            container.innerHTML += '<a href="enrollmentlist?page=' + i + '&email=' + email + '&course_name=' + courseName + '&course_duration=' + courseDuration + '&course_category=' + couseCategory + '&date_from=' + dateFrom + '&date_to=' + dateTo + '&check=${requestScope.check eq null ? "true" : requestScope.check}">' + i + '</a>';
                        }
                    }
                    container.innerHTML += '<span>' + pageIndex + '</span>';
                    for (var i = pageIndex + 1; i <= pageIndex + gap && i <= totalPage; i++) {
                        container.innerHTML += '<a href="enrollmentlist?page=' + i + '&email=' + email + '&course_name=' + courseName + '&course_duration=' + courseDuration + '&course_category=' + couseCategory + '&date_from=' + dateFrom + '&date_to=' + dateTo + '&check=${requestScope.check eq null ? "true" : requestScope.check}">' + i + '</a>';
                    }
                    if (pageIndex + gap < totalPage) {
                        container.innerHTML += '<a href="enrollmentlist?page=' + totalPage + '&email=' + email + '&course_name=' + courseName + '&course_duration=' + courseDuration + '&course_category=' + couseCategory + '&date_from=' + dateFrom + '&date_to=' + dateTo + '&check=${requestScope.check eq null ? "true" : requestScope.check}">Last</a>';
                    }
                }

                function submitForm() {
                    var error = '';
                    var inputEmail = document.getElementById('emailChoose').value;
                    if (!inputEmail.match('^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$')) {
                        error = 'Email is invalid. Please try again';
                        document.getElementById('error').textContent = error;
                        document.getElementById('error').style.display = 'block';
                    } else {
                        document.getElementById('emailAdd').value = inputEmail;
                        var courseName = document.getElementById('coursename').value;
                        document.getElementById('searchCourseInfo').value = courseName;
                        var regForm = document.getElementById('addReg');
                        var courses = document.querySelectorAll('.courses');
                        var count = 0;
                        courses.forEach(c => {
                            if (c.checked) {
                                count++;
                            }
                        });
                        if (count === 0) {
                            error = 'Please choose course(s)';
                            document.getElementById('error').textContent = error;
                            document.getElementById('error').style.display = 'block';
                        } else {
                            regForm.submit();
                        }
                    }
                }

            </script>
            <%
            List<Integer> countRegList = (List<Integer>) request.getAttribute("countRegList");
            List<Integer> totalIncomeList = (List<Integer>) request.getAttribute("totalIncomeList");
            %>
            <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
            <script>
                var countRegArray = [
                <c:forEach var="value" items="${countRegList}" varStatus="loop">
                    ${value}${!loop.last ? ', ' : ''}
                </c:forEach>
                ];

                var totalIncomeArray = [
                <c:forEach var="value" items="${totalIncomeList}" varStatus="loop">
                    ${value}${!loop.last ? ', ' : ''}
                </c:forEach>
                ];

                // Mã JavaScript tạo biểu đồ Chart.js với dữ liệu từ danh sách
                const ctx = document.getElementById('combinedChart');
                new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
                        datasets: [{
                                label: 'Income',
                                data: totalIncomeArray,
                                borderWidth: 1,
                                borderColor: '#4c1864',
                                backgroundColor: '#4c1864',
                                yAxisID: 'income',
                                type: 'line'
                            }, {
                                label: 'New people enroll',
                                data: countRegArray,
                                borderWidth: 2,
                                borderColor: '#f7b205',
                                backgroundColor: '#f7b205',
                                barPercentage: 0.2,
                                categoryPercentage: 1,
                                yAxisID: 'enroll'
                            }]
                    },
                    options: {
                        scales: {
                            income: {
                                grid: {
                                    drawOnChartArea: true
                                },
                                title: {
                                    display: true,
                                    text: 'Income',
                                    font: {
                                        size: 18,
                                    },
                                    color: '#4c1864'
                                },
                                id: 'income',
                            },
                            enroll: {
                                beginAtZero: true,
                                grid: {
                                    drawOnChartArea: true
                                },
                                type: 'linear',
                                position: 'right',
                                title: {
                                    display: true,
                                    text: 'New People Enroll',
                                    font: {
                                        size: 18
                                    },
                                    color: '#f7b205'
                                },
                                id: 'enroll'
                            }
                        }
                    }
                });
            </script>
            <script src="../assets/js/sort.js">
            </script>
    </body>
</html>
