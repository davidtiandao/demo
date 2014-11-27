package com.tdedu.bu.vo;

import java.util.Date;
import java.util.List;

import com.tdedu.bu.domain.Chapter;
import com.tdedu.bu.domain.Course;
import com.tdedu.bu.domain.UserComment;

public class CourseVo {

private List<ChapterVo> chapters;
private List<UserComment> usercomments;
private int sectionNum; 
private int commentsNum;
private int attentionsNum;


public List<UserComment> getUsercomments() {
	return usercomments;
}
public void setUsercomments(List<UserComment> usercomments) {
	this.usercomments = usercomments;
}
private String id;
private String courseTitle;
private String courseNo;
private String courseVersion;
private Date courseCreateDate;
private String courseContent;
private String courseResource;;
private String courseIntroduction;
private Date courseUpdateDate;
private int seeNumber;
private int courseStatus;
private String categoryNo;

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getCourseTitle() {
	return courseTitle;
}
public void setCourseTitle(String courseTitle) {
	this.courseTitle = courseTitle;
}
public String getCourseNo() {
	return courseNo;
}
public void setCourseNo(String courseNo) {
	this.courseNo = courseNo;
}
public String getCourseVersion() {
	return courseVersion;
}
public void setCourseVersion(String courseVersion) {
	this.courseVersion = courseVersion;
}
public Date getCourseCreateDate() {
	return courseCreateDate;
}
public void setCourseCreateDate(Date courseCreateDate) {
	this.courseCreateDate = courseCreateDate;
}
public String getCourseContent() {
	return courseContent;
}
public void setCourseContent(String courseContent) {
	this.courseContent = courseContent;
}
public String getCourseResource() {
	return courseResource;
}
public void setCourseResource(String courseResource) {
	this.courseResource = courseResource;
}
public String getCourseIntroduction() {
	return courseIntroduction;
}
public void setCourseIntroduction(String courseIntroduction) {
	this.courseIntroduction = courseIntroduction;
}
public Date getCourseUpdateDate() {
	return courseUpdateDate;
}
public void setCourseUpdateDate(Date courseUpdateDate) {
	this.courseUpdateDate = courseUpdateDate;
}
public int getSeeNumber() {
	return seeNumber;
}
public void setSeeNumber(int seeNumber) {
	this.seeNumber = seeNumber;
}
public int getCourseStatus() {
	return courseStatus;
}
public void setCourseStatus(int courseStatus) {
	this.courseStatus = courseStatus;
}
public String getCategoryNo() {
	return categoryNo;
}
public void setCategoryNo(String categoryNo) {
	this.categoryNo = categoryNo;
}
public int getAttentionsNum() {
	return attentionsNum;
}
public void setAttentionsNum(int attentionsNum) {
	this.attentionsNum = attentionsNum;
}

public List<ChapterVo> getChapters() {
	return chapters;
}
public void setChapters(List<ChapterVo> chapters) {
	this.chapters = chapters;
}
public int getSectionNum() {
	return sectionNum;
}
public void setSectionNum(int sectionNum) {
	this.sectionNum = sectionNum;
}
public int getCommentsNum() {
	return commentsNum;
}
public void setCommentsNum(int commentsNum) {
	this.commentsNum = commentsNum;
}

}
