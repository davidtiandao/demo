package com.tdedu.bu.vo;

import java.util.List;

import com.tdedu.bu.domain.Course;

public class UserCourseVo {
	
	private List<Course> courses;
	private String id;
	private String fullName;
	private int sectionNUm;
	private int finishedNum;
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public int getSectionNUm() {
		return sectionNUm;
	}
	public void setSectionNUm(int sectionNUm) {
		this.sectionNUm = sectionNUm;
	}
	public int getFinishedNum() {
		return finishedNum;
	}
	public void setFinishedNum(int finishedNum) {
		this.finishedNum = finishedNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	

}
