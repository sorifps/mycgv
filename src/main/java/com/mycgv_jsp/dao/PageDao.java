package com.mycgv_jsp.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PageDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int totalRowCount(String sname) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("sname", sname);
		return sqlSession.selectOne("mapper.page.count", param);
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
