<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        <h2>Product Management</h2>
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
                    </fieldset>
                </form>
                <!-- summary : 접근성을 위한 속성 -->
                <table class="bbsListTbl" summary="상품 정보 제공하는 표">
                    <!-- 테이블 제목 -->
                    <caption class="hdd">상품 목록</caption>
                    <thead>
                        <tr>
                            <th scope="col">상품번호</th>
                            <th scope="col">분류</th>
                            <th scope="col">브랜드</th>
                            <th scope="col">상품명</th>
                            <th scope="col">가격</th>
                            <th scope="col">원산지</th>
                            <th scope="col">판매량</th>
                            <th scope="col">재고량</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                       
                       <c:forEach var="v" items="${pdatas}">
                       
                           <tr>
                               <td>${v.pno}</td>
                               <td>${v.pcode}</td>
                               <td>${v.pbrand}</td>
                               <td>${v.pname}</td>
                               <td><fmt:formatNumber value="${v.pprice}" pattern="#,###" />원</td>
                               <td>${v.porigin}</td>
                               <td>${v.psales}</td>
                               <td>${v.pstock}</td>
                               <td>	
                               		<a href="product_modi.pro?pno=${v.pno}">수정</a>
                               		<a href="product_delete.pro?pno=${v.pno}">삭제</a>
                               </td>
                           </tr>
                        
                        </c:forEach>
                    </tbody>
                </table>
                <input type="button" class="btn_basecolor" onclick="productregister()" value="상품등록" >
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
      function productregister(){
         location.href="register.jsp";
      }
   </script>
    
	
<script type="text/javascript">
	function productedel(){
		ans=confirm("정말 삭제하시겠습니까?");
		if(ans==true){
			location.href="product_delete.pro?pno=${v.pno}";
		}
		else{
			return;
		}
	}
</script>


</body>

</html>    