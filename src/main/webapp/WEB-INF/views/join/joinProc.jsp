<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mycgv_jsp.vo.MemberVo"  %>
<%@ page import="com.mycgv_jsp.dao.MemberDao"  %>

<jsp:useBean id="memberVo" class="com.mycgv_jsp.vo.MemberVo"></jsp:useBean>
<jsp:setProperty name="memberVo" property="*" />

<%
	MemberDao memberDao = new MemberDao();
	int result = memberDao.insert(memberVo);
	if(result == 1) {
		//alert 창을 띄우려면
		out.write("<script>");
		out.write("alert('회원가입 성공~!');");
		out.write("location.href='http://localhost:9000/mycgv_jsp/login/login.jsp'"); //$(location).attr(,url)
		out.write("</script>");
		
		//response.sendRedirect("http://localhost:9000/mycgv_jsp/login/login.jsp"); //현제 접속창 종료하고 다시접속 // 사용할 시 쿼리스트링 방식으로 ?jresult=1 <-로 체크할 수있게 넘겨줘야한다
		//가지고 오는 주소 데이터를 request.getParameter()  함수로 받는다 .= 공부 못한 부분 
	}
%>
    
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><%= memberVo.getId() %></li>
		<li><%= memberVo.getPass() %></li>
		<li><%= memberVo.getName() %></li>
		<li><%= memberVo.getGender() %></li>
		<li><%= memberVo.getEmail() %></li>
		<li><%= memberVo.getAddr() %></li>
		<li><%= memberVo.getTel() %></li>
		<li><%= memberVo.getPnumber() %></li>
		<li><%= memberVo.getHobbyList() %></li>
		<li><%= memberVo.getIntro() %></li>
	</ul>
</body>
</html>