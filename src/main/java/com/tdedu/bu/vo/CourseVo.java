package com.tdedu.bu.vo;

import java.util.List;

import com.tdedu.bu.domain.Chapter;

public class CourseVo {
private List<Chapter> chapters;
private int sectionNum; 
private int commentsNum;
private int attentionsNum;
public int getAttentionsNum() {
	return attentionsNum;
}
public void setAttentionsNum(int attentionsNum) {
	this.attentionsNum = attentionsNum;
}
public List<Chapter> getChapters() {
	return chapters;
}
public void setChapters(List<Chapter> chapters) {
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
