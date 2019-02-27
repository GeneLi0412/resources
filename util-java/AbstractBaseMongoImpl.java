package com.chngenesis.nebula.base.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.chngenesis.nebula.base.MongoRepository;
import com.mongodb.WriteResult;

/**
 * mongodb的基本操作类
 * 
 * @author yaofei
 *
 * @param <T>
 */
public abstract class AbstractBaseMongoImpl<T> implements MongoRepository<T> {


	@SuppressWarnings("rawtypes")
	private Class clazz;

	@SuppressWarnings("unchecked")
	protected Class<T> getClazz() {
		if (clazz == null) {
			clazz = (Class<T>) (((ParameterizedType) this.getClass().getGenericSuperclass())
					.getActualTypeArguments()[0]);
		}
		return clazz;
	}
	
	protected abstract MongoTemplate getMongoTemplate();

	@Override
	public T save(T entity) {
		this.getMongoTemplate().save(entity);
		return entity;
	}

	@Override
	public T save(T entity, String collectionName) {
		this.getMongoTemplate().save(entity, collectionName);
		return entity;
	}

	@Override
	public T findById(String id) {
		return this.getMongoTemplate().findById(id, this.getClazz());
	}

	@Override
	public T findById(String id, String collectionName) {
		return this.getMongoTemplate().findById(id, this.getClazz(), collectionName);
	}

	@Override
	public List<T> findAll() {
		return this.getMongoTemplate().findAll(this.getClazz());
	}

	@Override
	public List<T> findAll(String collectionName) {
		return this.getMongoTemplate().findAll(this.getClazz(), collectionName);
	}

	@Override
	public List<T> find(Query query) {
		return this.getMongoTemplate().find(query, this.getClazz());
	}

	@Override
	public T findOne(Query query) {
		return this.getMongoTemplate().findOne(query, this.getClazz());
	}

	@Override
	public long count(Query query) {
		return this.getMongoTemplate().count(query, this.getClazz());
	}

	@Override
	public WriteResult update(Query query, Update update) {
		if (update == null) {
			return null;
		}
		return this.getMongoTemplate().updateMulti(query, update, this.getClazz());
	}

	@SuppressWarnings("unchecked")
	@Override
	public T updateFirst(Query query, Update update) {
		if (update == null) {
			return null;
		}
		return (T) this.getMongoTemplate().updateFirst(query, update, this.getClazz());
	}

	@Override
	public T updateOne(Query query, Update update) {
		if (update == null) {
			return null;
		}
		return this.getMongoTemplate().findAndModify(query, update, this.getClazz());
	}

	@Override
	public void remove(Query query) {
		this.getMongoTemplate().remove(query, this.getClazz());
	}

	@Override
	public abstract WriteResult update(T entity);

}
