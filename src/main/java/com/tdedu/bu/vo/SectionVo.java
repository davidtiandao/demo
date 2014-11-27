package com.tdedu.bu.vo;

import java.util.Date;
import java.util.List;

import com.tdedu.bu.domain.Video;

public class SectionVo {
private List<Video> videos;
private String id;
private String sectionName;
private String sectionVersion;
private Date sectionCreateDate;
private Date sectionUpdateDate;
private String sectionTypeId;
private int sectionStatus;
private String teacherId;
public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getSectionName() {
	return sectionName;
}

public void setSectionName(String sectionName) {
	this.sectionName = sectionName;
}

public String getSectionVersion() {
	return sectionVersion;
}

public void setSectionVersion(String sectionVersion) {
	this.sectionVersion = sectionVersion;
}

public Date getSectionCreateDate() {
	return sectionCreateDate;
}

public void setSectionCreateDate(Date sectionCreateDate) {
	this.sectionCreateDate = sectionCreateDate;
}

public Date getSectionUpdateDate() {
	return sectionUpdateDate;
}

public void setSectionUpdateDate(Date sectionUpdateDate) {
	this.sectionUpdateDate = sectionUpdateDate;
}

public String getSectionTypeId() {
	return sectionTypeId;
}

public void setSectionTypeId(String sectionTypeId) {
	this.sectionTypeId = sectionTypeId;
}

public int getSectionStatus() {
	return sectionStatus;
}

public void setSectionStatus(int sectionStatus) {
	this.sectionStatus = sectionStatus;
}

public String getTeacherId() {
	return teacherId;
}

public void setTeacherId(String teacherId) {
	this.teacherId = teacherId;
}

public List<Video> getVideos() {
	return videos;
}

public void setVideos(List<Video> videos) {
	this.videos = videos;
}

}
