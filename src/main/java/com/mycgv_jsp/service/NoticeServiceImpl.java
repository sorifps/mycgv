package com.mycgv_jsp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycgv_jsp.dao.BoardNoticeDao;
import com.mycgv_jsp.vo.BoardNoticeVo;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private BoardNoticeDao noticeDao;
	
	// 어드민 - 글쓰기 저장
	@Override
	public int getNoticeWrite(BoardNoticeVo boardNoticeVo) {
//		BoardNoticeDao boardNoticeDao = new BoardNoticeDao();
		return noticeDao.insert(boardNoticeVo);
	}
	
	// 어드민 - 게시물 수정 저장
	@Override
	public int getNoticeUpdate(BoardNoticeVo boardNoticeVo) {
//		BoardNoticeDao boardNoticeDao = new BoardNoticeDao();
		return noticeDao.update(boardNoticeVo);
	}
	
	
	// 어드민 - 게시물 수정 탭 이동
	@Override
	public BoardNoticeVo getUpdate(String bnid) {
//		BoardNoticeDao boardNoticeDao = new BoardNoticeDao();
		return noticeDao.select(bnid);
	}
	
	// 어드민 - 콘텐츠 삭제
	@Override
	public int getNoticeDelete(String bnid) {
//		BoardNoticeDao boardNoticeDao = new BoardNoticeDao();
		return noticeDao.delete(bnid);
	}
	
	// 콘텐츠 조회
	@Override
	public BoardNoticeVo getContent(String bnid) {
//		BoardNoticeDao boardNoticeDao = new BoardNoticeDao();
		if(noticeDao.select(bnid) != null) {
			noticeDao.updateHits(bnid);
		}
		return noticeDao.select(bnid);
	}
	
	// 보드 리스트 조회 + 어드민
	@Override
	public ArrayList<BoardNoticeVo> getList(int startCount, int endCount) {
		ArrayList<BoardNoticeVo> rlist = new ArrayList<BoardNoticeVo>();
		List<Object> list = noticeDao.select(startCount, endCount);
		for(Object obj : list) {
			BoardNoticeVo boardNoticeVo = (BoardNoticeVo)obj;
			rlist.add(boardNoticeVo);		
			}
		return rlist;
	}
}
