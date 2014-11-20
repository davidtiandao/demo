package com.tdedu.bu.test;

import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tdedu.bu.dao.VideoDao;
import com.tdedu.bu.domain.Video;

public class testVideo {
	ApplicationContext application=new ClassPathXmlApplicationContext("applicationContext.xml");
	VideoDao videoDao=(VideoDao) application.getBean("videoDao");
	
	@Test
	public void testInsert() throws Exception{
		Video video=new Video();
		video.setId(UUID.randomUUID().toString());
		video.setSectionId("25b1f374-2ff0-42b9-ade9-1ffb50a0ad30");
		video.setVideoFileTypeId("esgwrnekjgnkj");
		video.setVideoLx("gregr");
		video.setVideoName("wegjhewjkh");
		video.setVideoTypeId("ewgn lwken");
		videoDao.insert(video);
	}
	@Test
	public void testUpdate(){
		Video video=new Video();
		video.setId(UUID.randomUUID().toString());
		video.setSectionId("25b1f374-2ff0-42b9-ade9-1ffb50a0ad30");
		video.setVideoFileTypeId("esgwrnekjgnkj");
		video.setVideoLx("gregr");
		video.setVideoName("额jo今晚喝酒.mp4");
		video.setVideoTypeId("ewgn lwken");
		videoDao.update(video);
	}
	@Test
	public void testSelect(){
		videoDao.get("b9650714-fa5d-4080-81fb-1accacb0b4ea");
		System.out.println(videoDao.findBySection("25b1f374-2ff0-42b9-ade9-1ffb50a0ad30").getVideoName());
	}
	@Test
	public void testDelete(){
		videoDao.deleteById("924cd230-d05a-4302-8524-cfea606c48a8");
	}
	
}
