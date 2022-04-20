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
    <mytag:humberger/>
    <!-- Humberger End -->

    <!-- Header Section Begin -->
    <mytag:header/>
    <!-- Header Section End -->
    
    <!-- Hero Section Begin -->
    <mytag:herosection/>
    <!-- Hero Section End -->

       <!-- wrap 시작 -->
       <div id="wrap">

        <!-- container 시작 -->
        <div id="container">

            <!-- 본문 시작 -->
            <div class="bodytext_area box_inner">
           		<c:choose>
	            	<c:when test="${mrole == 'ADMIN'}">
	            		<form action="notice_update.not" method="post">
	            		<input type="hidden" name="nidx" value="${ndata.nidx}">
			             	 <ul class="bbsview_list">
		                    <li class="bbs_title"><input type="text" name="ntitle" value="${ndata.ntitle}"></p></li>
		                    <li class="bbs_date">번호<span>${ndata.nidx}</span></li>
		                    <li class="bbs_hit"><input type="text" name="writer" value="${ndata.writer}" readonly></li>
		                    <li class="bbs_content">
		                        <div class="editor_content">
		                        	<textarea rows="10" cols="130" name="ncont">${ndata.ncont}</textarea>
		                           
		                        </div>
		                    </li>
		                </ul>
		               		<p class="app_content" align="center">
                            	<input type="submit" class="btn_basecolor" value="수정">
	                            <input type="button" class="btn_basecolor" onclick="noticedel()" value="삭제">
                            </p>
	             		</form>
	             	</c:when>
             	
            		<c:otherwise>
		                <ul class="bbsview_list">
		                    <li class="bbs_title">${ndata.ntitle}</p></li>
		                    <li class="bbs_date">번호<span>${ndata.nidx}</span></li>
		                    <li class="bbs_hit">${ndata.writer}</li>
		                    <li class="bbs_content">
		                        <div class="editor_content">
		                            ${ndata.ncont}
		                        </div>
		                    </li>
		                </ul>
                	</c:otherwise>
             	</c:choose>
             	
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