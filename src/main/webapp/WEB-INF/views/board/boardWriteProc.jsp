<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mycgv_jsp.dao.BoardDao"%>
<%@ page import="com.mycgv_jsp.vo.BoardVo"%>

<jsp:useBean id="boardVo" class="com.mycgv_jsp.vo.BoardVo"></jsp:useBean>
<jsp:setProperty property="*" name="boardVo"/>

<%
	BoardDao boardDao = new BoardDao();
	int result = boardDao.insert(boardVo);
	if(result == 1) {
		response.sendRedirect("http://localhost:9000/mycgv_jsp/board/board_list.jsp");
	}else {
		
	}
%>