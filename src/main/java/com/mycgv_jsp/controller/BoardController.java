package com.mycgv_jsp.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycgv_jsp.service.BoardService;
import com.mycgv_jsp.service.FileServiceImpl;
import com.mycgv_jsp.service.PageServiceImpl;
import com.mycgv_jsp.vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private PageServiceImpl pageService;
	
	@Autowired
	private FileServiceImpl fileService;
	
	// file_upload_proc.do - ���� ���ε�
	@RequestMapping(value="/board_write_proc.do", method=RequestMethod.POST)
	public String board_write_proc(BoardVo boardVo, HttpServletRequest request) throws Exception{
		String viewName = "";
		int result = boardService.getWriteResult(fileService.fileCheck(boardVo));
		if(result == 1) {
			//������ �����ϸ� ������ ����
			if(boardVo.getBfile() != null && !boardVo.getBfile().equals("")) {
				fileService.fileSave(boardVo, request);
				viewName = "redirect:/board_list.do";
			}
		}
		return viewName;
	}
	
	
	/**
	 * board_list.do - �Խñ� ��ü ����Ʈ 
	 * @return
	 */
	@RequestMapping(value="/board_list.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public ModelAndView board_list(String page) {
		ModelAndView model = new ModelAndView();		
		Map<String, Integer> param = pageService.getPageResult(page, "board", boardService);
		ArrayList<BoardVo> list = boardService.getList(param.get("startCount"), param.get("endCount"));
		model.addObject("list", list);
		model.addObject("totals", param.get("totals"));
		model.addObject("pageSize", param.get("pageSize"));
		model.addObject("maxSize", param.get("maxSize"));
		model.addObject("page", param.get("page"));
		
		model.setViewName("/board/board_list");
		
		return model;
	} 
	
	//json ȣ��
	//header �Խ���(JSON) ȣ��Ǵ� �ּ�
	@RequestMapping(value="/board_list_json.do", method=RequestMethod.GET)
	public String board_list_json() {
		return "board/board_list_json";
	}
	
	//josn ���� - board_list_json_data.do - ajax���� ȣ��Ǵ� �Խñ� ��ü ����Ʈ(JSON)
	
//	@RequestMapping(value="/board_list_json_data.do", method=RequestMethod.GET)
//	@ResponseBody
//	public String board_list_json_data(String page) {
//		BoardDao boardDao = new BoardDao();
//		
//		//����¡ ó�� - startCount, endCount ���ϱ�
//		int startCount = 0;
//		int endCount = 0;
//		int pageSize = 5;	//���������� �Խù� ��
//		int reqPage = 1;	//��û������	
//		int pageCount = 1;	//��ü ������ ��
//		int dbCount = boardDao.totalRowCount("board");	//DB���� ������ ��ü ���
//		
//		//�� ������ �� ���
//		if(dbCount % pageSize == 0){
//			pageCount = dbCount/pageSize;
//		}else{
//			pageCount = dbCount/pageSize+1;
//		}
//
//		//��û ������ ���
//		if(page != null){
//			reqPage = Integer.parseInt(page);
//			startCount = (reqPage-1) * pageSize+1; 
//			endCount = reqPage *pageSize;
//		}else{
//			startCount = 1;
//			endCount = pageSize;
//		}
//		
//		ArrayList<BoardVo> list = boardDao.select(startCount, endCount);
//		
//		//list ��ü�� �����͸� JSON ���·� ����
//		JsonObject jlist = new JsonObject();
//		JsonArray jarray = new JsonArray();
//		
//		for(BoardVo boardVo : list) {
//			JsonObject jobj = new JsonObject(); // {}
//			jobj.addProperty("rno", boardVo.getRno()); // {rno:1}
//			jobj.addProperty("id", boardVo.getId()); // {rno:1, id:"df"}
//			jobj.addProperty("btitle", boardVo.getBtitle());
//			jobj.addProperty("bhits", boardVo.getBhits());
//			jobj.addProperty("bdate", boardVo.getBdate());
//			
//			jarray.add(jobj);
//		}
//		jlist.add("jlist", jarray);
//		jlist.addProperty("totals", dbCount);
//		jlist.addProperty("pageSize", pageSize);
//		jlist.addProperty("maxSize", pageCount);
//		jlist.addProperty("page", reqPage);
//		
//		return new Gson().toJson(jlist);
//	}
	
	
	
	// board_delete.do - �Խù� ���� ����
	@RequestMapping(value="/board_delete_proc.do", method=RequestMethod.POST)
	public String board_delete_proc(String bid,String bsfile, HttpServletRequest request) throws Exception {
		String viewName = "";
//		BoardDao boardDao = new BoardDao();
//		int result = boardDao.delete(bid);
		if(boardService.getDeleteResult(bid) == 1 ) {
			fileService.fileDelete(request, bsfile);
			viewName = "redirect:/board_list.do";
		}else {
			//���������� �̵�
		}
		return viewName;
	}
	
	// board_delete.do - �Խù� ���� �� 
	@RequestMapping(value="/board_delete.do", method=RequestMethod.GET)
	public ModelAndView board_delete(String bid, String bsfile) {
		ModelAndView model = new ModelAndView();
		
		model.addObject("bid", bid);
		model.addObject("bsfile", bsfile);
		model.setViewName("board/board_delete");
		return model;
	}

	
	// board_update.do - �Խù� ���� ����
	@RequestMapping(value="/board_update_proc.do", method=RequestMethod.POST)
	public String board_update_proc(BoardVo boardVo, HttpServletRequest request) throws Exception {
		String viewName = "";
		
		String oldFileName = boardVo.getBsfile(); // 새로운 파일 업데이트 시 기존 파일 삭제
		if(boardService.getUpdateResult(fileService.fileCheck(boardVo)) == 1) {
			if(boardVo.getBfile() != null && !boardVo.getBfile().equals("")) {
				fileService.fileSave(boardVo, request); // 새로운 파일 저장
				//기존 파일 삭제 
				fileService.fileDelete(boardVo,request,oldFileName);
				
			}
			viewName = "redirect:/board_list.do";
		}else {
			//에러 페이지
		}
		return viewName;
	}
	
	
	// board_update.do - �Խù� ���� �� �̵�
	@RequestMapping(value="/board_update.do", method=RequestMethod.GET)
	public ModelAndView board_update(String bid) {
		ModelAndView model = new ModelAndView();
//		BoardDao boardDao = new BoardDao();
//		BoardVo boardVo	= boardDao.select(bid);
		
		model.addObject("boardVo", boardService.getUpdate(bid));
		System.out.println(boardService.getUpdate(bid).getBfile());
		System.out.println(boardService.getUpdate(bid).getBsfile());
		model.setViewName("/board/board_update");
		
		return model;
	}
	
	// board_write.do - �Խù� ����
//	@RequestMapping(value="/board_write_proc.do", method=RequestMethod.POST)
//	public String board_write_proc(BoardVo boardVo) {
//		String viewName = "";
//		//1. ������ �Ѿ���� �����͸� �޾ƾ���. boardVo�� �־����
//		//2. BoardVo���� �Ѿ���� �����͸� Dao�� ����
//		//3. mycgv_board ���̺� insert 
////		BoardDao boardDao = new BoardDao();
////		int result = boardDao.insert(boardVo);
//		if(boardService.getWriteResult(boardVo) == 1) {
//			viewName = "redirect:/board_list.do";
//			//response.sendRedirect("http://localhost:9000/mycgv_jsp/board/board_list.do");
//			// �Ʒ����� list�� ��ﶧ ���εǴ� �̸����� �����ϰ� ���εǴ� �̸��� ���ؼ� ������� �ְ� �����ؾ��Ѵ�.
//		}else {
//			//0�̾ƴ� exception �� �߱⶧���� ���ڷ� üũ �Ұ���
//			//���������� ���� ���� . ȣ��
//		}
//		return viewName;
//	}
	
	// board_write.do - �Խñ� �۾���
	@RequestMapping(value="/board_write.do", method=RequestMethod.GET)
	public String board_write() {
		return "board/board_write";
	}
	
	//���� ����(������) board_content.do
	@RequestMapping(value="/board_content.do", method=RequestMethod.GET)
	public ModelAndView board_content(String bid) {
		ModelAndView model = new ModelAndView();
		
//		BoardDao boardDao = new BoardDao();
//		BoardVo boardVo = boardDao.select(bid);
		BoardVo boardVo = boardService.getContent(bid);
		if(boardVo !=null) {
			//��ȸ�� ������Ʈ-DB
//			boardDao.updateHits(bid);
			model.addObject("bvo", boardVo);
			model.setViewName("/board/board_content");
		}
		return model;
	}
	
	//���� ����Ʈ ��� ��� = board.list
	
	/*
	 * @RequestMapping(value ="/board_list.do",method = RequestMethod.GET) public
	 * ModelAndView board() { ModelAndView model = new ModelAndView(); //DB���� ��
	 * ArrayList<BoardVo> BoardDao boardDao = new BoardDao(); ArrayList<BoardVo>
	 * list = boardDao.select();
	 * 
	 * 
	 * model.addObject("list", list); model.setViewName("/board/board_list");
	 * 
	 * return model; }
	 */
}








