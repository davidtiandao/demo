package com.tdedu.bu.dao;

import com.tdedu.bu.domain.UserStudy;
import com.tdedu.bu.vo.UserCourseVo;

public interface UserStudyDao extends BaseDao<UserStudy> {

	public UserCourseVo getuserCourse(String uid);

	public void selectCourse(String courseId);
	
}
