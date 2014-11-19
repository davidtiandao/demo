package com.tdedu.bu.domain;

public class SectionType {
	/*
	 * 课件类型
	 */
	private String id;
	private String sectionIntroduction;
	private String sectionTypeId;
	
	
	
	public SectionType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SectionType(String id, String sectionIntroduction,
			String sectionTypeId) {
		super();
		this.id = id;
		this.sectionIntroduction = sectionIntroduction;
		this.sectionTypeId = sectionTypeId;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSectionIntroduction() {
		return sectionIntroduction;
	}
	public void setSectionIntroduction(String sectionIntroduction) {
		this.sectionIntroduction = sectionIntroduction;
	}
	public String getSectionTypeId() {
		return sectionTypeId;
	}
	public void setSectionTypeId(String sectionTypeId) {
		this.sectionTypeId = sectionTypeId;
	}
	
}
