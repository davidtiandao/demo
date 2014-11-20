package com.tdedu.bu.domain;

public class VideoType {
	/*
	 * 视频属性表
	 */
	private String id;
	private int videoHigh;
	private int videoWide;
	private Long videoLength;
	
	
	
	public VideoType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VideoType(String id, int videoHigh, int videoWide, Long videoLength) {
		super();
		this.id = id;
		this.videoHigh = videoHigh;
		this.videoWide = videoWide;
		this.videoLength = videoLength;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getVideoHigh() {
		return videoHigh;
	}
	public void setVideoHigh(int videoHigh) {
		this.videoHigh = videoHigh;
	}
	public int getVideoWide() {
		return videoWide;
	}
	public void setVideoWide(int videoWide) {
		this.videoWide = videoWide;
	}
	public Long getVideoLength() {
		return videoLength;
	}
	public void setVideoLength(Long videoLength) {
		this.videoLength = videoLength;
	}
	
	
}
