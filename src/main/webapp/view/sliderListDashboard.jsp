<%-- 
    Document   : sliderListDashborad
    Created on : Feb 6, 2024, 9:24:23 AM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
    <head>
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
            .right-sider {
                margin-left: 250px;
                position: relative;
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
            #pagee {
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 10px;
                background-color: #f2f2f2;
            }

            #pagee a {
                color: #333;
                padding: 8px 12px;
                margin: 0 5px; /* Khoảng cách giữa các số */
                text-decoration: none;
                border: 1px solid #ddd;
                border-radius: 4px;
                display: inline-block;
                cursor: pointer;
            }

            #pagee a span {
                display: inline-block;
            }

            #pagee a:hover {
                background-color: #ddd;
            }
            .infor-slider{
                width:800px;
                height:300px;
                overflow:hidden;
                border: 5px solid #fff;
                box-shadow:0 0 15px 0 rgba(0,0,0,0.2);
                margin:25px auto 15px;
            }
            .infor{
                width:800px;
                height:500px;
                overflow:hidden;
                margin:25px auto 15px;
            }
            .form-control {
                width: 100%;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                margin-top: 4px;
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
            .content-right{
                display: flex;
                padding: 10px;
                margin: 20px;
            }
            select {
                padding: 10px 40px 10px 10px; /* Khoảng cách giữa các phần tử trong select, 30px là khoảng cách cho mũi tên */
                font-size: 16px; /* Kích thước chữ */
                border: 1px solid #ccc; /* Đường viền */
                border-radius: 5px; /* Góc cong */
                appearance: none; /* Loại bỏ giao diện mặc định của trình duyệt */
                background-image: url('https://cdn.jsdelivr.net/gh/stephenhutchings/typicons.font@v2.0.7/src/svg/arrow-sorted-down.svg'); /* Hình ảnh mũi tên */
                background-repeat: no-repeat; /* Không lặp lại hình ảnh */
                background-position: right 10px center; /* Vị trí của hình ảnh */
            }


            /* Focus effect */
            select:focus {
                border-color: #333; /* Màu viền khi focus */
                outline: none; /* Loại bỏ đường viền xung quanh */
            }

            /* Active effect */
            select:active {
                border-color: #555; /* Màu viền khi click */
            }

            .left{
                padding: 0 0 0 20px;
                margin: 0 0 0 30px;
            }

            .listEnrollTable td{
                padding: 3px 8px;
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
            li a {
                padding-left: 0;
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
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
        <link rel="icon" href="../assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="../assets/images/favicon.png" />
        <link rel="stylesheet" type="text/css" href="../assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="../assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="../assets/css/color/color-1.css">
        <link href="../assets/css/short.css" rel="stylesheet" type="text/css"/>
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
                        <span class="material-symbols-outlined">tv</span><a href="report">Dashboard</a>
                    </li>
                    <li onclick="goTo('userList')"class="list-item" style=" margin-top: -30px;"  onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">person</span><a>Users</a></li>

                    <li onclick="goTo('post')"  class="list-item" style=" margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">post_add</span><a>Posts</a>
                    </li>
                    <li class="list-item" style="background-color: #f7b205;margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">sliders</span><a>Sliders</a>
                    </li>
                    <li onclick="goTo('enrollmentlist')" class="list-item" style="margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">how_to_reg</span><a href="enrollmentlist">Enrollment</a></li>
                </ul>
            </div>
        </div>
        <div class="right-sider">
            <div class="header" style="height: 10vh">
                <div class="title"><span>SLIDER</span></div>
                <div class="info" style="margin: 0 0 0 30px">
                    <div class="img-info">
                        <span><img style="width: 40px;height: 40px" src="${sessionScope.user.img}"
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
            <div class="content-right">
                <div class="right" style="width: 700px">
                    <div class="content-right"style="width: 100%">
                        <form action="slider" method="get" style="margin: 0 0 -30px -30px;">
                            <table class="listEnrollTable">
                                <tbody>
                                    <tr>
                                        <td><label for="searchInput">Search input:</label></td>
                                        <td><input type="text" id="searchInput" name="searchInput" placeholder="Input..." value="${requestScope.searchInput}"></td>
                                    </tr>
                                    <tr>
                                        <td><label for="date_from">From:</label></td>
                                        <td><input type="date" id="timeFrom" name="timeFrom" value="${requestScope.timeFrom}"></td>
                                    </tr>
                                    <tr>
                                        <td><label for="date_to">To:</label></td>
                                        <td style="display:flex;" ><input type="date" id="timeTo" name="timeTo" value="${requestScope.timeTo}">
                                            <span style="margin-left: 5%;">
                                                <button type="submit" style="color:white; background-color: black;margin-bottom: 11px;
                                                        height: 30px; margin:0 0 0 13px; padding: 0px 5px;" class="fa fa-search text-primary"></button>
                                            </span>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                        <form action="slider?action=add" method="get">
                            <input type="hidden" name="action" value="add" />
                            <button type="submit" class="btn" style="width: 200px;margin: 0 0 0 155px">Add new slider</button>
                        </form>
                    </div>
                    <div style="color: green" id="mess">${requestScope.mess}</div>
                    <c:choose>
                        <c:when test="${fn:length(requestScope.sliderDtos) > 0}">
                            <table border="1" class="table-sortable">
                                <thead class="table-active" style="height: 50px;">
                                    <tr style="text-align: center">
                                        <th>NO</th>
                                        <th style="width: 150px">Title</th>
                                        <th style="width: 150px">Description</th>
                                        <th style="width: 150px">Created Time</th>
                                        <th>Status</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach  items="${requestScope.sliderDtos}" var="s" varStatus="loop">
                                        <tr>
                                            <td style="text-align: center">${loop.index + 1}</td>
                                            <td>${s.title}</td>
                                            <td>${s.description}</td>
                                            <td>${s.createdTime}</td>
                                            <c:if test="${s.status eq 1}">
                                                <td style="text-align: center;color: green">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                                                    <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8M1.173 8a13 13 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5s3.879 1.168 5.168 2.457A13 13 0 0 1 14.828 8q-.086.13-.195.288c-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5s-3.879-1.168-5.168-2.457A13 13 0 0 1 1.172 8z"/>
                                                    <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5M4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0"/>
                                                    </svg>
                                                </td>
                                            </c:if>
                                            <c:if test="${s.status eq 0}">
                                                <td style="text-align: center;color: red">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye-slash" viewBox="0 0 16 16">
                                                    <path d="M13.359 11.238C15.06 9.72 16 8 16 8s-3-5.5-8-5.5a7 7 0 0 0-2.79.588l.77.771A6 6 0 0 1 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13 13 0 0 1 14.828 8q-.086.13-.195.288c-.335.48-.83 1.12-1.465 1.755q-.247.248-.517.486z"/>
                                                    <path d="M11.297 9.176a3.5 3.5 0 0 0-4.474-4.474l.823.823a2.5 2.5 0 0 1 2.829 2.829zm-2.943 1.299.822.822a3.5 3.5 0 0 1-4.474-4.474l.823.823a2.5 2.5 0 0 0 2.829 2.829"/>
                                                    <path d="M3.35 5.47q-.27.24-.518.487A13 13 0 0 0 1.172 8l.195.288c.335.48.83 1.12 1.465 1.755C4.121 11.332 5.881 12.5 8 12.5c.716 0 1.39-.133 2.02-.36l.77.772A7 7 0 0 1 8 13.5C3 13.5 0 8 0 8s.939-1.721 2.641-3.238l.708.709zm10.296 8.884-12-12 .708-.708 12 12z"/>
                                                    </svg>
                                                </td>
                                            </c:if>
                                            <td>
                                                <div style="display: flex;align-items: center;justify-content: center">
                                                    <form action="slider?action=edit" method="get" >
                                                        <input type="hidden" name="action" value="edit" />
                                                        <input type="hidden" name="id" value="${s.sliderId}" />
                                                        <input type="hidden" name="pageIndex" value="${requestScope.pageIndex}">
                                                        <input type="hidden" name="searchInput" value="${requestScope.searchInput}">
                                                        <input type="hidden" name="timeFrom" value="${requestScope.timeFrom}">
                                                        <input type="hidden" name="timeTo" value="${requestScope.timeTo}">
                                                        <button type="submit" style="width: 100%;border: none;background-color: #ffffff"value="edit">
                                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                                            <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                                            <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                                                            </svg>
                                                        </button>
                                                    </form>
                                                    <form action="slider?action=delete" method="post" onsubmit="return confirmSubmit()">
                                                        <input type="hidden" name="id" value="${s.sliderId}" />
                                                        <input type="hidden" name="pageIndex" value="${requestScope.pageIndex}">
                                                        <input type="hidden" name="searchInput" value="${requestScope.searchInput}">
                                                        <input type="hidden" name="timeFrom" value="${requestScope.timeFrom}">
                                                        <input type="hidden" name="timeTo" value="${requestScope.timeTo}">
                                                        <button type="submit" style="width: 100%;border: none;background-color: #ffffff;margin-left: 10px"value="delete"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                                            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                                            <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                                            </svg>
                                                        </button>
                                                    </form>
                                                </div>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div id="pagee"></div>
                        </c:when>
                        <c:otherwise>
                            <div class="img_not_found" style="margin: 0 0 0 160px">
                                <img src="../assets/images/404.2 (1).png" alt=""/>

                            </div>
                            <h3 class="not_found" style="margin: 0 0 0 85px">   No slider found matching this keyword !</h3>
                        </c:otherwise>
                    </c:choose>
                </div>
                <c:if test="${not empty requestScope.sliderDTO}">
                    <div class="left"style="width: 800px">
                        <form action="slider?action=edit" method="post" enctype="multipart/form-data" id="sliderdetail">
                            <input type="hidden" name="sliderId" value="${sliderDTO.sliderId}">

                            <div class="infor-slider" style="width: 700px">
                                <img src="${requestScope.sliderDTO.img}" alt="" id="imagePreview" onclick="triggerFileInput()"/>
                                <input type="file" name="imageFile" accept="image/*" style="display: none" id="uploadInput" onchange="uploadImage(event)">
                            </div>
                            <div class="infor">
                                <div class="form-group" style="margin: 0 0 20px 40px">
                                    Title: <input type="text"  value="${requestScope.sliderDTO.title}" id="title" name="title" style="width: 114%" placeholder="Input your title" onclick="hideError()" class="form-control">
                                </div>
                                <div class="form-group"style="margin: 0 0 20px 40px">
                                    Description: <input type="text" value="${requestScope.sliderDTO.description}" id="description" style="width: 114%"name="description" placeholder="Input your description" onclick="hideError()"  class="form-control">
                                </div>
                                <div class="form-group radio-group"style="margin: 0 0 0 40px">
                                    Status:
                                    <input style="margin: 0 0 0 15px" type="radio" id="show" ${requestScope.sliderDTO.status eq 1 ? 'checked' : ''} name="status" value="1">
                                    Show
                                    <input style="margin: 0 0 0 15px"type="radio" id="hide" ${requestScope.sliderDTO.status eq 0 ? 'checked' : ''} name="status" value="0">
                                    Hide
                                </div>
                                <div class="form-group"style="margin: 0 0 20px 40px">
                                    Post title: <select style="margin: 15px 0 0 15px"name="postId">
                                        <c:forEach  items="${requestScope.postDTOs}" var="p">
                                            <option value="${p.postId}" ${sliderDTO.post.postId eq p.postId ? 'selected':''}> ${p.title}</option>
                                        </c:forEach>
                                    </select>
                                    <button type="button" style="margin: 20px 0 0 460px;width: 60%;padding: 20px 0 20px 0" class="btn" onclick="sendForm()">Save</button>
                                </div>
                                <div id="error" style="color:red;"></div>
                                <input type="hidden" value="${requestScope.sliderDTO.img}" name="data">
                            </div>
                        </form>
                    </div>
                </c:if>
            </div>
        </div>
        <script>
            function goTo(url) {
                window.location = url;
            }
            function hideMess() {
                document.getElementById('mess').style.display = 'none';
            }
            setTimeout('hideMess()', 3000);
            function confirmSubmit() {
                var confirmed = confirm("Are you sure you want to delete this slider?");
                if (confirmed) {
                    document.querySelector("form").submit();
                    return true; // Nếu người dùng xác nhận, cho phép form được gửi đi
                } else {
                    return false; // Nếu người dùng hủy bỏ, chặn sự kiện mặc định của form
                }
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
            function sendForm() {
                var error = '';
                const title = document.getElementById('title').value;
                const description = document.getElementById('description').value;
                if (title.length === 0) {
                    error = 'Title is invalid. Please try again';
                    document.getElementById('error').textContent = error;
                    document.getElementById('error').style.display = 'block';
                } else if (description.length === 0) {
                    error = 'Description is invalid. Please try again';
                    document.getElementById('error').textContent = error;
                    document.getElementById('error').style.display = 'block';
                } else {
                    var form = document.getElementById('sliderdetail');
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
            // Hàm để mở input file khi nhấn vào ảnh
            function triggerFileInput() {
                document.getElementById('uploadInput').click();
            }

            // Hàm để xử lý sự kiện khi người dùng chọn file
            function uploadImage(event) {
                var input = event.target;
                var preview = document.getElementById('imagePreview');

                // Kiểm tra xem người dùng đã chọn file chưa
                if (input.files && input.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function (e) {
                        // Hiển thị ảnh đã chọn
                        preview.src = e.target.result;
                    };

                    // Đọc file ảnh
                    reader.readAsDataURL(input.files[0]);
                }
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
            render('pagee',${requestScope.pageIndex},${requestScope.numberOfPageSlider}, 2, '${requestScope.searchInput}', '${requestScope.timeFrom}', '${requestScope.timeTo}');
            function render(id, pageindex, totalpage, gap, searchInput, timeFrom, timeTo) {
                var container = document.getElementById(id);
                if (pageindex - gap > 1)
                    container.innerHTML += '<a href="slider?searchInput=' + searchInput + '&timeFrom=' + timeFrom + '&timeTo=' + timeTo + '&pageIndex=1">First</a> ';

                for (var i = pageindex - gap; i < pageindex; i++)
                    if (i > 0)
                        container.innerHTML += ' <a href="slider?searchInput=' + searchInput + '&timeFrom=' + timeFrom + '&timeTo=' + timeTo + '&pageIndex=' + i + '">' + i + '</a>';

                container.innerHTML += '<span>' + pageindex + '</span>';

                for (var i = pageindex + 1; i <= pageindex + gap && i <= totalpage; i++)
                    container.innerHTML += '  <a href="slider?searchInput=' + searchInput + '&timeFrom=' + timeFrom + '&timeTo=' + timeTo + '&pageIndex=' + i + '">' + i + '</a>';

                if (pageindex + gap < totalpage)
                    container.innerHTML += ' <a href="slider?searchInput=' + searchInput + '&timeFrom=' + timeFrom + '&timeTo=' + timeTo + '&pageIndex=' + totalpage + '">Last</a>';
            }
        </script>
        <script src="../assets/js/sort.js" type="text/javascript"></script>

    </body>
</html>
