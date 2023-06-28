package com.mycgv_jsp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mycgv_jsp.vo.SessionVo;

public class SessionAuthInterceptor extends HandlerInterceptorAdapter {
	/*
	 * preHandle : Controller�� �����ϱ� ���� �����ϴ� �޼ҵ� 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// Ŭ���̾�Ʈ(������)�� ��û Ȯ�� - ���� ��ü ��������
		HttpSession session = request.getSession();
		
		//sid Ȯ���ϱ�
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		if(svo == null) {
			//�α��� �ȵǾ� �ִ� �����̹Ƿ� �α��������� ����
			response.sendRedirect("/mycgv_jsp/login.do");
			return false;
		}
		return true;
	}
}
