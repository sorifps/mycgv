package com.mycgv_jsp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycgv_jsp.dao.PageDao;

@Service("pageService")
public class PageServiceImpl {
	
	@Autowired
	private PageDao pageDao;
	
	public Map<String, Integer> getPageResult(String page, String serviceName, Object serviceType) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		
		
		//페이징 처리 - startCount, endCount 구하기
		int startCount = 0;
		int endCount = 0;
		int pageSize = 10;	//한페이지당 게시물 수
		int reqPage = 1;	//요청페이지	
		int pageCount = 1;	//전체 페이지 수
		int dbCount = 0;	//DB에서 가져온 전체 행수
		
		dbCount = pageDao.totalRowCount(serviceName);
		if(serviceName.equals("board")) {
			pageSize = 3;
		}else if(serviceName.equals("notice")) {
//			noticeService = (NoticeService)serviceType;
//			dbCount = pageDao.totalRowCount(serviceName);
			pageSize = 5;
		}else if(serviceName.equals("member")) {
//			memberService = (MemberService)serviceType;
//			dbCount = pageDao.totalRowCount(serviceName);
			pageSize = 10;
		}
		
		//총 페이지 수 계산
		if(dbCount % pageSize == 0){
			pageCount = dbCount/pageSize;
		}else{
			pageCount = dbCount/pageSize+1;
		}

		//요청 페이지 계산
		if(page != null){
			reqPage = Integer.parseInt(page);
			startCount = (reqPage-1) * pageSize+1; 
			endCount = reqPage *pageSize;
		}else{
			startCount = 1;
			endCount = pageSize;
		}
		
		param.put("totals", dbCount);
		param.put("pageSize", pageSize);
		param.put("maxSize", pageCount);
		param.put("page", reqPage);
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		
		return param;
	}
	
}
