package com.chngenesis.nebula.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.chngenesis.nebula.base.IBaseDao;
import com.chngenesis.nebula.util.ReflectionUtil;
import com.chngenesis.nebula.util.StringUtil;
import com.chngenesis.nebula.util.SystemConstant;

/**
 * 父类的setSessionFactory是 final 型的，所以我们不能override此方法
 * 因此需要修改方法名称，此处使用setSuperSessionFactory()
 * 可以考虑考虑把所有公共的方法都写在BaseDao中，这个时候，让所有的DAO都继承BaseDao；
 * 这样基本上就实现了大量的基础方法，如果DAO中又一些特殊方法，再再具体的实现类的DAO中创建。
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {

	@SuppressWarnings("rawtypes")
	private Class clazz;

	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * 获取泛型的clazz
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Class<T> getClz() {
		if (clazz == null) {
			clazz = (Class<T>) (((ParameterizedType) this.getClass().getGenericSuperclass())
					.getActualTypeArguments()[0]);
		}
		return clazz;
	}

	@Override
	public String save(T entity) {
		return (String) this.getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(String id) {
		T entity = queryById(id);// 先查询出来在进行删除
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(T entity) {
		HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
		hibernateTemplate.update(entity);
	}

	@Override
	public T queryById(String id) {
		return this.getHibernateTemplate().get(getClz(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T queryByIdNoDel(String id) {
		Criteria criteria = this.getCriteria();
		criteria.add(Restrictions.eq("id", id));
		if (ReflectionUtil.haveField(getClz(), "del")) {
			criteria.add(Restrictions.eq("del", SystemConstant.NOT_DEL));
		}
		return (T) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryByIds(String[] ids) {
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.in("id", ids));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryByIdsNoDel(String[] ids) {
		Criteria criteria = getCriteria();
		criteria.add(Restrictions.in("id", ids));
		if (ReflectionUtil.haveField(getClz(), "del")) {
			criteria.add(Restrictions.eq("del", SystemConstant.NOT_DEL));
		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryAll() {
		Criteria criteria = getCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryAllNoDel() {
		Criteria criteria = getCriteria();
		if (ReflectionUtil.haveField(getClz(), "del")) {
			criteria.add(Restrictions.eq("del", SystemConstant.NOT_DEL));
		}
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

	@Override
	public List<T> pageQuery(BaseQuery<T> baseQuery) {
		return pageQuery(baseQuery, null);
	}

	public List<T> pageQuery(BaseQuery<T> baseQuery, Criteria criteria) {

		if (baseQuery == null) {
			return null;
		}

		if (criteria == null) {
			criteria = getCriteria();
		}

		if (ReflectionUtil.haveField(getClz(), "del")) {
			/***
			 * 根据前台传递的del选择是否需要根据del查询
			 */
			if (baseQuery.getDel() != null) {
				criteria.add(Restrictions.eq("del", baseQuery.getDel()));
			}
		}

		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.setFirstResult(baseQuery.getPageNum() * (baseQuery.getCurrentPage() - 1));
		criteria.setMaxResults(baseQuery.getPageNum());
		@SuppressWarnings("unchecked")
		List<T> pageList = criteria.list();
		return pageList;
	}

	@Override
	public Integer getTotalNumber(BaseQuery<T> baseQuery) {
		Integer totalNumber = 0;
		Criteria criteria = this.getCriteria();
		if (ReflectionUtil.haveField(getClz(), "del")) {
			if (baseQuery.getDel() != null) {
				criteria.setProjection(Projections.count("del"));
				criteria.add(Restrictions.eq("del", baseQuery.getDel()));
			} else {
				criteria.setProjection(Projections.rowCount());
			}
		} else {
			criteria.setProjection(Projections.rowCount());
		}

		if (criteria.uniqueResult() == null) {
			return totalNumber;
		}
		totalNumber = new Integer(criteria.uniqueResult() + "");
		return totalNumber;
	}

	@Override
	public Integer conditionTotalNumber(Criteria criteria) {
		criteria.setFirstResult(0);
		return new Integer(criteria.setProjection(Projections.rowCount()).uniqueResult() + "");
	}

	@Override
	public Criteria getCriteria() {
		return this.getSessionFactory().getCurrentSession().createCriteria(getClz());
	}

	@Override
	public boolean checkExist(String queryName, Object value) {
		if (this.getCriteria().add(Restrictions.eq(queryName, value)).uniqueResult() == null)
			return false;
		return true;
	}

	@Override
	public void logicDelete(String id) {
		String hql = "update " + getClz().getSimpleName() + " set del = " + SystemConstant.DEL + " where id = ?";
		this.getSessionFactory().getCurrentSession().createQuery(hql).setString(0, id).executeUpdate();
	}

	@Override
	public Integer logicDeleteByIds(String[] ids) {
		String hql = "update " + getClz().getSimpleName() + " set del = " + SystemConstant.DEL + " where id in ( ";
		hql = StringUtil.bulkPlaceholders(hql, ids);

		Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);
		for (int i = 0; i < ids.length; i++) {
			query.setString(i, ids[i]);
		}
		return query.executeUpdate();
	}

	@Override
	public int updateStatus(Serializable[] ids, Integer status) {
		String hql = "UPDATE " + getClz().getSimpleName() + " SET status = " + status + " WHERE id IN (:ids)";
		// .setParameterList("ids", ids).executeUpdate();
		Query query = this.getSessionFactory().getCurrentSession().createQuery(hql).setParameterList("ids", ids);
		return query.executeUpdate();
	}

	@Override
	public Session getSession() {
		return this.getSessionFactory().getCurrentSession();
	}

	@Override
	public void saveList(List<T> entity) {
		for (int i = 0; i < entity.size(); i++) {
			this.save(entity.get(i));
			if (i != 0 && i % 10 == 0) {
				this.getHibernateTemplate().flush();
				this.getHibernateTemplate().clear();
			}
		}
	}

	@Override
	public int updateStatus(Serializable id, Integer status) {
		String hql = "UPDATE " + getClz().getSimpleName() + " SET status = " + status + " WHERE id =:id";
		Query query = this.getSessionFactory().getCurrentSession().createQuery(hql).setParameter("id", id);
		return query.executeUpdate();
	}

	@Override
	public void flush() {
		this.getSession().flush();
	}

	@Override
	public void clear() {
		this.getSession().clear();
	}


}
