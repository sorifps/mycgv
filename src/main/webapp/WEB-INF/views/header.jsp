<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="http://localhost:9000/mycgv_jsp/css/mycgv_jsp.css">
</head>
<body>
	<header>
		<div class="header_menu">
			<nav class="nav1">
			<c:choose>
			<c:when test="${sessionScope.svo == null }">
				<ul>
					<li><a href="http://localhost:9000/mycgv_jsp/login.do">로그인</a></li>
					<li><a href="http://localhost:9000/mycgv_jsp/join.do">회원가입</a></li>
					<li><a href="http://localhost:9000/mycgv_jsp/mypage.do" target="_parent">마이페이지</a></li>
			 		<li><a href="#">VIP</a></li>
					<li><a href="#">고객센터</a></li>
					<li><a href="http://localhost:9000/mycgv_jsp/notice_list.do" target="_parent">공지사항</a></li>
					<li><a href="http://localhost:9000/mycgv_jsp/board_list.do" target="_parent">게시판</a></li>
					<li><a href="http://localhost:9000/mycgv_jsp/admin_index.do" target="_parent">ADMIN</a></li>
				</ul>
			</c:when>
			<c:otherwise>
				<ul>
					<li>${sessionScope.svo.name} 님 반갑습니다.</li>
					<li><a href="http://localhost:9000/mycgv_jsp/login/logout.do" target="_parent">로그아웃</a></li>
					<!-- <li><a href="http://localhost:9000/mycgv_jsp/join/join.jsp" target="_parent">회원가입</a></li> -->
					<li><a href="http://localhost:9000/mycgv_jsp/mypage.do">마이페이지</a></li>
					<li><a href="#">VIP</a></li>
					<li><a href="#">고객센터</a></li>
					<li><a href="http://localhost:9000/mycgv_jsp/notice_list.do">공지사항</a></li>
					<li><a href="http://localhost:9000/mycgv_jsp/board_list.do">게시판</a></li>
					<li><a href="http://localhost:9000/mycgv_jsp/board_list_json.do" id="JsonBoard">게시판(JSON)</a></li>
				<c:if test="${sessionScope.svo.id == 'admin'}">
					<li><a href="http://localhost:9000/mycgv_jsp/admin_index.do">ADMIN</a></li>
				</c:if>
				</ul>
			</c:otherwise>
			</c:choose>
			</nav>
			<div>
				<a href="http://localhost:9000/mycgv_jsp/index.do">
					<img src="http://localhost:9000/mycgv_jsp/images/h1_cgv.png">
				</a>
				<div>
					<img src="http://localhost:9000/mycgv_jsp/images/h2_cultureplex.png" >
					<nav class="nav2">
						<ul>
							<li><a href="#">영화</a></li>
							<li><a href="#">예매</a></li>
							<li><a href="#">극장</a></li>
							<li><a href="#">이벤트&컬처</a></li>
						</ul>
					</nav>				
				</div>
			</div>
		</div>
	</header>
</body>
</html>