package com.tdedu.bu.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tdedu.bu.dao.PasswordDao;
import com.tdedu.bu.domain.Password;

public class TestPassword {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	PasswordDao passwordDao=(PasswordDao) applicationContext.getBean("passwordDao");	
	@Test
	public void testInsert() throws Exception{
		Password password=new Password();
		password.setUserId("9aaba07e-9ad5-4414-9a7a-3e22ace47170");
		password.setUserName("huangyong");
		password.setPassword("abcd");
		password.setStartDate(new Date());
		password.setEndDate(new Date());
		passwordDao.insert(password);		
	}
	
	@Test
	public void testSeclect(){
		passwordDao.get("9aaba07e-9ad5-4414-9a7a-3e22ace47170");
		Password password=new Password();
		password.setUserName("huangyong");
		password.setPassword("abcd");
		passwordDao.findByPwd(password);
	}
	@Test
	public void testUpdate(){
		Password password=new Password();
		password.setUserId("9aaba07e-9ad5-4414-9a7a-3e22ace47170");
		password.setUserName("huangyongceshi");
		password.setPassword("abcdde");
		password.setStartDate(new Date());
		password.setEndDate(new Date());
		passwordDao.updatePwd(password);
	}
	@Test
	public void testDelete() throws Exception{
		passwordDao.deleteById("43511cc7-95a6-4244-b2d1-57ee7563bf24");
		String userId[]=new String[2];
		userId[0]="43511cc7-95a6-4244-b2d1-57ee7563bf24";
		userId[1]="127622ef-33b2-46df-b981-f57e4f92cd38";
		passwordDao.delete(userId);
	}
	@Test
	public void testFindByPwd(){
		Password password=new Password();
		password.setUserName("ewlohjg");
		password.setPassword("wgkje");
		passwordDao.findByPwd(password);	
	}
}
