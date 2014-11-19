package com.tdedu.bu.test;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tdedu.bu.dao.ShootingDao;
import com.tdedu.bu.domain.Shooting;

public class TestShooting {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	ShootingDao shootingDao=(ShootingDao) applicationContext.getBean("shootingDao");
	@Test
	public void testInsert(){
		Shooting shooting=new Shooting();
		shooting.setId(UUID.randomUUID().toString());
		shooting.setOnlineDate(new Date());
		shooting.setCategoryId("311dca53-1403-42cc-8308-db537ab62485");
		shooting.setLookNumber(32);
		shooting.setCategoryId("4226b44e-c785-486b-9b45-8d7af3d6b7c1");
		shooting.setPhotoUrl("lkewlkewn");
		shooting.setShootingCourseId("3f0fed46-1c79-4580-abe4-47e07f7fa28c");
		shooting.setTeacherId("127622ef-33b2-46df-b981-f57e4f92cd38");
		shootingDao.insert(shooting);
	}
	@Test
	public void testSelect(){
		shootingDao.get("7310638f-5ebf-4b8d-afe2-abdf11ac7500");
	}
	@Test
	public void testUpdate(){
		Shooting shooting=new Shooting();
		shooting.setId("7310638f-5ebf-4b8d-afe2-abdf11ac7500");
		shooting.setOnlineDate(new Date());
		shooting.setCategoryId("311dca53-1403-42cc-8308-db537ab62485");
		shooting.setLookNumber(88);
		shooting.setCategoryId("4226b44e-c785-486b-9b45-8d7af3d6b7c1");
		shooting.setPhotoUrl("D://我回家。png");
		shooting.setShootingCourseId("3f0fed46-1c79-4580-abe4-47e07f7fa28c");
		shooting.setTeacherId("127622ef-33b2-46df-b981-f57e4f92cd38");
		shootingDao.update(shooting);
	}
	@Test
	public void testDelete(){
		shootingDao.deleteById("7310638f-5ebf-4b8d-afe2-abdf11ac7500");
	}
	
}