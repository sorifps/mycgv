package com.mycgv_jsp.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycgv_jsp.service.NoticeService;
import com.mycgv_jsp.service.PageServiceImpl;
import com.mycgv_jsp.vo.BoardNoticeVo;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private PageServiceImpl pageService;
	
	@RequestMapping(value = "/notice_list.do", method = RequestMethod.GET)
	public ModelAndView notice_list(String page) {
		ModelAndView model = new ModelAndView();

		Map<String, Integer> param = pageService.getPageResult(page, "notice", noticeService);
		
		ArrayList<BoardNoticeVo> list = noticeService.getList(param.get("startCount"), param.get("endCount"));

		model.addObject("list", list);
		model.addObject("totals", param.get("totals"));
		model.addObject("pageSize", param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));

		model.setViewName("/notice/notice_list");

		return model;
	}


	// notice_content.do
	@RequestMapping(value = "/notice_content.do", method = RequestMethod.GET)
	public ModelAndView notice_content(String bnid) {
		ModelAndView model = new ModelAndView();
//		BoardNoticeDao boardNoticeDao = new BoardNoticeDao();
//		BoardNoticeVo boardNoticeVo = boardNoticeDao.select(bnid);
//		if (boardNoticeVo != null) {
//			boardNoticeDao.updateHits(bnid);
//		}
		
		model.addObject("boardNoticeVo", noticeService.getContent(bnid));
		model.setViewName("/notice/notice_content");

		return model;
	}

	/*
	 * //notice_list.do
	 * 
	 * @RequestMapping(value ="/notice_list.do", method=RequestMethod.GET) public
	 * ModelAndView notice_list() { ModelAndView model = new ModelAndView();
	 * BoardNoticeDao boardNoticeDao = new BoardNoticeDao();
	 * ArrayList<BoardNoticeVo> list = boardNoticeDao.select();
	 * model.addObject("list", list); model.setViewName("/notice/notice_list");
	 * return model; }
	 */
}
