<%-- 
    Document   : courseContent
    Created on : Feb 7, 2024, 10:45:55 AM
    Author     : tran Hoang Phuc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="" />
        <meta name="description" content="EduChamp : Education HTML Template" />
        <meta property="og:title" content="EduChamp : Education HTML Template" />
        <meta property="og:description" content="EduChamp : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">
        <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />
        <title>E-Learning : Education & Course </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
        <style>
            * {
                margin: 0;
                padding: 0;
                /* box-sizing: border-box; */
            }

            .header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 10px 20px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
                position: fixed;
                width: 100%;
                z-index: 100;
                background-color: white;
            }

            .logo img {
                width: 100px;
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

            .arrow {
                font-size: 20px;
                padding: 10px;
                cursor: pointer;
            }

            .dropdown-list {
                display: none;
                position: absolute;
                top: 65px;
                right: 130px;
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

            .btn {
                padding: 10px;
                margin-top: 10px;
                cursor: pointer;
            }

            .left-nav {
                width: fit-content;
                height: max-content;
                position: fixed;
                top: 150px;
                left: 0;
                transform: translateY(-50%);
            }

            .body {
                position: relative;
                display: flex;
                z-index: 1;
            }

            .right-site {
                width: 65%;
                margin-left: 5%;
                margin-top: 70px;
                z-index: 101;
                /* position: relative; */
                display: flex;
            }

            .course-description {
                width: 85%;
            }

            .course-content {
                margin-top: 40px;
            }

            .course-description p {
                text-align: justify;
                margin-top: 10px;
                margin-bottom: 30px;
            }

            .chapter-name span {
                font-size: 20px;
                max-width: inherit;
                margin-bottom: 10px;
            }

            .chapter {
                margin-bottom: 10px;
            }

            .chapter-name .name {
                padding: 10px;
                width: 90%;
                border: 1px solid #ebebeb;
                background-color: #f5f5f5;
                border-radius: 6px;
                cursor: pointer;
            }

            .lessons .lesson {
                padding: 10px;
                display: none;
                border-bottom: 1px solid rgba(0, 0, 0, .03);
                width: 90%;
                margin-left: 10px;
            }

            .lesson span a {
                text-decoration: none;
                color: black;
            }

            .lesson span {
                margin-left: 30px;
            }

            .course-target {
                margin-left: 10px;
            }

            .course-introduction {
                margin-top: 130px;
                width: 330px;
                position: fixed;
                right: 12%;
            }

            .course-img img {
                width: 800px;
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

            .course-features {
                list-style-type: none;
                padding: 10px;
                width: 300px;
            }

            .course-review h4 {
                text-align: center;
                margin-top: 10px;
                font-size: 30px;
            }

            .course-review ul li {
                list-style-type: none;
                padding: 10px;
                border-bottom: 1px solid rgba(0, 0, 0, 0.1);
                border-top: 1px solid rgba(0, 0, 0, 0.1);
                padding: 15px 0px;
            }

            li .label {
                font-weight: 500;
                margin-left: 10%;
            }



            .teacher-bx,
            .course-review {
                margin-left: 70px;
            }

            .ti-control-play {
                color: orangered;
            }

            .chapter-name:hover {
                opacity: 0.8;
            }

            .content-title {
                margin-left: 10px;
                margin-bottom: 10px;
            }
            .btn svg {
                margin-right: 3px;
            }
            .btn svg:hover {
                color:white;
            }
            .lesson i {
                margin-right: 10px
            }
            .ti-file {
                color:greenyellow;
            }
            .ti-pencil {
                color: purple;
            }
            .teacher-bx, .course-review {
                width: 99%;
                margin-left: 0px;
            }
            .sub-title {
                display: flex;
                position: relative;
            }
            .continue {
                position: absolute;
                right: 110px;
                top: 0px;
            }
        </style>
    </head>

    <body>
        <div id="myNav" class="overlay" onclick="closeNav()">
        </div>

        <div class="header">
            <div class="logo">
                <img src="assets/images/logoBlack.png" alt="logo">
            </div>
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
                            </svg><a href="editprofile">Profile</a></li>
                        <li><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
                                  d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0z" />
                            <path fill-rule="evenodd"
                                  d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z" />
                            </svg><a href="logout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="body">
            <div class="left-nav">
                <ul>
                    <a href="home">
                        <li class="btn">
                            <svg xmlns="http://www.w3.org/2000/svg"
                                 width="25" height="25" fill="currentColor"
                                 class="bi bi-house" viewBox="0 0 16 16">
                            <path
                                d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293zM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5z" />
                            </svg> 
                        </li></a> <br>
                    <a href="bloglist">
                        <li class="btn">
                            <svg xmlns="http://www.w3.org/2000/svg"
                                 width="25" height="25" fill="currentColor"
                                 class="bi bi-book" viewBox="0 0 16 16">
                            <path
                                d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783" />
                            </svg>
                        </li>
                    </a>
                </ul>
            </div>

            <div class="right-site">
                <div class="course-content">
                    <div class="course-target">
                        <div class="course-name">
                            <h2>${requestScope.course.name}</h2>
                        </div>
                        <div class="course-description">
                            <p>
                                ${requestScope.course.description}                            
                            </p>
                        </div>
                    </div>
                    <div class="content-title">
                        <h2>Content</h2>
                        <div class="sub-title">
                            <div style="margin: 10px 0px 20px 0px;">
                                <span><b>${requestScope.totalChapter}</b> chapters</span><span style="margin: 0px 10px;">&#x2022;</span><span><b>${requestScope.totalLessons}</b> lessons</span>
                            </div>
                            <c:if test="${requestScope.current ne 0}">
                                <div class="continue">
                                    <form action="lesson">
                                        <input type="hidden" name="courseId" value="${param.courseId}">
                                        <input type="hidden" name="lessonId" value="${requestScope.current}">
                                        <button type="submit" class="btn">Continue</button>
                                    </form>
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <div class="list-lesson">
                        <div class="chapters">
                            <c:forEach items="${requestScope.lesson}" var="l" varStatus="loop">
                                <c:set var="c" value="${l.key}" />
                                <c:set var="list" value="${l.value}" />
                                <div class="chapter">
                                    <div class="chapter-name" onclick="showLessons(this)">
                                        <div class="name"><span style="font-weight: 500;">${loop.count}. ${c.name}</span></div>
                                    </div>
                                    <div class="lessons">
                                        <c:forEach items="${list}" var="lesson">
                                            <div class="lesson">
                                                <span>
                                                    <i class="${lesson.type.typeId eq 1? "ti-control-play": lesson.type.typeId eq 2? "ti-file":"ti-pencil"}"></i>
                                                    <a href="lesson?courseId=${requestScope.course.courseId}&lessonId=${lesson.lessonId}">${lesson.name}</a>
                                                </span>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </c:forEach>                           
                        </div>
                    </div>
                </div>

            </div>
            <div class="course-introduction">
                <div class="course-img">
                    <img src="${requestScope.course.img}" alt="Course Image">
                </div>
                <div class="teacher-bx">
                    <div class="teacher-info">
                        <div class="teacher-thumb">
                            <img src="${requestScope.course.author.img}" alt />
                        </div>
                        <div class="teacher-name">
                            <h5>${requestScope.course.author.name}</h5>
                        </div>
                    </div>
                </div>
                <div class="course-review">
                    <h4>Course overview</h4>
                    <ul class="course-features">
                        <li><i class="ti-stats-up"></i> <span class="label">Skill
                                level</span> <span class="value">${requestScope.course.level.name}</span></li>
                        <li><i class="ti-smallcap"></i> <span class="label">Language</span> <span class="value">${requestScope.course.language.name}</span></li>
                        <li><i class="ti-book"></i> <span class="label">Category</span> <span class="value">${requestScope.course.category.name}</span></li>
                        <li><i class="ti-time"></i> <span class="label">Duration</span> <span class="value">${requestScope.course.duration.name}</span></li>

                    </ul>
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

            function showLessons(chapter) {
                var parent = chapter.parentNode;
                var lessons = parent.querySelector(".lessons").querySelectorAll(".lesson");

                lessons.forEach(function (lesson) {
                    lesson.style.display = lesson.style.display === "block" ? "none" : "block";
                });
            }
        </script>
    </body>

</html>
