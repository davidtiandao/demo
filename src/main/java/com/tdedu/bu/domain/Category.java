package com.tdedu.bu.domain;

public class Category {
	/*、
	 *课程分类表
	 */
	private String id;
	private String categoryName;
	private String categoryIntroduction;
	private int categoryHierarchy;
	private int categoryOrderNo;
	private String categoryParentId;
	private int categoryStatus;
	
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String id, String categoryName,
			String categoryIntroduction, int categoryHierarchy,
			int categoryOrderNo, String categoryParentId, int categoryStatus) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.categoryIntroduction = categoryIntroduction;
		this.categoryHierarchy = categoryHierarchy;
		this.categoryOrderNo = categoryOrderNo;
		this.categoryParentId = categoryParentId;
		this.categoryStatus = categoryStatus;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryIntroduction() {
		return categoryIntroduction;
	}
	public void setCategoryIntroduction(String categoryIntroduction) {
		this.categoryIntroduction = categoryIntroduction;
	}
	public int getCategoryHierarchy() {
		return categoryHierarchy;
	}
	public void setCategoryHierarchy(int categoryHierarchy) {
		this.categoryHierarchy = categoryHierarchy;
	}
	public int getCategoryOrderNo() {
		return categoryOrderNo;
	}
	public void setCategoryOrderNo(int categoryOrderNo) {
		this.categoryOrderNo = categoryOrderNo;
	}
	public String getCategoryParentId() {
		return categoryParentId;
	}
	public void setCategoryParentId(String categoryParentId) {
		this.categoryParentId = categoryParentId;
	}
	public int getCategoryStatus() {
		return categoryStatus;
	}
	public void setCategoryStatus(int categoryStatus) {
		this.categoryStatus = categoryStatus;
	}

	
}
