<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="css/swiper.min.css" type="text/css">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Humberger Begin -->
    <mytag:humberger/>
    <!-- Humberger End -->

    <!-- Header Section Begin -->
    <mytag:header/>
    <!-- Header Section End -->

    <!-- Hero Section Begin -->
    <mytag:herosection/>
    <!-- Hero Section End -->

 	<!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Product register</h2>
                        <div class="breadcrumb__option">                           
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->



    <!-- ??????   -->
    <!-- ?????? ?????? -->
	<div class="bodytext_area box_inner">
    <!-- ??????????????? ?????? -->
    <form action="product_insert.pro" class="appForm" method="post" enctype="multipart/form-data">
        <fieldset>
            <!-- ??????????????? ???????????? ?????? ?????????. -->
            <legend>???????????? ??????</legend>
            <ul class="app_list">
                <!-- ????????? -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        ????????????
                    </label>
                    <div class="app_content ">
                        <input type="file" class="w100p" id="name_lbl" name="pimg_src" accept=".jpg,.png">
                    </div>
                </li>
                
                <!-- ?????? -->
                <li class="clear">
                    <span class="tit_lbl">??????</span>
                    <div class="app_content radio_area">
                    	<input type="radio" name="pcode" value="VITA" style="vertical-align:0px" checked>???????????????
                    	<input type="radio" name="pcode" value="LACT" style="vertical-align:0px">?????????
                    	<input type="radio" name="pcode" value="EYES" style="vertical-align:0px">?????????
                    </div>
                </li>
                <!-- ????????? -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        ?????????
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w30p" id="name_lbl" placeholder="???????????? ???????????????" name="pbrand" required>
                    </div>
                </li>
                <!-- ????????? -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        ?????????
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w30p" id="name_lbl" placeholder="????????? ???????????????" name="pname" required>
                    </div>
                </li>
                <!-- ?????? -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        ??????
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w30p" id="name_lbl" placeholder="????????? ???????????????" name="pprice" required>
                    </div>
                </li>
                <!-- ???????????? -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        ????????????
                    </label>
                    <div class="app_content ">
                    	<textarea rows="10" cols="80" id="name_lbl" placeholder="??????????????? ???????????????" name="pdetail" style="resize:none" required></textarea>
                    </div>
                </li>
                <!-- ????????? -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        ?????????
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w30p" id="name_lbl" placeholder="???????????? ???????????????" name="porigin" required>
                    </div>
                </li>
                <!-- ???????????? -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        ????????????
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w20p" id="name_lbl" placeholder="??????????????? ???????????????" name="pperiod" required>
                    </div>
                </li>
                <!-- ???????????? -->
                <!-- <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        ????????????
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w100p" id="name_lbl" placeholder="??????????????? ???????????????" name="">
                    </div>
                </li> -->
                <!-- ????????? -->
                <!-- <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        ?????????
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w100p" id="name_lbl" placeholder="0" name="">
                    </div>
                </li> -->
                <!-- ????????? -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        ?????????
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w30p" id="name_lbl" placeholder="???????????? ???????????????" name="pstock" required>
                    </div>
                </li>
            </ul>
            <p class="app_content" align="center">
            	<input type="submit" class="btn_basecolor" value="??????">
            </p>
        </fieldset>
    </form>
    <!-- ???????????? ???  -->
</div>

	<!-- Footer Section Begin -->
	<jsp:include page="/footer.jsp"/>
    <!-- Footer Section End -->
    
    
    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>



</body>

</html>