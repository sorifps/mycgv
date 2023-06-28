<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mycgv_jsp.vo.BoardVo" %>
<%@ page import="com.mycgv_jsp.dao.BoardDao" %>

<jsp:useBean id="boardVo" class="com.mycgv_jsp.vo.BoardVo"></jsp:useBean>
<jsp:setProperty property="*" name="boardVo"/>

<%
	BoardDao boardDao = new BoardDao();
	int result = boardDao.update(boardVo);
	if(result == 1) {
		response.sendRedirect("board_list.jsp");
	}

%>
    
    
    
    
    
    
    
    
    
    
    
    
