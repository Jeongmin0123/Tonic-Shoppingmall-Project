<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="main.do"><img src="img/logo.png" alt=""></a>
        </div>
        <div class="humberger__menu__cart">
        </div>
        <div class="humberger__menu__widget">
            <div class="header__top__right__language">
                <img src="img/korea.png" alt="">
                <div>한국어</div>
            </div>
            <div class="header__top__right__auth">
               <mytag:login/>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="active"><a href="intro.jsp">Intro</a></li>
                <li><a>Shop</a></li>
                <li><a>Pages</a>
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