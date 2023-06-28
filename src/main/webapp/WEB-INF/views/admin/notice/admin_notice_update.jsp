<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYCGV</title>
<link rel="stylesheet" href="http://localhost:9000/mycgv_jsp/css/mycgv_jsp.css">
<script src="http://localhost:9000/mycgv_jsp/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/mycgv_jsp/js/mycgv_jsp_jquery.js"></script>

</head>
<body>
	<!-- header -->
	<!-- <iframe src="http://localhost:9000/mycgv_jsp/header.jsp"
			scrolling="no" width="100%" height="149px" frameborder=0></iframe> -->
	<jsp:include page="/header.do"></jsp:include>
	
	<!-- content -->
	<div class="content">
		<section class="board">
			<h1 class="title">관리자 - 공지사항</h1>
			<form name="updateForm" action="admin_notice_update_proc.do" method="post">
			<input type="hidden" name="bnid" value="${boardNoticeVo.bnid }">
				<table>
					<tr>
						<th>제목</th>
						<td>
							<input type="text" name="bntitle" value="${boardNoticeVo.bntitle }" id="ntitle">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea name="bncontent" id="bncontent">${boardNoticeVo.bncontent }</textarea>
						</td>
					</tr>					
					<tr>
						<td colspan="2">
							<button type="submit" class="btn_style">수정완료</button>
							<button type="reset" class="btn_style">다시쓰기</button>
							<a href="admin_notice_content.do?bnid=${boardNoticeVo.bnid }">
								<button type="button" class="btn_style">이전페이지</button></a>
							<a href="admin_notice_list.do">
								<button type="button" class="btn_style">리스트</button></a>							
						</td>				
					</tr>
				</table>
			</form>
		</section>
	</div>
	
	<!-- footer -->
	<!-- <iframe src="http://localhost:9000/mycgv_jsp/footer.jsp"
			scrolling="no" width="100%" height="500px" frameborder=0></iframe> -->	
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>

















