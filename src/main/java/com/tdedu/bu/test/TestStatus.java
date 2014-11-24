package com.tdedu.bu.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tdedu.bu.dao.StatusDao;
import com.tdedu.bu.domain.Status;

public class TestStatus {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	StatusDao	statusDao=(StatusDao) applicationContext.getBean("statusDao");
	@Test
	public void insert() throws Exception{
		Status status=new Status();
		status.setStatusNo(4);
		status.setStatusName("帐号过期");
		statusDao.insert(status);
	}
	@Test
	public void updateStatus() throws Exception{
		Status status=new Status();
		status.setStatusNo(4);
		status.setStatusName("帐号过期11");
		statusDao.update(status);
	}
	@Test
	public void select(){
		List<Status> statuss=statusDao.find(null);
		System.out.println(statuss.get(0).getStatusName());
	}
	@Test
	public void delete(){
		statusDao.deleteByStatusNo(4);
	}
}
