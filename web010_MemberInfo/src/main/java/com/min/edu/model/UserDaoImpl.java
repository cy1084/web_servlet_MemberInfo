package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.UserDto;
import com.min.edu.support.SqlSessionFactoryCreate;

public class UserDaoImpl implements IUserDao {

	private Logger log = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlSessionFactoryCreate.getFactory();
	private final String NS = "com.min.edu.model.UserDaoImpl.";

	@Override
	public List<UserDto> getAllUserStatus() {
		log.info("전체 사용자 조회");
		SqlSession session = manager.openSession();

		return session.selectList(NS + "getAllUserStatus");
	}

	@Override
	public List<UserDto> getAllUser() {
		log.info("사용 가능한 사용자 조회");
		SqlSession session = manager.openSession();

		return session.selectList(NS + "getAllUser");
	}

	@Override
	public int updateAuthUser(Map<String, Object> map) {
		log.info("권한 수정: " + map);
		SqlSession session = manager.openSession();

		int n=session.update(NS+"updateAuthUser",map);
		
		if(n==1) { //성공했다면, if문 대신 int n=session.update(NS+"updateAuthUser",map);의 try catch도 가능
			session.commit();
		}else {
			session.rollback();
		}
		
		return n;
	}

	@Override
	public int insertUser(UserDto dto) {
		log.info("사용자 입력 " + dto);
		SqlSession session = manager.openSession(true);

		return session.insert(NS+"insertUser",dto);
	}

	@Override
	public UserDto getLogin(Map<String, Object> map) {
		log.info("로그인" + map);
		SqlSession session = manager.openSession();
		
		return session.selectOne(NS+"getLogin",map);
	}

	@Override
	public UserDto getUserInfo(String seq) {
		log.info("사용자 상세 정보" + seq);
		SqlSession session = manager.openSession();
		
		return session.selectOne(NS+"getUserInfo",seq);
	}

	@Override
	public int updateUserInfo(Map<String, Object> map) {
		log.info("사용자 정보 수정" + map);	
		SqlSession session = manager.openSession(true);
		
		return session.update(NS+"updateUserInfo",map);
	}

	@Override
	public int delUser(String seq) {
		log.info("사용자 삭제" + seq);
		SqlSession session = manager.openSession(true);
		
		return session.delete(NS+"delUser",seq);
	}

	@Override
	public String duplicateId(String id) {
		log.info("아이디 중복 체크" + id);
		SqlSession session = manager.openSession();
		
		return session.selectOne(NS+"duplicateId",id);
	}

}
