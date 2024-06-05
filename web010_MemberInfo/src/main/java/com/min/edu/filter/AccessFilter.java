package com.min.edu.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.min.edu.dto.UserDto;

public class AccessFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 8154889922223902974L;
	private List<String> excludeURLS;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("필터를 통과합니다!!!!!!!!");

		HttpServletRequest request = (HttpServletRequest) req;
		String pathURL = request.getServletPath(); // 현재 요청하는 애

		if (!excludeURLS.contains(pathURL)) {
			// 로그인 상태 확인
			HttpSession session = request.getSession();
			UserDto loginDto = (UserDto) session.getAttribute("loginDto");

			if (loginDto != null) {
				chain.doFilter(req, res); // 흐름대로 가
			} else {
				System.out.println("로그인을 먼저 진행해주세요");
				chain.doFilter(req, res);
			}
		} else {
			chain.doFilter(req, res);
		}

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String excludePattern = config.getInitParameter("excludeURL");
		excludeURLS = Arrays.asList(excludePattern.split(","));
		System.out.println("제외 요청 주소 리스트: " + excludeURLS);
	}

}
