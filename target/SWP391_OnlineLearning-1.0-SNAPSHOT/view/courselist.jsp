
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="en">


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
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
        <style>
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
            .img_not_found {
                margin-left: 40%;
            }
            .not_found {
                margin-left:40%;
            }
        </style>
    </head>

    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>
            <!-- Header Top ==== -->
            <jsp:include page="publicheader.jsp"/>
            <!-- header END ==== -->
            <!-- Content -->
            <div class="page-content bg-white">
                <div class="page-banner ovbl-dark" style="background-image:url(assets/images/banner/banner3.jpg);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">Our Courses</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <% String home = request.getContextPath() + "/home"; %>
                        <ul class="list-inline">
                            <li><a href="<%= home%>">Home</a></li>
                            <li>Our Courses</li>
                        </ul>
                    </div>
                </div>
                <!-- Breadcrumb row END -->
                <!-- inner page banner END -->
                <div class="content-block">
                    <!-- About Us -->
                    <div class="section-area section-sp1">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-3 col-md-4 col-sm-12 m-b30">
                                    <form action="courselist" method="get">
                                        <div class="widget courses-search-bx placeani">
                                            <!-- Search by name -->
                                            <label>Search Courses</label>
                                            <input name="name" type="text" class="form-control" value="${param.name}">
                                            <!-- Sort by date -->
                                            <label for="sort">Sort By:</label>
                                            <select name="sort" id="sort">
                                                <option value="0" ${param.sort eq '0' ? 'selected' : ''}>Recently</option>
                                                <option value="1" ${param.sort eq '1' ? 'selected' : ''}>Latest</option>
                                            </select>
                                            <!-- Search by category -->
                                            <label for="coursecategory">Course Category:</label>
                                            <select name="ccid" id="ccid">
                                                <option value="0" ${param.ccid eq '0' ? 'selected' : ''}>All Category</option>
                                                <c:forEach items="${requestScope.category}" var="category">
                                                    <option value="${category.courseCategoryId}" ${param.ccid eq category.courseCategoryId ? 'selected' : ''}>${category.name}</option>
                                                </c:forEach>
                                            </select>
                                            <!-- Search by level -->
                                            <label for="level">Level:</label>
                                            <select name="levelid" id="levelid">
                                                <option value="0" ${param.levelid eq '0' ? 'selected' : ''}>All Level</option>
                                                <c:forEach items="${requestScope.level}" var="level">
                                                    <option value="${level.levelId}"} ${param.levelid eq level.levelId ? 'selected' : ''}>${level.name}</option>
                                                </c:forEach>
                                            </select>
                                            <!-- Search by duration -->
                                            <label for="duration">Duration:</label>
                                            <select name="durationid" id="durationid">
                                                <option value="0" ${param.durationid eq '0' ? 'selected' : ''}>All Duration</option>
                                                <c:forEach items="${requestScope.duration}" var="duration">
                                                    <option value="${duration.durationId}"} ${param.durationid eq duration.durationId ? 'selected' : ''}>${duration.name}</option>
                                                </c:forEach>
                                            </select>
                                            <!-- Search by language -->          
                                            <label for="language">Language:</label>
                                            <select name="languageid" id="languageid">
                                                <option value="0" ${param.languageid eq '0' ? 'selected' : ''}>All Language</option>
                                                <c:forEach items="${requestScope.language}" var="language">
                                                    <option value="${language.languageId}"} ${param.languageid eq language.languageId ? 'selected' : ''}>${language.name}</option>
                                                </c:forEach>
                                            </select>

                                            <!-- Submit button -->
                                            <br>
                                            <button type="submit" id="searchButton" > Search</button>
                                        </div>
                                    </form>

                                </div>

                                <div class="col-lg-9 col-md-8 col-sm-12">
                                    <div class="row">
                                        <!-- Show course -->
                                        <c:if test="${requestScope.course ne null and requestScope.course.size() > 0}">
                                            <c:forEach items="${requestScope.course}" var="c">
                                                <div id="content" class="col-md-6 col-lg-4 col-sm-6 m-b30">
                                                    <div class="cours-bx">
                                                        <div class="action-box">
                                                            <img src="${c.img}" alt="">
                                                            <a href="coursedetail?id=${c.courseId}" class="btn">Read More</a>
                                                        </div>
                                                        <div class="info-bx text-center">
                                                            <div class="course-content">
                                                                <h5><a href="coursedetail?id=${c.courseId}">${c.name}</a></h5>
                                                                <span>${c.getCategory().getName()}</span>
                                                            </div>
                                                        </div>
                                                        <div class="cours-more-info">
                                                            <div class="review">
                                                                <span>LEVEL</span>
                                                                <h5>${c.getLevel().getName()}</h5>
                                                            </div>
                                                            <div class="review">
                                                                <span>Price</span>
                                                                <h5><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${c.price}"/> d</h5>
                                                            </div>

                                                        </div>
                                                    </div>
                                                </div>
                                            </c:forEach>
                                            <!-- Paging -->
                                            <div class="col-lg-12 m-b20">
                                                <div class="pagination-bx rounded-sm gray clearfix">
                                                    <ul class="pagination">
                                                        <div id="pagee"></div>
                                                    </ul>
                                                </div>
                                            </div>
                                        </c:if>
                                        <c:if test="${requestScope.course eq null or requestScope.course.size() <=0 }">
                                            <div class="img_not_found">
                                                <img src="assets/images/404.2 (1).png" alt=""/>
                                            </div>
                                            <h3 class="not_found">No course found matching this keyword!</h3>
                                        </c:if>
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
        <script>
            window.onload = function () {
                var items = document.querySelectorAll('.blog-content');
                var maxHeight = 0;

                items.forEach(function (item) {
                    var itemHeight = item.clientHeight;
                    if (itemHeight > maxHeight) {
                        maxHeight = itemHeight;
                    }
                });

                // Áp d?ng chi?u cao l?n nh?t cho t?t c? các item
                items.forEach(function (item) {
                    item.style.height = maxHeight + 'px';
                });
                var courses = document.querySelectorAll('.course-content');
                var maxHeightCourses = 0;

                courses.forEach(function (course) {
                    var courseHeight = course.clientHeight;
                    if (courseHeight > maxHeightCourses) {
                        maxHeightCourses = courseHeight;
                    }
                });

                courses.forEach(function (course) {
                    course.style.height = maxHeightCourses + 'px';
                });
            };
        </script>
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
        <script src="assets/js/functions.js"></script>
        <script src="assets/js/contact.js"></script>
        <script src='assets/vendors/switcher/switcher.js'></script>
        <script src="js/newjavascript3.js" type="text/javascript"></script>

        <script>
            paging("pagee",${requestScope.pageindex},${requestScope.totalpage}, 2,${requestScope.ccid}, '${requestScope.name}',${requestScope.sort},${requestScope.levelid},${requestScope.durationid},${requestScope.languageid});

            function paging(id, pageindex, totalpage, gap, ccid, name, sort, level, duration, language) {
                var container = document.getElementById(id);

                if (!name) {
                    if (pageindex - gap > 1)
                        container.innerHTML += '<a href="courselist?ccid=' + ccid + '&sort=' + sort + '&levelid=' + level + '&durationid=' + duration + '&languageid=' + language + '&page=1">First</a> ';

                    for (var i = pageindex - gap; i < pageindex; i++)
                        if (i > 0)
                            container.innerHTML += ' <a href="courselist?ccid=' + ccid + '&sort=' + sort + '&levelid=' + level + '&durationid=' + duration + '&languageid=' + language + '&page=' + i + '">' + i + '</a>';

                    container.innerHTML += '<span>' + pageindex + '</span>';

                    for (var i = pageindex + 1; i <= pageindex + gap && i <= totalpage; i++)
                        container.innerHTML += '  <a href="courselist?ccid=' + ccid + '&sort=' + sort + '&levelid=' + level + '&durationid=' + duration + '&languageid=' + language + '&page=' + i + '">' + i + '</a>';

                    if (pageindex + gap < totalpage)
                        container.innerHTML += ' <a href="courselist?ccid=' + ccid + '&sort=' + sort + '&levelid=' + level + '&durationid=' + duration + '&languageid=' + language + '&page=' + totalpage + '">Last</a>';
                } else {
                    if (pageindex - gap > 1)
                        container.innerHTML += '<a href="courselist?ccid=' + ccid + '&name=' + name + '&sort=' + sort + '&levelid=' + level + '&durationid=' + duration + '&languageid=' + language + '&page=1">First</a> ';

                    for (var i = pageindex - gap; i < pageindex; i++)
                        if (i > 0)
                            container.innerHTML += ' <a href="courselist?ccid=' + ccid + '&name=' + name + '&sort=' + sort + '&levelid=' + level + '&durationid=' + duration + '&languageid=' + language + '&page=' + i + '">' + i + '</a>';

                    container.innerHTML += '<span>' + pageindex + '</span>';

                    for (var i = pageindex + 1; i <= pageindex + gap && i <= totalpage; i++)
                        container.innerHTML += '  <a href="courselist?ccid=' + ccid + '&name=' + name + '&sort=' + sort + '&levelid=' + level + '&durationid=' + duration + '&languageid=' + language + '&page=' + i + '">' + i + '</a>';

                    if (pageindex + gap < totalpage)
                        container.innerHTML += ' <a href="courselist?ccid=' + ccid + '&name=' + name + '&sort=' + sort + '&levelid=' + level + '&durationid=' + duration + '&languageid=' + language + '&page=' + totalpage + '">Last</a>';
                }
            }
        </script>
    </body>

</html>


<style>


    /* Phần Phân trang */
    .pagination-bx {
        text-align: center;
        margin-top: 20px;
    }

    .pagination {
        display: inline-block;
        list-style: none;
        padding: 0;
        margin: 0;
    }

    .pagination li {
        display: inline;
        margin-right: 5px;
    }

    .pagination a, .pagination span {
        display: inline-block;
        padding: 10px 15px;
        text-decoration: none;
        color: #333;
        background-color: #fff;
        border: 1px solid #ddd;
        border-radius: 5px;
        transition: background-color 0.3s;
    }

    .pagination a:hover {
        background-color: #337ab7;
        color: #fff;
    }

    .pagination .active {
        background-color: #337ab7;
        color: #fff;
        border: 1px solid #337ab7;
        cursor: default;
    }

    /* Đường link ở cuối trang */
    #pagee {
        clear: both;
        text-align: center;
        margin-top: 20px;
    }

    #pagee a {
        text-decoration: none;
        color: #337ab7;
        font-weight: bold;
    }

    #pagee a:hover {
        text-decoration: underline;
    }
</style>
</body>
</html>
