<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            .info {
                display: flex;
                align-items: center;
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

            #pagger {
                margin-top: 20px;
                text-align: center;
            }

            #pagger a {
                display: inline-block;
                padding: 8px 16px;
                text-decoration: none;
                color: #333;
                border: 1px solid #ccc;
                border-radius: 4px;
                margin-right: 5px;
            }

            #pagger a:hover {
                background-color: #f7f7f7;
            }

            #pagger span {
                display: inline-block;
                padding: 8px 16px;
                background-color: #ccc;
                color: #fff;
                border-radius: 4px;
                margin-right: 5px;
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



            .addUserAdmin form {
                display: flex;
                flex-wrap: nowrap; /* ??m b?o c?c ph?n t? kh?ng b? tr??t xu?ng h?ng m?i */
            }

            .addUserAdmin form input {

                flex: 1; /* C?n ch?nh c?c ? input ?? chia ??u kh?ng gian tr?n h?ng */
                margin-right: 3%; /* Kho?ng c?ch gi?a c?c ? input */
                height: 30px;
                margin-left: 1%;
            }

            .addUserAdmin form input[type="submit"] {
                flex: 0; /* Kh?ng ph? ??nh flex ?? n?t "Submit" kh?ng c?ng ra nh? ? input */
            }

            .leftPage{
                margin-left: 3%;
            }

            .leftPage, .rightPage {

                float: left;
                box-sizing: border-box;
            }
            .leftPage{
                width: 55%;

            }
            .rightPage {
                margin-right:  2%;
                width: 40%;
                float: right; /* ??m b?o rightPage n?m b?n ph?i c?a leftPage */
                box-sizing: border-box; /* ??m b?o padding v? border ???c t?nh v?o k?ch th??c */
                padding: 0 10px; /* ??m b?o padding kh?ng l?m thay ??i k?ch th??c */
                display: flex; /* S?p x?p c?c ph?n t? con theo c?t */
                flex-direction: column; /* S?p x?p c?c ph?n t? con theo c?t */
            }
            .container {
                display: flex;
                flex-wrap: wrap;
            }

            canvas{
                margin-left: 6%;
            }

            .addUserAdmin{
                margin-left: 12%;
                margin-top: 4%;
            }

            .addUserAdmin label{
                line-height: 30px;
            }

            .listAllUser td{
                width:15%;
                padding: 3px 0px;
            }
            .listAllUser{

            }
            .table-container {
                position: relative;
                overflow-y: auto;
                overflow-x: hidden; /* ?n thanh cu?n ngang */
                max-height: 445px;
            }

            .table-sortable thead {
                position: sticky;
                top: 0;
                z-index: 1;
                background-color: #f2f2f2;
                width: calc(100% - 17px); /* ??m b?o r?ng chi?u r?ng c?a thead gi?ng v?i tbody */
            }
            .img_not_found {
                margin-left: 20%;
            }
            .not_found {
                margin-left: 25%;
            }
            button {
                font-size: 16px;
                padding: 8px 16px;
                color: white;
                border-radius: 4px;
                border: none;
                background-color: #f7b205;
                transition: background-color 0.3s ease-in-out;
                cursor: pointer;
            }
            .button-add {
                display: inline-block;
                padding:  12.5px 20px ;
                background-color: #f7b205; /* Màu n?n c?a nút */
                color: #ffffff; /* Màu ch? */
                text-decoration: none; /* Lo?i b? g?ch chân */
                border: none; /* Lo?i b? ???ng vi?n */
                border-radius: 50%; /* Bo góc */
                cursor: pointer; /* Bi?n con tr? thành hình bàn tay khi rê chu?t vào */
                transition: background-color 0.3s; /* Hi?u ?ng chuy?n ??i màu n?n */

            }
            .button-add:hover {
                opacity: 0.8;
            }
            .button-block {
                display: inline-block;
                padding: 10px 20px;
                background-color: #CE201F; /* Màu n?n c?a nút */
                color: #ffffff; /* Màu ch? */
                text-decoration: none; /* Lo?i b? g?ch chân */
                border: none; /* Lo?i b? ???ng vi?n */
                border-radius: 5px; /* Bo góc */
                cursor: pointer; /* Bi?n con tr? thành hình bàn tay khi rê chu?t vào */
                transition: background-color 0.3s; /* Hi?u ?ng chuy?n ??i màu n?n */
            }

            .button-link:hover {
                background-color: #0056b3; /* Màu n?n m?i khi rê chu?t vào */
            }
            .addUserAdmin table {
                margin-top:13px;
            }
            .bi-ban {
                color:orangered;
            }
            .bi-check-circle {
                color: green;
            }
            .bi-circle {
                color:purple;
            }
            .input-text {
                width:90%;
            }
            .block-btn:hover {
                opacity: 0.8;
                color: white;
            }
        </style>
    </head>
    <body>
        <div class="left-sider">
            <div class="logo">
                <img src="../assets/images/logoBlack.png" onclick="goTo('../home')" alt>
            </div>
            <div class="navigator">
                <c:if test="${sessionScope.session.role.roleId eq 3}">
                    <ul class="list-task">
                        <li onclick="goTo('report')" class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                            <span class="material-symbols-outlined">tv</span><a href="report">Dashboard</a>
                        </li>
                        <li class="list-item" style="background-color: #f7b205; margin-top: -30px;"  onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">person</span><a>Users</a></li>

                        <li onclick="goTo('post')" class="list-item" style="margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">post_add</span><a href="post">Posts</a>
                        </li>
                        <li onclick="goTo('slider')" class="list-item" style="margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">sliders</span><a href="slider">Sliders</a>
                        </li>
                        <li onclick="goTo('enrollmentlist')" class="list-item" style="margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">how_to_reg</span><a href="enrollmentlist">Enrollment</a></li>
                    </ul>
                </c:if>
                <c:if test="${sessionScope.session.role.roleId eq 5}">
                    <ul class="list-task">
                        <!-- style này là ?? ?ánh d?u xem cái nào ?ang ???c ch?n -->
                        <li style="background-color: #f7b205; margin-top: -200px;" class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                            <span class="material-symbols-outlined">person</span><a>User list</a>
                        </li>
                        <li onclick="goTo('settingList')" class="list-item" style="margin-top: -520px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">settings</span><a>Settings</a></li>
                    </ul>
                </c:if>
            </div>
        </div>
        <div class="right-sider">
            <div class="header">
                <div class="title"><span>USERS LIST</span></div>
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

            <div class="content">

                <div class="leftPage">
                    <form action="userList" method="GET">
                        <table class="listAllUser">
                            <tbody>
                                <tr>
                                    <td>Search:</td>
                                    <td><input type="text" id="infor" name="infor" placeholder="Enter to search" value="${param.infor}"></td>
                                    <td>Role:</td>
                                    <td>
                                        <select id="role" name="role">
                                            <option value="0" ${param.role eq 0 ? "selected": ""}>All role </option>
                                            <c:forEach items="${requestScope.roles}" var="role">
                                                <option value="${role.roleId}" <c:if test="${param.role eq role.roleId}">selected</c:if>>${role.name}</option>
                                            </c:forEach>

                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Status</td>
                                    <td>
                                        <select id="status" name="status">
                                            <option value="3" <c:if test="${param.status eq '3'}">selected</c:if>>All status</option>
                                            <option value="1" <c:if test="${param.status eq '1'}">selected</c:if>>Activated</option>
                                            <option value="0" <c:if test="${param.status eq '0'}">selected</c:if>>Deactivated</option>
                                            <option value="2" <c:if test="${param.status eq '2'}">selected</c:if>>Blocked</option>
                                            </select>
                                        </td>

                                        <td> <button type="submit" style="color:white; background-color: black; height: 30px; padding: 0px 5px;" class="fa fa-search text-primary;"></button>
                                        </td>
                                        <td> <a href="userList?action=add" class="button-add"><span>+</span></a></td>
                                    <c:if test="${sessionScope.session.role.roleId ne 3 }">
                                        <td> <a href="userList?action=block" class="button-block block-btn">Block</a></td>
                                    </c:if>
                                </tr>
                            </tbody>

                        </table>
                    </form>

                    <c:if test="${requestScope.users!= null and requestScope.users.size()>0}">
                        <div class="listEnrollmentTable">
                            <table class="table-sortable" border="1">
                                <thead>
                                    <tr style="background-color: #f2f2f2;">
                                        <th>#</th>
                                        <th>Email</th>
                                        <th>Full Name</th>
                                        <th>DOB</th>
                                        <th>Gender</th>
                                        <th>Phone</th>
                                        <th>Role</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.users}" var="u" varStatus="loop">
                                        <tr <c:if test="${sessionScope.session.role.roleId ne 3}">onclick="viewUserDetail('${u.account.accId}', '${param.action}', '${param.role}', '${param.status}', '${param.page}')" </c:if>  >
                                            <td>${loop.count}</td>
                                            <td>${u.account.email}</td>
                                            <td>${u.name}</td>
                                            <td>${u.dob}</td>
                                            <td>${u.gender?"Male":"Female"}</td>
                                            <td>${u.phone}</td>
                                            <td>${u.account.role.name}</td>
                                            <td>
                                                ${u.account.isActivated eq 2? 
                                                  "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-ban\" viewBox=\"0 0 16 16\"><path d=\"M15 8a6.97 6.97 0 0 0-1.71-4.584l-9.874 9.875A7 7 0 0 0 15 8M2.71 12.584l9.874-9.875a7 7 0 0 0-9.874 9.874ZM16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0\"/></svg>"
                                                  :u.account.isActivated eq 1?
                                                  "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-check-circle\" viewBox=\"0 0 16 16\"><path d=\"M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16\"/><path d=\"m10.97 4.97-.02.022-3.473 4.425-2.093-2.094a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05\"/>":
                                                  "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-circle\" viewBox=\"0 0 16 16\"><path d=\"M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16\"/></svg>" } 
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>

                        <div id="pagger"></div>

                    </c:if>
                    <c:if test="${requestScope.users ne null and requestScope.users.size()==0}">
                        <div class="img_not_found">
                            <img src="../assets/images/404.2 (1).png" alt=""/>
                        </div>
                        <h3 class="not_found">No enrollments found!</h3>
                    </c:if>
                </div>       
                <div class="rightPage">
                    <div class="addUserAdmin" >
                        <% 
                  String id = request.getParameter("action");
                  if (id != null && !id.isEmpty() && id.equals("add")) { 
                        %>
                        <!--form add--> 
                        <h3>Add New User</h3>
                        <form class="addenrollments" action="userList" method="post" id="registerd">

                            <table style="border: 1px solid " >

                                <input type="hidden" name="action" value="add">
                                <tr>
                                    <td>Full Name:</td>
                                    <td><input type="text" onclick="hideError()" class="input-text" id="fullName" name="fullname" ></td>
                                </tr>
                                <tr>
                                    <td>Email:</td>
                                    <td><input type="text"  onclick="hideError()" id="email" class="input-text" name="email" ></td>
                                </tr>
                                <tr>
                                    <td>Gender:</td>
                                    <td>
                                        <input type="radio" id="male" name="gender" value="male" checked>
                                        <label for="male" style="font-weight: normal;">Male</label>

                                        <input type="radio" id="female" name="gender" value="female" >
                                        <label for="female" style="font-weight: normal;">Female</label>
                                    </td>
                                </tr>
                                <c:if test="${sessionScope.session.role.roleId eq 3}">
                                    <input type="hidden" name ="role" value="1">
                                </c:if>
                                <c:if test="${sessionScope.session.role.roleId ne 3}">
                                    <tr>
                                        <td>Role:</td>
                                        <td>

                                            <select id="roleadd" name="role" required class="input-text">

                                                <c:forEach items="${requestScope.roles}" var="role">

                                                    <c:if test="${sessionScope.session.role.roleId ne 3 }">
                                                        <option value="${role.roleId}">${role.name}</option>
                                                    </c:if>

                                                </c:forEach>
                                            </select>
                                        </td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td>Date of Birth:</td>
                                    <td><input type="date" id="dob" onclick="hideError()" name="dob" class="input-text" ></td>
                                </tr>
                                <tr>
                                    <td>Phone:</td>
                                    <td><input type="tel" id="phone"  onclick="hideError()" name="phone" class="input-text" title="Wrong phone number" required></td>
                                </tr>

                                <tr>
                                    <td>
                                        <button type="button" onclick="checkBeforeSend()">ADD</button>
                                    </td>
                                    <td><div style="color:red;" id="error">${requestScope.message}</div></td>
                                </tr>
                            </table>
                        </form>
                        <% } else if(id != null && !id.isEmpty() && id.equals("block")) { %>
                        <c:if test="${sessionScope.session.role.roleId ne 3 }">
                            <!--Form block-->
                            <h2>Block User By Role</h2>
                            <form class="addenrollments" action="userList" method="post">
                                <table >
                                    <input type="hidden" name="action" value="block">
                                    <tr>
                                        <td style="width:fit-content;"><label>Role:</label> &nbsp; &nbsp;   
                                            <select id="roleblock" name="roleblock" required>
                                                <c:forEach items="${requestScope.roles}" var="role">
                                                    <option value="${role.roleId}">${role.name}</option>

                                                </c:forEach>
                                            </select>
                                            <button style="background-color: #CE201F;margin-left: 5%;" class="block-btn" type="submit">Block</button>
                                        </td>

                                    </tr>
                                    <tr>
                                        <td>
                                        </td>

                                    </tr>
                                </table>
                            </form>
                        </c:if>
                        <% } %> 
                    </div>
                </div>
            </div>

            <script>
                function goTo(url) {
                    window.location = url;
                }
                function checkBeforeSend() {
                    var error = '';
                    const fullName = document.getElementById('fullName').value;
                    const email = document.getElementById('email').value;
                    const dob = document.getElementById('dob').value;
                    const mobile = document.getElementById('phone').value;
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
                        var form = document.getElementById('registerd');
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
                function viewUserDetail(accId, action, role, status, page) {
                    window.location = 'userDetail?accountID=' + accId + '&action=' + action + '&role=' + role + '&status=' + status + '&page=' + page;
                }
                paging1("pagger",${requestScope.pageindex},${requestScope.totalpage}, 2, '${requestScope.info}',${requestScope.role},${requestScope.status}, '<%= id %>');

                function paging1(id, pageindex, totalpage, gap, infor, role, status, action) {
                    var container = document.getElementById(id);

                    if (!infor) {
                        if (pageindex - gap > 1)
                            container.innerHTML += '<a href="userList?action=' + action + '&role=' + role + '&status=' + status + '&page=1">First</a> ';

                        for (var i = pageindex - gap; i < pageindex; i++)
                            if (i > 0)
                                container.innerHTML += ' <a href="userList?action=' + action + '&role=' + role + '&status=' + status + '&page=' + i + '">' + i + '</a>';

                        container.innerHTML += '<span>' + pageindex + '</span>';

                        for (var i = pageindex + 1; i <= pageindex + gap && i <= totalpage; i++)
                            container.innerHTML += '  <a href="userList?action=' + action + '&role=' + role + '&status=' + status + '&page=' + i + '">' + i + '</a>';

                        if (pageindex + gap < totalpage)
                            container.innerHTML += ' <a href="userList?action=' + action + '&role=' + role + '&status=' + status + '&page=' + totalpage + '">Last</a>';
                    } else {
                        if (pageindex - gap > 1)
                            container.innerHTML += '<a href="userList?action=' + action + '&info=' + infor + '&role=' + role + '&status=' + status + '&page=1">First</a> ';

                        for (var i = pageindex - gap; i < pageindex; i++)
                            if (i > 0)
                                container.innerHTML += ' <a href="userList?action=' + action + '&info=' + infor + '&role=' + role + '&status=' + status + '&page=' + i + '">' + i + '</a>';

                        container.innerHTML += '<span>' + pageindex + '</span>';

                        for (var i = pageindex + 1; i <= pageindex + gap && i <= totalpage; i++)
                            container.innerHTML += '  <a href="userList?action=' + action + '&info=' + infor + '&role=' + role + '&status=' + status + '&page=' + i + '">' + i + '</a>';

                        if (pageindex + gap < totalpage)
                            container.innerHTML += ' <a href="userList?action=' + action + '&info=' + infor + '&role=' + role + '&status=' + status + '&page=' + totalpage + '">Last</a>';
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
            <script src="../assets/js/sort.js" type="text/javascript"></script>
    </body>
</html>
