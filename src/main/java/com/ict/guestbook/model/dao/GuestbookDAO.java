package com.ict.guestbook.model.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ict.guestbook.model.vo.GuestbookVO;

@Repository
public class GuestbookDAO {
	private static final Logger logger = LoggerFactory.getLogger(GuestbookDAO.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	// Guestbook 리스트
	public List<GuestbookVO> guestbookList(){
		List<GuestbookVO> list = sqlSessionTemplate.selectList("guestbook.list");
		return list ;
	}	
	
}
