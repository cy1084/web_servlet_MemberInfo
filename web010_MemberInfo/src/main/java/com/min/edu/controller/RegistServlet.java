package com.min.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class RegistServlet extends HttpServlet {

	private static final long serialVersionUID = 2772821829390871282L;
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("RegistServlet GET 요청");
		req.getRequestDispatcher("/WEB-INF/views/registForm.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("RegistServlet POST 요청");
		req.setCharacterEncoding("UTF-8");

		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		System.out.printf("%s: %s: %s: %s: %s: %s: \n", id, password, name, address, email, phone);
		
		UserDto dto=new UserDto(id, password, name, address, email, phone);
		
		IUserDao dao=new UserDaoImpl();
		
		int row=dao.insertUser(dto);
		if(row==1) {
			resp.sendRedirect("./");
		}else {
			resp.sendRedirect("./registServlet.do");
		}
	}

}
