<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>E-Learning : Education & Course</title>

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
                            <li><a href="#">Home</a></li>
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
                                            <img src="${imageData}" alt=""/>

                                        </div>
                                        <div class="profile-info">
                                            <h4>${requestScope.user.name}</h4>
                                            <span>${sessionScope.session.email}</span>
                                            <div>d <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${requestScope.user.balance}"/></div>
                                        </div>

                                        <div class="profile-tabnav">
                                            <ul class="nav nav-tabs">
                                                <li class="nav-item">
                                                    <a class="nav-link active" data-toggle="tab" href="EditProfile"><i class="ti-pencil-alt"></i>Edit Profile</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" data-toggle="tab" href="#courses"><i class="ti-book"></i>Courses</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" data-toggle="tab" href="#quiz-results"><i class="ti-bookmark-alt"></i>Quiz Results </a>
                                                </li>

                                                <li class="nav-item">
                                                    <a class="nav-link" href="changepassword"><i class="ti-lock"></i>Change Password</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link" data-toggle="tab" href="#transaction-history"><i class="ti-money"></i>Transaction history</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-9 col-md-8 col-sm-12 m-b30">
                                    <div class="profile-content-bx">
                                        <div class="tab-content">
                                            <div class="tab-pane active">
                                                <div class="profile-head">
                                                    <h3>Edit Profile</h3>
                                                </div>
                                                <form class="edit-profile" action="editprofile" method="post" enctype="multipart/form-data">
                                                    <div class="">
                                                        <div class="user-profile-thumb">
                                                            <img src="${imageData}" alt="" id="imagePreview" onclick="triggerFileInput()"/>
                                                            <input type="file" name="imageFile" accept="image/*" style="display: none" id="uploadInput" onchange="uploadImage(event)">
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label" for="name">Full Name</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <!--														<input class="form-control" type="text" value="Mark Andre">-->
                                                                <input type="text" id="name" name="name" value="${requestScope.user.name}" pattern="^[a-zA-Z ]+$" title="Invalid namer" required>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label" for="gender">Gender:</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <!--														<input class="form-control" type="text" value="CTO">-->
                                                                <input type="radio" id="male" name="gender" value="Male" required
                                                                       <c:if test="${requestScope.user.gender}">
                                                                           checked="checked"
                                                                       </c:if>
                                                                       >
                                                                <label for="male">Male</label>
                                                                <input style="margin-left: 10px" type="radio" id="female" name="gender" value="Female"
                                                                       <c:if test="${!requestScope.user.gender}">
                                                                           checked="checked"
                                                                       </c:if>
                                                                       >
                                                                <label for="female">Female</label>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label" for="dob">Date of Birth:</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <!--														<input class="form-control" type="text" value="EduChamp">-->
                                                                <input class="form-control" type="date" id="dob" name="dob" value="${requestScope.user.dob}" required>
                                                            </div>
                                                        </div>
                                                        <div class="form-group row" for="phoneNumber">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label" for="phoneNumber">Phone No.</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <!--														<input class="form-control" type="text" value="+120 012345 6789">-->
                                                                <input class="form-control" type="text" id="phoneNumber" name="phoneNumber" value="${requestScope.user.phone}" pattern="^0\d{9}$" title="Wrong phone number" required>
                                                            </div>
                                                        </div>

                                                        <div class="seperator"></div>


                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label" for="address">Address</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <!--														<input class="form-control" type="text" value="5-S2-20 Dummy City, UK">-->
                                                                <input class="form-control" type="text" id="address" name="address" value="${requestScope.user.address}">
                                                            </div>
                                                        </div>

                                                        <div class="form-group row">
                                                            <label class="col-12 col-sm-3 col-md-3 col-lg-2 col-form-label" for="postcode">Postcode</label>
                                                            <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                <!--														<input class="form-control" type="text" value="000702">-->
                                                                <input class="form-control" type="text" id="postcode" name="postcode" value="${requestScope.user.postCode}" pattern="^[0-9]{6}$" title="Invalid postcode" >
                                                            </div>
                                                        </div>
                                                        <input type="hidden" value="${requestScope.imageData}" name="data">

                                                        <div class="m-form__seperator m-form__seperator--dashed m-form__seperator--space-2x"></div>

                                                    </div>
                                                    <div class="">
                                                        <div class="">
                                                            <div class="row">
                                                                <div class="col-12 col-sm-3 col-md-3 col-lg-2">
                                                                </div>
                                                                <div class="col-12 col-sm-9 col-md-9 col-lg-7">
                                                                    <button type="submit" class="btn">Save changes</button>
                                                                    <button type="reset" class="btn-secondry">Cancel</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>

                                            <div class="tab-pane" id="courses">
                                                <div class="profile-head">
                                                    <h3>My Courses</h3>
                                                    <div class="feature-filters style1 ml-auto">
                                                        <ul class="filters" data-toggle="buttons">
                                                            <li data-filter="" class="btn active">
                                                                <input type="radio">
                                                                <a href="#"><span>All</span></a> 
                                                            </li>
                                                            <li data-filter="publish" class="btn">
                                                                <input type="radio">
                                                                <a href="#"><span>Publish</span></a> 
                                                            </li>
                                                            <li data-filter="pending" class="btn">
                                                                <input type="radio">
                                                                <a href="#"><span>Pending</span></a> 
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="courses-filter">
                                                    <div class="clearfix">
                                                        <ul id="masonry" class="ttr-gallery-listing magnific-image row">
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 publish">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic1.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
                                                                    </div>
                                                                    <div class="cours-more-info">
                                                                        <div class="review">
                                                                            <span>3 Review</span>
                                                                            <ul class="cours-star">
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                            </ul>
                                                                        </div>
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 pending">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic2.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
                                                                    </div>
                                                                    <div class="cours-more-info">
                                                                        <div class="review">
                                                                            <span>3 Review</span>
                                                                            <ul class="cours-star">
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                            </ul>
                                                                        </div>
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 publish">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic3.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
                                                                    </div>
                                                                    <div class="cours-more-info">
                                                                        <div class="review">
                                                                            <span>3 Review</span>
                                                                            <ul class="cours-star">
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                            </ul>
                                                                        </div>
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 pending">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic4.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
                                                                    </div>
                                                                    <div class="cours-more-info">
                                                                        <div class="review">
                                                                            <span>3 Review</span>
                                                                            <ul class="cours-star">
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                            </ul>
                                                                        </div>
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 publish">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic5.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
                                                                    </div>
                                                                    <div class="cours-more-info">
                                                                        <div class="review">
                                                                            <span>3 Review</span>
                                                                            <ul class="cours-star">
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                            </ul>
                                                                        </div>
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 pending">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic6.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
                                                                    </div>
                                                                    <div class="cours-more-info">
                                                                        <div class="review">
                                                                            <span>3 Review</span>
                                                                            <ul class="cours-star">
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                            </ul>
                                                                        </div>
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 publish">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic7.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
                                                                    </div>
                                                                    <div class="cours-more-info">
                                                                        <div class="review">
                                                                            <span>3 Review</span>
                                                                            <ul class="cours-star">
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                            </ul>
                                                                        </div>
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 book">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic8.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
                                                                    </div>
                                                                    <div class="cours-more-info">
                                                                        <div class="review">
                                                                            <span>3 Review</span>
                                                                            <ul class="cours-star">
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                            </ul>
                                                                        </div>
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                            <li class="action-card col-xl-4 col-lg-6 col-md-12 col-sm-6 publish">
                                                                <div class="cours-bx">
                                                                    <div class="action-box">
                                                                        <img src="assets/images/courses/pic9.jpg" alt="">
                                                                        <a href="#" class="btn">Read More</a>
                                                                    </div>
                                                                    <div class="info-bx text-center">
                                                                        <h5><a href="#">Introduction EduChamp – LMS plugin</a></h5>
                                                                        <span>Programming</span>
                                                                    </div>
                                                                    <div class="cours-more-info">
                                                                        <div class="review">
                                                                            <span>3 Review</span>
                                                                            <ul class="cours-star">
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                                <li><i class="fa fa-star"></i></li>
                                                                            </ul>
                                                                        </div>
                                                                        <div class="price">
                                                                            <del>$190</del>
                                                                            <h5>$120</h5>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane" id="quiz-results">
                                                <div class="profile-head">
                                                    <h3>Quiz Results</h3>
                                                </div>
                                                <div class="courses-filter">
                                                    <div class="row">
                                                        <div class="col-md-6 col-lg-6">
                                                            <ul class="course-features">
                                                                <li><i class="ti-book"></i> <span class="label">Lectures</span> <span class="value">8</span></li>
                                                                <li><i class="ti-help-alt"></i> <span class="label">Quizzes</span> <span class="value">1</span></li>
                                                                <li><i class="ti-time"></i> <span class="label">Duration</span> <span class="value">60 hours</span></li>
                                                                <li><i class="ti-stats-up"></i> <span class="label">Skill level</span> <span class="value">Beginner</span></li>
                                                                <li><i class="ti-smallcap"></i> <span class="label">Language</span> <span class="value">English</span></li>
                                                                <li><i class="ti-user"></i> <span class="label">Students</span> <span class="value">32</span></li>
                                                                <li><i class="ti-check-box"></i> <span class="label">Assessments</span> <span class="value">Yes</span></li>
                                                            </ul>
                                                        </div>
                                                        <div class="col-md-6 col-lg-6">
                                                            <ul class="course-features">
                                                                <li><i class="ti-book"></i> <span class="label">Lectures</span> <span class="value">8</span></li>
                                                                <li><i class="ti-help-alt"></i> <span class="label">Quizzes</span> <span class="value">1</span></li>
                                                                <li><i class="ti-time"></i> <span class="label">Duration</span> <span class="value">60 hours</span></li>
                                                                <li><i class="ti-stats-up"></i> <span class="label">Skill level</span> <span class="value">Beginner</span></li>
                                                                <li><i class="ti-smallcap"></i> <span class="label">Language</span> <span class="value">English</span></li>
                                                                <li><i class="ti-user"></i> <span class="label">Students</span> <span class="value">32</span></li>
                                                                <li><i class="ti-check-box"></i> <span class="label">Assessments</span> <span class="value">Yes</span></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>


                                            <div class="tab-pane" id="transaction-history">
                                                <div class="profile-head">
                                                    <h3>Transaction history</h3>
                                                </div>

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
            <script>
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
        <script src="assets/js/functions.js"></script>
        <script src="assets/js/contact.js"></script>
        <script src='assets/vendors/switcher/switcher.js'></script>
    </body>

</html>
