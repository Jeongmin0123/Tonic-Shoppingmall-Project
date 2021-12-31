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
                <!-- <a href="login.do"><i class="fa fa-user"></i> Login</a> -->
                <mytag:login/>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="active"><a href="intro.jsp">Intro</a></li>
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
              		<li><a href="manage.man">상품관리</a></li>
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
                            	<!-- mdata.mid? mid? mid 세션에 저장하는 변수명에 따라 달라질 예정 -->
                            	<%-- <c:if test="${mid == null}">
	                                <a href="login.do"><i class="fa fa-user"></i> Login</a>
	                                <a href="new.do">&nbsp;&nbsp;회원가입</a>
                            	</c:if> --%>
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
                            <li class="active"><a href="intro.jsp">Intro</a></li>
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
                            <c:if test="${mrole == 'ADMIN'}">
			              		<li><a href="manage.man">상품관리</a></li>
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
                        <h2>My Page</h2>
                        <div class="breadcrumb__option">                           
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->
    
    

    <!-- 본문   -->
    <!-- container 시작 -->
    <div id="container">

        <!-- 본문 시작 -->
        <div class="bodytext_area box_inner">
            <!-- 내정보 틀 시작 -->
            <dl class="myinfo">
                <dt>내 정보</dt>
                <dd>
                    <form action="member_update.mem" method="post" class="regForm">
                    <input type="hidden" name="mno" value="${mdata.mno}">
                         <fieldset>
                            <legend>내 정보 입력 양식</legend>
                            <ul class="reg_list">
                               	<li class="clear">
                                    <span class="tit_lbl">이름</span>
                                    <div class="reg_content"><input type="text" name="mname" class="w20p" value="${mdata.mname}"></div>
                                </li>
                                <li class="clear">
                                    <span class="tit_lbl">성별</span>
                                    <div class="reg_content"><input type="text" name="mgender"  class="w20p" value="${mdata.mgender}"></div>
                                </li>
                                <li class="clear">
                                    <span class="tit_lbl">생년월일</span>
                                    <div class="reg_content"><input type="text" name="mbirth" class="w20p" value="${mdata.mbirth}"></div>
                                </li>
                                <li class="clear">
                                    <span class="tit_lbl">우편번호</span>
                                    <div class="reg_content"><input type="text" name="maddr_zipcode" class="w20p" value="${mdata.maddr_zipcode}"></div>
                                </li>
                                <li class="clear">
                                    <span class="tit_lbl">주소</span>
                                    <div class="reg_content"><input type="text" name="maddr_street" class="w40p" value="${mdata.maddr_street}"></div>
                                </li>
                                <li class="clear">
                                    <span class="tit_lbl">상세주소</span>
                                    <div class="reg_content"><input type="text" name="maddr_detail" class="w40p" value="${mdata.maddr_detail}"></div>
                                </li>
                                <li class="clear">
                                    <span class="tit_lbl">참고항목</span>
                                    <div class="reg_content"><input type="text" name="maddr_etc"  class="w30p" value="${mdata.maddr_etc}"></div>
                                </li>
                                <li class="clear">
                                    <span class="tit_lbl">연락처</span>
                                    <div class="reg_content"><input type="text" name="mtel" class="w20p"  value="${mdata.mtel}"></div>
                                </li>
                                
                                <li class="clear">
                                    <span class="tit_lbl">이메일</span>
                                    <div class="reg_content"><input type="text" name="memail" class="w30p" value="${mdata.memail}"></div>
                                </li>
                            </ul>
                            <!-- <p class="btn_line">
                            </p> -->
                            <p class="app_content" align="center">
                            	<input type="submit" class="btn_basecolor" value="정보수정">
	                            <input type="button" class="btn_basecolor" onclick="memdel()" value="회원탈퇴">
                            </p>
                        </fieldset>
                    </form>
                </dd>
            </dl>
            <!-- 내정보 틀 끝 -->
        </div>
        <!-- 본문 끝 -->
    </div>
    <!-- container 끝 -->

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

<script type="text/javascript">
	function memdel(){
		ans=confirm("정말 회원탈퇴하시겠습니까?");
		if(ans==true){
			mpw = prompt("비밀번호를 입력해주세요.");
			
			
			location.href="member_delete.mem?mid=${mid}&mpw="+mpw;
		}
		else{
			return;
		}
	}
</script>
	
</body>

</html>
    