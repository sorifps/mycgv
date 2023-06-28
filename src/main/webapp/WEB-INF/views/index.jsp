<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String sid = String.valueOf(session.getAttribute("sid"));
%>

<html>
<head>
	<meta charset="UTF-8">
	<title>MYCGV</title>
	<link rel="stylesheet" href="http://localhost:9000/mycgv_jsp/css/mycgv_jsp.css">
	<script type="text/javascript">
		let login_result = "${login_result}";
		if(login_result == 'ok') {
			alert("로그인 성공~ ${login_result}");
		}
	</script>	
</head>
<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>		
		
	<!-- content -->	
	<div class="content">
		<section class="section1">	
			<div class="section1_d1">	
				<img src="http://localhost:9000/mycgv_jsp/images/16347931161070.jpg">
			</div>
		</section>
		<section class="section2">
			<div><img src="http://localhost:9000/mycgv_jsp/images/h3_movie_selection.gif"></div>
			<div>
				<iframe width="710" height="400" src="https://www.youtube.com/embed/4-CyfHhVKnc" 
				title="YouTube video player" frameborder="0" 
				allow="accelerometer; autoplay; clipboard-write; encrypted-media;gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
			</div>
			<img src="http://localhost:9000/mycgv_jsp/images/1201_240x388.jpg">
		</section>
		<section class="section3">
			<div>
				<img src="http://localhost:9000/mycgv_jsp/images/h3_event.gif">
			</div>
			<div>
				<img src="http://localhost:9000/mycgv_jsp/images/16170705205160.jpg">
				<img src="http://localhost:9000/mycgv_jsp/images/16315139087750.jpg">
				<img src="http://localhost:9000/mycgv_jsp/images/16315139088220.jpg">
				<img src="http://localhost:9000/mycgv_jsp/images/16315179619950.jpg">
			</div>
			<div>
				<img src="http://localhost:9000/mycgv_jsp/images/1109_226x259.jpg">
				<img src="http://localhost:9000/mycgv_jsp/images/main_moviecollage.jpg">
				<img src="http://localhost:9000/mycgv_jsp/images/16258186526120.png">
			</div>
		</section>
	</div>
	
	<!-- footer -->
	<jsp:include page="footer.jsp"></jsp:include>			
			
</body>
</html>
















