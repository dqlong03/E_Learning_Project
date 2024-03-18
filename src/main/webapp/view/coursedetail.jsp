<%-- 
    Document   : coursedetail
    Created on : Jan 15, 2024, 8:16:47 AM
    Author     : quang
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <style>
            .loader {
                position: fixed;
                top: 0;
                left: 0;
                width: 100vw;
                height: 100vh;
                display: flex;
                justify-content: center;
                align-items: center;
                background-color: #f7f9fb;
                transition: opacity 0.75s, visibility 0.75s;
            }

            .loader-hidden {
                opacity: 0;
                visibility: hidden;
            }

            .loader::after {
                content: "";
                width: 75px;
                height: 75px;
                border: 15px solid #dddddd;
                border-top-color: #7449f5;
                border-radius: 50%;
                animation: loading 0.75s ease infinite;
            }

            @keyframes loading {
                from {
                    transform: rotate(0turn);
                }
                to {
                    transform: rotate(1turn);
                }
            }
            #searchButton {
                margin-top: 10px;
                background-color: #f7b205;
                color: black;
                border: none;
                border-radius: 4px;
                padding: 10px
            }

            #searchButton:hover {
                background-color: #4c1863;
                color: white;
                opacity: 0.8;
            }
        </style>    
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
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">

    </head>
    <body id="bg">
        <div class="page-wraper">
            <div class="loader" id="loadingContainer">
            </div>
            <!-- Header Top ==== -->
            <jsp:include page="publicheader.jsp"/>
            <!-- header END ==== -->
            <!-- Content -->
            <div class="page-content bg-white">
                <!-- inner page banner -->
                <div class="page-banner ovbl-dark" style="background-image:url(assets/images/banner/banner2.jpg);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">Courses Details</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <% String home = request.getContextPath() + "/home"; %>
                        <% String courselist = request.getContextPath() + "/courselist"; %>
                        <ul class="list-inline">
                            <li><a href="<%= home%>">Home</a></li>
                            <li><a href="<%= courselist%>">Courses list</a></li>
                            <li>Courses Details</li>
                        </ul>
                    </div>
                </div>
                <!-- Breadcrumb row END -->
                <!-- inner page banner END -->
                <div class="content-block">
                    <!-- About Us -->
                    <div class="section-area section-sp1">
                        <div class="container">
                            <div class="row d-flex flex-row-reverse">
                                <div class="col-lg-3 col-md-4 col-sm-12 m-b30">
                                    <div class="course-price">
                                        <h4 class="price"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${cdto.price}" /> d</h4>
                                    </div>	
                                    <div class="course-buy-now text-center">
                                        <a href="pay?courseId=${requestScope.courseId}" class="btn radius-xl text-uppercase">JOIN THIS COURSE</a>
                                    </div>
                                    <div class="teacher-bx">
                                        <div class="teacher-info">
                                            <div class="teacher-thumb">
                                                <img src="${cdto.author.img}" alt=""/>
                                            </div>
                                            <div class="teacher-name">
                                                <h5>${cdto.author.name}</h5>
                                            </div>
                                        </div>
                                    </div>
                                    <div>
                                        <h4>  </h4>
                                        <h4>Course overview</h4>
                                        <ul class="course-features">
                                            <li><i class="ti-stats-up"></i> <span class="label">Skill level</span> <span class="value">${cdto.level.name}</span></li>
                                            <li><i class="ti-smallcap"></i> <span class="label">Language</span> <span class="value">${cdto.language.name}</span></li>
                                            <li><i class="ti-book"></i> <span class="label">Category</span> <span class="value">${cdto.category.name}</span></li>
                                            <li><i class="ti-time"></i> <span class="label">Duration</span> <span class="value">${cdto.duration.name}</span></li>

                                        </ul>
                                    </div>
                                    <div></div>
                                    <div></div>
                                    <div class="widget">
                                        <h6 class="widget-title">Search another course</h6>
                                        <div class="search-bx style-1">
                                            <form action="courselist" method="get">
                                                <div class="widget courses-search-bx placeani">
                                                    <!-- Search by name -->
                                                    <label>Search Courses</label>
                                                    <input name="name" type="text" class="form-control"">
                                                    <!-- Sort by date -->
                                                    <label for="sort">Sort By:</label>
                                                    <select name="sort" id="sort">
                                                        <option value="0">Recently</option>
                                                        <option value="1">Latest</option>
                                                    </select>
                                                    <!-- Search by category -->
                                                    <label for="coursecategory">Course Category:</label>
                                                    <select name="ccid" id="ccid">
                                                        <option value="0" >All Category</option>
                                                        <c:forEach items="${requestScope.category}" var="category">
                                                            <option value="${category.courseCategoryId}">${category.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <!-- Search by level -->
                                                    <label for="level">Level:</label>
                                                    <select name="levelid" id="levelid">
                                                        <option value="0" >All Level</option>
                                                        <c:forEach items="${requestScope.level}" var="level">
                                                            <option value="${level.levelId}"}>${level.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <!-- Search by duration -->
                                                    <label for="duration">Duration:</label>
                                                    <select name="durationid" id="durationid">
                                                        <option value="0" >All Duration</option>
                                                        <c:forEach items="${requestScope.duration}" var="duration">
                                                            <option value="${duration.durationId}"}>${duration.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <!-- Search by language -->          
                                                    <label for="language">Language:</label>
                                                    <select name="languageid" id="languageid">
                                                        <option value="0" >All Language</option>
                                                        <c:forEach items="${requestScope.language}" var="language">
                                                            <option value="${language.languageId}"}>${language.name}</option>
                                                        </c:forEach>
                                                    </select>

                                                    <!-- Submit button -->
                                                    <br>
                                                    <button type="submit" id="searchButton" > Search</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-9 col-md-8 col-sm-12">
                                    <div class="courses-post">
                                        <div class="ttr-post-media media-effect">
                                            <img src="${cdto.img}" alt="">
                                        </div>
                                        <div class="ttr-post-info">
                                            <div class="ttr-post-title ">
                                                <h2 class="post-title">${cdto.name}</h2>
                                                <h2>  </h2>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="courese-overview" id="overview">
                                        <h5 class="m-b5">Course Description</h5>
                                        <h5>  </h5>
                                        <p>${cdto.description}</p>
                                        <h5>  </h5>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <!-- contact area END -->

        </div>
        <!-- Content END-->
        <!-- Footer ==== -->
        <jsp:include page="publicfooter.jsp"/>
        <!-- Footer END ==== -->
        <button class="back-to-top fa fa-chevron-up" ></button>
    </div>
    <!-- External JavaScripts -->
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/vendors/bootstrap/js/popper.min.js"></script>
    <script src="assets/vendors/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
    <script src="assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
    <script src="assets/vendors/magnific-popup/magnific-popup.js"></script>
    <script src="assets/vendors/counter/waypoints-min.js"></script>
    <script src="assets/vendors/counter/counterup.min.js"></script>
    <script src="assets/vendors/imagesloaded/imagesloaded.js"></script>
    <script src="assets/vendors/masonry/masonry.js"></script>
    <script src="assets/vendors/masonry/filter.js"></script>
    <script src="assets/vendors/owl-carousel/owl.carousel.js"></script>
    <script src="assets/js/jquery.scroller.js"></script>
    <script src="assets/js/functions.js"></script>
    <script src="assets/js/contact.js"></script>
    <script>
        window.addEventListener("load", () => {
            const loader = document.querySelector(".loader");
            loader.classList.add("loader-hidden");
            loader.addEventListener("transitioned", () => {
                document.body.removeChild("loader");
            })
        })
    </script>
    <script src="assets/vendors/switcher/switcher.js"></script>
</body>

</html>

