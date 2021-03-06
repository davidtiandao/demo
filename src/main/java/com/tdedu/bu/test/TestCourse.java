package com.tdedu.bu.test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tdedu.bu.dao.CourseDao;
import com.tdedu.bu.dao.UserStudyDao;
import com.tdedu.bu.domain.Course;
import com.tdedu.bu.vo.CourseVo;
import com.tdedu.bu.vo.UserCourseVo;

public class TestCourse {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	CourseDao courseDao=(CourseDao) applicationContext.getBean("courseDao");	
	UserStudyDao userStudyDao=(UserStudyDao) applicationContext.getBean("userStudyDao");	

	@Test
	public void testInsert() throws Exception{
		Course course=new Course();
		course.setId(UUID.randomUUID().toString());
		course.setCourseTitle("雅思英语技巧");
		course.setCourseVersion("-101-");
		course.setCourseContent("wgfhjewhkj");
		course.setCourseCreateDate( new Date());
		course.setCategoryNo("a7a40380-948a-41fd-a05f-f8b32177d817");
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
		List<Course> cpurses=courseDao.find(null);
		System.out.println(cpurses.get(0).getCourseTitle().toString());
	}
	@Test
	public void testDelete() throws Exception{
		courseDao.deleteById("4253e1a6-a9d4-43b1-a5b1-aab25b205c5b");
	}
	
	@Test
	public void testspecify() throws Exception{
		
		CourseVo v= courseDao.getCourseInfo("2d9bcb24-c146-43c4-9a04-0a1c31e8ccf2");
		System.out.println("sdf");
	}
	@Test
	public void testUserCourse() throws Exception{
		
		List<UserCourseVo> userCourseVos= userStudyDao.getuserCourse("9aaba07e-9ad5-4414-9a7a-3e22ace47170");
		System.out.println("sdf");
	}
	
}
