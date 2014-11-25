package com.tdedu.bu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.tdedu.bu.dao.CourseDao;
import com.tdedu.bu.domain.Course;

public class CourseService  {

	@Autowired
	private CourseDao courseDao;
	public List<Course> find(Map map){
		return courseDao.find(map);
	}
}
