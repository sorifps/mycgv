package com.mycgv_jsp.service;

import java.util.ArrayList;

import com.mycgv_jsp.vo.MemberVo;
import com.mycgv_jsp.vo.SessionVo;

public interface MemberService {
	public SessionVo getLoginResult(MemberVo memberVo);
	public String getIdCheckResult(String id);
	public int getJoinResult(MemberVo memberVo);
	public ArrayList<MemberVo> getList(int startCount, int endCount);
	public int getTotalRowCount();
}
