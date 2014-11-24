package com.tdedu.bu.test;


import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tdedu.bu.dao.ManagerDao;
import com.tdedu.bu.domain.Manager;

public class TestManager {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	ManagerDao managerDao=(ManagerDao) applicationContext.getBean("managerDao");	
	@Test
	public void TestInsert() throws Exception{
		Manager manager=new Manager();
		manager.setManagerId("8f7361e5-87f1-496a-8f05-7fd67f6d28c5");
		manager.setManagerRole("课程管理员");
		manager.setManagerStatus(2);
		managerDao.insert(manager);
	}
	
	@Test
	public void TestSelect(){
		managerDao.find();
		managerDao.get("43511cc7-95a6-4244-b2d1-57ee7563bf24");
	}
	@Test
	public void TestUpdate() throws Exception{
		Manager manager=new Manager();
		manager.setManagerId("e13acfef-d0f0-44c0-97c5-943da4507ead");
		manager.setManagerRole("教师-课程管理员");
		manager.setManagerStatus(2);
		managerDao.update(manager);
	}
	@Test
	public void TestDelete() throws Exception{
		managerDao.deleteById("8f7361e5-87f1-496a-8f05-7fd67f6d28c5");
	}
	@Test
	public void TestDeleteArray() throws Exception{
		String[] ids={"07e8b9f7-e21c-4d7a-ba70-8910bb54ffa2","0f25102d-dcc0-4a5c-b055-79fc8dfff7af"};
		managerDao.delete(ids);
	}	
	@Test
	public void TestSetManager(){
		String[] ids={"07e8b9f7-e21c-4d7a-ba70-8910bb54ffa2","05e75212-0741-4fcc-8788-bdf56166eb40"};
		Map<String,Object> mapManagerStatus=new HashMap<String,Object>();
		mapManagerStatus.put("ids", ids);
		mapManagerStatus.put("managerStatus", 2);
		managerDao.updateStatus(mapManagerStatus);
	}
}
