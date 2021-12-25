<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link href="https://fonts
    .googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

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
            <a href="main.do"><img src="img/logo.png" alt=""></a>
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
               <!--  <a href="login.do"><i class="fa fa-user"></i> Login</a> -->
               <mytag:login/>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="active"><a href="main.do">Home</a></li>
                <li><a href="shop_grid.do">Shop</a></li>
                <li><a href="#">Pages</a>
                    <ul class="header__menu__dropdown">
                        <li><a href="shop_grid.do">전체상품</a></li> 
                        <li><a href="shop_grid.do">종합비타민</a></li>
                        <li><a href="shop_grid.do">유산균</a></li>
                        <li><a href="shop_grid.do">눈건강</a></li>                        
                    </ul>
                </li>
                <li><a href="notice.do">공지사항</a></li>
                <li><a href="contact.jsp">고객센터</a></li>
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
                                <!-- <a href="login.jsp"><i class="fa fa-user"></i> Login</a>
                                <a href="new.jsp">&nbsp;&nbsp;회원가입</a> -->
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
                        <a href="main.do"><img src="img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="main.do">Home</a></li>
                            <!-- <li><a href="./shop-grid.html">Shop</a></li> -->
                            <li><a href="shop-grid.do">Shop</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="shop_grid.do">전체상품</a></li>
                                    <li><a href="shop_grid.do">종합비타민</a></li>
                                    <li><a href="shop_grid.do">유산균</a></li>
                                    <li><a href="shop_grid.do">눈건강</a></li>
                                </ul>
                            </li>
                            <li><a href="notice.do">공지사항</a></li>
                            <li><a href="contact.jsp">고객센터</a></li>
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

 	<!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>New</h2>
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
        <!-- 회원가입폼 시작 -->
        <form action="member_insert.mem" class="appForm" method="post">
            <fieldset>
                <!-- 안보이지만 접근성을 위해 넣는다. -->
                <legend>회원가입 입력 양식</legend>
                <p class="info_pilsoo pilsoo_item">필수입력</p>
                <ul class="app_list">
                
					<!-- 아이디 -->
                    <li class="clear">
                        <label for="id_lbl" class="tit_lbl pilsoo_item">
                            아이디
                        </label>
                        <div class="app_content ">
                            <input type="text" class="w40p" id="id_lbl" name="mid" placeholder="아이디를 입력하세요">
                            <!-- 중복확인 처리 필요 	ajax로 하기  -->
	                        <input type="button" value="중복확인" onclick="">
                        </div>
                    </li>
                    
                    <!-- 비밀번호 -->
                    <li class="clear">
                        <label for="pwd_lbl" class="tit_lbl pilsoo_item">
                            비밀번호
                        </label>
                        <div class="app_content ">
                            <input type="password" name="mpw" class="w40p pw" id="pwd_lbl" placeholder="비밀번호를 입력하세요">
                        </div>
                    </li>
                    
                    <!-- 비밀번호 확인 -->
                    <li class="clear">
                        <label for="pwd2_lbl" class="tit_lbl pilsoo_item">
                            비밀번호 확인
                        </label>
                        <div class="app_content ">
                            <input type="password" name="mpw2" class="w40p pw" id="pwd2_lbl" placeholder="비밀번호 확인을 입력하세요">
		                    <p class="alert alert-success w20p" id="alert-success" align="center">비밀번호 일치</p>
		                    <p class="alert alert-danger w20p" id="alert-danger" align="center">비밀번호 불일치</p>
                        </div>
                    </li>
                    <!-- <li>
                    	<p class="alert alert-success w20p" id="alert-success" align="center">비밀번호 일치</p>
		                <p class="alert alert-danger w20p" id="alert-danger" align="center">비밀번호 불일치</p>
                    </li> -->

                    
                    
                    <!-- 이름 -->
                    <li class="clear">
                        <label for="name_lbl" class="tit_lbl pilsoo_item">
                            이름
                        </label>
                        <div class="app_content ">
                            <input type="text" class="w40p" id="name_lbl" placeholder="이름을 입력하세요" name="mname">
                        </div>
                    </li>
                    <!-- 성별 -->
                    <li class="clear">
                        <span class="tit_lbl">성별</span>
                        <div class="app_content radio_area">
                            <input type="radio" class="css-radio" id="mmm_lbl" name="mgender" value="남">
                            <label for="mmm_lbl">남</label>
                            <input type="radio" class="css-radio" id="www_lbl" name="mgender" value="여">
                            <label for="www_lbl">여</label>
                        </div>
                    </li>
                    <!-- 생년월일 -->
                    <li class="clear">
                        <label for="name_lbl" class="tit_lbl">
                            생년월일
                        </label>
                        <div class="app_content ">
                            <input type="text" class="w40p" id="name_lbl" placeholder="생년월일을 입력하세요" name="mbirth">
                        </div>
                    </li>

                    <!-- 주소 -->
                    <li class="clear">
                        <label for="addr_lbl" class="tit_lbl pilsoo_item addr"> 주소 </label>

                        <div class="app_content ">
                            <input type="text" name="maddr_zipcode" class="postcodify_postcode5 w40p" id="name_lbl" placeholder="우편번호" />
                            <input type="button" id="postcodify_search_button" value="검색"/>
                            <input type="text" name=maddr_street class="postcodify_address w70p" id="name_lbl" placeholder="도로명 주소" /><br>
                            <input type="text" name="maddr_detail" class="postcodify_details w70p" id="name_lbl" placeholder="상세 주소" /><br>
                            <input type="text" name="maddr_etc" class="postcodify_extra_info w70p" id="name_lbl" placeholder="참고항목" /><br>
                            <!-- <input type="text" class="w100p" id="name_lbl" placeholder="주소을 입력하세요"> -->
                        </div>
                    </li>

                    <!-- 연락처 -->
                    <li class="clear">
                        <label for="phone_lbl" class="tit_lbl pilsoo_item">
                            연락처
                        </label>
                        <div class="app_content ">
                            <input type="tel" class="w40p" id="phone_lbl" placeholder="휴대폰 '-' 없이 숫자만 입력하세요" name="mtel">
                        </div>
                    </li>
                    <!-- 이메일 -->
                    <li class="clear">
                        <label for="email_lbl" class="tit_lbl pilsoo_item">
                            이메일
                        </label>
                        <div class="app_content email_area">
                            <input type="text" class="w40p" id="email_lbl" placeholder="이매일을 입력하세요" name="memail">
                        </div>
                    </li>
                    
                </ul>
                <p class="app_content" align="center">
                	<input type="submit" class="btn_basecolor" value="회원가입">
                </p>
            </fieldset>
        </form>
        <!-- 회원가입폼  -->
    </div>


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
                        <br>
                        <h4>판매자 정보</h4> <br>
                        <ul>
                            <li>
                                <bold>회사명 : </bold>&nbsp;&nbsp;World 3lass <br>
                                <bold>판매자 : </bold>&nbsp;&nbsp;이상헌 <br>
                                <bold>phone : </bold>&nbsp;&nbsp;010-1234-1234 <br>
                                <bold>사업자번호 : </bold>&nbsp;&nbsp;123-45-67
                            </li>
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
                        <div class="footer__copyright__text">
                            <p>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                Copyright &copy;<script>
                                    document.write(new Date().getFullYear());

                                </script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            </p>
                        </div>
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

    <!-- jQuery와 Postcodify를 로딩한다 -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>

    <!-- "검색" 단추를 누르면 팝업 레이어가 열리도록 설정한다 -->
    <script>
        $(function() {
            $("#postcodify_search_button").postcodifyPopUp();
        });
    </script>
	
	<script type="text/javascript"> 
		$(function(){ $("#alert-success").hide();
		$("#alert-danger").hide(); $("input").keyup(function(){ 
				var pwd1=$("#pwd_lbl").val();
				var pwd2=$("#pwd2_lbl").val(); 
				if(pwd1 != "" || pwd2 != ""){ 
					if(pwd1 == pwd2){ 
						$("#alert-success").show();
						$("#alert-danger").hide(); 
						$("#submit").removeAttr("disabled"); 
					} else {
						$("#alert-success").hide();
						$("#alert-danger").show(); 
						$("#submit").attr("disabled", "disabled");
					} 
				} 
			}); 
		});
	</script>

	
</body>

</html>