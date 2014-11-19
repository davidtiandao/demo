package com.tdedu.bu.domain;

public class TeacherInformation {
	/*
	 * 教师信息表
	 */
	
	private String teacherId;
	private String teacherIntroduction;
	private String teacherDirection;
	
	
	public TeacherInformation() {
		super();
	}
	
	public TeacherInformation(String teacherId, String teacherIntroduction,
			String teacherDirection) {
		super();
		this.teacherId = teacherId;
		this.teacherIntroduction = teacherIntroduction;
		this.teacherDirection = teacherDirection;
	}

	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherIntroduction() {
		return teacherIntroduction;
	}
	public void setTeacherIntroduction(String teacherIntroduction) {
		this.teacherIntroduction = teacherIntroduction;
	}
	public String getTeacherDirection() {
		return teacherDirection;
	}
	public void setTeacherDirection(String teacherDirection) {
		this.teacherDirection = teacherDirection;
	}
	
	
}
