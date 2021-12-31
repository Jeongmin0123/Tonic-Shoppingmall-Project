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

<script type="text/javascript">
   function showdetails(){
      window.open('notice_detail.not?nidx=${v.nidx}','새창으로 회원가입','width=1000, height=500, menubar=no, status=no,toolbar=no');
   }
</script>


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
                           <!--  <div class="header__top__right__auth">
                                <a href="login.do"><i class="fa fa-user"></i> Login</a>
                                <a href="new.do">&nbsp;&nbsp;회원가입</a>
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
                        <a href="main.do"><img src="img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="main.do">Home</a></li>
                            <!-- <li><a href="./shop-grid.html">Shop</a></li> -->
                            <li><a href="intro.jsp">Intro</a></li>
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
                        <h2>Notice</h2>
                        <div class="breadcrumb__option">                           
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->


    <!-- wrap 시작 -->
    <div id="wrap">
        <!-- container 시작 -->
        <div id="container">
            <!-- 본문 시작 -->
            <div class="bodytext_area box_inner">
                <form action="/notice_search.not" class="minisrch_form" method="post">
                    <fieldset>
                        <legend>검색</legend>
                        <input type="text" class="tbox" name="noticsearch" placeholder="검색어를 입력하세요">
                        <input type="submit" class="btn_basecolor btn_srch" value="검색">                        
                        <!-- <a href="/notice_search.not" class="btn_srch">검색</a> -->
                    </fieldset>
                </form>
                <!-- summary : 접근성을 위한 속성 -->
                <table class="bbsListTbl" summary="번호, 제목, 작성자 등을 제공하는 표">
                    <!-- 테이블 제목 -->
                    <caption class="hdd">공지사항 목록</caption>
                    <thead>
                        <tr>
                            <th scope="col">번호</th>
                            <th scope="col">제목</th>
                            <th scope="col">작성자</th>
                        </tr>
                    </thead>
                    <tbody>
                       
                       <c:forEach var="v" items="${ndatas}">
                       
                           <tr>
                               <td>${v.nidx}</td>
                               <td class="tit_notice"><a href="notice_detail.not?nidx=${v.nidx}">${v.ntitle}</a></td>
                               <%-- <td class="tit_notice"><a href="javascript:showdetails()">${v.ntitle}</a></td> --%>
                               <td>${v.writer}</td>
                           </tr>
                        
                        </c:forEach>
                               <!-- <td class="tit_notice"><a href="javascript:showdetails()">test(테스트 후 지우는 부분)</a></td> -->
                    </tbody>
                </table>
                    <c:if test="${mrole == 'ADMIN'}">
                       <p class="app_content" align="center">
                           <input type="button" class="btn_basecolor" onclick="noticecreate()" value="게시글 등록">
                       </p>
                    </c:if>
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
            <!-- 본문 끝 -->
        </div>
        <!-- container 끝 -->
    </div>
    <!-- wrap 끝 -->

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
      function noticecreate(){
         location.href="notice_new.jsp";
      }
   </script>
    

</body>

</html>    