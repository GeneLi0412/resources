package com.chngenesis.nebula.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.chngenesis.nebula.base.impl.BaseQuery;

/**
 * 操作dao层的基本类，封装了基本操作
 * 
 * @author Administrator
 * @param <T>
 */
public interface IBaseDao<T> {

	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	String save(T entity);

	/**
	 * 批量新增
	 * 
	 * @param entity
	 */
	void saveList(List<T> entity);

	/**
	 * 删除实体
	 * 
	 * @param id
	 */
	void delete(String id);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 按id查询
	 * 
	 * @param id
	 * @return
	 */
	T queryById(String id);

	/**
	 * 根据id查询未逻辑删除的结果
	 * 
	 * @param id
	 * @return
	 */
	T queryByIdNoDel(String id);

	/**
	 * 按id查询
	 * 
	 * @param ids
	 * @return
	 */
	List<T> queryByIds(String[] ids);

	/**
	 * 按id查询未逻辑删除的结果
	 * 
	 * @param ids
	 * @return
	 */
	List<T> queryByIdsNoDel(String[] ids);

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<T> queryAll();

	/**
	 * 查询所有未逻辑删除的结果
	 * 
	 * @return
	 */
	List<T> queryAllNoDel();

	/**
	 * 分页查询
	 */
	List<T> pageQuery(BaseQuery<T> baseQuery);

	/**
	 * 查询总的条数
	 * 
	 * @param baseQuery
	 * @return
	 */
	Integer getTotalNumber(BaseQuery<T> baseQuery);

	/**
	 * 查询总的条数，带条件
	 */
	Integer conditionTotalNumber(Criteria criteria);

	/**
	 * getCriteria
	 */
	public Criteria getCriteria();

	/* List<T> conditionQueryBycriteria(ProjectionList projectionList); */

	/**
	 * 判断是否已存在
	 * 
	 * @param queryName
	 * @param value
	 * @return 存在为true，不存在为false
	 */
	boolean checkExist(String queryName, Object value);

	/**
	 * 逻辑删除一个实体
	 * 
	 * @param id
	 */
	void logicDelete(String id);

	/**
	 * 批量删除
	 * 
	 * @param id
	 *            返回删除的条数
	 */
	Integer logicDeleteByIds(String[] ids);

	/**
	 * 批量修改状态
	 * 
	 * @param ids
	 * @param status
	 * @return
	 */
	int updateStatus(Serializable[] ids, Integer status);

	/**
	 * 修改状态
	 * 
	 * @param ids
	 * @param status
	 * @return
	 */
	int updateStatus(Serializable id, Integer status);

	/**
	 * 获取session
	 * 
	 * @return
	 */
	Session getSession();
	
	public void flush();
	
	public void clear();

}
