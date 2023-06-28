package com.mycgv_jsp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycgv_jsp.vo.BoardNoticeVo;

@Repository
public class BoardNoticeDao implements MycgvDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// �������� ī��Ʈ ó��
	@Override
	public List<Object> select(int startCount, int endCount){
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		
		List<Object> list = sqlSession.selectList("mapper.notice.list", param);
		return list;
	}
	
	// �������� ��ȸ�� ������Ʈ
	public void updateHits(String bnid) {
		sqlSession.selectOne("mapper.notice.noticeUpdateHits", bnid);
	}
	
	// �������� ���� ����
	public int delete(String bnid) {
		return sqlSession.delete("mapper.notice.delete", bnid);
	}
	
	@Override
	public int insert(Object boardNoticeVo) {
		return sqlSession.insert("mapper.notice.write", boardNoticeVo);
	}
	
//	// �������� ���� �۾���
//	public int insert(BoardNoticeVo boardNoticeVo) {
//		return sqlSession.insert("mapper.notice.write", boardNoticeVo);
//	}
	
	// �������� ���� ������Ʈ
	public int update(BoardNoticeVo boardNoticeVo) {
		return sqlSession.update("mapper.notice.update", boardNoticeVo);
	}

	// �������� ������ ��ȸ
	public BoardNoticeVo select(String bnid) {
		return sqlSession.selectOne("mapper.notice.content", bnid);
	}
	
}
