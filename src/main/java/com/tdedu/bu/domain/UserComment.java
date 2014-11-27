package com.tdedu.bu.domain;

public class UserComment {
	/*
	 * 用户评论表
	 */
	private String id;
	private String userId;
	private String sectionId;
	private String comment;
	private String commentDate;
	private int commentStatus;
	private String parentId;
	private String username;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserComment(String id, String userId, String sectionId,
			String comment, String commentDate, int commentStatus,
			String parentId) {
		super();
		this.id = id;
		this.userId = userId;
		this.sectionId = sectionId;
		this.comment = comment;
		this.commentDate = commentDate;
		this.commentStatus = commentStatus;
		this.parentId = parentId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSectionId() {
		return sectionId;
	}
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public int getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(int commentStatus) {
		this.commentStatus = commentStatus;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	
}
