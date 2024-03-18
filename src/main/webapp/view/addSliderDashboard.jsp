<%-- 
    Document   : addSliderDashboard
    Created on : Feb 6, 2024, 4:23:46 PM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <script src="https://cdn.tiny.cloud/1/o26m93ytnqs81i154itfeifyl1xyfpelfuho2wv2lv4j9q19/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>

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
            select {
                width: 100%;
                padding: 10px;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: #f9f9f9;
                outline: none;
                transition: border-color 0.3s;
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
                margin-right: 100px;
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
                <div class="title"><a href="slider"><i class="ti-angle-left" style="margin-right: 4px;color: white"></i></a><span>SLIDER</span></div>
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
            <form action="slider?action=add" method="post" enctype="multipart/form-data" id="addslider" >
                <div class="infor-slider"style="width: 50%;">
                    <img style="margin: 0 0 0 170px" src="../assets/images/anh_1.jpg" alt="" id="imagePreview" onclick="triggerFileInput()"/>
                    <input type="file" name="imageFile" accept="image/*" style="display: none" id="uploadInput" onchange="uploadImage(event)">
                </div>
                <div class="infor"style="width: 50%">

                    <div class="form-group">
                        Title: <input type="text"  id="title" name="title" placeholder="Input your title..." onclick="hideError()" class="form-control">
                    </div>
                    <div class="form-group">
                        Description: <input type="text"  id="description" name="description" placeholder="Input your description..." onclick="hideError()"  class="form-control">
                    </div>

                    <div class="form-group">
                        Post title: <select name="postId">
                            <c:forEach  items="${requestScope.postDTOs}" var="p">
                                <option value="${p.postId}" > ${p.title}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group radio-group">
                        Status:
                        <input style="margin: 0 0 0 10px" type="radio" id="show" checked name="status" value="1">
                        Show
                        <input style="margin: 0 0 0 10px"type="radio" id="hide" name="status" value="0">
                        Hide
                    </div> 
                    <br>
                    <div id="error" style="color:red;"></div>
                    <input type="hidden" value="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQEBLAEsAAD/4QW+RXhpZgAATU0AKgAAAAgABwEOAAIAAACXAAABbgE7AAIAAAARAAACBodpAAQAAAABAAACGJybAAEAAAEuAAADOJydAAEAAAAiAAAEZpyfAAEAAAEuAAAEiOocAAcAAAEMAAAAYgAAAAAc6gAAAAEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAM0QgSW1hZ2UgaWNvbiBvbiBTcGVlY2ggQnViYmxlLiBQaWN0dXJlLCBqcGcgZmlsZSwgcGhvdG8gaWNvbi4gTW91bnRhaW5zIGFuZCBzdW4uIENhbiBiZSB1c2VkIGZvciBtYW55IHB1cnBvc2VzLiBUcmVuZHkgYW5kIG1vZGVybiB2ZWN0b3IgaW4gM2Qgc3R5bGUuAABTb2ltYSBBbmFzdGFzaWlhAAAAAeocAAcAAAEMAAACKgAAAAAc6gAAAAEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAzAEQAIABJAG0AYQBnAGUAIABpAGMAbwBuACAAbwBuACAAUwBwAGUAZQBjAGgAIABCAHUAYgBiAGwAZQAuACAAUABpAGMAdAB1AHIAZQAsACAAagBwAGcAIABmAGkAbABlACwAIABwAGgAbwB0AG8AIABpAGMAbwBuAC4AIABNAG8AdQBuAHQAYQBpAG4AcwAgAGEAbgBkACAAcwB1AG4ALgAgAEMAYQBuACAAYgBlACAAdQBzAGUAZAAgAGYAbwByACAAbQBhAG4AeQAgAHAAdQByAHAAbwBzAGUAcwAuACAAVAByAGUAbgBkAHkAIABhAG4AZAAgAG0AbwBkAGUAcgBuACAAdgBlAGMAdABvAHIAIABpAG4AIAAzAGQAIABzAHQAeQBsAGUALgAAAFMAbwBpAG0AYQAgAEEAbgBhAHMAdABhAHMAaQBpAGEAAAAzAEQAIABJAG0AYQBnAGUAIABpAGMAbwBuACAAbwBuACAAUwBwAGUAZQBjAGgAIABCAHUAYgBiAGwAZQAuACAAUABpAGMAdAB1AHIAZQAsACAAagBwAGcAIABmAGkAbABlACwAIABwAGgAbwB0AG8AIABpAGMAbwBuAC4AIABNAG8AdQBuAHQAYQBpAG4AcwAgAGEAbgBkACAAcwB1AG4ALgAgAEMAYQBuACAAYgBlACAAdQBzAGUAZAAgAGYAbwByACAAbQBhAG4AeQAgAHAAdQByAHAAbwBzAGUAcwAuACAAVAByAGUAbgBkAHkAIABhAG4AZAAgAG0AbwBkAGUAcgBuACAAdgBlAGMAdABvAHIAIABpAG4AIAAzAGQAIABzAHQAeQBsAGUALgAAAP/hBbdodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvADw/eHBhY2tldCBiZWdpbj0n77u/JyBpZD0nVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkJz8+DQo8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIj48cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPjxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSJ1dWlkOmZhZjViZGQ1LWJhM2QtMTFkYS1hZDMxLWQzM2Q3NTE4MmYxYiIgeG1sbnM6ZGM9Imh0dHA6Ly9wdXJsLm9yZy9kYy9lbGVtZW50cy8xLjEvIi8+PHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9InV1aWQ6ZmFmNWJkZDUtYmEzZC0xMWRhLWFkMzEtZDMzZDc1MTgyZjFiIiB4bWxuczpkYz0iaHR0cDovL3B1cmwub3JnL2RjL2VsZW1lbnRzLzEuMS8iPjxkYzpjcmVhdG9yPjxyZGY6U2VxIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+PHJkZjpsaT5Tb2ltYSBBbmFzdGFzaWlhPC9yZGY6bGk+PC9yZGY6U2VxPg0KCQkJPC9kYzpjcmVhdG9yPjxkYzp0aXRsZT48cmRmOkFsdCB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPjxyZGY6bGkgeG1sOmxhbmc9IngtZGVmYXVsdCI+M0QgSW1hZ2UgaWNvbiBvbiBTcGVlY2ggQnViYmxlLiBQaWN0dXJlLCBqcGcgZmlsZSwgcGhvdG8gaWNvbi4gTW91bnRhaW5zIGFuZCBzdW4uIENhbiBiZSB1c2VkIGZvciBtYW55IHB1cnBvc2VzLiBUcmVuZHkgYW5kIG1vZGVybiB2ZWN0b3IgaW4gM2Qgc3R5bGUuPC9yZGY6bGk+PC9yZGY6QWx0Pg0KCQkJPC9kYzp0aXRsZT48ZGM6ZGVzY3JpcHRpb24+PHJkZjpBbHQgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj48cmRmOmxpIHhtbDpsYW5nPSJ4LWRlZmF1bHQiPjNEIEltYWdlIGljb24gb24gU3BlZWNoIEJ1YmJsZS4gUGljdHVyZSwganBnIGZpbGUsIHBob3RvIGljb24uIE1vdW50YWlucyBhbmQgc3VuLiBDYW4gYmUgdXNlZCBmb3IgbWFueSBwdXJwb3Nlcy4gVHJlbmR5IGFuZCBtb2Rlcm4gdmVjdG9yIGluIDNkIHN0eWxlLjwvcmRmOmxpPjwvcmRmOkFsdD4NCgkJCTwvZGM6ZGVzY3JpcHRpb24+PC9yZGY6RGVzY3JpcHRpb24+PC9yZGY6UkRGPjwveDp4bXBtZXRhPg0KICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIDw/eHBhY2tldCBlbmQ9J3cnPz7/2wBDAAMCAgMCAgMDAwMEAwMEBQgFBQQEBQoHBwYIDAoMDAsKCwsNDhIQDQ4RDgsLEBYQERMUFRUVDA8XGBYUGBIUFRT/2wBDAQMEBAUEBQkFBQkUDQsNFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBQUFBT/wAARCAEAAaADASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD9U6KKKACiiigAooooAKKKKACiiigAooooASmvIkalnYKo6ljiq99eizUcb5W+6n+PtWb9mkvG33Dbz1C/wj6CtYwvq9EZylbRbl2TWrVMgM0h/wBlT/Oo/wC37f8A55y/98D/ABpFsVAxtxS/Yl9K15aZF5h/b1v/AM85v++R/jR/b1v/AM85v++R/jR9iX+6KT7CP7op2pdg9/uL/b1v/wA85v8Avkf40f29b/8APOb/AL5H+NH2Nf7tJ9iH92jlpdhfvBf7et/+ec3/AHyP8aP7et/+ec3/AHyP8aT7CP7oo+xD+7Ry0uwXqC/29b/885v++R/jR/b1v/zzm/75H+NJ9jX0FH2Ef3RRy0uwfvBf7et/+ec3/fI/xo/t63/55zf98j/Gj7Ev90UfYV/u0Wpdh+/3D+3rf/nnN/3yP8aP7et/+ec3/fI/xpPsQ/u0fYh6CjlpdhfvBf7et/8AnnN/3yP8aP7et/8AnnN/3yP8aT7CP7opfsK/3aLUuwfvO4f29b/885v++R/jSf29b/8APOb/AL5H+NL9hX+7R9hX+7Ral2D94H9vW/8Azzm/75H+NH9vW/8Azzm/75H+NH2Ff7tH2Ff7tFqXYfv9w/t63/55zf8AfI/xo/t+3/55y/8AfI/xo+xr6Un2Ef3RRal2D3+4f8JBb/8APOX/AL5H+NPj16zYhTI0R/21IH51DJZr/dqjdWK7T8vFNU6UieaaOjjlSVQyOrqejKcinVw3nXGlymW2cp6qfut9RXTaLrUWswEr+7mTiSM9V9/oamph5U1zLVFwqqTs9zUooorlNgooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKazqilicKoyTTqz9akMemygcFsL+ZGf0zVRXNJIUnZXKFvIby4a4fq33R6L2FacXC5rNsR+7FX1+7XVU3sjnhtck8wUnm1EzVE0lZqJdyz51HnVV8yjzKrlFzFrzqPOqr5lHmUcocxa86jzfeqvmUeZRyhzFrzfejzfeqvmUeZRyhzFrzfejzqq+ZR5lHKHMWvN96PN96q+ZR5lHKHMWvN96PN96q+ZR5lHKHMWvN96PN96q+ZR5lHKHMWvOpfOFVPMPrS+Z70co+YtecKPOFVfM96PM96OUOYneSq08nFDPVeZvlqox1JcjPvsFTWAt9JoupRXkWcKcSKP4l7j/PfFbl23ymud1P5lIr2MPHm917M4qjtqj1KKZJ4kkjbcjqGVh3B70+sDwTcG48NWmTlo90f4BiAPyxW/Xz9SHs5yh2Z6UJc0VLuFFFFZlhRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABWZr/APx4f8DX+dadZviD/jw/4Gta0v4kSKnwsp2f+rFXe1UrP/Vir3YVvU3MIbETVC9TNUMlOI2NzRmkoqyRc0ZpKKAFzRmkooAXNGaSigBc0ZpKKAFzRmkoZgq7mIVfU8CgBc0ZpqyKwyrBh6g5paAFzRmkooAXNGaSigBc0ZNJRQAVDN0qaoZulNbiZmXn3TXPakflNdDefdP0rntS+6a9bD7nHUOx+Huf+EdX/rs/866euY+Hv/Iur/12f+ddPXhYr+PP1PSo/wAOIUUUVymwUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAVma//wAeH/A1/nWnWZr3/IPH++v861pfxIkT+FlWz/1a1d/hFUrP/VrV3+EVvPcxhsRNUMlTtUElOIMZRRRVkhRRRQAUUUUAFFFFABRRVDXtQOk6Pd3S/fjQ7P8AePA/UisK9aGHpTrVPhim36LVlwi6klCO7MbxB4pljunsNNK+cpxLcEZEZ/uqO5+vA9+3NS6Yt3J5t3I91Kf4pmLn9aNPUQ2wycu3JY9ST1qWS421/M2bZxiM2qOripe70j0S9Or7vd+mh9XTprD+5R+/q/67FVtLjtWMls720nZ4WKn8xWxoHjKe3uo7LU3EgchY7npz2DY/Qj/69Ydxe4zzWHqVwJVINcuWZ3WyisqmFlZdY/Za81+u6Ov6t9bjyVtfPqj3FWDLkdKWub8C6w2raHbvI26ULsY+pBwT+OM/jXSV/UWHrwxVGGIp/DNKS9Gro+KqQdOcqct07fcFFFFdBmFFFFABUM3Spqhm6U1uJ7GZefdP0rntR+6a6G8+6fpXPaj90162HOOqdl8Pf+RdX/rs/wDOumrmfh7/AMi6v/XZ/wCddNXhYr+PP1PSo/w4hRRRXKbBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABWZr3/IPH++v8606zPEH/AB4/8DX+da0v4kSKnwsq2f8Aq1q6Pu1Ss/8AVrV0fdree5jDYjaoJKsNVeSiIMZRRRWhIUUUUAFFFH86ACiiigArC8cRtJ4XvdoyVCyH6K6sf0FbtR3ECXEEkUi7kdSrKehB4P6Vw47DfXMLVw17c8ZR+9NG1Gp7KrGp2af3HlcN4PJX6CoZrv3qtrFjP4bvmtJgTGcmGU9HX/EcZrOlvPev5Kx1KthpyoV48s46Nf1+Hfc+/p0o1LThqnsWLi53ZrLupt3elmufem2FjNrF4tvCDkkFn7IPU15uFw9bFVo0KMXKcnZJdWegoxoxc5uyR6V8LY2XRUJ6O7sPpk/4V3dZHhzS102xjjVdqqoUD2ArXr+yMDhfqODo4S9/ZxjG/dpJNn5jXq+3qzq/zNv72FFFFdpgFFFFABUM3Spqhm6U1uJ7GZefdP0rntR+6a6G8+6fpXPaj90162H3OOodl8Pf+RdX/rs/866auZ+Hv/Iuj/rs/wDOumrwsV/Hn6npUf4cQooorlNgooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigArM8Qf8eP/A1/nWnWZ4g/48P+BrWtL+JEzqfCyrZ/6tavD7tUbP8A1a1eX7tbz3MobEb1Xkqw1V3oiDGUUUVoSFFFFABXKfELx1H4J06Dy4VvNSuiVtrdjhcAcu3+yMjgdSR9R0t7ewabZz3d1KsNtAhklkboqgZJr571DVpvGGvXWt3Ssgk+S3hb/llCCdq/XufdjXoYPDqvPmn8K/HyPIzLGfVafLB+89vLzLjfFfxpZy/aZZrG4izlrU2oVMegIO78ST+NeueCfGlr400eO9gUwyZ2SwMQWicYypOOexB7gg8V4VftuUiofAvi4+CPFSSSybdNvCIbnnhDn5ZPwJ59mPtXs18FCtTbpxtJdj5/BZlUp1lGtO8X36eZ9O0VHbzCaMMOakr5bY+3KGsaLa61atBdRLKh/vdvcHsffrXA6j8K3WQm0vXRM52ypvP5givTaK8XMMly7NLPG0VNrrqn96advK9jsw+MxGF/gzt+K+5nlNt8LJmkH2i7Zl/uxptP5kmu10HwnbaPGqxRqgHXvn/E10NFPLsly3KW5YKgoN9dW/vk2/xDEYzEYrStO67bL7loCqFGB0ooor2TjCiiigAooooAKhm6VNUM3SmtxPYzLz7p+lc9qP3TXQ3n3T9K57UfumvWw+5x1Tsfh7/yLg/67P8Azrp65n4e/wDIur/12f8AnXTV4WK/jz9T0qP8OIUUUVymwUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAVmeIP8AkH/8DWtOszxB/wAeH/A1rWl/EiZ1PhZVs/8AVrV5fu1Rs/8AVrV4fdrapuZQ2I3qvJVhu9V5KcQkMooorQkKKK57x54uj8E+G59QIWS6Y+TawN/y0lIO3/gI5Y+ymqjGVSShHdkVJxpxc5uyRwXxj8VHUb6PwvaPmKMrNqDDoW6pF/7Mf+A+4rktohhCjgYxWdo0Er+Zc3MjTXM7tJLK3V2Ykkn6mr15J8uBX2FKiqMFSj0/Fn5vi8TLEVJVpddvJGbeS5zXParGJVI6g1sXDdazLobga9KEbanje01PXvgX48OqaadEvJN17YqBGzHJkh6L9SvC/Tae9evcHpzXxppurXXhnW7bVLM4nt33BT0cdGU+xGR+Oa+svCviK18S6La39q+6Gddwz1B6FT7g5B+lfMZphfZT9rFaS/M/Q8nxv1il7Kb96P4r+tDZooorwj6EKKKKACioby8g06znurqVYbaGNpJJG6KoGSa8um+PHl3G9fD0x03P+uNyomK5+95e3H4bvxropYerXv7NXsctfFUcNZVZWv8A10PV6KpaTq9trenwXlpKJreZA6MO4P8An8Ku1g04uzOlNNXQUUUUhhUM3Spqhm6U1uJ7GXd/dNc/qP3TXQXn3TXPaj90162H3OKodn8Pf+RdX/rs/wDOumrmfh7/AMi6v/XZ/wCddNXhYr+PP1PTo/w4hRRRXKbBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABWb4g/wCQf/wNa0qzdf8A+Qf/AMDWtaX8SJnU+FlSz/1Yq+v3RVCy/wBWKvr9wVtU3M47ETVXkqxJVeSnEUhlFFFaEhkDJJAA6knAFfOXjbxSfiB4tM0LbtJst0NmvZ+fnl+rED8AvTmu/wDjd4ybTdNj8O2MhW/1FMzsp5ht8kH6Fz8v0De1ebaPp62luoxjAAr6HLqHJH28t3t/mfI5xi+eX1aGy3/y/X/hi9HGIYwBVO5YnNXJWqjPnmvYgfJ1X0M64XJNUJo85rRlWq8iV2RPPaMK8g68V2/wT8bHw7rn9jXUm2yvn/cljwk3THsG6fUD1NcxNDuBrGvLcq2RlSDkFeCD2INFSnGvTdOezO/CYmWGqxqx6H2lHIJFDCnV598H/Hn/AAl/h9VuHB1G1xFcj+8cHa/0YD8w1eg18BWpSo1HTluj9Vo1Y16aqQ2YUUVz/jrxZH4N8OzX5CyXbHyrWE/8tJiDj/gI5J9gazjGU5KEd2XOcacXObskcV8WPEg1K+Tw5bPmCErNfsvO5uqRfyY/8B9xXnupMvllR0qaxjkjhkmuJGnuZmaSaV+S7sSWJ+prNvpixNfZYegqUVTj0/M/NcdjJVqrqy6/gjqPg34zOj6y+gXL4trljJaE9Fk6sn/Auo98+te9KwZQe1fHGoK6yLNE7RzRsHSRThlYHII96+k/hf43Txl4diuHKpeRnyrmMcbZAOv0I5H19q83NMLy2rx+Z9HkeO9rD6vN6rb07fL8vQ7WiiivnT6oKhm6VNUM3SmtxPYzLz7p+lc9qH3TXQ3n3T9K57UPumvWw+5x1Tsvh7/yLq/9dn/nXTVzPw9/5F0f9dn/AJ101eFiv48/U9Kj/DiFFFFcpsFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFZmvf8g/8A4Gv8606zfEH/AB4f8DWtaX8SJnU+FlWy/wBWKvj7tZ9l/qxWgPu1tU3M4bEUneq0lWZO9VnpxCQys7xFr1r4Y0W81S9JFvbJuKqfmcnhUX3JwB9a0a8E+L3iw+K/Ei6JaPu03TJD5zKcrLcYwfwQEr9S3Xiu/C4f6zUUenX0PNx2KWEoufXZepzNvPd+JNYutZ1A7ru7fewHRB0VB7KAAPpW2o2rioLOAQxADtUzn5a+rk9bLZH5623eUt2Qyt1qpJVmSq0laROSZUcVCy1YYcmmba6EcjRUePNULy23Z4rYZKrzRZB4rWLI2Mzwn4qm8CeJrfUl3PbZ8u5iX+OInn8QeR7j3r620vUIdTsYbmCRZYZUWRJFOQ6kZBH1BzXx9qlpuVuK9K/Z78fG2uJPCt9Jyu6WwZj1XkvH+H3h7FvSvJzTC+2p+2hut/T/AIB9bkWYezn9WqPSW3r/AMH8z6C45JIAHUk4Ar588XeJT488VvdRMTpNluhsx2fn55fqxAx7Bfeu3+M/jE2Omx+H7GTF7qSEzsp5itySD+LnK/QN7V53p1qtrboigDA9K87L6HJH28t3t/mehnGL5pfVoPRav9F+v/DElwdse0cVi3S5Y1r3DZzWXOMmvdp6HxlbVmNdQ7gat+AvFsngTxPFdOzfYJ8RXSj+7nIce6nn6EjvTpI85rK1Cz3KTiulxjUi4S2ZNCtLD1FUhuj69s7pbq3SRGDqwBDKcgg9CKnrxT4D+OjPbt4dvZM3Fqu62Zj9+H+79Vzj6Eele15zzXweKoSw9V05H6xhcRHFUo1YdfzCoZulTVDN0rmW50vYzLz7p+lc7qP3TXQ3n3TXPaj90162H3OKodl8Pf8AkXB/12f+ddPXM/D3/kXR/wBdn/nXTV4WK/jz9T06P8OIUUUVymwUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAVmeIP+PD/AIGtadZviD/kH/8AA1rWl/EiZ1PhZVsv9WK0B/q6zrH7grSX/V1tU3M4bEEnU1Xk71YkqBl3MB6mnEGcH8WvHJ8F+Gytq+NWvsw2g7p/fl/4CCMf7RWvDPD9qIY1/mTz+dVvG3iuXxl4yvtQlJFvG5gtYz/yzhViF/E8sfdvpUtjdhUHNfb4XC/VqKT+J6v/AC+R+cZhi/rddtfCtF/n8/8AI6ZXwtRSS+9UFvxt+9UUl6PWtlE85svSScVXkbiqb3w/vVA18PWtVFmEi3JJ70zzRVFrxSetJ9rHrWqic7Rf80U1pAc1SN0vrSfal9atIzaG3iKyniuVvnn028gvrOQwXdtIs0Ui9VYHIP8Aj610s1wpzzWHqSht3pW8ezIjeLujqdA1ybxffXWsXriS8uJCZQOiYGAoyegUAD2rqvurXj/hXU30fX0jB/cXJ2svow+6f6fjXqZvQ0YPrXDXp8sly7HqxqOouaW/UdNVCVealmul9apyXAz1qYpnNUFaP2qvPBuWn/aPemtcZFdCOWSOfmuLvQNUttTsW8u7tZBJG3b3U+xGQfY19V+BfFtr4y8O2mp2hwky/NGTlo3GQyH3ByK+YNTUSxtmtT4L+Oj4K8Xf2bdSbdK1SRU5+7FcHhG+jcKf+AntXDmGF+s0eaPxR/I+gyTHvC1vZVH7svwfT+v8j6tPQ1DN0p8cnmR7hTJulfFLc/SHsZd5901z+ofdNdDd9657UPumvVw+5x1Dsfh7/wAi4P8Ars/866euZ+Hv/Iur/wBdn/nXTV4WK/jz9T0qP8OIUUUVymwUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAVmeIP+Qf/AMDWtOs3xB/yD/8Aga1rS/iRM6nwsqWP3RWiv3KzrH7orSX7lbVNzOGxDJVaQleR1zmrMlVpKcQkfLHxG+G2qeFfEF5PZ2c13pM8rywy26F/KBOSjAcjHTPQjHfIrloxfx4/0K6/78P/AIV9kS26TfeGTVVtHgYk7a+mpZs1BRqRu0fLVcjpzm5QnZPofJKzXo/5c7r/AL8N/hQZr0/8udz/AN+X/wAK+tf7Gt/7go/sW3/uCtP7Wj/J+P8AwDH+wV/z8/D/AIJ8iu14wH+h3P8A35b/AAqMre/8+l1/34f/AAr6+/sW3/u/zpf7Hg/u/wA6r+2I/wAgv7AX/Pz8P+CfH3l3v/Pndf8Afl/8KNt7/wA+Vz/35f8Awr7A/se3/uij+x7f+6Kf9sR/kF/q/H/n5+H/AAT4/wBl7/z53X/fl/8ACjy73/nyuv8Avy/+FfYH9j2/90Uf2Nb/ANwUf2xH+QP9X4/8/Pw/4J8eNFfH/lzuv+/Df4VQvI7vHNpcj6wt/hX2n/Y8H90frUE3huzn+/GCapZ1HrAl8PR/5+fh/wAE+I7GxvJNRjm+x3OIzkfuW5OMeldml3eCMD7Hdf8Afl/8K+qIfDNlB9yMCrH9jwen6mlUziEvsfiXHIFFW9p+H/BPkuS4vW6Wlz/35f8AwqLzL7/n0uv+/L/4V9c/2PB6fqaP7Hg/u/qaj+14/wAn4/8AAF/q+v8An5+H/BPkXzL7/nzuv+/D/wCFJvvf+fO6/wC/Lf4V9d/2PB/d/n/jR/Y8Hp+tH9sR/k/EX+r0f+fn4f8ABPj6b7ay/wDHldH/ALYv/hVXTPBuseLdYt7OCxuIkaQebcSRMqRJkbjkgc4zgDk8V9l/2PB6frTo9LgRs7cmm86svdhqOPD1NSTlO69BNL3fZgW4qebpUoUKuB0qKbpXzV7yufWvYzLvvXPah9010N33rntQ+6a9TD7nHVOy+Hv/ACLq/wDXZ/5101cz8Pf+RdX/AK7P/OumrwsV/Hn6npUf4cQooorlNgooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigArM8Qf8g/8A4Gv8606z9bjMulzgDlRv/I5rSm7TTIn8LKNifkFaan5aw7C4Gwc1qJMNtdNSLuYweg+SqslPklHrVeSQUophJi0VH5o9aXzK1sRcfRTPMHrSeaPWiwXJKKj80etHmj1oswuSUVH5o9aPNHrRYLklFR+aPWjzB60WC5JRUfmD1o8wetFguSUVH5g9aPMHrRYLklFR+YPWk82izC5LRUXm0ebRZhcloqLzaPOFFmFyU1BMeKVphiq80w2mqjFktlO6bg1zupN1rau5hzXP6jMOa9fDx1OSozuvh7/yLq/9dn/nXTVheDbVrPw3ZK4wzqZT/wACYsP0Irdr53EPmrTa7s9SkrU4ryCiiiuc1CiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACmlQwwRkU6igDjbuFtJvTCc+W3zRt6r6fUdKsR3wx1re1HTYtTtzFKPdWHVT6iuL1KxvtFLeYhltx0mjGVx7j+H+VetRlGurN+9+ZxTi6butjVa8HrUT3Q55rn/AO10YA7hTTqg9a7Fh2c7qo3vtPvR9q9657+1P9qk/tT/AGq0+ry7E+0R0X2mj7T71zv9q/7VH9q/7VH1eQe0R0X2n3o+0+9c7/an+1R/an+3+tH1dh7RHRfafej7T71zv9qf7VH9qf7VH1dh7RHRfavej7T71zv9qD+9Sf2oP71H1dh7Q6P7T70n2r3rnf7UH96j+1B/eo+rsPaI6P7V70n2qud/tQf3qP7UH96j6uw9ojovtXvR9qrnf7VH96j+1R/eo+rsPaI6L7V70faveud/tUf3qDqn+1R9XYe0R0X2r3o+1e9c5/ao/vUv9qD+9R9XfYXtDoHuveq8118vWsVtU3d6rzamNpywA+taRw7E6iL11ddear6NpT+ItWS3AJgUhp29Fz0+p/z0qTSvD+o+IHUxxmC273EoIGP9kfxfhx716No+i2+h2Yt7dfd5G5Zz6mssRiY4eLjB3l+RdKk6ju9i8qhVCgbQBgAdqfRRXzR6wUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABTdtOooAzbrw7pt4xaWxhZz1YIAx+pFVv+EL0b/nxT/vpv8a26K2VarHRSf3kOnB7ow/+EM0b/nxX/vtv8aT/AIQvRv8AnwX/AL7b/Gt2in9Yrfzv72L2cP5V9xhf8IXo3/Piv/fb/wCNL/whejf8+C/9/G/xrcoo+sVv5397D2cP5UYX/CFaN/z4L/38f/Gl/wCEL0b/AJ8V/wC+2/xrcoo+sVv5397D2cP5UcH4r8G21vHDcWMfkop2SKGJ69Dz75/OsWHwyZFByx/GvUZoFuIXjcZVhg1gWkPkTPA/3kOPr3Br0KOMqcnK3do5KlCPNe2jOSbwr6Fv++jVaTw0y/xMPxr0j7KjR9BVK6tVXsK0jjaje4pYeJ53Jobr/E351Uk0yRf42/Ou6uoF54FYt4qrmvRp4iUjllTSOUlt5U/5aNXX+AfCkepWs15qKGeFj5cMbEgcfebj34/A1jRWb6pqENnD/rJm25/ujufyya9as7OOxtYreFdkUShVHsBWOPxMqdNQi9X+ReGpKUuZ7IzP+EL0X/nwX/vtv8aT/hC9G/58F/77b/Gt2ivA+sVv5397PT9nD+VGF/whejf8+C/99t/jR/whejf8+C/99t/jW7RR9Yrfzv72Hs4fyowv+EL0b/nwX/vtv8aP+EL0b/nwX/vtv8a3aKPrFb+d/ew9nD+VGH/whOi/8+Cf99t/jVm18N6ZZMHhsLdJB0fYCw+hPNadFJ1qslZyf3j9nBapDdtOoorEsKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigArJ1iAo6XSj7vyv8ATsf8+ta1RyRiaNkYZVhgirhLllcmUeZWKdrIHUfSobwYzUdlut5Hgc5aM4B9R2NTXy/LmujaRjvEwrxsA1zeoTY3V0GottU1zi2cmr6lBZREhpWwzD+FerH8BXtYeyXM9kcFTeyOj+HukFY5dTlX5pcxw57IDyfxI/T3rtaht7ZLW3jhiXZHGoRR6AVNXg16rrVHNnp04KnFRQUUUVgaBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRSZozQBmatCU2XSjlPlf3U9PyP8zUdxMJLcGtWRVkVlYAqRgg1yt9I2ns8DnO0/KfUdjXXR9/3eqOep7rv3M7V5gqHmtDwHpWy3k1KRfnuPlj9kB6/if5CsMwvrmoQWSEgSH52H8KDlj/T6kV6LDEkMaRRqEjQBVVegA6Cu3FVPZ0lSW7/Iwox5p876EtFJmjNeOd4tFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQB//2Q==" name="data">
                    <div class="form-group" >
                        <button type="button" style="width: 70%;margin: 0 0 0 520px" class="btn" onclick="sendForm()">Save</button>
                    </div>
                </div>
            </form>
        </div>

        <script>
            function goHome() {
                window.location = '../home';
            }
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
                    var form = document.getElementById('addslider');
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
        </script>
    </body>
</html>
