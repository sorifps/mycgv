package com.mycgv_jsp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycgv_jsp.service.MemberService;
import com.mycgv_jsp.vo.MemberVo;
import com.mycgv_jsp.vo.SessionVo;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	/*
	 *  logout.do - �α׾ƿ�
	 */
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		ModelAndView model = new ModelAndView();
//		String sid = (String)session.getAttribute("sid");
		SessionVo svo = (SessionVo)session.getAttribute("svo");
		if(svo != null) {
			session.invalidate();
			model.addObject("logout_result", "ok");
		}
		model.setViewName("index");
		return model;
	}
	
	
	/*
	 *  login_fail.do - �α��� ó�� - ����
	 */
	@RequestMapping(value = "/login_fail.do", method=RequestMethod.GET)
	public String login_fail() {
		return "/login/login_fail";
	}
	
	/*
	 *  login_proc.do - �α��� ó��
	 */
	@RequestMapping(value = "/login_proc.do", method=RequestMethod.POST)
	public ModelAndView login_proc(MemberVo memberVo,HttpSession session) {
		ModelAndView model = new ModelAndView();
//		int result = memberService.getLoginResult(memberVo);
		SessionVo svo = memberService.getLoginResult(memberVo);
		if(svo.getLoginResult() == 1) {
			session.setAttribute("svo", svo);
			//�α��� �����ϸ� index �̵�
			//viewName = "index"; viewResolver �� ���� ȣ��Ǹ� ��� Ǫ�Ͱ� ���������� do�� �Ϸ��� ���ο� ��Ʈ�ѷ��� �ʿ��� 
			model.addObject("login_result", "ok");
			model.setViewName("index");
		}else {
			//login_fail.do
			model.setViewName("redirect:/login_fail.do");
		}
		
		return model;
	}
	
	/*
	 * login.do - �α��� ��
	 */
	@RequestMapping(value = "/login.do", method=RequestMethod.GET)
	public String login() {
		return "/login/login";
	}
}
	