package com.mycgv_jsp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycgv_jsp.vo.BoardVo;

@Repository
public class BoardDao implements MycgvDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// ��ȸ�� ����
	public void updateHits(String bid) {
		sqlSession.selectOne("mapper.board.updateHits", bid);
	}
	
	// �Խù� ����
	public int delete(String bid) {
		return sqlSession.delete("mapper.board.delete", bid);
	}
	
	// �Խù� ���� 
	public int update(BoardVo boardVo) {
		return sqlSession.update("mapper.board.update", boardVo);
	}
	
	// �Խù� �� ��ȸ
	public BoardVo select(String bid) {
		return sqlSession.selectOne("mapper.board.content",bid);
	}
	
	//����¡ ó�� - startCount, endCount
	@Override
	public List<Object> select(int startCount,int endCount) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		return sqlSession.selectList("mapper.board.list", param);
	}
	
	@Override
	public int insert(Object boardVo) {
		return sqlSession.insert("mapper.board.write", boardVo);
	}
	
//	//�Խñ� ���
//	public int insert(BoardVo boardVo) {
//		return sqlSession.insert("mapper.board.write", boardVo);
//	}
}
