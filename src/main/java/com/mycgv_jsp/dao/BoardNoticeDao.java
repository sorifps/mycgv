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
	
	// 공지사항 카운트 처리
	@Override
	public List<Object> select(int startCount, int endCount){
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("startCount", startCount);
		param.put("endCount", endCount);
		
		List<Object> list = sqlSession.selectList("mapper.notice.list", param);
		return list;
	}
	
	// 공지사항 조회수 업데이트
	public void updateHits(String bnid) {
		sqlSession.selectOne("mapper.notice.noticeUpdateHits", bnid);
	}
	
	// 공지사항 내용 삭제
	public int delete(String bnid) {
		return sqlSession.delete("mapper.notice.delete", bnid);
	}
	
	@Override
	public int insert(Object boardNoticeVo) {
		return sqlSession.insert("mapper.notice.write", boardNoticeVo);
	}
	
//	// 공지사항 내용 글쓰기
//	public int insert(BoardNoticeVo boardNoticeVo) {
//		return sqlSession.insert("mapper.notice.write", boardNoticeVo);
//	}
	
	// 공지사항 내용 업데이트
	public int update(BoardNoticeVo boardNoticeVo) {
		return sqlSession.update("mapper.notice.update", boardNoticeVo);
	}

	// 공지사항 콘텐츠 조회
	public BoardNoticeVo select(String bnid) {
		return sqlSession.selectOne("mapper.notice.content", bnid);
	}
	
}
