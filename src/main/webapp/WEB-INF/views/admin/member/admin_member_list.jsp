<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
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
		var pager = jQuery('#ampaginationsm').pagination({
			
			maxSize: '${maxSize}',
			totals: '${totals}',
			page: '${page}',
			pageSize: '${pageSize}',
			
			//custom labels
			lastText: '&raquo;&raquo;',
			firstText: '&laquo;&laquo;',
			prevText: '&laquo',
			nextText: '&raquo;',
			
			btnSize:'sm'
		});
		
		jQuery('#ampaginationsm').on('am.pagination.change',function(e){
			jQuery('.showlabelsm').text('The selected page no: '+e.page);
			$(location).attr('href', "http://localhost:9000/mycgv_jsp/admin_member_list.do?page="+e.page);
			
		});
		
	});
</script>

</head>
<body>
	<!-- header -->
	<jsp:include page="/header.do"></jsp:include>
	<!-- header -->
	<!-- content -->
	<div class="content">
		<section class="notice">
			<h1 class="title">관리자 - 회원관리</h1>			
			<table>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>성명</th>
					<th>가입일자</th>
					<th>회원등급</th>
				</tr>
				<c:forEach var="memberVo" items="${list }"> 
				<tr>
					<td>${memberVo.rno }</td>
					<td>${memberVo.id }</td>
					<td>${memberVo.name}</td>
					<td>${memberVo.mdate }</td>
					<td>${memberVo.grade }</td>
				</tr>
				</c:forEach> 
				<tr>
					<td colspan="5"><div id="ampaginationsm"></div></td>
				</tr>
			</table>
		</section>
	</div>
	
	<!-- footer -->
	<jsp:include page="/footer.do"></jsp:include>
	<!-- footer -->
</body>
</html>















