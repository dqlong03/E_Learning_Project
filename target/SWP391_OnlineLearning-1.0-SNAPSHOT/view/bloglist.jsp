<%-- 
    Document   : bloglist
    Created on : Jan 12, 2024, 2:04:40 AM
    Author     : quang
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
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
                .not_found {
                    text-align: center;
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
                .img_not_found {
                    text-align: center;
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
                    <div class="page-banner ovbl-dark" style="background-image:url(assets/images/blogslide.jpg);">
                        <div class="container">
                            <div class="page-banner-entry">
                                <h1 class="text-white">Blog List</h1>
                            </div>
                        </div>
                    </div>
                    <!-- Breadcrumb row -->
                    <div class="breadcrumb-row">
                        <% String home = request.getContextPath() + "/home"; %>
                        <div class="container">
                            <ul class="list-inline">
                                <li><a href="<%= home%>">Home</a></li>
                                <li>Blog List</li>
                            </ul>
                        </div>
                    </div>
                    <!-- Breadcrumb row END -->
                    <!-- contact area -->
                    <div class="content-block">
                        <div class="section-area section-sp1">
                            <div class="container">
                                <div class="row">
                                    <!-- Left part start -->
                                    <div class="col-lg-8">
                                        <c:choose>
                                            <c:when test="${fn:length(requestScope.blogDTOs) > 0}">
                                                <c:forEach  items="${requestScope.blogDTOs}" var="b">
                                                    <div class="blog-post blog-md clearfix">
                                                        <div class="ttr-post-media"> 
                                                            <img src="${b.img}" alt="">
                                                        </div>
                                                        <div class="ttr-post-info">
                                                            <ul class="media-post">
                                                                <li><i class="fa fa-calendar"></i> ${b.createdTime}</li>
                                                                <li><i class="fa fa-user"></i> ${b.author.name}</li>
                                                            </ul>
                                                            <h5 class="post-title"><a href="blogdetail?id=${b.blogId}">${b.title}</a></h5>
                                                            <p>${b.quickReview}</p>
                                                            <div class="post-extra">
                                                                <a href="blogdetail?id=${b.blogId}">VIEW MORE</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                                <!-- Pagination start --> 
                                                <div id="pagee"></div>
                                                <!-- Pagination END -->
                                            </c:when>
                                            <c:otherwise>
                                                <div class="img_not_found">
                                                    <img src="assets/images/404.2 (1).png" alt=""/>
                                                </div>
                                                <h3 class="not_found">No blogs found matching this keyword!</h3>
                                            </c:otherwise>
                                        </c:choose>

                                    </div>
                                    <!-- Left part END -->
                                    <!-- Side bar start -->
                                    <div class="col-lg-4 sticky-top">
                                        <div class="widget">
                                            <h6 class="widget-title">Search</h6>
                                            <div class="search-bx style-1">
                                                <form action="bloglist" method="get">
                                                    <div class="input-group">
                                                        <input name="title" class="form-control" placeholder="Enter your title..." type="text" value="${param.title}">
                                                    </div>
                                                    Category: <select name="category">
                                                        <option value="-1" ${param.category eq -1? 'selected':''}>All</option>
                                                        <c:forEach  items="${requestScope.bcdtos}" var="bc">
                                                            <option value="${bc.blogCategoryId}" ${param.category eq bc.blogCategoryId? 'selected':''}>${bc.name}</option>
                                                        </c:forEach>
                                                    </select>
                                                    Sort by time: <select name="orderTime">
                                                        <option value="1" ${param.orderTime eq 1? 'selected':''}>Latest</option>
                                                        <option value="-1"${param.orderTime eq -1? 'selected':''}>Oldest</option>
                                                    </select>
                                                    <span class="input-group-btn">
                                                        <button type="submit" class="fa fa-search text-primary"></button>
                                                    </span> 
                                                </form>
                                            </div>
                                        </div>
                                        <div class="widget recent-posts-entry">
                                            <h6 class="widget-title">Recent Blogs</h6>
                                            <div class="widget-post-bx">
                                                <c:forEach  items="${requestScope.bdtos}" var="rcb">
                                                    <div class="widget-post clearfix">
                                                        <div class="ttr-post-media"> <img src="${rcb.img}" width="200" height="143" alt=""> </div>
                                                        <div class="ttr-post-info">
                                                            <div class="ttr-post-header">
                                                                <h6 class="post-title"><a href="blogdetail?id=${rcb.blogId}">${rcb.title}</a></h6>
                                                            </div>
                                                            <ul class="media-post">
                                                                <li><i class="fa fa-calendar"></i> ${rcb.createdTime}</li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Side bar END -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Content END-->
                <!-- Footer ==== -->
                <jsp:include page="publicfooter.jsp"/>
                <!-- Footer END ==== -->
                <!-- scroll top button -->
                <button class="back-to-top fa fa-chevron-up" ></button>
            </div>
            <!-- External JavaScripts -->
            <script>
                render('pagee',${requestScope.pageIndex},${requestScope.numberOfPageBlog}, 2, ${requestScope.orderTime}, '${requestScope.title}',${requestScope.categoryId});
                function render(id, pageindex, totalpage, gap, orderTime, title, categoryId) {
                    var container = document.getElementById(id);
                    if (pageindex - gap > 1)
                        container.innerHTML += '<a href="bloglist?orderTime=' + orderTime + '&title=' + title + '&category=' + categoryId + '&pageIndex=1">First</a> ';

                    for (var i = pageindex - gap; i < pageindex; i++)
                        if (i > 0)
                            container.innerHTML += ' <a href="bloglist?orderTime=' + orderTime + '&title=' + title + '&category=' + categoryId + '&pageIndex=' + i + '">' + i + '</a>';

                    container.innerHTML += '<span>' + pageindex + '</span>';

                    for (var i = pageindex + 1; i <= pageindex + gap && i <= totalpage; i++)
                        container.innerHTML += '  <a href="bloglist?orderTime=' + orderTime + '&title=' + title + '&category=' + categoryId + '&pageIndex=' + i + '">' + i + '</a>';

                    if (pageindex + gap < totalpage)
                        container.innerHTML += ' <a href="bloglist?orderTime=' + orderTime + '&title=' + title + '&category=' + categoryId + '&pageIndex=' + totalpage + '">Last</a>';
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

