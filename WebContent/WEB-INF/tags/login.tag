<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${mid == null }">
		<a href="login.jsp"><i class="fa fa-user"></i> Login</a>
		<a href="new.jsp">&nbsp;&nbsp;회원가입</a>
	</c:when>
	<c:when test="${mid == 'admin'}">
		${mname} 님, 안녕하세요 :D <br>
		<a href="member_logout.mem">&nbsp;&nbsp;로그아웃</a>
	</c:when>
	<c:otherwise>
		${mname} 님, 안녕하세요 :D <br>
		<a href="member_mypage.mem?mid=${mid}">마이페이지</a>
		<a href="shopping_cart.jsp">&nbsp;&nbsp;장바구니</a>
		<a href="member_logout.mem">&nbsp;&nbsp;로그아웃</a>
	</c:otherwise>
</c:choose>