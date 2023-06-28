package com.mycgv_jsp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycgv_jsp.vo.MemberVo;
import com.mycgv_jsp.vo.SessionVo;


@Repository
public class MemberDao implements MycgvDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int totalRowCount(String sname) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("sname", sname);
		return sqlSession.selectOne("mapper.page.count", param);
	}	
	
	// 회원 조회
	@Override
	public List<Object> select(int startCount, int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		List<Object> list = sqlSession.selectList("mapper.member.list", param);
		return list;
	}
	
	// 중복체크
	public SessionVo loginCheck(MemberVo memberVo) {
		return sqlSession.selectOne("mapper.member.loginResult",memberVo);
	}
	
	public int idCheck(String id) {
		return sqlSession.selectOne("mapper.member.idCheck", id);
	}
	
	@Override
	public int insert(Object memberVo) {
		return sqlSession.insert("mapper.member.join", memberVo);
	}
	
//	// 회원가입
//	public int insert(MemberVo memberVo) {
//		return sqlSession.insert("mapper.member.join",memberVo);
//	}
}
