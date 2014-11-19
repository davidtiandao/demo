package com.tdedu.bu.domain;

public class Video {
	/*
	 * 可见视频表
	 */
	private String id;
	private String sectionId;
	private String videoName;
	private String videoLx;
	private String videoTypeId;
	private String videoFileTypeId;
	
	
	
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Video(String id, String sectionId, String videoName, String videoLx,
			String videoTypeId, String videoFileTypeId) {
		super();
		this.id = id;
		this.sectionId = sectionId;
		this.videoName = videoName;
		this.videoLx = videoLx;
		this.videoTypeId = videoTypeId;
		this.videoFileTypeId = videoFileTypeId;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSectionId() {
		return sectionId;
	}
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoLx() {
		return videoLx;
	}
	public void setVideoLx(String videoLx) {
		this.videoLx = videoLx;
	}
	public String getVideoTypeId() {
		return videoTypeId;
	}
	public void setVideoTypeId(String videoTypeId) {
		this.videoTypeId = videoTypeId;
	}
	public String getVideoFileTypeId() {
		return videoFileTypeId;
	}
	public void setVideoFileTypeId(String videoFileTypeId) {
		this.videoFileTypeId = videoFileTypeId;
	}
	
	
	
}
