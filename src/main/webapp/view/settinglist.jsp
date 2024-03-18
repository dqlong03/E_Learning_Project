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

            #combinedChart {
                width: 800px !important;
                height: 500px !important;
            }

            .addUserAdmin form {
                display: flex;
                flex-wrap: nowrap; /* ??m b?o các ph?n t? không b? tr??t xu?ng hàng m?i */
            }

            .addUserAdmin form input {
                flex: 1; /* C?n ch?nh các ô input ?? chia ??u không gian trên hàng */
                margin-right: 3%; /* Kho?ng cách gi?a các ô input */
                height: 30px;
                margin-left: 1%;
            }

            .addUserAdmin form input[type="submit"] {
                flex: 0; /* Không ph? ??nh flex ?? nút "Submit" không c?ng ra nh? ô input */
            }

            .leftPage{
                margin-left: 2%;
            }

            .leftPage, .rightPage {

                float: left;
                box-sizing: border-box;
            }
            .leftPage{
                width: 48%;
            }
            .rightPage {
                width: 50%;
                float: right; /* ??m b?o rightPage n?m bên ph?i c?a leftPage */
                box-sizing: border-box; /* ??m b?o padding và border ???c tính vào kích th??c */
                padding: 0 10px; /* ??m b?o padding không làm thay ??i kích th??c */
                display: flex; /* S?p x?p các ph?n t? con theo c?t */
                flex-direction: column; /* S?p x?p các ph?n t? con theo c?t */
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
                margin-top: 5%;
            }

            .addUserAdmin label{
                line-height: 30px;
            }

            .listAllUser td{
                width:15%;
                padding: 3px 0px;
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
            .choose {
                background-color: rgba(229, 229, 229, 0.5);
            }
            #name {
                width:88%;
            }
        </style>
    </head>
    <body>
        <div class="left-sider">
            <div class="logo">
                <img src="../assets/images/logoBlack.png" onclick="goTo('../home')" alt>
            </div>
            <div class="navigator">
                <ul class="list-task">
                    <!-- style này là ?? ?ánh d?u xem cái nào ?ang ???c ch?n -->
                    <li onclick="goTo('userList')" style=" margin-top: -200px;" class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                        <span class="material-symbols-outlined">person</span><a>User list</a>
                    </li>
                    <li  class="list-item" style="background-color: #f7b205;margin-top: -520px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">settings</span><a>Settings</a></li>
                </ul>
            </div>
        </div>
        <div class="right-sider">
            <div class="header" style="height: 10vh">
                <div class="title"><span>SETTINGS LIST</span></div>
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
                    <form action="settingList" method="GET">
                        <table class="listAllUser">
                            <tbody>
                                <tr>
                                    <td><label for="name">Name:</label></td>
                                    <td><input type="text" id="name" name="name"></td>

                                </tr>
                                <tr>
                                    <td><label for="type">Type:</label></td>
                                    <td><select id="type" name="type">
                                            <option value="0" <c:if test="${param.type eq '0'}">selected</c:if>>All</option>

                                            <c:forEach items="${requestScope.st}" var="st">
                                                <option value="${st.typeid}" <c:if test="${param.type eq st.typeid}">selected</c:if>>${st.name}</option>
                                            </c:forEach>

                                        </select></td>
                                    <td><label for="status">Status:</label></td>
                                    <td>
                                        <select id="status" name="status">
                                            <option value="3" <c:if test="${param.status eq '3'}">selected</c:if>>All</option>
                                            <option value="1" <c:if test="${param.status eq '1'}">selected</c:if>>Activated</option>
                                            <option value="0" <c:if test="${param.status eq '0'}">selected</c:if>>Inactivated</option>
                                            </select>
                                        </td>

                                        <td> <button type="submit" class="btn">Search</button> </td> 
                                        <td> <button type="button" class="add-button btn" onclick="location.href = 'settingList';">Add</button></td>
                                    </tr>

                                </tbody>

                            </table>
                        </form>

                    <c:if test="${requestScope.st!= null and requestScope.st.size()>0}">
                        <div class="listEnrollmentTable">
                            <table class="table-sortable" border="1">
                                <thead>
                                    <tr style="background-color: #f2f2f2;">
                                        <th>Name</th>
                                        <th>Typename</th>
                                        <th>Order</th>
                                        <th>Status</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.s}" var="s">
                                        <tr class="${s.type.typeid eq param.typeid and s.order eq param.order ? "choose":""}">
                                            <td>${s.name}</td>

                                            <td>${s.type.name}</td>
                                            <td>${s.order}</td>
                                            <td>${s.status?"Active":"Inactive"}</td>
                                            <td><a href="settingList?id=1&order=${s.order}&typeid=${s.type.typeid}&editname=${s.name}&typename=${s.type.name}&type=${param.type}&status=${param.status}&page=${param.page}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                                    <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                                    <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                                                    </svg></a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>

                        <div id="pagger"></div>

                    </c:if>
                    <c:if test="${requestScope.st ne null and requestScope.st.size()==0}">
                        <div class="img_not_found">
                            <img src="../assets/images/404.2 (1).png" alt=""/>
                        </div>
                        <h3 class="not_found">No setting found!</h3>
                    </c:if>
                </div>       


                <div class="rightPage">
                    <div class="addUserAdmin" >
                        <% 
                  // Ki?m tra xem có tham s? ID không
                  String id = request.getParameter("id");
                  String order = request.getParameter("order");
                  String editname = request.getParameter("editname");
                  String typeid = request.getParameter("typeid");
                  String typename = request.getParameter("typename");
                  if (id != null && !id.isEmpty()) { 
                        %>
                        <h3>Edit Setting</h3>
                        <form class="addenrollments" action="settingList" method="post" >
                            <table style="border: 1px solid ">
                                <input type="hidden" name="action" value="edit">
                                <input hidden=""type="text" id="type" name="typeedit" value="<%= typeid %>">
                                <tr>
                                    <td><label for="name">Name:</label></td>
                                    <td><input type="text" id="name" name="nameedit" pattern="^[A-Za-z ]+$" title="Invalid name" value="<%= editname %>" required</td>
                                </tr>
                                <tr>
                                    <td><label for="type">Type:</label></td>
                                    <td><input type="text" id="type" name="typeedit" value="<%= typename %>" readonly=""></td>
                                </tr>
                                <tr>
                                    <td><label for="type">Order:</label></td>
                                    <td><input readonly="" type="text" id="order" name="order" value="<%= order%>"></td>
                                </tr>
                                <tr>
                                    <td><label for="status">Status:</label></td>
                                    <td>
                                        <select id="status" name="statusedit">
                                            <option value="1" >Active</option>
                                            <option value="0" >Inactive</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <button style="background-color: #000000" type="reset" value="Reset">Reset</button>

                                    </td>
                                    <td>
                                        <button style="background-color: #f7b205" width="60px" type="submit" value="Submit">Submit</button>
                                    </td>
                                </tr>


                            </table>
                        </form>
                        <% } else { %>

                        <!--Form add-->
                        <h2>Add New Setting</h2>
                        <form class="addenrollments" action="settingList" method="post">
                            <table style="border: 1px solid ">
                                <input type="hidden" name="action" value="add">
                                <tr>
                                    <td><label for="name">Name:</label></td>
                                    <td><input type="text" id="name" name="nameadd" pattern="^[A-Za-z ]+$" title="Invalid name" value="" required></td>
                                </tr>
                                <tr>
                                    <td><label for="type">Type:</label></td>
                                    <td>
                                        <select name="typeadd" id="typeadd">
                                            <option value="0" ${param.typeadd eq '0' ? 'selected' : ''}>All Type</option>
                                            <c:forEach items="${requestScope.st}" var="st">
                                                <option value="${st.typeid}" ${param.typeadd eq st.typeid ? 'selected' : ''}>${st.name}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>

                                <input type="hidden" id="order" name="order" value="" readonly>

                                <tr>
                                    <td><label for="status">Status:</label></td>
                                    <td>
                                        <select id="status" name="statusadd">
                                            <option value="1">Active</option>
                                            <option value="0">Inactive</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>                                        <button style="background-color: #000000" type="reset" value="Reset">Reset</button>
                                    </td>
                                    <td><button style="background-color: #f7b205" width="60px" type="submit" class="btn">Submit</button></td>
                                </tr>
                            </table>
                        </form>


                        <% } %>  
                    </div>
                </div>
            </div>

            <script>
                paging1("pagger",${requestScope.pageindex},${requestScope.totalpage}, 2, '${requestScope.info}',${requestScope.type},${requestScope.status});

                function paging1(id, pageindex, totalpage, gap, infor, type, status) {
                    var container = document.getElementById(id);

                    if (!infor) {
                        if (pageindex - gap > 1)
                            container.innerHTML += '<a href="settingList?type=' + type + '&status=' + status + '&page=1">First</a> ';

                        for (var i = pageindex - gap; i < pageindex; i++)
                            if (i > 0)
                                container.innerHTML += ' <a href="settingList?type=' + type + '&status=' + status + '&page=' + i + '">' + i + '</a>';

                        container.innerHTML += '<span>' + pageindex + '</span>';

                        for (var i = pageindex + 1; i <= pageindex + gap && i <= totalpage; i++)
                            container.innerHTML += '  <a href="settingList?type=' + type + '&status=' + status + '&page=' + i + '">' + i + '</a>';

                        if (pageindex + gap < totalpage)
                            container.innerHTML += ' <a href="settingList?type=' + type + '&status=' + status + '&page=' + totalpage + '">Last</a>';
                    } else {
                        if (pageindex - gap > 1)
                            container.innerHTML += '<a href="settingList?name=' + infor + '&type=' + type + '&status=' + status + '&page=1">First</a> ';

                        for (var i = pageindex - gap; i < pageindex; i++)
                            if (i > 0)
                                container.innerHTML += ' <a href="settingList?name=' + infor + '&type=' + type + '&status=' + status + '&page=' + i + '">' + i + '</a>';

                        container.innerHTML += '<span>' + pageindex + '</span>';

                        for (var i = pageindex + 1; i <= pageindex + gap && i <= totalpage; i++)
                            container.innerHTML += '  <a href="settingList?name=' + infor + '&type=' + type + '&status=' + status + '&page=' + i + '">' + i + '</a>';

                        if (pageindex + gap < totalpage)
                            container.innerHTML += ' <a href="settingList?name=' + infor + '&type=' + type + '&status=' + status + '&page=' + totalpage + '">Last</a>';
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

            </script>
            <script src="../assets/js/sort.js" type="text/javascript"></script>
            <script>
                function goTo(url) {
                    window.location = url;
                }
            </script>
    </body>
</html>
