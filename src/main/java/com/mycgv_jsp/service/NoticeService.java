package com.mycgv_jsp.service;

import java.util.ArrayList;

import com.mycgv_jsp.vo.BoardNoticeVo;

public interface NoticeService {
	public int getNoticeDelete(String bnid);
	public int getNoticeUpdate(BoardNoticeVo boardNoticeVo);
	public BoardNoticeVo getUpdate(String bnid);
	public BoardNoticeVo getContent(String bnid);
	public int getNoticeWrite(BoardNoticeVo boardNoticeVo);
	public ArrayList<BoardNoticeVo> getList(int startCount, int endCount);

}
