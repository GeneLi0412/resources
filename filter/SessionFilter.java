package com.chngenesis.startrek.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chngenesis.nebula.entity.session.SessionCache;
import com.chngenesis.startrek.util.Constants.SessionCaChePlatform;
import com.chngenesis.startrek.util.SessionUtil;

public class SessionFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:63342");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		String sessionId = SessionUtil.getSessionId(request);
		SessionCache sessionCache = null;
		sessionCache = SessionUtil.getSessionCache(sessionId);
		if (sessionCache == null) {
			SessionUtil.saveNewSession(sessionId, SessionCaChePlatform.HIS);
		} else {
			long oldDate = sessionCache.getLastTime().getTime();
			long newDate = new Date().getTime();
			long num = newDate - oldDate;
			int number = (int) (num / (60 * 1000));
			if (number > 30) {
				SessionUtil.delSession(sessionCache.getSessionKey());
				SessionUtil.saveNewSession(sessionId, SessionCaChePlatform.HIS);
			} else {
				sessionCache.setLastTime(new Date());
				SessionUtil.UpdateSessionAttr(sessionCache);
			}
		}
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		filterChain.doFilter(servletRequest, servletResponse);
		Cookie cookie = new Cookie("JSESSIONID", sessionId);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
