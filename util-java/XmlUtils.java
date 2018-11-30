package com.chngenesis.nebula.util;

import org.apache.commons.lang.StringUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlUtils {

	public static XStream instance = null;

	static {
		if (instance == null) {
			instance = new XStream(new DomDriver());
			instance.ignoreUnknownElements();
		}
	}

	/**
	 * 转换为对象
	 * 
	 * @param clazz
	 * @param xml
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Object parseObj(Class clazz, String xml) {
		instance.processAnnotations(clazz);
		if (StringUtils.isBlank(xml)) {
			return null;
		}
		return instance.fromXML(xml);

	}
}
