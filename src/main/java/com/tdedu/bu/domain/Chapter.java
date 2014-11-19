package com.tdedu.bu.domain;

import java.util.Date;

public class Chapter {
	/*
	 * 章节表
	 */
	private String id;
	private String chapterTitle;
	private String chapterNo;
	private String chapterVersion;
	private Date chapterCreateDate;
	private Date chapterUpdateDate;//chapterUpdateDate
	private String chapterIntroduction;
	private String chapterContent;
	private String chapterResource;
	private String courseId;
	private int hierarchy;
	private String chapterParentId;
	private int chapterStatus;

	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chapter(String id, String chapterTitle, String chapterNo,
			String chapterVersion, Date chapterCreateDate,
			Date chapterUpdateDate, String chapterIntroduction,
			String chapterContent, String chapterResource, String courseId,
			int hierarchy, String chapterParentId, int chapterStatus) {
		super();
		this.id = id;
		this.chapterTitle = chapterTitle;
		this.chapterNo = chapterNo;
		this.chapterVersion = chapterVersion;
		this.chapterCreateDate = chapterCreateDate;
		this.chapterUpdateDate = chapterUpdateDate;
		this.chapterIntroduction = chapterIntroduction;
		this.chapterContent = chapterContent;
		this.chapterResource = chapterResource;
		this.courseId = courseId;
		this.hierarchy = hierarchy;
		this.chapterParentId = chapterParentId;
		this.chapterStatus = chapterStatus;
	}

	public Date getChapterUpdateDate() {
		return chapterUpdateDate;
	}

	public void setChapterUpdateDate(Date chapterUpdateDate) {
		this.chapterUpdateDate = chapterUpdateDate;
	}

	public String getChapterNo() {
		return chapterNo;
	}

	public void setChapterNo(String chapterNo) {
		this.chapterNo = chapterNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChapterTitle() {
		return chapterTitle;
	}

	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}

	public String getChapterVersion() {
		return chapterVersion;
	}

	public void setChapterVersion(String chapterVersion) {
		this.chapterVersion = chapterVersion;
	}

	public Date getChapterCreateDate() {
		return chapterCreateDate;
	}

	public void setChapterCreateDate(Date chapterCreateDate) {
		this.chapterCreateDate = chapterCreateDate;
	}

	public String getChapterIntroduction() {
		return chapterIntroduction;
	}

	public void setChapterIntroduction(String chapterIntroduction) {
		this.chapterIntroduction = chapterIntroduction;
	}

	public String getChapterContent() {
		return chapterContent;
	}

	public void setChapterContent(String chapterContent) {
		this.chapterContent = chapterContent;
	}

	public String getChapterResource() {
		return chapterResource;
	}

	public void setChapterResource(String chapterResource) {
		this.chapterResource = chapterResource;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public int getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(int hierarchy) {
		this.hierarchy = hierarchy;
	}

	public String getChapterParentId() {
		return chapterParentId;
	}

	public void setChapterParentId(String chapterParentId) {
		this.chapterParentId = chapterParentId;
	}

	public int getChapterStatus() {
		return chapterStatus;
	}

	public void setChapterStatus(int chapterStatus) {
		this.chapterStatus = chapterStatus;
	}

}
