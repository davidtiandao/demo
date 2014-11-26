package com.tdedu.bu.test;

import java.util.Date;
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
		newUser.setPhone("ergjnrejk");
		newUser.setCreateDate(new Date());
		newUser.setId(UUID.randomUUID().toString());
		newUser.setUserStatus(1);		
		userInformationService.save(newUser);
		
	}
	@Test
	public void userStatus() throws Exception{
		UserInformation newUser=new UserInformation();
		newUser.setFullName("test3");
		newUser.setGender("m");
		newUser.setUserStatus(50);
		newUser.setId("693b6016-0891-4a55-92d3-8ce0e4e7a99b");
		newUser.setUserStatus(1);		
		ud.update(newUser);
	}
	@Test
	public void testDelete() throws Exception{
		String[] arrayids={"693b6016-0891-4a55-92d3-8ce0e4e7a99b"};
		ud.delete(arrayids);
	}
	

}
