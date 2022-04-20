<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
                        <a href="main.do"><img src="img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="intro.jsp">Intro</a></li>
                            <li><a>Shop</a>
                                <ul class="header__menu__dropdown">
                                	<li><a href="product_selectall.pro">전체상품</a></li> 
			                        <li><a href="product_filterselect.pro?pcode=VITA">종합비타민</a></li>
			                        <li><a href="product_filterselect.pro?pcode=LACT">유산균</a></li>
			                        <li><a href="product_filterselect.pro?pcode=EYES">루테인</a></li>    
                                </ul>
                            </li>
                            <li><a href="notice.not">공지사항</a></li>
                            <li><a href="contact.con">고객센터</a></li>
                            <c:if test="${mrole == 'ADMIN'}">
			              		<li><a href="product_manage.pro">상품관리</a></li>
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