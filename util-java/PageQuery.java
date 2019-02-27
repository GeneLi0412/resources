package com.chngenesis.nebula.base.impl;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象封装分页查询的结果
 * 
 * @author Administrator
 * @param <T>
 */
public class PageQuery<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int currentPage = 1;// 当前查询页码
	private int totalPage;// 总页码
	private int totalNumber;// 总条数
	private int pageNum = 10;// 每页显示条数
	private List<T> queryList;// 返回的数据集合
	private int nextPage; // 下一页
	private int previousPage; // 上一页

	public PageQuery(int currentPage, int pageNum, int totalNumber, List<T> queryList) {
		this.currentPage = currentPage;
		this.pageNum = pageNum;
		this.totalNumber = totalNumber;
		this.queryList = queryList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		if(pageNum!=0){
			this.totalPage = totalNumber % pageNum == 0 ? totalNumber / pageNum : totalNumber / pageNum + 1;
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public List<T> getQueryList() {
		return queryList;
	}

	public void setQueryList(List<T> queryList) {
		this.queryList = queryList;
	}

	public int getNextPage() {
		this.nextPage = currentPage + 1 > totalPage ? currentPage : currentPage + 1;
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getPreviousPage() {
		this.previousPage = currentPage - 1 < 1 ? 1 : currentPage - 1;
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

}
