package com.chngenesis.startrek.commons.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chngenesis.nebula.base.impl.BaseModel;
import com.chngenesis.nebula.config.service.IConfigService;
import com.chngenesis.nebula.entity.config.Config;
import com.chngenesis.nebula.entity.platform.Platform;
import com.chngenesis.nebula.entity.session.SessionCache;
import com.chngenesis.nebula.entity.user.User;
import com.chngenesis.startrek.util.Constants;

/**
 * 用户展开子菜单列表，点击子菜单列表后，打开子菜单列表相关配置信息
 * 
 * @author gongliang 2017.11.22
 *
 */
@Controller
@RequestMapping("config")
public class ConfigController extends BaseController {

	@Autowired
	private IConfigService configService;

	/**
	 * 获取服务器当前时间
	 * 
	 * @return 当前时间
	 */
	@RequestMapping("getNewDate")
	@ResponseBody
	public Map<String, Object> getNewDate() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = configService.getNewDate();
		} catch (Exception e) {
			e.printStackTrace();
			map.put("error", false);
			map.put("message", Constants.FAIL);
		}
		return map;
	}

	/**
	 * 根据版本号和功能ID查询配置
	 * 
	 * @param request
	 * @param version
	 *            版本号
	 * @param functionId
	 *            配置ID
	 * @return
	 */
	@RequestMapping("queryConfigContent")
	@ResponseBody
	public BaseModel<Object> queryConfigContent(HttpServletRequest request, BigDecimal version, String functionId) {
		if (version == null) {
			version = Constants.VERSION;
		}
		SessionCache sessionCache = this.getSessionAttribute(request);
		BaseModel<Object> configContent = new BaseModel<Object>();
		try {
			configContent = configService.queryConfigContent(sessionCache.getUserId(), Constants.PLATFORMID, version,
					functionId);
		} catch (Exception e) {
			e.printStackTrace();
			configContent.setError(true);
			configContent.setMessage(Constants.FAIL);
			configContent.setException(e);
		}
		return configContent;
	}

	/**
	 * 更新快捷键信息
	 * 
	 * @param functionId
	 *            功能ID
	 * @param content
	 *            包含快捷键更新的数据信息(主要为mongodb中的数据配置信息)
	 * @return
	 */
	@RequestMapping("updateByFunctionId")
	@ResponseBody
	public BaseModel<Config> updateByFunctionId(HttpServletRequest request, String functionId, String content) {
		Config config = new Config();
		config.setFunctionId(functionId);
		config.setContent(content);
		config.setPlatformId(new Platform(Constants.PLATFORMID));
		config.setVersion(Constants.VERSION);
		SessionCache sessionCache = this.getSessionAttribute(request);
		config.setUserId(new User(sessionCache.getUserId()));
		BaseModel<Config> baseModel = new BaseModel<Config>();
		try {
			baseModel = configService.updateByFunctionId(config);
		} catch (Exception e) {
			e.printStackTrace();
			baseModel.setError(true);
			baseModel.setMessage(Constants.FAIL);
			baseModel.setException(e);
		}
		return baseModel;
	}

}
