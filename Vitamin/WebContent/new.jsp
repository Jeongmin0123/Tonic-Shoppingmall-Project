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
               <!--  <a href="login.do"><i class="fa fa-user"></i> Login</a> -->
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
                       <li><a href="product_selectall.pro?pcode=VITA">종합비타민</a></li>
                       <li><a href="product_selectall.pro?pcode=LACT">유산균</a></li>
                       <li><a href="product_selectall.pro?pcode=EYES">눈건강</a></li>                           
                    </ul>
                </li>
                <li><a href="notice.not">공지사항</a></li>
                <li><a href="contact.con">고객센터</a></li>
                <c:if test="${mid == 'admin'}">
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
                                <!-- <a href="login.jsp"><i class="fa fa-user"></i> Login</a>
                                <a href="new.jsp">&nbsp;&nbsp;회원가입</a> -->
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
			                       <li><a href="product_selectall.pro?pcode=VITA">종합비타민</a></li>
			                       <li><a href="product_selectall.pro?pcode=LACT">유산균</a></li>
			                       <li><a href="product_selectall.pro?pcode=EYES">눈건강</a></li>    
                                </ul>
                            </li>
                            <li><a href="notice.not">공지사항</a></li>
                            <li><a href="contact.con">고객센터</a></li>
                            <c:if test="${mid == 'admin'}">
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
	                       <li><a href="product_selectall.pro">전체상품</a></li> 
	                       <li><a href="product_selectall.pro?pcode=VITA">종합비타민</a></li>
	                       <li><a href="product_selectall.pro?pcode=LACT">유산균</a></li>
	                       <li><a href="product_selectall.pro?pcode=EYES">눈건강</a></li>    
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
                        <h2>New</h2>
                        <div class="breadcrumb__option">                           
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->


    <!-- 본문   -->
    <!-- 본문 시작 -->
    <div class="bodytext_area box_inner">
        <!-- 회원가입폼 시작 -->
        <form action="member_insert.mem" class="appForm" method="post" name="newForm">
            <fieldset>
                <!-- 안보이지만 접근성을 위해 넣는다. -->
                <legend>회원가입 입력 양식</legend>
                <p class="info_pilsoo pilsoo_item">필수입력</p>
                <ul class="app_list">
                
					<!-- 아이디 -->
                    <li class="clear">
                        <label for="id_lbl" class="tit_lbl pilsoo_item">
                            아이디
                        </label>
                        <div class="app_content ">
                            <input type="text" class="w40p input_id" id="id_lbl" name="mid" placeholder="아이디를 입력하세요" required>
	                        <input type="button" id="btnEmpnoCheck" value="중복체크" />
   							<p id="notice"></p>
                        </div>
                    </li>
                    
                    <!-- 비밀번호 -->
                    <li class="clear">
                        <label for="pwd_lbl" class="tit_lbl pilsoo_item">
                            비밀번호
                        </label>
                        <div class="app_content ">
                            <input type="password" name="mpw" class="w40p pw" id="pwd_lbl" placeholder="비밀번호를 입력하세요" required>
	                        <input type="button" value="비밀번호 표시" name="passwordsee" onclick="change()">
                        </div>
                    </li>
                    
                    <!-- 비밀번호 확인 -->
                    <li class="clear">
                        <label for="pwd2_lbl" class="tit_lbl pilsoo_item">
                            비밀번호 확인
                        </label>
                        <div class="app_content ">
                            <input type="password" name="mpw2" class="w40p pw" id="pwd2_lbl" placeholder="비밀번호 확인을 입력하세요" required>
                            <span class="alert alert-success w20p" id="alert-success" align="center">비밀번호 일치</span>
                            <span class="alert alert-danger w20p" id="alert-danger" align="center">비밀번호 불일치</span>
                        </div>
                    </li>

                    
                    <!-- 이름 -->
                    <li class="clear">
                        <label for="name_lbl" class="tit_lbl pilsoo_item">
                            이름
                        </label>
                        <div class="app_content ">
                            <input type="text" class="w40p" id="name_lbl" placeholder="이름을 입력하세요" name="mname" required>
                        </div>
                    </li>
                    <!-- 성별 -->
                    <li class="clear">
                        <span class="tit_lbl">성별</span>
                        <div class="app_content radio_area">
                            <input type="radio" class="css-radio" id="mmm_lbl" name="mgender" value="남자">
                            <label for="mmm_lbl">남</label>
                            <input type="radio" class="css-radio" id="www_lbl" name="mgender" value="여자">
                            <label for="www_lbl">여</label>
                        </div>
                    </li>
                    <!-- 생년월일 -->
                    <li class="clear">
                        <label for="name_lbl" class="tit_lbl pilsoo_item">
                            생년월일
                        </label>
                        <div class="app_content ">
                            <input type="text" class="w40p" id="name_lbl" placeholder="생년월일을 입력하세요 ex)211225" name="mbirth" required>
                        </div>
                    </li>

                    <!-- 주소 -->
                    <li class="clear">
                        <label for="addr_lbl" class="tit_lbl pilsoo_item addr"> 주소 </label>

                        <div class="app_content ">
                            <input type="text" name="maddr_zipcode" class="postcodify_postcode5 w40p" id="name_lbl" placeholder="우편번호" required/>
                            <input type="button" id="postcodify_search_button" value="검색"/>
                            <input type="text" name=maddr_street class="postcodify_address w70p" id="name_lbl" placeholder="도로명 주소" /><br>
                            <input type="text" name="maddr_detail" class="postcodify_details w70p" id="name_lbl" placeholder="상세 주소" required/><br>
                            <input type="text" name="maddr_etc" class="postcodify_extra_info w70p" id="name_lbl" placeholder="참고항목" /><br>
                            <!-- <input type="text" class="w100p" id="name_lbl" placeholder="주소을 입력하세요"> -->
                        </div>
                    </li>

                    <!-- 연락처 -->
                    <li class="clear">
                        <label for="phone_lbl" class="tit_lbl pilsoo_item">
                            연락처
                        </label>
                        <div class="app_content ">
                            <input type="tel" class="w40p" id="phone_lbl" placeholder="휴대폰 '-' 없이 숫자만 입력하세요" name="mtel" required>
                        </div>
                    </li>
                    <!-- 이메일 -->
                    <li class="clear">
                        <label for="email_lbl" class="tit_lbl pilsoo_item">
                            이메일
                        </label>
                        <div class="app_content email_area">
                            <input type="text" class="w40p" id="email_lbl" placeholder="이메일을 입력하세요" name="memail" required>
                        </div>
                    </li>
                    
                </ul>
                <p class="app_content" align="center">
                	<input type="submit" class="btn_basecolor" value="회원가입">
                </p>
            </fieldset>
        </form>
        <!-- 회원가입폼  -->
    </div>

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

    <!-- jQuery와 Postcodify를 로딩한다 -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>

    <!-- "검색" 단추를 누르면 팝업 레이어가 열리도록 설정한다 -->
    <script>
        $(function() {
            $("#postcodify_search_button").postcodifyPopUp();
        });
    </script>
	
	<script type="text/javascript"> 
		$(function(){ $("#alert-success").hide();
		$("#alert-danger").hide(); 
		$("input").keyup(function(){ 
				var pwd1=$("#pwd_lbl").val();
				var pwd2=$("#pwd2_lbl").val(); 
				if(pwd1 != "" || pwd2 != ""){ 
					if(pwd1 == pwd2){ 
						$("#alert-success").show();
						$("#alert-danger").hide(); 
						$("#submit").removeAttr("disabled"); 
					} else {
						$("#alert-success").hide();
						$("#alert-danger").show(); 
						$("#submit").attr("disabled", "disabled");
					} 
				} 
			}); 
		});
		
	</script>

	<script>
	function change(){
		var form = document.newForm;
		if(form.mpw.type == "password"){
			form.mpw.type = "text";
			form.passwordsee.value ="비밀번호 가리기";
		} else{
			form.mpw.type = "password";
			form.passwordsee.value ="비밀번호 표시"
		}
	}

	</script>
	
	<script>
	   $(document).ready(function (){   
		   $("#btnEmpnoCheck").on("click", function(event) {
		   var params = $("form").serialize(); 
		   		$.ajax({
		   			url:"isExistId.mem"
		   			,dataType:"json"
		   			,type:"get"
		   			,data:params
		   			,cache:false
		   			,success:function(data){
		   				if(data==1){
		   					$("#notice").css("color","blue").text("사용 가능한 ID입니다.");
		   				}else{
		   					$("#notice").css("color","red").text("이미 사용 중인 ID입니다.");
		   				}
		   			}
		   		});
		   });
	   });
	</script>

</body>

</html>