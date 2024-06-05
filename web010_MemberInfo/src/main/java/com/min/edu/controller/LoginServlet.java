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


public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -2302024328688378401L;
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("LoginServlet POST");
		req.setCharacterEncoding("UTF-8");
		// JSP 페이지에 <meta charset="UTF-8"> 이거보고.

		resp.setContentType("text/html; charset=UTF-8");

		IUserDao dao = new UserDaoImpl();

		// 전달값 받기
		String id = req.getParameter("id");
		// jsp에 name="id" name 값 가져옴!
		String password = req.getParameter("password");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", password);
		/*
		 * WHERE ID = #{id} AND PASSWORD = #{pw} 랑 같아야 함
		 */
		log.info("전달받은 요청 값: " + map);

		UserDto loginDto = dao.getLogin(map);
		if (loginDto != null) {// 로그인 성공
			HttpSession session = req.getSession();
			session.setAttribute("loginDto", loginDto); // 로그인 정보 담기
			session.setMaxInactiveInterval(10 * 60); // 10분동안 활동이 없으면 자동으로 세션 삭제

			// 이동 흐름
			// 값을 전송하지는 않지만 /WEB-INF/** 영역은 servlet을 통해서만 접근이 가능하기 때문에 Dispatcher 객체를 사용
			req.getRequestDispatcher("/WEB-INF/views/userMain.jsp").forward(req, resp);
			// 세션을 사용할 땐 세션이 계속 남아 오류가 발생하기 때문에 시크릿 창으로 서버 실행!

		} else { // 로그인 실패
			resp.getWriter().print("<script>alert('회원이 존재하지 않습니다.'); location.href='./' </script>");
		}

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("LoginServlet GET 요청");
		
		HttpSession session=req.getSession(); //세션 가져옴
		
		//세션 지움
		//invalidate
		//remove => 키 값으로 지우면 됨!
		session.invalidate();
		
		resp.sendRedirect("./");;
	}

}
