package com.tdedu.bu.dao;

import com.tdedu.bu.domain.Course;
import com.tdedu.bu.vo.CourseVo;

public interface CourseDao extends BaseDao<Course>{
	public CourseVo getCourseInfo(String courseId);
}
