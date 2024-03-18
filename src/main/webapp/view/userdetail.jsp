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
                margin: 0 5px; /* Kho?ng cách gi?a các s? */
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
                max-width: 30%;
                flex: 1; /* C?n ch?nh các ô input ?? chia ??u không gian trên hàng */
                margin-right: 3%; /* Kho?ng cách gi?a các ô input */
                height: 30px;
                margin-left: 1%;
            }

            .addUserAdmin form input[type="submit"] {
                flex: 0; /* Không ph? ??nh flex ?? nút "Submit" không c?ng ra nh? ô input */
            }

            .leftPage{
                margin-left: 10%;
            }

            .leftPage, .rightPage {

                float: left;
                box-sizing: border-box;
            }
            .leftPage{
                width: 20%;
            }
            .rightPage {
                margin-top: -280px;
                margin-right:  8%;
                width: 70%;
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


            .img_not_found {
                margin-left: 20%;
            }
            .not_found {
                margin-left: 25%;
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
                    <li style="background-color: #f7b205; margin-top: -200px;" class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                        <span class="material-symbols-outlined">person</span><a>User list</a>
                    </li>
                    <li onclick="goTo('settingList')" class="list-item" style="margin-top: -520px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">settings</span><a>Settings</a></li>
                </ul>
            </div>
        </div>
        <div class="right-sider">
            <div class="header" style="height: 10vh">
                <div class="title"><a href="userList?action=${param.action}&role=${param.role}&status=${param.status}&page=${param.page}" style="text-decoration: none; color: white;" ><i class="ti-angle-left" style="margin-right: 5px;"></i><span>USERS LIST</span></a>   </div>
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
                    <div class="profile-bx text-center">
                        <div class="user-profile-thumb">
                            <img src="${imageData}" alt=""/>

                        </div>
                        <div class="profile-info">
                            <h4>${requestScope.user.name}</h4>
                            <span>${requestScope.user.account.email}</span>
                            <div>d ${requestScope.user.balance}</div>

                        </div>

                    </div>

                </div>       


                <div class="rightPage">
                    <div class="addUserAdmin" >
                        <div class="col-lg-10">
                            <div class="profile-content-bx">
                                <div class="tab-content">
                                    <div class="tab-pane active">
                                        <div class="profile-head">
                                            <h3>User Information </h3>
                                        </div>
                                        <form action="userDetail" method="post" enctype="multipart/form-data">
                                            <input type="hidden" value="${param.action}" name="actionS">
                                            <input type="hidden" value="${param.role}" name="roleS">
                                            <input type="hidden" value="${param.status}" name="statusS">
                                            <input type="hidden" value="${param.page}" name="pageS">
                                            <table>

                                                <tr id="message">
                                                    <td style="color:red;">${requestScope.message}</td>
                                                </tr>

                                                <tr>
                                                    <td>Full Name:</td>
                                                    <td>${requestScope.user.name}</td>
                                                </tr>
                                                <tr>
                                                    <td>Gender:</td>
                                                    <td>${requestScope.user.gender ? "Male" : "Female"}</td>
                                                </tr>
                                                <tr>
                                                    <td>Date of Birth:</td>
                                                    <td>${requestScope.user.dob}</td>
                                                </tr>
                                                <tr>
                                                    <td>Phone No.:</td>
                                                    <td>${requestScope.user.phone}</td>
                                                </tr>
                                                <tr>
                                                    <td>Address:</td>
                                                    <td>${requestScope.user.address}</td>
                                                </tr>
                                                <tr>
                                                    <td>Postcode:</td>
                                                    <td>${requestScope.user.postCode}</td>
                                                </tr>
                                                <tr hidden="">
                                                    <td hidden="">AccountID:</td>
                                                    <td><input hidden="" type="text" id="accountid" name="accountid" value="${requestScope.user.account.accId}" readonly></td>
                                                </tr>
                                                <tr>
                                                    <td>Role:</td>
                                                    <td>
                                                        <select id="roleid" name="roleid">
                                                            <option value="${requestScope.user.account.role.roleId}" ${param.roleid eq requestScope.user.account.role.roleId ? 'selected' : ''}>${requestScope.user.account.role.name}</option>
                                                            <c:forEach items="${requestScope.role}" var="role">
                                                                <option value="${role.roleId}" ${param.roleid eq requestScope.user.account.role.roleId ? 'selected' : ''}>${role.name}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Status:</td>
                                                    <td>
                                                        <select id="status" name="status">                                                                                                                                                                                                             
                                                            <option value="2" ${requestScope.user.account.isActivated eq 2 ?"selected":""}>Blocked</option>
                                                            <option value="1" ${requestScope.user.account.isActivated eq 1 ?"selected":""}>Active</option>
                                                            <option value="0" ${requestScope.user.account.isActivated eq 0 ?"selected":""}>Inactive</option>                                                                                                                        
                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>Created Time:</td>
                                                    <td><input class="form-control" type="text" id="createdtime" name="createdtime" value="${requestScope.user.account.createdTime}" readonly></td>
                                                </tr>

                                                <tr>
                                                    <td colspan="2">
                                                        <button type="submit" class="btn">Save changes</button>
                                                        <button type="reset" class="btn-secondry">Cancel</button>
                                                    </td>
                                                </tr>
                                            </table>
                                        </form>

                                    </div>
                                </div> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script>
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
            function goTo(url) {
                window.location= url;
            }
            function hideMessage() {
                document.getElementById('message').style.display = 'none';
            }
            setTimeout('hideMessage()', 2000);
        </script>
    </body>
</html>
