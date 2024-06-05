package com.min.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class UserInfoServlet extends HttpServlet {

	
	private static final long serialVersionUID = 4037469176017131722L;
	private Logger log=Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("UserInfoServlet GET 요청");
		
		//세션 정보 가져옴 
		HttpSession session=req.getSession();
		UserDto loginDto= (UserDto)session.getAttribute("loginDto");
		
		log.info("로그인된 사용자의 seq 값: "+loginDto.getSeq());
		
		IUserDao dao=new UserDaoImpl();
		UserDto userInfo= dao.getUserInfo(String.valueOf(loginDto.getSeq())); //seq는 숫자이므로 String으로 바꿔줌
		
		req.setAttribute("info", userInfo);
		req.getRequestDispatcher("/WEB-INF/views/userInfo.jsp").forward(req, resp);
	}

}
