<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mycgv_jsp.dao.MemberDao"  %>
    
<%
	String id = request.getParameter("id"); // 쿼리스트링 방식을 받는 함수
	MemberDao memberDao = new MemberDao();
	int result = memberDao.idCheck(id);
	//*중요 - Ajax로 전송되는 데이터는 반드시!! 문자열 타입으로 전송한다!!
	// String 형변환
	// respons.리다이렉트 쓰면안됨 
	out.write(String.valueOf(result)); //out write로 다시 js 쪽 평션 매개변수로 보낸다.
%>
