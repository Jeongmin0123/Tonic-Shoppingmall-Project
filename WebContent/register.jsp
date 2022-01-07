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



    <!-- 본문   -->
    <!-- 본문 시작 -->
	<div class="bodytext_area box_inner">
    <!-- 상품등록폼 시작 -->
    <form action="product_insert.pro" class="appForm" method="post" enctype="multipart/form-data">
        <fieldset>
            <!-- 안보이지만 접근성을 위해 넣는다. -->
            <legend>상품등록 양식</legend>
            <ul class="app_list">
                <!-- 이미지 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        상품사진
                    </label>
                    <div class="app_content ">
                        <input type="file" class="w100p" id="name_lbl" name="pimg_src" accept=".jpg,.png">
                    </div>
                </li>
                
                <!-- 분류 -->
                <li class="clear">
                    <span class="tit_lbl">분류</span>
                    <div class="app_content radio_area">
                    	<input type="radio" name="pcode" value="VITA" style="vertical-align:0px" checked>종합비타민
                    	<input type="radio" name="pcode" value="LACT" style="vertical-align:0px">유산균
                    	<input type="radio" name="pcode" value="EYES" style="vertical-align:0px">눈건강
                    </div>
                </li>
                <!-- 브랜드 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        브랜드
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w30p" id="name_lbl" placeholder="제조사를 입력하세요" name="pbrand" required>
                    </div>
                </li>
                <!-- 상품명 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        상품명
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w30p" id="name_lbl" placeholder="상품명 입력하세요" name="pname" required>
                    </div>
                </li>
                <!-- 가격 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        가격
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w30p" id="name_lbl" placeholder="가격을 입력하세요" name="pprice" required>
                    </div>
                </li>
                <!-- 상세정보 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        상세정보
                    </label>
                    <div class="app_content ">
                    	<textarea rows="10" cols="80" id="name_lbl" placeholder="상세정보를 입력하세요" name="pdetail" style="resize:none" required>
                    	</textarea>
                        <!-- <input type="text" class="w100p" id="name_lbl" placeholder="상세정보를 입력하세요" name=""> -->
                    </div>
                </li>
                <!-- 원산지 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        원산지
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w30p" id="name_lbl" placeholder="원산지를 입력하세요" name="porigin" required>
                    </div>
                </li>
                <!-- 유통기한 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        유통기한
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w20p" id="name_lbl" placeholder="유통기한을 입력하세요" name="pperiod" required>
                    </div>
                </li>
                <!-- 제조일자 -->
                <!-- <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        제조일자
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w100p" id="name_lbl" placeholder="제조일자를 입력하세요" name="">
                    </div>
                </li> -->
                <!-- 판매량 -->
                <!-- <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        판매량
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w100p" id="name_lbl" placeholder="0" name="">
                    </div>
                </li> -->
                <!-- 재고량 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        재고량
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w30p" id="name_lbl" placeholder="재고량을 입력하세요" name="pstock" required>
                    </div>
                </li>
            </ul>
            <p class="app_content" align="center">
            	<input type="submit" class="btn_basecolor" value="등록">
            </p>
        </fieldset>
    </form>
    <!-- 상품등록 끝  -->
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