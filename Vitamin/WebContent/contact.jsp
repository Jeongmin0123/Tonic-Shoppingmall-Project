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
                <!-- <a href="login.jsp"><i class="fa fa-user"></i> Login</a> -->
                <mytag:login/>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="active"><a href="main.do">Home</a></li>
                <li><a href="intro.jsp">Intro</a></li>
                <li><a href="shop_grid.do">Shop</a></li>
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
                <c:if test="${mrole == 'ADMIN'}">
                     <li><a href="register.jsp">상품등록</a></li>
                  </c:if>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <div class="header__top__right__social">
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-linkedin"></i></a>
            <a href="#"><i class="fa fa-pinterest-p"></i></a>
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
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                <a href="#"><i class="fa fa-pinterest-p"></i></a>
                            </div>
                            <div class="header__top__right__language">
                                <img src="img/koera.png" alt="">
                                <div>한국어</div>
                                <!-- <span class="arrow_carrot-down"></span>
                                <ul>
                                    <li><a href="#">Spanis</a></li>
                                    <li><a href="#">English</a></li>
                                </ul> -->
                            </div>
                            <div class="header__top__right__auth">
                                <!-- <a href="login.jsp"><i class="fa fa-user"></i> Login</a>
                                <a href="new.do">&nbsp;&nbsp;회원가입</a> -->
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
                            <li><a href="intro.jsp">Intro</a></li>
                            <li><a href="#">Shop</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="shop-grid.do">전체상품</a></li> 
                                    <li><a href="shop-grid.do">종합비타민</a></li>
                                    <li><a href="shop-grid.do">유산균</a></li>
                                    <li><a href="shop-grid.do">눈건강</a></li>
                                </ul>
                            </li>
                            <li><a href="notice.not">공지사항</a></li>
                            <li><a href="contact.con">고객센터</a></li>
                              <c:if test="${mrole == 'ADMIN'}">
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
                        <h2>Contact Us</h2>
                        <div class="breadcrumb__option">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->




	<c:choose>

		<c:when test="${mrole == 'ADMIN'}">
			
			<div class="bodytext_area box_inner">
                <form action="#" class="minisrch_form">
                    <fieldset>
                        <legend>검색</legend>
                        <input type="text" class="tbox" title="검색어를 입력하세요" placeholder="검색어를 입력하세요">
                        <a href="#" class="btn_srch">검색</a>
                    </fieldset>
                </form>
                <!-- summary : 접근성을 위한 속성 -->
                <table class="bbsListTbl" summary="번호, 제목, 작성자 등을 제공하는 표">
                    <!-- 테이블 제목 -->
                    <caption class="hdd">고객문의 목록</caption>
                    <thead>
                        <tr>
                            <th scope="col">번호</th>
                            <th scope="col">내용</th>
                            <th scope="col">이메일</th>
                        </tr>
                    </thead>
                    <tbody>
                    	
                    	<c:forEach var="v" items="${cdatas}">
                    	
	                        <tr>
	                            <td>${v.msgno}</td>
	                            <td class="tit_notice"><a href="contact_detail.con?msgno=${v.msgno}">${v.msgtext}</a></td>
	                            <td>${v.msgemail}</td>
	                        </tr>
                        
                        </c:forEach>
	                            <!-- <td class="tit_notice"><a href="javascript:showdetails()">test(테스트 후 지우는 부분)</a></td> -->
                    </tbody>
                </table>

                <!-- 페이징처리 -->
                <!-- <div class="npagination">
                    <<
                    <a href="#" class="firstpage pbtn"><img src="./img/btn_firstpage.png" alt="첫 페이지로 이동"></a>
                    <
                    <a href="#" class="prevpage pbtn"><img src="./img/btn_prevpage.png" alt="이전 페이지로 이동"></a>
                    <a href="#"><span class="currentPage pagenum">1</span></a>
                    <a href="#"><span class="pagenum">2</span></a>
                    <a href="#"><span class="pagenum">3</span></a>
                    <a href="#"><span class="pagenum">4</span></a>
                    <a href="#"><span class="pagenum">5</span></a>
                    >
                    <a href="#" class="nextpage pbtn"><img src="./img/btn_nextpage.png" alt="다음 페이지로 이동"></a>
                    >>
                    <a href="#" class="lastpage pbtn"><img src="./img/btn_lastpage.png" alt="마지막 페이지로 이동"></a>
                </div> -->
            </div>
			
		</c:when>

	
		
		<c:otherwise>
		
		    <!-- Contact Section Begin -->
		    <section class="contact spad">
		        <div class="container">
		            <div class="row">
		                <div class="col-lg-3 col-md-3 col-sm-6 text-center">
		                    <div class="contact__widget">
		                        <span class="icon_phone"></span>
		                        <h4>Phone</h4>
		                        <p>+82-1-8888-6868</p>
		                    </div>
		                </div>
		                <div class="col-lg-3 col-md-3 col-sm-6 text-center">
		                    <div class="contact__widget">
		                        <span class="icon_pin_alt"></span>
		                        <h4>Address</h4>
		                        <p>60-49 Road 11378 Seoul</p>
		                    </div>
		                </div>
		                <div class="col-lg-3 col-md-3 col-sm-6 text-center">
		                    <div class="contact__widget">
		                        <span class="icon_clock_alt"></span>
		                        <h4>Open time</h4>
		                        <p>10:00 am to 23:00 pm</p>
		                    </div>
		                </div>
		                <div class="col-lg-3 col-md-3 col-sm-6 text-center">
		                    <div class="contact__widget">
		                        <span class="icon_mail_alt"></span>
		                        <h4>Email</h4>
		                        <p>hello@ogani.com</p>
		                    </div>
		                </div>
		            </div>
		        </div>
		    </section>
		    <!-- Contact Section End -->
		
		    <!-- Map Begin -->
		    <div class="map">
		       <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d50647.46568304649!2d127.03291992056559!3d37.49691167942796!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca4235fb589fb%3A0xb331971bc570bb6a!2z7ISc7Jq47Yq567OE7IucIOqwleuCqOq1rA!5e0!3m2!1sko!2skr!4v1640267479844!5m2!1sko!2skr" width="800" height="600" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
		        <div class="map-inside">
		            <i class="icon_pin"></i>
		            <div class="inside-widget">
		                <h4>GangNam</h4>
		                <ul>
		                    <li>Phone: +12-345-6789</li>
		                    <li>Add: GangNam, Seoul</li>
		                </ul>
		            </div>
		        </div>
		    </div>
		    <!-- Map End -->
		
		    <!-- Contact Form Begin -->
		    <div class="contact-form spad">
		        <div class="container">
		            <div class="row">
		                <div class="col-lg-12">
		                    <div class="contact__form__title">
		                        <h2>Leave Message</h2>
		                    </div>
		                </div>
		            </div>
		            <form action="contact_insert.con" method="post">
		                <div class="row">
		                    <div class="col-lg-6 col-md-6">
		                        <input type="text" placeholder="Your name" name="msgname">
		                    </div>
		                    <div class="col-lg-6 col-md-6">
		                        <input type="text" placeholder="Your Email" name="msgemail">
		                    </div>
		                    <div class="col-lg-12 text-center">
		                        <textarea placeholder="Your message" name="msgtext"></textarea>
		                    </div>
		                </div>               
		                <button type="submit" class="site-btn">SEND MESSAGE</button>
		            </form>
		        </div>
		    </div>
		    <!-- Contact Form End -->

		</c:otherwise>

	</c:choose>


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
    