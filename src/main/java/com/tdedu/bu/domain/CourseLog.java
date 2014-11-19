package com.tdedu.bu.domain;

import java.util.Date;

public class CourseLog {
	/*
	 * `COURSE_ID` varchar(40) NOT NULL COMMENT '课程编号',
  `COURSE_COMMENT` varchar(200) NOT NULL COMMENT '变更内容',
  `COURSE_DATE` date NOT NULL COMMENT '变更时间 ',
	 */
	private String id;
	private String courseId;
	private String courseComment;
	private Date courseUpdateDate;
	
	
	
	public CourseLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CourseLog(String id, String courseId, String courseComment,
			Date courseUpdateDate) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.courseComment = courseComment;
		this.courseUpdateDate = courseUpdateDate;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseComment() {
		return courseComment;
	}
	public void setCourseComment(String courseComment) {
		this.courseComment = courseComment;
	}
	public Date getCourseUpdateDate() {
		return courseUpdateDate;
	}
	public void setCourseUpdateDate(Date courseUpdateDate) {
		this.courseUpdateDate = courseUpdateDate;
	}
	
	
	
}
