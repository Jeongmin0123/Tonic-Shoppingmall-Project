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
                <form action="contact_search.con" class="minisrch_form">
                    <fieldset>
                        <legend>??????</legend>
                        <input type="text" class="tbox" title="???????????? ???????????????" name="searchword" placeholder="???????????? ???????????????">
                        <!-- ??? ????????? ?????? -->
                        <!-- <a href="#" class="btn_srch">??????</a> -->
                        <input type="submit" class="btn_basecolor btn_srch" value="??????">
                    </fieldset>
                </form>
                <!-- summary : ???????????? ?????? ?????? -->
                <table class="bbsListTbl" summary="??????, ??????, ????????? ?????? ???????????? ???">
                    <!-- ????????? ?????? -->
                    <caption class="hdd">???????????? ??????</caption>
                    <thead>
                        <tr>
                            <th scope="col" style="width:8%">??????</th>
                            <th scope="col" style="width:50%">?????????</th>
                            <th scope="col" style="width:50%">?????????</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="v" items="${cdatas}">
	                        <tr>
	                            <td>${v.msgno}</td>
	                            <td class="tit_notice"><a href="contact_detail.con?msgno=${v.msgno}">${v.msgname}</a></td>
	                            <td>${v.msgemail}</td>
	                        </tr>
                        </c:forEach>
	                            <!-- <td class="tit_notice"><a href="javascript:showdetails()">test(????????? ??? ????????? ??????)</a></td> -->
                    </tbody>
                </table>

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
		    <!-- <div class="map">
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
		    </div> -->
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
    