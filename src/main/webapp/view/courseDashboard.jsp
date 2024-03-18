<%-- 
    Document   : courseDashboard
    Created on : Feb 5, 2024, 9:34:27 PM
    Author     : tran Hoang Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
        <link rel="icon" href="../assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="../assets/images/favicon.png" />
        <link rel="stylesheet" type="text/css" href="../assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/typography.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/shortcodess/shortcodes.css">
        <link rel="stylesheet" type="text/css" href="../assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="../assets/css/color/color-1.css">
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
                background-color: #6a6ce4;
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

            .arrow {
                font-size: 20px;
                padding: 10px;
                cursor: pointer;
            }

            .dropdown-list {
                display: none;
                position: absolute;
                top: 55px;
                right: 20px;
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

            li a {
                text-decoration: none;
                color: black;
                padding-left: 10px;
            }
            .info {
                display: flex;
                align-items: center;
            }

            .img-info img {
                width: 50px;
                height: 50px;
                border-radius: 50%;
            }

            .name {
                margin-left: 10px;
            }
            .course-list {
                width: 55%;
            }
            .search td {
                padding: 3px 5px 0px 0px;
                margin-left: 2px;
            }
            .course-list {
                margin-left: 2%;
            }
            .search {
                margin: 10;
            }
            .content {
                margin-top: 3%;
            }
            .toggle {
                position : relative ;
                display : inline-block;
                width : 35px;
                height : 19px;
                background-color: #878787;
                border-radius: 30px;
                border: 1px solid white;
            }

            /* After slide changes */
            .toggle:after {
                content: '';
                position: absolute;
                width: 22px;
                height: 22px;
                border-radius: 50%;
                background-color: white;
                top: -3px;
                left: -1px;
                transition:  all 0.1s;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
            }
            p {
                font-family: Arial, Helvetica, sans-serif;
                font-weight: bold;
            }

            /* Checkbox checked effect */
            .checkbox:checked + .toggle::after {
                left : 15px;
            }

            /* Checkbox checked toggle label bg color */
            .checkbox:checked + .toggle {
                background: linear-gradient(45deg, rgba(76, 24, 100, 0.85) 0%, rgba(63, 24, 154, 0.85) 100%);
            }

            /* Checkbox vanished */
            .checkbox {
                display : none;
            }

            #paggerbot {
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 10px;
                background-color: #f2f2f2;
            }

            #paggerbot a {
                color: #333;
                padding: 8px 12px;
                margin: 0 5px; /* Khoảng cách giữa các số */
                text-decoration: none;
                border: 1px solid #ddd;
                border-radius: 4px;
                display: inline-block;
                cursor: pointer;
            }

            #paggerbot a span {
                display: inline-block;
            }

            #paggerbot a:hover {
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

            #choose {
                background-color: rgba(229, 229, 229, 0.5);
            }
            .content {
                display:flex;
            }
            .course-detail {
                margin-left: 40px;
            }
            .course-introduction {
                margin-top: 0px;
                width: 100%;
                position: relative;
                right: 0;
                display: flex;
            }
            .teacher-bx {
                margin-right: 50px;
                border: none;
            }
            .course-img img {
                width: 800px;
            }
            .course-review {
                width: 50%;
                margin-top: 15px;
            }
            .teacher-thumb img {
                width: 50px;
                height: 50px;
                margin-right: 30px;
                border-radius: 50%;
            }

            .teacher-info {
                display: flex;
                align-items: center;
                justify-content: center;
                margin-top: 30px;
                border-top: 1px solid rgba(0, 0, 0, 0.1);
                border-bottom: 1px solid rgba(0, 0, 0, 0.1);
                padding: 10px 0px;
            }
            .detail-course {
                margin-left: 40px;
                width: 100%;
            }
            .course-title-detail {
                display: flex;
                position: relative;
            }
            .btn-view {
                position: absolute;
                right: 0;
            }
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
            .right-sider {
                margin-left: 250px;
                position: relative;
            }

            .right-sider .header {
                display: flex;
                background: linear-gradient(45deg, rgba(76, 24, 100, 0.85) 0%, rgba(63, 24, 154, 0.85) 100%);
                height: 9vh;
            }

            .img-info img {
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
        </style>
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



            .leftPage, .rightPage {
                width: 37%;
                float: left;
                box-sizing: border-box;
            }

            .leftPage{
                margin-left: 2%;
                width: 55%;
            }

            .rightPage{
                margin-left: 3%;
            }

            #choose {
                background-color: rgba(229, 229, 229, 0.5);
            }

            .toggle {
                position : relative ;
                display : inline-block;
                width : 35px;
                height : 19px;
                background-color: #878787;
                border-radius: 30px;
                border: 1px solid white;
            }

            /* After slide changes */
            .toggle:after {
                content: '';
                position: absolute;
                width: 22px;
                height: 22px;
                border-radius: 50%;
                background-color: white;
                top: -3px;
                left: -1px;
                transition:  all 0.1s;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
            }
            p {
                font-family: Arial, Helvetica, sans-serif;
                font-weight: bold;
            }

            /* Checkbox checked effect */
            .checkbox:checked + .toggle::after {
                left : 15px;
            }

            /* Checkbox checked toggle label bg color */
            .checkbox:checked + .toggle {
                background: linear-gradient(45deg, rgba(76, 24, 100, 0.85) 0%, rgba(63, 24, 154, 0.85) 100%);
            }

            /* Checkbox vanished */
            .checkbox {
                display : none;
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



            .header .info {
                display: flex;
                position: absolute;
                right: 30px;
                top: 20px;
                color: white;
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
            li a {
                padding-left:0px;
            }

            .img-info img {
                width: 40px;
                height: 40px;
                border-radius: 50%;
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
                    <li style="background-color: #f7b205; margin-top: -200px;" class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                        <span class="material-symbols-outlined">book</span><a>Courses</a>
                    </li>
                    <li onclick="goTo('blogs')" class="list-item" style="margin-top: -520px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">person</span><a>Blogs</a></li>
                </ul>

            </div>
        </div>
        <div class="right-sider">
            <div class="header" style="height: 10vh">
                <div class="title"><span>COURSE</span></div>
                <div class="info">
                    <div class="img-info">
                        <span><img src="${sessionScope.user.img}"
                                   alt="logo">
                        </span>
                    </div>
                    <div class="name">
                        <span>${sessionScope.user.name}</span>
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
                <div class="course-list">
                    <form action="course" method="get">
                        <table class="search">
                            <tr>
                                <td>Information:</td>
                                <td><input type="text" name="info" value="${requestScope.info}"></td>
                                <td>Level: </td>
                                <td>
                                    <select name="level">
                                        <option value="0" >All level</option>
                                        <c:forEach items="${requestScope.levelList}" var="l">
                                            <option value="${l.levelId}" ${requestScope.level eq l.levelId ? "selected":""}>${l.name}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td>Duration: </td>
                                <td>
                                    <select name="duration">
                                        <option value="0" ${requestScopes.duration eq 0  ? "selected":""}>All duration</option>
                                        <c:forEach items="${requestScope.durationList}" var="d">
                                            <option value="${d.durationId}" ${requestScope.duration eq d.durationId ? "selected":""}>${d.name}</option>
                                        </c:forEach>
                                    </select>
                                </td>

                            </tr>
                            <tr>
                                <td>Category:</td>
                                <td>
                                    <select name="category">
                                        <option value="0" ${requestScopes.category eq 0 or requestScopes.category eq null ? "selected":""}>All category</option>
                                        <c:forEach items="${requestScope.cate}" var="c">
                                            <option value="${c.courseCategoryId}" ${requestScope.category eq c.courseCategoryId ? "selected":""}>${c.name}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td>Language:</td>
                                <td style="display: flex;">
                                    <select name="language">
                                        <option value="0" ${param.language eq 0 or param.language eq null ? "selected":""}>All language</option>
                                        <c:forEach items="${requestScope.languageList}" var="la">
                                            <option value="${la.languageId}" ${requestScope.language eq la.languageId ? "selected":""}>${la.name}</option>
                                        </c:forEach>
                                    </select>
                                    <span style="margin-left: 75%;">
                                        <button type="submit" style="color:white; background-color: black;margin-bottom: 0px;
                                                height: 30px; margin-left: 2%; padding: 0px 5px;" class="fa fa-search text-primary"></button>
                                    </span>
                                </td>
                            </tr>
                        </table>
                    </form>
                    <div class="courses">
                        <c:if test="${requestScope.course ne null and requestScope.course.size() > 0}"> 
                            <table border="1" class="table-sortable">
                                <thead>
                                    <tr style="background-color: #f2f2f2;">
                                        <th>#</th>
                                        <th>Course name</th>
                                        <th>Category</th>
                                        <th>Duration</th>
                                        <th>Language</th>
                                        <th>Level</th>
                                            <c:if test="${sessionScope.session.role.roleId eq 4}">
                                            <th>Author</th>
                                            <th>Status</th>
                                            </c:if>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.course}" var="c" varStatus="loop">
                                        <tr style="cursor: pointer;" ${c.courseId eq requestScope.chosenCourse.courseId?"id=\"choose\"":""}>
                                            <td onclick="chooseCourse(${c.courseId}, '${param.page}', '${param.info}', '${param.level}', '${param.duration}', '${param.category}', '${param.languagge}')">${loop.count}</td>
                                            <td onclick="chooseCourse(${c.courseId}, '${param.page}', '${param.info}', '${param.level}', '${param.duration}', '${param.category}', '${param.languagge}')">${c.name}</td>
                                            <td onclick="chooseCourse(${c.courseId}, '${param.page}', '${param.info}', '${param.level}', '${param.duration}', '${param.category}', '${param.languagge}')">${c.category.name}</td>
                                            <td onclick="chooseCourse(${c.courseId}, '${param.page}', '${param.info}', '${param.level}', '${param.duration}', '${param.category}', '${param.languagge}')">${c.duration.name}</td>
                                            <td onclick="chooseCourse(${c.courseId}, '${param.page}', '${param.info}', '${param.level}', '${param.duration}', '${param.category}', '${param.languagge}')">${c.language.name}</td>
                                            <td onclick="chooseCourse(${c.courseId}, '${param.page}', '${param.info}', '${param.level}', '${param.duration}', '${param.category}', '${param.languagge}')">${c.level.name}</td>
                                            <c:if test="${sessionScope.session.role.roleId eq 4}">
                                                <td onclick="chooseCourse(${c.courseId}, '${param.page}', '${param.info}', '${param.level}', '${param.duration}', '${param.category}', '${param.languagge}')">${c.author.name}</td>
                                                <td>
                                                    <form action="course" method="post" id="form${c.courseId}">
                                                        <input type="hidden" name="info" value="${param.infor}">
                                                        <input type="hidden" name="level" value="${param.level}">
                                                        <input type="hidden" name="duration" value="${param.duration}">
                                                        <input type="hidden" name="page" value="${param.page}">
                                                        <input type="hidden" name="category" value="${param.category}">
                                                        <input type="hidden" name="language" value="${param.language}">
                                                        <input type="hidden" name="courseId" value="${c.courseId}">
                                                        <input type="checkbox" name="courseStatus" value="check"
                                                               id="switch${c.courseId}"
                                                               class="checkbox" ${c.isActivated eq true?"checked" :""} 
                                                               onchange="changeStatus('form${c.courseId}')" />
                                                        <label for="switch${c.courseId}"
                                                               class="toggle">
                                                        </label>
                                                    </form>

                                                </td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div id="paggerbot"></div>
                        </c:if>
                    </div>
                </div>
                <c:if test="${requestScope.chosenCourse ne null}">
                    <div style="width: 40%;">
                        <div>
                            <div class="course-detail">
                                <div class="course-introduction">
                                    <div class="teacher-bx">
                                        <div class="teacher-info">
                                            <div class="teacher-thumb">
                                                <img src="${requestScope.chosenCourse.author.img}" alt />
                                            </div>
                                            <div class="teacher-name">
                                                <h5>${requestScope.chosenCourse.author.name}</h5>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="course-review">
                                        <h4>Course overview</h4>
                                        <ul class="course-features">
                                            <li><i class="ti-stats-up"></i> <span class="label">Skill
                                                    level</span> <span class="value">${requestScope.chosenCourse.level.name}</span></li>
                                            <li><i class="ti-smallcap"></i> <span class="label">Language</span> <span class="value">${requestScope.chosenCourse.language.name}</span></li>
                                            <li><i class="ti-book"></i> <span class="label">Category</span> <span class="value">${requestScope.chosenCourse.category.name}</span></li>
                                            <li><i class="ti-time"></i> <span class="label">Duration</span><span class="value">${requestScope.chosenCourse.duration.name}</span></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="detail-course">
                            <div class="course-title-detail">
                                <h3 class="name">
                                    ${requestScope.chosenCourse.name}
                                </h3>
                                <div class="btn-view">
                                    <c:if test="${sessionScope.session.role.roleId eq 4}">
                                        <form action="coursecontent" method="get">
                                            <input type="hidden" name="courseId" value="${requestScope.chosenCourse.courseId}">
                                            <button class="btn" type="submit">View lessons</button>
                                        </form>
                                    </c:if>
                                    <c:if test="${sessionScope.session.role.roleId eq 2}">
                                        <form action="editcourse" method="get">
                                            <input type="hidden" name="courseId" value="${requestScope.chosenCourse.courseId}">
                                            <button class="btn" type="submit">Edit course</button>
                                        </form>
                                    </c:if>
                                </div>
                            </div>
                            <div style="text-align: justify;">
                                <span>${requestScope.chosenCourse.description}</span>
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>

        </div>

        <script>
            function goTo(url) {
                window.location = url;
            }
            function chooseCourse(courseId, page, info, level, duration, category, language) {
                window.location = 'coursedetail?courseId=' + courseId + '&page=' + page + '&info=' + info + '&level=' + level + '&duration=' + duration + '&category=' + category + '&language=' + language;
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
            render('paggerbot', ${requestScope.page}, ${requestScope.totalPage}, 2, '${requestScope.info}', '${requestScope.level}', '${requestScope.duration}', '${requestScope.category}', '${requestScope.language}');
            function render(id, page, totalPage, gap, info, level, duration, category, language) {
                var container = document.getElementById(id);
                if (page - gap > 1) {
                    container.innerHTML += '<a href="course?page=1' + '&info=' + info + '&level=' + level + '&duration=' + duration + '&category=' + category + '&language=' + language + '">First</a> ';
                }
                for (var i = page - gap; i < page; i++) {
                    if (i > 0) {
                        container.innerHTML += '<a href="course?page=' + i + '&info=' + info + '&level=' + level + '&duration=' + duration + '&category=' + category + '&language=' + language + '">' + i + '</a> ';
                    }
                }
                container.innerHTML += '<span>' + page + '</span>';
                for (var i = page + 1; i <= page + gap && i <= totalPage; i++) {
                    container.innerHTML += '<a href="course?page=' + i + '&info=' + info + '&level=' + level + '&duration=' + duration + '&category=' + category + '&language=' + language + '">' + i + '</a> ';
                }
                if (page + gap < totalPage) {
                    container.innerHTML += '<a href="course?page=' + totalPage + '&info=' + info + '&level=' + level + '&duration=' + duration + '&category=' + category + '&language=' + language + '">Last</a> ';
                }
            }

            function changeStatus(courseId) {
                document.getElementById(courseId).submit();
            }
        </script>
        <script src="../assets/js/sort.js"></script>
    </body>
</html>
