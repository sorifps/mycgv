package com.mycgv_jsp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycgv_jsp.dao.BoardDao;
import com.mycgv_jsp.vo.BoardVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
 	@Override
	public int getDeleteResult(String bid) {
//		BoardDao boardDao = new BoardDao();
		return boardDao.delete(bid);
	}
	
	@Override
	public int getUpdateResult(BoardVo boardVo) {
//		BoardDao boardDao = new BoardDao();
		return boardDao.update(boardVo);
	}
	
	@Override
	public BoardVo getUpdate(String bid) {
//		BoardDao boardDao = new BoardDao();
		return boardDao.select(bid);
	}
	
	@Override
	public BoardVo getContent(String bid) {
//		BoardDao boardDao = new BoardDao();
		if(boardDao.select(bid) != null) {
			boardDao.updateHits(bid);
		}
		return boardDao.select(bid);
	}
	
	@Override
	public int getWriteResult(BoardVo boardVo) {
//		BoardDao boardDao = new BoardDao();
		return boardDao.insert(boardVo);
	}
	
	@Override
	public ArrayList<BoardVo> getList(int startCount, int endCount) {
		ArrayList<BoardVo> rlist = new ArrayList<BoardVo>();
		List<Object> list = boardDao.select(startCount, endCount);
		for(Object obj : list) {
			BoardVo boardVo = (BoardVo)obj;
			rlist.add(boardVo);
		}
		
		return rlist;
	}
	
}
