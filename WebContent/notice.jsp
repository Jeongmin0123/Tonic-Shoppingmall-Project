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


    <!-- wrap ?????? -->
    <div id="wrap">
        <!-- container ?????? -->
        <div id="container">
            <!-- ?????? ?????? -->
            <div class="bodytext_area box_inner">
                <form action="notice_search.not" class="minisrch_form" method="post">
                    <fieldset>
                        <legend>??????</legend>
                        <input type="text" class="tbox" name="search_word" placeholder="???????????? ???????????????">
                        <input type="submit" class="btn_basecolor btn_srch" value="??????">                        
                        <!-- <a href="/notice_search.not" class="btn_srch">??????</a> -->
                    </fieldset>
                </form>
                <!-- summary : ???????????? ?????? ?????? -->
                <table class="bbsListTbl" summary="??????, ??????, ????????? ?????? ???????????? ???">
                    <!-- ????????? ?????? -->
                    <caption class="hdd">???????????? ??????</caption>
                    <thead>
                        <tr>
                            <th scope="col" style="width:8%">??????</th>
                            <th scope="col" style="width:80%">??????</th>
                            <th scope="col" style="width:10%">?????????</th>
                        </tr>
                    </thead>
                    <tbody>
                       
                       <c:forEach var="v" items="${ndatas}">
                       
                           <tr>
                               <td>${v.nidx}</td>
                               <td class="tit_notice"><a href="notice_detail.not?nidx=${v.nidx}">${v.ntitle}</a></td>
                               <td>${v.writer}</td>
                           </tr>
                        
                        </c:forEach>
                    </tbody>
                </table>
                    <c:if test="${mrole == 'ADMIN'}">
                       <p class="app_content" align="center">
                           <input type="button" class="btn_basecolor" onclick="noticecreate()" value="????????? ??????">
                       </p>
                    </c:if>
                <!-- ??????????????? -->
                <!-- <div class="npagination">
                    <<
                    <a href="#" class="firstpage pbtn"><img src="./img/btn_firstpage.png" alt="??? ???????????? ??????"></a>
                    <
                    <a href="#" class="prevpage pbtn"><img src="./img/btn_prevpage.png" alt="?????? ???????????? ??????"></a>
                    <a href="#"><span class="currentPage pagenum">1</span></a>
                    <a href="#"><span class="pagenum">2</span></a>
                    <a href="#"><span class="pagenum">3</span></a>
                    <a href="#"><span class="pagenum">4</span></a>
                    <a href="#"><span class="pagenum">5</span></a>
                    >
                    <a href="#" class="nextpage pbtn"><img src="./img/btn_nextpage.png" alt="?????? ???????????? ??????"></a>
                    >>
                    <a href="#" class="lastpage pbtn"><img src="./img/btn_lastpage.png" alt="????????? ???????????? ??????"></a>
                </div> -->
            </div>
            <!-- ?????? ??? -->
        </div>
        <!-- container ??? -->
    </div>
    <!-- wrap ??? -->

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