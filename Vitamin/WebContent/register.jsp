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
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="#"><img src="img/logo.png" alt=""></a>
        </div>
        <div class="humberger__menu__widget">
            <div class="header__top__right__language">
                <img src="img/korea.png" alt="">
                <div>한국어</div>
                <!-- <span class="arrow_carrot-down"></span>
                <ul>
                    <li><a href="#">Spanis</a></li>
                    <li><a href="#">English</a></li>
                </ul> -->
            </div>
            <div class="header__top__right__auth">
                <mytag:login/>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="active"><a href="./index.html">Home</a></li>
                <li><a href="./shop-grid.html">Shop</a></li>
                <li><a href="#">Pages</a>
                    <ul class="header__menu__dropdown">
                        <li><a href="./shop-grid.html">전체상품</a></li> 
                        <li><a href="./shop-grid.html">종합비타민</a></li>
                        <li><a href="./shop-grid.html">유산균</a></li>
                        <li><a href="./shop-grid.html">눈건강</a></li>
                        
                    </ul>
                </li>
                <li><a href="./blog.html">Blog</a></li>
                <li><a href="./contact.html">Contact</a></li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <div class="header__top__right__social">
            <a><i class="fa fa-facebook"></i></a>
            <a><i class="fa fa-twitter"></i></a>
            <a><i class="fa fa-linkedin"></i></a>
            <a><i class="fa fa-pinterest-p"></i></a>
        </div>
        <div class="humberger__menu__contact">
            <ul>
                <!-- <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                <li>Free Shipping for all Order of $99</li> -->
            </ul>
        </div>
    </div>
    <!-- Humberger End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                                <!-- <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                                <li>Free Shipping for all Order of $99</li> -->
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__right">
                            <div class="header__top__right__social">
                                <a><i class="fa fa-facebook"></i></a>
                                <a><i class="fa fa-twitter"></i></a>
                                <a><i class="fa fa-linkedin"></i></a>
                                <a><i class="fa fa-pinterest-p"></i></a>
                            </div>
                            <div class="header__top__right__language">
                                <img src="img/korea.png" alt="">
                                <div>한국어</div>
                                <!-- <span class="arrow_carrot-down"></span>
                                <ul>
                                    <li><a href="#">Spanis</a></li>
                                    <li><a href="#">English</a></li>
                                </ul> -->
                            </div>
                            <div class="header__top__right__auth">
                                <mytag:login/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="./index.html"><img src="img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="./index.html">Home</a></li>
                            <!-- <li><a href="./shop-grid.html">Shop</a></li> -->
                            <li><a href="#">Shop</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="./shop-grid.html">전체상품</a></li> 
                                    <li><a href="./shop-grid.html">종합비타민</a></li>
                                    <li><a href="./shop-grid.html">유산균</a></li>
                                    <li><a href="./shop-grid.html">눈건강</a></li>
                                </ul>
                            </li>
                            <li><a href="notice.not">공지사항</a></li>
                            <li><a href="contact.con">고객센터</a></li>
                            <c:if test="${mid == 'admin'}">
			              		<li><a href="register.jsp">상품등록</a></li>
			              	</c:if>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>Shop</span>
                        </div>
                        <ul>
                            <li><a href="./shop-grid.html">전체상품</a></li>
                            <li><a href="./shop-grid.html">종합비타민</a></li>
                            <li><a href="./shop-grid.html">유산균</a></li>
                            <li><a href="./shop-grid.html">눈건강</a></li>
                
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <div class="hero__search__categories">
                                    All Categories
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <input type="text" placeholder="What do yo u need?">
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+65 11.188.888</h5>
                                <span>support 24/7 time</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
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
    <form action="#" class="appForm" method="post">
        <fieldset>
            <!-- 안보이지만 접근성을 위해 넣는다. -->
            <legend>상품등록 양식</legend>
            <!-- <p class="info_pilsoo pilsoo_item">필수입력</p> -->
            <ul class="app_list">
                <!-- 이미지 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        상품사진
                    </label>
                    <div class="app_content ">
                        <input type="file" class="w100p" id="name_lbl" name="">
                    </div>
                </li>
                
                <!-- 상품명 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        상품명
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w100p" id="name_lbl" placeholder="상품명 입력하세요" name="">
                    </div>
                </li>
                <!-- 가격 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        가격
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w100p" id="name_lbl" placeholder="가격을 입력하세요" name="">
                    </div>
                </li>
                <!-- 상세정보 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        상세정보
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w100p" id="name_lbl" placeholder="상세정보를 입력하세요" name="">
                    </div>
                </li>
                <!-- 유통기한 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        유통기한
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w100p" id="name_lbl" placeholder="유통기한을 입력하세요" name="">
                    </div>
                </li>
                <!-- 제조일자 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        제조일자
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w100p" id="name_lbl" placeholder="제조일자를 입력하세요" name="">
                    </div>
                </li>
                <!-- 원산지 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        원산지
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w100p" id="name_lbl" placeholder="원산지를 입력하세요" name="">
                    </div>
                </li>
                <!-- 제조사 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        제조사
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w100p" id="name_lbl" placeholder="제조사를 입력하세요" name="">
                    </div>
                </li>
                
                <!-- 판매량 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        판매량
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w100p" id="name_lbl" placeholder="0" name="">
                    </div>
                </li>

                <!-- 재고량 -->
                <li class="clear">
                    <label for="name_lbl" class="tit_lbl">
                        재고량
                    </label>
                    <div class="app_content ">
                        <input type="text" class="w100p" id="name_lbl" placeholder="재고량을 입력하세요" name="">
                    </div>
                </li>

                <!-- 분류 -->
                <li class="clear">
                    <span class="tit_lbl">분류</span>
                    <div class="app_content radio_area">
                        <input type="radio" class="css-radio" id="mmm_lbl" name="type" value="종합비타민"> 
                        <label for="mmm_lbl">종합비타민</label>

                        <input type="radio" class="css-radio" id="www_lbl" name="type" value="유산균"> 
                        <label for="www_lbl">유산균</label>
                        <!-- 오류 미해결 -->
                        <input type="radio" class="css-radio" id="www_lbl" name="type" value="눈건강"> 
                        <label for="www_lbl">눈건강</label>
                    </div>
                </li>

        
            </ul>
            <p class="btn_line"><a href="#" class="btn_basecolor">등록</a></p>
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