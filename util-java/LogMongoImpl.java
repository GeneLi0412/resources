package com.chngenesis.nebula.base.impl;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * mongodb操作日志基本操作类
 * @author yaofei
 *
 * @param <T>
 */
public abstract class LogMongoImpl<T> extends AbstractBaseMongoImpl<T> {

	/**
	 * spring mongodb 集成操作类
	 */
	@Resource(name = "mongoTemplateLog")
	protected MongoTemplate mongoTemplate;

	/**
	 * 注入mongodbTemplate
	 * 
	 * @param mongoTemplate
	 */
	protected void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	protected MongoTemplate getMongoTemplate() {
		return this.mongoTemplate;
	}

}
