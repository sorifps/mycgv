<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mycgv_jsp.vo.BoardVo" %>
<%@ page import="com.mycgv_jsp.dao.BoardDao" %>

<%
	String bid = request.getParameter("bid");
	BoardDao boardDao = new BoardDao();
	int result = boardDao.delete(bid);
	if(result == 1) {
		response.sendRedirect("board_list.jsp");
	}

%>
    