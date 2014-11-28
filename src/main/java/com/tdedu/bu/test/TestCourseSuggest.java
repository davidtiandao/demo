package com.tdedu.bu.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tdedu.bu.dao.CourseSuggestDao;
import com.tdedu.bu.domain.CourseSuggest;

public class TestCourseSuggest {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	CourseSuggestDao courseSuggestDao=(CourseSuggestDao) applicationContext.getBean("courseSuggestDao");
	@Test
	public void testInsert() throws Exception{
		CourseSuggest suggest=new CourseSuggest();
		suggest.setCourseSuggestId(UUID.randomUUID().toString());
		suggest.setCreateDate(new Date());
		suggest.setUserId("9aaba07e-9ad5-4414-9a7a-3e22ace47170");
		suggest.setUserName("李玉梅");
		suggest.setCourseSuggest("ba了。。。");
		courseSuggestDao.insert(suggest);
	}
	@Test
	public void testSelect(){
		List<CourseSuggest> listSuggest=courseSuggestDao.find(null);
		Iterator<CourseSuggest> it=listSuggest.iterator();
		while(it.hasNext()){
			CourseSuggest suggest=it.next();
			System.out.println(suggest.getCourseSuggest());
		}
	}
	@Test
	public void testDelete(){
		String[] courseSuggestIds={"6c8ace22-dc63-4fd1-b4c6-febff8388f48","707e6830-49e0-43ff-a278-8eb45670893c"};
		try {
			courseSuggestDao.delete(courseSuggestIds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
