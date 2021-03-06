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
                        <h2>New</h2>
                        <div class="breadcrumb__option">                           
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->


    <!-- ??????   -->
    <!-- ?????? ?????? -->
    <div class="bodytext_area box_inner">
        <!-- ??????????????? ?????? -->
        <form action="member_insert.mem" class="appForm" method="post" name="newForm">
            <fieldset>
                <!-- ??????????????? ???????????? ?????? ?????????. -->
                <legend>???????????? ?????? ??????</legend>
                <p class="info_pilsoo pilsoo_item">????????????</p>
                <ul class="app_list">
                
					<!-- ????????? -->
                    <li class="clear">
                        <label for="id_lbl" class="tit_lbl pilsoo_item">
                            ?????????
                        </label>
                        <div class="app_content ">
                            <input type="text" class="w40p input_id" id="id_lbl" name="mid" placeholder="???????????? ???????????????" required>
	                        <input type="button" id="btnEmpnoCheck" value="????????????" />
   							<p id="notice"></p>
                        </div>
                    </li>
                    
                    <!-- ???????????? -->
                    <li class="clear">
                        <label for="pwd_lbl" class="tit_lbl pilsoo_item">
                            ????????????
                        </label>
                        <div class="app_content ">
                            <input type="password" name="mpw" class="w40p pw" id="pwd_lbl" placeholder="??????????????? ???????????????" required>
	                        <input type="button" value="???????????? ??????" name="passwordsee" onclick="change()">
                        </div>
                    </li>
                    
                    <!-- ???????????? ?????? -->
                    <li class="clear">
                        <label for="pwd2_lbl" class="tit_lbl pilsoo_item">
                            ???????????? ??????
                        </label>
                        <div class="app_content ">
                            <input type="password" name="mpw2" class="w40p pw" id="pwd2_lbl" placeholder="???????????? ????????? ???????????????" required>
                            <span class="alert alert-success w20p" id="alert-success" align="center">???????????? ??????</span>
                            <span class="alert alert-danger w20p" id="alert-danger" align="center">???????????? ?????????</span>
                        </div>
                    </li>

                    
                    <!-- ?????? -->
                    <li class="clear">
                        <label for="name_lbl" class="tit_lbl pilsoo_item">
                            ??????
                        </label>
                        <div class="app_content ">
                            <input type="text" class="w40p" id="name_lbl" placeholder="????????? ???????????????" name="mname" required>
                        </div>
                    </li>
                    <!-- ?????? -->
                    <li class="clear">
                        <span class="tit_lbl">??????</span>
                        <div class="app_content radio_area">
                            <input type="radio" class="css-radio" id="mmm_lbl" name="mgender" value="??????">
                            <label for="mmm_lbl">???</label>
                            <input type="radio" class="css-radio" id="www_lbl" name="mgender" value="??????">
                            <label for="www_lbl">???</label>
                        </div>
                    </li>
                    <!-- ???????????? -->
                    <li class="clear">
                        <label for="name_lbl" class="tit_lbl pilsoo_item">
                            ????????????
                        </label>
                        <div class="app_content ">
                            <input type="text" class="w40p" id="name_lbl" placeholder="??????????????? ??????????????? ex)211225" name="mbirth" required>
                        </div>
                    </li>

                    <!-- ?????? -->
                    <li class="clear">
                        <label for="addr_lbl" class="tit_lbl pilsoo_item addr"> ?????? </label>

                        <div class="app_content ">
                            <input type="text" name="maddr_zipcode" class="postcodify_postcode5 w40p" id="name_lbl" placeholder="????????????" required/>
                            <input type="button" id="postcodify_search_button" value="??????"/>
                            <input type="text" name=maddr_street class="postcodify_address w70p" id="name_lbl" placeholder="????????? ??????" /><br>
                            <input type="text" name="maddr_detail" class="postcodify_details w70p" id="name_lbl" placeholder="?????? ??????" required/><br>
                            <input type="text" name="maddr_etc" class="postcodify_extra_info w70p" id="name_lbl" placeholder="????????????" /><br>
                            <!-- <input type="text" class="w100p" id="name_lbl" placeholder="????????? ???????????????"> -->
                        </div>
                    </li>

                    <!-- ????????? -->
                    <li class="clear">
                        <label for="phone_lbl" class="tit_lbl pilsoo_item">
                            ?????????
                        </label>
                        <div class="app_content ">
                            <input type="tel" class="w40p" id="phone_lbl" placeholder="????????? '-' ?????? ????????? ???????????????" name="mtel" required>
                        </div>
                    </li>
                    <!-- ????????? -->
                    <li class="clear">
                        <label for="email_lbl" class="tit_lbl pilsoo_item">
                            ?????????
                        </label>
                        <div class="app_content email_area">
                            <input type="text" class="w40p" id="email_lbl" placeholder="???????????? ???????????????" name="memail" required>
                        </div>
                    </li>
                    
                </ul>
                <p class="app_content" align="center">
                	<input type="submit" class="btn_basecolor" value="????????????">
                </p>
            </fieldset>
        </form>
        <!-- ???????????????  -->
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

    <!-- jQuery??? Postcodify??? ???????????? -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>

    <!-- "??????" ????????? ????????? ?????? ???????????? ???????????? ???????????? -->
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
			form.passwordsee.value ="???????????? ?????????";
		} else{
			form.mpw.type = "password";
			form.passwordsee.value ="???????????? ??????"
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
		   					$("#notice").css("color","blue").text("?????? ????????? ID?????????.");
		   				}else{
		   					$("#notice").css("color","red").text("?????? ?????? ?????? ID?????????.");
		   				}
		   			}
		   		});
		   });
	   });
	</script>

</body>

</html>