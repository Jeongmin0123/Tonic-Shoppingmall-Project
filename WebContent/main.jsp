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
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

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

<style>
   
   .main_container {
    font-size: 30px;
    color: black;
    text-align: center;
    margin: 30px 0;
    padding-top: 30px;
    font-family: 'Noto Sans KR', sans-serif;
    font-weight: bold;
   }
   
   
   .categories {
  /*  padding-top: 10px; */
   }

   .categories_wrap {
    background-color: #E5F3DA;
    height: 450px;
   }
   
   .event {
   background-color: #A7BEDE;
   text-align: center;
   height:100px;
   
   }
   
   .event h2 {
   line-height: 100px;
   font-family: 'Noto Sans KR', sans-serif;
   font-weight: bold;
   }
</style>

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

    

    <!-- Categories Section Begin -->
    <div class="categories_wrap">
    <h2 class="main_container">#인기 #HOT</h2>
    <section class="categories">
    
        <div class="container">
            <div class="row">
                <div class="categories__slider owl-carousel">
                	
                	<c:forEach var="v" items="${pdatas}" begin="0" end="10" step="1" varStatus="status">
	                    <div class="col-lg-3">
	                        <div class="categories__item set-bg" data-setbg="${v.pimg_src}">
	                        </div>
	                        <div> 
	                        	<h5><a href="product_detail.pro?pno=${v.pno}">${v.pname}</a></h5>
	                        </div>
	                    </div>
	                    
                    </c:forEach>
                </div>
            </div>
        </div> 
    </section>
    </div>
    <!-- Categories Section End -->

    <div class="event">
    <h2>최신상품이 궁금하다면? Click</h2>
    </div>

    <!-- Featured Section Begin -->
     <section class="featured spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>상품목록</h2>
                    </div>
                    <div class="featured__controls">
                        <ul>
                            <li class="active" data-filter="*">All</li>
                            <li data-filter=".pdatas_fav">판매량순</li>
                            <li data-filter=".pdatas_low">낮은가격순</li>
                            <li data-filter=".pdatas_high">높은가격순</li>
                            <li data-filter=".pdatas_soldout">매진임박순</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="row featured__filter">
            
            	<c:forEach var="v" items="${pdatas_soldout}">
            		<div class="col-lg-3 col-md-4 col-sm-6 mix pdatas_soldout fresh-meat">
	                    <div class="featured__item">
	                        <div class="featured__item__pic set-bg" data-setbg="${v.pimg_src}">
	                            <!-- <ul class="featured__item__pic__hover">
	                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
	                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
	                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
	                            </ul> -->
	                        </div>
	                        <div class="featured__item__text">
	                            <h6><a href="product_detail.pro?pno=${v.pno}">${v.pname}</a></h6>
	                            <h5>${v.pprice} 원</h5>
	                        </div>
	                    </div>
	                </div>
               	</c:forEach>
            
            	<c:forEach var="v" items="${pdatas}">
	            	<div class="col-lg-3 col-md-4 col-sm-6 mix pdatas_fav fresh-meat">
	                    <div class="featured__item">
	                        <div class="featured__item__pic set-bg" data-setbg="${v.pimg_src}">
	                            <!-- <ul class="featured__item__pic__hover">
	                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
	                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
	                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
	                            </ul> -->
	                        </div>
	                        <div class="featured__item__text">
	                            <h6><a href="product_detail.pro?pno=${v.pno}">${v.pname}</a></h6>
	                            <h5>${v.pprice} 원</h5>
	                        </div>
	                    </div>
                	</div>
             	</c:forEach>
                
            	<c:forEach var="v" items="${pdatas_low}">
	                <div class="col-lg-3 col-md-4 col-sm-6 mix pdatas_low fresh-meat">
	                    <div class="featured__item">
	                        <div class="featured__item__pic set-bg" data-setbg="${v.pimg_src}">
	                            <!-- <ul class="featured__item__pic__hover">
	                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
	                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
	                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
	                            </ul> -->
	                        </div>
	                        <div class="featured__item__text">
	                            <h6><a href="product_detail.pro?pno=${v.pno}">${v.pname}</a></h6>
	                            <h5>${v.pprice} 원</h5>
	                        </div>
	                    </div>
                	</div>
           		</c:forEach>
            
            	<c:forEach var="v" items="${pdatas_high}">
                	<div class="col-lg-3 col-md-4 col-sm-6 mix pdatas_high fresh-meat">
	                    <div class="featured__item">
	                        <div class="featured__item__pic set-bg" data-setbg="${v.pimg_src}">
	                            <!-- <ul class="featured__item__pic__hover">
	                                <li><a href="#"><i class="fa fa-heart"></i></a></li>
	                                <li><a href="#"><i class="fa fa-retweet"></i></a></li>
	                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
	                            </ul> -->
	                        </div>
	                        <div class="featured__item__text">
	                            <h6><a href="product_detail.pro?pno=${v.pno}">${v.pname}</a></h6>
	                            <h5>${v.pprice} 원</h5>
	                        </div>
	                    </div>
                	</div>
              	</c:forEach>
               
            </div>
        </div>
    </section>
    <!-- Featured Section End -->



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