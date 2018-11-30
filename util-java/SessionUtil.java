package com.chngenesis.startrek.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.chngenesis.nebula.entity.session.SessionCache;
import com.chngenesis.nebula.session.service.ISessionCacheService;

/**
 * session 缓存数据 相关
 * @author zhanghengrui 2018-10-17
 *
 */
public class SessionUtil {
	
	/**
	 * 从请求中的cookie获取sessionId 没有就创建新的session
	 * @param request
	 * @return
	 */
	public static String getSessionId(HttpServletRequest request) {
		String sessionId = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("JSESSIONID")) {
					sessionId = cookie.getValue();
				}
			}
		}
		if(StringUtils.isBlank(sessionId)) {
			sessionId = request.getSession().getId();
		}
		return sessionId;
	}
	
	/**
	 * 根据sessionId 获取session缓存对象
	 * @param sessionId
	 * @return
	 */
	public static SessionCache getSessionCache(String sessionId) {
		SessionCache sessionCache = null;
		if(StringUtils.isNotBlank(sessionId)) {
			ISessionCacheService sessionCacheService = (ISessionCacheService) SpringContextUtil
					.getBean("sessionCacheService");
			sessionCache = sessionCacheService.findBySessionKey("JSESSIONID" + sessionId);
		}
		return sessionCache;
	}
	
	/**
	 * 保存新的session缓存数据对象
	 * @param sessionId sessionId
	 */
	public static void saveNewSession(String sessionId, String platformId) {
		ISessionCacheService sessionCacheService = (ISessionCacheService) SpringContextUtil
				.getBean("sessionCacheService");
		sessionCacheService.save(sessionId, platformId);
	}
	
	/**
	 * 更新session缓存数据
	 * @param sessionCache
	 */
	public static void UpdateSessionAttr(SessionCache sessionCache) {
		ISessionCacheService sessionCacheService = (ISessionCacheService) SpringContextUtil
				.getBean("sessionCacheService");
		sessionCacheService.update(sessionCache);
	}
	
	/**
	 * 根据sessionId删除session缓存数据
	 * @param sessionKey sessionId
	 */
	public static void delSession(String sessionKey) {
		ISessionCacheService sessionCacheService = (ISessionCacheService) SpringContextUtil
				.getBean("sessionCacheService");
		sessionCacheService.delete(sessionKey);
	}
}
