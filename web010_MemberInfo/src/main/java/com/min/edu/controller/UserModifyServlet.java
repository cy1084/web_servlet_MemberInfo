package com.min.edu.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dto.UserDto;
import com.min.edu.model.IUserDao;
import com.min.edu.model.UserDaoImpl;

public class UserModifyServlet extends HttpServlet {

	private static final long serialVersionUID = 8682479110134628960L;
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("UserModifyServlet GET 요청");

		HttpSession session = req.getSession();
		UserDto loginDto = (UserDto) session.getAttribute("loginDto");

		IUserDao dao = new UserDaoImpl();
		UserDto dto = dao.getUserInfo(loginDto.getSeq() + "");
		req.setAttribute("info", dto);

		req.getRequestDispatcher("/WEB-INF/views/modifyForm.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("UserModifyServlet POST 요청");

		req.setCharacterEncoding("UTF-8");
		
		HttpSession session=req.getSession();
		UserDto loginDto=(UserDto)session.getAttribute("loginDto");
		
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");

		Map<String, Object> map = new HashMap<String, Object>() {
			{
				put("address", address);
				put("phone", phone);
				put("email", email);
				put("seq",loginDto.getSeq());
			}
		};
		log.info("전달받은 요청 값: " + map);
		
		IUserDao dao= new UserDaoImpl();
		int n=dao.updateUserInfo(map);
		if(n==1) {
			resp.sendRedirect("./userInfo.do");
		}else {
			resp.getWriter().print("<script>alert('정보를 수정하지 못했습니다.\n 다시 진행해 주세요'); location.href='./userModifyServlet.do'</script>");
		}
		}
	}


