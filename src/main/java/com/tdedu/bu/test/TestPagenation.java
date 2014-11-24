package com.tdedu.bu.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tdedu.bu.dao.UserInformationDao;
import com.tdedu.bu.domain.UserInformation;
import com.tdedu.bu.service.UserInformationService;
import com.tdedu.bu.web.Page;

public class TestPagenation {

	@Test
	public void test(){
		ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
		Page page=Page.newBuilder(2, 10, "userInformation");
		page.getParams().put("gender", "女");
		UserInformationDao userInformationDao=(UserInformationDao) app.getBean("userInformationDao");
		UserInformationService service=new UserInformationService();
		service.setUserInformationDao(userInformationDao);
		List<UserInformation> list= service.listUser(page);
		System.out.println(list.size());
	}
}
