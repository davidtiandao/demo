package com.tdedu.bu.domain;

public class VideoFileType {
	/*
	 * 
	 */
	private String id;
	private String videoFileType;
	
	
	
	public VideoFileType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VideoFileType(String id, String videoFileType) {
		super();
		this.id = id;
		this.videoFileType = videoFileType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVideoFileType() {
		return videoFileType;
	}
	public void setVideoFileType(String videoFileType) {
		this.videoFileType = videoFileType;
	}
	
	
}
