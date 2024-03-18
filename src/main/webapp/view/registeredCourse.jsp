<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
        <style>
            .img_not_found {
                margin-left: 35%;
            }
            .not_found {
                margin-left: 35%;
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
            .profile-content-bx {
                width: fit-content;
            }
            .tab-content {
                width: fit-content;
            }
            .row {
                width: 100%;
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
                <!-- inner page banner -->
                <div class="page-banner ovbl-dark" style="background-image:url(assets/images/banner/banner1.jpg);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">Profile</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="home">Home</a></li>
                            <li>Profile</li>
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
                                    <div class="profile-bx text-center">
                                        <div class="user-profile-thumb">
                                            <img src="${requestScope.user.img}" alt=""/>

                                        </div>
                                        <div class="profile-info">
                                            <h4>${requestScope.user.name}</h4>
                                            <span>${sessionScope.session.email}</span>
                                            <div>d <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${requestScope.user.balance}"/></div>
                                        </div>

                                        <div class="profile-tabnav">
                                            <ul class="nav nav-tabs">
                                                <li class="nav-item">
                                                    <a class="nav-link" href="editprofile"><i class="ti-pencil-alt"></i>Edit Profile</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link active" data-toggle="tab" href="enroll"><i class="ti-book"></i>Courses</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" href="changepassword"><i class="ti-lock"></i>Change Password</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link " href="transaction"><i class="ti-money"></i>Transaction history</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-9 col-md-8 col-sm-12 m-b30">
                                    <div class="profile-content-bx" >
                                        <div class="tab-content">
                                            <div class="tab-pane active">
                                                <div class="profile-head">
                                                    <h3>Enrollment</h3>
                                                </div>
                                                <form action="enroll" method="get" id="enrollForm">
                                                    <input type="hidden" name="page" id="pageIndex" value="1">
                                                    <div>
                                                        <table>
                                                            <tr>
                                                                <td><input type="text" name="dataSearch" placeholder="Enter to search" value="${param.dataSearch}"></td>
                                                                <td>
                                                                    <select name="category"  id="category">
                                                                        <option value="0" ${0 eq param.category?"selected":""}>All category</option>
                                                                        <c:forEach items="${requestScope.category}" var="c">
                                                                            <option value="${c.courseCategoryId}" ${c.courseCategoryId eq param.category?"selected":"" }>${c.name}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                </td>
                                                                <td>From</td>
                                                                <td><input type="date" name="from" value="${param.from}"></td>
                                                                <td>To</td>
                                                                <td><input type="date" name="to" value="${param.to}"></td>
                                                                <td>
                                                                    <span class="input-group-btn">
                                                                        <button type="submit" style="color:white; background-color: black;" class="fa fa-search text-primary"></button>
                                                                    </span>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                    </div>
                                                </form>
                                                <c:if test="${requestScope.course ne null and requestScope.course.size() > 0 }">
                                                    <div style="margin-left: 30px;">
                                                        <div class="row">
                                                            <!-- Show course -->
                                                            <c:if test="${requestScope.course ne null and requestScope.course.size() > 0}">
                                                                <c:forEach items="${requestScope.course}" var="c">
                                                                    <div id="content" class="col-md-4 col-lg-4 col-sm-4 m-b30">
                                                                        <div class="cours-bx" style="height:320px;">
                                                                            <div class="action-box" >
                                                                                <img style="width:300px;height: 200px;object-fit: cover;" src="${c.img}" alt="">
                                                                                <a href="coursecontent?courseId=${c.courseId}" class="btn">JOIN</a>
                                                                            </div>
                                                                            <div class="info-bx text-center">
                                                                                <h5><a href="coursecontent?courseId=${c.courseId}">${c.name}</a></h5>
                                                                                <span>${c.getCategory().getName()}</span>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </c:forEach>
                                                                <!-- Paging -->
                                                                <div class="col-lg-12 m-b20">
                                                                    <div class="pagination-bx rounded-sm gray clearfix">
                                                                        <ul class="pagination">
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

                                                    <div id="paggerbot"></div>         

                                                </c:if>
                                                <c:if test="${requestScope.course eq null or requestScope.course.size() <= 0}">
                                                    <div class="img_not_found">
                                                        <img style="width: 300px;" src="assets/images/404.2 (1).png" alt=""/>
                                                    </div>
                                                    <h3 class="not_found">No course found!</h3>
                                                </c:if>
                                            </div>
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
        <script>
            render('paggerbot', ${requestScope.pageIndex}, ${requestScope.totalPage}, 2, '${requestScope.from}', '${requestScope.to}', '${requestScope.searchValue}', '${requestScope.categoryId}');
            function render(id, pageIndex, totalPage, gap, from, to, searchValue, category) {
                var container = document.getElementById(id);
                if (pageIndex - gap > 1) {
                    container.innerHTML += '<a href="enroll?page=1' + '&from=' + from + '&to=' + to + '&dataSearch=' + searchValue + '&category=' + category + '">First</a> ';
                }
                for (var i = pageIndex - gap; i < pageIndex; i++) {
                    if (i > 0) {
                        container.innerHTML += '<a href="enroll?page=' + i + '&from=' + from + '&to=' + to + '&dataSearch=' + searchValue + '&category=' + category + '">' + i + '</a>';
                    }
                }
                container.innerHTML += '<span>' + pageIndex + '</span>';
                for (var i = pageIndex + 1; i <= pageIndex + gap && i <= totalPage; i++) {
                    container.innerHTML += '<a href="enroll?page=' + i + '&from=' + from + '&to=' + to + '&dataSearch=' + searchValue + '&category=' + category + '">' + i + '</a>';
                }
                if (pageIndex + gap < totalPage) {
                    container.innerHTML += '<a href="enroll?page=' + totalPage + '&from=' + from + '&to=' + to + '&dataSearch=' + searchValue + '&category=' + category + '">Last</a>';
                }
            }
        </script>    
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
    </body>

</html>
