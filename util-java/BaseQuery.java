package com.chngenesis.nebula.base.impl;

import java.io.Serializable;

public class BaseQuery<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer  currentPage=1;// 当前查询页码
	private Integer pageNum=10;// 每页显示条数
	private String hql;// 分页语句
	private Integer del=0;
	
	public Integer getDel() {
		return del;
	}
	public void setDel(Integer del) {
		this.del = del;
	}
	public BaseQuery(Integer currentPage, Integer pageNum) {
		super();
		this.currentPage = currentPage;
		this.pageNum = pageNum;
	}
	public BaseQuery() {
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public String getHql() {
		return hql;
	}
	public void setHql(String hql) {
		this.hql = hql;
	}
	
}
