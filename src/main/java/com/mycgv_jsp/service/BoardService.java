package com.mycgv_jsp.service;

import java.util.ArrayList;

import com.mycgv_jsp.vo.BoardVo;

public interface BoardService {
	public int getDeleteResult(String bid);
	public int getUpdateResult(BoardVo boardVo);
	public BoardVo getUpdate(String bid);
	public BoardVo getContent(String bid);
	public int getWriteResult(BoardVo boardVo);
	public ArrayList<BoardVo> getList(int startCount, int endCount);
}
