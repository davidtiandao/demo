package com.tdedu.bu.domain;

import java.util.Date;
 /*
  * 用户信息表 
  */

public class UserInformation {
	private String id;
	private String fullName;
	private String gender;
	private Date birthday;
	private String hometown;
	private String livePlace;
	private String phone;
	private String telphone;
	private String email;
	private String qq;
	private String weixin;
	private String otherContent;
	private String cardType;
	private String cardNo;
	private String nationality;
	private String politicalAddiliation;
	private String photo;
	private int userStatus;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInformation(String id, String fullName, String gender,
			Date birthday, String hometown, String livePlace, String phone,
			String telphone, String email, String qq, String weixin,
			String otherContent, String cardType, String cardNo,
			String nationality, String politicalAddiliation, String photo,
			int userStatus) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.birthday = birthday;
		this.hometown = hometown;
		this.livePlace = livePlace;
		this.phone = phone;
		this.telphone = telphone;
		this.email = email;
		this.qq = qq;
		this.weixin = weixin;
		this.otherContent = otherContent;
		this.cardType = cardType;
		this.cardNo = cardNo;
		this.nationality = nationality;
		this.politicalAddiliation = politicalAddiliation;
		this.photo = photo;
		this.userStatus = userStatus;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getLivePlace() {
		return livePlace;
	}
	public void setLivePlace(String livePlace) {
		this.livePlace = livePlace;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getOtherContent() {
		return otherContent;
	}
	public void setOtherContent(String otherContent) {
		this.otherContent = otherContent;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPoliticalAddiliation() {
		return politicalAddiliation;
	}
	public void setPoliticalAddiliation(String politicalAddiliation) {
		this.politicalAddiliation = politicalAddiliation;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	
	
	
}
