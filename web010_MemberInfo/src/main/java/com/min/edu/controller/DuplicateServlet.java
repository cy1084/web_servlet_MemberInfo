package com.min.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class DuplicateServlet extends HttpServlet {

	private static final long serialVersionUID = 6667008269082307553L;
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("DuplicateServlet GET 요청");
		String id=req.getParameter("id");
		log.info("요청받은 값: "+id);
		
		IUserDao dao=new UserDaoImpl();
		String checkId=dao.duplicateId(id);
		boolean isc=false;
	
		if(checkId==null) { //사용할 수 있는 아이디
			isc=true;
		}
		req.setAttribute("isc", isc);
		req.getRequestDispatcher("/WEB-INF/views/idCheck.jsp").forward(req, resp);
		
	}
	
	

}
