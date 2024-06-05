package com.test.edu;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.min.edu.support.SqlSessionFactoryCreate;

public class MemberInfo_JUnitTest {

	private SqlSession session;
	
	@Before
	public void sqlSession_Test() {
		SqlSessionFactory factory=SqlSessionFactoryCreate.getFactory();
		session=factory.openSession();
		assertNotNull(session);
	}
	
	@Test
	public void duplicate_Test() {
		//있을 땐 id 반환, 초록색
		//없을 땐 공집합(null), 빨간색
		
		String checkId= session.selectOne("com.min.edu.model.UserDaoImpl.duplicateId","HAPPY");
		//정상 작동
		
		//String checkId= session.selectOne("com.min.edu.model.UserDaoImpl.duplicateId","HAPPY0");
		//없으므로 빨간색 뜸
		assertNotNull(checkId);
	}
	
	

}
