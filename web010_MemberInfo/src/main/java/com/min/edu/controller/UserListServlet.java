package com.min.edu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class UserListServlet extends HttpServlet {

	private static final long serialVersionUID = 7283944796406591586L;
	private Logger log=Logger.getLogger(UserListStateServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("UserListServlet GET 요청");
		
		IUserDao dao=new UserDaoImpl();
		List<UserDto> lists=dao.getAllUser();
		req.setAttribute("lists", lists);
		req.getRequestDispatcher("/WEB-INF/views/userList.jsp").forward(req, resp);
	}
}
