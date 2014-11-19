package com.tdedu.bu.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tdedu.bu.dao.ManagerDao;
import com.tdedu.bu.domain.Manager;

public class TestManager {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	ManagerDao managerDao=(ManagerDao) applicationContext.getBean("managerDao");	
	@Test
	public void TestInsert(){
		Manager manager=new Manager();
		manager.setManagerId("8f7361e5-87f1-496a-8f05-7fd67f6d28c5");
		manager.setManagerRole("课程管理员");
		manager.setManagerStatus(2);
		managerDao.insert(manager);
	}
	
	@Test
	public void TestSelect(){
		managerDao.find(2);
		managerDao.get("43511cc7-95a6-4244-b2d1-57ee7563bf24");
	}
	@Test
	public void TestUpdate(){
		Manager manager=new Manager();
		manager.setManagerId("e13acfef-d0f0-44c0-97c5-943da4507ead");
		manager.setManagerRole("教师-课程管理员");
		manager.setManagerStatus(2);
		managerDao.update(manager);
	}
	@Test
	public void TestDelete(){
		managerDao.deleteById("8f7361e5-87f1-496a-8f05-7fd67f6d28c5");
	}
}
