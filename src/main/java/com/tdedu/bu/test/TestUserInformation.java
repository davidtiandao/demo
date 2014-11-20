package com.tdedu.bu.test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tdedu.bu.dao.UserInformationDao;
import com.tdedu.bu.domain.UserInformation;
import com.tdedu.bu.service.UserInformationService;

public class TestUserInformation {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	UserInformationService	userInformationService=(UserInformationService) applicationContext.getBean("userService");
	UserInformationDao ud=(UserInformationDao) applicationContext.getBean("userInformationDao");
	@Test
	public void testInsert() throws Exception{
		UserInformation newUser=new UserInformation();
		newUser.setFullName("test2");
		newUser.setGender("m");
		newUser.setUserStatus(50);
		newUser.setId(UUID.randomUUID().toString());
		newUser.setUserStatus(1);		
		userInformationService.save(newUser);
		
	}
	@Test
	public void userStatus(){
		UserInformation newUser=new UserInformation();
		newUser.setFullName("test3");
		newUser.setGender("m");
		newUser.setUserStatus(50);
		newUser.setId("43511cc7-95a6-4244-b2d1-57ee7563bf24");
		newUser.setUserStatus(1);		
		ud.update(newUser);
	}
	
	

}
