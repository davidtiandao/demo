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
	public void testInsert() throws Exception{
		Shooting shooting=new Shooting();
		shooting.setId(UUID.randomUUID().toString());
		shooting.setOnlineDate(new Date());
		shooting.setCategoryId("6a541641-f3fb-427a-8897-c67c448026f1");
		shooting.setLookNumber(32);
		shooting.setPhotoUrl("lkewlkewn");
		shooting.setShootingCourseId("2d9bcb24-c146-43c4-9a04-0a1c31e8ccf2");
		shooting.setTeacherId("9aaba07e-9ad5-4414-9a7a-3e22ace47170");
		shootingDao.insert(shooting);
	}
	@Test
	public void testSelect(){
		shootingDao.get("2e809521-8639-42a5-8127-27c3e8ea8127");
	}
	@Test
	public void testUpdate() throws Exception{
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
	public void testDelete() throws Exception{
		shootingDao.deleteById("7310638f-5ebf-4b8d-afe2-abdf11ac7500");
	}
	
}