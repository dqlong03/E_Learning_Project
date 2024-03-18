<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
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

            .logo a {
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

            /*      .row {
                     position: absolute;
                     top: 15vh;
                     display: flex;
                     justify-content: center;
                     align-items: center;
                     margin-left: 50px;
                  }*/
            .row{
                margin: 20px;
            }
            .box {
                padding: 15px;
                border-radius: 7px;
                background-color: white;
                width: 300px;
                margin-right: 40px;
            }

            .box-body-header {
                display: flex;
                position: relative;
            }

            .box-body-header .symbol {
                position: absolute;
                right: 10px;
                color: green;
                font-size: 20px;
            }

            .box-body-content {
                padding-top: 35px;
            }

            /*      #incomeChart {
                     width: 800px !important;
                     height: 500px !important;
                  }*/

            #enrollChart {
                width: 550px !important;
                height: 230px !important;
                color: #f7b205;
            }

            #user-registeration {
                width: 550px !important;
                height: 230px !important;
                color: #f7b205;
            }

            .imcome-chart {
                margin-right: 50px;
                margin-top: 20px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
                width: fit-content;
                border-radius: 5px;
                padding: 10px;
                /* background-color: #4c1864; */
            }

            .chart-area {
                display: flex;
                justify-content: center;
            }

            .enroll-chart{
                margin-left: 3%;
                background-color: #fff;
                box-shadow:0 3px 10px 0px rgba(0,0,0,.08);
                border-radius: 4px;
                height: fit-content;
            }
            .enroll-chart .upper-chart{
                margin-bottom: 20px;
            }
            .enroll-chart .upper-chart .wc-title h4{
                padding: 15px 15px;
                border-bottom:1px solid rgba(0,0,0,0.05);
                font-size:16px;
                line-height:18px;
                margin:0;
                color:#333;
                font-weight:500;
            }

            .enroll-chart .lower-chart .wc-title h4{
                padding: 15px 15px;
                border-bottom:1px solid rgba(0,0,0,0.05);
                font-size:16px;
                line-height:18px;
                margin:0;
                color:#333;
                font-weight:500;
            }
            .view-more-btn {
                margin-left: auto; /* Di chuy?n nút v? phía bên ph?i */
                display: inline-block; /* Hi?n th? nút trên cùng c?a div cha */
                margin-top: -5px; /* ?i?u ch?nh ?? l?ch gi?a nút và tiêu ?? */
                padding: 5px 10px; /* ?i?u ch?nh ?? l?ch và ?? l?n c?a nút */
                background-color: #007bff; /* Màu n?n c?a nút */
                color: #fff; /* Màu ch? c?a nút */
                border: none; /* Lo?i b? ???ng vi?n c?a nút */
                cursor: pointer; /* Bi?n con tr? thành hình tay khi di chu?t qua nút */
            }

            .not_found {
                text-align: center;
            }
            #paging {
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 10px;
                background-color: #f2f2f2;
            }

            #paging a {
                color: #333;
                padding: 8px 12px;
                margin: 0 5px;
                text-decoration: none;
                border: 1px solid #ddd;
                border-radius: 4px;
                display: inline-block;
                cursor: pointer;
            }

            #paging a span {
                display: inline-block;
            }

            #paging a:hover {
                background-color: #ddd;
            }
            .img_not_found {
                text-align: center;
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
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="../adminassets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="../adminassets/js/html5shiv.min.js"></script>
        <script src="../adminassets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="../adminassets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="../adminassets/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="../adminassets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="../adminassets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="../adminassets/css/style.css">
        <link rel="stylesheet" type="text/css" href="../adminassets/css/dashboard.css">

        <link href="../assets/css/sort.css" rel="stylesheet" type="text/css"/>
        <link class="skin" rel="stylesheet" type="text/css" href="../adminassets/css/color/color-1.css">
        <style>
            .search-btn{
                position: relative;
            }
            #export-btn{
                position: absolute;
                right: 1px;
                top: 1px;
                padding: 10px;
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
            li a {
                padding-left: 0px;
            }
            .info {
                display: flex;
                align-items: center;
            }

            .img-info img {
                width: 40px;
                height: 40px;
                border-radius: 50%;
            }

            .name {
                margin-left: 10px;
            }
        </style>
    </head>

    <body class="ttr-opened-sidebar ttr-pinned-sidebar">
        <div id="myNav" class="overlay" onclick="closeNav()">
        </div>
        <div class="left-sider">
            <div class="logo">
                <a href="../home"><img src="../assets/images/logoBlack.png" alt=""/></a>
            </div>
            <div class="navigator">
                <ul class="list-task">
                    <!-- style này là ?? ?ánh d?u xem cái nào ?ang ???c ch?n -->
                    <li style="background-color: #f7b205;" class="list-item" onmouseover="toWhite(this)" onmouseout="toBlack()">
                        <span class="material-symbols-outlined">tv</span><a>Dashboard</a>
                    </li>
                    <li onclick="goTo('userList')" class="list-item" style="margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">person</span><a href="userList">Users</a></li>

                    <li onclick="goTo('post')" class="list-item" style="margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">post_add</span><a href="post">Posts</a>
                    </li>
                    <li onclick="goTo('slider')" class="list-item" style="margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">sliders</span><a href="slider">Sliders</a>
                    </li>
                    <li onclick="goTo('enrollmentlist')" class="list-item" style="margin-top: -30px;" onmouseover="toWhite(this)" onmouseout="toBlack()"><span class="material-symbols-outlined">how_to_reg</span><a href="enrollmentlist">Enrollment</a></li>
                </ul>
            </div>
            <div class="logout"><span class="material-symbols-outlined">logout</span><a href="logout">Logout</a></div>
        </div>


        <!-- Xoa tu cho nay -->
        <div class="right-sider">
            <div class="header" style="height: 10vh">
                <div class="title"><span>DASHBOARD</span></div>
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

            <div class="breadcrumb-row">
                <% String report = request.getContextPath() + "/dashboard/report"; %>
                <div class="container" style="margin-left:10px">
                    <ul class="list-inline">
                        <li><a href="<%= report%>">Dashboard</a></li>
                        <li>Course Registration Stats</li>
                    </ul>
                </div>
            </div>
            <div class="row" style="margin: 20px">
                <!-- Your Profile Views Chart -->
                <div class="col-lg-2 m-b30">

                </div>
                <div class="col-lg-8 m-b30">
                    <div class="widget-box">
                        <div class="wc-title">
                            <h4>Course registration</h4>                               
                        </div>
                        <div class="widget-inner">
                            <div class="search-btn" style="margin-bottom: 20px" >
                                <form method="get" action="courseregistrationStats"">
                                    From: <input type="date" name="from" value="${requestScope.from}">
                                    To: <input type="date" name="to" value="${requestScope.to}">
                                    Total registration: ${requestScope.totalRegistration}
                                    <input class="btn" type="submit" value="View" style="margin-left: 1rem">
                                </form>
                                <button id="export-btn" class="btn">Export</button>
                            </div>
                            <c:if test="${requestScope.registrationList.size()>0 and requestScope.registrationList ne null}">       
                                <table border="1px" class="table-sortable">
                                    <thead>
                                        <tr>
                                            <th style="text-align: center">No</th>
                                            <th style="text-align: center">Email</th>
                                            <th style="text-align: center">Course Name</th>
                                            <th style="text-align: center">Registered Date</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.registrationList}" var="r">
                                            <c:set var="i" value="${i+1}"></c:set>
                                                <tr>
                                                    <td>${i + requestScope.pageSize*(requestScope.pageIndex-1)}</td>
                                                <td>${r.user.account.email}</td>
                                                <td>${r.course.name}</td>
                                                <td>${r.createdTime}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>

                                </table>
                                <div id="paging"></div>
                            </c:if>
                            <c:if test="${requestScope.registrationList eq null or requestScope.registrationList.size() <= 0}">
                                <div class="img_not_found">
                                    <img style="width: 300px;" src="../assets/images/404.2 (1).png" alt=""/>
                                </div>
                                <h3 class="not_found">No course registration found!</h3>
                            </c:if>
                        </div>
                    </div>

                </div>
                <div class="col-lg-2 m-b30">

                </div>
                <table border="1px" id="courseRegistration_table" style="display: none">
                    <thead>
                        <tr>
                            <th style="text-align: center">No</th>
                            <th style="text-align: center">Email</th>
                            <th style="text-align: center">Course Name</th>
                            <th style="text-align: center">Registered Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.allCourseRegistrationList}" var="r">
                            <c:set var="j" value="${j+1}"></c:set>
                                <tr>
                                    <td>${j}</td>
                                <td>${r.user.account.email}</td>
                                <td>${r.course.name}</td>
                                <td>${r.createdTime}</td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>                           
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

        function goTo(url) {
            window.location = url;
        }

        function closeNav() {
            document.getElementById("myNav").style.width = "0%";
            var dropdown = document.getElementById("dropdownList");

            dropdown.style.display = "none";
        }
    </script>
    <script>
        var btnXlsx = document.getElementById('export-btn');

        btnXlsx.onclick = () => exportData('xlsx')

        function exportData(type) {
            const fileName = 'courseRegistration-sheet.' + type
            const courseRegistration_table = document.getElementById("courseRegistration_table")
            const wb = XLSX.utils.table_to_book(courseRegistration_table)
            XLSX.writeFile(wb, fileName)
        }
    </script>
    <script>
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
        renderPaging('paging',${requestScope.pageIndex},${requestScope.totalPage}, 2, '${requestScope.from}', '${requestScope.to}');
        function renderPaging(id, pageIndex, totalPage, gap, from, to) {
            var container = document.getElementById(id);
            if (pageIndex - gap > 1) {
                container.innerHTML += '<a href="courseregistrationStats?pageIndex=1' + '&from=' + from + '&to=' + to + '">First</a> ';
            }
            for (var i = pageIndex - gap; i < pageIndex; i++) {
                if (i > 0) {
                    container.innerHTML += '<a href="courseregistrationStats?pageIndex=' + i + '&from=' + from + '&to=' + to + '">' + i + '</a>';
                }
            }
            container.innerHTML += '<span>' + pageIndex + '</span>';
            for (var i = pageIndex + 1; i <= pageIndex + gap && i <= totalPage; i++) {
                container.innerHTML += '<a href="courseregistrationStats?pageIndex=' + i + '&from=' + from + '&to=' + to + '">' + i + '</a>';
            }
            if (pageIndex + gap < totalPage) {
                container.innerHTML += '<a href="courseregistrationStats?pageIndex=' + totalPage + '&from=' + from + '&to=' + to + '">Last</a>';
            }
        }

    </script>

    <!-- hai script nay de ve bieu do -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        const ctx = document.getElementById('incomeChart');

        new Chart(ctx, {
            type: 'line',
            data: {
                labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'July', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                datasets: [{
                        label: 'Income',
                        data: [12, 19, 3, 5, 2, 3, 12, 19, 3, 5, 2, 3],
                        borderWidth: 1,
                        borderColor: '#4c1864',
                        backgroundColor: '#4c1864'

                    }]
            },
            options: {
                legend: {
                    labels: {
                        fontColor: "white",
                        fontSize: 18
                    }
                },
                scales: {

                    x: {
                        grid: {
                            drawOnChartArea: false,
                        },
                        ticks: {
                            fontColor: "green",
                            fontSize: 18,
                            stepSize: 1,
                            beginAtZero: true
                        }

                    },
                    y: {
                        beginAtZero: true,
                        // grid: {
                        //    drawOnChartArea: false
                        // }
                    },
                }
            }
        });
    </script>
    <script>
        const enroll = document.getElementById('enrollChart');

        new Chart(enroll, {
            type: 'bar',
            data: {
                labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
                datasets: [{
                        label: 'New people enroll',
                        data: [12, 19, 3, 5, 2, 3, 10],
                        borderWidth: 2,
                        borderColor: '#f7b205',
                        backgroundColor: '#f7b205',
                        barPercentage: 0.2,
                        categoryPercentage: 1
                    }]
            },
            options: {
                indexAxis: 'x',
                scales: {
                    x: {
                        grid: {
                            drawOnChartArea: false
                        }
                    },
                    y: {
                        beginAtZero: true,
                        // grid: {
                        //    drawOnChartArea: false
                        // }
                    },
                    barPercentage: 0.4

                }
            }
        });
    </script>

    <script>
        const registeration = document.getElementById('user-registeration');

        new Chart(registeration, {
            type: 'bar',
            data: {
                labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
                datasets: [{
                        label: 'New people enroll',
                        data: [12, 19, 3, 5, 2, 3, 10],
                        borderWidth: 2,
                        borderColor: '#f7b205',
                        backgroundColor: '#f7b205',
                        barPercentage: 0.2,
                        categoryPercentage: 1
                    }]
            },
            options: {
                indexAxis: 'x',
                scales: {
                    x: {
                        grid: {
                            drawOnChartArea: false
                        }
                    },
                    y: {
                        beginAtZero: true,
                        // grid: {
                        //    drawOnChartArea: false
                        // }
                    },
                    barPercentage: 0.4
                }
            }
        });
    </script>
    <script src="../assets/js/sort.js" type="text/javascript"></script>
    <script src="../assets/js/sheet.js" type="text/javascript"></script>
</body>

</html>