package com.min.edu.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class AuthUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = -2923849169927007755L;
	private Logger log=Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("AuthUpdateServlet GET 요청");
		String seq=req.getParameter("seq");
		log.info("권한변경요청 seq: "+seq);
		
		IUserDao dao=new UserDaoImpl();
		UserDto dto=dao.getUserInfo(seq);
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/WEB-INF/views/authUpdateForm.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("AuthUpdateServlet POST 요청");
//		req.setCharacterEncoding("UTF-8");
		
		String seq=req.getParameter("seq");
		String role=req.getParameter("role");
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("seq", seq);
		map.put("auth", role);
		log.info("전달받은 요청 값: "+map);
		
		IUserDao dao=new UserDaoImpl();
		int row=dao.updateAuthUser(map);
		if(row==1) {
			resp.sendRedirect("./userListServlet.do");
		}else {
			resp.sendRedirect("./authUpdate.do?seq="+seq);
		}
	}

}
