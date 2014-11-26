package com.tdedu.bu.test;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tdedu.bu.dao.UserAttentionDao;
import com.tdedu.bu.domain.UserAttention;


public class TestUserAttention {
	ApplicationContext apx=new ClassPathXmlApplicationContext("applicationContext.xml");
	UserAttentionDao userAttentionDao=(UserAttentionDao) apx.getBean("userAttentionDao");
	@Test
	public void testInset() throws Exception{
		UserAttention userAttention=new UserAttention();
		userAttention.setId(UUID.randomUUID().toString());
		userAttention.setCourseId("2d9bcb24-c146-43c4-9a04-0a1c31e8ccf2");
		userAttention.setShootingAttentionStatus(1);
		userAttention.setShootingDate(new Date());
		userAttention.setShootingId("2e809521-8639-42a5-8127-27c3e8ea8127");
		userAttention.setUserId("9aaba07e-9ad5-4414-9a7a-3e22ace47170");
		userAttentionDao.insert(userAttention);
	}
	@Test
	public void testUpdate() throws Exception{
		UserAttention userAttention=new UserAttention();
		userAttention.setId("25ed6f55-fd98-4b4e-80be-1b7acd109e7d");
		userAttention.setCourseId("2d9bcb24-c146-43c4-9a04-0a1c31e8ccf2");
		userAttention.setShootingAttentionStatus(2);
		userAttention.setShootingDate(new Date());
		userAttention.setShootingId("2e809521-8639-42a5-8127-27c3e8ea8127");
		userAttention.setUserId("9aaba07e-9ad5-4414-9a7a-3e22ace47170");
		userAttentionDao.update(userAttention);
	}
	@Test
	public void testDelete() throws Exception{
		userAttentionDao.deleteById("25ed6f55-fd98-4b4e-80be-1b7acd109e7d");
	}
}
