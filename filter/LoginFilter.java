package com.chngenesis.startrek.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.chngenesis.nebula.entity.session.SessionCache;
import com.chngenesis.startrek.commons.controller.BaseController;
import com.chngenesis.startrek.util.Constants;
import com.chngenesis.startrek.util.SessionUtil;

public class LoginFilter extends BaseController implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");//http://7.0.0.147:80
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String servletpath = request.getServletPath();
		String requestPath = servletpath.substring(1);
		String suffix = "";
		if (servletpath.contains(".")) {
			requestPath = servletpath.substring(1, servletpath.lastIndexOf("."));
			suffix = servletpath.substring(servletpath.lastIndexOf("."));
		}
		String token = request.getParameter("token");
		//获取客户端cookie中的sessionId 如果没有就从session中获取ID
		String sessionId = SessionUtil.getSessionId(request);
		//获取mongo db 中保存的session
		SessionCache sessionCache = SessionUtil.getSessionCache(sessionId);
		
		List<String> pathList = new ArrayList<String>();
		pathList.add(".js");
		pathList.add(".css");
		pathList.add(".jpg");
		pathList.add(".png");
		if ("user/checkLogin".equals(requestPath) || "index".equals(requestPath) || pathList.contains(suffix)
				|| Constants.HIS_TOKEN.equals(token)) {
			filterChain.doFilter(servletRequest, servletResponse);// 登录放行
		} else if (sessionCache != null && StringUtils.isNotBlank(sessionCache.getUserId())) {
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			//把sessionID放入响应
			Cookie cookie = new Cookie("JSESSIONID", sessionId);
			cookie.setPath("/");
			response.addCookie(cookie);
			PrintWriter out = response.getWriter();
			out.write("{\"error\":true,\"message\":\"未登录\"}");
			out.flush();
			out.close();
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
