package com.tdedu.bu.test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tdedu.bu.dao.CourseDao;
import com.tdedu.bu.domain.Course;

public class TestCourse {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	CourseDao courseDao=(CourseDao) applicationContext.getBean("courseDao");	

	@Test
	public void testInsert() throws Exception{
		Course course=new Course();
		course.setId(UUID.randomUUID().toString());
		course.setCourseTitle("雅思英语技巧");
		course.setCourseVersion("-101-");
		course.setCourseContent("wgfhjewhkj");
		course.setCourseCreateDate( new Date());
		course.setCategoryNo("4226b44e-c785-486b-9b45-8d7af3d6b7c1");
		course.setCourseStatus(2);
		courseDao.insert(course);
	}
	@Test
	public void testUpadte() throws Exception{
		Course course=new Course();
		course.setId(UUID.randomUUID().toString());
		course.setCourseTitle("雅思英语技巧和写作");
		course.setCourseVersion("-101-");
		course.setCourseContent("wgfhjewhkj");
		course.setCourseCreateDate( new Date());
		course.setCategoryNo("4226b44e-c785-486b-9b45-8d7af3d6b7c1");
		course.setCourseStatus(2);
		courseDao.update(course);
	}
	@Test
	public void testSelect(){
		List<Course> cpurses=courseDao.find(2);
		System.out.println(cpurses.get(0).getCourseTitle().toString());
	}
	@Test
	public void testDelete() throws Exception{
		courseDao.deleteById("4253e1a6-a9d4-43b1-a5b1-aab25b205c5b");
	}
}
