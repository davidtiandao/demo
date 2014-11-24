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
		userAttention.setCourseId("3f0fed46-1c79-4580-abe4-47e07f7fa28c");
		userAttention.setShootingAttentionStatus(1);
		userAttention.setShootingDate(new Date());
		userAttention.setShootingId("e7f147fb-9757-4d3f-a4d8-49e205161e8d");
		userAttention.setUserId("43511cc7-95a6-4244-b2d1-57ee7563bf24");
		userAttentionDao.insert(userAttention);
	}
	@Test
	public void testUpdate() throws Exception{
		UserAttention userAttention=new UserAttention();
		userAttention.setId("25ed6f55-fd98-4b4e-80be-1b7acd109e7d");
		userAttention.setCourseId("3f0fed46-1c79-4580-abe4-47e07f7fa28c");
		userAttention.setShootingAttentionStatus(2);
		userAttention.setShootingDate(new Date());
		userAttention.setShootingId("e7f147fb-9757-4d3f-a4d8-49e205161e8d");
		userAttention.setUserId("43511cc7-95a6-4244-b2d1-57ee7563bf24");
		userAttentionDao.update(userAttention);
	}
	@Test
	public void testDelete() throws Exception{
		userAttentionDao.deleteById("25ed6f55-fd98-4b4e-80be-1b7acd109e7d");
	}
}
