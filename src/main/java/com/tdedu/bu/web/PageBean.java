package com.tdedu.bu.web;

public class PageBean {
	private int startPage;//起始条数
	private int pageNum;//第几页
	private int pageSize;//每页条数
	
	public PageBean(int pageNum, int pageSize) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}
	public int getStartPage() {
		return (pageNum-1)*pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}	
}
