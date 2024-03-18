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
        <script src="https://cdn.tiny.cloud/1/fxl5y9orttfc7bs00l2bcgwyxaefx9f4s8dvb0qajm25dpu4/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
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
                    <!-- style này là ?? ?ánh d?u xem cái nào ?ang ???c ch?n -->
                    <li onclick="goTo('course')" style=" margin-top: -200px;" class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                        <span class="material-symbols-outlined">book</span><a>Courses</a>
                    </li>
                    <li  class="list-item" style="background-color: #f7b205;margin-top: -520px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">person</span><a>Blogs</a></li>
                </ul>
            </div>
        </div>
        <div class="right-sider">
            <div class="header" style="height: 10vh">
                <div class="title"> <a href="course"><i class="ti-angle-left" style="margin-right: 4px;color: white"></i></a><span>COURSE</span></div>
                <div class="info">
                    <span class="avatar">
                        <img style="width: 40px;height: 40px" src="${sessionScope.user.img}" alt>
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
            <div class="content" style="margin: 0 0 0 350px">
                <div  style="width: 70%">
                    <form action="" method="post" id="savechange">
                        <div class="infor">
                            <div class="form-group">
                                <input type="text" readonly="true"  id="course_name" name="course_name" style="width: 100%" class="form-control">
                            </div>
                            <div class="form-group">
                                Lesson name: <input type="text"   id="lesson_name" name="lesson_name" style="width: 100%" placeholder="Input lesson name..." onclick="hideError()" class="form-control">
                            </div>
                            <div>
                                <textarea id="content" cols="30" rows="20" style="width: 100%;" onclick="hideError()" name="content">
                                   
                                </textarea>
                            </div>
                            <div id="error" style="color:red;"></div>
                            <button type="button" style="margin: 20px 0 0 685px;width: 25%;padding: 20px 0 20px 0" class="btn" onclick="sendForm()">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
            <script>
                function sendForm() {
                    var error = '';
                    const title = document.getElementById('lesson_name').value;
                    if (title.length === 0) {
                        error = 'Lesson name is invalid. Please try again';
                        document.getElementById('error').textContent = error;
                        document.getElementById('error').style.display = 'block';
                    } else {
                        var form = document.getElementById('savechange');
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
                tinymce.init({
                    selector: 'textarea',
                    plugins: 'ai tinycomments mentions anchor autolink charmap preview codesample emoticons image link lists media searchreplace table visualblocks wordcount checklist mediaembed casechange export formatpainter pageembed permanentpen footnotes advtemplate advtable advcode editimage tableofcontents mergetags powerpaste tinymcespellchecker autocorrect a11ychecker typography inlinecss',
                    toolbar: 'undo redo | blocks fontfamily fontsize | bold italic underline strikethrough | link image media table mergetags | align lineheight | tinycomments | checklist numlist bullist indent outdent | emoticons charmap | removeformat',
                    tinycomments_mode: 'embedded',
                    tinycomments_author: 'Author name',
                    mergetags_list: [{
                            value: 'First.Name',
                            title: 'First Name'
                        }, {
                            value: 'Email',
                            title: 'Email'
                        }, ],
                    ai_request: (request, respondWith) => respondWith.string(() => Promise.reject("See docs to implement AI Assistant")),
                });
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
            </script>
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

                function chooseBlog(blogId, page, title, author, category, dateFrom, dateTo) {
                    window.location = 'blogs?blogId=' + blogId + '&page=' + page + '&title=' + title + '&author=' + author + '&blog_category=' + category + '&date_from=' + dateFrom + '&date_to=' + dateTo;
                }

                function changeStatus(blogId) {
                    document.getElementById(blogId).submit();
                }

            </script>
    </body>
</html>
