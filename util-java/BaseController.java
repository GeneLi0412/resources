package com.chngenesis.startrek.commons.controller;

import com.chngenesis.nebula.entity.session.SessionCache;
import com.chngenesis.startrek.util.SessionUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 提供session的get、set方法
 * 
 * @author gongliang 2017.11.22
 *
 */
public class BaseController {
	
	@ExceptionHandler
	@ResponseBody
	public Map<String, Object> exp(HttpServletRequest request, Exception ex) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("error", true);
		model.put("message", ex.getMessage());
		return model;
	}
	
	/**
	 * 获取SESSION缓存数据对象
	 * @param request
	 * @return
	 */
	public SessionCache getSessionAttribute(HttpServletRequest request) {
		return SessionUtil.getSessionCache(SessionUtil.getSessionId(request));
	}

	/**
	 * 像SESSION中存入需要缓存数据
	 * @param request
	 * @param userId 用户ID
	 * @param userName 用户名称
	 * @param accountId 登录ID
	 */
	public void setSessionAttribute(HttpServletRequest request, String userId, String userName, String accountId) {
		SessionCache sessionCache = SessionUtil.getSessionCache(SessionUtil.getSessionId(request));
		sessionCache.setUserId(userId);
		sessionCache.setUserName(userName);
		sessionCache.setAccountId(accountId);
		SessionUtil.UpdateSessionAttr(sessionCache);
	}
}
