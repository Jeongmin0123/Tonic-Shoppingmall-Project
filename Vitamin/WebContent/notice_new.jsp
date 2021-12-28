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
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

   <!--  Humberger Begin -->
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="#"><img src="img/logo.png" alt=""></a>
        </div>
        <div class="humberger__menu__cart">
            <ul>
                <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
            </ul>
            <div class="header__cart__price">item: <span>$150.00</span></div>
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
                <!-- <a href="login.do"><i class="fa fa-user"></i> Login</a> -->
                <mytag:login/>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="active"><a href="./index.html">Home</a></li>
                <li><a href="./shop-grid.html">Shop</a></li>
                <li><a href="#">Pages</a>
                    <ul class="header__menu__dropdown">
                        <li><a href="shop_grid.do">전체상품</a></li> 
                        <li><a href="shop_grid.do">종합비타민</a></li>
                        <li><a href="shop_grid.do">유산균</a></li>
                        <li><a href="shop_grid.do">눈건강</a></li>   
                    </ul>
                </li>
                <li><a href="notice.not">공지사항</a></li>
                <li><a href="contact.con">고객센터</a></li>
                <c:if test="${mid == 'admin'}">
              		<li><a href="register.jsp">상품등록</a></li>
              	</c:if>
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
    <!-- Humberger End  -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                               <!--  <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
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
                            <!-- <div class="header__top__right__auth">
                                <a href="./login.html"><i class="fa fa-user"></i> Login</a>
                                <a href="./new.html">&nbsp;&nbsp;회원가입</a>
                            </div> -->
                            <mytag:login/>
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
                           <li class="active"><a href="main.do">Home</a></li>
                            <!-- <li><a href="./shop-grid.html">Shop</a></li> -->
                            <li><a href="shop_grid.do">Shop</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="shop_grid.do">전체상품</a></li> 
                                    <li><a href="shop_grid.do">종합비타민</a></li>
                                    <li><a href="shop_grid.do">유산균</a></li>
                                    <li><a href="shop_grid.do">눈건강</a></li>
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
                <!-- <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                            <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                        </ul>
                        <div class="header__cart__price">item: <span>$150.00</span></div>
                    </div>
                </div> -->
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
  <!--   Header Section End  -->
    
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
                        	<li><a href="shop_grid.do">전체상품</a></li>
                            <li><a href="shop_grid.do">종합비타민</a></li>
                            <li><a href="shop_grid.do">유산균</a></li>
                            <li><a href="shop_grid.do">눈건강</a></li>
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

       <!-- wrap 시작 -->
       <div id="wrap">

        <!-- container 시작 -->
        <div id="container">

            <!-- 본문 시작 -->
            <div class="bodytext_area box_inner">
	            
	            		<form action="notice_insert.not" method="post">
	            		
			             	<ul class="bbsview_list">
			                    <li class="bbs_title"><input type="text" name="ntitle"></li>
			                    
			                    <li class="bbs_hit"><input type="text" name="writer" value="관리자" readonly></li>
			                    <li class="bbs_content">
			                        <div class="editor_content">
			                        	<!-- <input type="text" name="ncont"> -->
			                           	<textarea rows="" cols="" name="ncont"></textarea>
			                        </div>
			                    </li>
			                </ul>
		               		<p class="app_content" align="right">
                            	<input type="submit" class="btn_basecolor" value="등록">
                            </p>
		               		
	             		</form>
	             	
             	
             	
             	
             	
             	
             	
                <!-- <p class="btn_line txt_right">
                    <a href="./notice_list.html" class="btn_bbs">목록</a>
                </p> -->
                <!-- <ul class="near_list mt20">
                    <li>
                        <h4 class="prev">이전글</h4><a href="#">공지사항1</a>
                    </li>
                    <li>
                        <h4 class="next">다음글</h4><a href="#">공지사항2</a>
                    </li>
                </ul> -->
            </div>
            <!-- 본문 끝 -->
        </div>
        <!-- container 끝 -->

    </div>
    <!-- wrap 끝 -->

	<!-- Footer Section Begin -->
    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__about__logo">
                            <a href="main.do"><img src="img/logo.png" alt=""></a>
                        </div>
                        <ul>
                            <li>Address: 60-49 Road 11378 New York</li>
                            <li>Tel: +65 11.188.888</li>
                            <li>Email: hello@colorlib.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                    <div class="footer__widget">
                        <h4>판매자 정보</h4> <br>
                        <ul>
                            <li><bold>Company</bold>&nbsp;World 3lass <br><br>
                            <bold>판매자</bold>&nbsp;이상헌 <br><br>
                            <bold>phone</bold>&nbsp;010-1234-1234 <br><br>
                            <bold>Business License</bold>&nbsp;123-45</li>
                        </ul> 
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <h6>Join Our Newsletter Now</h6>
                        <p>Get E-mail updates about our latest shop and special offers.</p>
                        <form action="#">
                            <input type="text" placeholder="Enter your mail">
                            <button type="submit" class="site-btn">Subscribe</button>
                        </form>
                        <div class="footer__widget__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">
                        <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                        <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
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

<script type="text/javascript">
	function noticedel(){
		ans=confirm("정말 삭제하시겠습니까?");
		if(ans==true){
			location.href="notice_delete.not?nidx=${ndata.nidx}";
		}
		else{
			return;
		}
	}
</script>


</body>

</html>