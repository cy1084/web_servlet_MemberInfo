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

public class DelUserServlet extends HttpServlet{

	private static final long serialVersionUID = -7385512789511851719L;
	private Logger log=Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("DelUserServlet GET 요청");
		
		HttpSession session=req.getSession();
		UserDto dto= (UserDto)session.getAttribute("loginDto");
		
		IUserDao dao=new UserDaoImpl();
		int n= dao.delUser(String.valueOf(dto.getSeq()));
		if(n==1) {
			resp.sendRedirect("./loginServlet.do");
		}else {
			req.getRequestDispatcher("/WEB-INF/views/err/500.html").forward(req, resp);
		}
	}

}
