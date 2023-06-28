<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYCGV</title>
<link rel="stylesheet" href="http://localhost:9000/mycgv_jsp/css/mycgv_jsp.css">
<link rel="stylesheet" href="http://localhost:9000/mycgv_jsp/css/am-pagination.css">
<script src="http://localhost:9000/mycgv_jsp/js/jquery-3.6.4.min.js"></script>
<script src="http://localhost:9000/mycgv_jsp/js/mycgv_jsp_jquery.js"></script>
<script src="http://localhost:9000/mycgv_jsp/js/am-pagination.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var paper = jQuery('#ampaginationsm').pagination({
			
			maxSize: '${maxSize}',
			totals: '${totals}',
			page: '${page}',
			pageSize: '${pageSize}',

		    // custom labels		
		    lastText: '&raquo;&raquo;', 		
		    firstText: '&laquo;&laquo;',		
		    prevText: '&laquo;',		
		    nextText: '&raquo;',
			
			btnSize : 'sm' // 'sm' or 'lg'
		});
		jQuery('#ampaginationsm').on('am.pagination.change',function(e){
			jQuery('.showlabelsm').text('The selected page no: '+e.page);
			$(location).attr("href", "http://localhost:9000/mycgv_jsp/admin_notice_list.do?page="+e.page);
		});
		
	});
</script>
</head>
<body>
	<!-- header -->
	<!-- <iframe src="http://localhost:9000/mycgv_jsp_jsp_jsp/header.jsp"
			scrolling="no" width="100%" height="149px" frameborder=0></iframe> -->
	<jsp:include page="/header.do"></jsp:include>
	
	<!-- content -->
	<div class="content">
		<section class="board">
			<h1 class="title">관리자 - 공지사항</h1>			
			<table class="board_list">
				<tr>
					<td colspan="4">
						<a href="admin_notice_write.do">
							<button type="button">등록하기</button>
						</a>
					</td>
				</tr>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>조회수</th>
					<th>작성일자</th>
				</tr>
				<c:forEach var="boardNoticeVo" items="${list }">
				<tr>
					<td>${boardNoticeVo.rno }</td>
					<td><a href="admin_notice_content.do?bnid=${boardNoticeVo.bnid }">${boardNoticeVo.bntitle }</a></td>
					<td>${boardNoticeVo.bnhits }</td>
					<td>${boardNoticeVo.bndate }</td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="5"><div id="ampaginationsm"></div></td>
				</tr>
			</table>
		</section>
	</div>
	
	<!-- footer -->
	<!-- <iframe src="http://localhost:9000/mycgv_jsp_jsp_jsp/footer.jsp"
			scrolling="no" width="100%" height="500px" frameborder=0></iframe> -->	
	<jsp:include page="../../footer.jsp"></jsp:include>
</body>
</html>
















