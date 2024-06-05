package com.test.edu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class Scenario_JUnitTest {

	private IUserDao dao;

	@Before
	public void createDao() {
		dao = new UserDaoImpl();
	}

	//@Test
	public void registTest() {
		String checkId = dao.duplicateId("newUser1");
		assertNull(checkId);

		UserDto dto = new UserDto("newUser1", "newUser", "newUser", "새로운사용자", "금천구", "000");
		int row = dao.insertUser(dto);
		assertEquals(1, row);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", dto.getId());
		map.put("pw", dto.getPassword());
		UserDto loginDto = dao.getLogin(map);
		assertNotNull(loginDto);
	}
	
	
}
