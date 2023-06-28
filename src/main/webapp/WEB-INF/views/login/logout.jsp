<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sid = (String)session.getAttribute("sid");
	if(sid != null){
		session.invalidate();
		out.write("<script>");
		out.write("if(confirm('정말로 로그아웃 하시겠습니까?')) {");
		out.write("alert('로그아웃에 되셨습니다.');");
		out.write("location.href='http://localhost:9000/mycgv_jsp/index.jsp';");
		out.write(" } else {");
		out.write("location.href='http://localhost:9000/mycgv_jsp/index.jsp';");
		out.write(" } ");
		out.write("</script>");
	}
%>
