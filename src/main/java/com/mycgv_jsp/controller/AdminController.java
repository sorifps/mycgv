package com.mycgv_jsp.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycgv_jsp.service.FileServiceImpl;
import com.mycgv_jsp.service.MemberService;
import com.mycgv_jsp.service.NoticeService;
import com.mycgv_jsp.service.PageServiceImpl;
import com.mycgv_jsp.vo.BoardNoticeVo;
import com.mycgv_jsp.vo.MemberVo;

@Controller
public class AdminController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private PageServiceImpl pageService;
	
	@Autowired
	private FileServiceImpl fileService;
	
	
	//���� ������ ����¡ ó��
	@RequestMapping(value="/admin_notice_list.do", method=RequestMethod.GET)
	public ModelAndView admin_notice(String page) 	{
		ModelAndView model = new ModelAndView();
		
		Map<String, Integer> param = pageService.getPageResult(page, "notice", noticeService);
		ArrayList<BoardNoticeVo> list = noticeService.getList(param.get("startCount"), param.get("endCount"));
		model.addObject("list", list);
		model.addObject("totals", param.get("totals"));
		model.addObject("pageSize", param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		
		model.setViewName("/admin/notice/admin_notice_list");
		
		return model;
	}
	
	
	//admin_member_list.do - ȸ�� ��ü ����Ʈ ��� (����¡ ó��)
	@RequestMapping(value="/admin_member_list.do", method=RequestMethod.GET)
	public ModelAndView admin_member_list(String page) {
		ModelAndView model = new ModelAndView();
		
		Map<String, Integer> param = pageService.getPageResult(page, "member", memberService);
		ArrayList<MemberVo> list = memberService.getList(param.get("startCount"), param.get("endCount"));
		
		model.addObject("list", list);
		model.addObject("page", param.get("page"));
		model.addObject("pageSize", param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("totals", param.get("totals"));
		model.setViewName("admin/member/admin_member_list");
		return model;
	}
	
	
	//admin_notice_delete.do - �������� ����
	@RequestMapping(value="/admin_notice_delete_proc.do", method=RequestMethod.POST)
	public String admin_notice_delete_proc(String bnid) {
		String viewName = "";
		int result = noticeService.getNoticeDelete(bnid);
		if(result ==1) {
			viewName = "redirect:/admin_notice_list.do";
		}
		
		return viewName;
	}
	
	//admin_notice_delete.do - �������� ���� ��
	@RequestMapping(value="/admin_notice_delete.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_delete(String bnid)	{
		ModelAndView model = new ModelAndView();
//		int result = noticeService.getNoticeDelete(bnid);
		if(noticeService.getNoticeDelete(bnid) == 1) {
			model.setViewName("redirect:/admin_notice_list.do");
		}
		return model;
	}
	//admin_notice_write - �� ����
	@RequestMapping(value="/admin_notice_write_proc.do", method=RequestMethod.POST)
	public String admin_notice_write_proc(BoardNoticeVo boardNoticeVo, HttpServletRequest request) throws Exception {
		String viewName = "";
		
		//멀티파일 업로드 - fileService.multiFileCheck()
		
		
		
		int result = noticeService.getNoticeWrite(fileService.multiFileCheck(boardNoticeVo));
		if(result == 1) {
			if(!boardNoticeVo.getFiles()[0].getOriginalFilename().equals("")) {
				fileService.multiFileSave(boardNoticeVo, request);
			}
			
			viewName = "redirect:/admin_notice_list.do";
		}else {
			//���� ������ �̵�
		}
		return viewName;
	}
	
	//admin_notice_write 
	@RequestMapping(value="/admin_notice_write.do", method=RequestMethod.GET)
	public String admin_notice_write() {
		return "/admin/notice/admin_notice_write";
	}
	
	//admin_notice_update
	@RequestMapping(value="/admin_notice_update_proc.do", method=RequestMethod.POST)
	public String admin_notice_update_proc(BoardNoticeVo boardNoticeVo) {
		String viewName = "";
		int result = noticeService.getNoticeUpdate(boardNoticeVo);
		if(result == 1) {
			viewName = "redirect:/admin_notice_list.do";
		}else {
			//������������ �̵�
		}
		return viewName;
	}
	
	//admin_notice_update - �Խù� ���� ���̵�
	@RequestMapping(value="/admin_notice_update.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_update(String bnid) {
		ModelAndView model = new ModelAndView();
		model.addObject("boardNoticeVo", noticeService.getUpdate(bnid));
		model.setViewName("/admin/notice/admin_notice_update");
		return model;
	}
	
	
	//admin_notice_content
	@RequestMapping(value="/admin_notice_content.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_content(String bnid) {
		ModelAndView model = new ModelAndView();
		model.addObject("boardNoticeVo", noticeService.getContent(bnid));
		model.setViewName("/admin/notice/admin_notice_content");
		return model;
	}
	
//	//admin_notice_list.do
//	@RequestMapping(value="/notice/admin_notice_list.do", method=RequestMethod.GET)
//	public ModelAndView admin_notice_list() {
//		ModelAndView model = new ModelAndView();
//		BoardNoticeDao boardNoticeDao = new BoardNoticeDao();
//		ArrayList<BoardNoticeVo> list = boardNoticeDao.select();
//		model.addObject("list", list);
//		model.setViewName("/admin/notice/admin_notice_list");
//		
//		return model;
//	}
	
	//admin_index.do
	@RequestMapping(value = "/admin_index.do", method=RequestMethod.GET)
	public String admin() {
		return "/admin/admin_index";
	}
}
