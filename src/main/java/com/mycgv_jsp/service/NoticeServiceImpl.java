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
	
	// ���� - �۾��� ����
	@Override
	public int getNoticeWrite(BoardNoticeVo boardNoticeVo) {
//		BoardNoticeDao boardNoticeDao = new BoardNoticeDao();
		return noticeDao.insert(boardNoticeVo);
	}
	
	// ���� - �Խù� ���� ����
	@Override
	public int getNoticeUpdate(BoardNoticeVo boardNoticeVo) {
//		BoardNoticeDao boardNoticeDao = new BoardNoticeDao();
		return noticeDao.update(boardNoticeVo);
	}
	
	
	// ���� - �Խù� ���� �� �̵�
	@Override
	public BoardNoticeVo getUpdate(String bnid) {
//		BoardNoticeDao boardNoticeDao = new BoardNoticeDao();
		return noticeDao.select(bnid);
	}
	
	// ���� - ������ ����
	@Override
	public int getNoticeDelete(String bnid) {
//		BoardNoticeDao boardNoticeDao = new BoardNoticeDao();
		return noticeDao.delete(bnid);
	}
	
	// ������ ��ȸ
	@Override
	public BoardNoticeVo getContent(String bnid) {
//		BoardNoticeDao boardNoticeDao = new BoardNoticeDao();
		if(noticeDao.select(bnid) != null) {
			noticeDao.updateHits(bnid);
		}
		return noticeDao.select(bnid);
	}
	
	// ���� ����Ʈ ��ȸ + ����
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
